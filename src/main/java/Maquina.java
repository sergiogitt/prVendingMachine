
import java.util.UUID;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Windows10
 */
public class Maquina {

    private UUID id;
    private String direccion;
    private Bandeja bandeja1;
    private Bandeja bandeja2;
    private Bandeja bandeja3;
    private Bandeja bandeja4;
    private Bandeja bandeja5;
    private Bandeja bandeja6;

    private Monedas monedas20;
    private Monedas monedas10;
    private Monedas monedas5;
    private Monedas monedas2;
    private Monedas monedas1;
    private Monedas monedas0coma50;
    private Monedas monedas0coma20;
    private Monedas monedas0coma10;

    public Maquina(UUID id, String direccion, Bandeja bandeja1, Bandeja bandeja2, Bandeja bandeja3, Bandeja bandeja4, Bandeja bandeja5, Bandeja bandeja6, Monedas monedas20, Monedas monedas10, Monedas monedas5, Monedas monedas2, Monedas monedas1, Monedas monedas0coma50, Monedas monedas0coma20, Monedas monedas0coma10) {
        this.id = id;
        this.direccion = direccion;
        this.bandeja1 = bandeja1;
        this.bandeja2 = bandeja2;
        this.bandeja3 = bandeja3;
        this.bandeja4 = bandeja4;
        this.bandeja5 = bandeja5;
        this.bandeja6 = bandeja6;

        if (monedas20.getValor() != 20.0) {   //consideramos que las monedas ser�n introducidas en orden descendente y  por tanto en caso que
            //su valor no sea el que le corresponde se le asigna automaticamente

            this.monedas20.setValor(20.0);
        } else {
            this.monedas20 = monedas20;
        }
        if (monedas10.getValor() != 10.0) {
            this.monedas10.setValor(10.0);
        } else {
            this.monedas10 = monedas10;
        }
        if (monedas5.getValor() != 5.0) {
            this.monedas20.setValor(5.0);
        } else {
            this.monedas5 = monedas5;
        }
        if (monedas2.getValor() != 2.0) {
            this.monedas2.setValor(2.0);
        } else {
            this.monedas2 = monedas2;
        }
        if (monedas1.getValor() != 1.0) {
            this.monedas1.setValor(1.0);
        } else {
            this.monedas1 = monedas1;
        }

        if (monedas0coma50.getValor() != 0.5) {
            this.monedas0coma50.setValor(0.5);

        } else {
            this.monedas0coma50 = monedas0coma50;
        }

        if (monedas0coma20.getValor() != 0.2) {
            this.monedas0coma20.setValor(0.2);

        } else {
            this.monedas0coma20 = monedas0coma20;
        }
        if (monedas0coma10.getValor() != 0.1) {
            this.monedas0coma10.setValor(0.1);

        } else {
            this.monedas0coma10 = monedas0coma10;
        }
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String informacionCompletaMaquina() {
        String texto = "La maquina con id " + id + " que esta ubicada en la direccion " + direccion + "tiene: \n"
                + bandeja1.informacionBandeja() + "\n"
                + bandeja2.informacionBandeja() + "\n"
                + bandeja3.informacionBandeja() + "\n"
                + bandeja4.informacionBandeja() + "\n"
                + bandeja5.informacionBandeja() + "\n"
                + bandeja6.informacionBandeja() + "\n"
                + monedas20.informacionMonedas() + "\n"
                + monedas10.informacionMonedas() + "\n"
                + monedas5.informacionMonedas() + "\n"
                + monedas2.informacionMonedas() + "\n"
                + monedas1.informacionMonedas() + "\n"
                + monedas0coma50.informacionMonedas() + "\n"
                + monedas0coma20.informacionMonedas() + "\n"
                + monedas0coma10.informacionMonedas() + "\n";
        return texto;
    }
}