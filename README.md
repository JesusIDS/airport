Recuerda abrir el programa como un proyecto Maven
ya que es la base del mismo, debera ejecutarse como proyecto 
Spring Boot, recuerda que despues de abrir el programa
deberas esperar a que el ID instale todas las dependencias
necesarias.
Podras comunicarte con el programa mediante la direccion
http://localhost:8090/apiv1/clientes/add utilizando un
metodo Post y un Json con el siguiente formato:
{
"surname" : "Perez",
"firstname" : "Jesus",
"languageSpeaks" : [
{
"code" : "es",
"name" : "Español"
}
],
"countryWork" :
{
"code" : "MX",
"name" : "Mexico",
"airportsCountry" : [
{
"name" : "AIFA"
}
]
}
}