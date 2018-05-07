# Tienda
—------------------------------------------------------------------------------------------------------------------------

## Realizo:

#### Javier González Contreras
#### Hilario Gutiérrez Camacho

—------------------------------------------------------------------------------------------------------------------------

## Descripción:

Ejercicio ejemplo implementando el framework Spring creando un sistema CRUD desarrollado bajo el IDE de Eclipse:

* Agregar
* Consultar
* Eliminar
* Actualizar
* Listar

—------------------------------------------------------------------------------------------------------------------------

## Pasos:

1.- Crear base de datos con nombre tienda. Para ello seguiremos los siguientes pasos:
    *create database tienda;
    
*Nota:
  Es mas que sificiente con crear la pura base de datos sin tablas, ya que la aplicacion con base a las entidades que cuenta, las creara por si sola.

*Nota: 
  Puede cambiar pero se debe actualizar el archivo application.properties cambiando el nombre de la base.
  Mismo caso con el usuario y contraseña.
  
2.- Ejecutar la Aplicación dentro de nuestro navegador:

    * Agregar : url = localhost:8080/tienda/agregar?codigo=Codigo(String)&nombre=Nombre(String)&precio=Precio(float)
    * Consultar : url = localhost:8080/tienda/consultar?clave=Clave(int)
    * Eliminar : url = localhost:8080/tienda/eliminar?clave=Clave(int)
    * Actualizar : url = localhost:8080/tienda/actualizar?clave=clave(int)&codigo=Codigo(String)&nombre=Nombre(String)&precio=Precio(float)
    * Listar : url = localhost:8080/tienda/listar
