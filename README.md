# CRUD con JAVA SWING

Un CRUD completo utilizando JAVA SWING & SQLITE (incluye la BD)

Este ejemplo prático implemento:

- Una JFrame principal que engloba toda las funciones
- Un JInternalFrame para cada una de las acciones
- Organización del código utilizando el patron de diseño MVC

Herramientas utilizadas:

- [SQlite](#)
- [Eclipse 2024-09](#)
- [DB Broswser](#)
- [Java 17](#)
- [Indicaciones para crear Jframes](images/indicaciones_jframe.txt)

### Estructura del proyecto

```
|- lib/                                  // Jar de SQlite
|- bd/                                   // directorio con la base de datos
|- src/
|   |
|   |- controller/                       // Directorio con la conexión  a las acciones del modelo
|   |- model/                            // Directorio con la conexión y codigo con las Queries hacia la BD
|   |- view/                             // Directorio con todas las pantallas utilizadas
```

---

**Nota:** Para ejecutar el proyecto hay que lanzar el archivo  `.../crudswing/src/view/ProductoView.java`

---

#### Imagenes

|x|x|x|
|---|---|---|
|![imagen 1](images/imagen01.jpg)|![imagen 2](images/imagen02.jpg)| ![imagen 3](images/imagen03.jpg)|
|![imagen 4](images/imagen04.jpg)|![imagen 5](images/imagen05.jpg)| ![imagen 6](images/imagen06.jpg)|
