package jsu.com.servlet;

import jsu.com.bean.Orders;
import jsu.com.dao.OrdersDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/AddOrdersServlet")
public class AddOrdersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置post提交时候，参数解码方式
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

//        private Integer orderId;
//        private String orderType;
//        private String trade;
//        private String orderGoodsId;
//        private Integer orderCount;

        // 从前台获取订单的各基本信息
        String orderType = request.getParameter("order_type");
        String trade = request.getParameter("trader");
        String orderGoodsId = request.getParameter("order_goods_id");
        String orderCount = request.getParameter("order_count");

        Integer count=Integer.valueOf(orderCount);
        //封装成一个对象
        Orders orders=new Orders(null,orderType,trade,orderGoodsId,count);

        OrdersDAO ordersDAO=new OrdersDAO();
        boolean flag=ordersDAO.saveOrders(orders);
        if(flag){
            //添加成功
            //请求转发
            request.getRequestDispatcher("/OrderServlet").forward(request,response);
        }else{
            // 通过response对象给客户端一个错误提示
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('添加失败');");
            writer.write("window.location.href = '/OrderServlet'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
