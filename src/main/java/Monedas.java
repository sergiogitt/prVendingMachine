
public class Monedas {

    private double valor;
    private int cantidadDeMonedas;
    private final int MAXIMA_CANTIDAD_MONEDAS = 30;

    public Monedas(double valor, int cantidadDeMonedas) {
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
        if (this.cantidadDeMonedas - cantidad < 0) {
            System.out.println("No hay cambio suficiente para esta moneda");
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
    
    public String informacionMonedas(){
    String texto= "De la moneda " + valor + "hay " + cantidadDeMonedas+ "unidades"; 
        if (this.cantidadDeMonedas == 0) {
            texto += "\n Hay que añadir mas monedas";
        }
    return texto;
    }
    
}

