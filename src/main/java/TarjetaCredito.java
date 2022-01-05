
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

        if ((numTarjeta / Math.pow(10, 15) > 1) && ((numTarjeta / Math.pow(10, 16)) < 1)) { //comnprobacion tarjeta tiene 16 cifas
            this.numTarjeta = numTarjeta;
        } else {
            this.numTarjeta = 912343456; //COMPROBAR ERROR EN CANTIDAD DE DIGITOS QUE ACEPTA!!!!!!
        }

        if (fechaVencimiento.isBefore(LocalDate.now())) {                                  // Si la tarjeta ha caducado antes de hoy se crea otra
                                                                                           //con un vencimiento de 5 años
            this.fechaVencimiento = LocalDate.now().plusYears(5);

        } else {
            this.fechaVencimiento = fechaVencimiento;

        }

        if ((cvv / Math.pow(10, 2) > 1) && ((cvv / Math.pow(10, 3)) < 1)) {                //comprobacion CVV tiene 3 cifras
            this.cvv = cvv;
        } else {
            this.cvv = 123;
        }
    }

    public boolean tarjetaValida(double numTarjeta, LocalDate fechaVencimiento, int cvv) { //comprobacion tarjeta iguales
        boolean tarjetaIgual = true;
        if (this.numTarjeta != numTarjeta || !this.fechaVencimiento.equals(fechaVencimiento) || this.cvv != cvv) {
            tarjetaIgual = false;

        }
        return tarjetaIgual;

    }
}
