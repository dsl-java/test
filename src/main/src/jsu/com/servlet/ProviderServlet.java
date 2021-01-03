package jsu.com.servlet;

import jsu.com.bean.Provider;
import jsu.com.dao.ProviderDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/ProviderServlet")
public class ProviderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置post提交时候，参数解码方式
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

//        private  int providerId;
//        private String providerName;
//        private String providerAddress;
//        private String providerTel;
        //查询商品信息
        String sql="SELECT  provider_id providerId,provider_name providerName,provider_address  providerAddress,provider_tel providerTel FROM tb_goods_provider";

              ProviderDAO providerDAO=new ProviderDAO ();
        List<Provider> providerList=providerDAO.getProviderLsit(sql);

        //查看是否有数据
        if(providerList.size()!=0){
            //放入请求作用域，显示商品信息
            request.setAttribute("providerList",providerList);
            //请求转发
            request.getRequestDispatcher("providerManage.jsp").forward(request,response);
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
