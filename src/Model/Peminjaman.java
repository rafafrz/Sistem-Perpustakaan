/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.Date;

/**
 *
 * @author ASUS VIVOBOOK
 */
public class Peminjaman {
    private String namaPeminjam;
    private int idBuku;
    private Date tanggalPinjam;
    private Date tanggalKembali;
    private String judulBuku;
    
    public Peminjaman(){
    }

    public Peminjaman(String namaPeminjam, int idBuku, Date tanggalPinjam, Date tanggalKembali) {
        this.namaPeminjam = namaPeminjam;
        this.idBuku = idBuku;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalKembali = tanggalKembali;
    }
    
    public void setNamaPeminjam(String namaPeminjam) {
        this.namaPeminjam = namaPeminjam;
    } 
    
    public String getNamaPeminjam() {
        return namaPeminjam;
    }
    
    public void setIdBuku(int idBuku){
        this.idBuku = idBuku;
    }

    public int getIdBuku() {
        return idBuku;
    }
    
    public void setTanggalPinjam(Date tanggalPinjam){
        this.tanggalPinjam = tanggalPinjam;
    }

    public Date getTanggalPinjam() {
        return tanggalPinjam;
    }
    
    public void setTanggalKembali(Date tanggalKembali){
        this.tanggalKembali = tanggalKembali;
    }
    public Date getTanggalKembali() {
        return tanggalKembali;
    }
    
    public void setJudulBuku(String judulBuku){
        this.judulBuku = judulBuku;
    }
    
    public String getJudulBuku(){
        return judulBuku;
    }
}
