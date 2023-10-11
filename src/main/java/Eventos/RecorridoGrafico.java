/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Eventos;

import Logica.DatosGlobales;
import Logica.Motocicleta;
import Logica.Pedido;
import TableModels.RegistrosTableModel;
import Windows.VtnEstadoEntregas;
import Windows.VtnRealizarPedidos;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author cesar
 */
public class RecorridoGrafico extends Thread {
    
    Pedido pedido;
    JLabel labelMoto;
    VtnEstadoEntregas escenario;
    VtnRealizarPedidos vtnRealizarPedidos = new VtnRealizarPedidos();
    RegistrosTableModel registrosTableModel = new RegistrosTableModel();
    public RecorridoGrafico (JLabel moto, VtnEstadoEntregas escenario, Pedido pedido){
        this.labelMoto = moto;
        this.pedido = pedido;
        this.escenario = escenario;
    }
    private Motocicleta obtenerMoto(){
        
        for(Motocicleta motocicleta : DatosGlobales.getInstance().getMOTOCICLETAS()){
            if(motocicleta.getNombre().equals(pedido.getVehiculoName())){
                
                return motocicleta;
                
            }
        }
        return null;
        
    }
        
    public void run() {
        if (!pedido.isPedidoFinalizado()) {
            int posMoto = 0;
            double distancia = Double.parseDouble(pedido.getDistancia());
            boolean viajeRegreso = false;
            int posInicial = labelMoto.getLocation().x;
            while (true) {
                try {
                    sleep((int) (distancia * 100));

                    posMoto = labelMoto.getLocation().x;
                    if (!viajeRegreso) {
                        if (posMoto < escenario.getMeta().getLocation().x - 20) {
                            labelMoto.setLocation(labelMoto.getLocation().x + 10, labelMoto.getLocation().y);
                            escenario.repaint();
                        } else {
                            pedido.FinalizarPedido();
                            viajeRegreso = true;
                        }
                    } else {
                        if(posMoto > posInicial){
                            labelMoto.setLocation(labelMoto.getLocation().x-10, labelMoto.getLocation().y);
                            escenario.repaint();
                        }
                        else{
                            Motocicleta motocicleta = this.obtenerMoto();
                            motocicleta.desocuparMoto();
                            vtnRealizarPedidos.actualizarCbb();
                            Date horaLlegada = new Date();
                            pedido.setHoraLlegada(horaLlegada);
                            registrosTableModel.fireTableDataChanged();
                            break;
                            
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Pedido finalizado");
        }

    }
    
    
    
}
