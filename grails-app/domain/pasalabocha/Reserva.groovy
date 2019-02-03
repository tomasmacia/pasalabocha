package pasalabocha

import java.time.LocalDateTime
import java.time.Duration

class Reserva {
    BigDecimal precioFinal
    // lo dejo pero recordar que dijeron que no era necesario incluir esta historia de usuario
    LocalDateTime plazoLimiteCancelacion
    Integer nroReserva
    Turno turno
    Asistencia asistencia = Asistencia.INDETERMINADA

    static hasOne = [sena: Sena]

    static belongsTo = [turno: Turno, cliente: Cliente]

    static constraints = {
      //nullable porque todavia no esta implementado que se complete
      nroReserva nullable: true
      sena nullable: true
    }

    public Reserva(Turno turno, Cliente cliente, BigDecimal precio,
                    LocalDateTime plazoLimiteCancelacion, LocalDateTime ahora){
        this.turno = turno
        this.cliente = cliente
        this.precioFinal = precio
        this.plazoLimiteCancelacion = plazoLimiteCancelacion

        Club club = turno.cancha.club
        if (!club.esConfiable(cliente)){
            Duration tiempoLimitePagoDeSena = club.tiempoLimitePagoDeSena
            this.sena = new Sena(this, tiempoLimitePagoDeSena, precio, club.porcentajeSena, ahora)
            this.sena.save(failOnError: true)
        }
    }

    boolean tieneSenaPaga(){
        this.sena && this.sena.estaPaga()
    }

    boolean estaCumplida(){
        this.asistenciaCumplida
    }

    String toString(){
     "${turno} por ${cliente}"
    }
}
