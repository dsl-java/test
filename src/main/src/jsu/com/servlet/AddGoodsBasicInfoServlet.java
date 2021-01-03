package jsu.com.servlet;


import jsu.com.bean.GoodsBasicInfo;
import jsu.com.dao.GoodsBasicInfoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/AddGoodsBasicInfoServlet")
public class AddGoodsBasicInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置post提交时候，参数解码方式
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 从前台获取商品的各基本信息
        String goodsName = request.getParameter("goods_name");
        String goodsType = request.getParameter("goods_type");
        String goodsStock = request.getParameter("goods_stock");
        String goodsPrice = request.getParameter("goods_price");
        String providerId = request.getParameter("provider_id");

        Integer stock=Integer.valueOf(goodsStock);
        Double price=Double.valueOf(goodsPrice);
        Integer provider_Id=Integer.valueOf(providerId);

        //封装成一个对象
        GoodsBasicInfo goodsBasicInfo=new GoodsBasicInfo(null,goodsName,goodsType,stock,price,provider_Id);

        GoodsBasicInfoDAO goodsBasicInfoDAO=new GoodsBasicInfoDAO();
        //插入商品信息
        boolean flag=goodsBasicInfoDAO.saveGoodsBasicInfo(goodsBasicInfo);

        if(flag){
            //添加成功
            //请求转发
          //  request.getRequestDispatcher("/stock/GoodsBasicInfoServlet").forward(request,response);
            request.getRequestDispatcher("/GoodsBasicInfoServlet").forward(request,response);
        }else {
            // 通过response对象给客户端一个错误提示
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('添加失败');");
            writer.write("window.location.href = 'goodsManage.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
