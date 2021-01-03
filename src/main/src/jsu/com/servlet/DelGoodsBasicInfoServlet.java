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

@WebServlet(urlPatterns = "/DelGoodsBasicInfoServlet")
public class DelGoodsBasicInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置post提交时候，参数解码方式
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String goodsId=request.getParameter("goodsId");
        //先根据商品的Id查找商品
        GoodsBasicInfoDAO goodsBasicInfoDAO=new GoodsBasicInfoDAO();
        Integer id=Integer.valueOf(goodsId);
        //根据ID查找到该商品
        GoodsBasicInfo goodsBasicInfo=goodsBasicInfoDAO.getGoodsBasicInfoById(id);
        //删除此对象
        boolean flag=goodsBasicInfoDAO.deleteGoodsBasicInfo(goodsBasicInfo);

        if(flag){//为true对象被删除

//            PrintWriter writer = response.getWriter();
//            writer.write("<script>");
//            writer.write("alert('删除成功');");
//            writer.write("window.location.href = 'goodsManage.jsp'");
//            writer.write("</script>");
//            writer.flush();
//            writer.close();

            //请求转发
            request.getRequestDispatcher("/stock/GoodsBasicInfoServlet").forward(request,response);
        }else{
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('删除失败');");
            writer.write("window.location.href = 'goodsManage.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }
    }
}
