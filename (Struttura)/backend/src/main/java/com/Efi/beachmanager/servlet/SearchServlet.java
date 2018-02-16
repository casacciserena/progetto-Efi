package com.Efi.postgresql.Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Utente on 18/05/2017.
 */
public class SearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String parola = request.getParameter("ricerca");
        String categoria = request.getParameter("selezionaCategoria");

        HttpSession session = request.getSession();
        session.setAttribute("parola", parola);
        session.setAttribute("categoria", categoria);

        request.getRequestDispatcher("lista_parole_trovate.jsp").forward(request, response);
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) {

    }
}
