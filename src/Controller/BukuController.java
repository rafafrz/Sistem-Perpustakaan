/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOPerpustakaan;
import DAOInterface.IPerpustakaan;
import Model.Buku;
import javax.swing.JOptionPane;
import java.util.List;

/**
 *
 * @author ASUS VIVOBOOK
 */
public class BukuController {
    private IPerpustakaan daoBuku;  
    private List<Buku> daftarBuku;

    public BukuController() {
        daoBuku = new DAOPerpustakaan(); 
        loadDariDatabase();
    }

    public void tambahBuku(Buku buku) {
        daoBuku.tambahBuku(buku); 
        loadDariDatabase();        
        JOptionPane.showMessageDialog(null, "Buku berhasil ditambahkan ke database.");
    }
    
    public void HapusBuku(String penerbit) {
       Buku buku = new Buku();       
       buku.setPenerbit(penerbit);           
       boolean berhasil = daoBuku.hapusBuku(buku);  
       if (berhasil) {
           loadDariDatabase();
           JOptionPane.showMessageDialog(null, "Buku berhasil dihapus dari database.");
       } else {
           JOptionPane.showMessageDialog(null, "Gagal menghapus buku dari database.");
       }
   }
    
    public void loadDariDatabase() {
        daftarBuku = daoBuku.getAllBuku(); 
    }

    public List<Buku> getDaftarBuku() {
        return daftarBuku;
    }
}