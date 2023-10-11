/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableModels;

import Logica.DatosGlobales;
import Logica.Pedido;
import Logica.Producto;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cesar
 */
public class PedidoTableModel extends AbstractTableModel {
    DatosGlobales datosGlobales = DatosGlobales.getInstance();
    private String[] columnNames = {"Nombre","Precio"};
    Pedido pedidoRec;
    ArrayList<Producto> productosPedido;
    
    public PedidoTableModel(Pedido pedido){
        this.pedidoRec = pedido;
        productosPedido = pedido.getProductos();
    }
    
    public void agregarProductoAlPedido(Producto producto){
        pedidoRec.agregarProducto(producto);
        fireTableDataChanged();
    }
    @Override
    public int getRowCount() {
        return productosPedido.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Producto producto = productosPedido.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return producto.getNombre();
            case 1:
                return producto.getPrecio();
            default:
                return null;
        }
    }
    @Override
    public String getColumnName (int column){
        return columnNames[column];
    }
    
    
}
