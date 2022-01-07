
import java.time.LocalDate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Windows10
 */
public class TarjetaCredito {

    private double numTarjeta;
    private LocalDate fechaVencimiento;
    private int cvv;

    public double getNumTarjeta() {
        return numTarjeta;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public int getCvv() {
        return cvv;
    }

    public TarjetaCredito(double numTarjeta, LocalDate fechaVencimiento, int cvv) {
        String comprobacionLongitudNumeroTarjeta = String.valueOf(numTarjeta);

        if (comprobacionLongitudNumeroTarjeta.length() == 18) { //comprobacion tarjeta tiene 16 cifas
            this.numTarjeta = numTarjeta;
        } else {
            this.numTarjeta = 1234123412341234.0;
        }

        if (fechaVencimiento.isBefore(LocalDate.now())) {                                  // Si la tarjeta ha caducado antes de hoy se crea otra
                                                                                            //con un vencimiento de 5 a�os
            this.fechaVencimiento = LocalDate.now().plusYears(5);

        } else {
            this.fechaVencimiento = fechaVencimiento;

        }
        String comprobacionLongitudCVVTarjeta = String.valueOf(cvv);

        if (comprobacionLongitudCVVTarjeta.length() == 3) {                //comprobacion CVV tiene 3 cifras
            this.cvv = cvv;
        } else {
            this.cvv = 123;
        }
    }

    public boolean tarjetaValida(TarjetaCredito tarjetaAValidar) { //comprobacion tarjeta iguales
        boolean tarjetaDiferente = false;
        if (this.numTarjeta != tarjetaAValidar.getNumTarjeta() && !this.fechaVencimiento.equals(tarjetaAValidar.getFechaVencimiento())
                && this.cvv != tarjetaAValidar.getCvv()) {
            tarjetaDiferente = true;

        }
        return tarjetaDiferente;

    }
}
