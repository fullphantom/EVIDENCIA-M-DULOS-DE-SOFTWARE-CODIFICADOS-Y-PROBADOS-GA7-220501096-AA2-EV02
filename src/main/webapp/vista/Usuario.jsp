<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestión de Usuarios</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container my-4">
    <h2>Crear Usuario</h2>
    <form action="${pageContext.request.contextPath}/UsuarioControlador" method="POST">
        <input type="hidden" name="accion" value="crear" />
        <div class="mb-3">
            <label>Nombre</label>
            <input class="form-control" type="text" name="txtNombre" required />
        </div>
        <div class="mb-3">
            <label>Apellido</label>
            <input class="form-control" type="text" name="txtApellido" required />
        </div>
        <div class="mb-3">
            <label>Dirección</label>
            <input class="form-control" type="text" name="txtDireccion" required />
        </div>
        <div class="mb-3">
            <label>Teléfono</label>
            <input class="form-control" type="text" name="txtTelefono" required />
        </div>
        <div class="mb-3">
            <label>Email</label>
            <input class="form-control" type="email" name="txtEmail" required />
        </div>
        <div class="mb-3">
            <label>Cédula</label>
            <input class="form-control" type="text" name="txtCedula" required />
        </div>
        <div class="mb-3">
            <label>Contraseña</label>
            <input class="form-control" type="password" name="txtPassword" required />
        </div>
        <div class="mb-3">
            <label>Tipo de Usuario</label>
            <select class="form-control" name="txtIdTipoUsuario" required>
                <option value="1">Admin</option>
                <option value="2">Cliente</option>
                <option value="3">Empleado</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Registrar Usuario</button>
    </form>

    <hr>

    <h2>Buscar Usuario por ID</h2>
    <form action="${pageContext.request.contextPath}/UsuarioControlador" method="GET">
        <input type="hidden" name="accion" value="buscar" />
        <div class="mb-3">
            <label>ID Usuario</label>
            <input class="form-control" type="number" name="idUsuario" required />
        </div>
        <button type="submit" class="btn btn-info">Buscar</button>
    </form>

    <hr>

    <h2>Actualizar Usuario</h2>
    <form action="${pageContext.request.contextPath}/UsuarioControlador" method="POST">
        <input type="hidden" name="accion" value="actualizar" />
        <div class="mb-3">
            <label>ID Usuario</label>
            <input class="form-control" type="number" name="idUsuario" required />
        </div>
        <div class="mb-3">
            <label>Nombre</label>
            <input class="form-control" type="text" name="txtNombre" />
        </div>
        <div class="mb-3">
            <label>Apellido</label>
            <input class="form-control" type="text" name="txtApellido" />
        </div>
        <div class="mb-3">
            <label>Dirección</label>
            <input class="form-control" type="text" name="txtDireccion" />
        </div>
        <div class="mb-3">
            <label>Teléfono</label>
            <input class="form-control" type="text" name="txtTelefono" />
        </div>
        <div class="mb-3">
            <label>Email</label>
            <input class="form-control" type="email" name="txtEmail" />
        </div>
        <div class="mb-3">
            <label>Cédula</label>
            <input class="form-control" type="text" name="txtCedula" />
        </div>
        <div class="mb-3">
            <label>Contraseña</label>
            <input class="form-control" type="password" name="txtPassword" />
        </div>
        <div class="mb-3">
            <label>Tipo de Usuario</label>
            <select class="form-control" name="txtIdTipoUsuario">
                <option value="">--Selecciona--</option>
                <option value="1">Admin</option>
                <option value="2">Cliente</option>
                <option value="3">Empleado</option>
            </select>
        </div>
        <button type="submit" class="btn btn-warning">Actualizar Usuario</button>
    </form>

    <hr>

    <h2>Eliminar Usuario</h2>
    <form action="${pageContext.request.contextPath}/UsuarioControlador" method="POST">
        <input type="hidden" name="accion" value="eliminar" />
        <div class="mb-3">
            <label>ID Usuario</label>
            <input class="form-control" type="number" name="idUsuario" required />
        </div>
        <button type="submit" class="btn btn-danger">Eliminar Usuario</button>
    </form>
</div>
</body>
</html>
