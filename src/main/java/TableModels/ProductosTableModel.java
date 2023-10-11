/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableModels;

import Logica.Administrador;
import Logica.DatosGlobales;
import Logica.Producto;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cesar
 */
public class ProductosTableModel extends AbstractTableModel {
    DatosGlobales datosGlobales = DatosGlobales.getInstance();
    ArrayList<Producto> productos = datosGlobales.getPRODUCTOS();
    private String[] columnNames = {"Nombre","Precio"};
    
    public void AgregarProducto (String nombre, String precio,String cantidad){
        Administrador administrador = new Administrador();
        administrador.agregarProductos(nombre, precio, cantidad);
        fireTableDataChanged();
    }
    @Override
    public int getRowCount() {
        return productos.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Producto producto = productos.get(rowIndex);
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
