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

@WebServlet(urlPatterns = "/UpdateGoodsServlet")
public class UpdateGoodsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置post提交时候，参数解码方式
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String goodsId=(String)request.getSession().getAttribute("SESSION_goodsId");

        // 从前台获取商品的各基本信息
        String goodsName = request.getParameter("goods_name");
        String goodsType = request.getParameter("goods_type");
        String goodsStock = request.getParameter("goods_stock");
        String goodsPrice = request.getParameter("goods_price");
        String providerId = request.getParameter("provider_id");

        Integer id=Integer.valueOf(goodsId);
        Integer stock=Integer.valueOf(goodsStock);
        Double price=Double.valueOf(goodsPrice);
        Integer provider_Id=Integer.valueOf(providerId);

        //封装成一个对象
        GoodsBasicInfo goodsBasicInfo=new GoodsBasicInfo(id,goodsName,goodsType,stock,price,provider_Id);
        //修改对象
        GoodsBasicInfoDAO goodsBasicInfoDAO=new GoodsBasicInfoDAO();

        boolean flag=goodsBasicInfoDAO.updateGoodsBasicInfo(goodsBasicInfo);
        if(flag){
            //修改成功
            //请求转发
            request.getRequestDispatcher("/GoodsBasicInfoServlet").forward(request,response);
        }else{
            //修改失败
            // 通过response对象给客户端一个错误提示
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('修改失败');");
            writer.write("window.location.href = '/GoodsBasicInfoServlet'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }

    }
}
