
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.UUID;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Windows10
 */
public class TestMaquinaCompleto {

    public static void main(String[] args) {
        UUID id = new UUID(UUID.randomUUID().getMostSignificantBits(), UUID.randomUUID().getLeastSignificantBits());
        String direccion = "calle oporto";

        Bandeja bandeja1 = new Bandeja(10, "cocacola", 2);
        Bandeja bandeja2 = new Bandeja(10, "Agua1Litro", 1.5);
        Bandeja bandeja3 = new Bandeja(1, "Biofrutas", 3);
        Bandeja bandeja4 = new Bandeja(1, "PatatasJamon", 1);
        Bandeja bandeja5 = new Bandeja(5, "Palomitas", 0.9);
        Bandeja bandeja6 = new Bandeja(4, "Almendras", 2.5);

        Moneda monedas20 = new Moneda(20, 30);
        Moneda monedas10 = new Moneda(10, 30);
        Moneda monedas5 = new Moneda(5, 30);
        Moneda monedas2 = new Moneda(2, 30);
        Moneda monedas1 = new Moneda(1, 30);
        Moneda monedas0coma50 = new Moneda(0.50, 30);
        Moneda monedas0coma20 = new Moneda(0.20, 30);
        Moneda monedas0coma10 = new Moneda(0.10, 30);

        TarjetaCredito tarjeta1 = new TarjetaCredito("1234456884569563", LocalDate.now(), "569");
        TarjetaCredito tarjeta2 = new TarjetaCredito("1234456884879563", LocalDate.now(), "454");
        TarjetaCredito tarjeta3 = new TarjetaCredito("1234456886369563", LocalDate.now(), "586");

        Maquina maquina1 = new Maquina(id, direccion, bandeja1, bandeja2, bandeja3, bandeja4, bandeja5, bandeja6,
                monedas20, monedas10, monedas5, monedas2, monedas1, monedas0coma50, monedas0coma20, monedas0coma10,
                tarjeta1, tarjeta2, tarjeta3);

        System.out.println(maquina1.informacionCompletaMaquina());
        System.out.println(tarjeta1.getCvv());
        System.out.println( tarjeta1.getNumTarjeta());

        boolean eleccionModoValida = false;
        int eleccionModo = 0;
        boolean apagarMaquina = false;
        do {
            do {
                String texto = JOptionPane.showInputDialog("Elige el modo de uso: \n 1.Modo venta \n 2.Modo Administardor");
                try {
                    eleccionModo = Integer.parseInt(texto);
                    eleccionModoValida = true;
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "Has introducido un caracter erroneo, introduce un caracter numerico ");
                }
            } while (!eleccionModoValida);
            if (eleccionModo != 1 && eleccionModo != 2) {
                JOptionPane.showMessageDialog(null, "Introduce un numero que este en el menu por favor");
            }
            switch (eleccionModo) {
                case 1:
                    int eleccionUsuario = 0;
                    boolean eleccionModoUsuarioValida = false;
                    do {
                        do {
                            String text = JOptionPane.showInputDialog("Elige que opcion deseas realizar\n"
                                    + "1.Consultar precio\n2.Comprar producto\n3.Salir modo venta");
                            try {
                                eleccionUsuario = Integer.parseInt(text);
                                eleccionModoUsuarioValida = true;
                            } catch (NumberFormatException nfe) {
                                JOptionPane.showMessageDialog(null, "Has introducido un caracter erroneo, introduce un caracter numerico ");
                            }
                        } while (!eleccionModoUsuarioValida);
                        if (eleccionModo < 1 || eleccionModo > 3) {
                            JOptionPane.showInputDialog("Introduce un numero que este en el menu por favor");
                        }
                        switch (eleccionUsuario) {
                            case 1:
                                String saberPrecioProducto = "";
                                do {
                                    saberPrecioProducto = JOptionPane.showInputDialog("Tecle el identificador del producto que "
                                            + " desee saber el precio\n-" + bandeja1.getNombreProducto() + "tiene codigo: " + bandeja1.getId() + "\n"
                                            + "-" + bandeja2.getNombreProducto() + " tiene codigo: " + bandeja2.getId() + "\n"
                                            + "-" + bandeja3.getNombreProducto() + " tiene codigo: " + bandeja3.getId() + "\n"
                                            + "-" + bandeja4.getNombreProducto() + " tiene codigo: " + bandeja4.getId() + "\n"
                                            + "-" + bandeja5.getNombreProducto() + " tiene codigo: " + bandeja5.getId() + "\n"
                                            + "-" + bandeja6.getNombreProducto() + " tiene codigo: " + bandeja6.getId());
                                    if (bandeja1.getId().equals(saberPrecioProducto)) {
                                        JOptionPane.showMessageDialog(null, bandeja1.getPrecioProducto());
                                    } else if (bandeja2.equals(saberPrecioProducto)) {
                                        JOptionPane.showMessageDialog(null, bandeja2.getPrecioProducto());
                                    } else if (bandeja3.equals(saberPrecioProducto)) {
                                        JOptionPane.showMessageDialog(null, bandeja3.getPrecioProducto());
                                    } else if (bandeja4.equals(saberPrecioProducto)) {
                                        JOptionPane.showMessageDialog(null, bandeja4.getPrecioProducto());
                                    } else if (bandeja5.equals(saberPrecioProducto)) {
                                        JOptionPane.showMessageDialog(null, bandeja5.getPrecioProducto());
                                    } else if (bandeja6.equals(saberPrecioProducto)) {
                                        JOptionPane.showMessageDialog(null, bandeja6.getPrecioProducto());
                                    }
                                    if (!saberPrecioProducto.equals(bandeja1.getId()) && !saberPrecioProducto.equals(bandeja2.getId()) && !saberPrecioProducto.equals(bandeja3.getId())
                                            && !saberPrecioProducto.equals(bandeja4.getId()) && !saberPrecioProducto.equals(bandeja5.getId()) && !saberPrecioProducto.equals(bandeja6.getId())) {
                                        JOptionPane.showMessageDialog(null, "Introduzca un codigo valido");
                                    }
                                } while (!saberPrecioProducto.equals(bandeja1.getId()) && !saberPrecioProducto.equals(bandeja2.getId()) && !saberPrecioProducto.equals(bandeja3.getId())
                                        && !saberPrecioProducto.equals(bandeja4.getId()) && !saberPrecioProducto.equals(bandeja5.getId()) && !saberPrecioProducto.equals(bandeja6.getId()));
                                break;

                            case 2:
                                String productoAComprar = "";
                                String modoPago = "";
                                Bandeja bandejaProductoCompra=new Bandeja();
                                do {
                                    productoAComprar = JOptionPane.showInputDialog("Tecle el identificador que desea comprar:\n "
                                            + bandeja1.getNombreProducto() + "tiene codigo: " + bandeja1.getId() + "\n"
                                            + "-" + bandeja2.getNombreProducto() + " tiene codigo: " + bandeja2.getId() + "\n"
                                            + "-" + bandeja3.getNombreProducto() + " tiene codigo: " + bandeja3.getId() + "\n"
                                            + "-" + bandeja4.getNombreProducto() + " tiene codigo: " + bandeja4.getId() + "\n"
                                            + "-" + bandeja5.getNombreProducto() + " tiene codigo: " + bandeja5.getId() + "\n"
                                            + "-" + bandeja6.getNombreProducto() + " tiene codigo: " + bandeja6.getId());
                                    if (bandeja1.getId().equals(productoAComprar)) {
                                        JOptionPane.showMessageDialog(null, bandeja1.getPrecioProducto());
                                        bandejaProductoCompra=bandeja1;
                                    } else if (bandeja2.equals(productoAComprar)) {
                                        JOptionPane.showMessageDialog(null, bandeja2.getPrecioProducto());
                                        bandejaProductoCompra=bandeja1;
                                    } else if (bandeja3.equals(productoAComprar)) {
                                        JOptionPane.showMessageDialog(null, bandeja3.getPrecioProducto());
                                        bandejaProductoCompra=bandeja1;
                                    } else if (bandeja4.equals(productoAComprar)) {
                                        JOptionPane.showMessageDialog(null, bandeja4.getPrecioProducto());
                                        bandejaProductoCompra=bandeja1;
                                    } else if (bandeja5.equals(productoAComprar)) {
                                        JOptionPane.showMessageDialog(null, bandeja5.getPrecioProducto());
                                        bandejaProductoCompra=bandeja1;
                                    } else if (bandeja6.equals(productoAComprar)) {
                                        JOptionPane.showMessageDialog(null, bandeja6.getPrecioProducto());
                                        bandejaProductoCompra=bandeja1;
                                    }
                                    if (!productoAComprar.equals(bandeja1.getId()) && !productoAComprar.equals(bandeja2.getId()) && !productoAComprar.equals(bandeja3.getId())
                                            && !productoAComprar.equals(bandeja4.getId()) && !productoAComprar.equals(bandeja5.getId()) && !productoAComprar.equals(bandeja6.getId())) {
                                        JOptionPane.showMessageDialog(null, "Introduzca un codigo valido");
                                    }else{
                                        do {
                                            modoPago = JOptionPane.showInputDialog("Selecciona el metodo de pago: \n1.Efectivo\n2.Tarjeta\n3.Cancelar compra ");
                                            if (!modoPago.equals("1") && !modoPago.equals("2")&& !modoPago.equals("3")) {
                                                JOptionPane.showMessageDialog(null, "Introduce una opcion del menu");
                                            }else {
                                                switch (modoPago){
                                                    case "1":                    //Pago con efectivo
                                                        JOptionPane.showMessageDialog(null,"opcion uno");
                                                        break;
                                                    case "2":                   //Pago con tarjeta
                                                        TarjetaCredito tarjetaTemporal =new TarjetaCredito("1",LocalDate.now(),"123");
                                                        do {

                                                            String numeroTarjetaCliente=JOptionPane.showInputDialog(null,"Instroduce el numero de la tarjeta de credito");
                                                            String numeroCVVCliente=JOptionPane.showInputDialog(null,"Instroduce el CVV de la tarjeta de credito");
                                                            boolean diaCorrecto=false;
                                                            boolean mesCorrecto=false;
                                                            boolean anioCorrecto=false;
                                                            int diaFechaVencimiento=0;
                                                            int mesFechaVencimiento=0;
                                                            int anioFechaVencimiento=0;


                                                            do {//-----------------------------------------formato dia numerico----------------------------------------
                                                                try{
                                                                    String textoDiaFechaVencimiento=JOptionPane.showInputDialog(null,"Instroduce el dia de la tarjeta de redito");
                                                                    diaFechaVencimiento=Integer.parseInt(textoDiaFechaVencimiento);
                                                                    diaCorrecto=true;
                                                                }catch( NumberFormatException nfe){
                                                                    JOptionPane.showMessageDialog(null,"Introduce una entrada valida");
                                                                }
                                                            }while(!diaCorrecto);
                                                            do {//-------------------------------------------formato mes numerico---------------------------------------
                                                                try{
                                                                    String textoMesFechaVencimiento=JOptionPane.showInputDialog(null,"Introduce el mes de la tarjeta de redito");
                                                                    mesFechaVencimiento=Integer.parseInt(textoMesFechaVencimiento);
                                                                    mesCorrecto=true;
                                                                }catch (NumberFormatException nfe){
                                                                    JOptionPane.showMessageDialog(null,"Introduce una entrada valida");
                                                                }
                                                            }while(!mesCorrecto);
                                                            do {//-------------------------------------------formato anio numerico---------------------------------------------
                                                                try{
                                                                    String textoAnioFechaVencimiento=JOptionPane.showInputDialog(null,"Introduce el anio de la tarjeta de redito");
                                                                    anioFechaVencimiento=Integer.parseInt(textoAnioFechaVencimiento);
                                                                    anioCorrecto=true;
                                                                }catch (NumberFormatException nfe){
                                                                    JOptionPane.showMessageDialog(null,"Introduce una entrada valida");
                                                                }
                                                            }while(!anioCorrecto);
                                                             LocalDate fechaCliente= LocalDate.of(diaFechaVencimiento,mesFechaVencimiento,anioFechaVencimiento);
                                                             tarjetaTemporal.setNumTarjeta(numeroTarjetaCliente);
                                                             tarjetaTemporal.setFechaVencimiento(LocalDate.now());
                                                             tarjetaTemporal.setCvv(numeroCVVCliente);
                                                             if (maquina1.tarjetaEnMiBaseDeDatos(tarjetaTemporal)){
                                                                 maquina1.compraConTarjeta(bandejaProductoCompra.getPrecioProducto());
                                                                 JOptionPane.showMessageDialog(null,"La tarjeta introducida ha sido validada correctamente");
                                                             }else{
                                                                 JOptionPane.showMessageDialog(null,"La tarjeta introducida no se corresponde con ninguna de las que tenemos guardadas");

                                                             }
                                                        }while (!maquina1.tarjetaEnMiBaseDeDatos(tarjetaTemporal));
                                                        break;
                                                }
                                            }
                                        } while (!modoPago.equals("1")&&!modoPago.equals("2")&&!modoPago.equals("3"));
                                    }
                                } while ((!productoAComprar.equals(bandeja1.getId()) && !productoAComprar.equals(bandeja2.getId()) && !productoAComprar.equals(bandeja3.getId())
                                        && !productoAComprar.equals(bandeja4.getId()) && !productoAComprar.equals(bandeja5.getId()) && !productoAComprar.equals(bandeja6.getId()))
                                        &&!modoPago.equals("1")&&!modoPago.equals("2")&&!modoPago.equals("3"));
                                break;
                        }
                    } while (eleccionUsuario != 3);
                    break;
                case 2://---------------------------------------------MODO ADMINISTRADOR-------------------------------------
                    String codigoAdministrador = "";
                    String eleccionAdministrador = "";
                    do {
                        codigoAdministrador = JOptionPane.showInputDialog(null, "Introduzca el numero secreto de administrador:\nNo es " + maquina1.getContrasenaAdministrador() + " aso que no pruebes esa");
                        if (!codigoAdministrador.equals(maquina1.getContrasenaAdministrador())) {
                            JOptionPane.showMessageDialog(null, "El numero secreto no es correcto, intentelo de nuevo");
                        }
                        if (codigoAdministrador.equals(maquina1.getContrasenaAdministrador())) {
                            do {
                                eleccionAdministrador = JOptionPane.showInputDialog(null, "Teclee la opcion que deseas realizar:\n1.Mostrar estado de la maquina\n"
                                        + "2.Cambiar codigo de una bandeja\n3.Cambiar producto de una bandeja\n4.Apagar maquina\n5.Cambiar stock de bandejas\n6.Consultar dinero recaudado mediante tarjeta.\n7.Salir del modo administrador");
                                if (!eleccionAdministrador.equals("1") && !eleccionAdministrador.equals("2") && !eleccionAdministrador.equals("3")
                                        && !eleccionAdministrador.equals("4") && !eleccionAdministrador.equals("5")) {
                                    JOptionPane.showMessageDialog(null, "Teclee una opcion valida del menu");
                                }
                                switch (eleccionAdministrador) {
                                    case "1": //-------------------------Informacion completa de la maquina--------------------------
                                        JOptionPane.showMessageDialog(null, maquina1.informacionCompletaMaquina());
                                        break;
                                    case "2"://-------------------------Cambiar codigo de una bandeja-----------------------------------
                                        String bandejaSaberId = "";
                                        do {
                                            bandejaSaberId = JOptionPane.showInputDialog(null, "Teclee la bandeja que desees cambiar el codigo: \n"
                                                    + "1.Bandeja que tiene codigo " + bandeja1.getId() + " que contiene " + bandeja1.getNombreProducto() + "\n"
                                                    + "2.Bandeja que tiene codigo " + bandeja2.getId() + " que contiene " + bandeja2.getNombreProducto() + "\n"
                                                    + "3.Bandeja que tiene codigo " + bandeja3.getId() + " que contiene " + bandeja3.getNombreProducto() + "\n"
                                                    + "4.Bandeja que tiene codigo " + bandeja4.getId() + " que contiene " + bandeja4.getNombreProducto() + "\n"
                                                    + "5.Bandeja que tiene codigo " + bandeja5.getId() + " que contiene " + bandeja5.getNombreProducto() + "\n"
                                                    + "6.Bandeja que tiene codigo " + bandeja6.getId() + " que contiene " + bandeja6.getNombreProducto() + "\n"
                                                    + "7.Volver al modo menu del administrador.");

                                            switch (bandejaSaberId) {
                                                case "1":
                                                    cambiarId(bandeja1);
                                                    break;
                                                case "2":
                                                    cambiarId(bandeja2);
                                                    break;
                                                case "3":
                                                    cambiarId(bandeja3);
                                                    break;
                                                case "4":
                                                    cambiarId(bandeja4);
                                                    break;
                                                case "5":
                                                    cambiarId(bandeja5);
                                                    break;
                                                case "6":
                                                    cambiarId(bandeja6);
                                                    break;
                                            }
                                            if (!bandejaSaberId.equals("1") && !bandejaSaberId.equals("2") && !bandejaSaberId.equals("3") && !bandejaSaberId.equals("4") && !bandejaSaberId.equals("5") && !bandejaSaberId.equals("6") && !bandejaSaberId.equals("7")) {
                                                JOptionPane.showMessageDialog(null, "Introduce un numero de los que se muestra en el menu");
                                            }
                                        } while (!bandejaSaberId.equals("7"));

                                        break;
                                    case "3"://------------------------------------Cambiar nombre y precio de bandeja------------------------------------
                                        do {
                                            bandejaSaberId = JOptionPane.showInputDialog(null, "Teclee la bandeja que desees cambiar de producto: \n"
                                                    + "1.Bandeja que tiene codigo " + bandeja1.getId() + " que contiene " + bandeja1.getNombreProducto() + " a un precio de" + bandeja1.getPrecioProducto() + "$\n"
                                                    + "2.Bandeja que tiene codigo " + bandeja2.getId() + " que contiene " + bandeja2.getNombreProducto() + " a un precio de" + bandeja1.getPrecioProducto() + "$\n"
                                                    + "3.Bandeja que tiene codigo " + bandeja3.getId() + " que contiene " + bandeja3.getNombreProducto() + " a un precio de" + bandeja1.getPrecioProducto() + "$\n"
                                                    + "4.Bandeja que tiene codigo " + bandeja4.getId() + " que contiene " + bandeja4.getNombreProducto() + " a un precio de" + bandeja1.getPrecioProducto() + "$\n"
                                                    + "5.Bandeja que tiene codigo " + bandeja5.getId() + " que contiene " + bandeja5.getNombreProducto() + " a un precio de" + bandeja1.getPrecioProducto() + "$\n"
                                                    + "6.Bandeja que tiene codigo " + bandeja6.getId() + " que contiene " + bandeja6.getNombreProducto() + " a un precio de" + bandeja1.getPrecioProducto() + "$\n"
                                                    + "7.Volver al modo menu del administrador.");
                                            String nuevoProducto = "";
                                            double nuevoPrecioProducto;
                                            boolean precioCorrecto = false;
                                            switch (bandejaSaberId) {
                                                case "1":
                                                    cambiarProducto(bandeja1);
                                                    break;
                                                case "2":
                                                    cambiarProducto(bandeja2);
                                                    break;
                                                case "3":
                                                    cambiarProducto(bandeja3);
                                                    break;
                                                case "4":
                                                    cambiarProducto(bandeja4);
                                                    break;
                                                case "5":
                                                    cambiarProducto(bandeja5);
                                                    break;
                                                case "6":
                                                    cambiarProducto(bandeja6);
                                                    break;
                                            }
                                            if (!bandejaSaberId.equals("1") && !bandejaSaberId.equals("2") && !bandejaSaberId.equals("3") && !bandejaSaberId.equals("4") && !bandejaSaberId.equals("5") && !bandejaSaberId.equals("6") && !bandejaSaberId.equals("7")) {
                                                JOptionPane.showMessageDialog(null, "Introduce un numero de los que se muestra en el menu");
                                            }
                                        } while (!bandejaSaberId.equals("7"));
                                        break;
                                    case "4"://---------------------------------Apagar maquina----------------------------------------------
                                        apagarMaquina = true;
                                        break;
                                    case "5"://--------------------------------Cambiar stock de bandeja--------------------------------------
                                        do {
                                            bandejaSaberId = JOptionPane.showInputDialog(null, "Teclee la bandeja que desees cambiar de stock \n"
                                                    + "1.Bandeja que contiene " + bandeja1.getNombreProducto() + " con un stock de " + bandeja1.getStock() + "\n"
                                                    + "2.Bandeja que contiene " + bandeja2.getNombreProducto() + " con un stock de " + bandeja2.getStock() + "\n"
                                                    + "3.Bandeja que contiene " + bandeja3.getNombreProducto() + " con un stock de " + bandeja3.getStock() + "\n"
                                                    + "4.Bandeja que contiene " + bandeja4.getNombreProducto() + " con un stock de " + bandeja4.getStock() + "\n"
                                                    + "5.Bandeja que contiene " + bandeja5.getNombreProducto() + " con un stock de " + bandeja5.getStock() + "\n"
                                                    + "6.Bandeja que contiene " + bandeja6.getNombreProducto() + " con un stock de " + bandeja6.getStock() + "\n"
                                                    + "7.Reponer todas las bandejas con la maxima capacidad" + "\n"
                                                    + "8.Volver al modo menu del administrador.");
                                            String nuevoProducto = "";
                                            double nuevoPrecioProducto;
                                            boolean precioCorrecto = false;
                                            switch (bandejaSaberId) {
                                                case "1":
                                                    cambiarStock(bandeja1);
                                                    break;
                                                case "2":
                                                    cambiarStock(bandeja2);
                                                    break;
                                                case "3":
                                                    cambiarStock(bandeja3);
                                                    break;
                                                case "4":
                                                    cambiarStock(bandeja4);
                                                    break;
                                                case "5":
                                                    cambiarStock(bandeja5);
                                                    break;
                                                case "6":
                                                    cambiarStock(bandeja6);
                                                    break;
                                                case "7":
                                                    bandeja1.rellenarBandeja();
                                                    bandeja2.rellenarBandeja();
                                                    bandeja3.rellenarBandeja();
                                                    bandeja4.rellenarBandeja();
                                                    bandeja5.rellenarBandeja();
                                                    bandeja6.rellenarBandeja();
                                                    break;

                                            }
                                            if (!bandejaSaberId.equals("1") && !bandejaSaberId.equals("2") && !bandejaSaberId.equals("3") && !bandejaSaberId.equals("4") && !bandejaSaberId.equals("5") && !bandejaSaberId.equals("6") && !bandejaSaberId.equals("7") && !bandejaSaberId.equals("8")) {
                                                JOptionPane.showMessageDialog(null, "Introduce un numero de los que se muestra en el menu");
                                            }
                                        } while (!bandejaSaberId.equals("8"));
                                        break;
                                    case "6":
                                        JOptionPane.showMessageDialog(null,"Se ha recaudado "+maquina1.getDineroRecaudadoConTarjeta()+" euros mediante tarjeta de credito");
                                        break;
                                }
                            } while (!eleccionAdministrador.equals("7") && !eleccionAdministrador.equals("4"));
                        }
                    } while (!codigoAdministrador.equals(maquina1.getContrasenaAdministrador()));
            }
        } while (!apagarMaquina);
    }

    public static void cambiarProducto(Bandeja bandeja) {
        String nuevoProducto = "";
        double nuevoPrecioProducto = 0;
        boolean precioCorrecto = false;
        nuevoProducto = JOptionPane.showInputDialog(null, "Introduce el nombre que va a tener el producto con codigo " + bandeja.getId());
        bandeja.setNombreProducto(nuevoProducto);
        do {
            try {
                String texto = JOptionPane.showInputDialog(null, "Introduce el precio que va a tener el producto llamado " + bandeja.getNombreProducto());
                nuevoPrecioProducto = Double.parseDouble(texto);
                precioCorrecto = true;

            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Introduce un valor numerico");
            }
        } while (!precioCorrecto);
        bandeja.setPrecioProducto(nuevoPrecioProducto);
    }

    public static void cambiarId(Bandeja bandeja) {
        bandeja.setId();
        JOptionPane.showMessageDialog(null, "La bandeja que contiene  " + bandeja.getNombreProducto() + " ahora tiene el codigo " + bandeja.getId());
    }

    public static void cambiarStock(Bandeja bandeja) {
        int numeroDeProductoAMeter = 0;
        boolean numeroAMeterCorrecto = false;
        do {
            try {
                String texto = JOptionPane.showInputDialog("Introduce la cantidad de producto que vas a reponer");
                numeroDeProductoAMeter = Integer.parseInt(texto);
                numeroAMeterCorrecto = true;

            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Introduce un valor numerico");
            }
        } while (!numeroAMeterCorrecto);
        bandeja.meterProducto(numeroDeProductoAMeter);
    }
}
