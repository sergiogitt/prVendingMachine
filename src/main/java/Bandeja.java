
import java.util.Random;
import javax.swing.JOptionPane;

public class Bandeja {

    public static final int MAXIMO_PRODUCTO_POR_BANDEJA = 15;
    private String id;
    private int stock;
    private String nombreProducto;
    private double precioProducto;
    private final int MINIMO_STOCK_BANDEJA_AVISO_REPONER = 1;
    private final int MAXIMO_STOCK_BANDEJA_AVISO_REPONER = 5;
    

    public Bandeja() {
        this.id = numeroAleatorio();
        this.stock = 0;
        this.nombreProducto = "Sin Nombre";
        this.precioProducto = 0;
    }

    public Bandeja(int stock,String id, String nombreProducto, double precioProducto) {
        if (!comprobarId(id)) {
            this.id = numeroAleatorio();
        } else {
            this.id = id;
        }
        if (stock < 0) {                                 //control para que el stock sea positivo
            this.stock = Math.abs(stock);
        } else if (stock > MAXIMO_PRODUCTO_POR_BANDEJA) {//control para que no supere el stock maximo
          
            this.stock = MAXIMO_PRODUCTO_POR_BANDEJA;
        } else if(stock==0){
            this.setStock(5);
        }else {
            this.stock = stock;
        }
        this.nombreProducto = nombreProducto;
        if (precioProducto < 0) {
            this.precioProducto = Math.abs(precioProducto);
        } else if (precioProducto == 0) {
            JOptionPane.showMessageDialog(null, "Has introducido un precio cero, vamos a poner por defecto un precio de 5 euros, si quieres cambiarlo hazlo manualmente");
            this.precioProducto=5;
        }else {
            this.precioProducto=precioProducto;
        }
    }

    public void sacarProducto() {
        if (this.stock - 1 == -1) {                     //no dejar sacar con un stock de 0 items
             JOptionPane.showMessageDialog(null,"No es posible sacar producto.Esta acabado");
        } else {
            this.stock--;
        }

    }

    public void meterProducto(int cantidad) {
        if (cantidad < 0) {
            cantidad = Math.abs(cantidad);
        }
        if (this.stock + cantidad > MAXIMO_PRODUCTO_POR_BANDEJA) {
            this.stock = MAXIMO_PRODUCTO_POR_BANDEJA;
        } else {
            this.stock += cantidad;
        }

    }

    public void setId() {
        if (!comprobarId(id)) {
            this.id = numeroAleatorio();
        } else {
            this.id = id;
        }
    }

    public void setStock(int stock) {

        if (stock < 0) {                                 //control para que el stock sea positivo
            this.stock = Math.abs(stock);
        } else if (stock > MAXIMO_PRODUCTO_POR_BANDEJA) {//control para que no supere el stock maximo
            this.stock = MAXIMO_PRODUCTO_POR_BANDEJA;
            JOptionPane.showMessageDialog(null,"No puedes poner mas de "+MAXIMO_PRODUCTO_POR_BANDEJA+" de stock, asi que el stock se ha adaptado al maximo");

        } else if(stock==0){
            JOptionPane.showMessageDialog(null,"No puedes poner 0 de stock, te pongo por defecto 5");
            this.setStock(5);
        }else {
            this.stock = stock;
        }
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        if (precioProducto < 0) {
            this.precioProducto = Math.abs(precioProducto);
        } else if (precioProducto == 0) {
            JOptionPane.showMessageDialog(null, "Has introducido un precio cero, vamos a poner por defecto un precio de 5 euros, si quieres cambiarlo hazlo manualmente");
            this.precioProducto=5;
        }
    }
    public void rellenarBandeja(){
        this.setStock(Bandeja.MAXIMO_PRODUCTO_POR_BANDEJA);
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
            texto += "\nHay que a�adir mas stock";
        } else if (this.stock <= MAXIMO_STOCK_BANDEJA_AVISO_REPONER && this.stock >= MINIMO_STOCK_BANDEJA_AVISO_REPONER) {
            texto += "\nSe recomienda a�adir mas stock";
        }
        return texto;
    }
    private boolean comprobarId(String id) {
        boolean idCorrecto = true;

        for (int i = 0; i < id.length(); i++) {

            if (!Character.isDigit(id.charAt(i))) {
                idCorrecto = false;
            }
        }
        return idCorrecto && id.length() == 3;
    }

}
