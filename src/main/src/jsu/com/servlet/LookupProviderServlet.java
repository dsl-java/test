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

@WebServlet(urlPatterns = "/LookupProviderServlet")
public class LookupProviderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置post提交时候，参数解码方式
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 从前台获取供应商ID
        String providerId = request.getParameter("search");

        if(providerId.equals("")){
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('请输入供应商编号,不能为空');");
            writer.write("window.location.href = '/stock/ProviderServlet'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }
        //将字符串转为Integer
        Integer id=Integer.valueOf(providerId);

        ProviderDAO providerDAO=new ProviderDAO();
        List<Provider> providerList=providerDAO.getProviderLsit(id);

        if(providerList.size()!=0){
            //查找成功
            //放入请求作用域，显示商品信息
            request.setAttribute("providerList",providerList);
            //请求转发
            request.getRequestDispatcher("providerManage.jsp").forward(request,response);
        }else{
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('没有该供应商信息，请输入正确的商品编号');");
            writer.write("window.location.href = 'providerManage.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }
    }
}
