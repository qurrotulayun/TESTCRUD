

import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class file_koneksi {

private static Connection koneksi;
public static Connection GetConnection() throws SQLException 
{
    if (koneksi == null) {
    Driver driver = new Driver();
    koneksi = (Connection)
            DriverManager.getConnection("jdbc:mysql://localhost:3306/db_testkoneksi?zeroDateTimeBehavior=convertToNull", "root", "");
}
return koneksi;
}
    
}
