<%  String rutaActual = request.getAttribute("rutaActual").toString(); %>
<!-- MenÃº -->
  <header>
        <nav class="navbar navbar-expand-lg nav__back navbar-dark  mx-auto">
            <div class="container-fluid">
                <a class="navbar-brand ms-5 logo" href="/">
                    <img class="img-fluid" src="../assets/img/codoacodo.png" alt="Logo Codo a Codo" width="100px"> Conf Bs As
                </a>
                <!-- <button onclick="cambiarTema()" class="btn btn-rounded-fill text-light menu__movil--moon"><i id="dl-icon" class="fas fa-moon"></i></button> -->
                <button class="navbar-toggler border-0" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fas fa-stream"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item">
                            <a class="nav-link fs-5" href="/#home">La conferencia</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link fs-5" href="/#los-oradores">Los oradores</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link fs-5" href="/#lugar">El lugar y la fecha</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link fs-5" href="/#convertite-en-orador">Conviértete en orador</a>
                        </li>
                        <%
                            if (session.getAttribute("id") != null) {
                        %>

                        <li class="nav-item">
                            <a class="nav-link nav__text fs-5 <%= rutaActual.equals("/comprar/ticket") ? "active2" : ""%>" href="/comprar/ticket">Comprar tickets</a>
                        </li>
                        <% } %>
                        <li class="nav-item">
                            <a class="nav-link fs-5 <%= rutaActual.equals("/buscar") ? "active" : ""%>" href="/buscar">Buscar ticket</a>
                        </li>
                        <%
                            if (session.getAttribute("id") == null) {
                        %>
                        <li class="nav-item">
                            <a class="nav-link fs-5 <%= rutaActual.equals("/iniciarsesion") || rutaActual.equals("/registrarse") ? "active" : ""%>" href="/iniciarsesion">Iniciar sesion / Registrarse</a>
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
                                        <a class="dropdown-item d-flex align-items-center <%= rutaActual.equals("/admin/tablero") ? "active" : ""%>" href="/admin/tablero">Tablero</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="dropdown-item d-flex align-items-center <%= rutaActual.equals("/admin/oradores") ? "active" : ""%>" href="/admin/oradores">Oradores</a>
                                    </li><!-- comment -->

                                    <li class="nav-item">
                                        <a class="dropdown-item d-flex align-items-center <%= rutaActual.equals("/admin/tickets") ? "active" : ""%>" href="/admin/tickets">Tickets</a>
                                    </li>

                                    <li class="nav-item">
                                        <a class="dropdown-item d-flex align-items-center <%= rutaActual.equals("/admin/usuarios") ? "active" : ""%>" href="/admin/usuarios">Usuarios</a>
                                    </li>
                                    <% }%>
                                    <li class="nav-item">
                                        <a class="dropdown-item d-flex align-items-center <%= rutaActual.equals("/tickets") ? "active" : ""%>" href="/tickets">Mis tickets</a>
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