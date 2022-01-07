
import javax.swing.JOptionPane;

public class Moneda {

    private double valor;
    private int cantidadDeMonedas;
    private final int MAXIMA_CANTIDAD_MONEDAS = 30;
    private final int MINIMA_MONEDA_AVISO_REPONER = 1;
    private final int MAXIMO_MONEDA_AVISO_REPONER = 10;

    public Moneda(double valor, int cantidadDeMonedas) {
        if (valor < 0) {
            this.valor = Math.abs(valor);
        } else {
            this.valor = valor;
        }
        if (cantidadDeMonedas < 0) {
            this.cantidadDeMonedas = Math.abs(cantidadDeMonedas);
        } else {
            this.cantidadDeMonedas = cantidadDeMonedas;
        }
        if (cantidadDeMonedas > MAXIMA_CANTIDAD_MONEDAS) {
            this.cantidadDeMonedas = MAXIMA_CANTIDAD_MONEDAS;
        }

    }

    public void meterMoneda(int cantidad) {
        if (cantidad < 0) {                       //control cantidad positiva
            cantidad = Math.abs(cantidad);
        }
        if (this.cantidadDeMonedas + cantidad > MAXIMA_CANTIDAD_MONEDAS) {
            this.cantidadDeMonedas = MAXIMA_CANTIDAD_MONEDAS;
        } else {
            this.cantidadDeMonedas += cantidad;
        }

    }

    public void sacarMoneda(int cantidad) {
        if (cantidad < 0) {                     //control de cantidad positiva
            cantidad = Math.abs(cantidad);
        }
        if (this.cantidadDeMonedas - cantidad < 0 && this.valor == 0.10) {
            JOptionPane.showMessageDialog(null, "No hay cambio suficiente intenta introducir la cantidad excata");
        } else if (this.cantidadDeMonedas - cantidad < 0) {
            JOptionPane.showMessageDialog(null, "No hay cambio suficiente para la moneda de valor " + this.valor);
        } else {
            this.cantidadDeMonedas -= cantidad;

        }

    }

    public int cambioMonedas(double cambioADevolver) {
        int numMonedasADevolver;
        numMonedasADevolver = (int) (cambioADevolver / this.valor);

        sacarMoneda(numMonedasADevolver);
        return numMonedasADevolver;
    }

    public double getValor() {
        return valor;
    }

    public int getCantidadDeMonedas() {
        return cantidadDeMonedas;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setCantidadDeMonedas(int cantidadDeMonedas) {
        this.cantidadDeMonedas = cantidadDeMonedas;
    }

    public String informacionMonedas() {
        String texto = "De la moneda " + valor + " hay " + cantidadDeMonedas + " unidades";
        if (this.cantidadDeMonedas == 0) {
            texto += "\nHay que añadir mas monedas";
        } else if (this.cantidadDeMonedas <= MAXIMO_MONEDA_AVISO_REPONER && this.cantidadDeMonedas >= MINIMA_MONEDA_AVISO_REPONER) {
            texto += "\nSe recomienda añadir mas stock";
        }
        return texto;
    }

}
