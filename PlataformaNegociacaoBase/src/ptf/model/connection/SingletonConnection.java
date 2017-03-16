
package ptf.model.connection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 
 * Classe referente ao Singleton.
 * @author Victor Moraes Ribeiro
 */
public class SingletonConnection {
    
    private static SingletonConnection instance;
    private Connection connection;

    private SingletonConnection() {
        try {
                Properties prop = new Properties();
                InputStream inputStream = SingletonConnection.class.getClassLoader().getResourceAsStream("ptf/model/connection/db.properties");
                prop.load(inputStream);
                String driver = prop.getProperty("driver");
                String url = prop.getProperty("url");
                String user = prop.getProperty("user");
                String password = prop.getProperty("password");
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public static synchronized SingletonConnection getInstance() {
        if(instance == null)
            instance = new SingletonConnection();
        return instance;
    }
    
    public Connection getConnection(){
        return this.connection;
    }
    
           
    
}
