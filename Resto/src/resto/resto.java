/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class resto {

        public static void main(String[] args) {
        GUI g = new GUI();
        //MVC_Daftarfilm mvcp = new MVC_Daftarfilm();
    }
}
class GUI extends JFrame {
    Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
    
   final JTextField fnama = new JTextField(10);
   final JPasswordField fpass = new JPasswordField(10);

   JLabel lnama = new JLabel(" Nama Pengguna : ");
   JLabel lpass = new JLabel(" Kata Sandi ");
   JButton btnSave = new JButton("Login");
  
public GUI() {
   
setTitle("Login");
	setDefaultCloseOperation(3);
	setSize(350,200);
        setLocation(500,275);
        
        
        getContentPane().setBackground(new java.awt.Color(175, 238, 238));
        btnSave.setBackground(new java.awt.Color(70, 130, 180));
        btnSave.setForeground(new java.awt.Color(224, 255, 255));
        
setLayout(null);
	add(lnama);
	add(fnama);
        add(lpass);
	add(fpass);
        add(btnSave);
   
   
        lnama.setBounds(10,10,120,20);
        fnama.setBounds(140,10,150,20);
        lpass.setBounds(10,45,120,20);
        fpass.setBounds(140,45,150,20);
        btnSave.setBounds(120,100,100,40);

        
        btnSave.addActionListener(new ActionListener(){
       
             @Override
             public void actionPerformed(ActionEvent e){
                 if(fnama.getText().length()>0){
                koneksi DB = new koneksi();
                DB.config();
                con = DB.con;
                stat = DB.stm;
                                   try {
                    sql = "SELECT * FROM admin WHERE Username='"+fnama.getText()+"' AND Password='"+fpass.getText()+"'";
                    rs = stat.executeQuery(sql);
                    if(rs.next()){
                        if(fnama.getText().equals(rs.getString("Username")) && fpass.getText().equals(rs.getString("password"))){
                            JOptionPane.showMessageDialog(null, "berhasil login");
                            System.out.println("Koneksi berhasil");
                            Menuutama menu = new Menuutama();
                        }
                    }else{
                            JOptionPane.showMessageDialog(null, "username atau password salah");
                            resto login = new resto();
                        }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
               System.out.println("Koneksi gagal"); }
                             
                 }
            dispose();
             }
   });
        
               
        setVisible(true);
}
}
    
