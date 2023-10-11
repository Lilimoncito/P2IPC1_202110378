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
public class Administrador extends Usuario implements Serializable {
    
    public Administrador(String nombre, String contrasena) {
        super(nombre, contrasena);
    }
    
    public Administrador (){
    
        super("","");
    }
    
    
    public void agregarProductos(String nombre, String precio, String cantidad){
        Producto producto = new Producto(nombre, precio);
        producto.setCantidad(cantidad);
        DatosGlobales datosGlobales = DatosGlobales.getInstance();
        datosGlobales.agregarProducto(producto);
        
    }
    
    public void agregarProductoAlPedido (String id, Producto productoEnv){
        
    Producto productoRec = productoEnv;
    for(Pedido pedido : DatosGlobales.getInstance().getPEDIDOS()){
        if(pedido.getId().equals(id)){
            pedido.agregarProducto(productoRec);
        
        }
    }
    
    }
    
}
