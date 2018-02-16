package com.Efi.postgresql.Servlet;

import com.Efi.postgresql.Dao.Category.Category;
import com.Efi.postgresql.Dao.Word.WordDao;
import com.Efi.postgresql.Dao.Word.WordDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Utente on 24/05/2017.
 */
public class InsertWordServlet extends HttpServlet {
    WordDao wordDao = new WordDaoImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String parola = request.getParameter("inserisciParola");
        Category categoria = new Category();
        categoria.setId_category_words(Integer.parseInt(request.getParameter("selezionaCategoriaDaInserire")));

        wordDao.insertWord(parola, categoria);

        request.getRequestDispatcher("lista_parole.jsp").forward(request, response);
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) {

    }
}
