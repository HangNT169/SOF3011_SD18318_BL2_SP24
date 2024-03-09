package com.sof3011.hangnt169.B2_LamQuenVoiForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = {"/login","/ket-qua"})
// value => duong dan va bat dau bang dau /. Neu k tomcat k build
// Duong dan giong y de bai
// BE & FE => tang trung gian: controller va trao doi thong qua phuong thuc HTTP.
// Co 4 loai HTTP Methods co ban:
// GET : Lay ra , Hien thi <=> READ
// POST : Add nha <=> CREATE
// PUT : Update
// DELETE : DELETE
// J4, J5: Chi lam viec vs 2 loai get , post
// Get: Lay ra, hien thi
// Post: Xu ly
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Truyen gia tri cua 1 bien tu servlet sang jsp => setAttribute demo
        String mess = "PhongTT35";
        request.setAttribute("a",mess);
        // Chuyen trang
        // C1:
//        request.getRequestDispatcher("fomr-login.jsp").forward(request,response);
        // C2:
        response.sendRedirect("fomr-login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: Lay du lieu tu jsp ve servlet => getParameter => Lay thong qua name
        String name = request.getParameter("a");
        String pass = request.getParameter("b");
        // B2: Truyen du lieu tu servlet => jsp
        request.setAttribute("x1",name);
        request.setAttribute("x2",pass);
        request.getRequestDispatcher("ket-qua.jsp").forward(request,response);
    }

}
