
import java.time.LocalDate;
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
    
    public final int MINIMO_MONEDAS_REPOSICION= 10;
    private UUID id;
    private String contrasenaAdministrador;
    private String direccion;
    private Bandeja bandeja1;
    private Bandeja bandeja2;
    private Bandeja bandeja3;
    private Bandeja bandeja4;
    private Bandeja bandeja5;
    private Bandeja bandeja6;

    private Moneda listaMonedas[];
    

    private TarjetaCredito tarjeta1;
    private TarjetaCredito tarjeta2;
    private TarjetaCredito tarjeta3;

    private double dineroRecaudadoConTarjeta=0;
    private LocalDate fechaRecaudacionTotal;
    private double dineroRecaudadoTotal=0;

    public Maquina(UUID id, String direccion, Bandeja bandeja1, Bandeja bandeja2, Bandeja bandeja3, Bandeja bandeja4,
            Bandeja bandeja5, Bandeja bandeja6,
            Moneda listaMonedas[],
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
        this.dineroRecaudadoConTarjeta=0;
        this.listaMonedas=listaMonedas;
        this.tarjeta1=tarjeta1;
        this.tarjeta2=tarjeta2;
        this.tarjeta3=tarjeta3;
        
    }
    public void compraConTarjeta(double valorAumentado){
        this.dineroRecaudadoConTarjeta+=valorAumentado;
    }
    public void compraTotal(double valorAumentado){
        this.dineroRecaudadoTotal+=dineroRecaudadoConTarjeta+valorAumentado;
    }
    public void recaudarDinero(){
        fechaRecaudacionTotal=LocalDate.now();
        dineroRecaudadoConTarjeta=0;
        dineroRecaudadoTotal=0;
    }
    public boolean tarjetaEnMiBaseDeDatos(TarjetaCredito tarjeta){
        return tarjeta1.tarjetaValida(tarjeta)||tarjeta2.tarjetaValida(tarjeta)||tarjeta3.tarjetaValida(tarjeta);
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

   
    
    
    public double getDineroRecaudadoConTarjeta() {
        return dineroRecaudadoConTarjeta;
    }

    public UUID getId() {
        return id;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getContrasenaAdministrador() {
        return contrasenaAdministrador;
    }

    public double getDineroRecaudadoTotal() {
        return dineroRecaudadoTotal;
    }


    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public boolean liquidoSuficienteParaVenta(double cambioTotal){
        return listaMonedas[10].haySaldoSuficiente(cambioTotal);
    }
    public String informacionCompletaMaquina() {
        String texto = "La maquina con id " + id + " que esta ubicada en la direccion " + direccion + " tiene: \n"
                + "La palabra secreta del administrador es:" +contrasenaAdministrador+ "\n"
                + bandeja1.informacionBandeja() + "\n"
                + bandeja2.informacionBandeja() + "\n"
                + bandeja3.informacionBandeja() + "\n"
                + bandeja4.informacionBandeja() + "\n"
                + bandeja5.informacionBandeja() + "\n"
                + bandeja6.informacionBandeja();
        for(int i=0;i<listaMonedas.length;i++){
            texto+="\n"+listaMonedas[i].informacionMonedas();
        }
        return texto;
    }
}
