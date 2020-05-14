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

public class Menuutama extends JFrame {
   JButton btnMkn = new JButton("MAKANAN");
   JButton btnMnm = new JButton("MINUMAN");
   JButton btnPsn = new JButton("DATA PESANAN");
   JButton btnAdmin = new JButton("ADMIN");
   
public Menuutama(){
setTitle("MENU");
	setDefaultCloseOperation(3);
	setSize(290,300);
        Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();
        // membuat titik x dan y
        int x = layar.width / 2  - this.getSize().width / 2;
        int y = layar.height / 2 - this.getSize().height / 2;
        this.setLocation(x, y);
        
setLayout(null);
        add(btnMkn);
	add(btnMnm);
        add(btnPsn);
	add(btnAdmin);
        
        getContentPane().setBackground(new java.awt.Color(250, 250, 210));
        btnMkn.setBackground(new java.awt.Color(184, 134, 11));
        btnMkn.setForeground(Color.WHITE);
        btnMnm.setBackground(new java.awt.Color(184, 134, 11));
        btnMnm.setForeground(Color.WHITE);
        btnPsn.setBackground(new java.awt.Color(184, 134, 11));
        btnPsn.setForeground(Color.WHITE);
        btnAdmin.setBackground(new java.awt.Color(184, 134, 11));
        btnAdmin.setForeground(Color.WHITE);
        	
        btnMkn.setBounds(65,10,150,40);
        btnMnm.setBounds(65,80,150,40);
        btnPsn.setBounds(65,150,150,40);
        btnAdmin.setBounds(65,210,150,40);


        
        btnMkn.addActionListener(new ActionListener(){
       
             @Override
             public void actionPerformed(ActionEvent e){
                 MVC mvc = new MVC();
                 mvc.MKN();
                 dispose();
             }
        });
        
       btnMnm.addActionListener(new ActionListener(){
       
             @Override
             public void actionPerformed(ActionEvent e){
                        MVC mvc = new MVC();
                        mvc.MNM();
                 
            dispose();
             }
        }); 

        btnPsn.addActionListener(new ActionListener(){
       
             @Override
             public void actionPerformed(ActionEvent e){
                 MVC mvc = new MVC();
                        mvc.PSN();
                 
            dispose();
             }
         }); 
  

        btnAdmin.addActionListener(new ActionListener(){
       
             @Override
             public void actionPerformed(ActionEvent e){
                 MVC mvc = new MVC();
                 mvc.Admin();
                 
            dispose();
             }
        }); 

        setVisible(true);
}   
}
