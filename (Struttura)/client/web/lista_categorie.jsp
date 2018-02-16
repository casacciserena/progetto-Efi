<%@ page import="com.Efi.postgresql.Dao.Category.CategoryDao" %>
<%@ page import="com.Efi.postgresql.Dao.Category.CategoryDaoImpl" %>
<%@ page import="com.Efi.postgresql.Dao.Category.Category" %><%--
  Created by IntelliJ IDEA.
  User: Utente
  Date: 18/05/2017
  Time: 16:53
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
                <th>Categoria</th>
            </tr>
            </thead>
            <tbody>
            <%CategoryDao categoryDao = new CategoryDaoImpl();%>
            <%for(Category category : categoryDao.searchCategory()) {
            %><tr>
                <td><%=category.getId_category_words()%></td>
                <td><%=category.getCategory()%></td>
            </tr><%}%>
            </tbody>
        </table>
    </div>
</div>
</body>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>
