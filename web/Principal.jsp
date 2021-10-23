<%-- 
    Document   : Principal
    Created on : 22/10/2021, 04:03:46 AM
    Author     : diant
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-info">

            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ">
                    <li class="nav-item active">
                        <a style="margin-left: 10px; border: none"   class="btn btn-outline-light" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none"   class="btn btn-outline-light" href="Controlador?accion=Producto" target="myFrame" >Producto</a>
                    </li>

                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none"   class="btn btn-outline-light" href="Controlador?accion=Empleado" target="myFrame">Empleado</a>
                    </li>

                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none"   class="btn btn-outline-light" href="Controlador?accion=Cliente" target="myFrame">Cliente</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none"  class="btn btn-outline-light" href="Controlador?accion=NuevaVenta"target="myFrame" >Nueva venta</a>
                    </li>
                </ul>


            </div>
            <div  class="dropdown">
                <button style="margin-right: 15px; border: none" class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    ${usuario.getNom()}
                </button>
                <div class="dropdown-menu text-center" >
                    <a class="dropdown-item" href="#">
                        <img src="img/149071.png" alt="60" width="60"/>

                    </a>
                    <a class="dropdown-item" href="#"> ${usuario.getNom()}</a>
                    <a class="dropdown-item" href="#">usuario@gmail.com</a>
                    
                    <div class="dropdown-divider"></div>
                    <form action="Validar" method="POST">
                        
                    <button name="accion" value="Salir"  class="dropdown-item" href="#">Salir</button>
                    
                    </form>
                </div>


            </div>
        </nav>
                    <div class="m-4" style="height: 550px; ">       
                <iframe name="myFrame" style="height: 100%; width: 100%">      
            
                 </iframe>         
                   
              </div>       

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>


</html>