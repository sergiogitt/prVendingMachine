public class Monedas {
    private double valor;
    private int cantidadDeMonedas;
    private final int MAXIMA_CANTIDAD_MONEDAS=30;

    public Monedas(double valor, int cantidadDeMonedas) {
        if(valor<0){
            this.valor=Math.abs(valor);
        }else{
            this.valor = valor;
        }
        if(cantidadDeMonedas<0){
            this.cantidadDeMonedas=Math.abs(cantidadDeMonedas);
        }else{
            this.cantidadDeMonedas = cantidadDeMonedas;
        }
        if (cantidadDeMonedas>MAXIMA_CANTIDAD_MONEDAS){
            this.cantidadDeMonedas=MAXIMA_CANTIDAD_MONEDAS;
        }

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
}
