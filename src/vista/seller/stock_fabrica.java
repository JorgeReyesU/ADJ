/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.seller;

import java.awt.Dimension;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Productos;
import persistencia.ProductosJpaController;

/**
 *
 * @author Juan Sebaxtian
 */
public class stock_fabrica extends javax.swing.JFrame {
ProductosJpaController cProductos = new ProductosJpaController();
    Productos cEdit;
    
    /**
     * Creates new form stock_fabrica
     */
    public stock_fabrica() {
    initComponents();
        this.setMinimumSize(new Dimension(1420, 950));
        this.setLocationRelativeTo(null);
        CrearModelo();
        Cargar_Informacion();
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 945, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    DefaultTableModel modelo;
    private void CrearModelo() {
        try {
            modelo = (new DefaultTableModel(
                    null, new String[]{
                        "Codigo", "Nombre", "Descripcion",
                        "Unidad", "Cantidad", "P. Comprado",
                        "P. Venta", "Proveedor"}) {
                Class[] types = new Class[]{
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class
                };
                boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, false, false
                };

                @Override
                public Class getColumnClass(int columnIndex) {
                    return types[columnIndex];
                }

                @Override
                public boolean isCellEditable(int rowIndex, int colIndex) {
                    return canEdit[colIndex];
                }
            });
            tabla.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString() + "error");
            System.out.println("Problema con el modelo de tabla");
        }
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new stock_fabrica().setVisible(true);
            }
        });
    }
private void Cargar_Informacion(){
        try{
            Object o[]=null;
            List<Productos> listP = cProductos.findProductosEntities();
            int contadorr = 0;
            for (int i=0; i< listP.size(); i++){
                String productoF = listP.get(i).getProdDescripcion();
                String productoF2 = listP.get(0).getProdDescripcion();
                if(productoF.equals(productoF2)){
                    modelo.addRow(o);
                    modelo.setValueAt(listP.get(i).getProdCodigo(), contadorr, 0);
                    modelo.setValueAt(listP.get(i).getProdNombre(), contadorr, 1);
                    modelo.setValueAt(listP.get(i).getProdDescripcion(), contadorr, 2);
                    modelo.setValueAt(listP.get(i).getProdUnidadMedida(), contadorr, 3);
                    modelo.setValueAt(listP.get(i).getProdCantidad(), contadorr, 4);
                    modelo.setValueAt(listP.get(i).getProdPrecioComprado(), contadorr, 5);
                    modelo.setValueAt(listP.get(i).getProdPrecioVenta(), contadorr, 6);
                    modelo.setValueAt(listP.get(i).getProNIT().getProNIT(), contadorr, 7);
                    contadorr++;
                }
            }                                            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("problema al cargar datos");
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
