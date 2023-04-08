
package vist.alumno;

import Dao.DAOManager;

import java.awt.*;
import java.text.ParseException;

import modelo.Alumno;

import javax.swing.*;

public class listaAlumnosFrame extends javax.swing.JFrame {
    
    private DAOManager manager;
    private AlumnoTablaModel alumnoTablaModel;

    public listaAlumnosFrame(DAOManager manager) throws HeadlessException {
        initComponents();
        this.manager = manager;
        this.alumnoTablaModel = new AlumnoTablaModel(manager.getAlumnoDAO());
        this.alumnoTablaModel.updatemodel();
        this.tabla.setModel(alumnoTablaModel);
        this.tabla.getSelectionModel().addListSelectionListener(e -> {
            boolean seleccionValida = (tabla.getSelectedRow() != -1);
            editar.setEnabled(seleccionValida);
            borrar.setEnabled(seleccionValida);
        });


    }

    public listaAlumnosFrame() {
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
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        detalle = new vist.alumno.DetalleAlumnoPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jToolBar1.setRollover(true);

        nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imag/icons8-por-nueva-copia-30.png"))); // NOI18N
        nuevo.setText("Nuevo");
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
        cancelar.setFocusable(false);
        cancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        jToolBar1.add(cancelar);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.BorderLayout());

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

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);
        jPanel1.add(detalle, java.awt.BorderLayout.LINE_END);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private Alumno getAlumnoSeleccionado(){
        Long id = (Long) tabla.getValueAt(tabla.getSelectedRow(), 0);
        return manager.getAlumnoDAO().obtener(id);
    }
    
    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        Alumno alumno=getAlumnoSeleccionado();
        detalle.setAlumno(alumno);
        detalle.setEditable(true);
        detalle.loadData();
        guardar.setEnabled(true);
        cancelar.setEnabled(true);
    }//GEN-LAST:event_editarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        detalle.setAlumno(null);
        detalle.setEditable(false);
        detalle.loadData();
        tabla.clearSelection();
        guardar.setEnabled(false);
        cancelar.setEnabled(false);

        // TODO add your handling code here:
    }//GEN-LAST:event_cancelarActionPerformed

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        detalle.setAlumno(null);
        detalle.loadData();
        detalle.setEditable(true);
        guardar.setEnabled(true);
        cancelar.setEnabled(true);

    }//GEN-LAST:event_nuevoActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        try {
            detalle.saveData();
            Alumno alu=detalle.getAlumno();
            if(alu.getId()==null){
                manager.getAlumnoDAO().insertar(alu);
                JOptionPane.showMessageDialog(rootPane, "Alumno agregado con exito");
            }else{
                manager.getAlumnoDAO().modificar(alu);
                JOptionPane.showMessageDialog(rootPane, "Alumno modificado correctamente");
            }
            detalle.setAlumno(null);
            detalle.setEditable(false);
            detalle.loadData();
            tabla.clearSelection();
            guardar.setEnabled(false);
            cancelar.setEnabled(false);
            alumnoTablaModel.updatemodel();
            alumnoTablaModel.fireTableDataChanged();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }//GEN-LAST:event_guardarActionPerformed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        if(JOptionPane.showConfirmDialog(rootPane, "Está seguro que desea borrar","Borrar",
                JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
            Alumno Alumno = getAlumnoSeleccionado();
            manager.getAlumnoDAO().eliminar(Alumno.getId());
            alumnoTablaModel.updatemodel();
            alumnoTablaModel.fireTableDataChanged();
            JOptionPane.showMessageDialog(rootPane, "Alumno Eliminado");
        }
    }//GEN-LAST:event_borrarActionPerformed

   


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borrar;
    private javax.swing.JButton cancelar;
    private vist.alumno.DetalleAlumnoPanel detalle;
    private javax.swing.JButton editar;
    private javax.swing.JButton guardar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton nuevo;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
