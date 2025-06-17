/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import DAO.DAOPerpustakaan;
import DAOInterface.IPerpustakaan;

/**
 *
 * @author ASUS VIVOBOOK
 */
public class LoginController {
    private IPerpustakaan Dao;
    
    public LoginController(){
        Dao = new DAOPerpustakaan();
    }
    
    public boolean login(String username, String password){
       return Dao.login(username, password);
    }
}
