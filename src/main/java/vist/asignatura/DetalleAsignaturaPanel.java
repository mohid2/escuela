package vist.asignatura;

import Dao.ProfesorDAO;
import modelo.Asignatura;
import modelo.Profesor;

public class DetalleAsignaturaPanel extends javax.swing.JPanel {

    private Asignatura asignatura;
    private  boolean editable;
    private ProfesoresCombomodel profesoresCombomodel;

    public DetalleAsignaturaPanel() {
        initComponents();

    }
    public DetalleAsignaturaPanel(ProfesorDAO profesorDAO) {
        initComponents();
        this.profesoresCombomodel=new ProfesoresCombomodel(profesorDAO);
        IdProfe.setModel(profesoresCombomodel);
        profesoresCombomodel.update();

    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public boolean isEditable() {
        return editable;
    }

    public ProfesoresCombomodel getProfesoresCombomodel() {
        return profesoresCombomodel;
    }

    public void setProfesoresCombomodel(ProfesoresCombomodel profesoresCombomodel) {
        this.profesoresCombomodel = profesoresCombomodel;
        IdProfe.setModel(profesoresCombomodel);
        profesoresCombomodel.update();
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
        nomAsignatura.setEditable(editable);
        IdProfe.setEnabled(editable);
    }
    public void loadData(){
        if(asignatura!=null){
            nomAsignatura.setText(asignatura.getNombre());
        }else{
            nomAsignatura.setText("");
        }
        nomAsignatura.requestFocus();

    }
    public void saveData(){
        if(asignatura==null){
            asignatura=new Asignatura();
        }
        asignatura.setNombre(nomAsignatura.getText());

        Profesor profesorSeleccionado = (Profesor) IdProfe.getSelectedItem();
        if (profesorSeleccionado != null) {
            asignatura.setIdProfesor(profesorSeleccionado.getId());
        } else {
            asignatura.setIdProfesor(null);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        IdProfe = new javax.swing.JComboBox<>();
        nomAsignatura = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel1.setText("Asignatura:");

        jLabel2.setText("Profesor:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nomAsignatura)
                    .addComponent(IdProfe, 0, 188, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IdProfe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Profesor> IdProfe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nomAsignatura;
    // End of variables declaration//GEN-END:variables
}
