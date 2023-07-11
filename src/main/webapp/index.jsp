<%
    String status = (String) session.getAttribute("status");
    String msg = (String) session.getAttribute("msg");
    String nombre2 = (String) session.getAttribute("nombre2");    
    String apellido2 = (String) session.getAttribute("apellido2");
    String tema = (String) session.getAttribute("tema");

    String nombre3 = (String) session.getAttribute("nombre3");
        String apellido3 = (String) session.getAttribute("apellido3");
        String tema2 = (String) session.getAttribute("tema2");
    String codigo = (String) session.getAttribute("codigo");

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Trabajo Integrador Final CAC 23049 - Fabrizio Ferroni</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <link rel="stylesheet" href="assets/css/normalize.css">
        <link rel="stylesheet" href="assets/css/styles.css">
        <link rel="apple-touch-icon" href="./assets/img/codoacodo.png" />
        <link rel="shorcut icon" href="./assets/img/codoacodo.png" type="image/x-png" />
        <link rel="icon" href="./assets/img/codoacodo.png" type="image/x-png" />
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
    <header>
        <nav class="navbar navbar-expand-lg nav__back navbar-dark  mx-auto">
            <div class="container-fluid">
                <a class="navbar-brand ms-5 logo" href="#home">
                    <img class="img-fluid" src="./assets/img/codoacodo.png" alt="Logo Codo a Codo" width="100px"> Conf Bs As
                </a>
                <!-- <button onclick="cambiarTema()" class="btn btn-rounded-fill text-light menu__movil--moon"><i id="dl-icon" class="fas fa-moon"></i></button> -->
                <button class="navbar-toggler border-0" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fas fa-stream"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item">
                            <a class="nav-link fs-5" href="#home">La conferencia</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link fs-5" href="#los-oradores">Los oradores</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link fs-5" href="#lugar">El lugar y la fecha</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link fs-5" href="#convertite-en-orador">Conviértete en orador</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav__text fs-5" href="comprar/ticket">Comprar tickets</a>
                        </li>
                        <%
                            if (session.getAttribute("id") == null) {
                        %>
                        <li class="nav-item">
                            <a class="nav-link fs-5" href="/iniciarsesion">Iniciar sesion </a>
                        </li>
                        <% } else {%>
                        <ul class="navbar-nav mb-2 mb-lg-0">
                            <li class="nav-item dropdown">
                                <button class="btn btn-link nav-link py-2 px-0 px-lg-2 dropdown-toggle d-flex align-items-center" id="bd-theme" type="button" aria-expanded="false" data-bs-toggle="dropdown" data-bs-display="static" aria-label="Toggle theme (auto)">

                                    <span class="fs-5" id="bd-theme-text">Hola: <span class="text-success"><%= session.getAttribute("nombre")%></span></span>
                                </button>
                                <ul class="dropdown-menu dropdown-menu-start">
                                    <li class="nav-item">
                                        <a class="dropdown-item d-flex align-items-center" href="/admin/tablero">Tablero</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="dropdown-item d-flex align-items-center " href="/admin/operadores">Oradores</a>
                                    </li><!-- comment -->

                                    <li class="nav-item">
                                        <a class="dropdown-item d-flex align-items-center " href="/admin/tickets">Tickets</a>
                                    </li>

                                    <li class="nav-item">
                                        <a class="dropdown-item d-flex align-items-center " href="/admin/usuarios">Usuarios</a>
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
    <!-- Fin Menú -->

    <!-- Section Home -->
    <section id="home">
        <div class="home__info d-flex justify-content-end align-items-center">
            <div class="d-flex flex-column justify-content-center align-items-end pl-5 home__info--text">
                <h1>Conf Bs As</h1>
                <p>
                    Bs As llega por primera vez a Argentina. Un evento para compartir con nuestra comunidad el conocimiento y experiencia de los expertos que están creando el futuro de internet. Ven a conocer a miembros del evento, a otros estudiantes de Codo a Codo y los
                    oradores de primer nivel que tenemos para tí. Te esperamos!
                </p>
                <div class="d-flex pt-4">
                    <a class="btn btn-outline-light me-3 home__info--button" href="#convertite-en-orador">Quiero ser orador</a>
                    <a class="btn home__info--btn home__info--button" href="comprar/ticket">Comprar tickets</a>
                </div>
            </div>
        </div>
    </section>
    <!-- Fin Section Home -->

    <!-- Main -->
    <main class="pt-3 w-100">
        <!-- Section Oradores -->
        <section id="los-oradores">
            <div class="oradores__info">
                <div class="d-flex justify-content-center flex-column align-items-center pt-3 oradores__info--title">
                    Conoce a los <span>Oradores</span>
                </div>

                <div class=" d-flex justify-content-center align-items-center">
                    <div class="g-0 gap-4 justify-content-between mb-2 mt-2 operadores__info--cards">
                        <div class="card operadores__info--card">
                            <img src="assets/img/steve.jpg" class="card-img-top" alt="Steve Jobs Portada">
                            <div class="card-body">
                                <span class="badge bg-warning text-dark">JavaScript</span>
                                <span class="badge bg-info text-light">React</span>
                                <h5 class="card-title pt-2">Steve Jobs</h5>
                                <p class="card-text pb-10">Lorem ipsum dolor sit amet, consectetur adipising elit. Et voluptatibus perferendis deleniti, totam fuga sequi iste! Facilis explicabo repellat ut similique incidunt? Ullam nobis beatae, corporis facilis veniam magni ratione!
                                </p>
                            </div>
                        </div>
                        <div class="card operadores__info--card">
                            <img src="assets/img/bill.jpg" class="card-img-top" alt="Bill Gates Portada">
                            <div class="card-body">
                                <span class="badge bg-warning text-dark">JavaScript</span>
                                <span class="badge bg-info text-light">React</span>
                                <h5 class="card-title pt-2">Bill Gates</h5>
                                <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipising elit. Et voluptatibus perferendis deleniti, totam fuga sequi iste! Facilis explicabo repellat ut similique incidunt? Ullam nobis beatae, corporis facilis veniam magni ratione!
                                </p>
                            </div>
                        </div>
                        <div class="card operadores__info--card">
                            <img src="assets/img/ada.jpeg" class="card-img-top" alt="Ada Lovelace Portada">
                            <div class="card-body">
                                <span class="badge bg-secondary text-white">Negocios</span>
                                <span class="badge bg-danger text-light">Startups</span>
                                <h5 class="card-title pt-2">Ada Lovelace</h5>
                                <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipising elit. Et voluptatibus perferendis deleniti, totam fuga sequi iste! Facilis explicabo repellat ut similique incidunt? Ullam nobis beatae, corporis facilis veniam magni ratione!
                                </p>
                            </div>
                        </div>
                    </div>
                </div>


            </div>
        </section>
        <!-- Fin Section Oradores -->

        <!-- Section Lugar -->
        <section id="lugar">
            <div class="row g-0">
                <div class="col-md-6 col-sm-12">
                    <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
                        <div class="carousel-indicators">
                            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
                            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
                        </div>
                        <div class="carousel-inner">
                            <div class="carousel-item active" data-bs-interval="10000">
                                <img src="./assets/img/ba2.jpg" class="d-block w-100 h-100" alt="Buenos Aires Carousel 1">
                            </div>
                            <div class="carousel-item" data-bs-interval="12000">
                                <img src="./assets/img/ba1.jpg" class="d-block w-100 h-100" alt="Buenos Aires Carousel 2">
                            </div>
                            <div class="carousel-item" data-bs-interval="16000">
                                <img src="./assets/img/ba3.jpg" class="d-block w-100 h-100" alt="Buenos Aires Carousel 3">
                            </div>
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                </div>
                <div class="col-md-6 col-sm-12 lugar__info--bg text-white p-4 lugar__info--border">
                    <h3>Bs As - Octubre</h3>
                    <p>
                        Buenos Aires es una ciudad vibrante y emocionante, que sin duda es una excelente opción para celebrar un evento como "Conf Bs As" de "Codo a Codo". Buenos Aires es la capital de Argentina y la ciudad más grande del país, con una población de alrededor
                        de 3 millones de personas. Es una ciudad cosmopolita y multicultural que atrae a turistas y viajeros de todo el mundo.
                    </p>
                    <a href="javascript:void(0);" class="btn btn-outline-light"> Conocé más</a>
                </div>
            </div>
        </section>
        <!-- Fin Section Lugar -->

        <!-- Section Convertite en Orador -->
        <section id="convertite-en-orador">
            <div class="convertite__info">
                <div class="d-flex justify-content-center flex-column align-items-center pt-3 convertite__info--title">
                    Conviértete en un <span>Orador</span>
                </div>
                Anótate como orador para dar una <a href="javascript:void(0);">charla ignite</a>. Cuéntanos de qué quieres hablar!

                <div class="container mt-3 mb-5">
                    <input type="hidden" name="status" id="status" value="<%= status%>">                
                    <input type="hidden" name="msg" id="msg" value="<%= msg%>">
                    <input type="hidden" name="nombre2" id="nombre2" value="<%= nombre3 %>">
                    <input type="hidden" name="apellido2" id="apellido2" value="<%= apellido3 %>">
                    <input type="hidden" name="tema2" id="tema2" value="<%= tema2 %>">
                    <input type="hidden" name="codigo" id="codigo" value="<%= codigo %>">

                    <form id="form" class="needs-validation convertite__info--form" method="post" action="index" novalidate>
                        <div class="row">
                            <div class="col-md-6 col-sm-12">
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control" id="nombre" name="nombre" required placeholder="Ingresa tu nombre" value="<%= nombre2 != null ? nombre2 : ""%>">
                                    <label for="floatingInput">Nombre</label>
                                    <div class="invalid-feedback">
                                        Por favor, ingrese su nombre
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6 col-sm-12">
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control" id="apellido" name="apellido" required placeholder="Ingresa tu apellido" value="<%= apellido2 != null ? apellido2 : ""%>">
                                    <label for="floatingInput">Apellido</label>
                                    <div class="invalid-feedback">
                                        Por favor, ingrese su apellido
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-floating mb-3">
                                    <textarea class="form-control convertite__info--textarea" name="tema" id="mensaje" cols="30" rows="10" required placeholder="Sobre que quieres hablar?" height="30px"><%= tema != null ? tema : ""%></textarea>
                                    <label for="floatingInput">Sobre que quieres hablar?</label>
                                    <div class="invalid-feedback">
                                        Por favor, ingrese su tema de lo que va a hablar
                                    </div>
                                    <span class="text-muted convertite__info-left d-flex pt-1">Recuerda incluir un título para tu charla</span>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <button type="submit" class="d-block btn convertite__info--btn w-100 py-3">Enviar</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </section>
        <!-- Fin Section Convertite en Orador -->
    </main>
    <!-- Fin Main -->

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
    <script src="assets/js/validation.js"></script>
    <script src="assets/js/form.js"></script>
    <script src="assets/js/icon-menu.js"></script>
    <script src="assets/js/darkMode.js"></script>
    <!--<script src="assets/js/alert.js"></script>-->

    <!-- Fin Scripts -->
    <%
        session.removeAttribute("status");
        session.removeAttribute("msg");
        session.removeAttribute("nombre2");
        session.removeAttribute("apellido2");
        session.removeAttribute("tema");

        session.removeAttribute("nombre3");
                session.removeAttribute("apellido3");
                session.removeAttribute("tema2");
        session.removeAttribute("codigo");
    %>

</body>
</html>
