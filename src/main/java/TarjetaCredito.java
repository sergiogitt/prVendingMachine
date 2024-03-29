
import java.time.LocalDate;

//------------------------------------ATRIBUTOS--------------------------------------------------------
public class TarjetaCredito {
    private String  numTarjeta;
    private LocalDate fechaVencimiento;
    private String cvv;
//-------------------------------------CONSTRUCTORES---------------------------------------------
    public TarjetaCredito(String numTarjeta, LocalDate fechaVencimiento, String cvv) {

        if (comprobarSiEsNumericoYLongitud(numTarjeta,16)) {                 //comprobacion tarjeta tiene 16 cifas
            this.numTarjeta = numTarjeta;
        } else {
            this.numTarjeta = "1234123412341234";
        }
        if (fechaVencimiento.isBefore(LocalDate.now())) {                               // Si la tarjeta ha caducado antes de hoy se crea otra
            this.fechaVencimiento = LocalDate.now().plusYears(5);                       // con un vencimiento de 5 anios
        } else {
            this.fechaVencimiento = fechaVencimiento;
        }
        if (comprobarSiEsNumericoYLongitud(cvv,3)) {                         //comprobacion CVV tiene 3 cifras
            this.cvv = cvv;
        } else {
            this.cvv = "123";
        }
    }
//----------------------------------------------------SETTERS-----------------------------------------
    public void setNumTarjeta(String numTarjeta) {
        if (comprobarSiEsNumericoYLongitud(numTarjeta,16)) {                 //comprobacion tarjeta tiene 16 cifas
            this.numTarjeta = numTarjeta;
        } else {
            this.numTarjeta = "1234123412341234";
        }
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public void setCvv(String cvv) {
        if (comprobarSiEsNumericoYLongitud(cvv,3)) {                         //comprobacion CVV tiene 3 cifras
            this.cvv = cvv;
        } else {
            this.cvv = "123";
        }
    }
//--------------------------------------------------GETTERS---------------------------------------
    public String getNumTarjeta() {
        return numTarjeta;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public String getCvv() {
        return cvv;
    }
//----------------------------------------------------METODOS--------------------------------------------
    public boolean tarjetaValida(TarjetaCredito tarjetaAValidar) { //comprobacion tarjeta iguales
        boolean tarjetaIgual = false;
        if (this.numTarjeta.equals(tarjetaAValidar.getNumTarjeta())  && this.fechaVencimiento.equals(tarjetaAValidar.getFechaVencimiento())
                && this.cvv.equals(tarjetaAValidar.getCvv())) {
            tarjetaIgual = true;
        }
        return tarjetaIgual;
    }
    private boolean comprobarSiEsNumericoYLongitud(String texto, int longitud){
        boolean cadenaNumerica=true;
        for(int i=0;i<texto.length();i++){
            if (!Character.isDigit(texto.charAt(i))){
                cadenaNumerica=false;
            }
        }
        return cadenaNumerica&&texto.length()==longitud;
    }
}
