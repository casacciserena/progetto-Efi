<%@ page import="com.Efi.postgresql.Dao.Word.WordDao" %>
<%@ page import="com.Efi.postgresql.Dao.Word.WordDaoImpl" %>
<%@ page import="com.Efi.postgresql.Dao.Word.Word" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Utente
  Date: 24/05/2017
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista parole</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body class="container" style="padding-top:20px">
<div class="row">
    <div class="col-xs-6 col-sm-6 col-md-6">
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Parola</th>
                <th>Categoria</th>
            </tr>
            </thead>
            <tbody>
            <%WordDao wordDao = new WordDaoImpl();%>
            <%for(Word word : wordDao.searchWords()) {
            %><tr>
                <td><%=word.getId_words()%></td>
                <td><%=word.getWords()%></td>
                <td><%=word.getId_category_words().getCategory()%></td>
            </tr><%}%>
            </tbody>
        </table>
    </div>
</div>
</body>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>
