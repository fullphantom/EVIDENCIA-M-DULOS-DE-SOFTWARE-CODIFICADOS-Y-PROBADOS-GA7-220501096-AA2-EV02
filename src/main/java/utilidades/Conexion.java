package utilidades; 

import java.sql.Connection;       // Importa la clase Connection para manejar conexiones a la bases de datos
import java.sql.DriverManager;   // Importa DriverManager, que gestiona los controladores JDBC
import java.sql.SQLException;    // Importa la clase SQLException para manejar errores de SQL

public class Conexion { 
    
    // Constantes con los datos de conexión a la base de datos restaurante
    private static final String URL = "jdbc:mysql://localhost:3306/restaurante";  // Dirección y nombre de la base de datos
    private static final String USER = "root";  // Nombre de usuario para conectarse 
    private static final String PASSWORD = "";         // Contraseña de la base de datos

    // Método estático que establece la conexión con la base de datos
    public static Connection conectar() {
        try {
            // Cargar el driver JDBC de MySQL 
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establece la conexión usando los datos de las constantes como  URL, usuario y contraseña
            Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("conexión exitosa a MYSQL");  // Mensaje en consola si la conexión es exitosa
            return conexion;  // Devuelve el objeto de conexión

        } catch (ClassNotFoundException e) {
            // Si no se encuentra el driver, muestra el error en consola
            System.out.println("Error: Driver JDBC no encontrado: " + e.getMessage());
            return null;  // Retorna null en caso de error

        } catch (SQLException e) {
            
            System.out.println("Error al conectar: " + e.getMessage());
            return null;  
        }      
    }  
}

