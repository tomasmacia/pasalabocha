package pasalabocha

class Dinero implements Comparable<Dinero>, Serializable {
    BigDecimal monto
    Moneda moneda

    Dinero(BigDecimal monto, Moneda moneda) {
        if (monto < 0) {
            throw new IllegalArgumentException("Monto negativo")
        }
        this.monto = monto
        this.moneda = moneda
    }

    Dinero() {

    }


    @Override
    int compareTo(Dinero that) {
        int iguales = 0

        if ( this == that ) return iguales

        int comparacion = this.monto.compareTo(that.monto)
        if ( comparacion != iguales ) return comparacion

        comparacion = this.moneda <=> that.moneda
        if ( comparacion != iguales ) return comparacion

        return iguales
    }

    @Override
    boolean equals(Object o) {
        return o != null &&
                o.getClass() == Dinero.class &&
                this.monto == (BigDecimal) o.monto &&
                this.moneda == (Moneda) o.moneda
    }

    @Override
    String toString() {
        return this.monto.toString() + " " + this.moneda.toString()
    }


    Dinero plus(Dinero d){
        if (this.moneda != d.moneda) {
            throw new IllegalArgumentException("Monedas distintas")
        }
        return new Dinero(this.monto + d.monto, this.moneda)
    }

    Dinero minus(Dinero d){
        if (this.moneda != d.moneda) {
            throw new IllegalArgumentException("Monedas distintas")
        }
        return new Dinero(this.monto - d.monto, this.moneda)
    }

    Dinero multiply(def factor){
        BigDecimal factorDecimal = new BigDecimal(factor)
        BigDecimal nuevoMonto = this.monto * factorDecimal
        return new Dinero(nuevoMonto, this.moneda)
    }


    Dinero div(def factor){
        BigDecimal factorDecimal = new BigDecimal(factor)
        BigDecimal nuevoMonto = this.monto / factorDecimal
        return new Dinero(nuevoMonto, this.moneda)
    }
}

enum Moneda {
    ARS,
    USD
}