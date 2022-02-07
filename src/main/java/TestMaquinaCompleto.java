
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;
import javax.swing.JOptionPane;

public class TestMaquinaCompleto {

    public static void main(String[] args) {

        UUID id = new UUID(UUID.randomUUID().getMostSignificantBits(), UUID.randomUUID().getLeastSignificantBits());
        String direccion = "calle oporto";

        Bandeja bandeja1 = new Bandeja(0, "001", "cocacola", 200);
        Bandeja bandeja2 = new Bandeja(10, "002", "Agua1Litro", 150);
        Bandeja bandeja3 = new Bandeja(1, "003", "Biofrutas", 300);
        Bandeja bandeja4 = new Bandeja(1, "101", "PatatasJamon", 100);
        Bandeja bandeja5 = new Bandeja(5, "102", "Palomitas", 90);
        Bandeja bandeja6 = new Bandeja(4, "103", "Almendras", 250);

        Moneda monedas20 = new Moneda(2000, 5);
        Moneda monedas10 = new Moneda(1000, 5);
        Moneda monedas5 = new Moneda(500, 15);
        Moneda monedas2 = new Moneda(200, 15);
        Moneda monedas1 = new Moneda(100, 15);
        Moneda monedas0coma50 = new Moneda(50, 15);
        Moneda monedas0coma20 = new Moneda(20, 10);
        Moneda monedas0coma10 = new Moneda(10, 15);
        Moneda monedas0coma5 = new Moneda(5, 15);
        Moneda monedas0coma2 = new Moneda(2, 10);
        Moneda monedas0coma1 = new Moneda(1, 10);

        Moneda listaMonedas[] = {monedas20, monedas10, monedas5, monedas2, monedas1, monedas0coma50, monedas0coma20, monedas0coma10, monedas0coma5, monedas0coma2, monedas0coma1};

        TarjetaCredito tarjeta1 = new TarjetaCredito("1234456884569563", LocalDate.now(), "569");
        TarjetaCredito tarjeta2 = new TarjetaCredito("1234456884879563", LocalDate.now(), "454");
        TarjetaCredito tarjeta3 = new TarjetaCredito("1234456886369563", LocalDate.now(), "586");

        Maquina maquina1 = new Maquina(id, direccion, bandeja1, bandeja2, bandeja3, bandeja4, bandeja5, bandeja6,
                listaMonedas,
                tarjeta1, tarjeta2, tarjeta3);

        System.out.println(maquina1.informacionCompletaMaquina());
        System.out.println(tarjeta1.getCvv());
        System.out.println(tarjeta1.getNumTarjeta());

        boolean eleccionModoValida = false;
        int eleccionModo = 0;
        boolean apagarMaquina = false;
        do {//-------------bucle principal del programa que solo finaliza cuando el administrador apaga la maquina
            do {//---------bucle eleccion del modo de uso
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
                case 1://-------------Modo usuario-----------------------
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
                            case 1://-----------------------Consultar precio--------------------------------------
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
                                        JOptionPane.showMessageDialog(null, bandeja1.getPrecioProducto() / 100);
                                    } else if (bandeja2.getId().equals(saberPrecioProducto)) {
                                        JOptionPane.showMessageDialog(null, bandeja2.getPrecioProducto() / 100);
                                    } else if (bandeja3.getId().equals(saberPrecioProducto)) {
                                        JOptionPane.showMessageDialog(null, bandeja3.getPrecioProducto() / 100);
                                    } else if (bandeja4.getId().equals(saberPrecioProducto)) {
                                        JOptionPane.showMessageDialog(null, bandeja4.getPrecioProducto() / 100);
                                    } else if (bandeja5.getId().equals(saberPrecioProducto)) {
                                        JOptionPane.showMessageDialog(null, bandeja5.getPrecioProducto() / 100);
                                    } else if (bandeja6.getId().equals(saberPrecioProducto)) {
                                        JOptionPane.showMessageDialog(null, bandeja6.getPrecioProducto() / 100);
                                    }
                                    if (!saberPrecioProducto.equals(bandeja1.getId()) && !saberPrecioProducto.equals(bandeja2.getId()) && !saberPrecioProducto.equals(bandeja3.getId())
                                            && !saberPrecioProducto.equals(bandeja4.getId()) && !saberPrecioProducto.equals(bandeja5.getId()) && !saberPrecioProducto.equals(bandeja6.getId())) {
                                        JOptionPane.showMessageDialog(null, "Introduzca un codigo valido");
                                    }
                                } while (!saberPrecioProducto.equals(bandeja1.getId()) && !saberPrecioProducto.equals(bandeja2.getId()) && !saberPrecioProducto.equals(bandeja3.getId())
                                        && !saberPrecioProducto.equals(bandeja4.getId()) && !saberPrecioProducto.equals(bandeja5.getId()) && !saberPrecioProducto.equals(bandeja6.getId()));
                                break;

                            case 2://---------------------Comprar producto--------------------
                                String productoAComprar = "";
                                String modoPago = "";
                                Bandeja bandejaProductoCompra = new Bandeja(1, "303", "prueba", 10);
                                do {
                                    productoAComprar = JOptionPane.showInputDialog("Tecle el identificador que desea comprar:\n "
                                            + "-" + bandeja1.getNombreProducto() + " tiene codigo: " + bandeja1.getId() + " con un precio de " + bandeja1.getPrecioProducto() / 100 + "\n"
                                            + "-" + bandeja2.getNombreProducto() + " tiene codigo: " + bandeja2.getId() + " con un precio de " + bandeja2.getPrecioProducto() / 100 + "\n"
                                            + "-" + bandeja3.getNombreProducto() + " tiene codigo: " + bandeja3.getId() + " con un precio de " + bandeja3.getPrecioProducto() / 100 + "\n"
                                            + "-" + bandeja4.getNombreProducto() + " tiene codigo: " + bandeja4.getId() + " con un precio de " + bandeja4.getPrecioProducto() / 100 + "\n"
                                            + "-" + bandeja5.getNombreProducto() + " tiene codigo: " + bandeja5.getId() + " con un precio de " + bandeja5.getPrecioProducto() / 100 + "\n"
                                            + "-" + bandeja6.getNombreProducto() + " tiene codigo: " + bandeja6.getId() + " con un precio de " + bandeja6.getPrecioProducto() / 100);
                                    if (bandeja1.getId().equals(productoAComprar)) {
                                        JOptionPane.showMessageDialog(null, "El producto seleccionado vale " + bandeja1.getPrecioProducto() / 100 + " Euros");
                                        bandejaProductoCompra = bandeja1;
                                    } else if (bandeja2.getId().equals(productoAComprar)) {
                                        JOptionPane.showMessageDialog(null, "El producto seleccionado vale " + bandeja2.getPrecioProducto() / 100 + " Euros");
                                        bandejaProductoCompra = bandeja2;
                                    } else if (bandeja3.getId().equals(productoAComprar)) {
                                        JOptionPane.showMessageDialog(null, "El producto seleccionado vale " + bandeja3.getPrecioProducto() / 100 + " Euros");
                                        bandejaProductoCompra = bandeja3;
                                    } else if (bandeja4.getId().equals(productoAComprar)) {
                                        JOptionPane.showMessageDialog(null, "El producto seleccionado vale " + bandeja4.getPrecioProducto() / 100 + " Euros");
                                        bandejaProductoCompra = bandeja4;
                                    } else if (bandeja5.getId().equals(productoAComprar)) {
                                        JOptionPane.showMessageDialog(null, "El producto seleccionado vale " + bandeja5.getPrecioProducto() / 100 + " Euros");
                                        bandejaProductoCompra = bandeja5;
                                    } else if (bandeja6.getId().equals(productoAComprar)) {
                                        JOptionPane.showMessageDialog(null, "El producto seleccionado vale " + bandeja6.getPrecioProducto() / 100 + " Euros");
                                        bandejaProductoCompra = bandeja6;
                                    }
                                    if (!productoAComprar.equals(bandeja1.getId()) && !productoAComprar.equals(bandeja2.getId()) && !productoAComprar.equals(bandeja3.getId())
                                            && !productoAComprar.equals(bandeja4.getId()) && !productoAComprar.equals(bandeja5.getId()) && !productoAComprar.equals(bandeja6.getId())) {
                                        JOptionPane.showMessageDialog(null, "Introduzca un codigo valido");
                                    } else if (bandejaProductoCompra.getStock() == 0) {
                                        JOptionPane.showMessageDialog(null, "No hay stock del producto seleccionado\nLa compra de este producto ha sido cncelada");
                                    } else {
                                        do {
                                            modoPago = JOptionPane.showInputDialog("Selecciona el metodo de pago: \n1.Efectivo\n2.Tarjeta\n3.Cancelar compra ");
                                            if (!modoPago.equals("1") && !modoPago.equals("2") && !modoPago.equals("3")) {
                                                JOptionPane.showMessageDialog(null, "Introduce una opcion del menu");
                                            } else {
                                                switch (modoPago) {
                                                    case "1"://--------------------------------------Pago con efectivo--------------------------------------------
                                                        double dineroProporcionadoPorClienteTotal = 0;
                                                        double cambioTotal = 0;
                                                        int monedasParaElCliente[] = new int[11];
                                                        do {
                                                            for (int i = 0; i <= 10; i++) {
                                                                dineroProporcionadoPorClienteTotal = cantidadProporcionadaPorCliente(listaMonedas[i], dineroProporcionadoPorClienteTotal);
                                                            }
                                                            JOptionPane.showMessageDialog(null, "Total efectivo proporcionado: " + dineroProporcionadoPorClienteTotal / 100);
                                                            cambioTotal = dineroProporcionadoPorClienteTotal - bandejaProductoCompra.getPrecioProducto();
                                                            if (dineroProporcionadoPorClienteTotal < bandejaProductoCompra.getPrecioProducto()) {
                                                                JOptionPane.showMessageDialog(null, "No has introducido suficiente efectivo para comprar " + bandejaProductoCompra.getNombreProducto()
                                                                        + "\n.Por favor introduzca " + bandejaProductoCompra.getPrecioProducto() / 100.0 + " Euros");
                                                            } else {
                                                                for (int i = 0; i <= 10; i++) {
                                                                    monedasParaElCliente[i] = listaMonedas[i].cambioMonedas(cambioTotal);
                                                                    cambioTotal -= monedasParaElCliente[i] * listaMonedas[i].getValor();
                                                                }
                                                                String devolucionCliente = "";

                                                                for (int i = 0; i <= 10; i++) {
                                                                    if (monedasParaElCliente[i] != 0) {
                                                                        if (listaMonedas[10].haySaldoSuficiente(cambioTotal) && monedasParaElCliente[i] != 0) {
                                                                            devolucionCliente += "De la moneda de valor " + listaMonedas[i].getValor() / 100.0 + " se da como vuelta " + monedasParaElCliente[i] + " unidades\n";
                                                                        }
                                                                    }
                                                                }
                                                                if (!devolucionCliente.equals("")) {
                                                                    JOptionPane.showMessageDialog(null, devolucionCliente + "\nLa compra se realizo correctamente");
                                                                    maquina1.compraEfectivo(bandejaProductoCompra.getPrecioProducto());
                                                                } else if (devolucionCliente.equals("") && dineroProporcionadoPorClienteTotal == bandejaProductoCompra.getPrecioProducto()) {
                                                                    maquina1.compraEfectivo(bandejaProductoCompra.getPrecioProducto());
                                                                    JOptionPane.showMessageDialog(null, devolucionCliente + "\nLa compra se realizo correctamente y no hay vuelta");
                                                                } else if (dineroProporcionadoPorClienteTotal > bandejaProductoCompra.getPrecioProducto() && !listaMonedas[10].haySaldoSuficiente(cambioTotal)) {
                                                                    dineroProporcionadoPorClienteTotal = 0;

                                                                }

                                                            }
                                                        } while (dineroProporcionadoPorClienteTotal < bandejaProductoCompra.getPrecioProducto() || !listaMonedas[10].haySaldoSuficiente(cambioTotal));
                                                        break;
                                                    case "2":  //------------------------------Pago con tarjeta--------------------------------
                                                        TarjetaCredito tarjetaTemporal = new TarjetaCredito("1", LocalDate.now(), "123");
                                                        do {

                                                            String numeroTarjetaCliente = JOptionPane.showInputDialog(null, "Introduce el numero de la tarjeta de credito");
                                                            String numeroCVVCliente = JOptionPane.showInputDialog(null, "Introduce el CVV de la tarjeta de credito");

                                                            tarjetaTemporal.setNumTarjeta(numeroTarjetaCliente);
                                                            tarjetaTemporal.setCvv(numeroCVVCliente);
                                                            if (maquina1.tarjetaEnMiBaseDeDatos(tarjetaTemporal)) {
                                                                maquina1.compraConTarjeta(bandejaProductoCompra.getPrecioProducto());

                                                                JOptionPane.showMessageDialog(null, "La tarjeta introducida ha sido validada correctamente");
                                                            } else {
                                                                JOptionPane.showMessageDialog(null, "La tarjeta introducida no se corresponde con ninguna de las que tenemos guardadas");
                                                            }
                                                        } while (!maquina1.tarjetaEnMiBaseDeDatos(tarjetaTemporal));
                                                        break;
                                                }
                                            }
                                        } while (!modoPago.equals("1") && !modoPago.equals("2") && !modoPago.equals("3"));
                                    }
                                } while (((!productoAComprar.equals(bandeja1.getId()) && !productoAComprar.equals(bandeja2.getId()) && !productoAComprar.equals(bandeja3.getId())
                                        && !productoAComprar.equals(bandeja4.getId()) && !productoAComprar.equals(bandeja5.getId()) && !productoAComprar.equals(bandeja6.getId()))
                                        && !modoPago.equals("1") && !modoPago.equals("2") && !modoPago.equals("3")) || bandejaProductoCompra.getStock() == 0);
                                break;
                        }
                    } while (eleccionUsuario != 3);
                    break;
                case 2://---------------------------------------------MODO ADMINISTRADOR-------------------------------------
                    String codigoAdministrador = "";
                    String eleccionAdministrador = "";
                    do {
                        codigoAdministrador = JOptionPane.showInputDialog(null, "Introduzca el numero secreto de administrador:\nNo es " + maquina1.getContrasenaAdministrador() + " asi que no pruebes esa");
                        if (!codigoAdministrador.equals(maquina1.getContrasenaAdministrador())) {
                            JOptionPane.showMessageDialog(null, "El numero secreto no es correcto, intentelo de nuevo");
                        }
                        if (codigoAdministrador.equals(maquina1.getContrasenaAdministrador())) {
                            do {
                                eleccionAdministrador = JOptionPane.showInputDialog(null, "Teclee la opcion que deseas realizar:\n1.Mostrar estado de la maquina\n"
                                        + "2.Cambiar codigo de una bandeja\n3.Cambiar producto de una bandeja\n4.Apagar maquina"
                                        + "\n5.Cambiar stock de bandejas\n6.Consultar dinero recaudado mediante tarjeta."
                                        + "\n7.Consultar dinero recaudado en total.\n8.Reponer dinero \n9.Salir del modo administrador");

                                if (!eleccionAdministrador.equals("1") && !eleccionAdministrador.equals("2") && !eleccionAdministrador.equals("3")
                                        && !eleccionAdministrador.equals("4") && !eleccionAdministrador.equals("5") && !eleccionAdministrador.equals("6") && !eleccionAdministrador.equals("7") && !eleccionAdministrador.equals("8")
                                        && !eleccionAdministrador.equals("9")) {
                                    JOptionPane.showMessageDialog(null, "Teclee una opcion valida del menu");
                                } else {
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
                                                        + "1.Bandeja que tiene codigo " + bandeja1.getId() + " que contiene " + bandeja1.getNombreProducto() + " a un precio de" + bandeja1.getPrecioProducto() / 100.0 + "$\n"
                                                        + "2.Bandeja que tiene codigo " + bandeja2.getId() + " que contiene " + bandeja2.getNombreProducto() + " a un precio de" + bandeja1.getPrecioProducto() / 100.0 + "$\n"
                                                        + "3.Bandeja que tiene codigo " + bandeja3.getId() + " que contiene " + bandeja3.getNombreProducto() + " a un precio de" + bandeja1.getPrecioProducto() / 100.0 + "$\n"
                                                        + "4.Bandeja que tiene codigo " + bandeja4.getId() + " que contiene " + bandeja4.getNombreProducto() + " a un precio de" + bandeja1.getPrecioProducto() / 100.0 + "$\n"
                                                        + "5.Bandeja que tiene codigo " + bandeja5.getId() + " que contiene " + bandeja5.getNombreProducto() + " a un precio de" + bandeja1.getPrecioProducto() / 100.0 + "$\n"
                                                        + "6.Bandeja que tiene codigo " + bandeja6.getId() + " que contiene " + bandeja6.getNombreProducto() + " a un precio de" + bandeja1.getPrecioProducto() / 100.0 + "$\n"
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
                                                bandejaSaberId = JOptionPane.showInputDialog(null, "Teclee el ID de la bandeja que desees cambiar de stock \n"
                                                        + "Bandeja que contiene " + bandeja1.getNombreProducto() + " con un stock de " + bandeja1.getStock() + " con ID " + bandeja1.getId() + "\n"
                                                        + "Bandeja que contiene " + bandeja2.getNombreProducto() + " con un stock de " + bandeja2.getStock() + " con ID " + bandeja2.getId() + "\n"
                                                        + "Bandeja que contiene " + bandeja3.getNombreProducto() + " con un stock de " + bandeja3.getStock() + " con ID " + bandeja3.getId() + "\n"
                                                        + "Bandeja que contiene " + bandeja4.getNombreProducto() + " con un stock de " + bandeja4.getStock() + " con ID " + bandeja4.getId() + "\n"
                                                        + "Bandeja que contiene " + bandeja5.getNombreProducto() + " con un stock de " + bandeja5.getStock() + " con ID " + bandeja5.getId() + "\n"
                                                        + "Bandeja que contiene " + bandeja6.getNombreProducto() + " con un stock de " + bandeja6.getStock() + " con ID " + bandeja6.getId() + "\n"
                                                        + "Reponer todas las bandejas con la maxima capacidad (si desea esta opcion teclee 1234)" + "\n"
                                                        + "Volver al modo menu del administrador.(si desea esta opcion teclee 4321)");
                                                String nuevoProducto = "";
                                                double nuevoPrecioProducto;
                                                boolean precioCorrecto = false;

                                                if (bandeja1.getId().equals(bandejaSaberId)) {
                                                    cambiarStock(bandeja1);

                                                } else if (bandeja2.getId().equals(bandejaSaberId)) {
                                                    cambiarStock(bandeja2);
                                                } else if (bandeja3.getId().equals(bandejaSaberId)) {
                                                    cambiarStock(bandeja3);
                                                } else if (bandeja4.getId().equals(bandejaSaberId)) {
                                                    cambiarStock(bandeja4);
                                                } else if (bandeja5.getId().equals(bandejaSaberId)) {
                                                    cambiarStock(bandeja5);
                                                } else if (bandeja6.getId().equals(bandejaSaberId)) {
                                                    cambiarStock(bandeja6);
                                                } else if (bandejaSaberId.equals("1234")) {
                                                    bandeja1.rellenarBandeja();
                                                    bandeja2.rellenarBandeja();
                                                    bandeja3.rellenarBandeja();
                                                    bandeja4.rellenarBandeja();
                                                    bandeja5.rellenarBandeja();
                                                    bandeja6.rellenarBandeja();
                                                }

                                                if (!bandejaSaberId.equals(bandeja1.getId()) && !bandejaSaberId.equals(bandeja2.getId()) && !bandejaSaberId.equals(bandeja3.getId())
                                                        && !bandejaSaberId.equals(bandeja4.getId()) && !bandejaSaberId.equals(bandeja5.getId()) && !bandejaSaberId.equals(bandeja6.getId())
                                                        && !bandejaSaberId.equals("1234") && !bandejaSaberId.equals("4321")) {
                                                    JOptionPane.showMessageDialog(null, "Introduce un numero de los que se muestra en el menu");
                                                }
                                            } while (!bandejaSaberId.equals("4321"));
                                            break;
                                        case "6"://----------------------------------Consultar dinero recaudado mediante tarjeta------------------------
                                            JOptionPane.showMessageDialog(null, "Se ha recaudado " + maquina1.getDineroRecaudadoConTarjeta() + " euros mediante tarjeta de credito");
                                            break;
                                        case "7"://----------------------------------recaudar dinero y recarga con un minimo---------------------------------------------------
                                            JOptionPane.showMessageDialog(null, "Dinero recaudado en total " + maquina1.getDineroRecaudadoTotal()+" euros");
                                            int[] monedasParaAdministrador = new int[11];
                                            double dineroRecaudar = maquina1.getDineroRecaudadoTotal() - maquina1.getDineroRecaudadoConTarjeta();
                                            if (dineroRecaudar > 0) {
                                                for (int i = 0; i <= 10; i++) {
                                                    monedasParaAdministrador[i] = listaMonedas[i].cambioMonedas(dineroRecaudar);
                                                    dineroRecaudar -= monedasParaAdministrador[i] * listaMonedas[i].getValor();
                                                }
                                                String monedasParaAdministradorTexto = "";
                                                for (int i = 0; i < monedasParaAdministrador.length; i++) {
                                                    if (monedasParaAdministrador[i] != 0) {
                                                        monedasParaAdministradorTexto += "Tiene que recoger " + monedasParaAdministrador[i] + " monedas de valor " + listaMonedas[i].getValor() / 100.0;
                                                    }
                                                }
                                                JOptionPane.showMessageDialog(null, monedasParaAdministradorTexto);

                                            }
                                            String meterMonedas = "";//variable auxiliar usada para saber si hay que devolver algo
                                            for (int i = 0; i < listaMonedas.length; i++) {
                                                if (listaMonedas[i].getCantidadDeMonedas() < maquina1.MINIMO_MONEDAS_REPOSICION) {
                                                    meterMonedas += "Tiene que meter " + (maquina1.MINIMO_MONEDAS_REPOSICION - listaMonedas[i].getCantidadDeMonedas())
                                                            + " monedas de valor " + listaMonedas[i].getValor() / 100.0 + "\n";
                                                    listaMonedas[i].meterMoneda(maquina1.MINIMO_MONEDAS_REPOSICION - listaMonedas[i].getCantidadDeMonedas());
                                                }
                                            }
                                            if (meterMonedas.equals("")) {
                                                JOptionPane.showMessageDialog(null, "La maquina tiene ,al menos,el minimo de monedas en todas las monedas.");
                                            } else {
                                                JOptionPane.showMessageDialog(null, meterMonedas);
                                            }
                                            maquina1.setFechaRecaudacionTotal();
                                            maquina1.setDineroRecaudadoTotal(0);
                                            maquina1.setDineroRecaudadoConTarjeta(0);

                                            break;
                                        case "8"://--------------------------Recargar un tipo de moneda-------------------------------
                                            String texto = "";
                                            String monedaElegidaReponerTexto = "";
                                            int monedaElegidaReponerNumero = 0;
                                            boolean monedaElegidaCorrecta = false;
                                            boolean cantidadMonedaCorrecta = false;
                                            String cantidadMonedasReponerTexto = "";
                                            int cantidadMonedasReponerNumero = 0;

                                            for (int i = 0; i < listaMonedas.length; i++) {

                                                texto += (i + 1) + "." + listaMonedas[i].informacionMonedas() + "\n";
                                            }

                                            do {
                                                monedaElegidaReponerTexto = JOptionPane.showInputDialog(null, "Seleccione una de las siguientes opciones \n"
                                                        + texto + (listaMonedas.length + 1) + ".Reponer todas la monedas con un minimo de 10 monedas");
                                                try {
                                                    monedaElegidaReponerNumero = Integer.parseInt(monedaElegidaReponerTexto);
                                                    monedaElegidaCorrecta = true;
                                                } catch (NumberFormatException nfe) {
                                                    JOptionPane.showMessageDialog(null, "Debe de introduccir un caracter numerico");
                                                }

                                            } while (!monedaElegidaCorrecta);
                                            if (monedaElegidaReponerNumero < listaMonedas.length + 1) {

                                                do {
                                                    cantidadMonedasReponerTexto = JOptionPane.showInputDialog("�Cuanto quieres reponer");
                                                    try {
                                                        cantidadMonedasReponerNumero = Integer.parseInt(cantidadMonedasReponerTexto);
                                                        cantidadMonedaCorrecta = true;
                                                    } catch (NumberFormatException nfe) {
                                                        JOptionPane.showMessageDialog(null, "Debe de introduccir un caracter numerico");
                                                    }

                                                } while (!cantidadMonedaCorrecta);
                                                listaMonedas[monedaElegidaReponerNumero - 1].meterMoneda(cantidadMonedasReponerNumero);

                                            } else {
                                                for (int i = 0; i < listaMonedas.length; i++) {
                                                    if (listaMonedas[i].getCantidadDeMonedas() < maquina1.MINIMO_MONEDAS_REPOSICION) {
                                                        listaMonedas[i].meterMoneda(maquina1.MINIMO_MONEDAS_REPOSICION - listaMonedas[i].getCantidadDeMonedas());
                                                    }
                                                }
                                            }
                                            maquina1.setFechaUltimaRecarga(LocalDate.now());
                                            break;
                                    }
                                }
                            } while (!eleccionAdministrador.equals("9") && !eleccionAdministrador.equals("4"));
                        }
                    } while (!codigoAdministrador.equals(maquina1.getContrasenaAdministrador()));
            }
        } while (!apagarMaquina);
    }
//----------------------------------------------METODOS ESTATICOS-----------------------------------------------

    public static void cambiarProducto(Bandeja bandeja) {
        String nuevoProducto = "";
        double nuevoPrecioProducto = 0;
        int nuevoStockProducto = 0;
        boolean precioCorrecto = false;
        boolean stockCorrecto = false;
        nuevoProducto = JOptionPane.showInputDialog(null, "Introduce el nombre que va a tener el producto con codigo " + bandeja.getId());
        bandeja.setNombreProducto(nuevoProducto);
        do {
            try {
                String texto = JOptionPane.showInputDialog(null, "Introduce el precio en euros que va a tener el producto llamado " + bandeja.getNombreProducto());
                nuevoPrecioProducto = Double.parseDouble(texto);
                precioCorrecto = true;

            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Introduce un valor numerico");
            }
        } while (!precioCorrecto);
        bandeja.setPrecioProducto(nuevoPrecioProducto * 100);
        do {
            try {
                String texto = JOptionPane.showInputDialog(null, "Introduce el stock que va a tener el producto llamado " + bandeja.getNombreProducto());
                nuevoStockProducto = Integer.parseInt(texto);
                stockCorrecto = true;

            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Introduce un valor numerico");
            }
        } while (!stockCorrecto);
        bandeja.setStock(nuevoStockProducto);
    }

    public static void cambiarId(Bandeja bandeja) {

        String id=JOptionPane.showInputDialog("Introduce el id que quieres poner a la bandeja que contiene "+bandeja.getNombreProducto());
        bandeja.setId(id);
        if(!bandeja.comprobarId(id)){
            JOptionPane.showMessageDialog(null,"Has introducido un id que no cumple las caracteristicas correctas y por tanto se te ha puesto un id aleatorioa que es "+bandeja.getId());
        }else {
            JOptionPane.showMessageDialog(null,"Se ha actualizado el id del producto "+bandeja.getNombreProducto()+" con el id "+bandeja.getId());

        }
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

    public static int pedirMonedaCliente(Moneda moneda) {
        boolean monedaCorrecta = false;
        int numeroDeMonedadPedidas = 0;
        do {
            try {
                String texto = JOptionPane.showInputDialog("Introduzca la cantidad de dinero que introduces con valor " + moneda.getValor() / 100.0);
                numeroDeMonedadPedidas = Integer.parseInt(texto);
                monedaCorrecta = true;
                moneda.meterMoneda(numeroDeMonedadPedidas);
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Introduzca un valor numerico");
            }
        } while (!monedaCorrecta);
        return numeroDeMonedadPedidas;
    }

    public static double cantidadProporcionadaPorCliente(Moneda moneda, double valorAcumulado) {
        int numeroMonedas = pedirMonedaCliente(moneda);
        valorAcumulado += numeroMonedas * moneda.getValor();
        return valorAcumulado;
    }
}
