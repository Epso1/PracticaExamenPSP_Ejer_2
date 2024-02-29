# Aplicación de Descarga y Compresión de URLs

## Características

Esta aplicación permite al usuario introducir direcciones URL que se almacenan en un listado junto con una cadena aleatoria y única de 20 caracteres. Cada vez que se añade una URL al listado, se muestra un mensaje en la consola con la URL y la cadena única asociada. Si el usuario introduce una URL vacía, la aplicación procede a descargar el contenido HTML de todas las URLs almacenadas, cada una en un archivo con el nombre de la cadena única asociada. Al finalizar la descarga, todos los archivos se comprimen en un único archivo .ZIP.

La aplicación utiliza el patrón Observer-Listener para la implementación y los Futuros de Java para la descarga y compresión de los archivos.

## Requisitos del sistema

- Sistema operativo: Windows
- Java JDK 11 o superior
- IntelliJ IDEA 2023.2.2 o superior
- Maven

## Instalación en IntelliJ IDEA

1. Clona el repositorio del proyecto en tu máquina local.
2. Abre IntelliJ IDEA.
3. Haz clic en `File > Open...`.
4. Navega hasta el directorio donde clonaste el repositorio y selecciona el archivo `pom.xml`.
5. Haz clic en `Open`.
6. IntelliJ IDEA importará el proyecto y descargará automáticamente las dependencias necesarias.

## Uso de la aplicación

1. Ejecuta la clase `Main` para iniciar la aplicación.
2. Cuando se te solicite, introduce una URL y presiona `Enter`.
3. La URL se añadirá al listado y se mostrará un mensaje en la consola con la URL y la cadena única asociada.
4. Para descargar y comprimir las URLs, introduce una URL vacía y presiona `Enter`.
5. La aplicación descargará el contenido HTML de todas las URLs y lo guardará en archivos individuales. Luego, comprimirá todos los archivos en un único archivo .ZIP.
6. Para salir de la aplicación, introduce `0` y presiona `Enter`.