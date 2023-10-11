/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author cesar
 */
public class DatosGlobales implements Serializable {
    private static DatosGlobales instance;
    
    private ArrayList<Motocicleta> MOTOCICLETAS;
    private ArrayList<Producto> PRODUCTOS;
    private ArrayList<Pedido> PEDIDOS;
    private Administrador administrador;
    
    String h;
    private DatosGlobales() {
        administrador = null;
        MOTOCICLETAS = new ArrayList<>();
        PRODUCTOS = new ArrayList<>();
        PEDIDOS = new ArrayList<>();
    }
    
    public static synchronized DatosGlobales getInstance(){
        if(instance == null){
            instance = new DatosGlobales();
        }
        return instance;
    }
    
    public void setInstance (DatosGlobales newInstance){
        
        instance = newInstance;
    }
    
    //Administrador
    
    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    
    
    
    
    //Motocicletas
    
    public ArrayList<Motocicleta> getMOTOCICLETAS() {
        return MOTOCICLETAS;
    }

    public void setMOTOCICLETAS(ArrayList<Motocicleta> MOTOCICLETA) {
        this.MOTOCICLETAS = MOTOCICLETA;
    }
    
    public void agregarMotocicletas (Motocicleta motocicleta){
        this.MOTOCICLETAS.add(motocicleta);
    
    }
    
    
    //Productos

    public ArrayList<Producto> getPRODUCTOS() {
        return PRODUCTOS;
    }

    public void setPRODUCTOS(ArrayList<Producto> PRODUCTOS) {
        this.PRODUCTOS = PRODUCTOS;
    }
    
    public void agregarProducto(Producto producto){
        PRODUCTOS.add(producto);
        
    }
    
    //Pedidos
    
    
    public ArrayList<Pedido> getPEDIDOS() {
        return PEDIDOS;
    }

    public void setPEDIDOS(ArrayList<Pedido> PEDIDOS) {
        this.PEDIDOS = PEDIDOS;
    }
    
    public void agregarPedido (Pedido pedido){
        this.PEDIDOS.add(pedido);
    }
    //Metodos Serializacion
    public void actualizarConDatos(DatosGlobales datos){
        this.administrador = datos.getAdministrador();
        this.MOTOCICLETAS = datos.getMOTOCICLETAS();
        this.PEDIDOS = datos.getPEDIDOS();
        this.PRODUCTOS = datos.getPRODUCTOS();
    }
    public void guardarDatos (){
        serializarDatos(this, "datos.dat");
    }
    public void serializarDatos(DatosGlobales datos, String rutaArchivo){
        try(ObjectOutputStream Salida = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            Salida.writeObject(datos);
            System.out.println("datos serializados correctamente");
            
        } catch(IOException e){
            e.printStackTrace();
        
        }
    }
    
     public static DatosGlobales deserializarDatos(String rutaArchivo){
        
        try(ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            
            DatosGlobales datos = (DatosGlobales) entrada.readObject();
            System.out.println("datos desSerializados correctamente");
            return datos;
            
                    
            
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
            return null;
        
        }
     }
}
