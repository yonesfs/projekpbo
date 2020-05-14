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
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import java.awt.Toolkit;


public class ViewPSN extends JFrame{
    JLabel lNom = new JLabel(" Nomor Meja : ");
    JTextField tfID = new JTextField();
    JTextField tfNom = new JTextField();
    //JLabel lAngkatan= new JLabel("Angkatan :");
    //JTextField tfAngkatan = new JTextField();
    JLabel lNama = new JLabel(" Nama : ");
    JTextField tfNama = new JTextField();
    JLabel lPesanan = new JLabel(" Makan di ? ");
    JRadioButton cbRumah = new JRadioButton("Rumah");
    JRadioButton cbRestoran = new JRadioButton("Restoran");
    JLabel lHarga = new JLabel(" Harga : ");
    JTextField tfHarga = new JTextField();
    JLabel lPembayaranVia = new JLabel(" PembayaranVia: ");
    JTextField tfPembayaranVia = new JTextField();
    
    JTextField tfSearch = new JTextField();
    JLabel lSearch = new JLabel(" CARI ");
    JButton btnRefresh = new JButton(" REFRESH ");
    JButton btnSimpan = new JButton(" SIMPAN ");
    JButton btnHapus = new JButton(" HAPUS ");
    JButton btnKeluar = new JButton(" KELUAR ");
    JButton btnEdit = new JButton(" EDIT ");
    JButton btnMenu = new JButton(" MENU ");
   
    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    //JScrollPane scrollPane1;
    Object namaKolom[] = {"ID","NIM","Angkatan", "Nama","Event", "Bidang", "Tahun"};
    
    public ViewPSN(){
        setTitle("Pesanan");
        tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable (tableModel);
        scrollPane = new JScrollPane(tabel);
        
        //Background
        getContentPane().setBackground(new java.awt.Color(204, 166, 166));
        lNom.setForeground(Color.white);
        lNama.setForeground(Color.white);
        //lAngkatan.setForeground(Color.white);
        lHarga.setForeground(Color.white);
        lPesanan.setForeground(Color.white);
        lPembayaranVia.setForeground(Color.white);
        lSearch.setForeground(Color.white);
        scrollPane.setBackground(Color.DARK_GRAY);
        
        btnSimpan.setBackground(new java.awt.Color(255, 250, 205));
        btnRefresh.setBackground(new java.awt.Color(255, 250, 205));
        btnHapus.setBackground(new java.awt.Color(255, 250, 205));
        btnKeluar.setBackground(new java.awt.Color(255, 250, 205));
        btnEdit.setBackground(new java.awt.Color(255, 250, 205));
        btnMenu.setBackground(new java.awt.Color(255, 250, 205));
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(900,900);
        Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();
        // membuat titik x dan y
        int x = layar.width / 2  - this.getSize().width / 2;
        int y = layar.height / 2 - this.getSize().height / 2;
        this.setLocation(x, y);
        
        add(tfID);
       add(lNom);
        lNom.setBounds(40,30,200,20);
        add(tfNom);
        tfNom.setBounds(200,30,200,20);
        //add(lAngkatan);
        //lAngkatan.setBounds(40,60,200,20);
        //add(tfAngkatan);
        //tfAngkatan.setBounds(200,60,200,20);
        add(lNama);
        lNama.setBounds(40,90,200,20);
        add(tfNama);
        tfNama.setBounds(200,90,200,20);
        add(lPesanan);
        lPesanan.setBounds(40,120,200,20);
        add(cbRumah);
        cbRumah.setBounds(200,120,100,20);
        add(cbRestoran);
        cbRestoran.setBounds(300,120,100,20);
        add(lHarga);
        lHarga.setBounds(40,150,200,20);
        add(tfHarga);
        tfHarga.setBounds(200,150,200,20);
        add(lPembayaranVia);
        lPembayaranVia.setBounds(40,180,200,20);
        add(tfPembayaranVia);
        tfPembayaranVia.setBounds(200,180,200,20);
        
        add(lSearch);
        lSearch.setBounds(500,250,100,20);
        add(tfSearch);
        tfSearch.setBounds(630,250,100,20);
        add(btnRefresh);
        btnRefresh.setBounds(500,100,100,20);
        add(btnSimpan);
        btnSimpan.setBounds(630,100,100,20);
        add(btnHapus);
        btnHapus.setBounds(500,150,100,20);
        add(btnKeluar);
        btnKeluar.setBounds(630,150,100,20);
        add(btnEdit);
        btnEdit.setBounds(500,200,100,20);
        add(btnMenu);
        btnMenu.setBounds(630,200,100,20);
        
        add(scrollPane);
        scrollPane.setBounds(40,400,750,180);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        btnMenu.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed (ActionEvent e){
        Menuutama menuutama = new Menuutama();   
        dispose();
        }    
        });
   
        tfNom.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String Nom= tfNom.getText();
        String Awal= Nom.substring(0,5);
          System.out.println(Awal);
//        String Angkatan; 
  //      if (null == Awal) {
    //        Angkatan = "tidak diketahui";
      //  } else  switch (Awal) {
        //      case "12316":
          //        Angkatan = "2016";               
            //      break;
              //case "12317":
                //  Angkatan = "2017";
                  //break;
              //case "12318":
               //Angkatan = "2018";
                //  break;
              //default:
               //   Angkatan = "tidak diketahui";
               //break;
          //}
        
       // tfAngkatan.setText(Angkatan);
       
      }
    });
      
        
        setVisible(true);
    }
    
    public String getNom(){
        return tfNom.getText();
    }
    public String getNama(){
        return tfNama.getText();
    }
     public String getPembayaranVia(){
        return tfPembayaranVia.getText();
    }
    public String getHarga(){
        return tfHarga.getText();
    }
    public String getID(){
       return tfID.getText();
   }
   public String getSearch(){
        return tfSearch.getText();
    }

    Object getPesanan() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
