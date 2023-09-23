package com.vaideheekore.servlet;

import com.vaideheekore.dao.UserDao;
import com.vaideheekore.db.HibernateUtil;
import com.vaideheekore.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/userRegister")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String fullname = req.getParameter("fullname");
        String email = req.getParameter( "email");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User u = new User(fullname, email, username, password);
        //System.out.println(u);

        UserDao dao = new UserDao(HibernateUtil.getSessionFactory());
        boolean f = dao.saveuser(u);

        HttpSession session = req.getSession();

        if(f){
            session.setAttribute("msg", "Registered Successfully!");
            //System.out.println("success");
            resp.sendRedirect("register.jsp");
        } else {
            session.setAttribute("msg", "User not registered!");
        }

    }
}
