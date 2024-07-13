package com.example.su24tutor.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "HomeServlet", value = {
        "/home",
        "/login", // post
})
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ten = "Vu Van Nguyen";
        request.setAttribute("name", ten);
        request.getRequestDispatcher("/dang-nhap.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals("admin") && password.equals("admin")){
            request.getRequestDispatcher("/trang-chu.jsp").forward(request, response);
        }else {
            response.sendRedirect("/home");
        }

    }

    public void hello(){
        System.out.println("hello");
    }
}
