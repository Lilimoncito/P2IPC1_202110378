/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Windows.VtnIngreso;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author cesar
 */
public class Main {
     public static void main(String[] args) {
          for(LookAndFeelInfo lafinfo : UIManager.getInstalledLookAndFeels()){
            System.out.println(lafinfo.getClassName());
        }
        
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        DatosGlobales datosGlobales = DatosGlobales.getInstance();
        DatosGlobales datosDeserializados = DatosGlobales.deserializarDatos("datos.dat");
        
        if(datosDeserializados != null){
            datosGlobales.actualizarConDatos(datosDeserializados);
        }
        else{
            Administrador administrador = new Administrador("admin", "admin");
            ArrayList<Motocicleta> motocicletas = new ArrayList<>();
            ArrayList<Pedido> pedidos = new ArrayList<>();
            ArrayList<Producto> productos = new ArrayList<>();
            datosGlobales.setAdministrador(administrador);
            datosGlobales.setMOTOCICLETAS(motocicletas);
            datosGlobales.setPEDIDOS(pedidos);
            datosGlobales.setPRODUCTOS(productos);
            Producto producto1 = new Producto("cafe la jarrilla", "40");
            producto1.setCantidad("100");
            Producto producto2 = new Producto("arroz", "5");
            producto2.setCantidad("20");
            Producto producto3 = new Producto("coca", "4");
            producto1.setCantidad("100");
            Producto producto4 = new Producto("papas", "10");
            producto2.setCantidad("20");
            Motocicleta moto1 = new Motocicleta("motocicleta1","mazda", "30 km/s");
            Motocicleta moto2 = new Motocicleta("motocicleta2","toyota", "30 km/s");
            Motocicleta moto3 = new Motocicleta("motocicleta3","toyota", "30 km/s");
            datosGlobales.agregarMotocicletas(moto1);
            datosGlobales.agregarMotocicletas(moto2);
            datosGlobales.agregarMotocicletas(moto3);
            datosGlobales.agregarProducto(producto1);
            datosGlobales.agregarProducto(producto2);
            datosGlobales.agregarProducto(producto3);
            datosGlobales.agregarProducto(producto4);
        }
        
        
        VtnIngreso vtnIngreso = new VtnIngreso();
        vtnIngreso.setVisible(true);
        vtnIngreso.setLocationRelativeTo(null);
        
        
        
        
        
        
        final DatosGlobales datosPaGuardar = datosGlobales;
        Runtime.getRuntime().addShutdownHook(new Thread (() -> {
            datosPaGuardar.guardarDatos();
        
        }));
    }
}
