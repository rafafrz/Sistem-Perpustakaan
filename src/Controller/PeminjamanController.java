/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Peminjaman;
import DAO.DAOPerpustakaan;
import DAOInterface.IPerpustakaan;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS VIVOBOOK
 */
public class PeminjamanController {
    private IPerpustakaan dao;

    public PeminjamanController() {
        dao = new DAOPerpustakaan(); 
    }

    public void tambahPeminjaman(Peminjaman peminjaman) {
        dao.tambahPeminjaman(peminjaman);
    }
    
    public void HapusPeminjaman(int id) {
       Peminjaman peminjaman = new Peminjaman();       
       peminjaman.setIdBuku(id);           
       boolean berhasil = dao.hapusPeminjaman(peminjaman);  
       if (berhasil) {
           loadDariDatabase();
           JOptionPane.showMessageDialog(null, "Buku berhasil dihapus dari database.");
       } else {
           JOptionPane.showMessageDialog(null, "Gagal menghapus buku dari database.");
       }
   }
    
    public void loadDariDatabase() {
        List<Peminjaman> daftarPeminjaman = dao.getAllPeminjaman(); 
    }

    
    public List<Peminjaman> getAllPeminjaman() {
        if (dao instanceof DAOPerpustakaan) {
            return ((DAOPerpustakaan) dao).getAllPeminjaman();
        }
        return null;
    }
    public List<Peminjaman> cariPeminjaman(String namaPeminjam) {
        return dao.getPeminjamanByNama(namaPeminjam);
    }
}
