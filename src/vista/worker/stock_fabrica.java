/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.worker;

import java.awt.Dimension;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.logica_fabrica_stock_fabrica;
import modelo.Productos;
import persistencia.ProductosJpaController;

/**
 *
 * @author reyes
 */
public class stock_fabrica extends javax.swing.JFrame {

    ProductosJpaController cProductos = new ProductosJpaController();
    logica_fabrica_stock_fabrica logicaF = new logica_fabrica_stock_fabrica();
    Productos cEdit;
    
    public static int contadorG = 0;
    public static int contadorP = 0;
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        bAgregar = new javax.swing.JButton();

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

        bAgregar.setText("Agregar lote");
        bAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1020, 1020, 1020)
                        .addComponent(bAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(bAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAgregarActionPerformed
        try {
            List<Productos> listP = cProductos.findProductosEntities();
            //if (Integer.parseInt((String) modelo.getValueAt(tabla.getSelectedRow(), 0)) == 123) {
                
           // }
            
            
            
            
            
            
            
            //     String productoF = listP.get(i).getProdDescripcion();
            String productoF1 = listP.get(0).getProdNombre();
            String productoF2 = listP.get(1).getProdNombre();
            int numeroo = tabla.getSelectedRow();
            String Nombree = (String) modelo.getValueAt(numeroo, 1);
            if (Nombree.equals(productoF1) && (contadorG < 3)) {
                cEdit = cProductos.findProductos((Integer) modelo.getValueAt(tabla.getSelectedRow(), 0));
                int numero = tabla.getSelectedRow();
                int cantidadS = (int) modelo.getValueAt(numero, 3);
                //System.out.println(cantidadS);

                cEdit.setProdCantidad(cantidadS + 300);
                logicaF.reducirMP(0);
                contadorG++;
            } else if (Nombree.equals(productoF1) && contadorG > 2) {
                JOptionPane.showMessageDialog(null, "ya se agregaron demasiados lotes de graniplas por hoy");
            }

            if (Nombree.equals(productoF2) && (contadorP < 3)) {
                cEdit = cProductos.findProductos((Integer) modelo.getValueAt(tabla.getSelectedRow(), 0));
                int numero = tabla.getSelectedRow();
                int cantidadS = (int) modelo.getValueAt(numero, 3);
                //  System.out.println(cantidadS);

                cEdit.setProdCantidad(cantidadS + 60);
                logicaF.reducirMP(1);
                contadorP++;
            } else if (Nombree.equals(productoF2) && contadorP > 2) {
                JOptionPane.showMessageDialog(null, "ya se agregaron demasiados lotes de pintura por hoy");
            }

            cProductos.edit(cEdit);
            System.out.println("Se actualizo");
            CrearModelo();
            Cargar_Informacion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString() + "error");
            System.out.println("Error al actualizar");
        }
    }//GEN-LAST:event_bAgregarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(stock_fabrica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(stock_fabrica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(stock_fabrica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(stock_fabrica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new stock_fabrica().setVisible(true);
            }
        });
    }
    
    DefaultTableModel modelo;
    private void CrearModelo() {
        try {
            modelo = (new DefaultTableModel(
                    null, new String[]{
                        "Codigo", "Nombre",
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
                    false, false, false, false, false, false, false
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
                   // modelo.setValueAt(listP.get(i).getProdDescripcion(), contadorr, 2);
                    modelo.setValueAt(listP.get(i).getProdUnidadMedida(), contadorr, 2);
                    modelo.setValueAt(listP.get(i).getProdCantidad(), contadorr, 3);
                    modelo.setValueAt(listP.get(i).getProdPrecioComprado(), contadorr, 4);
                    modelo.setValueAt(listP.get(i).getProdPrecioVenta(), contadorr, 5);
                    modelo.setValueAt(listP.get(i).getProNIT().getProNIT(), contadorr, 6);
                    contadorr++;
                }
            }                                            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("problema al cargar datos");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAgregar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
