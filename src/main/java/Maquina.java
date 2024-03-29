
import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;


public class Maquina {
  //------------------------------------ATRIBUTOS--------------------------------------------------------
    
    public final int MINIMO_MONEDAS_REPOSICION= 10; //Stock minimo para avisar al administrador que reponga
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
    private double dineroRecaudadoTotal=0;
     
    private LocalDate fechaRecaudacionTotal;
    private LocalDate fechaUltimaRecarga;
    
   
//-------------------------------------CONSTRUCTOR---------------------------------------------
    
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
    //----------------------------------------------------METODOS--------------------------------------------
    
    public void compraConTarjeta(double valorAumentado){
        this.dineroRecaudadoConTarjeta+=valorAumentado;
        this.dineroRecaudadoTotal+=valorAumentado;
    }

    public void compraEfectivo(double valorAumentado){
        this.dineroRecaudadoTotal+=dineroRecaudadoConTarjeta+valorAumentado;
    }

    public void recaudarDinero(){
        fechaRecaudacionTotal=LocalDate.now();
        dineroRecaudadoConTarjeta=0;
        dineroRecaudadoTotal=0;
    }

    public boolean tarjetaEnMiBaseDeDatos(TarjetaCredito tarjeta){ //metodo que comprueba si la tarjeta del cliente esta almacenada en la maquina
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

    public boolean liquidoSuficienteParaVenta(double cambioTotal){ //metodo para comprobar la posibilidad de hacer cambio
        return listaMonedas[10].haySaldoSuficiente(cambioTotal);
    }
//----------------------------------------------------SETTERS-----------------------------------------
    public void setId(UUID id) {
        this.id = id;
    }

    public void setDineroRecaudadoConTarjeta(double dineroRecaudadoConTarjeta) {
        this.dineroRecaudadoConTarjeta = dineroRecaudadoConTarjeta;
    }

    public void setDineroRecaudadoTotal(double dineroRecaudadoTotal) {
        this.dineroRecaudadoTotal = dineroRecaudadoTotal;
    }

    public void setFechaRecaudacionTotal(LocalDate fechaRecaudacionTotal) {
        this.fechaRecaudacionTotal = fechaRecaudacionTotal;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setFechaUltimaRecarga(LocalDate fechaUltimaRecarga) {
        this.fechaUltimaRecarga = fechaUltimaRecarga;
    }

    public void setFechaRecaudacionTotal() {
        if(dineroRecaudadoTotal!=0){
            this.fechaRecaudacionTotal = LocalDate.now();
        }
    }
 //--------------------------------------------------GETTERS---------------------------------------
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
//----------------------------METODO TOSTRING MEJORADO-----------------------------------------------
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
        String informacionFech="";
        String informacionRecaudacion="";
       
        informacionFech=(fechaRecaudacionTotal==null)?"Nunca se ha recaudado":("La ultima recaudacion se realizo "+fechaRecaudacionTotal);
        informacionRecaudacion=(fechaUltimaRecarga==null)?"Nunca se ha recargado":("La ultima recarga se realizo "+fechaUltimaRecarga);
        texto+="\n"+informacionFech+"\n"+informacionRecaudacion;
        return texto;
    }
}
