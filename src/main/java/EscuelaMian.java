import Dao.MySQL.MySQLDaoManger;
import vist.Login;
import vist.MainMenu;

import java.sql.SQLException;

public class EscuelaMian {
    public static void main(String[] args) throws SQLException {
        Login login = new Login();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
        if(login.isAceptado()){
            String username=login.getUsuario();
            String password=login.getContrasenia();
            MySQLDaoManger manger=new MySQLDaoManger("localhost","escuela",username,password);
            MainMenu menu=new MainMenu(manger);
            menu.setLocationRelativeTo(null);
            menu.setVisible(true);
        }
    }
}
