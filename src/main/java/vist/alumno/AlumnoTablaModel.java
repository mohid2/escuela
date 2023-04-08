
package vist.alumno;

import Dao.AlumnoDAO;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Alumno;


class AlumnoTablaModel extends AbstractTableModel{
    private AlumnoDAO alumnoDAO;
    private List<Alumno> datos=new ArrayList<>();

    public AlumnoTablaModel(AlumnoDAO alumnoDAO) {
        this.alumnoDAO = alumnoDAO;
    }
    
    public  void updatemodel(){

        this.datos=alumnoDAO.obtenerTodos();
    } 

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "ID";
            case 1: return "Nombre";
            case 2: return "Apellido";
            case 3: return "Fecha de Nacimiento";
            default: return null;
        }
    }
    
    @Override
    public int getRowCount() {

        return datos.size();
    }

    @Override
    public int getColumnCount() {

        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Alumno alumnoPeguntado=datos.get(rowIndex);
       switch (columnIndex) {
           case 0: return alumnoPeguntado.getId();
           case 1: return alumnoPeguntado.getNombre();
           case 2: return alumnoPeguntado.getApellidos();
           case 3:
               DateFormat df = DateFormat.getDateInstance();
               return df.format(alumnoPeguntado.getFechNaimiento());
           default: return null;

       }

    }
    
    
}
