<%@page import="java.util.Date"%>
<%@page import="java.time.ZoneId"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.LocalDateTime"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ar.fabriziodev.finalcacfabrizioferroni.models.Orador" %>
<%
    if (session.getAttribute("id") == null) {
        response.sendRedirect("/iniciarsesion");
    }
    String status = (String) session.getAttribute("status");
    String msg = (String) session.getAttribute("msg");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Oradores - Trabajo Integrador Final CAC 23049 - Fabrizio Ferroni</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <link rel="stylesheet" href="../assets/css/normalize.css">
        <link rel="stylesheet" href="../assets/css/styles.css">
        <link rel="stylesheet" href="../assets/css/dt/buttons.css">
        <link rel="apple-touch-icon" href="../assets/img/codoacodo.png" />
        <link rel="shorcut icon" href="../assets/img/codoacodo.png" type="image/x-png" />
        <link rel="icon" href="../assets/img/codoacodo.png" type="image/x-png" />
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
         <link rel="stylesheet" href="https://cdn.datatables.net/1.13.5/css/dataTables.bootstrap5.min.css"/>
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
                <a class="navbar-brand ms-5 logo" href="/">
                    <img class="img-fluid" src="../assets/img/codoacodo.png" alt="Logo Codo a Codo" width="100px"> Conf Bs As
                </a>
                <!-- <button onclick="cambiarTema()" class="btn btn-rounded-fill text-light menu__movil--moon"><i id="dl-icon" class="fas fa-moon"></i></button> -->
                <button class="navbar-toggler border-0" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fas fa-stream"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav ms-auto">
                        <ul class="navbar-nav mb-2 mb-lg-0">
                        <li class="nav-item dropdown">
                            <button class="btn btn-link nav-link py-2 px-0 px-lg-2 dropdown-toggle d-flex align-items-center" id="username" type="button" aria-expanded="false" data-bs-toggle="dropdown" data-bs-display="static" aria-label="Toggle profile options">
                                
                                <span class="fs-5" id="bd-theme-text">Hola: <span class="text-success"><%= session.getAttribute("nombre") %></span></span>
                            </button>
                            <ul class="dropdown-menu dropdown-menu-start">
                                <li class="nav-item">
                                    <a class="dropdown-item d-flex align-items-center" href="/admin/tablero">Tablero</a>
                                </li>
                                
                                <li class="nav-item">
                                    <a class="dropdown-item d-flex align-items-center active" href="/admin/oradores">Oradores</a>
                                </li><!-- comment -->
                                
                                <li class="nav-item">
                                    <a class="dropdown-item d-flex align-items-center " href="/admin/tickets">Tickets</a>
                                </li>
                                
                                <li class="nav-item">
                                    <a class="dropdown-item d-flex align-items-center" href="/admin/usuarios">Usuarios</a>
                                </li>
                                
                                <li class="nav-item">
                                    <a class="dropdown-item d-flex align-items-center" href="/cerrarsesion">Cerrar sesion</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
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
        <input type="hidden" name="status" id="status" value="<%= status%>">                
        <input type="hidden" name="msg" id="msg" value="<%= msg%>">
        
        <div class="container d-flex justify-content-center align-items-center flex-column mt-5 mb-5">
        <h3 class="text-capitalize text-muted text-center">Oradores que quieren presentar una charla</h3>
        <%
            /*codigo java*/
            ArrayList<Orador> oradores = (ArrayList<Orador>) request.getAttribute("oradores"); //esto es un array
        %>
        <!-- Table -->
        <table id="example" class="dataTable text-center table table-striped table-responsive display" style="width:100%">
            <thead>
                <tr>
                    <th class="text-center">ID</th>
                    <th class="text-center">Código</th>
                    <th class="text-center">Nombre</th>
                    <th class="text-center">Apellido</th>
                    <th class="text-center">Tema a debatir</th>
                    <th class="text-center">Fecha de alta</th>
                    <th class="text-center" width="15px">Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (Orador orador : oradores) {

                        // Supongamos que tienes un objeto LocalDateTime llamado createdAt
                        LocalDateTime createdAt = orador.getCreatedAt();

                        // Define el formato deseado
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");

                        // Convierte LocalDateTime a Date
                        Date createdAtDate = Date.from(createdAt.atZone(ZoneId.systemDefault()).toInstant());

                        // Aplica el formato a la fecha
                        String formattedDateTime = formatter.format(createdAtDate);
                %>
                <tr>
                    <td><%= orador.getId()%></td>
                    <td><%= orador.getCodigo() %></td>
                    <td><%= orador.getNombre()%></td>
                    <td><%= orador.getApellido()%></td>
                    <td><%= orador.getTema()%></td>
                    <td><%= formattedDateTime%></td>
                    <td>
                        <div class="d-flex flex-row justify-content-center align-items-center gap-1">
                            <a href="/admin/orador/editar/<%= orador.getId() %>" class="btn btn-info text-white" title="Editar"><i class="fas fa-pen"></i></a>
                            <a href="/admin/orador/eliminar/<%= orador.getId() %>" class="btn btn-danger" title="Borrar"><i class="fas fa-trash"></i></a>
                        </div>
                    </td>
                </tr>
                <% } %>
            </tbody>

        </table>
    </div>


        <!-- Scripts -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js" integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js" integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
           <script src="https://cdn.datatables.net/1.13.5/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.13.5/js/dataTables.bootstrap5.min.js"></script>        


    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/2.5.0/jszip.min.js"></script>

    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/pdfmake.min.js"></script>

    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/vfs_fonts.js"></script>

    <script type="text/javascript" src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>

    <script type="text/javascript" src="https://cdn.datatables.net/1.11.3/js/dataTables.bootstrap5.min.js"></script>

    <script type="text/javascript" src="https://cdn.datatables.net/buttons/2.0.1/js/dataTables.buttons.min.js"></script>

    <script type="text/javascript" src="https://cdn.datatables.net/buttons/2.0.1/js/buttons.bootstrap5.min.js"></script>

    <script type="text/javascript" src="https://cdn.datatables.net/buttons/2.0.1/js/buttons.colVis.min.js"></script>

    <script type="text/javascript" src="https://cdn.datatables.net/buttons/2.0.1/js/buttons.html5.min.js"></script>

    <script type="text/javascript" src="https://cdn.datatables.net/buttons/2.0.1/js/buttons.print.min.js"></script>

    <script src="https://cdn.jsdelivr.net/npm/datatables-buttons-excel-styles@1.2.0/js/buttons.html5.styles.min.js"></script>

    <script src="https://cdn.jsdelivr.net/npm/datatables-buttons-excel-styles@1.2.0/js/buttons.html5.styles.templates.min.js"></script>
    
        <script src="../assets/js/validation.js"></script>
        <script src="../assets/js/form.js"></script>
        <script src="../assets/js/icon-menu.js"></script>
        <script src="../assets/js/darkMode.js"></script>
        <script src="../assets/js/alert.js"></script>

        <%
            session.removeAttribute("status");
            session.removeAttribute("msg");
        %>
        
         <script>


        $(document).ready(function () {
            $('#example').DataTable({
                dom: '<"float-left"l><"float-right"B><"float-right"f>t<"float-left"i><"float-right"p><"clearfix">',
                buttons: {
                    dom: {
                        button: {
                            className: 'butt b0br2 btn'
                        }
                    },
                    buttons: [{
                            extend: "collection",
                            text: '<i class="fas fa-cloud-download-alt"></i> Exportar',
                            className: 'ml10 b0br2 btn btn-secondary',
                            buttons: [{
                                    extend: "copyHtml5",
                                    text: '<i class="far fa-file"></i> Copiar',
                                    title: 'Oradores - CaC 23049 Fabrizio Ferroni',
                                    exportOptions: {
                                        columns: [0, 1, 2, 3, 4, 5]
                                    }
                                },

                                {
                                    extend: "csvHtml5",
                                    text: '<i class="fas fa-file-csv"></i> CSV',
                                    title: 'Oradores - CaC 23049 Fabrizio Ferroni',
                                    excelStyles: {
                                        template: 'header_red'
                                    },
                                    exportOptions: {
                                        columns: [0, 1, 2, 3, 4, 5]
                                    }
                                },
                                {
                                    extend: "excelHtml5",
                                    text: '<i class="far fa-file-excel"></i> Excel',
                                    title: 'Lista de oradores que quieren dar la charla',
                                    sheetName: 'Oradores - CaC 23049 Fabrizio Ferroni',
                                    header: true,
                                    footer: false,
                                    excelStyles: [
                                        {
                                            cells: [1, 2], // to row 2
                                            style: {
                                                alignment: {
                                                    vertical: "center",
                                                    horizontal: "center",
                                                    wrapText: true,
                                                }, // The style block
                                                font: {// Style the font
                                                    name: "Arial", // Font name
                                                    text: "center",
                                                    color: "FFFFFF", // Font Color
                                                    b: false, // Remove bolding from header row
                                                },
                                                // Border Object
                                                border: {
                                                    top: {// At the bottom of the cell/s apply a
                                                        style: "thin", // thick border with
                                                        color: "000000", // a lovely hue of green
                                                    }, // Thin black border at top of cell/s
                                                    bottom: {// At the bottom of the cell/s apply a
                                                        style: "thin", // thick border with
                                                        color: "000000", // a lovely hue of green
                                                    },
                                                    right: {// At the bottom of the cell/s apply a
                                                        style: "thin", // thick border with
                                                        color: "000000", // a lovely hue of green
                                                    },
                                                    left: {// At the bottom of the cell/s apply a
                                                        style: "thin", // thick border with
                                                        color: "000000", // a lovely hue of green
                                                    }
                                                },
                                                fill: {// Style the cell fill (background)
                                                    pattern: {// Type of fill (pattern or gradient)
                                                        color: "dc4345", // Fill color
                                                    }
                                                }
                                            }
                                        },
                                        {
                                            cells: "3:n,2", // to row 2, 3:
                                            style: {
                                                alignment: {
                                                    vertical: "center",
                                                    horizontal: "center",
                                                    wrapText: true,
                                                }, // The style block
                                                font: {// Style the font
                                                    name: "Arial", // Font name
                                                    text: "center",
                                                    color: "3e3e3e", // Font Color
                                                    b: false, // Remove bolding from header row
                                                },
                                                // Border Object
                                                border: {
                                                    top: {// At the bottom of the cell/s apply a
                                                        style: "thin", // thick border with
                                                        color: "000000", // a lovely hue of green
                                                    }, // Thin black border at top of cell/s
                                                    bottom: {// At the bottom of the cell/s apply a
                                                        style: "thin", // thick border with
                                                        color: "000000", // a lovely hue of green
                                                    },
                                                    right: {// At the bottom of the cell/s apply a
                                                        style: "thin", // thick border with
                                                        color: "000000", // a lovely hue of green
                                                    },
                                                    left: {// At the bottom of the cell/s apply a
                                                        style: "thin", // thick border with
                                                        color: "000000", // a lovely hue of green
                                                    }
                                                },
                                                fill: {// Style the cell fill (background)
                                                    pattern: {// Type of fill (pattern or gradient)
                                                        color: "F8CBAD", // Fill color
                                                    }
                                                }
                                            }


                                        },
                                        {
                                            cells: "4:n,2", // to row 2, 3:
                                            style: {
                                                alignment: {
                                                    vertical: "center",
                                                    horizontal: "center",
                                                    wrapText: true,
                                                }, // The style block
                                                font: {// Style the font
                                                    name: "Arial", // Font name
                                                    text: "center",
                                                    color: "3e3e3e", // Font Color
                                                    b: false, // Remove bolding from header row
                                                },
                                                // Border Object
                                                border: {
                                                    top: {// At the bottom of the cell/s apply a
                                                        style: "thin", // thick border with
                                                        color: "000000", // a lovely hue of green
                                                    }, // Thin black border at top of cell/s
                                                    bottom: {// At the bottom of the cell/s apply a
                                                        style: "thin", // thick border with
                                                        color: "000000", // a lovely hue of green
                                                    },
                                                    right: {// At the bottom of the cell/s apply a
                                                        style: "thin", // thick border with
                                                        color: "000000", // a lovely hue of green
                                                    },
                                                    left: {// At the bottom of the cell/s apply a
                                                        style: "thin", // thick border with
                                                        color: "000000", // a lovely hue of green
                                                    }
                                                },
                                                fill: {// Style the cell fill (background)
                                                    pattern: {// Type of fill (pattern or gradient)
                                                        color: "FCE4D6", // Fill color
                                                    }
                                                }
                                            }


                                        }
                                    ],

                                    //
                                    exportOptions: {
                                        columns: [0, 1, 2, 3, 4, 5]
                                    }
                                },
                                {
                                    extend: "print",
                                    text: '<i class="fas fa-print"></i> Imprimir',
                                    autoPrint: true,
                                    title: 'Lista de oradores que quieren dar la charla',
                                    exportOptions: {
                                        columns: [0, 1, 2, 3, 4, 5]
                                    },
                                    customize: function (win) {
                                        $(win.document.body).find('table').addClass('display').css('font-size', '20px');
                                        $(win.document.body).find('tr:nth-child(odd) td').each(function (index) {
                                            $(this).css('background-color', '#F8CBAD');
                                        });
                                        $(win.document.body).find('tr:nth-child(even) td').each(function (index) {
                                            $(this).css('background-color', '#FCE4D6');
                                        });
                                        $(win.document.body).find('h1').css('text-align', 'center');
                                    }
                                },
                                {
                                    extend: "pdfHtml5",
                                    text: '<i class="far fa-file-pdf"></i> PDF',
                                    orientation: 'portrait',
                                    title: 'Lista de oradores que quieren dar la charla',
                                    exportOptions: {
                                        columns: [0, 1, 2, 3, 4, 5]
                                    },
                                    customize: function (doc) {
                                        //Remove the title created by datatTables
                                        doc.content.splice(0, 1);
                                        //Create a date string that we use in the footer. Format is dd-mm-yyyy
                                        var now = new Date();
                                        var jsDate = now.getDate() + '-' + (now.getMonth() + 1) + '-' + now.getFullYear();
                                        // Logo converted to base64
                                        // var logo = getBase64FromImageUrl('https://datatables.net/media/images/logo.png');
                                        // The above call should work, but not when called from codepen.io
                                        // So we use a online converter and paste the string in.
                                        // Done on http://codebeautify.org/image-to-base64-converter
                                        // It's a LONG string scroll down to see the rest of the code !!!
                                        var logo = 'data:image/png;base64,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';
                                        // A documentation reference can be found at
                                        // https://github.com/bpampuch/pdfmake#getting-started
                                        // Set page margins [left,top,right,bottom] or [horizontal,vertical]
                                        // or one number for equal spread
                                        // It's important to create enough space at the top for a header !!!
                                        doc.pageMargins = [40, 60, 20, 20];
                                        // Set the font size fot the entire document
                                        doc.defaultStyle.fontSize = 10;
                                        // Set the fontsize for the table header
                                        doc.styles.tableHeader.fontSize = 10;
                                        // Create a header object with 3 columns
                                        // Left side: Logo
                                        // Middle: brandname
                                        // Right side: A document title
                                        doc['header'] = (function () {
                                            return {
                                                columns: [
                                                    {
                                                        image: logo,
                                                        width: 60
                                                    },
                                                    {
                                                        alignment: 'left',
                                                        italics: true,
                                                        text: 'Lista de oradores que quieren dar la charla',
                                                        fontSize: 18,
                                                        margin: [5, 5]
                                                    },
                                                    {
                                                        alignment: 'right',
                                                        fontSize: 18,
                                                        text: '23049 - CaC',
                                                        margin: [0, 5, 5]
                                                    }
                                                ],
                                                margin: 20
                                            }
                                        });
                                        // Create a footer object with 2 columns
                                        // Left side: report creation date
                                        // Right side: current page and total pages
                                        doc['footer'] = (function (page, pages) {
                                            return {
                                                columns: [
                                                    {
                                                        alignment: 'left',
                                                        text: ['Creado el: ', {text: jsDate.toString()}]
                                                    },
                                                    {
                                                        alignment: 'right',
                                                        text: ['Página ', {text: page.toString()}, ' de ', {text: pages.toString()}]
                                                    }
                                                ],
                                                margin: [10, 0, 10, 0]
                                            }
                                        });
                                        // Change dataTable layout (Table styling)
                                        // To use predefined layouts uncomment the line below and comment the custom lines below
                                        // doc.content[0].layout = 'lightHorizontalLines'; // noBorders , headerLineOnly
                                        var objLayout = {};
                                        objLayout['hLineWidth'] = function (i) {
                                            return .5;
                                        };
                                        objLayout['vLineWidth'] = function (i) {
                                            return .5;
                                        };
                                        objLayout['hLineColor'] = function (i) {
                                            return '#3e3e3e';
                                        };
                                        objLayout['vLineColor'] = function (i) {
                                            return '#3e3e3e';
                                        };
                                        objLayout['paddingLeft'] = function (i) {
                                            return 10;
                                        };
                                        objLayout['paddingRight'] = function (i) {
                                            return 10;
                                        };
                                        doc.content[0].layout = objLayout;
                                    }
                                },
                            ],
                            fade: true,
                        }]
                },
                "order": [
                    [0, "desc"]
                ],
                "language": {
                    search: "Buscar:",
                    processing: "Procesando...",
                    lengthMenu: "Mostrar _MENU_ registros por página",
                    info: "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
                    infoEmpty: "Mostrando registros del 0 al 0 de un total de 0 registros",
                    infoFiltered: "(filtrado de un total de _MAX_ registros)",
                    infoPostFix: "",
                    loadingRecords: "Cargando...",
                    zeroRecords: "No se encontraron resultados",
                    emptyTable: "Ningún dato disponible en esta tabla",
                    paginate: {
                        first: "Primero",
                        previous: "Anterior",
                        next: "Siguiente",
                        last: "Último"
                    },
                    aria: {
                        sortAscending: ": Activar para ordenar la columna de manera ascendente",
                        sortDescending: ": Activar para ordenar la columna de manera descendente"
                    },
                }
            });
            // $('[data-toggle="tooltip"]').tooltip();
        });

    </script>
    </body>
</html>
