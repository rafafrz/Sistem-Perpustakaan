/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;
import Model.Buku;
import Model.Peminjaman;
import java.util.List;

/**
 *
 * @author ASUS VIVOBOOK
 */
public interface IPerpustakaan {
    void tambahBuku(Buku buku);
    boolean hapusBuku(Buku buku);
    List<Buku> getAllBuku();
    boolean login(String username, String password);
    void tambahPeminjaman(Peminjaman peminjaman);
    boolean hapusPeminjaman(Peminjaman peminjaman);
    List<Peminjaman> getPeminjamanByNama(String namaPeminjam);
    List<Peminjaman> getAllPeminjaman();
}
