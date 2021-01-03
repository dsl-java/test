package jsu.com.servlet;

import jsu.com.bean.Orders;
import jsu.com.bean.Provider;
import jsu.com.dao.OrdersDAO;
import jsu.com.dao.ProviderDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/LookupOrdersServlet")
public class LookupOrdersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置post提交时候，参数解码方式
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 从前台获取订单ID
        String orderId = request.getParameter("search");

        if(orderId.equals("")){
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('请输入订单号,不能为空');");
            writer.write("window.location.href = '/stock/OrderServlet'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }
        //将字符串转为Integer
        Integer id=Integer.valueOf(orderId);

        OrdersDAO ordersDAO=new OrdersDAO();
        List<Orders> ordersList=ordersDAO.getOrdersLsit(id);

        if(ordersList.size()!=0){
            //查找成功
            //放入请求作用域，显示订单信息
            request.setAttribute("ordersList",ordersList);
            //请求转发
            request.getRequestDispatcher("ordersManage.jsp").forward(request,response);
        }else{
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('没有该订单信息，请输入正确的商品编号');");
            writer.write("window.location.href = 'ordersManage.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }
    }
}
