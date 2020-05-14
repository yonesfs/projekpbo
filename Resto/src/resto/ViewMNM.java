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
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import java.awt.Toolkit;

public class ViewMNM extends JFrame{
    JLabel lNom = new JLabel(" Nomor Meja: ");
    JTextField tfNom = new JTextField();
    JLabel lNama = new JLabel(" Nama Minuman : ");
    JTextField tfNama = new JTextField();
    JLabel lPesanan = new JLabel(" Makan di ? ");
    JRadioButton cbRumah = new JRadioButton("Rumah");
    JRadioButton cbRestoran = new JRadioButton("Restoran");
    JLabel lHarga = new JLabel(" Harga Kejujuran : ");
    JTextField tfHarga = new JTextField();
    JLabel lPembayaranVia = new JLabel(" Pembayaran Via : ");
    JTextField tfPembayaranVia = new JTextField();
    JLabel lPedas = new JLabel(" Dingin ? ");
    String[] tingkatPedas =
        {"Panas", "Hangat", "Dingin"};
    JComboBox cmbPedas = new JComboBox(tingkatPedas);
    
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
     Object namaKolom[] = {"ID","NomorMeja", "Nama Makanan", "Minum Di ?", "Harga Kejujuran", "Pembayaran Via", "Tingkat Kepedasan"};
    
        public ViewMNM(){
        setTitle("Makanan. ");
        tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable (tableModel);
        scrollPane = new JScrollPane(tabel);
        //scrollPane1 = new JScrollPane(tfAlasan);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(900,800);
        
        //Background
        getContentPane().setBackground(new java.awt.Color(204, 166, 166));
        lNom.setForeground(Color.white);
        lNama.setForeground(Color.white);
        lPesanan.setForeground(Color.white);
        lHarga.setForeground(Color.white);
        lPembayaranVia.setForeground(Color.white);
        lPedas.setForeground(Color.white);
        lSearch.setForeground(Color.white);
        scrollPane.setBackground(Color.DARK_GRAY);
        
        btnSimpan.setBackground(new java.awt.Color(255, 250, 205));
        btnRefresh.setBackground(new java.awt.Color(255, 250, 205));
        btnHapus.setBackground(new java.awt.Color(255, 250, 205));
        btnKeluar.setBackground(new java.awt.Color(255, 250, 205));
        btnEdit.setBackground(new java.awt.Color(255, 250, 205));
        btnMenu.setBackground(new java.awt.Color(255, 250, 205));
        
        
        Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();
        // membuat titik x dan y
        int x = layar.width / 2  - this.getSize().width / 2;
        int y = layar.height / 2 - this.getSize().height / 2;
        this.setLocation(x, y);
        
        add(lNom);
        lNom.setBounds(40,30,200,20);
        add(tfNom);
        tfNom.setBounds(200,30,200,20);
        add(lNama);
        lNama.setBounds(40,60,200,20);
        add(tfNama);
        tfNama.setBounds(200,60,200,20);
        add(lPesanan);
        lPesanan.setBounds(40,90,200,20);
        add(cbRumah);
        cbRumah.setBounds(200,90,100,20);
        add(cbRestoran);
        cbRestoran.setBounds(300,90,100,20);
        add(lHarga);
        lHarga.setBounds(40,120,200,20);
        add(tfHarga);
        tfHarga.setBounds(200,120,200,20);
        add(lPembayaranVia);
        lPembayaranVia.setBounds(40,150,200,20);
        add(tfPembayaranVia);
        tfPembayaranVia.setBounds(200,150,200,20);
        add(lPedas);
        lPedas.setBounds(40,180,200,20);
        add(cmbPedas);
        cmbPedas.setBounds(200,180,200,20);
        
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
   
        
        
        setVisible(true);
    }
    
    
    public String getNom(){
        return tfNom.getText();
    }
    public String getNama(){
        return tfNama.getText();
    }
    /*public String getJenisKel(){
       if(cbPria.isSelected())
            return cbPria.getText();
        else if(cbWanita.isSelected())
            return cbWanita.getText();
        else
            return null;
    }*/
     public String getHarga(){
        return tfHarga.getText();
    }
    public String getPembayaranVia(){
        return tfPembayaranVia.getText();
    }
    public String getPedas(){
        return cmbPedas.getSelectedItem().toString();
    }

    Object getPesanan() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String getSearch() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}