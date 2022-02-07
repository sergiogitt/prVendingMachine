
import javax.swing.JOptionPane;

public class Moneda {
//------------------------------------ATRIBUTOS--------------------------------------------------------

    private int valor;
    private int cantidadDeMonedas;
    private static final int MAXIMA_CANTIDAD_MONEDAS = 30;
    private static final int MINIMA_MONEDA_AVISO_REPONER = 1;
    private static final int MAXIMO_MONEDA_AVISO_REPONER = 10;
//-------------------------------------CONSTRUCTOR---------------------------------------------

    public Moneda(int valor, int cantidadDeMonedas) {
        if (valor < 0) {                                    //control cantidad positiva
            this.valor = Math.abs(valor);
        }else {
            this.valor = valor;
        }
        if (cantidadDeMonedas < 0) {
            this.cantidadDeMonedas = Math.abs(cantidadDeMonedas);
        } else if(cantidadDeMonedas > MAXIMA_CANTIDAD_MONEDAS){
            this.cantidadDeMonedas = MAXIMA_CANTIDAD_MONEDAS;
        }else {
            this.cantidadDeMonedas = cantidadDeMonedas;
        }

    }
//----------------------------------------------------METODOS--------------------------------------------

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

    public void sacarMoneda(int cantidad) {             //metodo que saca moneda si hay stock de esta y avisa si no hay cambio posible
        if (cantidad < 0) {                     //control de cantidad positiva
            cantidad = Math.abs(cantidad);
            sacarMoneda(cantidad);
        }
        if (this.cantidadDeMonedas - cantidad < 0 && this.valor == 0.01) {
            JOptionPane.showMessageDialog(null, "No hay cambio suficiente intenta introducir la cantidad excata");
        } else if (this.cantidadDeMonedas - cantidad < 0) {
            JOptionPane.showMessageDialog(null, "No hay cambio suficiente para la moneda de valor " + this.valor);
        } else {
            this.cantidadDeMonedas -= cantidad;
        }
    }

    public boolean haySaldoSuficiente(double cantidad) {        //devulve true si hay stock de la moneda en la maquina
        boolean haysaldo = true;
        if (this.cantidadDeMonedas - cantidad < 0) {
            haysaldo = false;
        }
        return haysaldo;
    }

    public int cambioMonedas(double cambioADevolver) {//devulve la cantidad de monedas que se puede devolver respecto a un valor total a devolver
        int numMonedasADevolver;
        numMonedasADevolver = (int) (cambioADevolver / this.valor);
        if (cantidadDeMonedas-numMonedasADevolver>=0) {
            sacarMoneda(numMonedasADevolver);
        } else if (!haySaldoSuficiente(cambioADevolver) && this.valor == 1) {
            numMonedasADevolver = 0;
            JOptionPane.showMessageDialog(null, "No hay cambio suficiente intenta introducir la cantidad excata");
        } else {
            numMonedasADevolver = 0;
        }
        return numMonedasADevolver;
    }

    //--------------------------------------------------GETTERS---------------------------------------
    public int getValor() {
        return valor;
    }

    public int getCantidadDeMonedas() {
        return cantidadDeMonedas;
    }

    public int getMAXIMA_CANTIDAD_MONEDAS() {
        return MAXIMA_CANTIDAD_MONEDAS;
    }

    public int getMINIMA_MONEDA_AVISO_REPONER() {
        return MINIMA_MONEDA_AVISO_REPONER;
    }

    public int getMAXIMO_MONEDA_AVISO_REPONER() {
        return MAXIMO_MONEDA_AVISO_REPONER;
    }
//----------------------------------------------------SETTERS-----------------------------------------

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setCantidadDeMonedas(int cantidadDeMonedas) {
        if (cantidadDeMonedas < 0) {             //no hay cantidades negativas
            this.cantidadDeMonedas = Math.abs(cantidadDeMonedas);
        } else if(cantidadDeMonedas > MAXIMA_CANTIDAD_MONEDAS){
            this.cantidadDeMonedas = MAXIMA_CANTIDAD_MONEDAS;
        }else {
            this.cantidadDeMonedas = cantidadDeMonedas;
        }
    }
//----------------------------METODO TOSTRING MEJORADO-----------------------------------------------

    public String informacionMonedas() {
        String texto = "De la moneda " + valor/100.0 + " hay " + cantidadDeMonedas + " unidades";
        if (this.cantidadDeMonedas == 0) {
            texto += "\n***********Hay que meter mas monedas de valor " + this.getValor()/100.0 + "**************";
        } else if (this.cantidadDeMonedas <= MAXIMO_MONEDA_AVISO_REPONER && this.cantidadDeMonedas >= MINIMA_MONEDA_AVISO_REPONER) {
            texto += "\n***********Se recomienda meter mas stock de la moneda de valor " + this.getValor()/100.0 + "**************";
        }
        return texto;
    }

}
