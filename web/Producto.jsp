<%-- 
    Document   : Producto
    Created on : 22/10/2021, 07:37:15 PM
    Author     : diant
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="d-flex">
           <div class="card col-sm-4">
            <div class="card-body">
                <form action="Controlador?menu=Producto" method="POST">

                   
                    
                    <div class="form-group"> 
                        <label> Nombres </label>
                        <input type="text"  value="${producto.getNom()}" name="txtNombres" class="form-control">
                    </div>
                    <div class="form-group"> </div>
                    <label> PRECIO</label>
                    <input type="text" value="${producto.getPrecio()}"  name="txtPrecio" class="form-control">
                    <div class="form-group"> </div>
                    <label> STOCK</label>
                    <input type="text" value="${producto.getStock()}"  name="txtStock" class="form-control">
                    <div class="form-group"> </div>
                    <label> Estado </label>
                    <input type="text"  value="${producto.getEstado()}" name="txtEstado" class="form-control">
                    <div class="form-group"> 
                    
                    
                    </div>
                    
                    <input  type="submit" name="accion" value="Agregar" class="btn btn-info">
                     <input  type="submit" name="accion" value="Actualizar" class="btn btn-success">
                </form>

            </div>
                    
        </div>
        <div class="col-sm-8 ">  
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>NOMBRES</th>
                        <th>PRECIO</th>
                        <th>STOCK</th>
                        <th>ESTADO</th>
                        <th>ACCIONES</th>
                      
                        
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="pr" items="${productos}">
                        
                    <tr>
                        <td>${pr.getId()}</td>
                        <td>${pr.getNom()}</td>
                        <td>${pr.getPrecio()}</td>
                        <td>${pr.getStock()}</td>
                        <td>${pr.getEstado()}</td>
                       
                        
                        <td>
                            
                            <a class="btn btn-warning" href="Controlador?menu=Producto&accion=Editar&id=${pr.getId()}"  >Editar </a>
                            
                            <a class="btn btn-danger" href="Controlador?menu=Producto&accion=Delete&id=${pr.getId()}">Eliminar </a>
                            
                        </td>
                        
                    </tr>
                    
                   </c:forEach>
                </tbody>
            </table>
        </div>
        
                  
            

        </div>
    </body>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</html>
