# Trabajo Integrador Final Frontend + Backend Codo a Codo

Aplicacion web que se reutilizo los trabajos hecho de integrador de bootstrap y javascript y se unifico con el backend uniendo a la base de datos

## Tecnologias usadas

**Cliente**: JSP, Html, Css, Js, Tomcat 10

* **Aclaración:** Hay que descargar tomcat 10 y configurarlo.

**Server:** Java, Servlets, JDBC, MySQL

## Variables de entornos

Para ejecutar este proyecto, deberá agregar las siguientes variables de entorno a su archivo config-properties en la raiz del proyecto. o copiar el archivo config-example.properties y renombrarlo a config.properties

`DB_HOST`

`DB_PORT`

`DB_PASSWORD`

`DB_USERNAME`

`DB_BD`

### Pre-requisitos 📋

Para poder ejecutar bien este proyecto se necesita tener instalado la version de Java 11 y Tomcat 10

```
Java 11. Se descarga en: https://www.oracle.com/es/java/technologies/javase/jdk11-archive-downloads.html

Tomcat 10. Se descarga en: https://tomcat.apache.org/download-10.cgi
```
## Ejecutar localmente el servidor

Clonar el proyecto

```bash
  git clone https://github.com/FabrizioFerroni/final-java-cac-23049
```

Ir al directorio del proyecto

```bash
  cd final-java-cac-23049
```

Abrir el IDE de preferencia y abrir el proyecto.

Configurar Tomcat .

Y luego iniciar el servidor


## Mapa de la aplicación

Así se encuentra organizado el proyecto en cuestión.

```
📁 final-java-cac-23049/
├───📁 src/
│   └───📁 main/
│       ├───📁 java/
│       │   └───📁 ar/
│       │       └───📁 fabriziodev/
│       │           └───📁 finalcacfabrizioferroni/
│       │               ├───📁 data/
│       │               │   └───📄 Conexion.java
│       │               ├───📁 models/
│       │               │   ├───📄 Orador.java
│       │               │   ├───📄 Ticket.java
│       │               │   └───📄 Usuario.java
│       │               ├───📁 repository/
│       │               │   ├───📄 AuthRepository.java
│       │               │   ├───📄 OradorRepository.java
│       │               │   ├───📄 TicketRepository.java
│       │               │   └───📄 UserRepository.java
│       │               ├───📁 services/
│       │               │   ├───📄 AuthService.java
│       │               │   ├───📄 OradorService.java
│       │               │   ├───📄 TicketService.java
│       │               │   └───📄 UserService.java
│       │               └───📁 servlets/
│       │                   ├───📁 oradores/
│       │                   │   ├───📄 DeletOradorServlet.java
│       │                   │   ├───📄 EditOradorServlet.java
│       │                   │   └───📄 ReadServlet.java
│       │                   ├───📁 tickets/
│       │                   │   ├───📄 DeletTicketServlet.java
│       │                   │   ├───📄 EditTicketServlet.java
│       │                   │   └───📄 ReadServlet.java
│       │                   ├───📁 usuarios/
│       │                   │   ├───📄 DeletServlet.java
│       │                   │   ├───📄 EditServlet.java
│       │                   │   └───📄 ReadServlet.java
│       │                   ├───📄 ComprarTicketServlet.java
│       │                   ├───📄 DashboardIndexServlet.java
│       │                   ├───📄 InicioServlet.java
│       │                   ├───📄 LoginServlet.java
│       │                   ├───📄 LogoutServlet.java
│       │                   └───📄 RegisterServlet.java
│       ├───📁 resources/
│       │   ├───📄 config-example.properties
│       │   └───📄 config.properties
│       └───📁 webapp/
│           ├───📁 admin/
│           │   ├───📁 oradores/
│           │   │   ├───📄 editar.jsp
│           │   │   └───📄 listar.jsp
│           │   ├───📁 tickets/
│           │   │   ├───📄 editar.jsp
│           │   │   └───📄 listar.jsp
│           │   ├───📁 usuarios/
│           │   │   ├───📄 editar.jsp
│           │   │   └───📄 listar.jsp
│           │   └───📄 tablero.jsp
│           ├───📁 assets/
│           │   ├───📁 css/
│           │   │   ├───📁 dt/
│           │   │   │   └───📄 buttons.css
│           │   │   ├───📄 normalize.css
│           │   │   └───📄 styles.css
│           │   ├───📁 img/
│           │   │   ├───📄 ada.jpeg
│           │   │   ├───📄 ba1.jpg
│           │   │   ├───📄 ba2.jpg
│           │   │   ├───📄 ba3.jpg
│           │   │   ├───📄 bill.jpg
│           │   │   ├───📄 codoacodo.png
│           │   │   ├───📄 hawaii.jpg
│           │   │   ├───📄 hawaii2.jpg
│           │   │   ├───📄 hawaii3.jpg
│           │   │   ├───📄 honolulu.jpg
│           │   │   └───📄 steve.jpg
│           │   └───📁 js/
│           │       ├───📄 alert.js
│           │       ├───📄 darkMode.js
│           │       ├───📄 edit_ticket.js
│           │       ├───📄 form.js
│           │       ├───📄 icon-menu.js
│           │       ├───📄 ticket.js
│           │       └───📄 validation.js
│           ├───📁 auth/
│           │   ├───📄 login.jsp
│           │   └───📄 register.jsp
│           ├───📁 comprar/
│           │   └───📄 ticket.jsp
│           ├───📁 META-INF/
│           │   └───📄 context.xml
│           ├───📁 WEB-INF/
│           │   └───📄 web.xml
│           └───📄 index.jsp
└───📄 pom.xml
```
## Quien desarrollo este proyecto

**[Fabrizio Ferroni](https://www.github.com/FabrizioFerroni)**

