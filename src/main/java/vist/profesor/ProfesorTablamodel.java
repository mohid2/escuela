
package vist.profesor;

import Dao.ProfesorDAO;
import modelo.Profesor;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

class ProfesorTablamodel extends AbstractTableModel {

    private ProfesorDAO profesorDAO;

    private List<Profesor> datos=new ArrayList<>();

    public ProfesorTablamodel(ProfesorDAO profesorDAO) {
        this.profesorDAO = profesorDAO;
    }
    public void updateModel(){
        this.datos=profesorDAO.obtenerTodos();
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Profesor profesor=datos.get(rowIndex);
        switch (columnIndex){
            case 0: return profesor.getId();
            case 1: return profesor.getNombre();
            case 2: return profesor.getApellidos();
        }
        return null;
    }
    public String getColumnName(int column){
        switch (column){
            case 0: return "ID";
            case 1: return "Nombre";
            case 2: return "Apellido";
            default: return "";
    }
}
}
