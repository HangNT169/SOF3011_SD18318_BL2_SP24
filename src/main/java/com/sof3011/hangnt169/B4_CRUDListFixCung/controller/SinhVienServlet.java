package com.sof3011.hangnt169.B4_CRUDListFixCung.controller;

import com.sof3011.hangnt169.B4_CRUDListFixCung.entity.SinhVien;
import com.sof3011.hangnt169.B4_CRUDListFixCung.service.SinhVienService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
    private List<SinhVien> lists = new ArrayList<>();

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

    @SneakyThrows
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

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
//        // C1: Giong J2
//        // B1: Lay du lieu tu view => servlet
//        String masv = request.getParameter("mssv");
//        String ten = request.getParameter("ten");
//        String tuoi = request.getParameter("tuoi");
//        String diaChi = request.getParameter("diaChi");
//        String gioiTinh = request.getParameter("gioiTinh");
//        // B2: Khoi tao doi tuong (contructor => new)
//        SinhVien sv = new SinhVien(masv, ten, Integer.valueOf(tuoi), Boolean.valueOf(gioiTinh), diaChi);
//        // B3: Goi service
//        service.addSinhVien(sv);
//        // B4: Quay lai trang chu
//        // goi lai list
////        lists = service.getAll();
////        request.setAttribute("abc",lists);
////        request.getRequestDispatcher("/buoi4/sinhviens.jsp").forward(request,response);
//        response.sendRedirect("/sinh-vien/hien-thi");
        // C2: BeanUtils
        SinhVien sv = new SinhVien();
        BeanUtils.populate(sv, request.getParameterMap());
        service.addSinhVien(sv);
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/buoi4/add-sinh-vien.jsp").forward(request, response);
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lay vi tri tren url
        String index = request.getParameter("viTri");
        SinhVien sv = service.detailSinhVien(Integer.valueOf(index));
        request.setAttribute("sv", sv);
        request.getRequestDispatcher("/buoi4/update-sinh-vien.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lay vi tri tren url
        String index = request.getParameter("viTri");
        SinhVien sv = service.detailSinhVien(Integer.valueOf(index));
        request.setAttribute("sv", sv);
        request.getRequestDispatcher("/buoi4/detail-sinh-vien.jsp").forward(request, response);
    }

    private void removeSinhVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Lay vi tri tren url
        String index = request.getParameter("viTri");
        service.xoaSinhVien(Integer.valueOf(index));
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void searchSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lists = service.getAll();
        request.setAttribute("abc", lists);
        request.getRequestDispatcher("/buoi4/sinhviens.jsp").forward(request, response);
    }
}
