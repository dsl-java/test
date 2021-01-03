package jsu.com.servlet;

import jsu.com.bean.GoodsBasicInfo;
import jsu.com.dao.GoodsBasicInfoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/UpdateGoodsBasicInfoServlet")
public class UpdateGoodsBasicInfoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置post提交时候，参数解码方式
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String goodsId=request.getParameter("goodsId");

        Integer id=Integer.valueOf(goodsId);
        GoodsBasicInfoDAO goodsBasicInfoDAO=new GoodsBasicInfoDAO();
        //根据id查询该对象
        GoodsBasicInfo goodsBasicInfo=goodsBasicInfoDAO.getGoodsBasicInfoById(id);

        request.getSession().setAttribute("SESSION_goodsId",goodsId);
        request.getSession().setAttribute("SESSION_goodsBasicInfo",goodsBasicInfo);

        //请求转发
        request.getRequestDispatcher("updateGoods.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

}
