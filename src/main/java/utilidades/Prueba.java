import utilidades.Conexion;
import java.sql.Connection;

public class Prueba {
    public static void main(String[] args) {
        Connection conexion = Conexion.conectar();
        if (conexion != null) {
            System.out.println("✅ ¡Conexión exitosa a la base de datos!");
        } else {
            System.out.println("❌ Error: No se pudo conectar a la base de datos.");
        }
    }
}
