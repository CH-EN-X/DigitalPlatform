package com.dp.common;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.ListUtils;
import com.dp.entity.OrderTable;
import com.dp.service.OrderTableService;
import com.dp.service.impl.OrderTableServiceImpl;
import com.dp.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;


@WebServlet("/excelWrite")
public class ExcelController extends BaseController {

    @Autowired
    private OrderTableService service = new OrderTableServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
//        resp.setContentType("application/json");

        String op = req.getParameter("op");
        if("getExcel".equals(op)){
            simpleWrite(req,resp);
        } else{
            printToJson(resp,"NO method ......");
        }
    }


    public void simpleWrite(HttpServletRequest request,
                            HttpServletResponse response) throws IOException {

        String origin = System.currentTimeMillis() + ".xlsx";
        String fileName = new String(origin.getBytes(), StandardCharsets.ISO_8859_1);
        response.setContentType("application/msexcel");
        response.setCharacterEncoding("utf8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName );

        List<OrderTable> orderTables = service.getOrderTable(new OrderTable());

        List<OrderTable> data = data(orderTables);
//        log("{}", (Throwable) data);
        // EasyExcel.write(fileName, OrderTable.class).sheet("模板").doWrite(data);
        EasyExcel.write(response.getOutputStream(), OrderTable.class)
//                .registerConverter(new CharConverter())
                .sheet("sheet")
                .doWrite(data);
        // 刷新和关闭输出流
//        response.getOutputStream().flush();
//        response.getOutputStream().close();
    }

    private List<OrderTable> data(List<OrderTable> orderTables) {
        List<OrderTable> list = ListUtils.newArrayList();
        for (OrderTable orderTable : orderTables) {
            OrderTable o = new OrderTable();
            o = orderTable;
            list.add(o);
        }
        return list;
    }
}