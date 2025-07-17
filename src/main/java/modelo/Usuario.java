package modelo;  

public class Usuario {  // Define la clase "Usuario"

    // Atributos (variables)
    private int idUsuario;           // Id_usuario en la tabla, usado para identificar al usuario
    private int idTipoUsuario;       // Id_tipo_usuario, para diferenciar entre tipos de usuarios
    private String nombre;           // Nombre del usuario
    private String apellido;         // Apellido del usuario
    private String direccion;        // Dirección del usuario
    private String telefono;         // Teléfono del usuario 
    private String cedula;           // Cedula del usuario
    private String email;            // Correo electrónico del usuario
    private String password;         // Contraseña del usuario

    // Constructor (para crear un nuevo usuario, el id no es necesario)
    public Usuario(int idTipoUsuario, String nombre, String apellido, String direccion,
    String telefono, String cedula, String email, String password) {
        // Asigna los valores recibidos en los parámetros del constructor a los atributos de la clase
        this.idTipoUsuario = idTipoUsuario;  // Tipo de usuario (admin, cliente, etc.)
        this.nombre = nombre;                // Nombre del usuario
        this.apellido = apellido;            // Apellido del usuario
        this.direccion = direccion;          // Dirección del usuario
        this.telefono = telefono;            // Teléfono del usuario
        this.cedula = cedula;                // Cedula del usuario
        this.email = email;                  // Correo electrónico del usuario
        this.password = password;            // Contraseña del usuario
    }

    // Métodos getters y setters: permiten acceder y modificar los valores de los atributos

    public int getIdUsuario() { return idUsuario; }  // Obtiene el idUsuario
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }  // Establece el idUsuario

    public int getIdTipoUsuario() { return idTipoUsuario; }  // Obtiene el idTipoUsuario
    public void setIdTipoUsuario(int idTipoUsuario) { this.idTipoUsuario = idTipoUsuario; }  // Establece el idTipoUsuario

    public String getNombre() { return nombre; }  // Obtiene el nombre del usuario
    public void setNombre(String nombre) { this.nombre = nombre; }  // Establece el nombre del usuario

    public String getApellido() { return apellido; }  // Obtiene el apellido del usuario
    public void setApellido(String apellido) { this.apellido = apellido; }  // Establece el apellido del usuario

    public String getDireccion() { return direccion; }  // Obtiene la dirección del usuario
    public void setDireccion(String direccion) { this.direccion = direccion; }  // Establece la dirección del usuario

    public String getTelefono() { return telefono; }  // Obtiene el teléfono del usuario
    public void setTelefono(String telefono) { this.telefono = telefono; }  // Establece el teléfono del usuario

    public String getCedula() { return cedula; }  // Obtiene la cédula del usuario
    public void setCedula(String cedula) { this.cedula = cedula; }  // Establece la cédula del usuario

    public String getEmail() { return email; }  // Obtiene el correo electrónico del usuario
    public void setEmail(String email) { this.email = email; }  // Establece el correo electrónico del usuario

    public String getPassword() { return password; }  // Obtiene la contraseña del usuario
    public void setPassword(String password) { this.password = password; }  // Establece la contraseña del usuario
}