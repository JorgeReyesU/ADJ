/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.admin;

import java.awt.Dimension;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Materiasprimas;
import modelo.Proveedores;
import persistencia.MateriasprimasJpaController;
import persistencia.ProveedoresJpaController;

/**
 *
 * @author reyes
 */
public class gestionar_mprimas extends javax.swing.JFrame {

    MateriasprimasJpaController cMateriasprimas = new MateriasprimasJpaController();
    ProveedoresJpaController cProveedores = new ProveedoresJpaController();
    Materiasprimas cEdit;
    
    /**
     * Creates new form gestionar_mprimas
     */
    public gestionar_mprimas() {
        initComponents();
        this.setMinimumSize(new Dimension(1400, 680));
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

        txtCantidad = new javax.swing.JTextField();
        bSeleccionar = new javax.swing.JButton();
        txtPrecioC = new javax.swing.JTextField();
        txtNITP = new javax.swing.JTextField();
        bGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        txtNombre = new javax.swing.JTextField();
        bActualizar = new javax.swing.JButton();
        txtDescripcion = new javax.swing.JTextField();
        comboUnidad = new javax.swing.JComboBox<>();
        comboProv = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bSeleccionar.setText("Seleccionar");
        bSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSeleccionarActionPerformed(evt);
            }
        });

        bGuardar.setText("Guardar");
        bGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarActionPerformed(evt);
            }
        });

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

        bActualizar.setText("Actualizar");
        bActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bActualizarActionPerformed(evt);
            }
        });

        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });

        comboUnidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kg", "Gal" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNITP)
                    .addComponent(comboProv, 0, 180, Short.MAX_VALUE))
                .addContainerGap(923, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(bActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(txtPrecioC, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(comboUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(bSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(40, 40, 40)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(337, Short.MAX_VALUE)
                .addComponent(comboProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txtNITP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(219, 219, 219))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(480, 480, 480)
                            .addComponent(bActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(62, 62, 62)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(22, 22, 22)
                            .addComponent(txtPrecioC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(comboUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(188, 188, 188)
                            .addComponent(bSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(bGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSeleccionarActionPerformed
        txtNombre.setText(tabla.getValueAt(tabla.getSelectedRow(), 1).toString());
        txtDescripcion.setText(tabla.getValueAt(tabla.getSelectedRow(), 2).toString());
        comboUnidad.setSelectedItem(modelo.getValueAt(tabla.getSelectedRow(), 3).toString());
        txtCantidad.setText(tabla.getValueAt(tabla.getSelectedRow(), 4).toString());
        txtPrecioC.setText(tabla.getValueAt(tabla.getSelectedRow(), 5).toString());
        txtNITP.setText(tabla.getValueAt(tabla.getSelectedRow(), 6).toString());

        cEdit = cMateriasprimas.findMateriasprimas((Integer) modelo.getValueAt(tabla.getSelectedRow(), 0));
    }//GEN-LAST:event_bSeleccionarActionPerformed

    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed
        try {
            Materiasprimas c = new Materiasprimas();

            c.setMatNombre(txtNombre.getText());
            c.setMatDescripcion(txtDescripcion.getText());
            c.setMatUnidadMedida((String) comboUnidad.getSelectedItem());
            c.setMatCatidad(Integer.parseInt(txtCantidad.getText()));
            c.setMatPrecioComprado(Integer.parseInt(txtPrecioC.getText()));
            c.setProNIT(cProveedores.findProveedores(comboProv.getSelectedItem().toString()));

            cMateriasprimas.create(c);
            System.out.println("Los datos fueron guardados");

            CrearModelo();
            Cargar_Informacion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Problema el guardar datos");
        }
    }//GEN-LAST:event_bGuardarActionPerformed

    private void bActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bActualizarActionPerformed
        try{
            cEdit.setMatNombre(txtNombre.getText());
            cEdit.setMatDescripcion(txtDescripcion.getText());
            cEdit.setMatCatidad(Integer.parseInt(txtCantidad.getText()));
            cEdit.setMatPrecioComprado(Integer.parseInt(txtPrecioC.getText()));
            cEdit.setProNIT(cProveedores.findProveedores(txtNITP.getText()));

            cMateriasprimas.edit(cEdit);
            System.out.println("Se actualizo");
            CrearModelo();
            Cargar_Informacion();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.toString() + "error");
            System.out.println("Error al actualizar");
        }
    }//GEN-LAST:event_bActualizarActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

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
            java.util.logging.Logger.getLogger(gestionar_mprimas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gestionar_mprimas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gestionar_mprimas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gestionar_mprimas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gestionar_mprimas().setVisible(true);
            }
        });
    }
    
    DefaultTableModel modelo;
    private void CrearModelo() {
        try {
            modelo = (new DefaultTableModel(
                    null, new String[]{
                        "Codigo", "Nombre", "Descripcion",
                        "Unidad", "Cantidad", "P. Comprado",
                        "Proveedor"}) {
                Class[] types = new Class[]{
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
            List<Materiasprimas> listP = cMateriasprimas.findMateriasprimasEntities();
            List<Proveedores> listProv = cProveedores.findProveedoresEntities();
            for (int i=0; i< listP.size(); i++){
                modelo.addRow(o);
                modelo.setValueAt(listP.get(i).getMatCodigo(), i, 0);
                modelo.setValueAt(listP.get(i).getMatNombre(), i, 1);
                modelo.setValueAt(listP.get(i).getMatDescripcion(), i, 2);
                modelo.setValueAt(listP.get(i).getMatUnidadMedida(), i, 3);
                modelo.setValueAt(listP.get(i).getMatCatidad(), i, 4);
                modelo.setValueAt(listP.get(i).getMatPrecioComprado(), i, 5);
                modelo.setValueAt(listP.get(i).getProNIT().getProNIT(), i, 6);                
            }                                            
            
            for (int i = 0; i < listProv.size(); i++) {
                comboProv.addItem(listProv.get(i).getProNIT());
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("problema al cargar datos");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bActualizar;
    private javax.swing.JButton bGuardar;
    private javax.swing.JButton bSeleccionar;
    private javax.swing.JComboBox<String> comboProv;
    private javax.swing.JComboBox<String> comboUnidad;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNITP;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecioC;
    // End of variables declaration//GEN-END:variables
}
