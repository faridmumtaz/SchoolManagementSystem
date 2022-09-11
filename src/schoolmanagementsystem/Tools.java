/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagementsystem;

import java.awt.Toolkit;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author farid
 */
public class Tools {
    public static void setFrameAtMiddle(JFrame frame) {
        double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int frameHeight = frame.getHeight();
        int frameWidth = frame.getWidth();
        int y = ((int)screenHeight - frameHeight)/2;
        int x = ((int)screenWidth - frameWidth)/2;
        frame.setLocation(x,y);
    }
    public static Statement dbConnection() {
        try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sms","root","");
        Statement st = con.createStatement();
        return st;
        }
        catch(Exception e){
            Statement st = null;
            return st;
        }
    }
    public static String passwordToString(JPasswordField jpf){
        String password = "";
        char[] array = jpf.getPassword();
        for(char c : array){
            password += c;  
        } 
        return password;
    }
    
    public static boolean containsChar(String s){
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) < '0' || s.charAt(i) > '9'){
                return true;
            }
        }
        return scoreValidator(s);
    }
    
    public static boolean scoreValidator(String s){
        if(Integer.parseInt(s) > 100 || Integer.parseInt(s)< 0){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static String[] mergeArrays(String[] arr1, String[] arr2){
        int len1 = arr1.length;
        int len2 = arr2.length;
        int i;
        String[] result = new String[len1+len2];
        for(i=0;i<arr1.length;i++){
            result[i] = arr1[i];
        }
        for(int j=0;j<arr2.length;j++){
            result[i++] = arr2[j];
        }
        return result;
    }
}
