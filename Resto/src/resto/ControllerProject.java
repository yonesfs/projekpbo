/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ControllerProject {
    ModelProject modelProject;
    ViewMKN viewMKN;
    ViewMNM viewMNM;
    ViewAdmin viewAdmin;
    ViewPSN viewPSN;
    
    public ControllerProject(ModelProject modelProject, ViewMKN viewMKN){
    this.modelProject = modelProject;
    this.viewMKN = viewMKN;
    
    if(modelProject.getBanyakDataMKN()!=0){
    String dataMKN[][] = modelProject.readMKN();
    viewMKN.tabel.setModel((new JTable(dataMKN, viewMKN.namaKolom)).getModel());
    }
    else{
    JOptionPane.showMessageDialog(null, "Data tidak ada");
    }
    
    viewMKN.btnSimpan.addActionListener(new ActionListener(){
        @Override
    public void actionPerformed (ActionEvent e){
    if((viewMKN.getNom().equals("")
            || viewMKN.getNama().equals("")
            //|| viewMKN.getJenisKel().equals("")
            || viewMKN.getHarga().equals("")
            || viewMKN.getPembayaranVia().equals("")
            || viewMKN.getPedas().equals("")
            //|| viewMKN.getAlamat().equals("")
            //|| viewMKN.getNoHP().equals("")
            //|| viewMKN.getBidang().equals("")
           //|| viewMKN.getAlasan().equals("")
            )){
    JOptionPane.showMessageDialog(null, "Failed tidak boleh kosong");
    }
    else{
    String Nom = viewMKN.getNom();
    String Nama = viewMKN.getNama();
    String Pesanan=(null);
                    if(viewMKN.cbRumah.isSelected()){
                               Pesanan="Rumah";
                    }
                    else if(viewMKN.cbRestoran.isSelected()){
                     Pesanan="Restoran";
                    }
                    
    String Harga = viewMKN.getHarga();
    String PembayaranVia = viewMKN.getPembayaranVia();
    String Pedas = viewMKN.getPedas();
//    String alamat = viewMKN.getAlamat();
//    String nohp = viewMKN.getNoHP();
//    String bidang = viewMKN.getBidang();
//    String alasan = viewMKN.getAlasan();
    
    modelProject.insertMKN(Nom,Nama,Pesanan,Harga,PembayaranVia,Pedas);
    
    String dataMKN[][] = modelProject.readMKN();
    viewMKN.tabel.setModel(new JTable(dataMKN, viewMKN.namaKolom).getModel());
    }
    }
    });
    
    viewMKN.btnRefresh.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            String dataMKN[][] = modelProject.readMKN();
            viewMKN.tabel.setModel(new JTable(dataMKN, viewMKN.namaKolom).getModel());
                
            viewMKN.tfNom.setText(null);
            viewMKN.tfNama.setText(null);
            viewMKN.tfHarga.setText(null);
            viewMKN.tfPembayaranVia.setText(null);
            viewMKN.cbRumah.setText("Rumah");
            viewMKN.cbRestoran.setText("Restoran");
            viewMKN.cmbPedas.setSelectedItem(this);
            viewMKN.tfSearch.setText(null);
            
            
        }
    });
    
        viewMKN.tfSearch.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
        String getSearch= viewMKN.getSearch();
                String dataMKN[][] = modelProject.searchMKN(getSearch);
                    viewMKN.tabel.setModel(new JTable (dataMKN, viewMKN.namaKolom).getModel());
                 }
        }); 
        
    viewMKN.btnHapus.addActionListener((ActionEvent e) -> {
           
                int baris = viewMKN.tabel.getSelectedRow();
                int kolom = viewMKN.tabel.getSelectedColumn();
                String dataterpilih = viewMKN.tabel.getValueAt(baris, 1).toString();
                
                System.out.println(dataterpilih);
                
                int input = JOptionPane.showConfirmDialog(null, "Apakah Anda ingin menghapus NIM "+dataterpilih+ "?"," Pilih Opsi", JOptionPane.YES_NO_CANCEL_OPTION);
                
                if(input==0){
                    modelProject.deleteMKN(dataterpilih);
                    String dataMKN[][] = modelProject.readMKN();
                    viewMKN.tabel.setModel(new JTable(dataMKN, viewMKN.namaKolom).getModel());
                }
                else{
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Hapus");
                }
        });
    
    viewMKN.tabel.addMouseListener(new MouseAdapter(){
        
        @Override
        public void mouseClicked(MouseEvent e){
    
                int baris = viewMKN.tabel.getSelectedRow();
                int kolom = viewMKN.tabel.getSelectedColumn();
                String dataterpilih = viewMKN.tabel.getValueAt(baris, 0).toString();
                String Nom = viewMKN.tabel.getValueAt(baris, 1).toString();
                viewMKN.tfNom.setText(Nom);
                String Nama =viewMKN.tabel.getValueAt(baris, 2).toString();
                viewMKN.tfNama.setText(Nama);
                String Pesanan =viewMKN.tabel.getValueAt(baris, 3).toString();
                 if(Pesanan == "Rumah"){
                             viewMKN.cbRumah.isSelected();
                    }
                    else if(Pesanan=="Restoran"){
                             viewMKN.cbRestoran.isSelected();
                    }
                   
                //viewMKN.tfJenisKel.setText(jenisKel);
                String Harga =viewMKN.tabel.getValueAt(baris, 4).toString();
                viewMKN.tfHarga.setText(Harga);
                String PembayaranVia =viewMKN.tabel.getValueAt(baris, 5).toString();
                viewMKN.tfPembayaranVia.setText(PembayaranVia);
                String Pedas =viewMKN.tabel.getValueAt(baris, 6).toString();
                viewMKN.cmbPedas.setSelectedItem(Pedas);
                
        viewMKN.btnEdit.addActionListener(new ActionListener(){                
             @Override
             public void actionPerformed(ActionEvent e){ 
                  String id = dataterpilih;
                    
                    String Nom = viewMKN.getNom();                 
                    String Nama = viewMKN.getNama();
                    String Pesanan=(null);
                    if(viewMKN.cbRumah.isSelected()){
                             Pesanan="Rumah";
                    }
                    else if(viewMKN.cbRestoran.isSelected()){
                     Pesanan="Restoran";
                    }
    
    //                String  jenisKel= viewMKN.getJenisKel();
                    String Harga = viewMKN.getHarga();
                    String PembayaranVia = viewMKN.getPembayaranVia();
                    String Pedas = viewMKN.getPedas();
                    modelProject.editMKN(Nom, Nama, Pesanan, Harga, PembayaranVia, Pedas);
                

                String dataMKN[][]= modelProject.readMKN();
                viewMKN.tabel.setModel(new JTable(dataMKN, viewMKN.namaKolom).getModel());

     }
        });
    }
       });
       
    
    viewMKN.btnKeluar.addActionListener(new ActionListener(){
        @Override
    public void actionPerformed (ActionEvent e){
        System.exit(0);
    }    
    });
    
    
    
    }
    
 //MINUMAN  
    
    public ControllerProject(ModelProject modelProject, ViewMNM viewMNM){
    this.modelProject = modelProject;
    this.viewMNM = viewMNM;
    
    if(modelProject.getBanyakDataMNM()!=0){
    String dataMNM[][] = modelProject.readMNM();
    viewMNM.tabel.setModel((new JTable(dataMNM, viewMNM.namaKolom)).getModel());
    }
    else{
    JOptionPane.showMessageDialog(null, "Data tidak ada");
    }
    
    viewMNM.btnSimpan.addActionListener(new ActionListener(){
        @Override
    public void actionPerformed (ActionEvent e){
    if((viewMNM.getNom().equals("")
            || viewMNM.getNama().equals("")
            || viewMNM.getPesanan().equals("")
            || viewMNM.getHarga().equals("")
            || viewMNM.getPembayaranVia().equals("")
            || viewMNM.getPedas().equals("")
            )){
    JOptionPane.showMessageDialog(null, "Failed tidak boleh kosong");
    }
    else{
    String Nom = viewMNM.getNom();
    String Nama = viewMNM.getNama();
    String Pesanan=(null);
                    if(viewMNM.cbRumah.isSelected()){
                             Pesanan="Rumah";
                    }
                    else if(viewMNM.cbRestoran.isSelected()){
                     Pesanan="Restoran";
                    }
                    
    //String jeniskel = viewPKK.getJenisKel();
    String Harga = viewMNM.getHarga();
    String PembayaranVia = viewMNM.getPembayaranVia();
    String Pedas = viewMNM.getPedas();
    
    modelProject.insertMNM(Nom,Nama,Pesanan,Harga,PembayaranVia,Pedas);
    /*viewPKK.tfNim.setText("");
    viewPKK.tfNama.setText("");
    viewPKK.tfTempat.setText("");
    viewPKK.tfTgllahir.setText("");
    viewPKK.cmbAgama.setSelectedItem("");
    viewPKK.tfAlamat.setText("");
    viewPKK.tfNoHP.setText("");
    viewPKK.tfBidang.setText("");
    viewPKK.tfAlasan.setText("");*/
    
    String dataMNM[][] = modelProject.readMNM();
    viewMNM.tabel.setModel(new JTable(dataMNM, viewMNM.namaKolom).getModel());
    }
    }
    });
    
    viewMNM.btnRefresh.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            String dataMNM[][] = modelProject.readMNM();
            viewMNM.tabel.setModel(new JTable(dataMNM, viewMNM.namaKolom).getModel());
                
            viewMNM.tfNom.setText(null);
            viewMNM.tfNama.setText(null);
            viewMNM.tfHarga.setText(null);
            viewMNM.tfPembayaranVia.setText(null);
            viewMNM.cbRestoran.setText("Restoran");
            viewMNM.cbRumah.setText("Rumah");
            viewMNM.cmbPedas.setSelectedItem(this);
            viewMNM.tfSearch.setText(null);
            
        }
    });
    
    viewMNM.tfSearch.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
        String getSearch= viewMNM.getSearch();
                String dataMNM[][] = modelProject.searchMNM(getSearch);
                    viewMNM.tabel.setModel(new JTable (dataMNM, viewMNM.namaKolom).getModel());
                 }
        }); 

    
    viewMNM.btnHapus.addActionListener((ActionEvent e) -> {
           
                int baris = viewMNM.tabel.getSelectedRow();
                int kolom = viewMNM.tabel.getSelectedColumn();
                String dataterpilih = viewMNM.tabel.getValueAt(baris, 1).toString();
                
                System.out.println(dataterpilih);
                
                int input = JOptionPane.showConfirmDialog(null, "Apakah Anda ingin menghapus NIM "+dataterpilih+ "?"," Pilih Opsi", JOptionPane.YES_NO_CANCEL_OPTION);
                
                if(input==0){
                    modelProject.deleteMNM(dataterpilih);
                    String dataMNM[][] = modelProject.readMNM();
                    viewMNM.tabel.setModel(new JTable(dataMNM, viewMNM.namaKolom).getModel());
                }
                else{
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Hapus");
                }
        });
    
    viewMNM.tabel.addMouseListener(new MouseAdapter(){
        
        @Override
        public void mouseClicked(MouseEvent e){
    
                int baris = viewMNM.tabel.getSelectedRow();
                int kolom = viewMNM.tabel.getSelectedColumn();
                String dataterpilih = viewMNM.tabel.getValueAt(baris, 0).toString();
                String Nom = viewMNM.tabel.getValueAt(baris, 1).toString();
                viewMNM.tfNom.setText(Nom);
                String nama =viewMNM.tabel.getValueAt(baris, 2).toString();
                viewMNM.tfNama.setText(nama);
                String Pesanan =viewMNM.tabel.getValueAt(baris, 3).toString();
                 if(Pesanan=="Rumah"){
                             viewMNM.cbRumah.isSelected();
                    }
                    else if(Pesanan=="Restoran"){
                             viewMNM.cbRestoran.isSelected();
                    }
                   
                //viewPKK.tfJenisKel.setText(jenisKel);
                String Harga =viewMNM.tabel.getValueAt(baris, 4).toString();
                viewMNM.tfHarga.setText(Harga);
                String PembayaranVia =viewMNM.tabel.getValueAt(baris, 5).toString();
                viewMNM.tfPembayaranVia.setText(PembayaranVia);
                String Pedas =viewMNM.tabel.getValueAt(baris, 6).toString();
                viewMNM.cmbPedas.setSelectedItem(Pedas);
                
        viewMNM.btnEdit.addActionListener(new ActionListener(){                
             @Override
             public void actionPerformed(ActionEvent e){ 
                  String id = dataterpilih;
                    String Nom = viewMNM.getNom();                 
                    String Nama = viewMNM.getNama();
                    String Pesanan=(null);
                    if(viewMNM.cbRumah.isSelected()){
                             Pesanan="Rumah";
                    }
                    else if(viewMNM.cbRestoran.isSelected()){
                     Pesanan="Restoran";
                    }
    
                    String Harga = viewMNM.getHarga();
                    String PembayarnVia = viewMNM.getPembayaranVia();
                    String Pedas = viewMNM.getPedas();
                    modelProject.editMNM(Nom,Nama,Pesanan,Harga,PembayaranVia,Pedas);
                

                String dataMNM[][]= modelProject.readMNM();
                viewMNM.tabel.setModel(new JTable(dataMNM, viewMNM.namaKolom).getModel());

     }
        });
    }
       });
       
    
    viewMNM.btnKeluar.addActionListener(new ActionListener(){
        @Override
    public void actionPerformed (ActionEvent e){
        System.exit(0);
    }    
    });
    
    
    
    }
    
    
    //ADMIN
    public ControllerProject(ModelProject modelProject, ViewAdmin viewAdmin){
    this.modelProject = modelProject;
    this.viewAdmin = viewAdmin;
    
    if(modelProject.getBanyakDataAdmin()!=0){
    String dataAdmin[][] = modelProject.readAdmin();
    viewAdmin.tabel.setModel((new JTable(dataAdmin, viewAdmin.namaKolom)).getModel());
    }
    else{
    JOptionPane.showMessageDialog(null, "Data tidak ada");
    }
    
    viewAdmin.btnSimpan.addActionListener(new ActionListener(){
        @Override
    public void actionPerformed (ActionEvent e){
    if((viewAdmin.getUsername().equals("")
            || viewAdmin.getPassword().equals("")
            )){
    JOptionPane.showMessageDialog(null, "Failed tidak boleh kosong");
    }
    else{
    String username = viewAdmin.getUsername();
    String password = viewAdmin.getPassword();
    
    modelProject.insertAdmin(username, password);
    
    String dataAdmin[][] = modelProject.readAdmin();
    viewAdmin.tabel.setModel(new JTable(dataAdmin, viewAdmin.namaKolom).getModel());
    }
    }
    });
    
    viewAdmin.btnRefresh.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            String dataAdmin[][] = modelProject.readAdmin();
            viewAdmin.tabel.setModel(new JTable(dataAdmin, viewAdmin.namaKolom).getModel());
                
            //viewPKK.tfNim.setText(null);
            viewAdmin.tfUsername.setText(null);
            viewAdmin.tfPassword.setText(null);
            viewAdmin.tfSearch.setText(null);
            
        }
    });
    
    viewAdmin.tfSearch.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
        String getSearch= viewAdmin.getSearch();
                String dataAdmin[][] = modelProject.searchAdmin(getSearch);
                    viewAdmin.tabel.setModel(new JTable (dataAdmin, viewAdmin.namaKolom).getModel());
                 }
        }); 

    
    viewAdmin.btnHapus.addActionListener((ActionEvent e) -> {
           
                int baris = viewAdmin.tabel.getSelectedRow();
                int kolom = viewAdmin.tabel.getSelectedColumn();
                String dataterpilih = viewAdmin.tabel.getValueAt(baris, 1).toString();
                
                System.out.println(dataterpilih);
                
                int input = JOptionPane.showConfirmDialog(null, "Apakah Anda ingin menghapus user "+dataterpilih+ "?"," Pilih Opsi", JOptionPane.YES_NO_CANCEL_OPTION);
                
                if(input==0){
                    modelProject.deleteAdmin(dataterpilih);
                    String dataAdmin[][] = modelProject.readAdmin();
                    viewAdmin.tabel.setModel(new JTable(dataAdmin, viewAdmin.namaKolom).getModel());
                }
                else{
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Hapus");
                }
        });
    
    viewAdmin.tabel.addMouseListener(new MouseAdapter(){
        
        @Override
        public void mouseClicked(MouseEvent e){
    
                int baris = viewAdmin.tabel.getSelectedRow();
                int kolom = viewAdmin.tabel.getSelectedColumn();
                String dataterpilih = viewAdmin.tabel.getValueAt(baris, 0).toString();
                //viewPKK.tfNim.setText(dataterpilih);
                String username =viewAdmin.tabel.getValueAt(baris, 1).toString();
                viewAdmin.tfUsername.setText(username);
                String password =viewAdmin.tabel.getValueAt(baris, 2).toString();
                viewAdmin.tfPassword.setText(password);
                
        viewAdmin.btnEdit.addActionListener(new ActionListener(){                
             @Override
             public void actionPerformed(ActionEvent e){ 
                  String id = dataterpilih;
                    
                   //String dataterpilih = viewAdmin.getID();                 
                    String username = viewAdmin.getUsername();
                    String password = viewAdmin.getPassword();
                    modelProject.editAdmin( username, password, id);
                

                String dataAdmin[][]= modelProject.readAdmin();
                viewAdmin.tabel.setModel(new JTable(dataAdmin, viewAdmin.namaKolom).getModel());

     }
        });
    }
       });
       
    
    viewAdmin.btnKeluar.addActionListener(new ActionListener(){
        @Override
    public void actionPerformed (ActionEvent e){
        System.exit(0);
    }    
    });
    
  }
    
    //Pesanan
     public ControllerProject(ModelProject modelProject, ViewPSN viewPSN){
    this.modelProject = modelProject;
    this.viewPSN = viewPSN;
    
    if(modelProject.getBanyakDataPSN()!=0){
    String dataPSN[][] = modelProject.readPSN();
    viewPSN.tabel.setModel((new JTable(dataPSN, viewPSN.namaKolom)).getModel());
    }
    else{
    JOptionPane.showMessageDialog(null, "Data tidak ada");
    }
    
    viewPSN.btnSimpan.addActionListener(new ActionListener(){
        @Override
    public void actionPerformed (ActionEvent e){
    if((viewPSN.getNom().equals("")
            || viewPSN.getNama().equals("")
            || viewPSN.getPesanan().equals("")
            || viewPSN.getHarga().equals("")
            || viewPSN.getPembayaranVia().equals("")
            )){
    JOptionPane.showMessageDialog(null, "Failed tidak boleh kosong");
    }
    else{
    String Nom = viewPSN.getNom();
    String Nama = viewPSN.getNama();
    String Pesanan=(null);
            if(viewPSN.cbRumah.isSelected()){
            Pesanan="Rumah";
            }
            else if(viewPSN.cbRestoran.isSelected()){
            Pesanan="Restoran";
            } 
    //String angkatan = viewPSN.tfAngkatan.getText();
    String Harga = viewPSN.getHarga();
    String PembayaranVia = viewPSN.getPembayaranVia();
    modelProject.insertPSN(Nom,Nama,Pesanan,Harga,PembayaranVia);
    
    String dataPSN[][] = modelProject.readPSN();
    viewPSN.tabel.setModel(new JTable(dataPSN, viewPSN.namaKolom).getModel());
    }
    }
    });
    
    viewPSN.tfSearch.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
        String getSearch= viewPSN.getSearch();
                String dataPSN[][] = modelProject.searchPSN(getSearch);
                    viewPSN.tabel.setModel(new JTable (dataPSN, viewPSN.namaKolom).getModel());
                 }
        }); 

    
    viewPSN.btnRefresh.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            String dataPSN[][] = modelProject.readPSN();
            viewPSN.tabel.setModel(new JTable(dataPSN, viewPSN.namaKolom).getModel());
                
            //viewPSN.tfAngkatan.setText(null);
            viewPSN.tfNom.setText(null);
            viewPSN.tfNama.setText(null);
            viewPSN.cbRumah.setText("PKK");
            viewPSN.cbRestoran.setText("BAKSOS");
            viewPSN.tfHarga.setText(null);
            viewPSN.tfPembayaranVia.setText(null);
            viewPSN.tfSearch.setText(null);
            
        }
    });
    
    viewPSN.btnHapus.addActionListener((ActionEvent e) -> {
           
                int baris = viewPSN.tabel.getSelectedRow();
                int kolom = viewPSN.tabel.getSelectedColumn();
                String dataterpilih = viewPSN.tabel.getValueAt(baris, 1).toString();
                
                System.out.println(dataterpilih);
                
                int input = JOptionPane.showConfirmDialog(null, "Apakah Anda ingin menghapus NIM "+dataterpilih+ "?"," Pilih Opsi", JOptionPane.YES_NO_CANCEL_OPTION);
                
                if(input==0){
                    modelProject.deletePSN(dataterpilih);
                    String dataPSN[][] = modelProject.readPSN();
                    viewPSN.tabel.setModel(new JTable(dataPSN, viewPSN.namaKolom).getModel());
                }
                else{
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Hapus");
                }
        });
    
    viewPSN.tabel.addMouseListener(new MouseAdapter(){
        
        @Override
        public void mouseClicked(MouseEvent e){
    
                int baris = viewPSN.tabel.getSelectedRow();
                int kolom = viewPSN.tabel.getSelectedColumn();
                String dataterpilih = viewPSN.tabel.getValueAt(baris, 0).toString();
                System.out.println(dataterpilih);
                viewPSN.tfID.setText(dataterpilih);
                
                String Nom = viewPSN.tabel.getValueAt(baris, 1).toString();
                viewPSN.tfNom.setText(Nom);
                //String angkatan =viewPSN.tabel.getValueAt(baris, 2).toString();
                //viewPSN.tfAngkatan.setText(angkatan);
                
                String Nama =viewPSN.tabel.getValueAt(baris, 3).toString();
                viewPSN.tfNama.setText(Nama);
                String Pesanan =viewPSN.tabel.getValueAt(baris, 4).toString();
                if(Pesanan=="Rumah"){
                             viewPSN.cbRumah.isSelected();
                    }
                    else if(Pesanan=="Restoran"){
                             viewPSN.cbRestoran.isSelected();
                    }
                String Harga =viewPSN.tabel.getValueAt(baris, 5).toString();
                viewPSN.tfHarga.setText(Harga);
                String PembayaranVia =viewPSN.tabel.getValueAt(baris, 6).toString();
                viewPSN.tfPembayaranVia.setText(PembayaranVia);
                
        viewPSN.btnEdit.addActionListener(new ActionListener(){                
             @Override
             public void actionPerformed(ActionEvent e){ 
                  String id = dataterpilih;

                    String Nom = viewPSN.getNom();
                    String  Nama= viewPSN.getNama();
                    String Pesanan =(null);
                    if(viewPSN.cbRumah.isSelected()){
                             Pesanan="Rumah";
                    }
                    else if(viewPSN.cbRestoran.isSelected()){
                     Pesanan="Restoran";
                    }
                    String  Harga = viewPSN.getHarga();
                    String  PembayaranVia = viewPSN.getPembayaranVia();
                    modelProject.editPSN(Nom, Nama, Pesanan,Harga,PembayaranVia);
                

                String dataPSN[][]= modelProject.readPSN();
                viewPSN.tabel.setModel(new JTable(dataPSN, viewPSN.namaKolom).getModel());

     }
        });
        
    }
       });
       
    
    viewPSN.btnKeluar.addActionListener(new ActionListener(){
        @Override
    public void actionPerformed (ActionEvent e){
        System.exit(0);
    }    
    });
    
  }
     }
