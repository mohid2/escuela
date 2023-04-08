package vist.asignatura;

import Dao.ProfesorDAO;
import modelo.Profesor;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ProfesoresCombomodel extends DefaultComboBoxModel<Profesor> {
    private ProfesorDAO profesorDAO;
    private List<Profesor> lista;

    public ProfesoresCombomodel(ProfesorDAO profesorDAO) {
        this.profesorDAO = profesorDAO;
        this.lista=new ArrayList<>();
    }
    public void  update(){
        this.lista=profesorDAO.obtenerTodos();
        removeAllElements();
        for (Profesor p:lista){
            addElement(p);
        }

    }
}
