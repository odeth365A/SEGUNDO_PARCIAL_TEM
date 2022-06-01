<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Segundo Parcial</title>
     <table border="1" cellspacing="0" align="center"><tr><td>
            <h1>SEGUNDO PARCIAL TEM-742</h1>
            <p>Nombres: Karla Odeth Angulo Callisaya<br>C.I.: 7089614 L.P.</p></td></tr>
        </table>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
  </head>
  <body>
      <jsp:include page="META-INF/menu.jsp">
              <jsp:param name="opcion" value="participantes"/>
      </jsp:include>
      <div class="container">
          <h1>Participantes</h1>    
          <br>
          <a href="ParticipanteControlador?action=add" class="btn btn-primary btn-sm mb-3"><i class="fa-solid fa-circle-plus"></i> Nuevo </a>
          <br>
          <table class="table table-dark table-striped">
              <tr>
                  <th>ID</th>
                  <th>NOMBRES</th>
                  <th>APELLIDOS</th>
                  <th>SEMINARIO</th>
                  <th>CONFIRMADO</th>
                  <th></th>
                  <td></td>
              </tr>
              <c:forEach var="item" items="${participantes}">
              <tr>
                  <td>${item.id}</td>
                  <td>${item.nombres}</td>
                  <td>${item.apellidos}</td>
                  <td>${item.id_seminario}</td>
                  <td>${item.confirmado}</td>
                  <td><a href="ParticipanteControlador?action=edit&id=${item.id}" class="btn btn-sm btn-primary"><i class="fa-solid fa-pen-to-square"></i></a></td>
                  <td><a href="ParticipanteControlador?action=delete&id=${item.id}" onclick="return(confirm('esta seguro?'))" class="btn btn-sm btn-primary"><i class="fa-solid fa-trash-can"></i></a></td>
              </tr>
              </c:forEach>
          </table>
      </div>  
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
  </body>
</html>