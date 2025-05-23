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
     private String judul;
    private String pengarang;
    private String penerbit;
    private String tahunTerbit;
    private String kategori;

    public Buku(String judul, String pengarang, String penerbit, String tahunTerbit, String kategori) {
        this.judul = judul;
        this.pengarang = pengarang;
        this.penerbit = penerbit;
        this.tahunTerbit = tahunTerbit;
        this.kategori = kategori;
    }

    // Getter dan Setter
    public String getJudul() {
        return judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public String getTahunTerbit() {
        return tahunTerbit;
    }

    public String getKategori() {
        return kategori;
    }
}
