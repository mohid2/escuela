
package vist.asignatura;


import Dao.DAOManager;
import Dao.MySQL.MySQLDaoManger;
import modelo.Asignatura;
import modelo.Profesor;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class ListaAsignaturasFarme extends javax.swing.JFrame {
    private DAOManager manager;
    private AsignaturasTablaModel model;


    public ListaAsignaturasFarme(DAOManager manager) throws HeadlessException {
        initComponents();
        this.manager = manager;
        this.model = new AsignaturasTablaModel(manager.getAsignaturaDAO());
        this.model.updateModel();
        this.tabla.setModel(model);
        this.detalle.setProfesoresCombomodel(new ProfesoresCombomodel(manager.getProfesorDAO()));
        this.tabla.getSelectionModel().addListSelectionListener(e -> {
            boolean seleccionValida = (tabla.getSelectedRow() != -1);
            editar.setEnabled(seleccionValida);
            borrar.setEnabled(seleccionValida);
        });

    }

    public ListaAsignaturasFarme() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        nuevo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        editar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        borrar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        guardar = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        cancelar = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        detalle = new vist.asignatura.DetalleAsignaturaPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jToolBar1.setRollover(true);

        nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imag/icons8-por-nueva-copia-30.png"))); // NOI18N
        nuevo.setText("Nuevo");
        nuevo.setBorderPainted(false);
        nuevo.setContentAreaFilled(false);
        nuevo.setFocusable(false);
        nuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });
        jToolBar1.add(nuevo);
        jToolBar1.add(jSeparator1);

        editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imag/icons8-editar-fila-30.png"))); // NOI18N
        editar.setText("Editar");
        editar.setBorderPainted(false);
        editar.setContentAreaFilled(false);
        editar.setEnabled(false);
        editar.setFocusable(false);
        editar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });
        jToolBar1.add(editar);
        jToolBar1.add(jSeparator2);

        borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imag/icons8-eliminar-30.png"))); // NOI18N
        borrar.setText("Borrar");
        borrar.setBorderPainted(false);
        borrar.setContentAreaFilled(false);
        borrar.setEnabled(false);
        borrar.setFocusable(false);
        borrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        borrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });
        jToolBar1.add(borrar);
        jToolBar1.add(jSeparator3);

        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imag/icons8-guardar-30.png"))); // NOI18N
        guardar.setText("Guardar");
        guardar.setBorderPainted(false);
        guardar.setContentAreaFilled(false);
        guardar.setEnabled(false);
        guardar.setFocusable(false);
        guardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        guardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        jToolBar1.add(guardar);
        jToolBar1.add(jSeparator4);

        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imag/icons8-cerrar-ventana-30.png"))); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.setBorderPainted(false);
        cancelar.setContentAreaFilled(false);
        cancelar.setEnabled(false);
        cancelar.setFocusable(false);
        cancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        jToolBar1.add(cancelar);
        jToolBar1.add(jSeparator5);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);
        getContentPane().add(detalle, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        detalle.setAsignatura(null);
        detalle.setEnabled(true);
        detalle.loadData();
        guardar.setEnabled(true);
        cancelar.setEnabled(true);
        
    }//GEN-LAST:event_nuevoActionPerformed
    private Asignatura getAsigaturaSleccionada() {
        Long id = (Long) tabla.getValueAt(tabla.getSelectedRow(), 0);
        return manager.getAsignaturaDAO().obtener(id);
    }

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        Asignatura asignatura =getAsigaturaSleccionada();
        detalle.setAsignatura(asignatura);
        detalle.loadData();
        detalle.setEditable(true);
        guardar.setEnabled(true);
        cancelar.setEnabled(true);
  
    }//GEN-LAST:event_editarActionPerformed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        if(JOptionPane.showConfirmDialog(rootPane, "Está seguro que desea borrar","Borrar",
                JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            Asignatura asignatura=getAsigaturaSleccionada();
            manager.getAsignaturaDAO().eliminar(asignatura.getId());
            model.updateModel();
            model.fireTableDataChanged();
            JOptionPane.showMessageDialog(rootPane, "Asignatura  Eliminado");
        }
       
    }//GEN-LAST:event_borrarActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        detalle.saveData();
        Asignatura  asignatura=detalle.getAsignatura();
        if(asignatura.getId()==null){
            manager.getAsignaturaDAO().insertar(asignatura);
            JOptionPane.showMessageDialog(rootPane, "Asignatura agregado con exito");
        }else {
            manager.getAsignaturaDAO().modificar(asignatura);
            JOptionPane.showMessageDialog(rootPane, "Asignatura modificado correctamente");
        }
        detalle.setAsignatura(null);
        detalle.setEditable(false);
        detalle.loadData();
        tabla.clearSelection();
        guardar.setEnabled(false);
        cancelar.setEnabled(false);
        model.updateModel();
        model.fireTableDataChanged();
   
    }//GEN-LAST:event_guardarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        detalle.setAsignatura(null);
        detalle.loadData();
        tabla.clearSelection();
        guardar.setEnabled(false);
        cancelar.setEnabled(false);
     
    }//GEN-LAST:event_cancelarActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borrar;
    private javax.swing.JButton cancelar;
    private vist.asignatura.DetalleAsignaturaPanel detalle;
    private javax.swing.JButton editar;
    private javax.swing.JButton guardar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton nuevo;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
