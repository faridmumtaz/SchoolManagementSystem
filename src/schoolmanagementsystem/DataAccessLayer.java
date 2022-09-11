/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author farid
 */
public class DataAccessLayer {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    public DataAccessLayer(){
    try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        con = DriverManager.getConnection("jdbc:mysql://localhost/sms","root","");
        st = con.createStatement();
        }
        catch(SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e){
            javax.swing.JOptionPane.showMessageDialog(null, "ERR:401 - Unable to connect to database");
            System.out.println(e.getMessage());
        }
    }
    //useful for loging in
    public ResultSet doLogin(String username, String password){
        try{
        rs = st.executeQuery("SELECT * FROM admin WHERE username = '" + username + "' AND password = '" + password + "'");
        return rs;
        }
        catch(SQLException e){
            javax.swing.JOptionPane.showMessageDialog(null, "ERR:402 - Unable to connect to database");
            System.out.println(e.getMessage());
            return null;
        }
    }
    // useful for inserting records
    public boolean insertRecords(String command){
        try{
        if(st.executeUpdate(command) == 1){
            return true;
        }
        else{
            return false;
        }
        }
        catch(SQLException e){
            javax.swing.JOptionPane.showMessageDialog(null, "ERR:403 - Unable to insert the record");
            System.out.println(e.getMessage());
            return false;
        }
    }
    // useful for select statement
    public ResultSet selectRecords(String command){
        try{
            return st.executeQuery(command);
        }
        catch(SQLException e){
            javax.swing.JOptionPane.showMessageDialog(null, "ERR:404 - Unable to fetch records");
            System.out.println(e.getMessage());
            return null;
        }
    }
    //useful for delete records
    public int deleteRecords(String table, int id){
        try{
            return st.executeUpdate("DELETE FROM " + table + " WHERE student_id =" + id);            
        }
        catch(SQLException e){
            javax.swing.JOptionPane.showMessageDialog(null, "ERR:405 - Unable to delete the record");
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public int updateRecords(String command){
        try{
            return st.executeUpdate(command);
        }
        catch(SQLException e){
            javax.swing.JOptionPane.showMessageDialog(null, "ERR:406 - Unable to update the record");
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public int deleteRecords(String command){
        try{
            return st.executeUpdate(command);
        }
        catch(SQLException e){
            javax.swing.JOptionPane.showMessageDialog(null, "ERR:404 - Unable to fetch records");
            System.out.println(e.getMessage());
            return -1;
        }
    }
}
