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

@WebServlet(urlPatterns = "/UpdateProviderServlet")
public class UpdateProviderServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置post提交时候，参数解码方式
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String providerId=(String)request.getSession().getAttribute("SESSION_providerId");

        // 从前台获取供应商的各基本信息
        String providerName = request.getParameter("provider_name");
        String providerAddress = request.getParameter("provider_address");
        String providerTel = request.getParameter("provider_tel");

        Integer id=Integer.valueOf(providerId);
        //封装成一个对象
        Provider provider=new Provider(id,providerName,providerAddress,providerTel);
        ProviderDAO providerDAO=new ProviderDAO();

        boolean flag=providerDAO.updateProvider(provider);
        if(flag){
            //修改成功
            //请求转发
            request.getRequestDispatcher("/ProviderServlet").forward(request,response);
        }else {
            //修改失败
            // 通过response对象给客户端一个错误提示
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('修改失败');");
            writer.write("window.location.href = '/ProviderServlet'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }

    }
}
