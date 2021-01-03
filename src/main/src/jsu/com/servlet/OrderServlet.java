package jsu.com.servlet;

import jsu.com.bean.Orders;
import jsu.com.bean.Provider;
import jsu.com.dao.OrdersDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/OrderServlet")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置post提交时候，参数解码方式
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

//        private Integer orderId;
//        private String orderType;
//        private String trade;
//        private String orderGoodsId;
//        private Integer orderCount;
        //查询订单信息
        String sql="SELECT order_id orderId, order_type orderType, trader trade, " +
                "order_goods_id orderGoodsId, order_count orderCount FROM tb_goods_order";

        OrdersDAO ordersDAO=new OrdersDAO();
        List<Orders> ordersList=ordersDAO.getOrdersLsit(sql);

        //查看是否有数据
        if(ordersList.size()!=0){
            //放入请求作用域，显示商品信息
            request.setAttribute("ordersList",ordersList);
            //请求转发
            request.getRequestDispatcher("ordersManage.jsp").forward(request,response);
        }else{
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('表中没有数据');");
            writer.write("window.location.href = 'index.html'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }
    }
}
