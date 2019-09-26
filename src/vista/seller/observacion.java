package vista.seller;

import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Empleados;
import modelo.Observaciones;
import persistencia.EmpleadosJpaController;
import persistencia.ObservacionesJpaController;
import vista.login.login;

/**
 *
 * @author Juan Sebaxtian
 */
public class observacion extends javax.swing.JFrame {
   EmpleadosJpaController cEmpleados = new EmpleadosJpaController();
    ObservacionesJpaController cObservaciones = new ObservacionesJpaController();
    
    java.util.Date fecha = new Date();
    String strDateFormat = "dd/MM/y";
    SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
    String fechaHoy = objSDF.format(fecha);
    
    public observacion() {
        this.setMinimumSize(new Dimension(1000, 650));
        this.setLocationRelativeTo(null);
        initComponents();}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservacion = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        btnFact = new javax.swing.JButton();
        btnSUtileria = new javax.swing.JButton();
        btnSFabrica = new javax.swing.JButton();
        btnObservaciones = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtObservacion.setColumns(20);
        txtObservacion.setRows(5);
        jScrollPane1.setViewportView(txtObservacion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 740, 500));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/bGuardar.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 570, 200, 50));

        btnFact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/venta_bFacturacion.png"))); // NOI18N
        btnFact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFactActionPerformed(evt);
            }
        });
        getContentPane().add(btnFact, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 80, 80));

        btnSUtileria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/bStockU.png"))); // NOI18N
        btnSUtileria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSUtileriaActionPerformed(evt);
            }
        });
        getContentPane().add(btnSUtileria, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 80, 80));

        btnSFabrica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/bStockF.png"))); // NOI18N
        btnSFabrica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSFabricaActionPerformed(evt);
            }
        });
        getContentPane().add(btnSFabrica, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 80, 80));

        btnObservaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/Admin_bObservaciones.png"))); // NOI18N
        btnObservaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObservacionesActionPerformed(evt);
            }
        });
        getContentPane().add(btnObservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 80, 80));

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/bExit.png"))); // NOI18N
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 90, 100));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/SmallWin.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int resp = JOptionPane.showConfirmDialog(this, "Esta seguro que desea enviar esta observacion?", "Confirmacion",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (resp == JOptionPane.YES_OPTION) {
            try {
                Observaciones c = new Observaciones();
                List<Empleados> listE = cEmpleados.findEmpleadosEntities();
                Empleados emp = listE.get(1);
                c.setEmpDni(emp);
                c.setObsDescripcion(txtObservacion.getText());
                Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(fechaHoy);
                c.setObsFecha(date1);
                c.setObsEstado(0);

                cObservaciones.create(c);

                System.out.println("Los datos fueron guardados");

                txtObservacion.setText("");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                System.out.println("Problema el guardar datos");
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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

    private void btnSFabricaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSFabricaActionPerformed
        stock_fabrica window = new stock_fabrica();
        window.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSFabricaActionPerformed

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

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new observacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFact;
    private javax.swing.JButton btnObservaciones;
    private javax.swing.JButton btnSFabrica;
    private javax.swing.JButton btnSUtileria;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtObservacion;
    // End of variables declaration//GEN-END:variables
}
