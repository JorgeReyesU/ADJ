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
import vista.login.login;

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
        this.setMinimumSize(new Dimension(1400, 900));
        this.setLocationRelativeTo(null);
        CrearModelo();
        Cargar_Informacion();
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnSFabrica = new javax.swing.JButton();
        btnFact = new javax.swing.JButton();
        btnSUtileria = new javax.swing.JButton();
        btnObservaciones = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 1210, 740));

        btnSFabrica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/bStockF.png"))); // NOI18N
        btnSFabrica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSFabricaActionPerformed(evt);
            }
        });
        getContentPane().add(btnSFabrica, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 80, 80));

        btnFact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/venta_bFacturacion.png"))); // NOI18N
        btnFact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFactActionPerformed(evt);
            }
        });
        getContentPane().add(btnFact, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 80, 80));

        btnSUtileria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/bStockU.png"))); // NOI18N
        btnSUtileria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSUtileriaActionPerformed(evt);
            }
        });
        getContentPane().add(btnSUtileria, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 80, 80));

        btnObservaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/Admin_bObservaciones.png"))); // NOI18N
        btnObservaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObservacionesActionPerformed(evt);
            }
        });
        getContentPane().add(btnObservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 80, 80));

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/bExit.png"))); // NOI18N
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 800, 90, 100));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/Fabrica_StockF.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 900));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSFabricaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSFabricaActionPerformed
        stock_fabrica window = new stock_fabrica();
        window.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSFabricaActionPerformed

    private void btnFactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFactActionPerformed
        facturacion window = new facturacion();
        window.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnFactActionPerformed

    private void btnSUtileriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSUtileriaActionPerformed
        stock_utileria window = new stock_utileria();
        window.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSUtileriaActionPerformed

    private void btnObservacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObservacionesActionPerformed
        observacion window = new observacion();
        window.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnObservacionesActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        login window = new login();
        window.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

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
    private javax.swing.JButton btnFact;
    private javax.swing.JButton btnObservaciones;
    private javax.swing.JButton btnSFabrica;
    private javax.swing.JButton btnSUtileria;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
