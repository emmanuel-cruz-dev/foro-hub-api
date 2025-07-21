# Foro Hub API REST

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Flyway](https://img.shields.io/badge/Flyway-CC3333?style=for-the-badge&logo=flyway&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring%20Security-6DB33F?style=for-the-badge&logo=spring-security&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=json-web-tokens&logoColor=white)

Una API REST robusta desarrollada con Spring Boot para la gestión de un foro de discusión. Permite a los usuarios interactuar con tópicos de debate, autenticarse de forma segura y administrar sus perfiles, ofreciendo una base sólida para una aplicación de foro moderna.

---

## 📚 Descripción del Proyecto

`Foro Hub API REST` es un servicio backend diseñado para ser el corazón de una plataforma de discusión. La aplicación proporciona una interfaz programática completa para la creación, lectura, actualización y eliminación de tópicos y usuarios.

El proyecto se adhiere a una arquitectura en capas clara, promoviendo la modularidad, la mantenibilidad y la escalabilidad. Incorpora principios de Clean Code y buenas prácticas de diseño de APIs REST, con un fuerte enfoque en la seguridad mediante la autenticación basada en JWT y el hashing de contraseñas. La gestión del esquema de la base de datos se realiza de forma automatizada y controlada con Flyway, y la documentación de la API es interactiva gracias a SpringDoc.

---

## ✨ Características Principales

* **Gestión Completa de Tópicos (CRUD):**
    * Creación de nuevos tópicos con título, mensaje, autor (usuario registrado) y curso.
    * Listado paginado de todos los tópicos.
    * Detalle de un tópico específico por ID.
    * Actualización de tópicos existentes (título, mensaje, curso).
    * Eliminación de tópicos.
* **Gestión de Usuarios (CRUD):**
    * Registro de nuevos usuarios.
    * Listado paginado de usuarios.
    * Detalle de un usuario específico por ID.
    * Actualización de perfiles de usuario (email, contraseña).
    * Eliminación de usuarios.
* **Autenticación y Autorización Segura:**
    * **Spring Security:** Framework robusto para la seguridad de la aplicación.
    * **JSON Web Tokens (JWT):** Autenticación sin estado para proteger los endpoints de la API.
    * **Hashing de Contraseñas:** Las contraseñas se almacenan de forma segura utilizando BCrypt.
* **Validación de Datos:**
    * Uso de `jakarta.validation` para asegurar la integridad y el formato de los datos de entrada.
* **Manejo de Errores Global:**
    * Respuestas HTTP estandarizadas (`400 Bad Request`, `403 Forbidden`, `404 Not Found`, `409 Conflict`, `500 Internal Server Error`) para una comunicación clara con el cliente.
* **Gestión de Base de Datos con Flyway:**
    * Control de versiones del esquema de la base de datos para un despliegue y mantenimiento consistentes.
* **Documentación Interactiva de API (Swagger/SpringDoc):**
    * Acceso a la documentación completa de la API a través de Swagger UI para facilitar las pruebas y el consumo de los endpoints.

---

## 🛠️ Tecnologías Utilizadas

* **Lenguaje:** Java 17+
* **Framework:** Spring Boot 3
* **Base de Datos:** MySQL
* **ORM:** Spring Data JPA / Hibernate
* **Migraciones DB:** Flyway
* **Seguridad:** Spring Security, JWT (JSON Web Tokens)
* **Validación:** Jakarta Validation (Bean Validation)
* **Herramienta de Construcción:** Maven
* **Documentación API:** SpringDoc OpenAPI (Swagger UI)

---

## 🏛️ Arquitectura del Proyecto

El proyecto sigue una arquitectura en capas limpia y modular, facilitando la separación de responsabilidades y la mantenibilidad:

* **`controller`**: Maneja las solicitudes HTTP entrantes, mapea las rutas y delega la lógica de negocio a los servicios.
* **`domain`**: Contiene la lógica de negocio central, incluyendo:
    * **`topico`**: Entidad `Topico`, `ITopicoRepository`, `TopicoService` y DTOs (`TopicoCreacionDTO`, `TopicoDetalleDTO`, `TopicoActualizacionDTO`).
    * **`usuario`**: Entidad `Usuario`, `IUsuarioRepository`, `UsuarioService` y DTOs (`UsuarioRegistroDTO`, `UsuarioDetalleDTO`, `UsuarioActualizacionDetalle`, `UsuarioDetalleParaTopicoDTO`).
* **`infra`**: Contiene componentes de infraestructura y configuración transversal:
    * **`security`**: Clases relacionadas con Spring Security, JWT (`SecurityConfiguration`, `SecurityFilter`, `TokenService`, `AutenticacionService`).
    * **`exception`**: Clases de excepciones personalizadas y el `ManejadorDeErrores` global.

---

## 🔒 Seguridad

La seguridad es un pilar fundamental de esta API:

* **Autenticación JWT:** Cada solicitud a un endpoint protegido requiere un token JWT válido en el encabezado `Authorization`.
* **Hashing de Contraseñas:** Las contraseñas de los usuarios nunca se almacenan en texto plano. Se utiliza `BCryptPasswordEncoder` para hashearlas antes de guardarlas en la base de datos.
* **Autorización Flexible:** Los endpoints están configurados para permitir o requerir autenticación según su función (ej. registro público, creación de tópicos protegida).

---

## 🚀 Cómo Ejecutar el Proyecto

### Prerrequisitos

* Java Development Kit (JDK) 17 o superior.
* Maven.
* MySQL Server (versión 8.0 o superior).
* Un cliente HTTP como [Insomnia](https://insomnia.rest/download) o [Postman](https://www.postman.com/downloads/) para probar los endpoints.

### Configuración de la Base de Datos

1.  Asegúrate de tener un servidor MySQL en ejecución.
2.  Crea una nueva base de datos para el proyecto (ej. `foro_hub_challenge`).
    ```sql
    CREATE DATABASE foro_hub_challenge;
    ```
3.  Asegúrate de que tus credenciales de MySQL (usuario y contraseña) y la URL de la base de datos estén configuradas en las **variables de entorno** de tu sistema o en la configuración de ejecución de tu IDE.
    * **Linux/macOS:**
        ```bash
        export SPRING_DATASOURCE_URL="jdbc:mysql://localhost:3306/foro_hub_challenge?useSSL=false&serverTimezone=UTC"
        export SPRING_DATASOURCE_USERNAME="root" # O tu usuario de MySQL
        export SPRING_DATASOURCE_PASSWORD="tu_contraseña_mysql"
        ```
    * **Windows (CMD):**
        ```cmd
        set SPRING_DATASOURCE_URL="jdbc:mysql://localhost:3306/foro_hub_challenge?useSSL=false&serverTimezone=UTC"
        set SPRING_DATASOURCE_USERNAME="root"
        set SPRING_DATASOURCE_PASSWORD="tu_contraseña_mysql"
        ```
    * **En tu IDE (IntelliJ IDEA, Eclipse):** Configura estas variables en la sección "Environment variables" de tu "Run Configuration".

4.  Flyway se encargará automáticamente de aplicar las migraciones del esquema de la base de datos al iniciar la aplicación.

### Clonar y Ejecutar

1.  Clona el repositorio:
    ```bash
    git clone [https://github.com/tu-usuario/foro-hub-api.git](https://github.com/tu-usuario/foro-hub-api.git) # Reemplaza con la URL de tu repositorio
    cd foro-hub-api
    ```
2.  Construye el proyecto con Maven:
    ```bash
    mvn clean install
    ```
3.  Ejecuta la aplicación Spring Boot:
    ```bash
    mvn spring-boot:run
    ```
    La aplicación se iniciará en `http://localhost:8080`. Flyway ejecutará las migraciones de la base de datos automáticamente.

---

## 🔍 Endpoints de la API (Ejemplos)

Una vez que la aplicación esté ejecutándose, puedes interactuar con ella:

### Autenticación

* **`POST /login`**
    * **Descripción:** Autentica a un usuario y devuelve un token JWT.
    * **Body (JSON):**
        ```json
        {
            "username": "nombre_de_usuario_o_email",
            "password": "contraseña_en_texto_plano"
        }
        ```
    * **Respuesta (200 OK):**
        ```json
        {
            "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
        }
        ```
    * *Nota:* Para las pruebas iniciales, puedes insertar un usuario manualmente en la base de datos con la contraseña hasheada.

### Usuarios

* **`POST /usuarios`**
    * **Descripción:** Registra un nuevo usuario. (Público)
    * **Body (JSON):**
        ```json
        {
            "nombre": "NuevoUsuario",
            "email": "nuevo.usuario@example.com",
            "contrasena": "password123"
        }
        ```
    * **Respuesta (201 Created):** Detalles del usuario creado.

* **`GET /usuarios`**
    * **Descripción:** Lista todos los usuarios paginados. (Requiere JWT)
    * **Headers:** `Authorization: Bearer <JWT_TOKEN>`
    * **Parámetros de consulta (opcionales):** `?page=0&size=10&sort=nombre,asc`
    * **Respuesta (200 OK):** Lista paginada de usuarios.

* **`GET /usuarios/{id}`**
    * **Descripción:** Detalla un usuario por su ID. (Requiere JWT)
    * **Headers:** `Authorization: Bearer <JWT_TOKEN>`
    * **Respuesta (200 OK):** Detalles del usuario.

* **`PUT /usuarios/{id}`**
    * **Descripción:** Actualiza los datos de un usuario (email y/o contraseña). (Requiere JWT)
    * **Headers:** `Authorization: Bearer <JWT_TOKEN>`
    * **Body (JSON):**
        ```json
        {
            "email": "email.actualizado@example.com",
            "contrasena": "nuevaContrasenaSegura"
        }
        ```
    * **Respuesta (200 OK):** Detalles del usuario actualizado.

* **`DELETE /usuarios/{id}`**
    * **Descripción:** Elimina un usuario por su ID. (Requiere JWT)
    * **Headers:** `Authorization: Bearer <JWT_TOKEN>`
    * **Respuesta (204 No Content):** Si la eliminación fue exitosa.

### Tópicos

* **`POST /topicos`**
    * **Descripción:** Crea un nuevo tópico. (Requiere JWT)
    * **Headers:** `Authorization: Bearer <JWT_TOKEN>`
    * **Body (JSON):**
        ```json
        {
            "titulo": "Mi primer tópico con API",
            "mensaje": "Este es un mensaje de prueba para mi nuevo tópico.",
            "autorId": 1,
            "curso": "JAVA"
        }
        ```
    * **Respuesta (201 Created):** Detalles del tópico creado.

* **`GET /topicos`**
    * **Descripción:** Lista todos los tópicos paginados. (Requiere JWT)
    * **Headers:** `Authorization: Bearer <JWT_TOKEN>`
    * **Parámetros de consulta (opcionales):** `?page=0&size=10&sort=fechaDeCreacion,asc`
    * **Respuesta (200 OK):** Lista paginada de tópicos.

* **`GET /topicos/{id}`**
    * **Descripción:** Detalla un tópico por su ID. (Requiere JWT)
    * **Headers:** `Authorization: Bearer <JWT_TOKEN>`
    * **Respuesta (200 OK):** Detalles del tópico.

* **`PUT /topicos/{id}`**
    * **Descripción:** Actualiza los datos de un tópico (título, mensaje, curso). (Requiere JWT)
    * **Headers:** `Authorization: Bearer <JWT_TOKEN>`
    * **Body (JSON):**
        ```json
        {
            "titulo": "Título del tópico actualizado",
            "mensaje": "Mensaje del tópico actualizado.",
            "curso": "SPRING"
        }
        ```
    * **Respuesta (200 OK):** Detalles del tópico actualizado.

* **`DELETE /topicos/{id}`**
    * **Descripción:** Elimina un tópico por su ID. (Requiere JWT)
    * **Headers:** `Authorization: Bearer <JWT_TOKEN>`
    * **Respuesta (204 No Content):** Si la eliminación fue exitosa.

---

## 📚 Documentación de la API (Swagger UI)

Una vez que la aplicación esté en ejecución, puedes acceder a la documentación interactiva de la API en tu navegador:

👉 [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## 🔮 Posibles Mejoras Futuras

* Implementar roles y permisos más granulares (ej. `ROLE_ADMIN`, `ROLE_MODERATOR`).
* Funcionalidad de comentarios en los tópicos.
* Sistema de "me gusta" o votos para tópicos y comentarios.
* Notificaciones.
* Integración con un frontend.
* Pruebas unitarias y de integración exhaustivas.

---

## 🤝 Contribuciones

¡Las contribuciones son bienvenidas! Si encuentras un error o tienes una sugerencia de mejora, por favor, abre un "Issue" o envía un "Pull Request".

---

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.

---

## 📧 Contacto

* **Desarrollado por:** Carla Pasandi
* **LinkedIn:** www.linkedin.com/in/carla-pasandi
* **GitHub:** https://github.com/CarlaGP94
* **Email:** pasandicarla@gmail.com

---
