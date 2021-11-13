<%-- 
    Document   : RegistrarVenta
    Created on : 22/10/2021, 07:38:27 PM
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
        
        <style>
            @media print{
                
                .parte01, .btn, .accion{
                    display: none;
                }
            }
        </style>    
    </head>
    <body>
        <div class="d-flex">
            <div class="col-sm-5 parte01">     
                <div class="card">  
                    <form action="Controlador?menu=NuevaVenta" method="POST">
                        <div class="card-body">   
                            <div class="form-group ">
                                <label>Datos del cliente</label>
                            </div>
                            <div class="form-group d-flex ">
                                <div class="col-sm-6 d-flex">  
                                    <input type="text" name="codigocliente" value="${cl.getDni()}" class="form-control" placeholder="Codigo">
                                    <input type="submit" name="accion" value="BuscarCliente"  class="btn btn-outline-info">

                                </div>

                                <div class="col-sm-6">  
                                    <input type="text" name="nombrescliente"  value="${cl.getNom()}" class="form-control"placeholder="Datos cliente">
                                </div>

                            </div>
                            <div class="form-group ">
                                <label>Datos Producto</label>

                            </div>
                            <div class="form-group d-flex ">
                                <div class="col-sm-6 d-flex">  
                                    <input type="text" name="codigoproducto" value="${producto.getId()}" class="form-control" placeholder="Codigo">
                                    <button type="submit" name="accion" value="BuscarProducto"  class="btn btn-outline-info">Buscar </button>

                                </div>

                                <div class="col-sm-6">  
                                    <input type="text" name="nomproducto" value="${producto.getNom()}" class="form-control"placeholder="Datos producto">
                                </div>

                            </div>
                            <div class="form-group d-flex">

                                <div class="col-sm-6 d-flex">  
                                    <input type="text" name="precio" value="${producto.getPrecio()}" class="form-control" placeholder="$/. 0.00">
       
                                </div>

                                <div class="col-sm-3">  
                                    <input type="number" value="1" name="cant" class="form-control">
                                </div>

                                <div class="col-sm-3">  
                                    <input type="text" name="stock" value="${producto.getStock()}" class="form-control" placeholder="Stock">
                                </div>     
                            </div>
                                <!-- Btn -->
                            <div class="form-group"> 
                              <div class="col-sm"> 
                                  <button type="submit" name="accion" value="Agregar" class="btn btn-outline-info"> Agregar producto </button>
                            </div>      
                           </div> 
                        </div> 
                    </form>
                </div>
            </div>

            <div class="col-sm-7">

                <div class="card"> 
                    <div class="card-body"> 
                        <div class="d-flex col-sm-6 ml-auto">
                            <label>Nro.Serie</label>
                            <input type="text" name="NroSerie" value="${nserie}" class="form-control">
                        </div>
                        <br>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Nro</th>
                                    <th>Codigo</th>
                                    <th>Descripcion</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>Subtotal</th>
                                    <th class="accion">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="list" items="${lista}">
                                <tr>
                                    <td>${list.getItem()}</td>
                                    <td>${list.getIdproducto()}</td>
                                    <td>${list.getDescripcionP()}</td>
                                    <td>${list.getPrecio()}</td>
                                    <td>${list.getCantidad()}</td>
                                    <td>${list.getSubtotal()}</td>
                                    <td class="d-flex">
                                        <a href="#" class="btn btn-warning">Editar</a>
                                        <a href="#" class="btn btn-danger" style="margin-left: 10px">Eliminar</a>
                                        
                                    </td>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>


                    </div>

                    <div class="card-footer d-flex">

                        <div class="col-sm-6">
                            <a href="Controlador?menu=NuevaVenta&accion=GenerarVenta" onclick="print()" class="btn btn-success">Generar Venta</a>
                            
                            <input type="submit" name="accion" value="Cancelar" class="btn btn-danger ">
                        </div>
                        <div class="col-sm-3 ml-auto">
                            <input type="text" name="txtTotal" value=" $/. ${totalpagar}" class="form-control">
                        </div>
                    </div>

                </div>

            </div>



        </div>

    </body>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</html>
