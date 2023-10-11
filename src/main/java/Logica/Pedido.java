/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
/**
 *
 * @author cesar
 */
public class Pedido implements Serializable {
    
    private String id;
    private ArrayList<Producto> productos;
    private String vehiculoName;
    private Date horaPartida;
    private Date horaLlegada;
    private String distancia;
    private double total;
    private boolean motoAsignada;
    private boolean pedidoFinalizado;
    
    public Pedido() {
        this.productos = new ArrayList<>();
        this.vehiculoName ="";
        this.distancia ="";
        this.id = UUID.randomUUID().toString();
        this.motoAsignada = false;
        this.pedidoFinalizado = false;
        this.total = 0;
    }
    //metodos 
    public double actualizarTotal (double monto){
        total = total + monto;
        return total;
    }
    public void agregarProducto(Producto producto){
        this.productos.add(producto);
    }
    
    public void configurarHoraSalida(Date horaSalida){
        this.horaPartida = horaSalida;
    }
    public void configurarHoraLlegada (Date horaLlegada){
        this.horaLlegada = horaLlegada;
    }
    public void FinalizarPedido (){
        pedidoFinalizado = true;
    }
    public boolean isPedidoFinalizado(){
        return pedidoFinalizado;
    }
    public void asignarMoto(){
        motoAsignada = true;
    }
    public boolean isMotoAsignada(){
        return motoAsignada;
    }
    
    public Double obtenerVelocidad (){
       String motoVelo =  "";
       double motoVeloClean = 0;
        for(Motocicleta motocicleta : DatosGlobales.getInstance().getMOTOCICLETAS()){
            if(motocicleta.getNombre().equals(this.vehiculoName)){
                motoVelo = motocicleta.getVelocidad();
                break;
            
            }
        }
        String [] velocidadPartes = motoVelo.split(" ");
        if(velocidadPartes.length >= 2){
            try{
                motoVeloClean = Double.parseDouble(velocidadPartes[0]);
            }catch(NumberFormatException e){
                e.printStackTrace();
                motoVeloClean = 0;
            }
        
        }
        
        return motoVeloClean;
    }
    
   

    //getters y setters
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {    
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public String getVehiculoName() {
        return vehiculoName;
    }

    public void setVehiculoName(String vehiculoName) {
        this.vehiculoName = vehiculoName;
    }

    public Date getHoraPartida() {
        return horaPartida;
    }

    public void setHoraPartida(Date horaPartida) {
        this.horaPartida = horaPartida;
    }

    public Date getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(Date horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }
    
}
