package jsu.com.servlet;

import jsu.com.bean.Provider;
import jsu.com.dao.ProviderDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/UpdateProviderBasicInfoServlet")
public class UpdateProviderBasicInfoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置post提交时候，参数解码方式
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String providerId=request.getParameter("providerId");

        Integer id=Integer.valueOf(providerId);
        ProviderDAO providerDAO=new ProviderDAO();
        //根据id查询该对象
        Provider provider=providerDAO.getProviderById(id);

        request.getSession().setAttribute("SESSION_providerId",providerId);
        request.getSession().setAttribute("SESSION_provider",provider);

        //请求转发
        request.getRequestDispatcher("updateProvider.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
