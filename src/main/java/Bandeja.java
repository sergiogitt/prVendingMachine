
import java.util.Random;

public class Bandeja {

    final int MAXIMO_PRODUCTO_POR_BANDEJA = 15;
    int id;
    int stock;
    String nombreProducto;
    double precioProducto;

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
    }

    public void sacarProducto() {
        if (this.stock - 1 == -1) {
            System.out.println("No es posible sacar producto.Est√° acabado");
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

    public int getId() {
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

    public static int numeroAleatorio() {
        int numero;
        String texto = "";
        Random aleatorio = new Random();
        for (int i = 0; i < 3; i++) {
            numero = aleatorio.nextInt();
            texto += numero;
        }
        numero = Integer.parseInt(texto);
        return numero;
    }

    public String informacionBandeja() {
        String texto = "La bandeja con ID =" + id + " que contiene " + nombreProducto + "tiene un Stock " + stock
                + " con un precio de " + precioProducto;
        if (this.stock == 0) {
            texto += "\n Hay que aÒadir mas stock";
        }
        return texto;
    }
}
