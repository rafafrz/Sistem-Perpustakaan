/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import java.sql.*;
import Model.KoneksiDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ASUS VIVOBOOK
 */
public class LoginController {
    public static boolean login(String username, String password) {
        try {
            Connection conn = KoneksiDB.getConnection();
            String sql = "SELECT * FROM admin WHERE namaadmin = ? AND passadmin = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            return rs.next(); // return true jika data ditemukan

        } catch (Exception e) {
            System.err.println("Login error: " + e.getMessage());
            return false;
        }
    }
}
