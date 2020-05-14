/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

class ModelProject {
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/project_prakpbo";
    static final String USER = "root"; 
    static final String PASS = "";  
    
    Connection con;
    Statement stm;
    
    
    public ModelProject() {
        try{
            Class.forName(JDBC_DRIVER);
            con = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Koneksi Berhasil!");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi gagal");
        }
    }
    
    public void insertMakanan(String Nom, String Nama, String Pesanan, String Harga, String PembayaranVia, String Pedas){
    try{
        String query = "INSERT INTO `makanan` (`Nom`, `Nama`, `Pesanan`, `Harga`, `PembayaranVia`, `Pedas`) VALUES ('"+Nom+"', '"+Nama+"','"+Pesanan+"', '"+Harga+"', '"+PembayaranVia+"', '"+Pedas+"')";
        stm = (Statement) con.createStatement();
        stm.executeUpdate(query);
        System.out.println("Berhasil Ditambahkan");
        JOptionPane.showMessageDialog(null, "Data berhasil ditambah");
        }
    catch(Exception sql){
        System.out.println(sql.getMessage());
        JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public String[][] readMakanan(){
    try{
        int jmlData = 0;
        String data[][] = new String[getBanyakDataMakanan()][11];
        String query = "Select * from `makanan`";
        ResultSet resultSet = stm.executeQuery(query);
        while (resultSet.next()){
        data[jmlData][0] = resultSet.getString("ID");
        data[jmlData][1] = resultSet.getString("Nomor Meja");
        data[jmlData][2] = resultSet.getString("Nama");
        data[jmlData][3] = resultSet.getString("Pesanan");
        data[jmlData][4] = resultSet.getString("Harga");
        data[jmlData][5] = resultSet.getString("PembayaranVia");
        data[jmlData][6] = resultSet.getString("Pedas");
        jmlData++;
    }
    return data;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL Error");
        return null;
    }
    }
    
    public int getBanyakDataMakanan(){
        int jmlData = 0;
    try{
        stm = con.createStatement();
        String query = "Select * from `makanan`";
        ResultSet resultSet = stm.executeQuery(query);
        while(resultSet.next()){
            jmlData++;
            }
        return jmlData;
        }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL Error");
        return 0;
        }
    }
    
    public void deleteMakanan (String Nom){
    try{
    String query = "DELETE FROM `makanan` WHERE `Nom` = '"+Nom+"'";
    stm = con.createStatement();
    stm.executeUpdate(query);
    JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
    }
    catch(SQLException sql){
        System.out.println(sql.getMessage());
    }
    }
    
    public void editMakanan(String Nom, String Nama, String Pesanan, String Harga, String PembayaranVia, String Pedas) {                                         
       
        try {
      
 String query ="UPDATE `makanan` SET `Nom` = '"+Nom+"', `Nama` = '"+Nama+"',`Pesanan` = '"+Pesanan+"',`Harga`= '"+Harga+"',`PembayaranVia` = '"+PembayaranVia+"',`Pedas`= '"+Pedas+"') WHERE (`Nom` = '"+ Nom+"'";
        stm = (Statement) con.createStatement();
        stm.executeUpdate(query);
        JOptionPane.showMessageDialog(null, "data berhasil di edit");
                       
        } catch(SQLException sql){
            System.out.println(sql.getMessage());
    }
    } 

    
    public int getBanyakDataSearchMakanan(String getSearch){
    int jmlData=0;
    try{
        stm = con.createStatement();
        String query ="Select * from `makanan` where `Nom` like '%"+getSearch+"%'";
        ResultSet resultSet =stm.executeQuery(query);
        while(resultSet.next()){
            jmlData++;
        }
        return jmlData;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL ERROR");
        return 0;
    }
}

public String[][] searchMakanan(String getSearch){
    try{
        
        int jmlData = 0;
        String data[][]= new String[getBanyakDataSearchMakanan(getSearch)][11];
        String query="Select * from `makanan` where `Nom` like '%"+getSearch+"%'";
        ResultSet resultSet =stm.executeQuery(query);
        while(resultSet.next()){
        data[jmlData][0] = resultSet.getString("ID");
        data[jmlData][1] = resultSet.getString("Nomor Meja");
        data[jmlData][2] = resultSet.getString("Nama");
        data[jmlData][3] = resultSet.getString("Pesanan");
        data[jmlData][4] = resultSet.getString("Harga");
        data[jmlData][5] = resultSet.getString("PembayaranVia");
        data[jmlData][6] = resultSet.getString("Pedas");
        jmlData++;
        }
        
        return data;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL ERROR");
        return null;
    }
}



public void insertMinuman(String Nom, String Nama, String Pesanan, String Harga, String PembayaranVia, String Pedas){
    try{
        String query = "INSERT INTO `minuman` (`Nom`, `Nama`, `Pesanan`, `Harga`, `PembayaranVia`, `Pedas`) VALUES ('"+Nom+"', '"+Nama+"','"+Pesanan+"', '"+Harga+"', '"+PembayaranVia+"', '"+Pedas+"')";
        stm = (Statement) con.createStatement();
        stm.executeUpdate(query);
        System.out.println("Berhasil Ditambahkan");
        JOptionPane.showMessageDialog(null, "Data berhasil ditambah");
        }
    catch(Exception sql){
        System.out.println(sql.getMessage());
        JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public String[][] readMinuman(){
    try{
        int jmlData = 0;
        String data[][] = new String[getBanyakDataMinuman()][11];
        String query = "Select * from `minuman`";
        ResultSet resultSet = stm.executeQuery(query);
        while (resultSet.next()){
        data[jmlData][0] = resultSet.getString("ID");
        data[jmlData][1] = resultSet.getString("Nomor Meja");
        data[jmlData][2] = resultSet.getString("Nama");
        data[jmlData][3] = resultSet.getString("Pesanan");
        data[jmlData][4] = resultSet.getString("Harga");
        data[jmlData][5] = resultSet.getString("PembayaranVia");
        data[jmlData][6] = resultSet.getString("Pedas");
        jmlData++;
    }
    return data;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL Error");
        return null;
    }
    }
    
    public int getBanyakDataMinuman(){
        int jmlData = 0;
    try{
        stm = con.createStatement();
        String query = "Select * from `minuman`";
        ResultSet resultSet = stm.executeQuery(query);
        while(resultSet.next()){
            jmlData++;
            }
        return jmlData;
        }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL Error");
        return 0;
        }
    }
    
    public void deleteMinuman (String Nom){
    try{
    String query = "DELETE FROM `minuman` WHERE `Nom` = '"+Nom+"'";
    stm = con.createStatement();
    stm.executeUpdate(query);
    JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
    }
    catch(SQLException sql){
        System.out.println(sql.getMessage());
    }
    }
    
    public void editMinuman(String Nom, String Nama, String Pesanan, String Harga, String PembayaranVia, String Pedas) {                                         
       
        try {
      
 String query ="UPDATE `minuman` SET `Nom` = '"+Nom+"', `Nama` = '"+Nama+"',`Pesanan` = '"+Pesanan+"',`Harga`= '"+Harga+"',`TPembayaranVia` = '"+PembayaranVia+"',`Pedas`= '"+Pedas+"'"+ "WHERE `Nom` = '"+ Nom+"'";
        stm = (Statement) con.createStatement();
        stm.executeUpdate(query);
        JOptionPane.showMessageDialog(null, "data berhasil di edit");
                       
        } catch(SQLException sql){
            System.out.println(sql.getMessage());
    }
    }

    
    public int getBanyakDataSearchMinuman(String getSearch){
    int jmlData=0;
    try{
        stm = con.createStatement();
        String query ="Select * from `minuman` where `Nom` like '%"+getSearch+"%'";
        ResultSet resultSet =stm.executeQuery(query);
        while(resultSet.next()){
            jmlData++;
        }
        return jmlData;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL ERROR");
        return 0;
    }
}


public String[][] searchMinuman(String getSearch){
    try{
        
        int jmlData = 0;
        String data[][]= new String[getBanyakDataSearchMinuman(getSearch)][11];
        String query="Select * from `minuman` where `NIM` like '%"+getSearch+"%'";
        ResultSet resultSet =stm.executeQuery(query);
        while(resultSet.next()){
        data[jmlData][0] = resultSet.getString("ID");
        data[jmlData][1] = resultSet.getString("Nomor Meja");
        data[jmlData][2] = resultSet.getString("Nama");
        data[jmlData][3] = resultSet.getString("Pesanan");
        data[jmlData][4] = resultSet.getString("Harga");
        data[jmlData][5] = resultSet.getString("PembayaranVia");
        data[jmlData][6] = resultSet.getString("Pedas");
        jmlData++;
        }
        
        return data;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL ERROR");
        return null;
    }
}

public void insertAdmin(String username, String password){
    try{
        String query = "INSERT INTO `admin` (`Username`, `Password`) VALUES ('"+username+"', '"+password+"')";
        stm = (Statement) con.createStatement();
        stm.executeUpdate(query);
        System.out.println("Berhasil Ditambahkan");
        JOptionPane.showMessageDialog(null, "Data berhasil ditambah");
        }
    catch(Exception sql){
        System.out.println(sql.getMessage());
        JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public String[][] readAdmin(){
    try{
        int jmlData = 0;
        String data[][] = new String[getBanyakDataAdmin()][3];
        String query = "Select * from `admin`";
        ResultSet resultSet = stm.executeQuery(query);
        while (resultSet.next()){
        data[jmlData][0] = resultSet.getString("ID");
        data[jmlData][1] = resultSet.getString("Username");
        data[jmlData][2] = resultSet.getString("Password");
        jmlData++;
    }
    return data;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL Error");
        return null;
    }
    }
    
    public int getBanyakDataAdmin(){
        int jmlData = 0;
    try{
        stm = con.createStatement();
        String query = "Select * from `admin`";
        ResultSet resultSet = stm.executeQuery(query);
        while(resultSet.next()){
            jmlData++;
            }
        return jmlData;
        }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL Error");
        return 0;
        }
    }
    
public int getBanyakDataSearchAdmin(String getSearch){
    int jmlData=0;
    try{
        stm = con.createStatement();
        String query ="Select * from `admin` where `Username` like '%"+getSearch+"%'";
        ResultSet resultSet =stm.executeQuery(query);
        while(resultSet.next()){
            jmlData++;
        }
        return jmlData;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL ERROR");
        return 0;
    }
}


public String[][] searchAdmin(String getSearch){
    try{
        
        int jmlData = 0;
        String data[][]= new String[getBanyakDataSearchAdmin(getSearch)][10];
        String query="Select * from `admin` where `Username` like '%"+getSearch+"%'";
        ResultSet resultSet =stm.executeQuery(query);
        while(resultSet.next()){
            data[jmlData][0] = resultSet.getString("ID");
        data[jmlData][1] = resultSet.getString("Username");
        data[jmlData][2] = resultSet.getString("Password");
        jmlData++;
        }
        
        return data;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL ERROR");
        return null;
    }
}
    
    
    public void deleteAdmin (String username){
    try{
    String query = "DELETE FROM `admin` WHERE `Username` = '"+username+"'";
    stm = con.createStatement();
    stm.executeUpdate(query);
    JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
    }
    catch(SQLException sql){
        System.out.println(sql.getMessage());
    }
    }

    public void editAdmin(String username, String password, String id) {                                         
       
        try {
      
 String query ="UPDATE `admin` SET `Username` = '"+username+"', `Password` = '"+password+"' WHERE `Username` = '"+username+"'";
        stm = (Statement) con.createStatement();
        stm.executeUpdate(query);
        JOptionPane.showMessageDialog(null, "data berhasil di edit");
                       
        } catch(SQLException sql){
            System.out.println(sql.getMessage());
    }
    }

    
    public void insertPesanan(String Nom, String Nama, String Pesanan, String Harga, String PembayaranVia, String Pedas){
    try{
        String query = "INSERT INTO `Pesanan` (`Nom`,`Nama`, `Pesanan`, `Harga`, `PembayaranVia`) VALUES ('"+Nom+"', '"+Nama+"', '"+Pesanan+"', '"+Harga+"','"+PembayaranVia+"')";
        stm = (Statement) con.createStatement();
        stm.executeUpdate(query);
        System.out.println("Berhasil Ditambahkan");
        JOptionPane.showMessageDialog(null, "Data berhasil ditambah");
        }
    catch(Exception sql){
        System.out.println(sql.getMessage());
        JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    
    public String[][] readPesanan(){
    try{
        int jmlData = 0;
        String data[][] = new String[getBanyakDataPesanan()][7];
        String query = "Select * from `pesanan`";
        ResultSet resultSet = stm.executeQuery(query);
        while (resultSet.next()){
        data[jmlData][0] = resultSet.getString("Nom");
        data[jmlData][1] = resultSet.getString("Nama");
        data[jmlData][2] = resultSet.getString("Pesanan");
        data[jmlData][3] = resultSet.getString("Harga");
        data[jmlData][4] = resultSet.getString("PembayaranVia");
        jmlData++;
    }
    return data;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL Error");
        return null;
    }
    }
    
    public int getBanyakDataPesanan(){
        int jmlData = 0;
    try{
        stm = con.createStatement();
        String query = "Select * from `pesanan`";
        ResultSet resultSet = stm.executeQuery(query);
        while(resultSet.next()){
            jmlData++;
            }
        return jmlData;
        }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL Error");
        return 0;
        }
    }
    
    public int getBanyakDataSearchPesanan(String getSearch){
    int jmlData=0;
    try{
        stm = con.createStatement();
        String query ="Select * from `pesanan` where `Nom` like '%"+getSearch+"%'";
        ResultSet resultSet =stm.executeQuery(query);
        while(resultSet.next()){
            jmlData++;
        }
        return jmlData;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL ERROR");
        return 0;
    }
}


public String[][] searchPesanan(String getSearch){
    try{
        
        int jmlData = 0;
        String data[][]= new String[getBanyakDataSearchPesanan(getSearch)][10];
        String query="Select * from `pesanan` where `Nom` like '%"+getSearch+"%'";
        ResultSet resultSet =stm.executeQuery(query);
        while(resultSet.next()){
        data[jmlData][0] = resultSet.getString("Nom");
        data[jmlData][1] = resultSet.getString("Nama");
        data[jmlData][2] = resultSet.getString("Pesanan");
        data[jmlData][3] = resultSet.getString("Harga");
        data[jmlData][4] = resultSet.getString("PembayaranVia");
        jmlData++;
        }
        
        return data;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL ERROR");
        return null;
    }
}

    
    public void deleteLalu (String Nom){
    try{
    String query = "DELETE FROM `lalu` WHERE `Nom` = '"+Nom+"'";
    stm = con.createStatement();
    stm.executeUpdate(query);
    JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
    }
    catch(SQLException sql){
        System.out.println(sql.getMessage());
    }
    }

    public void editLalu(String Nom, String Nama, String Pesanan, String Harga, String PembayaranVia, String Pedas) {                                         
       
        try {
      
 String query ="UPDATE `lalu` SET `Nom` = '"+Nom+"', `Nama` = '"+Nama+"', `Nama` = '"+Nama+"', `Pesanan` = '"+Pesanan+"', `Harga` = '"+Harga+"', `PembayaranVia` = '"+PembayaranVia+"' WHERE `Nom` = '"+Nom+"'";
        stm = (Statement) con.createStatement();
        stm.executeUpdate(query);
        JOptionPane.showMessageDialog(null, "data berhasil di edit");
                       
        } catch(SQLException sql){
            System.out.println(sql.getMessage());
    }
    }

    int getBanyakDataMKN() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String[][] readMKN() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void insertMKN(String Nom, String Nama, String Pesanan, String Harga, String PembayaranVia, String Pedas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String[][] searchMKN(String search) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void deleteMKN(String dataterpilih) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void editMKN(String Nom, String Nama, String Pesanan, String Harga, String PembayaranVia, String Pedas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    int getBanyakDataMNM() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String[][] readMNM() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void insertMNM(String Nom, String Nama, String Pesanan, String Harga, String PembayaranVia, String Pedas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String[][] searchMNM(String search) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void deleteMNM(String dataterpilih) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void editMNM(String Nom, String Nama, String Pesanan, String Harga, String PembayaranVia, String Pedas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    int getBanyakDataPSN() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String[][] readPSN() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void editPSN(String nim, String angkatan, String nama, String event, String bidang, String tahun, String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void editPSN(String Nom, String Nama, String Pesanan, String Harga, String PembayaranVia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void insertPSN(String Nom, String Nama, String Pesanan, String Harga, String PembayaranVia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String[][] searchPSN(String search) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void deletePSN(String dataterpilih) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}