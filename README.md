# 🚀 Foro Hub - API REST para gestión de tópicos

Una API REST robusta desarrollada con Spring Boot para la gestión de un foro de discusión, permitiendo crear, leer, actualizar y eliminar tópicos.

---

## 📚 Descripción del Proyecto

`Foro Hub - API REST` es un servicio backend diseñado para proporcionar una interfaz programática completa para la creación, lectura, actualización y eliminación de tópicos.

El proyecto se adhiere a una arquitectura en capas clara, promoviendo la modularidad, la mantenibilidad y la escalabilidad. Incorpora principios de Clean Code y buenas prácticas de diseño de APIs REST, con un fuerte enfoque en la seguridad mediante la autenticación basada en JWT y el hashing de contraseñas. La gestión del esquema de la base de datos se realiza de forma automatizada y controlada con Flyway.

---

## ✨ Características Principales

* **Gestión Completa de Tópicos (CRUD):**
    * Creación de nuevos tópicos con título, mensaje, autor (usuario registrado) y curso.
    * Detalle de un tópico específico por ID.
    * Actualización de tópicos existentes (título, autor, mensaje, curso).
    * Eliminación de tópicos.
* **Autenticación y Autorización Segura:**
    * **Spring Security:** Framework robusto para la seguridad de la aplicación.
    * **JSON Web Tokens (JWT):** Autenticación sin estado para proteger los endpoints de la API.
    * **Hashing de Contraseñas:** Las contraseñas se almacenan de forma segura utilizando BCrypt.
* **Validación de Datos:**
    * Uso de `jakarta.validation` para asegurar la integridad y el formato de los datos de entrada.
* **Manejo de Errores Global:**
    * Respuestas HTTP estandarizadas (`400 Bad Request`, `403 Forbidden`, `404 Not Found`, `500 Internal Server Error`) para una comunicación clara con el cliente.
* **Gestión de Base de Datos con Flyway:**
    * Control de versiones del esquema de la base de datos para un despliegue y mantenimiento consistentes.

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
* **Autorización Flexible:** Los endpoints están configurados para permitir o requerir autenticación según su función (ej. registro y lista de tópicos públicos, creación de tópicos protegida).

---

## 🔍 Endpoints de la API

Una vez que la aplicación esté ejecutándose, puedes interactuar con ella:

### Autenticación

* **`POST /auth`**
    * **Descripción:** Autentica a un usuario y devuelve un token JWT.
    * **Body (JSON):**
        ```json
        {
            "login": "alumno@gmail.com",
            "contrasena": "123456"
        }
        ```
    * **Respuesta (200 OK):**
        ```json
        {
            "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
        }
        ```

### Tópicos

* **`POST /topicos`**
    * **Descripción:** Crea un nuevo tópico. (Requiere JWT)
    * **Headers:** `Authorization: Bearer <JWT_TOKEN>`
    * **Body (JSON):**
        ```json
        {
            "idAutor": 1,
            "mensaje": "Este es un mensaje de prueba para mi nuevo tópico.",
            "nombreCurso": "JAVA",
            "titulo": "Mi primer tópico con API"
        }
        ```
    * **Respuesta (201 Created):** Detalles del tópico creado.

* **`GET /topicos`**
    * **Descripción:** Lista todos los tópicos paginados. (No requiere JWT)
    * **Respuesta (200 OK):** Lista de tópicos.

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
            "mensaje": "Mensaje del tópico actualizado.",
            "nombreCurso": "SPRING",
            "titulo": "Título del tópico actualizado"
        }
        ```
    * **Respuesta (200 OK):** Detalles del tópico actualizado.

* **`DELETE /topicos/{id}`**
    * **Descripción:** Elimina un tópico por su ID. (Requiere JWT)
    * **Headers:** `Authorization: Bearer <JWT_TOKEN>`
    * **Respuesta (204 No Content):** Si la eliminación fue exitosa.

---
