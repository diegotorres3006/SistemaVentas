/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ClienteDAO {
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    
    public Cliente buscar(String dni){
        Cliente c=new Cliente();
        String sql="select * from cliente where Dni="+dni;
        try {
           con=cn.Conexion();
           ps=con.prepareStatement(sql);
           rs=ps.executeQuery();
            while (rs.next()) {                
                c.setId(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setNom(rs.getString(3));
                c.setDir(rs.getString(4));
                c.setEstado(rs.getString(5));      
                
            }
        } catch (Exception e) {
            
        }
        return c;
    }
    
    
     // Operaciones CRUD
      
     
    public List  listar() {
        System.out.println("Listar cliente");
         String sql="select * from cliente "; 
         List<Cliente>lista=new ArrayList<>();
          try {
              
             con=cn.Conexion();
             ps=con.prepareStatement(sql);
             rs=ps.executeQuery();
              while (rs.next()) {
                  Cliente cl =new Cliente();
                  cl.setId(rs.getInt(1));
                  cl.setDni(rs.getString(2));
                  cl.setNom(rs.getString(3));
                  cl.setDir(rs.getString(4));
                  cl.setEstado(rs.getString(5));
                  
                  lista.add(cl);
  
              }
             
         } catch (Exception e) {
             System.out.println("error listar cliente"+e.getMessage());
         }
         
          return lista;
          
          
          
     }
     
       
     public int agregar(Cliente cl){
           System.out.println("Agregar cliente");
         String sql="insert into cliente(Dni, Nombres, Direccion, Estado)values(?,?,?,?)";
         
         try {
             con=cn.Conexion();
             ps=con.prepareStatement(sql);
             ps.setString(1, cl.getDni());
             ps.setString(2, cl.getNom());
             ps.setString(3, cl.getDir());
             ps.setString(4, cl.getEstado());
            
             
             ps.executeUpdate();
             
         } catch (Exception e) {
             System.out.println("error");
         }
         
         return r;
         
     }
     public Cliente listarId(int id){
         Cliente cli =new Cliente();
         String sql="select * from cliente where IdCliente="+id;
         try {
             con=cn.Conexion();
             ps=con.prepareStatement(sql);
             rs=ps.executeQuery();
             while (rs.next()) {                 
                   cli.setDni(rs.getString(2));
                   cli.setNom(rs.getString(3));
                   cli.setDir(rs.getString(4));
                   cli.setEstado(rs.getString(5));
                   
                 
             }
         } catch (Exception e) {
             System.out.println("error");
         }
         
         return cli;
         
     }
     
      public int actualizar(Cliente cl){
           String sql="update cliente set Dni=?, Nombres=?, Direccion=?, Estado=? where IdCliente=?";
         
         try {
             con=cn.Conexion();
             ps=con.prepareStatement(sql);
             ps.setString(1, cl.getDni());
             ps.setString(2, cl.getNom());
             ps.setString(3, cl.getDir());
             ps.setString(4, cl.getEstado());
           
             ps.setInt(5, cl.getId());
             ps.executeUpdate();
             
         } catch (Exception e) {
             System.out.println("error actualizar"+e.getMessage());
         }
         
         return r;
          
      }
     public void delete(int id ){
         
         String sql = "delete from cliente where IdCliente="+id;
         try {
             con=cn.Conexion();
             ps=con.prepareStatement(sql);
             ps.executeUpdate();
             
         } catch (Exception e) {
             System.out.println("error en delete cliente: "+e.getMessage());
         }
     }
      
}
