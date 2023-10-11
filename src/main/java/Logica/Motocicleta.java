/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.io.Serializable;

/**
 *
 * @author cesar
 */
public class Motocicleta extends Vehiculo implements Serializable{
    
    private Pedido pedido;
    private boolean motoOcupada  = false;
    public Motocicleta(String nombre, String marca, String velocidad) {
        super(nombre, marca, velocidad);
        this.pedido = new Pedido();
    }
    public void desocuparMoto(){
        motoOcupada = false;
    }
    public void ocuparMoto(){
        motoOcupada = true;
    }
    public boolean isMotoOcupada(){
        return motoOcupada;
    }
    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(String velocidad) {
        this.velocidad = velocidad;
    }
    
    
    
}
