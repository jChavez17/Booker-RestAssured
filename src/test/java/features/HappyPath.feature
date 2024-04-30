# language: es
Característica: Happy Path - Funcionalidades de Reservas en RESTful Booker

  Escenario: Gestión de Reservas en RESTful Booker
  # Crear una reserva exitosamente
    Dado que desean realizar una reserva con los siguientes datos
    Cuando realizan la reserva
    Entonces la reserva se crea exitosamente

  # Leer los detalles de una reserva existente
    Dado que desean revisar los detalles de la reserva
    Cuando revisan los detalles de la reserva
    Entonces los detalles de la reserva se muestran exitosamente

  # Actualizar los detalles de una reserva existente
    Dado que desean actualizar los detalles de la reserva
    Cuando actualizan los detalles de la reserva
    Entonces la reserva se actualiza exitosamente

  # Eliminar una reserva existente
    Dado que desean eliminar una reserva existente
    Cuando eliminan la reserva
    Entonces la reserva se elimina exitosamente
