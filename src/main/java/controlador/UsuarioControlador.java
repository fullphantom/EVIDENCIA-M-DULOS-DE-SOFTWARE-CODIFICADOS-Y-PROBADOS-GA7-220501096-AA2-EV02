package controlador;

// Importación de librerías necesarias para manejar peticiones HTTP
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Importación de clases del modelo
import modelo.Usuario;
import modelo.dao.UsuarioDao;

public class UsuarioControlador extends HttpServlet {

    // Objeto para acceder a los métodos de la base de datos
    private UsuarioDao usuarioDao;

    // Método principal que procesa todas las acciones que recibe el servlet
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtiene la acción desde el parámetro del formulario o enlace
        String accion = request.getParameter("accion");

        // Evalúa qué acción se quiere ejecutar
        switch (accion) {
            case "crear":        // Si la acción es crear un usuario nuevo
                crear(request, response);
                break;
            case "buscar":       // Buscar usuario por ID
                buscar(request, response);
                break;
            case "actualizar":   // Actualizar un usuario existente
                actualizar(request, response);
                break;
            case "eliminar":     // Eliminar un usuario
                eliminar(request, response);
                break;
            default:             // Si no se reconoce la acción
                System.out.println("Acción no válida: " + accion);
                response.sendRedirect("vista/error.jsp");
                break;
        }
    }

    // Método para crear un nuevo usuario
    private void crear(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        // Obtener los datos del formulario
        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        String direccion = request.getParameter("txtDireccion");
        String telefono = request.getParameter("txtTelefono");
        String email = request.getParameter("txtEmail");
        String cedula = request.getParameter("txtCedula");
        String password = request.getParameter("txtPassword");
        String tipoUsuarioStr = request.getParameter("txtIdTipoUsuario");

        // Validar que el teléfono no sea nulo
        String telefonoFinal = (telefono != null) ? telefono : "";

        // Convertir tipo de usuario a entero
        int tipoUsuario = 0;
        try {
            tipoUsuario = Integer.parseInt(tipoUsuarioStr);
        } catch (NumberFormatException e) {
            System.err.println("Error de formato en tipo de usuario: " + tipoUsuarioStr);
        }

        // Crear objeto Usuario con los datos
        Usuario usuario = new Usuario(tipoUsuario, nombre, apellido, direccion, telefonoFinal, cedula, email, password);

        // Llamar al método del DAO para guardar el usuario en la base de datos
        usuarioDao = new UsuarioDao();
        usuarioDao.guardarUsuario(usuario);

        // Redirigir a una página JSP de confirmación
        response.sendRedirect("vista/usuario_creado.jsp");
    }

    // Método para buscar un usuario por su ID
    private void buscar(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        // Obtener el ID desde el parámetro
        String idStr = request.getParameter("id");

        try {
            // Convertir ID a entero
            int id = Integer.parseInt(idStr);

            // Crear DAO y buscar el usuario en la base de datos
            usuarioDao = new UsuarioDao();
            Usuario usuario = usuarioDao.buscarUsuarioPorId(id);

            if (usuario != null) {
                // Si lo encuentra, lo envía como atributo al JSP
                request.setAttribute("usuario", usuario);
                request.getRequestDispatcher("vista/usuario_ver.jsp").forward(request, response);
            } else {
                // Si no se encuentra, redirige a página de error
                response.sendRedirect("vista/no_encontrado.jsp");
            }
        } catch (NumberFormatException e) {
            // Si el ID no es válido, redirige a error
            System.out.println("ID inválido: " + e.getMessage());
            response.sendRedirect("vista/error.jsp");
        }
    }

    // Método para actualizar los datos de un usuario existente
    private void actualizar(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        // Obtener todos los campos del formulario
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        String direccion = request.getParameter("txtDireccion");
        String telefono = request.getParameter("txtTelefono");
        String email = request.getParameter("txtEmail");
        String cedula = request.getParameter("txtCedula");
        String password = request.getParameter("txtPassword");
        int tipoUsuario = Integer.parseInt(request.getParameter("txtIdTipoUsuario"));

        // Crear objeto Usuario con los nuevos datos
        Usuario usuario = new Usuario(tipoUsuario, nombre, apellido, direccion, telefono, cedula, email, password);
        usuario.setIdUsuario(idUsuario); // Asegurar que el ID esté asignado

        // Actualizar en la base de datos
        usuarioDao = new UsuarioDao();
        usuarioDao.actualizarUsuario(usuario);

        // Redirigir a página de éxito
        response.sendRedirect("vista/usuario_actualizado.jsp");
    }

    // Método para eliminar un usuario por ID
    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtener el ID desde el parámetro
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));


        // Llamar al DAO para eliminar el usuario
        usuarioDao = new UsuarioDao();
        usuarioDao.eliminarUsuario(idUsuario);

        // Redirigir a una página de confirmación
        response.sendRedirect("vista/usuario_eliminado.jsp");
    }

    // Método para manejar solicitudes GET
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);  
    }

    // Método para manejar solicitudes POST
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);  
    }

}
