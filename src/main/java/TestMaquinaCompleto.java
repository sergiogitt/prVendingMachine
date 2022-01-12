
import java.time.LocalDate;
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

        Bandeja bandeja1 = new Bandeja(15, "cocacola", 2);
        Bandeja bandeja2 = new Bandeja(15, "Agua1Litro", 1.5);
        Bandeja bandeja3 = new Bandeja(15, "Biofrutas", 3);
        Bandeja bandeja4 = new Bandeja(15, "PatatasJamon", 1);
        Bandeja bandeja5 = new Bandeja(15, "Palomitas", 0.9);
        Bandeja bandeja6 = new Bandeja(15, "Almendras", 2.5);

        Moneda monedas20 = new Moneda(20, 30);
        Moneda monedas10 = new Moneda(10, 30);
        Moneda monedas5 = new Moneda(5, 30);
        Moneda monedas2 = new Moneda(2, 30);
        Moneda monedas1 = new Moneda(1, 30);
        Moneda monedas0coma50 = new Moneda(0.50, 30);
        Moneda monedas0coma20 = new Moneda(0.20, 30);
        Moneda monedas0coma10 = new Moneda(0.10, 30);

        TarjetaCredito tarjeta1 = new TarjetaCredito(1234456884569563.0, LocalDate.now(), 569);
        TarjetaCredito tarjeta2 = new TarjetaCredito(1234456884879563.0, LocalDate.now(), 454);
        TarjetaCredito tarjeta3 = new TarjetaCredito(1234456886369563.0, LocalDate.now(), 586);

        Maquina maquina1 = new Maquina(id, direccion, bandeja1, bandeja2, bandeja3, bandeja4, bandeja5, bandeja6,
                monedas20, monedas10, monedas5, monedas2, monedas1, monedas0coma50, monedas0coma20, monedas0coma10,
                tarjeta1, tarjeta2, tarjeta3);

        System.out.println(maquina1.informacionCompletaMaquina());
        boolean eleccionModoValida = false;
        int eleccionModo = 0;
        do {
            do {
                String texto = JOptionPane.showInputDialog("Elige el modo de uso: \n 1.Modo venta \n 2.Modo Administardor");
                try {
                    eleccionModo = Integer.parseInt(texto);
                    eleccionModoValida = true;
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null,"Has introducido un caracter erroneo, introduce un caracter numerico ");
                }
            } while (!eleccionModoValida);
            if (eleccionModo != 1 && eleccionModo != 2) {
                JOptionPane.showInputDialog("Introduce un numero que este en el menu por favor");
            }
        } while (eleccionModo != 1 && eleccionModo != 2);

        switch (eleccionModo) {
            case 1:

                int eleccionUsuario = 0;
                boolean eleccionModoUsuarioValida = false;
                do {
                    do {
                        String text = JOptionPane.showInputDialog("Elige que opcion deseas realizar\n" +
                                "1.Consultar precio\n2.Comprar producto");
                        try {
                            eleccionUsuario = Integer.parseInt(text);
                            eleccionModoUsuarioValida = true;
                        } catch (NumberFormatException nfe) {
                            JOptionPane.showMessageDialog(null,"Has introducido un caracter erroneo, introduce un caracter numerico ");

                        }
                    } while (!eleccionModoUsuarioValida);
                }while(eleccionUsuario!=1&&eleccionUsuario!=2);

                if (eleccionModo != 1 && eleccionModo != 2) {
                    JOptionPane.showInputDialog("Introduce un numero que este en el menu por favor");
                }

                switch (eleccionUsuario) {
                    case 1:
                        String saberPrecioProducto = "";
                        do {
                            saberPrecioProducto = JOptionPane.showInputDialog("Tecle el identificador del producto que " +
                                    " desee saber el precio\n-"+bandeja1.getNombreProducto()+"tiene codigo: "+bandeja1.getId()+"\n"+
                                    "-"+bandeja2.getNombreProducto()+" tiene codigo: "+bandeja2.getId()+"\n"
                                    +"-"+bandeja3.getNombreProducto()+" tiene codigo: "+bandeja3.getId()+"\n"
                                    +"-"+bandeja4.getNombreProducto()+" tiene codigo: "+bandeja4.getId()+"\n"
                                    +"-"+bandeja5.getNombreProducto()+" tiene codigo: "+bandeja5.getId()+"\n"
                                    +"-"+bandeja6.getNombreProducto()+" tiene codigo: "+bandeja6.getId());
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
                            if (!saberPrecioProducto.equals(bandeja1.getId()) && !saberPrecioProducto.equals(bandeja2.getId()) && !saberPrecioProducto.equals(bandeja3.getId()) &&
                                    !saberPrecioProducto.equals(bandeja4.getId()) && !saberPrecioProducto.equals(bandeja5.getId()) && !saberPrecioProducto.equals(bandeja6.getId())){
                                JOptionPane.showMessageDialog(null,"Introduzca un codigo valido");
                            }
                        } while (!saberPrecioProducto.equals(bandeja1.getId()) && !saberPrecioProducto.equals(bandeja2.getId()) && !saberPrecioProducto.equals(bandeja3.getId()) &&
                               !saberPrecioProducto.equals(bandeja4.getId()) && !saberPrecioProducto.equals(bandeja5.getId()) && !saberPrecioProducto.equals(bandeja6.getId()));


                        break;
                    case 2:


                        break;

                }

        }
        while (eleccionModo != 1 && eleccionModo != 2) ;



        }
    }

