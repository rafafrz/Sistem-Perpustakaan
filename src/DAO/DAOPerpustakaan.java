/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DAOInterface.IPerpustakaan;
import Model.Buku;
import Model.KoneksiDB;
import Model.Peminjaman;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
/**
 *
 * @author ASUS VIVOBOOK
 */
public class DAOPerpustakaan implements IPerpustakaan {
    public boolean login(String username, String password) {
        Connection conn = KoneksiDB.getConnection();
        if (conn != null) {
            try {
                String sql = "SELECT * FROM admin WHERE namaadmin = ? AND passadmin = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, username);
                stmt.setString(2, password);
                ResultSet rs = stmt.executeQuery();

                boolean loginBerhasil = rs.next();

                return loginBerhasil;

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Gagal login: " + e.getMessage());
            }
        }
        return false;
     }
    
    public void tambahBuku(Buku buku) {
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
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Gagal menyimpan buku: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Koneksi ke database gagal.");
        }
    }
    
    public boolean hapusBuku(Buku buku) {
        Connection conn = KoneksiDB.getConnection();
        PreparedStatement pst = null;
        if (conn != null) {
            try {
                String sql = "DELETE FROM buku WHERE penerbit = ?";
                pst = conn.prepareStatement(sql);
                pst.setString(1, buku.getPenerbit());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
            } catch (SQLException e) {
                System.out.println("Gagal menghapus buku: " + e.getMessage());
            }
        } else {
            System.out.println("Koneksi ke database gagal.");
        }
        return false;
    }

    public List<Buku> getAllBuku() {
        List<Buku> daftarBuku = new ArrayList<>();
        Connection conn = KoneksiDB.getConnection();
        if (conn != null) {
            try {
                String sql = "SELECT * FROM buku";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    Buku buku = new Buku(
                        rs.getInt("id_buku"),
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
        return daftarBuku;
    }
    
     
    public void tambahPeminjaman(Peminjaman p) {
        Connection conn = KoneksiDB.getConnection();
        if (conn != null) {
            try {
                String sql = "INSERT INTO peminjaman (nama_peminjam, id_buku, tanggal_pinjam, tanggal_kembali) VALUES (?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, p.getNamaPeminjam());
                stmt.setInt(2, p.getIdBuku());
                stmt.setDate(3, new java.sql.Date(p.getTanggalPinjam().getTime())); 
                stmt.setDate(4, new java.sql.Date(p.getTanggalKembali().getTime()));
                stmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Data peminjaman berhasil disimpan.");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Gagal menyimpan peminjaman: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Koneksi ke database gagal.");
        }
    }
    
    public boolean hapusPeminjaman(Peminjaman p) {
        Connection conn = KoneksiDB.getConnection();
        PreparedStatement pst = null;
        if (conn != null) {
            try {
                String sql = "DELETE FROM peminjaman WHERE id_buku = ?";
                pst = conn.prepareStatement(sql);
                pst.setInt(1, p.getIdBuku());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
            } catch (SQLException e) {
                System.out.println("Gagal menghapus buku: " + e.getMessage());
            }
        } else {
            System.out.println("Koneksi ke database gagal.");
        }
        return false;
    }

    public List<Peminjaman> getPeminjamanByNama(String namaPeminjam) {
        List<Peminjaman> list = new ArrayList<>();

        String sql = "SELECT b.id_buku, p.nama_peminjam, b.judul AS judul_buku, p.tanggal_pinjam, p.tanggal_kembali " +
                     "FROM peminjaman p JOIN buku b ON p.id_buku = b.id_buku " +
                     "WHERE p.nama_peminjam LIKE ?";

        try {
            Connection conn = KoneksiDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + namaPeminjam + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Peminjaman p = new Peminjaman();
                p.setIdBuku(rs.getInt("id_buku"));
                p.setNamaPeminjam(rs.getString("nama_peminjam"));
                p.setJudulBuku(rs.getString("judul_buku"));
                p.setTanggalPinjam(rs.getDate("tanggal_pinjam"));
                p.setTanggalKembali(rs.getDate("tanggal_kembali"));
                list.add(p);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

        return list;
    }
    
    public List<Peminjaman> getAllPeminjaman() {
        List<Peminjaman> list = new ArrayList<>();

        String sql = "SELECT b.id_buku, p.nama_peminjam, b.judul AS judul_buku, p.tanggal_pinjam, p.tanggal_kembali " +
                     "FROM peminjaman p JOIN buku b ON p.id_buku = b.id_buku";

        try {
            Connection conn = KoneksiDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Peminjaman p = new Peminjaman();
                p.setIdBuku(rs.getInt("id_buku"));
                p.setNamaPeminjam(rs.getString("nama_peminjam"));
                p.setJudulBuku(rs.getString("judul_buku"));
                p.setTanggalPinjam(rs.getDate("tanggal_pinjam"));
                p.setTanggalKembali(rs.getDate("tanggal_kembali"));
                list.add(p);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal memuat data peminjaman: " + e.getMessage());
        }

        return list;
    }
    
}
