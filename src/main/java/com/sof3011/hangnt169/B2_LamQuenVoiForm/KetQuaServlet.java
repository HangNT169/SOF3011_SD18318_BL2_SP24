package com.sof3011.hangnt169.B2_LamQuenVoiForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "KetQuaServlet", value = "/ket-qua1")
public class KetQuaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getRequestDispatcher("test.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // B1: Lay du lieu tu jsp ve servlet => getParameter => Lay thong qua name
//        String name = request.getParameter("a");
//        String pass = request.getParameter("b");
//        // B2: Truyen du lieu tu servlet => jsp
//        request.setAttribute("x1",name);
//        request.setAttribute("x2",pass);
//        request.getRequestDispatcher("ket-qua.jsp").forward(request,response);
    }
}
