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
import java.util.List;

@WebServlet(urlPatterns = "/LookupGoodsBasicInfoServlet")
public class LookupGoodsBasicInfoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置post提交时候，参数解码方式
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 从前台获取商品ID
        String goodsId = request.getParameter("search");

        if(goodsId.equals("")){
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('请输入商品编号,不能为空');");
            writer.write("window.location.href = '/stock/GoodsBasicInfoServlet'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }
        //将字符串转为Integer
        Integer id=Integer.valueOf(goodsId);

        GoodsBasicInfoDAO goodsBasicInfoDAO=new GoodsBasicInfoDAO();
        List<GoodsBasicInfo> goodsBasicInfoList=goodsBasicInfoDAO.getGoodsBasicInfoLsit(id);

        if(goodsBasicInfoList.size()!=0){
            //查找成功
            //放入请求作用域，显示商品信息
            request.setAttribute("goodsBasicInfoList",goodsBasicInfoList);
            //请求转发
            request.getRequestDispatcher("goodsManage.jsp").forward(request,response);
        }else{
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('没有该商品信息，请输入正确的商品编号');");
            writer.write("window.location.href = 'goodsManage.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
