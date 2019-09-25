/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import modelo.Detallesorden;
import modelo.Ordenes;
import modelo.Productos;
import persistencia.DetallesordenJpaController;
import persistencia.OrdenesJpaController;
import persistencia.ProductosJpaController;
import vista.seller.facturacion;
import static vista.seller.facturacion.labelDescuento;
import static vista.seller.facturacion.labelTotal;
import static vista.seller.facturacion.subtotal;
import vista.seller.pago;

/**
 *
 * @author Kings
 */
public class logica_venta_facturacion {
    ProductosJpaController cProductos = new ProductosJpaController();
    
    public static DetallesordenJpaController cDetalles = new DetallesordenJpaController();
    
    public static int total;
    
    
    
    public static void agregarItemTabla(int cAgregar, String nombre, String color, int cantidadP, String unidad, int valorU, int total){
        Object o[] = null;
        vista.seller.facturacion.modelo.addRow(o);
        vista.seller.facturacion.modelo.setValueAt(nombre, cAgregar, 0);
        vista.seller.facturacion.modelo.setValueAt(color, cAgregar, 1);
        vista.seller.facturacion.modelo.setValueAt(cantidadP, cAgregar, 2);
        vista.seller.facturacion.modelo.setValueAt(unidad, cAgregar, 3);
        vista.seller.facturacion.modelo.setValueAt(valorU, cAgregar, 4);
        vista.seller.facturacion.modelo.setValueAt(total, cAgregar, 5); 
    }

    public static void subtotalL(int cAgregar, int valorT){
        subtotal = subtotal + valorT;    
        vista.seller.facturacion.labelSubtotal.setText(String.valueOf(subtotal));
    }
    
    public static void totalL(){
        total = subtotal - ((Integer.parseInt(labelDescuento.getText()) * subtotal)/100);
        labelTotal.setText(String.valueOf(total));
    }
    
  /*  public static void crearDeta(Productos prodCodigo, int cantidad, String color){
        Detallesorden c = new Detallesorden();
        OrdenesJpaController cOrdenes = new OrdenesJpaController();
        int num = cOrdenes.getOrdenesCount();
        Ordenes ordenn = cOrdenes.findOrdenes(num);
        c.setOrdCodigo(ordenn);
        c.setProdCodigo(prodCodigo);
        c.setDetCantidad(cantidad);
        c.setDetDescripcion(color);
        cDetalles.create(c);
    }*/
}
