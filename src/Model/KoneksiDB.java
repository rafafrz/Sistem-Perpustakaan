/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ASUS VIVOBOOK
 */
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author ASUS VIVOBOOK
 */
public class KoneksiDB {
    static Connection con;
        
        public static Connection getConnection(){
            if (con == null){
                MysqlDataSource data = new MysqlDataSource();
                data.setDatabaseName("perpustakaan");
                data.setUser("root");
                data.setPassword("12345");
                try{
                   con = data.getConnection(); 
                   System.out.println("koneksi berhasil");
                } catch(SQLException e){
                    System.out.println("tidak konek");
                }
            }
            return con;
            
        }
    }

