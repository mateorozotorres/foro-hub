# foro-hub
Este es un proyecto de una API para un sistema de foro desarrollado con Spring Boot. La API implementa autenticación mediante JSON Web Tokens (JWT) para asegurar las rutas protegidas y permitir un acceso controlado a los usuarios.

Características
Autenticación con JWT: Los usuarios pueden iniciar sesión proporcionando un nombre de usuario y una contraseña, y recibir un token JWT para autenticar futuras solicitudes.
Protección de Rutas: Las rutas protegidas requieren un token JWT válido en el header de la solicitud para ser accesibles.
Inicio de sesión: Los usuarios pueden iniciar sesión con las credenciales predeterminadas.
Tecnologías
Java 17
Spring Boot 2.x
Spring Security
JWT (Json Web Tokens)
MySQL (como base de datos)
Requisitos previos
Java 17 o superior.
Maven para la gestión de dependencias y la construcción del proyecto.
MySQL para la base de datos.

* BD
CREATE TABLE responses (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    content TEXT NOT NULL,
    topic_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (topic_id) REFERENCES topics(id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
CREATE TABLE topics (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    user_id BIGINT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    role ENUM('USER', 'ADMIN') DEFAULT 'USER',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

Configura la base de datos MySQL:

Crea la base de datos llamada forohub en MySQL y proporciona las credenciales correctas en el archivo application.properties.

spring.datasource.url=jdbc:mysql://localhost:3306/forohub
spring.datasource.username=root
spring.datasource.password=tu-contraseña
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.jpa.hibernate.ddl-auto=update
Compila y ejecuta el proyecto:

Usa Maven para compilar y ejecutar la aplicación:

mvn clean install
mvn spring-boot:run
Esto iniciará el servidor en http://localhost:8080.

Endpoints
1. Iniciar sesión
POST /api/v1/auth/login

Este endpoint permite a los usuarios iniciar sesión proporcionando un nombre de usuario y una contraseña. Si las credenciales son correctas, se devuelve un token JWT que debe usarse para autenticar las solicitudes posteriores.

Request Body (JSON):
json
{
  "username": "admin",
  "password": "admin123"
}
Response (JSON):
json
{
  "token": "<TOKEN>"
}
2. Endpoint protegido (requiere JWT)
GET /api/v1/protected/resource

Este endpoint está protegido y requiere un token JWT válido. El token debe enviarse en el encabezado de la solicitud como Authorization: Bearer <TOKEN>.

Request Header:
plaintext
Authorization: Bearer <TOKEN>
Response (si el token es válido):
json
{
  "message": "Acceso permitido"
}
3. Respuesta en caso de no autenticación
Si el token JWT no se proporciona o es inválido, el servidor devolverá una respuesta con un código de estado 401 (Unauthorized).

json
{
  "error": "Unauthorized"
}
Seguridad
La seguridad en este proyecto está configurada con Spring Security para proteger las rutas mediante la validación del token JWT. El servidor espera que todas las solicitudes que accedan a rutas protegidas envíen un token JWT válido en el encabezado Authorization.

Configuración de seguridad:
El endpoint /api/v1/auth/login está permitido sin autenticación.
Todos los demás endpoints requieren un token JWT válido.
Pruebas
Para ejecutar las pruebas en el proyecto, puedes usar Maven y postman
