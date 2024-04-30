# language: es
Característica: Unhappy Path - Funcionalidades de Reservas en RESTful Booker

  Escenario: Manejo de Reservas Fallidas
    Dado que un usuario intenta interactuar con las funcionalidades de reservas
    Cuando ocurren diferentes situaciones de fallo durante el proceso
    Entonces la API devuelve códigos de estado de error correspondientes

    Dado que el usuario proporciona datos incorrectos para una reserva
    Cuando intenta realizar la reserva con estos datos
    Entonces la API devuelve un código de estado de error

    Dado que el usuario intenta revisar los detalles de una reserva que no existe
    Cuando intenta leer los detalles de esta reserva
    Entonces la API devuelve un código de estado de error

    Dado que el usuario intenta actualizar los detalles de una reserva que no existe
    Cuando intenta actualizar los detalles de esta reserva
    Entonces la API devuelve un código de estado de error