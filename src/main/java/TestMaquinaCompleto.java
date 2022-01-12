
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
            if (eleccionModo != 1 && eleccionModo != 2){
                JOptionPane.showMessageDialog(null,"Introduce un numero que se muestre en el menu,por favor.");
            }
        } while (eleccionModo != 1 && eleccionModo != 2);

        switch (eleccionModo) {


        }
    }
}
