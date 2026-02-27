UsuarioService
Este microservicio está desarrollado con Spring Boot 2.7.18 y Java 11. Está optimizado para la eficiencia mediante soporte de imágenes nativas con GraalVM y cuenta con métricas de cobertura de código automatizadas.

🛠️ Stack Tecnológico
Java 11: Lenguaje base.

Spring Boot 2.7.18: Framework principal.

Gradle: Gestor de dependencias y construcción.

GraalVM Native Image: Permite compilar la aplicación a un binario nativo para un inicio casi instantáneo y menor consumo de memoria.

Jacoco: Herramienta para medir la cobertura de pruebas unitarias.



--------------------------------------------------------------------------------

Requisitos Previos
JDK 11 instalado (se recomienda Amazon Corretto o OpenJDK).

GraalVM (opcional, solo si deseas generar el binario nativo).

Gradle (incluido mediante el gradlew wrapper).

----------------------------------------------------------------------------------
Instalación y Configuración

1. Clonar el repositorio :
git clone https://github.com/gmatamala1992/UsuarioServiceJava11.git
cd UsuarioService


2. Construir el proyecto:
Para descargar las dependencias y compilar el proyecto, utiliza el wrapper de Gradle:

./gradlew build

