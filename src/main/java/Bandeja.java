
import java.util.Random;
import javax.swing.JOptionPane;

public class Bandeja {

    private final int MAXIMO_PRODUCTO_POR_BANDEJA = 15;
    private String id;
    private int stock;
    private String nombreProducto;
    private double precioProducto;
    private final int MINIMA_BANDEJA_AVISO_REPONER = 1;
    private final int MAXIMO_BANDEJA_AVISO_REPONER = 5;
    

    public Bandeja() {
        this.id = numeroAleatorio();
        this.stock = 0;
        this.nombreProducto = "Sin Nombre";
        this.precioProducto = 0;
    }

    public Bandeja(int stock, String nombreProducto, double precioProducto) {
        this.id = numeroAleatorio();

        if (stock < 0) {                                 //control para que el stock sea positivo
            this.stock = Math.abs(stock);
        } else if (stock > MAXIMO_PRODUCTO_POR_BANDEJA) {//control para que no supere el stock maximo
            this.stock = MAXIMO_PRODUCTO_POR_BANDEJA;
        } else {
            this.stock = stock;
        }
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        if (precioProducto < 0) {
            this.precioProducto = Math.abs(precioProducto);
        } else if (precioProducto == 0) {
            JOptionPane.showMessageDialog(null, "Has introducido un precio cero, vamos a poner por defecto un precio de 5 euros, si quieres cambiarlo hazlo manualmente");
            this.precioProducto=5;
        }
    }

    public void sacarProducto() {
        if (this.stock - 1 == -1) {
             JOptionPane.showMessageDialog(null,"No es posible sacar producto.Esta acabado");
        } else {
            this.stock--;
        }

    }

    public void meterProducto(int cantidad) {
        if (cantidad < 0) {                       //control cantidad positiva
            cantidad = Math.abs(cantidad);
        }
        if (this.stock + cantidad > MAXIMO_PRODUCTO_POR_BANDEJA) {
            this.stock = MAXIMO_PRODUCTO_POR_BANDEJA;
        } else {
            this.stock += cantidad;
        }

    }

    public void setId() {
        this.id = numeroAleatorio();
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getMAXIMO_PRODUCTO_POR_BANDEJA() {
        return MAXIMO_PRODUCTO_POR_BANDEJA;
    }

    public String getId() {
        return id;
    }

    public int getStock() {
        return stock;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public static String numeroAleatorio() {
        int numero;
        String texto = "";
        Random aleatorio = new Random();
        for (int i = 0; i < 3; i++) {
            numero = aleatorio.nextInt(10);
            texto += numero;
        }
       
        return texto;
    }

    public String informacionBandeja() {
        String texto = "Una bandeja con ID = " + id + " que contiene " + nombreProducto + " tiene un Stock " + stock
                + " con un precio de " + precioProducto;
        if (this.stock == 0) {
            texto += "\nHay que añadir mas stock";
        } else if (this.stock <= MAXIMO_BANDEJA_AVISO_REPONER && this.stock >= MINIMA_BANDEJA_AVISO_REPONER) {
            texto += "\nSe recomienda añadir mas stock";
        }
        return texto;
    }
}
