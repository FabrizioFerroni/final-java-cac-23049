<%

    String status = (String) session.getAttribute("status");
    String msg = (String) session.getAttribute("msg");

    String nombre2 = (String) session.getAttribute("nombre2");
    String apellido2 = (String) session.getAttribute("apellido2");
    String email2 = (String) session.getAttribute("email2");
    String codigo2 = (String) session.getAttribute("codigo2");
    Integer cantidad2 = (Integer) session.getAttribute("cantidad2");
    Double total2 = (Double) session.getAttribute("total2");
    String categoria2 = (String) session.getAttribute("categoria2");


%>

<%@page import="java.util.Date"%>
<%@page import="java.time.ZoneId"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.text.NumberFormat" %>
<%@page import="java.util.Locale" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ar.fabriziodev.finalcacfabrizioferroni.models.Ticket" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Ver Mis Tickets - Trabajo Integrador Bootstrap CAC 23049 - Fabrizio Ferroni</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <link rel="stylesheet" href="../../assets/css/normalize.css">
        <link rel="stylesheet" href="../../assets/css/styles.css">
        <link rel="stylesheet" href="../../assets/css/ticket.css">

        <link rel="apple-touch-icon" href="../../assets/img/codoacodo.png" />
        <link rel="shorcut icon" href="../../assets/img/codoacodo.png" type="image/x-png" />
        <link rel="icon" href="../../assets/img/codoacodo.png" type="image/x-png" />
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer"
              />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
        <meta name="description" content="Proyecto final de bootstrap para la comision 23049 del curso de Java en Codo a Codo.">
        <meta name="keywords" content="HTML, CSS, JavaScript, Bootstrap, Codo a Codo, Java Inicial">
        <meta name="author" content="Fabrizio Ferroni">
        <style>
            * {
                box-sizing: border-box;
                margin:0;
                padding:0;
            }
            .pl-2{
                padding-left: .5rem;
            }
        </style>
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


    <%        /*codigo java*/
        ArrayList<Ticket> tickets = (ArrayList<Ticket>) request.getAttribute("tickets"); //esto es un array
    %>

    <header>
        <nav class="navbar navbar-expand-lg nav__back navbar-dark  mx-auto">
            <div class="container-fluid">
                <a class="navbar-brand ms-5 logo" href="/">
                    <img class="img-fluid" src="../../assets/img/codoacodo.png" alt="Logo Codo a Codo" width="100px"> Conf Bs As
                </a>
                <!-- <button onclick="cambiarTema()" class="btn btn-rounded-fill text-light menu__movil--moon"><i id="dl-icon" class="fas fa-moon"></i></button> -->
                <button class="navbar-toggler border-0" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fas fa-stream"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item">
                            <a class="nav-link fs-5" href="../#home">La conferencia</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link fs-5" href="../#los-oradores">Los oradores</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link fs-5" href="../#lugar">El lugar y la fecha</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link fs-5" href="../#convertite-en-orador">Conviertete en orador</a>
                        </li>
                        <%
                            if (session.getAttribute("id") != null) {
                        %>
                        <li class="nav-item">
                            <a class="nav-link nav__text fs-5" href="/comprar/ticket">Comprar tickets</a>
                        </li>
                        <%
                            }
                            if (tickets == null || tickets.size() == 0) {
                        %>
                        <li class="nav-item">
                            <a class="nav-link fs-5 active" href="/buscar">Buscar ticket</a>
                        </li>
                        <% } else {%>
                        <li class="nav-item">
                            <a class="nav-link fs-5 active" href="/tickets/dni/<%= request.getAttribute("dni")%>">Ver tickets por dni</a>
                        </li>

                        <%
                            }
                            if (session.getAttribute("id") == null) {
                        %>
                        <li class="nav-item">
                            <a class="nav-link fs-5" href="/iniciarsesion">Iniciar sesion / Registrarse</a>
                        </li>
                        <% } else {%>
                        <ul class="navbar-nav mb-2 mb-lg-0">
                            <li class="nav-item dropdown">
                                <button class="btn btn-link nav-link py-2 px-0 px-lg-2 dropdown-toggle d-flex align-items-center" id="bd-theme" type="button" aria-expanded="false" data-bs-toggle="dropdown" data-bs-display="static" aria-label="Toggle theme (auto)">

                                    <span class="fs-5" id="bd-theme-text">Hola: <span class="text-success"><%= session.getAttribute("nombre")%></span></span>
                                </button>
                                <ul class="dropdown-menu dropdown-menu-start">
                                    <%
                                        if (session.getAttribute("rol").equals("admin")) {
                                    %>
                                    <li class="nav-item">
                                        <a class="dropdown-item d-flex align-items-center" href="/admin/tablero">Tablero</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="dropdown-item d-flex align-items-center " href="/admin/oradores">Oradores</a>
                                    </li><!-- comment -->

                                    <li class="nav-item">
                                        <a class="dropdown-item d-flex align-items-center " href="/admin/tickets">Tickets</a>
                                    </li>

                                    <li class="nav-item">
                                        <a class="dropdown-item d-flex align-items-center " href="/admin/usuarios">Usuarios</a>
                                    </li>
                                    <% }%>
                                    <li class="nav-item">
                                        <a class="dropdown-item d-flex align-items-center" href="/tickets">Mis tickets</a>
                                    </li>


                                    <li class="nav-item">
                                        <a class="dropdown-item d-flex align-items-center" href="/cerrarsesion">Cerrar sesion</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                        <% }%>
                    </ul>
                    <ul class="navbar-nav mb-2 mb-lg-0">
                        <li class="nav-item dropdown">
                            <button class="btn btn-link nav-link py-2 px-0 px-lg-2 dropdown-toggle d-flex align-items-center" id="bd-theme" type="button" aria-expanded="false" data-bs-toggle="dropdown" data-bs-display="static" aria-label="Toggle theme (auto)">
                                <svg class="bi my-1 theme-icon-active"><use href="#circle-half"></use></svg>
                                <span class="d-lg-none ms-2" id="bd-theme-text">Cambiar tema</span>
                            </button>
                            <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="bd-theme-text">
                                <li>
                                    <button type="button" class="dropdown-item d-flex align-items-center" data-bs-theme-value="light" aria-pressed="false">
                                        <svg class="bi me-2 opacity-50 theme-icon"><use href="#sun-fill"></use></svg>
                                        Claro
                                        <svg class="bi ms-auto d-none"><use href="#check2"></use></svg>
                                    </button>
                                </li>
                                <li>
                                    <button type="button" class="dropdown-item d-flex align-items-center" data-bs-theme-value="dark" aria-pressed="false">
                                        <svg class="bi me-2 opacity-50 theme-icon"><use href="#moon-stars-fill"></use></svg>
                                        Oscuro
                                        <svg class="bi ms-auto d-none"><use href="#check2"></use></svg>
                                    </button>
                                </li>
                                <li>
                                    <button type="button" class="dropdown-item d-flex align-items-center active" data-bs-theme-value="auto" aria-pressed="true">
                                        <svg class="bi me-2 opacity-50 theme-icon"><use href="#circle-half"></use></svg>
                                        Auto
                                        <svg class="bi ms-auto d-none"><use href="#check2"></use></svg>
                                    </button>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
    <input type="hidden" name="status" id="status" value="<%= status%>">                
    <input type="hidden" name="msg" id="msg" value="<%= msg%>">

    <div class="container-ticket">
        <div class="d-flex flex-column align-items-center">
            <h1 class="pagina__heading">Mis tickets adquiridos</h1>
            <a href="/buscar" class="btn w-20p btn-md btn-secondary text-white <%= (tickets.size() > 0) ? "" : "d-none"%>"> <i class="fas fa-arrow-left"></i> Volver a buscar un ticket</a>

        </div>
        <%
            if (tickets == null || tickets.size() == 0) {


        %>

        <div>
            <div class="pagina__descripcion d-block text-center"><span class="form-text text-black fw-bolder">No hay tickets comprado o asociados a tu dni</span></div>
            <div class="d-flex justify-content-center align-items-center gap-5 pt-4 flex-column flex-md-row"><img src="../../assets/img/no.svg" alt="No hay tickets" class="w-20"></div>
            <div class="d-flex justify-content-center align-items-center mt-5 mb-5"><a href="/comprar/ticket" class="text-white btn btn-info"><i class="fas fa-money-check-alt"></i> Comprar ticket</a></div>
        </div>
        <%        } else {
            for (Ticket ticket : tickets) {

                // Supongamos que tienes un objeto LocalDateTime llamado createdAt
                LocalDateTime createdAt = ticket.getCreatedAt();

                // Define el formato deseado
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");

                // Convierte LocalDateTime a Date
                Date createdAtDate = Date.from(createdAt.atZone(ZoneId.systemDefault()).toInstant());

                // Aplica el formato a la fecha
                String formattedDateTime = formatter.format(createdAtDate);

                double precio = ticket.getTotal();

                // Crea un objeto NumberFormat para el formato monetario
                NumberFormat formatoMonetario = NumberFormat.getCurrencyInstance(new Locale("es", "AR"));

                // Establece la cantidad máxima de dígitos decimales a mostrar
                formatoMonetario.setMaximumFractionDigits(0);

                // Formatea el precio
                String precioFormateado = formatoMonetario.format(precio);
        %>
        <div class="item">
            <div class="item-right">
                <div class="conf-title">
                    <div class="text-center pl-c-5">
                        <span class="fs-6 text-center span-color">Conf Bs As</span>
                    </div>
                    <h2 class="num">Oct</h2>
                    <p class="day">23</p>
                </div>
                <span class="up-border"></span>
                <span class="down-border"></span>
            </div> <!-- end item-right -->

            <div class="item-left">
                <p class="event"><%= ticket.getCategoria()%> </p>
                <h2 class="title text-capitalize texto-largo"  data-bs-toggle="tooltip" data-bs-placement="top"
                    data-bs-custom-class="custom-tooltip"
                    data-bs-title="<%= ticket.orador.getTema()%>" ><%= ticket.orador.getTema()%></h2>

                <div class="sce">
                    <div class="icon">
                        <i class="fa fa-user"></i>
                    </div>
                    <p class="text-capitalize"><%= ticket.getNombre()%> <%= ticket.getApellido()%></p>
                </div>
                <div class="fix"></div>
                <div class="loc ">
                    <div class="icon">
                        <i class="fa fa-hand-holding-usd"></i>
                    </div>
                    <p><%= ticket.getCantidad()%></p>
                    <div class="icon pl-2">
                        <i class="fa fa-money-bill-alt"></i>
                    </div>
                    <p><%= precioFormateado%></p>
                </div>

                <div class="fix"></div>
                <a href="/ticket/<%= ticket.getCodigo()%>" class="btn btn-secondary tickets">Ver ticket</a>
            </div> <!-- end item-right -->
        </div> <!-- end item -->


        <% } %>

        <%
            }
        %>
    </div>



    <!-- Footer -->
    <!--  bottom-0 position-fixed w-100 -->
    <footer class="mt-5 text-white footer__info--bg py-4 <%= (tickets.size() < 3 && tickets.size() > 0) ? "mt-custom" : ""%> ">
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
    <script src="../../assets/js/validation.js"></script>
    <script src="../../assets/js/icon-menu.js"></script>
    <script src="../../assets/js/darkMode.js"></script>
    <script src="../../assets/js/alert.js"></script>

    <!-- Fin Scripts -->

    <%        session.removeAttribute("status");
        session.removeAttribute("msg");
        session.removeAttribute("codigo");
    %>
    <script>
        var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'))
        var tooltipList = tooltipTriggerList.map(function (tooltipTriggerEl) {
            return new bootstrap.Tooltip(tooltipTriggerEl)
        })
    </script>

</body>
</html>

