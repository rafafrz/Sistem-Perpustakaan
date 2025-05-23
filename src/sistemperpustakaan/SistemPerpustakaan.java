/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemperpustakaan;
import Model.KoneksiDB;
import View.LoginForm;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import javax.swing.SwingUtilities;

/**
 *
 * @author ASUS VIVOBOOK
 */
public class SistemPerpustakaan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Inisialisasi koneksi database
         KoneksiDB.getConnection();
         // Tampilkan Login Form
        SwingUtilities.invokeLater(() -> {
            new LoginForm().setVisible(true);
        });
    }
}
