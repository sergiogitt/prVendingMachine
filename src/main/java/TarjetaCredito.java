
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

    private String  numTarjeta;
    private LocalDate fechaVencimiento;
    private String cvv;

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public String getCvv() {
        return cvv;
    }

    public TarjetaCredito(String numTarjeta, LocalDate fechaVencimiento, String cvv) {

        if (numTarjeta.length() == 16) { //comprobacion tarjeta tiene 16 cifas
            this.numTarjeta = numTarjeta;
        } else {
            this.numTarjeta = "1234123412341234";
        }

        if (fechaVencimiento.isBefore(LocalDate.now())) {                                  // Si la tarjeta ha caducado antes de hoy se crea otra
                                                                                            //con un vencimiento de 5 a�os
            this.fechaVencimiento = LocalDate.now().plusYears(5);

        } else {
            this.fechaVencimiento = fechaVencimiento;

        }


        if (cvv.length() == 3) {                //comprobacion CVV tiene 3 cifras
            this.cvv = cvv;
        } else {
            this.cvv = "123";
        }
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public boolean tarjetaValida(TarjetaCredito tarjetaAValidar) { //comprobacion tarjeta iguales
        boolean tarjetaIgual = false;
        if (this.numTarjeta.equals(tarjetaAValidar.getNumTarjeta())  && this.fechaVencimiento.equals(tarjetaAValidar.getFechaVencimiento())
                && this.cvv.equals(tarjetaAValidar.getCvv())) {
            tarjetaIgual = true;

        }
        return tarjetaIgual;

    }
}
