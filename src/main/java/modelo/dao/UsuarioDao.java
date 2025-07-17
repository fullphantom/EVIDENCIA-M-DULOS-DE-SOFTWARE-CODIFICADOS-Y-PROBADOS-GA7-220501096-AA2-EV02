package modelo.dao;

import java.sql.Connection;          // Para manejar la conexión con la base de datos
import java.sql.PreparedStatement;  // Para preparar consultas SQL con parámetros
import java.sql.ResultSet;           // Para manejar el resultado de consultas SELECT
import java.sql.SQLException;        // Para capturar errores de SQL

import modelo.Usuario;               // Clase modelo Usuario
import utilidades.Conexion;          // Clase que proporciona la conexión a la base de datos

public class UsuarioDao {

   
    //Guarda un nuevo usuario en la base de datos.
   
    public void guardarUsuario(Usuario usuario) {
        // Consulta SQL para insertar un usuario nuevo con valores parametrizados (?)
        String sql = "INSERT INTO usuario (Nombre, Apellido, Direccion, Telefono, Email, Cedula, Password, Id_tipo_usuario) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        // Abre la conexión y prepara la sentencia SQL (se cierran automáticamente con try-with-resources)
        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Asigna cada valor del objeto usuario a cada parámetro de la consulta SQL
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getDireccion());
            ps.setString(4, usuario.getTelefono());
            ps.setString(5, usuario.getEmail());
            ps.setString(6, usuario.getCedula());
            ps.setString(7, usuario.getPassword());
            ps.setInt(8, usuario.getIdTipoUsuario());

            // Ejecuta la consulta para insertar el usuario
            ps.executeUpdate();

            // Mensaje de éxito
            System.out.println("Usuario guardado correctamente.");

        } catch (SQLException e) {
            // En caso de error, imprime un mensaje simple con la descripción del error
            System.out.println("Error al guardar el usuario: " + e.getMessage());
        }
    }

  
     // Actualiza un usuario existente en la base de datos.
    
    public void actualizarUsuario(Usuario usuario) {
        // Consulta SQL para actualizar datos de usuario según el ID
        String sql = "UPDATE usuario SET Nombre=?, Apellido=?, Direccion=?, Telefono=?, Email=?, Cedula=?, Password=?, Id_tipo_usuario=? WHERE Id_usuario=?";

        // Abre la conexión y prepara la sentencia SQL
        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Asigna los nuevos valores a cada campo
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getDireccion());
            ps.setString(4, usuario.getTelefono());
            ps.setString(5, usuario.getEmail());
            ps.setString(6, usuario.getCedula());
            ps.setString(7, usuario.getPassword());
            ps.setInt(8, usuario.getIdTipoUsuario());

            // Importante: asignar el ID del usuario a actualizar 
            ps.setInt(9, usuario.getIdUsuario());

            // Ejecuta la actualización y devuelve el número de filas afectadas
            int filasActualizadas = ps.executeUpdate();

            // Mensaje según si encontró o no el usuario para actualizar
            if (filasActualizadas > 0) {
                System.out.println("Usuario actualizado correctamente.");
            } else {
                System.out.println("No se encontró el usuario para actualizar.");
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar el usuario: " + e.getMessage());
        }
    }

    
    // Elimina un usuario de la base de datos por su ID.
   
    public void eliminarUsuario(int idUsuario) {
        // Consulta SQL para eliminar usuario por ID
        String sql = "DELETE FROM usuario WHERE Id_usuario=?";

        // Abre conexión y prepara sentencia
        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Asigna el ID del usuario a eliminar
            ps.setInt(1, idUsuario);

            // Ejecuta eliminación y devuelve número de filas eliminadas
            int filasEliminadas = ps.executeUpdate();

            // Mensaje según si encontró o no el usuario para eliminar
            if (filasEliminadas > 0) {
                System.out.println("Usuario eliminado correctamente.");
            } else {
                System.out.println("No se encontró el usuario para eliminar.");
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar el usuario: " + e.getMessage());
        }
    }

   
     // Busca un usuario por su ID y devuelve el objeto Usuario o null si no existe.
  
    public Usuario buscarUsuarioPorId(int idUsuario) {
        // Consulta SQL para buscar usuario por ID
        String sql = "SELECT * FROM usuario WHERE Id_usuario=?";

        // Abre conexión y prepara sentencia
        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Asigna el ID del usuario a buscar
            ps.setInt(1, idUsuario);

            // Ejecuta la consulta y obtiene el resultado
            ResultSet rs = ps.executeQuery();

            // Si hay resultado, crea un objeto Usuario con los datos
            if (rs.next()) {
                Usuario usuario = new Usuario(
                    rs.getInt("Id_tipo_usuario"),
                    rs.getString("Nombre"),
                    rs.getString("Apellido"),
                    rs.getString("Direccion"),
                    rs.getString("Telefono"),
                    rs.getString("Cedula"),
                    rs.getString("Email"),
                    rs.getString("Password")
                );
                // Asigna el ID del usuario
                usuario.setIdUsuario(rs.getInt("Id_usuario"));
                return usuario;

            } else {
                // Si no encontró resultados, muestra mensaje y retorna null
                System.out.println("Usuario no encontrado.");
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar el usuario: " + e.getMessage());
            return null;
        }
    }
}
