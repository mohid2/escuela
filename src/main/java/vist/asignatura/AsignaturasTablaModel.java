package vist.asignatura;

import Dao.AsignaturaDAO;
import modelo.Asignatura;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class AsignaturasTablaModel extends AbstractTableModel {
    private AsignaturaDAO asignatura;
    private List<Asignatura> datos=new ArrayList<>();

    public AsignaturasTablaModel(AsignaturaDAO asignatura) {
        this.asignatura = asignatura;
    }
    public void updateModel(){
        this.datos=asignatura.obtenerTodos();
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Asignatura a =datos.get(rowIndex);
        switch (columnIndex){
            case 0: return a.getId();
            case 1: return a.getNombre();
        }

        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0: return "ID";
            case 1: return "Asignatura";
            default : return null;
        }
    }
}
