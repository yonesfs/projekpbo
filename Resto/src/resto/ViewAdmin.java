/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resto;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import java.awt.Toolkit;

public class ViewAdmin extends JFrame{
    JLabel lUsername = new JLabel(" Username : ");
    JTextField tfUsername = new JTextField();
    JLabel lPassword = new JLabel(" Password : ");
    JTextField tfPassword = new JTextField();
    JTextField tfSearch = new JTextField();
    JLabel lSearch = new JLabel(" CARI ");
    
    JButton btnSimpan = new JButton(" SIMPAN ");
    JButton btnHapus = new JButton(" HAPUS ");
    JButton btnKeluar = new JButton(" KELUAR ");
    JButton btnEdit = new JButton(" EDIT ");
    JButton btnMenu = new JButton(" MENU ");
    JButton btnRefresh = new JButton(" REFRESH ");
   
    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"ID","Username", "Password"};
    
    public ViewAdmin(){
        setTitle("Admin");
        tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable (tableModel);
        scrollPane = new JScrollPane(tabel);
        
        //Background
        getContentPane().setBackground(new java.awt.Color(204, 166, 166));
        lUsername.setForeground(Color.white);
        lPassword.setForeground(Color.white);
        lSearch.setForeground(Color.white);
        btnSimpan.setBackground(new java.awt.Color(255, 250, 205));
        btnRefresh.setBackground(new java.awt.Color(255, 250, 205));
        btnHapus.setBackground(new java.awt.Color(255, 250, 205));
        btnKeluar.setBackground(new java.awt.Color(255, 250, 205));
        btnEdit.setBackground(new java.awt.Color(255, 250, 205));
        btnMenu.setBackground(new java.awt.Color(255, 250, 205));
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(800,600);
        Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();
        // membuat titik x dan y
        int x = layar.width / 2  - this.getSize().width / 2;
        int y = layar.height / 2 - this.getSize().height / 2;
        this.setLocation(x, y);
        
        add(lUsername);
        lUsername.setBounds(40,30,200,20);
        add(tfUsername);
        tfUsername.setBounds(200,30,200,20);
        add(lPassword);
        lPassword.setBounds(40,60,200,20);
        add(tfPassword);
        tfPassword.setBounds(200,60,200,20);
        add(lSearch);
        lSearch.setBounds(60,150,100,20);
        add(tfSearch);
        tfSearch.setBounds(140,150,100,20);
        add(btnSimpan);
        btnSimpan.setBounds(40,90,110,20);
        add(btnHapus);
        btnHapus.setBounds(170,90,110,20);
        add(btnRefresh);
        btnRefresh.setBounds(290,90,110,20);
        add(btnKeluar);
        btnKeluar.setBounds(290,120,110,20);
        add(btnEdit);
        btnEdit.setBounds(40,120,110,20);
        add(btnMenu);
        btnMenu.setBounds(170,120,110,20);
        
        
        add(scrollPane);
        scrollPane.setBounds(40,200,300,100);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
         btnMenu.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed (ActionEvent e){
        Menuutama menuutama = new Menuutama();   
        dispose();
        }    
        });
   
        setVisible(true);
    }
    
    public String getUsername(){
        return tfUsername.getText();
    }
    public String getPassword(){
        return tfPassword.getText();
    }
    public String getSearch(){
        return tfSearch.getText();
    }
}
