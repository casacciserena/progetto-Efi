<%@ page import="com.Efi.postgresql.Dao.Category.Category" %>
<%@ page import="com.Efi.postgresql.Dao.Category.CategoryDaoImpl" %>
<%@ page import="com.Efi.postgresql.Dao.Category.CategoryDao" %><%--
  Created by IntelliJ IDEA.
  User: Utente
  Date: 17/05/2017
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>PostgreSQL</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body class="container" style="padding-top:20px">
<div class="row" style="text-align:center">
  <div class="col-xs-6 col-sm-6 col-md-6">
    <form action="InsertCategoryServlet">
      <div class="form-group">
        <label for="inserisciCategoria">Inserisci categoria parole</label>
        <input type="text" class="form-control" id="inserisciCategoria" name="inserisciCategoria" placeholder="Inserisci la categoria da aggiungere" style="text-align:center">
      </div>
      <button type="submit" class="btn btn-success">Inserisci</button>
    </form>
  </div>

  <div class="col-xs-6 col-sm-6 col-md-6">
    <form action="SearchServlet">
      <div class="form-group">
        <label for="ricerca">Ricerca parola</label>
        <input type="text" class="form-control" id="ricerca" name="ricerca" placeholder="Inserisci la parola da ricercare" style="text-align:center">
        <label for="selezionaCategoria">Seleziona categoria</label>
        <select class="form-control" id="selezionaCategoria" name="selezionaCategoria">
          <%CategoryDao categoryDaoDaRicercare = new CategoryDaoImpl();%>
          <%for(Category category : categoryDaoDaRicercare.searchCategory()) {
          %><option value="<%=category.getCategory()%>"><%=category.getCategory()%></option><%}%>
        </select>
      </div>
      <button type="submit" class="btn btn-primary">Ricerca</button>
    </form>
  </div>
</div>

<div class="row" style="text-align:center">
  <div class="col-xs-6 col-sm-6 col-md-6">
    <form action="InsertWordServlet">
      <div class="form-group">
        <label for="inserisciParola">Inserisci parola</label>
        <input type="text" class="form-control" id="inserisciParola" name="inserisciParola" placeholder="Inserisci la parola da aggiungere" style="text-align:center">
        <label for="selezionaCategoriaDaInserire">Seleziona categoria</label>
        <select class="form-control" id="selezionaCategoriaDaInserire" name="selezionaCategoriaDaInserire">
          <%CategoryDao categoryDaoDaInserire = new CategoryDaoImpl();%>
          <%for(Category category : categoryDaoDaInserire.searchCategory()) {
          %><option value="<%=category.getId_category_words()%>"><%=category.getCategory()%></option><%}%>
        </select>
      </div>
      <button type="submit" class="btn btn-success">Inserisci</button>
    </form>
  </div>
</div>
</body>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>