/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Buku;
import Model.KoneksiDB;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS VIVOBOOK
 */
public class BukuController {
  private List<Buku> daftarBuku;

    public BukuController() {
        daftarBuku = new ArrayList<>();
        loadDariDatabase();
    }

    public void tambahBuku(Buku buku) {
        daftarBuku.add(buku);
        simpanKeDatabase(buku); // ← Tambahkan baris ini
        JOptionPane.showMessageDialog(null, "Buku berhasil ditambahkan ke daftar dan database.");
    }

public void simpanKeDatabase(Buku buku) {
    Connection conn = KoneksiDB.getConnection();
    if (conn != null) {
        try {
            String sql = "INSERT INTO buku (judul, pengarang, penerbit, tahun_terbit, kategori) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, buku.getJudul());
            stmt.setString(2, buku.getPengarang());
            stmt.setString(3, buku.getPenerbit());
            stmt.setString(4, buku.getTahunTerbit());
            stmt.setString(5, buku.getKategori());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal menyimpan buku: " + e.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(null, "Koneksi ke database gagal.");
    }
}

public void loadDariDatabase() {
        daftarBuku.clear(); // Bersihkan dulu list-nya
        Connection conn = KoneksiDB.getConnection();
        if (conn != null) {
            try {
                String sql = "SELECT * FROM buku";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    Buku buku = new Buku(
                        rs.getString("judul"),
                        rs.getString("pengarang"),
                        rs.getString("penerbit"),
                        rs.getString("tahun_terbit"),
                        rs.getString("kategori")
                    );
                    daftarBuku.add(buku);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Gagal memuat data: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Koneksi ke database gagal.");
        }
    }

    public List<Buku> getDaftarBuku() {
        return daftarBuku;
    }
}