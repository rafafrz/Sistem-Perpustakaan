/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ASUS VIVOBOOK
 */
public class Buku {
    private int idBuku;
    private String judul;
    private String pengarang;
    private String penerbit;
    private String tahunTerbit;
    private String kategori;

    public Buku(){
    }
    
    public Buku(int idBuku, String judul, String pengarang, String penerbit, String tahunTerbit, String kategori) {
        this.idBuku = idBuku;
        this.judul = judul;
        this.pengarang = pengarang;
        this.penerbit = penerbit;
        this.tahunTerbit = tahunTerbit;
        this.kategori = kategori;
    }
    
    public Buku(String judul, String pengarang, String penerbit, String tahunTerbit, String kategori) {
    this.judul = judul;
    this.pengarang = pengarang;
    this.penerbit = penerbit;
    this.tahunTerbit = tahunTerbit;
    this.kategori = kategori;
}

    // Getter dan Setter
    public int getIdBuku(){
        return idBuku;
    }
    
    public void setIdBuku(int IdBuku){
        this.idBuku = IdBuku;
    }
    public String getJudul() {
        return judul;
    }
    
    public void setJudul(String Judul){
        this.judul = Judul;
    }

    public String getPengarang() {
        return pengarang;
    }
    
    public void setPengarang(String pengarang){
        this.pengarang = pengarang;
    }

    public String getPenerbit() {
        return penerbit;
    }
    
    public void setPenerbit(String penerbit){
        this.penerbit = penerbit;
    }

    public String getTahunTerbit() {
        return tahunTerbit;
    }
    
    public void setTahunTerbit(String tahunTerbit){
        this.tahunTerbit = tahunTerbit;
    }

    public String getKategori() {
        return kategori;
    }
    
    public void setKategori(String kategori){
        this.kategori = kategori;
    }
}
