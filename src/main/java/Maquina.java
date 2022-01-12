
import java.util.Random;
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
    private String contrasenaAdministrador;
    private String direccion;
    private Bandeja bandeja1;
    private Bandeja bandeja2;
    private Bandeja bandeja3;
    private Bandeja bandeja4;
    private Bandeja bandeja5;
    private Bandeja bandeja6;

    private Moneda monedas20;
    private Moneda monedas10;
    private Moneda monedas5;
    private Moneda monedas2;
    private Moneda monedas1;
    private Moneda monedas0coma50;
    private Moneda monedas0coma20;
    private Moneda monedas0coma10;

    private TarjetaCredito tarjeta1;
    private TarjetaCredito tarjeta2;
    private TarjetaCredito tarjeta3;

    public Maquina(UUID id, String direccion, Bandeja bandeja1, Bandeja bandeja2, Bandeja bandeja3, Bandeja bandeja4,
            Bandeja bandeja5, Bandeja bandeja6, Moneda monedas20,
            Moneda monedas10, Moneda monedas5, Moneda monedas2, Moneda monedas1, Moneda monedas0coma50, Moneda monedas0coma20, Moneda monedas0coma10,
            TarjetaCredito tarjeta1, TarjetaCredito tarjeta2, TarjetaCredito tarjeta3) {
        this.id = id;
        this.direccion = direccion;
        this.contrasenaAdministrador= generarContrasenia();
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
        this.tarjeta1=tarjeta1;
        this.tarjeta2=tarjeta2;
        this.tarjeta3=tarjeta3;
        
    }
    private String generarContrasenia() {
        String simbolo="";
        if (generarCaracterAleatorio(48,49)==0){
            simbolo=String.valueOf(generarCaracterAleatorio(33,46));
        }else{
            simbolo=String.valueOf(generarCaracterAleatorio(58,64));
        }

        String contrasena=String.valueOf(generarCaracterAleatorio(97,122))+
                String.valueOf(generarCaracterAleatorio(65,90))+
                String.valueOf(generarCaracterAleatorio(48,57)+
                        simbolo+
                        String.valueOf(generarCaracterAleatorio(33,122))+
                        String.valueOf(generarCaracterAleatorio(33,122))+
                        String.valueOf(generarCaracterAleatorio(33,122))+
                        String.valueOf(generarCaracterAleatorio(33,122)));
        return contrasena;

    }
    private char generarCaracterAleatorio(int rangoMinimo,int rangoMaximo){
        char caracterDevuelto;
        Random aleatorio=new Random();
        caracterDevuelto=(char)(aleatorio.nextInt(rangoMaximo-rangoMinimo+1)+rangoMinimo);
        return caracterDevuelto;
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
        String texto = "La maquina con id " + id + " que esta ubicada en la direccion " + direccion + " tiene: \n"
                + "La palabra secreta del administrador es:" +contrasenaAdministrador+ "\n"
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
