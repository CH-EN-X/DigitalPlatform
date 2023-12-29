package com.dp.ExcelTest;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.ListUtils;
import com.dp.common.ExcelDAO;
import com.dp.common.ExcelData;
import com.dp.common.ExcelDataListener;
import org.junit.Test;

import java.io.File;
import java.util.Date;
import java.util.List;

public class ExcelTest {

    String PATH = "F:\\CHEN\\YC\\二阶段\\二阶段项目-数码电商平台\\DigitalPlatform";

    private List<ExcelData> data() {
        List<ExcelData> list = ListUtils.newArrayList();
        for (int i = 0; i < 10; i++) {
            ExcelData data = new ExcelData();
            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }

    /**
     * 最简单的写
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link ExcelData}
     * <p>
     * 2. 直接写即可
     */
    @Test
    public void simpleWrite() {
        // 注意 simpleWrite在数据量不大的情况下可以使用（5000以内，具体也要看实际情况），数据量大参照 重复多次写入

        // 写法2
        String fileName = "ExcelTest.xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, ExcelData.class).sheet("模板").doWrite(data());

    }



    /**
     * 最简单的读
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link ExcelData}
     * <p>
     * 2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link ExcelDataListener}
     * <p>
     * 3. 直接读即可
     */
    @Test
    public void simpleRead() {

        String fileName = "ExcelTest.xlsx";
        // 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去

        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, ExcelData.class, new ExcelDataListener()).sheet().doRead();

    }

}
