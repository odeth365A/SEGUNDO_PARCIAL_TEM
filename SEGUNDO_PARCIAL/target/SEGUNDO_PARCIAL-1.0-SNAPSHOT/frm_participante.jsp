<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Segundo Parcial</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
  </head>
  <body>
      <jsp:include page="META-INF/menu.jsp">
              <jsp:param name="opcion" value="participantes"/>
      </jsp:include>
      <div class="container">
          <h1>Formulario de registro de participantes</h1>
         
          <br>
          <form action="ParticipanteControlador" method="POST">
              <input type="hidden" name="id" value="${Participante.id}">
              <div class="mb-3">
                  <label for="exampleInputEmail1" class="form-label">Nombres</label>
                  <input type="text" class="form-control" id="exampleInputEmail1" value="${Participante.nombres}" name="nombres" placeholder="Escriba su nombre">
              </div>
              <div class="mb-3">
                  <label for="exampleInputEmail1" class="form-label">Apellidos</label>
                  <input type="text" class="form-control" id="exampleInputEmail1" value="${Participante.apellidos}" name="apellidos" placeholder="Escriba su apellido">
              </div>
   
              <div class="mb-3">
                  <label for="exampleInputPassword1" class="form-label">id Seminario</label>
                  <input type="text" class="form-control" id="exampleInputPassword1" value="${Partcipante.id_seminario}" name="id_seminario" placeholder="Ingrese id del seminario">
              </div>
              <button type="submit" class="btn btn-primary">Enviar</button>
          </form>

      </div>  
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
  </body>
</html>
