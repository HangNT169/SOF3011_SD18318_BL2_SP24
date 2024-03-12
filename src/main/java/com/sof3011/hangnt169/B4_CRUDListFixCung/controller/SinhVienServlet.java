package com.sof3011.hangnt169.B4_CRUDListFixCung.controller;

import com.sof3011.hangnt169.B4_CRUDListFixCung.entity.SinhVien;
import com.sof3011.hangnt169.B4_CRUDListFixCung.service.SinhVienService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SinhVienServlet", value = {
        "/sinh-vien/hien-thi",     // GET
        "/sinh-vien/search",      // GET
        "/sinh-vien/remove",      // GET
        "/sinh-vien/detail",      // GET
        "/sinh-vien/view-update",  // GET
        "/sinh-vien/view-add",     // GET
        "/sinh-vien/update",      // POST
        "/sinh-vien/add"          // POST
})
public class SinhVienServlet extends HttpServlet {

    private SinhVienService service = new SinhVienService();
    private List<SinhVien>lists = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: Lay uri tu duong dan
        String uri = request.getRequestURI();
        // B2: Check uri thuoc loai nao
        if (uri.contains("hien-thi")) {
            //hiển thi ds sinh vien
            this.hienThi(request, response);
        } else if (uri.contains("search")) {
            this.searchSinhVien(request, response);
        } else if (uri.contains("remove")) {
            this.removeSinhVien(request, response);
        } else if (uri.contains("detail")) {
            this.detail(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdate(request, response);
        } else {
            this.viewAdd(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("update")) {
            //update
            this.update(request, response);
        } else {
            this.add(request, response);
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) {
    }

    private void removeSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void searchSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lists = service.getAll();
        request.setAttribute("abc",lists);
        request.getRequestDispatcher("/buoi4/sinhviens.jsp").forward(request,response);
    }
}
