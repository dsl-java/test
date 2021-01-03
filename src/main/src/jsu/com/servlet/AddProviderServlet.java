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

@WebServlet(urlPatterns = "/AddProviderServlet")
public class AddProviderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置post提交时候，参数解码方式
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 从前台获取供应商的各基本信息
        String providerName = request.getParameter("provider_name");
        String providerAddress = request.getParameter("provider_address");
        String providerTel = request.getParameter("provider_tel");

        //封装成一个对象
        Provider provider=new Provider(null,providerName,providerAddress,providerTel);
        ProviderDAO providerDAO=new ProviderDAO();

        //添加供应商信息
        boolean flag=providerDAO.saveProvider(provider);

        if(flag){
            //添加成功
            //请求转发
            request.getRequestDispatcher("/ProviderServlet").forward(request,response);
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
