# ***Simplev6***
En este sitio va haber el proceso explicado de cada version del diseño creado, cualquier tipo de cambio se agregara cada sprint.
# Apartados
Para tener una idea base y poder empezar a desarrollar la parte de diseño hice un mockups, el programa que se utilizo fue moqups.
![Captura de pantalla a 2022-04-01 15-22-00](https://user-images.githubusercontent.com/95090891/161272154-8c9e0771-3401-4a4c-82a2-c7769dcdd451.png)
![Captura de pantalla a 2022-04-01 15-27-34](https://user-images.githubusercontent.com/95090891/161272988-09b30675-4287-4b5a-871f-4c8e550f0239.png)
![Captura de pantalla a 2022-04-01 15-27-53](https://user-images.githubusercontent.com/95090891/161273005-2d663585-1562-4db3-a21d-2b0c5bde4706.png)


Una vez terminado el mockups nos encargamos de pasarlo a la app y tambien se  esta intentando agreagar la version noche y dia. 

# Logo
El logo fue buscado por medio de un creador de logos de la pagina llamada hatchful que es totalmente gratis que da archivo .zip de varios medidas del logo.

![Captura de pantalla de 2022-03-23 23-34-28](https://user-images.githubusercontent.com/71900639/159809976-41cb2b1c-f25e-4e44-bab5-b6030de85eab.png)

## Diseño versión Light
# Apartado alarmas
![Screenshot_20220505_211810_com neuro simplev6](https://user-images.githubusercontent.com/71900639/167031107-69adb4b8-3530-4713-9355-cd36e072d3bd.jpg)

# Apartado Notas
![Screenshot_20220505_211814_com neuro simplev6](https://user-images.githubusercontent.com/71900639/167031133-b60385bf-f513-4bf7-bec2-bf76208a889d.jpg)

# Aprtado Telefono
![Screenshot_20220505_211829_com neuro simplev6](https://user-images.githubusercontent.com/71900639/167030825-33a5c84c-6806-427d-a59d-f02d42b8cb6f.jpg)

## Diseño versión Night


Este en el diseño que tenemos para el modo nocturno, El cual se adapara en conjunto con el modo nocturno del mobil

# Apartado alarmas
![Screenshot_20220505_211747_com neuro simplev6](https://user-images.githubusercontent.com/71900639/167031148-d076654f-82c9-4fc1-a32e-94a16cfb497a.jpg)

# Apartado Notas
![Screenshot_20220505_211751_com neuro simplev6](https://user-images.githubusercontent.com/71900639/167031159-183bc91d-78ce-43b5-8592-ce062b03ac8a.jpg)

# Aprtado Telefono
![Screenshot_20220505_211755_com neuro simplev6](https://user-images.githubusercontent.com/71900639/167031223-4930f406-47a6-4b7f-bfc3-81d1952de53f.jpg)

# ***Simplev3***
En este apartado quise ya empezar hacer el diseño base verdadero que se utilizara en la aplicación, este diseño se agregaria entre el sprint 4 y 5.

# Logo
La app se le cambio el color entonces hemos tenido que cambiar el color del logo.
![logo_transparent](https://user-images.githubusercontent.com/95090891/161074122-50fb3fe9-ac8d-4278-8f7e-a7a8144ef811.png)

# Portada 
Charlando con mi compañero me enseño un diseño de colores variados y me recordo a Instagram entonces quise hacer algo similar en base a los colores.

![Captura de pantalla a 2022-03-31 16-10-42](https://user-images.githubusercontent.com/95090891/161075680-9a1c291a-f2de-4c56-a17b-b647b2dfc4e6.png)

# Apartados
En esta zona estara la información de los contenidos que esta conformado por:Alarmas, Notas, Control, Parental, Mapa.

# Alarmas 
En este apartado ya se esta intentando agregar la base de datos de la aplicación.

![Captura de pantalla a 2022-03-31 16-37-37](https://user-images.githubusercontent.com/95090891/161081472-22a25885-3936-4275-861f-7b2f0b2876d1.png)

# Notas
En este apartado ya se ha podido agregar la base de datos de la aplicación.

# Mapa
Ya tenemos un codigo encontrado para poder agregar el google maps pero todavia seguimos avanzando en otros apartados.

![Captura de pantalla a 2022-03-31 16-44-53](https://user-images.githubusercontent.com/95090891/161083119-fe414669-d738-406c-8c96-3423f11852c0.png)

![Captura de pantalla a 2022-03-31 16-37-37](https://user-images.githubusercontent.com/95090891/161082524-7fdeb2c8-3bd0-4fe5-a138-f719fd138f72.png)

# ***Simplev4***
# Control Parental

Tenemos dos apartados en los que estaran los apartados de direcciones de google y contactos de emergencia en los cuales se guardaran contactos 

![image](https://user-images.githubusercontent.com/102673066/166142746-f27e5879-027c-4804-b5e2-327f7c9d7198.png)

# Mapa
En este apartado se recreó un google maps con geolocalizador incluido donde puedes poner una ubicación fija de tu vivienda, en caso de que la persona se pierda le da donde sale el logo de ubicación y saldra una opcion abajo a la derecha de redirigir a google maps con la ruta de su vivienda directamente, donde ya le saldrá todas las formas de llegar a su propiedad.

![Screenshot_20220429-160718_Mapa](https://user-images.githubusercontent.com/95090891/166143274-1dba37c8-7452-4ec3-bb6b-55a802aa9ef1.png)

![Screenshot_20220429-160701_Maps](https://user-images.githubusercontent.com/95090891/166143279-a44b6d67-a149-4393-9b9a-7872939f48f6.png)

-------------


# ***Explicación código***
## MainActivity
este es el trozo de código es el encargado de configurar los distintos fragmentos que contiene esta sección, si quisiéramos crear otro solo tendríamos que 

https://github.com/MarcCrusellas/Simplev6/blob/78a7aec93cc918d81f395a6a6230d3f63ac23af2/app/src/main/java/com/neuro/simplev6/MainActivity.java#L33-L38

Si quisiéramos crear otro fragmento solo tendríamos poner:
1. En MainActivity otro R.id."el nuevo fragmento" en esta línea
  https://github.com/MarcCrusellas/Simplev6/blob/4c3306db124d1ec21daaa29a16374975ce6eefef/app/src/main/java/com/neuro/simplev6/MainActivity.java#L34
2. En el mobile_navigation.xml poner otro fragmento parecido a este, pero con el ID y las otras características modificadas, aunque lo segundo no es totalmente necesario:
https://github.com/MarcCrusellas/Simplev6/blob/4c3306db124d1ec21daaa29a16374975ce6eefef/app/src/main/res/navigation/mobile_navigation.xml#L20-L24
3. I por último en bottom_nav_menu.xml poner un ítem más para que se vea en el Bottom Navigation Drawer. Como este:
https://github.com/MarcCrusellas/Simplev6/blob/4c3306db124d1ec21daaa29a16374975ce6eefef/app/src/main/res/menu/bottom_nav_menu.xml#L14-L17

## HomeFragment

https://github.com/MarcCrusellas/Simplev6/blob/f37d8c936d0200085ff9fb7e02f5c57c7769a306/app/src/main/java/com/neuro/simplev6/ui/home/HomeFragment.java#L25
Este es el fragmento principal de la aplicación, contiene las alarmas programadas.
https://github.com/MarcCrusellas/Simplev6/blob/f37d8c936d0200085ff9fb7e02f5c57c7769a306/app/src/main/java/com/neuro/simplev6/ui/home/HomeFragment.java#L33
Si nos fijamos bien poder ver una línea de código que nos otorga la posibilidad de encontrar objetos sin tener que usar FindViewById(), es más rápido y no gasta tanta memoria.
En el siguiente ejemplo podemos ver el uso de binding.
https://github.com/MarcCrusellas/Simplev6/blob/f37d8c936d0200085ff9fb7e02f5c57c7769a306/app/src/main/java/com/neuro/simplev6/ui/home/HomeFragment.java#L42
En el HomeFragment también podemos ver que la opción de eliminar una alarma solo se puede utilizar para eliminar una alarma con el nombre test. Es motivo, no pude implementar la opción de getId en el EntityClass, y no hubiese dado error, únicamente habría sido necesario poner otro Queri en el DAO y ya habríamos podido implementar esta opción, sin embargo, si se puede eliminar directamente toda la lista, con el botón naranja. 
De lo que hemos hablado aparece en esta sección de código.
https://github.com/MarcCrusellas/Simplev6/blob/f37d8c936d0200085ff9fb7e02f5c57c7769a306/app/src/main/java/com/neuro/simplev6/ui/home/HomeFragment.java#L108-L111

## DashboardFragment

Este es el segundo fragmento, principalmente es el encargado de mostrar las notas. 
Las notas se almacenan si una base de datos, si no que se utiliza un SharedPreferences, que es un documento privado usado para almacenar pequeñas cuantidades de texto.
https://github.com/MarcCrusellas/Simplev6/blob/daead811c8dfe6a83a708c9d8b8b366c21342681/app/src/main/java/com/neuro/simplev6/ui/dashboard/DashboardFragment.java#L50-L58
Este es el código que uso para poner todas las lasta de notas en el ListView. Como podemos ver, cuando no hay ningún elemento en la lista se crea uno automáticamente para que la persona sepa lo que puede hacer.
Estas son las líneas de código encajadas de hacer un Intent con Información, y permiten editar una nota.
https://github.com/MarcCrusellas/Simplev6/blob/daead811c8dfe6a83a708c9d8b8b366c21342681/app/src/main/java/com/neuro/simplev6/ui/dashboard/DashboardFragment.java#L89-L97

Estas son las líneas de código encargar de escucha cuando un elemento de la línea esta siento presionado por más de un momento.
https://github.com/MarcCrusellas/Simplev6/blob/daead811c8dfe6a83a708c9d8b8b366c21342681/app/src/main/java/com/neuro/simplev6/ui/dashboard/DashboardFragment.java#L65-L88
Estas líneas generan un AlertDialog, que se encarga de hacer salir una pantalla encima, con dos botones, que especifican sí que queremos o no eliminar la nota. Esto ofrece que si escogemos que sí, elimina del SharedPreferences este ítem de la Array, si, por otro lado, nos arrepentimos, podemos presionar no, y no hace nada.

Este trozo de código se encarga de hacer un Intent a una nueva activity, donde podemos originar la nota. 
https://github.com/MarcCrusellas/Simplev6/blob/daead811c8dfe6a83a708c9d8b8b366c21342681/app/src/main/java/com/neuro/simplev6/ui/dashboard/DashboardFragment.java#L100-L110
### NotesActivity
Esta activity está relacionada con DashboardFragment, es la que se encarga de editar las notas creadas y de editar las antiguas.

Este trozo es usado para esconder el Tolbar predefinido
https://github.com/MarcCrusellas/Simplev6/blob/44148e7b05b09e8b58c103875e59df5fd6047f99/app/src/main/java/com/neuro/simplev6/ui/dashboard/AddNote/NotesActivity.java#L31-L33

## NotificationsFragment








