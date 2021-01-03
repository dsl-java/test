package jsu.com.servlet;

import jsu.com.bean.GoodsBasicInfo;
import jsu.com.bean.Provider;
import jsu.com.dao.GoodsBasicInfoDAO;
import jsu.com.dao.ProviderDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/DelProviderServlet")
public class DelProviderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置post提交时候，参数解码方式
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String providerId=request.getParameter("providerId");
        //先根据商品的Id查找供应商
        ProviderDAO providerDAO=new ProviderDAO();
        Integer id=Integer.valueOf(providerId);
        //根据ID查找到该供应商
        Provider provider=providerDAO.getProviderById(id);
        //删除此对象
        boolean flag=providerDAO.deleteProvider(provider);

        if(flag){//为true对象被删除
            //请求转发
            request.getRequestDispatcher("/ProviderServlet").forward(request,response);
        }else {
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('删除失败');");
            writer.write("window.location.href = 'providerManage.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }

    }
}
