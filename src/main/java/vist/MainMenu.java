
package vist;

import Dao.DAOManager;
import vist.alumno.listaAlumnosFrame;
import vist.asignatura.ListaAsignaturasFarme;
import vist.profesor.listaProfesoresFarme;


public class MainMenu extends javax.swing.JFrame {
    private DAOManager manager;
    public MainMenu(DAOManager manager) {
        initComponents();
        this.manager = manager;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        alumnos = new javax.swing.JButton();
        Asignaturas = new javax.swing.JButton();
        profesores = new javax.swing.JButton();
        Matriculas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Panel prencipal");

        alumnos.setBackground(new java.awt.Color(0, 204, 204));
        alumnos.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        alumnos.setText("Alumnos");
        alumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alumnosActionPerformed(evt);
            }
        });

        Asignaturas.setBackground(new java.awt.Color(0, 204, 204));
        Asignaturas.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        Asignaturas.setText("Asignaturas");
        Asignaturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AsignaturasActionPerformed(evt);
            }
        });

        profesores.setBackground(new java.awt.Color(0, 204, 204));
        profesores.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        profesores.setText("Profesores");
        profesores.setActionCommand("");
        profesores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profesoresActionPerformed(evt);
            }
        });

        Matriculas.setBackground(new java.awt.Color(0, 204, 204));
        Matriculas.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        Matriculas.setText("Matriculas");
        Matriculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MatriculasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Asignaturas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(alumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(profesores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Matriculas, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(profesores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(alumnos, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Asignaturas, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(Matriculas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void alumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alumnosActionPerformed
        listaAlumnosFrame  listaAlumnosFrame=new  listaAlumnosFrame(manager);
        listaAlumnosFrame.setLocationRelativeTo(this);
        listaAlumnosFrame.setVisible(true);

    }//GEN-LAST:event_alumnosActionPerformed

    private void AsignaturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AsignaturasActionPerformed
        ListaAsignaturasFarme listaAsignaturasFarme=new ListaAsignaturasFarme(manager);
        listaAsignaturasFarme.setLocationRelativeTo(this);
        listaAsignaturasFarme.setVisible(true);

    }//GEN-LAST:event_AsignaturasActionPerformed

    private void profesoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profesoresActionPerformed
        listaProfesoresFarme listaProfesoresFarme =new listaProfesoresFarme(manager);
        listaProfesoresFarme.setLocationRelativeTo(this);
        listaProfesoresFarme.setVisible(true);

    }//GEN-LAST:event_profesoresActionPerformed

    private void MatriculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MatriculasActionPerformed


    }//GEN-LAST:event_MatriculasActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Asignaturas;
    private javax.swing.JButton Matriculas;
    private javax.swing.JButton alumnos;
    private javax.swing.JButton profesores;
    // End of variables declaration//GEN-END:variables
}
