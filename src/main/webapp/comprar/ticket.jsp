<%

    if (session.getAttribute("id") == null) {
        response.sendRedirect("/registrarse");
    }

    String status = (String) session.getAttribute("status");
    String msg = (String) session.getAttribute("msg");
    String nombre3 = (String) session.getAttribute("nombre");
    String apellido3 = (String) session.getAttribute("apellido");
    String email3 = (String) session.getAttribute("email");

    String nombre2 = (String) session.getAttribute("nombre2");
    String apellido2 = (String) session.getAttribute("apellido2");
    String email2 = (String) session.getAttribute("email2");
    String codigo2 = (String) session.getAttribute("codigo2");
    Integer cantidad2 = (Integer) session.getAttribute("cantidad2");
    Double total2 = (Double) session.getAttribute("total2");
    String categoria2 = (String) session.getAttribute("categoria2");
    String dni2 = (String) session.getAttribute("dni2");
    Long orador2 = (Long) session.getAttribute("orador_2");

%>

<%@page import="java.util.Date"%>
<%@page import="java.time.ZoneId"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.text.NumberFormat" %>
<%@page import="java.util.Locale" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ar.fabriziodev.finalcacfabrizioferroni.models.Orador" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Comprar Tickets - Trabajo Integrador Bootstrap CAC 23049 - Fabrizio Ferroni</title>
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

    <jsp:include page="../template/nav.jsp"/>



    <!-- Main -->
    <main class="pt-3 w-100">
        <section class="comprar-ticket">
            <div class="container">
                <div class="row justify-content-center">
                    <div class=" d-flex justify-content-center align-items-center">
                        <ul class="m-0 p-0 g-0 gap-4 justify-content-between mb-2 mt-2 operadores__info--cards">
                            <li onclick="selectCat('Estudiante')" id="estudiante" class="text-decoration-none card operadores__info--card estudiante__card text-center border-primary rounded-0 cursor-pointer" onmouseleave="changeTotal()">
                                <div class="card-body d-flex justify-content-center align-items-center">
                                    <div class="d-flex flex-column justify-content-center align-items-center">
                                        <h5 class="card-title pb-10">Estudiante</h5>
                                        <h6 class="fw-normal pb-10">Tienen un descuento</h6>
                                        <h2 class="pb-10">80%</h2>
                                        <span class="pb-10 text-muted">* presentar documentación</span>
                                    </div>
                                </div>
                            </li>
                            <li onclick="selectCat('Trainee')" id="trainee" class="text-decoration-none card operadores__info--card text-center trainee__card border-info rounded-0 cursor-pointer" onmouseleave="changeTotal()">
                                <div class="card-body d-flex justify-content-center align-items-center">
                                    <div class="d-flex flex-column justify-content-center align-items-center">
                                        <h5 class="card-title pb-10">Trainee</h5>
                                        <h6 class="fw-normal pb-10">Tienen un descuento</h6>
                                        <h2 class="pb-10">50%</h2>
                                        <span class="pb-10 text-muted">* presentar documentación</span>
                                    </div>
                                </div>
                            </li>
                            <li onclick="selectCat('Junior')" id="junior" class="text-decoration-none card operadores__info--card text-center junior__card border-warning rounded-0 cursor-pointer" onmouseleave="changeTotal()">
                                <div class="card-body d-flex justify-content-center align-items-center">
                                    <div class="d-flex flex-column justify-content-center align-items-center">
                                        <h5 class="card-title pb-10">Junior</h5>
                                        <h6 class="fw-normal pb-10">Tienen un descuento</h6>
                                        <h2 class="pb-10">15%</h2>
                                        <span class="pb-10 text-muted">* presentar documentación</span>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>



                    <div class="col-12 mt-3">
                        <h5 class="text-center text-uppercase text-secondary mb-0">
                            <span class="text-secondary mb-0">
                                <span class="text-secondary mb-0">Venta</span>
                            </span>
                        </h5>
                        <h1 class="text-uppercase text-center mt-2 fs-1">
                            Valor de ticket: $200
                        </h1>

                        <div class="row">
                            <div class="container mt-3 mb-5">
                                <input type="hidden" name="status" id="status" value="<%= status%>">                
                                <input type="hidden" name="msg" id="msg" value="<%= msg%>">
                                <input type="hidden" name="codigo2" id="codigo2" value="<%= codigo2%>">
                                <input type="hidden" name="nombre2" id="nombre2" value="<%= nombre2%>">
                                <input type="hidden" name="apellido2" id="apellido2" value="<%= apellido2%>">
                                <input type="hidden" name="email2" id="email2" value="<%= email2%>">
                                <input type="hidden" name="cantidad2" id="cantidad2" value="<%= cantidad2%>">
                                <input type="hidden" name="total2" id="total2" value="<%= total2%>">
                                <input type="hidden" name="categoria2" id="categoria2" value="<%= categoria2%>">
                                <input type="hidden" name="dni2" id="dni2" value="<%= dni2%>">
                                <input type="hidden" name="orador_id2" id="orador_id2" value="<%= orador2%>">
                                <input type="hidden" id="nombre3" value="<%= session.getAttribute("nombre")%>">
                                <input type="hidden" id="apellido3" value="<%= session.getAttribute("apellido")%>">
                                <input type="hidden" id="email3" value="<%= session.getAttribute("email")%>">

                                <%
                                    /*codigo java*/
                                    ArrayList<Orador> oradores = (ArrayList<Orador>) request.getAttribute("oradores"); //esto es un array
                                %>


                                <form id="form" action="/comprar/ticket" class="needs-validation convertite__info--form-ticket" method="POST" novalidate>
                                    <div class="row">
                                        <div class="col-md-6 col-sm-12">
                                            <div class="form-floating mb-3">
                                                <input type="text" class="form-control text-capitalize" id="nombre" name="nombre" required placeholder="Ingresa tu nombre" value="<%= session.getAttribute("nombre") == null ? nombre3 : session.getAttribute("nombre")%>">
                                                <label for="floatingInput">Nombre</label>
                                                <div class="invalid-feedback">
                                                    Por favor, ingrese su nombre
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6 col-sm-12">
                                            <div class="form-floating mb-3">
                                                <input type="text" class="form-control text-capitalize" id="apellido" name="apellido" required placeholder="Ingresa tu apellido" value="<%= session.getAttribute("apellido") == null ? apellido3 : session.getAttribute("apellido")%>">
                                                <label for="floatingInput">Apellido</label>
                                                <div class="invalid-feedback">
                                                    Por favor, ingrese su apellido
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 col-sm-12">
                                            <div class="form-floating mb-3">
                                                <input type="email" class="form-control" id="correo" name="email" required placeholder="Ingresa tu correo electrónico" value="<%= session.getAttribute("email") == null ? email3 : session.getAttribute("email")%>">
                                                <label for="floatingInput">Correo Electrónico</label>
                                                <div class="invalid-feedback">
                                                    Por favor, ingrese su correo electrónico
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6 col-sm-12">
                                            <div class="form-floating mb-3">
                                                <input type="number" class="form-control" id="dni" name="dni" required placeholder="Ingresa tu dni" value="<%= session.getAttribute("dni") == null ? "" : session.getAttribute("dni")%>">
                                                <label for="floatingInput">Dni</label>
                                                <div class="invalid-feedback">
                                                    Por favor, ingrese su dni
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-floating mb-3">


                                                <select name="orador_id" id="orador_id" class="form-select text-capitalize" required placeholder="Orador" autocomplete="off" value="<%= session.getAttribute("orador_id") == null ? "" : session.getAttribute("orador_id")%>">
                                                    <option readonly disabled selected value="">Seleccione una charla</option>
                                                    <% for (Orador orador : oradores) {%>
                                                    <option value="<%= orador.getId()%>"
                                                            <% if (orador.getId().equals(session.getAttribute("orador_id"))) { %>
                                                            selected
                                                            <% }%>
                                                            >
                                                        ( <%= orador.getNombre()%> <%= orador.getApellido()%> ) - <%= orador.getTema()%>
                                                    </option>
                                                    <% } %>
                                                </select>
                                                <label for="floatingInput">Charla a la cual quiere ir</label>
                                                <div class="invalid-feedback">
                                                    Por favor, ingrese la Charla a la cual quiere ir
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 col-sm-12">
                                            <div class="form-floating mb-3">
                                                <input type="number" class="form-control" id="cantidad" name="cantidad" required placeholder="Ingresa la cantidad" min="1" step="1" onchange="changeTotal()">
                                                <label for="floatingInput">Cantidad</label>
                                                <div class="invalid-feedback">
                                                    Por favor, ingrese su cantidad
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6 col-sm-12">
                                            <div class="form-floating mb-3">
                                                <input type="text" class="form-control" id="categoria" name="categoria" required placeholder="Selecciona una categoria">
                                                <label for="floatingInput">Categoria</label>
                                                <div class="invalid-feedback">
                                                    Por favor, seleccione una categoria de arriba
                                                </div>
                                                <span class="text-muted convertite__info-left d-flex pt-1">Tienes que seleccionar una categoria en las cards de arriba</span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-12">
                                            <div class="form-floating mb-3">
                                                <div class="alert alert-info">
                                                    <h5 class="mb-0 mt-0 text-info-50">
                                                        Total a pagar: $<span class="text-info-50" id="total">0</span>
                                                        <input type="hidden" id="total_input" name="total" value="0">
                                                    </h5>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 col-sm-12 mb-erase">
                                            <button type="button" onclick="borrar()" class="d-block btn convertite__info--btn w-100 py-3">Borrar</button>
                                        </div>
                                        <div class="col-md-6 col-sm-12">
                                            <button type="submit" class="d-block btn convertite__info--btn w-100 py-3">Comprar ticket</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </main>
    <!-- Fin Main -->

    <!-- Footer -->
    <!--  bottom-0 position-fixed w-100 -->
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
    <script src="../assets/js/ticket.js"></script>
    <script src="../assets/js/icon-menu.js"></script>
    <script src="../assets/js/darkMode.js"></script>
    <!--<script src="../assets/js/alert.js"></script>-->

    <!-- Fin Scripts -->

    <%
        session.removeAttribute("status");
        session.removeAttribute("msg");
        session.removeAttribute("nombre2");
        session.removeAttribute("codigo2");
        session.removeAttribute("apellido2");
        session.removeAttribute("email2");
        session.removeAttribute("cantidad2");
        session.removeAttribute("total2");
        session.removeAttribute("categoria2");
    %>

</body>
</html>
