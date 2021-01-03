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

@WebServlet(urlPatterns = "/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置post提交时候，参数解码方式
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        User user=(User) request.getSession().getAttribute("user");
        Integer userId=user.getId();
        String password=user.getPassword();

        //从前台获取相应的值
        String oldPassword=request.getParameter("oldPassword");
        String newPassword=request.getParameter("newPassword");
        String comparePassword=request.getParameter("comparePassword");

        if(!(password.equals(oldPassword))){
            // 通过response对象给客户端一个错误提示
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('原密码输入错误，请重新输入！');");
            writer.write("window.location.href = 'updatePassword.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }else{
            //封装成一个对象
            User user1=new User(userId,user.getUsername(),newPassword);
            UserDAO userDAO=new UserDAO();

            boolean flag=userDAO.updatePassword(user1);
            if(flag){
                //修改成功
           /* PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('修改成功！');");
            writer.write("window.location.href = 'updatePassword.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();*/

                //请求转发，进入登录界面
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }else{

                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('修改失败！');");
                writer.write("window.location.href = 'updatePassword.jsp'");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
