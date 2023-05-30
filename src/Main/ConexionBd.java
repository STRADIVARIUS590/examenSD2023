/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author cdsi2
 */
public class ConexionBd {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    public ConexionBd(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/database", "root", "");
            st = con.createStatement();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public ResultSet consultar(String tabla){
        try{
            String query = ("SELECT * FROM " + tabla);
            rs = st.executeQuery(query); 
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return rs;
    }
    
    public void editar(int id, String newName, double newPrice) {
        String name = getName(id);
        String message = "";
        try {
            String query = "UPDATE products SET name = '" + newName + "', price = " + newPrice + " WHERE id = " + id;
            st.executeUpdate(query);
            
            //mensaje
            message = "El producto " + name + " ha sido modificado";
            System.out.println(message);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        Console3.notify(message);
    }
    
    public String getName(int id) {
        String name = null;
        try {
            String query = "SELECT name FROM products WHERE id = " + id;
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                name = rs.getString("name");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return name;
    }
}
