<%
    if (session.getAttribute("id") != null) {
        response.sendRedirect("/tablero");
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Registrarse - Trabajo Integrador Final CAC 23049 - Fabrizio Ferroni</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <link rel="stylesheet" href="../assets/css/normalize.css">
        <link rel="stylesheet" href="../assets/css/styles.css">
        <link rel="apple-touch-icon" href="../assets/img/codoacodo.png" />
        <link rel="shorcut icon" href="../assets/img/codoacodo.png" type="image/x-png" />
        <link rel="icon" href="../assets/img/codoacodo.png" type="image/x-png" />
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer"
              />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
        <meta name="description" content="Proyecto final de bootstrap para la comision 23049 del curso de Java en Codo a Codo.">
        <meta name="keywords" content="HTML, CSS, JavaScript, Bootstrap, Codo a Codo, Java Inicial">
        <meta name="author" content="Fabrizio Ferroni">
    </head>
    <body>
        <!-- Iconos -->
        <svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
    <symbol id="circle-half" viewBox="0 0 16 16">
        <path d="M8 15A7 7 0 1 0 8 1v14zm0 1A8 8 0 1 1 8 0a8 8 0 0 1 0 16z"/>
    </symbol>
    <symbol id="moon-stars-fill" viewBox="0 0 16 16">
        <path d="M6 .278a.768.768 0 0 1 .08.858 7.208 7.208 0 0 0-.878 3.46c0 4.021 3.278 7.277 7.318 7.277.527 0 1.04-.055 1.533-.16a.787.787 0 0 1 .81.316.733.733 0 0 1-.031.893A8.349 8.349 0 0 1 8.344 16C3.734 16 0 12.286 0 7.71 0 4.266 2.114 1.312 5.124.06A.752.752 0 0 1 6 .278z"/>
        <path d="M10.794 3.148a.217.217 0 0 1 .412 0l.387 1.162c.173.518.579.924 1.097 1.097l1.162.387a.217.217 0 0 1 0 .412l-1.162.387a1.734 1.734 0 0 0-1.097 1.097l-.387 1.162a.217.217 0 0 1-.412 0l-.387-1.162A1.734 1.734 0 0 0 9.31 6.593l-1.162-.387a.217.217 0 0 1 0-.412l1.162-.387a1.734 1.734 0 0 0 1.097-1.097l.387-1.162zM13.863.099a.145.145 0 0 1 .274 0l.258.774c.115.346.386.617.732.732l.774.258a.145.145 0 0 1 0 .274l-.774.258a1.156 1.156 0 0 0-.732.732l-.258.774a.145.145 0 0 1-.274 0l-.258-.774a1.156 1.156 0 0 0-.732-.732l-.774-.258a.145.145 0 0 1 0-.274l.774-.258c.346-.115.617-.386.732-.732L13.863.1z"/>
    </symbol>
    <symbol id="sun-fill" viewBox="0 0 16 16">
        <path d="M8 12a4 4 0 1 0 0-8 4 4 0 0 0 0 8zM8 0a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 0zm0 13a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 13zm8-5a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2a.5.5 0 0 1 .5.5zM3 8a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2A.5.5 0 0 1 3 8zm10.657-5.657a.5.5 0 0 1 0 .707l-1.414 1.415a.5.5 0 1 1-.707-.708l1.414-1.414a.5.5 0 0 1 .707 0zm-9.193 9.193a.5.5 0 0 1 0 .707L3.05 13.657a.5.5 0 0 1-.707-.707l1.414-1.414a.5.5 0 0 1 .707 0zm9.193 2.121a.5.5 0 0 1-.707 0l-1.414-1.414a.5.5 0 0 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .707zM4.464 4.465a.5.5 0 0 1-.707 0L2.343 3.05a.5.5 0 1 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .708z"/>
    </symbol>
    </svg>
    <!-- Fin Iconos -->

    <!-- Menú -->
   <jsp:include page="../template/nav.jsp"/>
    <!-- Fin Menú -->

    <div class="d-flex justify-content-center align-items-center">
        <div class="card-login p-5 border-1">
            <div class="d-flex justify-content-center flex-column align-items-center pb-3 ">
                <span class="fs-1 text-muted">Registrarse</span>
            </div>

            <div class="container">

                <input type="hidden" name="status" id="status" value="<%= request.getAttribute("status")%>">                
                <input type="hidden" name="msg" id="msg" value="<%= request.getAttribute("msg")%>">

                <form class="needs-validation mb-2" novalidate method="post" action="registrarse"> <%--convertite__info--form--%>
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control text-capitalize" required id="nombre" name="nombre" placeholder="Nombre" autocomplete="off" value="<%= request.getAttribute("nombre") != null ? request.getAttribute("nombre") : ""%>">
                        <label for="floatingInput">Nombre</label>
                        <div class="invalid-feedback">
                            Por favor, ingrese su nombre
                        </div>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control text-capitalize" required id="apellido" name="apellido" placeholder="Apellido" autocomplete="off" value="<%= request.getAttribute("apellido") != null ? request.getAttribute("apellido") : ""%>">
                        <label for="floatingInput">Apellido</label>
                        <div class="invalid-feedback">
                            Por favor, ingrese su apellido
                        </div>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="email" class="form-control" required id="email" name="email" placeholder="Correo electrónico" autocomplete="off" value="<%= request.getAttribute("email") != null ? request.getAttribute("email") : ""%>">
                        <label for="floatingInput">Email</label>
                        <div class="invalid-feedback">
                            Por favor, ingrese su correo electrónico
                        </div>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control" required id="username" name="username" placeholder="Username" autocomplete="off" value="<%= request.getAttribute("username") != null ? request.getAttribute("username") : ""%>">
                        <label for="floatingInput">Nombre de usuario</label>
                        <div class="invalid-feedback">
                            Por favor, ingrese su nombre de usuario
                        </div>
                    </div>
                    <div class="form-floating">
                        <input type="password" class="form-control" required name="password" id="password" placeholder="Contraseña" autocomplete="off">
                        <label for="floatingPassword">Contraseña</label>
                        <div class="invalid-feedback">
                            Por favor, ingrese su contraseña
                        </div>
                    </div>
                    <div class="d-block mt-3">
                        <button class="btn btn-success btn-lg w-100" type="submit" name="action" value="registrarme">Registrarme</button>
                    </div>
                </form>
                <span class="text-muted">Ya tenes cuenta? Haz <a href="/iniciarsesion" class="text-decoration-none">click aquí</a> para iniciar sesion</span>
            </div>
        </div>
    </div>





    <!-- Footer -->
    <footer class="mt-5 text-white footer__info--bg py-4 ">
        <!-- <div class="d-flex"> -->
        <ul class="footer__info container w-100">
            <li>
                <a class="text-white text-decoration-none footer__info--enlace" href="javascript:void(0);">Preguntas frecuentes</a>
            </li>
            <li>
                <a class="text-white text-decoration-none footer__info--enlace" href="javascript:void(0);">Contáctanos</a>
            </li>
            <li>
                <a class="text-white text-decoration-none footer__info--enlace" href="javascript:void(0);">Prensa</a>
            </li>
            <li>
                <a class="text-white text-decoration-none footer__info--enlace" href="javascript:void(0);">Conferencias</a>
            </li>
            <li>
                <a class="text-white text-decoration-none footer__info--enlace" href="javascript:void(0);">Términos y condiciones</a>
            </li>
            <li>
                <a class="text-white text-decoration-none footer__info--enlace" href="javascript:void(0);">Privacidad</a>
            </li>
            <li>
                <a class="text-white text-decoration-none footer__info--enlace" href="javascript:void(0);">Estudiante</a>
            </li>
        </ul>
        <!-- </div> -->
    </footer>
    <!-- Fin Footer -->

    <!-- Scripts -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js" integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js" integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ" crossorigin="anonymous"></script>
    <script src="../assets/js/validation.js"></script>
    <script src="../assets/js/icon-menu.js"></script>
    <script src="../assets/js/darkMode.js"></script>    
    <script src="../assets/js/alert.js"></script>


    <!-- Fin Scripts -->
</body>
</html>
