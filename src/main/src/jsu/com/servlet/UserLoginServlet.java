package jsu.com.servlet;

import jsu.com.bean.User;
import jsu.com.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet( request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        // 获取前台提交的用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 根据用户名和密码查询用户
        UserDAO userDAO =new UserDAO();
        User user = userDAO.getUserByUsernameAndPass(username,password);

        // 判断user == null,返回登录界面，不为空，就进入主页面
        if(user!=null){
            // 用户名密码输入正
            //当前登录用户的ID
            Integer userID=user.getId();
            //将当前登录用户的简历ID，保存到Session中
            request.getSession().setAttribute("SESSION_UserId",userID);

            //用户放入请求作用域，显示该对象信息
            request.getSession().setAttribute("user",user);

            //请求转发到主页页面
            request.getRequestDispatcher("index.jsp").forward(request,response);
//            // 登录成功就跳转到主页面   重定向
//            response.sendRedirect("/stock/index.html");
        }else {
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('用户名或密码错误！');");
            writer.write("window.location.href = 'login.html'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }

    }
}
