/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableModels;

import Logica.DatosGlobales;
import Logica.Pedido;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cesar
 */
public class RegistrosTableModel extends AbstractTableModel {
    DatosGlobales datosGlobales = DatosGlobales.getInstance();
    ArrayList<Pedido> pedidosVerificados = new ArrayList<>();
    String[] columnNames = {"Vehiculo","Distancia (km)","Monto","Fecha y hora de creacion","Fecha y hora de entrega"};
    public RegistrosTableModel (){
        for(Pedido pedido: datosGlobales.getPEDIDOS()){
            if(pedido.isPedidoFinalizado()){
                pedidosVerificados.add(pedido);
            }
        }
    }
    @Override
    public int getRowCount() {
        return pedidosVerificados.size();
               
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pedido pedido = pedidosVerificados.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return pedido.getVehiculoName();
            case 1:
                return pedido.getDistancia();
            case 2:
                return pedido.getTotal();
            case 3:
                return pedido.getHoraPartida();
            case 4:
                return pedido.getHoraLlegada();
            default:
                return null;
        }
    }
    @Override
    public String getColumnName (int column){
        return columnNames[column];
    }
    
}
