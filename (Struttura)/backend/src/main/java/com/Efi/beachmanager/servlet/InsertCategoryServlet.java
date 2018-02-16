package com.Efi.postgresql.Servlet;

import com.Efi.postgresql.Dao.Category.CategoryDao;
import com.Efi.postgresql.Dao.Category.CategoryDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InsertCategoryServlet extends HttpServlet {
    CategoryDao categoryDao = new CategoryDaoImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String categoria = request.getParameter("inserisciCategoria");

        categoryDao.insertCategory(categoria);

        request.getRequestDispatcher("lista_categorie.jsp").forward(request, response);
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}