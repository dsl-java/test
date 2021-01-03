package jsu.com.servlet;

import jsu.com.bean.GoodsBasicInfo;
import jsu.com.bean.User;
import jsu.com.dao.GoodsBasicInfoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/GoodsBasicInfoServlet")
public class GoodsBasicInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置post提交时候，参数解码方式
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

//        private int goodsId;
//        private String goodsName;
//        private String goodsType;
//        private int goodsStock;
//        private double goodsPrice;
//        private int provider_id;

        //查询商品信息
        String sql="select goods_id goodsId,goods_name goodsName,goods_type goodsType,goods_stock goodsStock," +
                "goods_price goodsPrice,provider_id provider_id FROM tb_goods_basicinfo";

        GoodsBasicInfoDAO goodsBasicInfoDAO=new GoodsBasicInfoDAO();
        List<GoodsBasicInfo> goodsBasicInfoList=goodsBasicInfoDAO.getGoodsBasicInfoLsit(sql);

        //查看是否有数据
        if(goodsBasicInfoList.size()!=0){
            //放入请求作用域，显示商品信息
            request.setAttribute("goodsBasicInfoList",goodsBasicInfoList);
            //请求转发
            request.getRequestDispatcher("goodsManage.jsp").forward(request,response);
        }else{
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('表中没有数据');");
            writer.write("window.location.href = 'goodsManage.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }
    }
}
