/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cliente;
import modelo.ClienteDAO;
import modelo.Empleado;
import modelo.EmpleadoDAO;
import modelo.GenerarSerie;
import modelo.Producto;
import modelo.ProductoDAO;
import modelo.Venta;
import modelo.VentaDAO;

/**
 *
 * @author diant
 */
public class Controlador extends HttpServlet {

    Empleado em = new Empleado();
    Cliente cl = new Cliente();
    Producto pr= new Producto();
    EmpleadoDAO edao = new EmpleadoDAO();
    ClienteDAO cdao = new ClienteDAO();
    ProductoDAO pdao = new ProductoDAO();
    int ide;
    int idc;
    int idp;
    
    Venta v =new Venta();
    List<Venta>lista=new ArrayList<>();
    int item;
    int cod;
    String descripcion;
    double precio;
    int cant;
    double subtotal;
    double totalPagar;
    
    String numeroserie;
    VentaDAO vdao = new VentaDAO();
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
      

        if (menu.equals("Principal")) {

            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        
        

        if (menu.equals("Empleado")) {

            switch (accion) {

                case "Listar":

                    List lista = edao.listar();
                    request.setAttribute("empleados", lista);
                    
                    
                    break;
                case "Agregar":

                    String dni = request.getParameter("txtDni");
                    String nom = request.getParameter("txtNombres");
                    String tel = request.getParameter("txtTel");
                    String est = request.getParameter("txtEstado");
                    String user = request.getParameter("txtUser");
                    em.setDni(dni);
                    em.setNom(nom);
                    em.setTel(tel);
                    em.setEstado(est);
                    em.setUser(user);
                    edao.agregar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);

                    break;
                case "Editar":

                    ide = Integer.parseInt(request.getParameter("id"));
                    Empleado e = edao.listarId(ide);
                    request.setAttribute("empleado", e);

                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);

                    break;

                case "Actualizar":
                    String dni1 = request.getParameter("txtDni");
                    String nom1 = request.getParameter("txtNombres");
                    String tel1 = request.getParameter("txtTel");
                    String est1 = request.getParameter("txtEstado");
                    String user1 = request.getParameter("txtUser");
                    em.setDni(dni1);
                    em.setNom(nom1);
                    em.setTel(tel1);
                    em.setEstado(est1);
                    em.setUser(user1);

                    em.setId(ide);
                    edao.actualizar(em);

                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);

                    break;
                case "Delete":

                    ide = Integer.parseInt(request.getParameter("id"));
                    edao.delete(ide);

                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);

                    break;

                default:

                    throw new AssertionError();

            }
               request.getRequestDispatcher("Empleado.jsp").forward(request, response);
            
        }
        if (menu.equals("Cliente")) {
             System.out.println("Entra cliente");
              switch (accion) {
                  case "Listar":
                    List lista = cdao.listar();
                    request.setAttribute("clientes", lista);
                    request.getRequestDispatcher("Clientes.jsp").forward(request, response);
                    break;
                case "Agregar":

                    String dni = request.getParameter("txtDni");
                    String nom = request.getParameter("txtNombres");
                    String Dir = request.getParameter("txtDir");
                    String est = request.getParameter("txtEstado");
                    
                    cl.setDni(dni);
                    cl.setNom(nom);
                    cl.setDir(Dir);
                    cl.setEstado(est);
                   
                    cdao.agregar(cl);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idc = Integer.parseInt(request.getParameter("id"));
                    Cliente e = cdao.listarId(idc);
                    request.setAttribute("cliente", e);
                    
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    
                    break;

                case "Actualizar":
                       String dni1 = request.getParameter("txtDni");
                    String nom1 = request.getParameter("txtNombres");
                    String Dir1 = request.getParameter("txtDir");
                    String est1 = request.getParameter("txtEstado");
                  
                    cl.setDni(dni1);
                    cl.setNom(nom1);
                    cl.setDir(Dir1);
                    cl.setEstado(est1);

                    cl.setId(idc);
                    cdao.actualizar(cl);
                    
                    
                     request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    idc = Integer.parseInt(request.getParameter("id"));
                    cdao.delete(idc);
                    
                     request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                  
                    break;

                default:

                    throw new AssertionError();
                  
                  
              }
            

            request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }
        if (menu.equals("Producto")) {

             switch (accion) {
                  case "Listar":
                      System.out.println("Listar producto");
                    List lista = pdao.listar();
                    request.setAttribute("productos", lista);
                    request.getRequestDispatcher("Producto.jsp").forward(request, response);
                    break;

                  case "Agregar":

                    String nom = request.getParameter("txtNombres");
                    double pre = Double.parseDouble(request.getParameter("txtPrecio"));
                    int sto = Integer.parseInt(request.getParameter("txtStock"));
                    String est = request.getParameter("txtEstado");
                    
                    pr.setNom(nom);
                    pr.setPrecio(pre);
                    pr.setStock(sto);
                    pr.setEstado(est);
                   
                    pdao.agregar(pr);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idp = Integer.parseInt(request.getParameter("id"));
                    Producto e = pdao.listarId(idp);
                    request.setAttribute("producto", e);
                    
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    
                    break;

                case "Actualizar":
                       String nom1 = request.getParameter("txtNombres");
                    double pre1 = Double.parseDouble(request.getParameter("txtPrecio"));
                    int sto1 = Integer.parseInt(request.getParameter("txtStock"));
                    String est1 = request.getParameter("txtEstado");
                  
                    pr.setNom(nom1);
                    pr.setPrecio(pre1);
                    pr.setStock(sto1);
                    pr.setEstado(est1);

                    pr.setId(idp);
                    pdao.actualizar(pr);
                    
                    
                     request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    idp = Integer.parseInt(request.getParameter("id"));
                    pdao.delete(idp);
                    
                     request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                  
                    break;  
                    
                    
   
                    
                default:

                    throw new AssertionError(); 
                    
             }
            
            
            
            
            
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }
        if (menu.equals("NuevaVenta")) {

//            switch (accion){
//                
//                case "BuscarCliente":
//                String dni=request.getParameter("codigocliente");
//                cl.setDni(dni);
//                cl=cdao.buscar(dni);
//                request.setAttribute("cl", cl);
//                break;
//                
//                 default:
//
//                throw new AssertionError();
//                
//            }
            if (menu.equals("NuevaVenta")) {
            
             switch (accion){
                 case "BuscarCliente":
                     request.setAttribute("nserie", numeroserie);
                     String dni=request.getParameter("codigocliente");
                     cl.setDni(dni);
                     cl =cdao.buscar(dni);
                     request.setAttribute("cl", cl);
                     break;
                     
                 case "BuscarProducto":
                     request.setAttribute("nserie", numeroserie);
                     int id= Integer.parseInt(request.getParameter("codigoproducto"));
                     pr=pdao.listarId(id);
                     request.setAttribute("cl", cl);
                     request.setAttribute("producto", pr);
                     request.setAttribute("lista", lista);
                     request.setAttribute("totalpagar", totalPagar);
                     break;
                     
                 case "Agregar":
                     request.setAttribute("nserie", numeroserie);
                     request.setAttribute("cl", cl);
                     totalPagar=0.0;
                     item = item+1;
                     cod=pr.getId();
                     descripcion=request.getParameter("nomproducto");
                     precio=Double.parseDouble(request.getParameter("precio"));
                     cant=Integer.parseInt(request.getParameter("cant"));
                     subtotal=precio*cant;
                     
                     v = new Venta();
                     v.setItem(item);
                     v.setIdproducto(cod);
                     v.setDescripcionP(descripcion);
                     v.setPrecio(precio);
                     v.setCantidad(cant);
                     v.setSubtotal(subtotal);
                     
                     lista.add(v);
                     
                     for (int i = 0; i < lista.size(); i++) {
                         totalPagar=totalPagar + lista.get(i).getSubtotal();
                     }
                     request.setAttribute("totalpagar", totalPagar);
                     request.setAttribute("lista", lista);
                     
                     break;
                     
                 case "GenerarVenta":
                     
                     //actualizar Stock
                     for (int i = 0; i < lista.size(); i++) {
                         Producto pr = new Producto();
                         int cantidad=lista.get(i).getCantidad();
                         int idproducto=lista.get(i).getIdproducto();
                         ProductoDAO aO = new ProductoDAO();
                         pr=aO.buscar(idproducto);
                         int sac=pr.getStock()-cantidad;
                         aO.actualizarstock(idproducto, sac);
                     }
                     //venta
                     v.setIdcliente(cl.getId());
                     v.setIdempleado(1);
                     v.setNumserie(numeroserie);
                     v.setFecha("2019-06-14");
                     v.setMonto(totalPagar);
                     v.setEstado("1");
                     vdao.guardarVenta(v);
                     //detalle
                     int idv=Integer.parseInt(vdao.IdVentas());
                     for (int i = 0; i < lista.size(); i++) {
                         v= new Venta();
                         v.setId(idv);
                         v.setIdproducto(lista.get(i).getIdproducto());
                         v.setCantidad(lista.get(i).getCantidad());
                         v.setPrecio(lista.get(i).getPrecio());
                         vdao.guardarDetalleventas(v);
                         
                     }
                     
                     break;
                     
                     
                      default:
                          v= new Venta();
                          lista= new ArrayList<>();
                          item=0;
                          totalPagar=0.0;
                          
                        numeroserie = vdao.GenerarSerie();
                    if(numeroserie==null){
                        numeroserie="00000001";
                        request.setAttribute("nserie", numeroserie);
                    }
                    else{
                        int incrementar=Integer.parseInt(numeroserie);
                        GenerarSerie gs =new GenerarSerie();
                        numeroserie=gs.NumeroSerie(incrementar);
                        request.setAttribute("nserie", numeroserie);
                    }
                    
                    
                          request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
             }
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
