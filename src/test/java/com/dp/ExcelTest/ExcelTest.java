package com.dp.ExcelTest;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.ListUtils;
import com.dp.common.CharConverter;
import com.dp.common.ExcelDAO;
import com.dp.common.ExcelData;
import com.dp.common.ExcelDataListener;
import com.dp.entity.OrderTable;
import com.dp.mapper.OrderTableMapper;
import com.dp.service.OrderDetailsService;
import com.dp.service.OrderTableService;
import com.dp.service.impl.OrderDetailsServiceImpl;
import com.dp.service.impl.OrderTableServiceImpl;
import com.dp.util.MybatisPlusUtil;
import com.dp.web.controller.BaseController;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class ExcelTest extends BaseController {

    String PATH = "F:\\CHEN\\YC\\二阶段\\二阶段项目-数码电商平台\\DigitalPlatform";

    @Autowired
    private OrderTableService service = new OrderTableServiceImpl();

    @Autowired
    private OrderDetailsService serviceDetails = new OrderDetailsServiceImpl();

    private void doFinds(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        OrderTable order = parseRequest(req,OrderTable.class);

        int uId = Integer.parseInt(req.getParameter("uId"));
        order.setUId(2);

        printToJson(resp,service.finds(order));
    }


    private List<OrderTable> orderTableData() {
        OrderTable order = new OrderTable();
        order.setUId(2);
//        List<OrderTable> list = service.finds(order);
//        for (int i = 0; i < 10; i++) {
//
//            OrderTable data = new OrderTable();
//
//            list.add(data);
//        }
        return service.getOrderTable(order);
    }

//    private List<OrderTable> data(List<OrderTable> orderTables) {
//        List<OrderTable> list = ListUtils.newArrayList();
//        for (OrderTable orderTable : orderTables) {
//            OrderTable o = new OrderTable();
//            o = orderTable;
//            list.add(o);
//        }
//        return list;
//    }

    @Test
    public void orderTableWrite() throws IOException {
//        HttpServletResponse response = new HttpServletResponse ;
//        String origin = System.currentTimeMillis() + ".xlsx";
//        String fileName = new String(origin.getBytes(), StandardCharsets.ISO_8859_1);
//        response.setContentType("application/msexcel");
//        response.setCharacterEncoding("utf8");
//        response.setHeader("Content-disposition", "attachment;filename=" + fileName );
//
//        List<OrderTable> orderTables = service.getOrderTable(new OrderTable());
//
//        List<OrderTable> data = data(orderTables);
//        // EasyExcel.write(fileName, OrderTable.class).sheet("模板").doWrite(data);
//        EasyExcel.write(response.getOutputStream(), OrderTable.class)
//                .sheet("sheet")
//                .doWrite(data);
        // 注意 simpleWrite在数据量不大的情况下可以使用（5000以内，具体也要看实际情况），数据量大参照 重复多次写入

        // 写法2
        String fileName = "ExcelTable5.xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, OrderTable.class).registerConverter(new CharConverter()).sheet("模板").doWrite(orderTableData());

    }












    @Test
    public void simpleTableWrite() throws IOException {


        // 写法2
        String fileName = "ExcelTable5.xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可 .registerConverter(new CharConverter())
        EasyExcel.write(fileName, OrderTable.class).sheet("模板").doWrite(data());

    }


    private List<OrderTable> data() {
        List<OrderTable> list = ListUtils.newArrayList();
        for (int i = 0; i < 10; i++) {

//            SqlSession session = MybatisPlusUtil.getSession();
//            orderTableMapper = session.getMapper(OrderTableMapper.class);
//            List<Map<String,Object>> list = orderTableMapper.selectList(order);

            OrderTable data = new OrderTable();
//            data.setString("字符串" + i);
//            data.setDate(new Date());
//            data.setDoubleData(0.56);
            list.add(data);
        }
        OrderTable orderTable = new OrderTable();
        return service.getOrderTable(orderTable);
        //return list;
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
        String fileName = "ExcelTest2.xlsx";
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
