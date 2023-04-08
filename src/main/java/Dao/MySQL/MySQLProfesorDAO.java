package Dao.MySQL;

import Dao.ProfesorDAO;
import modelo.Alumno;
import modelo.Profesor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLProfesorDAO implements ProfesorDAO {
    private Connection connection;
    private ResultSet resultSet;
    private PreparedStatement ps;

    public MySQLProfesorDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertar(Profesor a) {
        String  insert = "INSERT INTO profesores (nombre, apellidos) VALUES (?,?)";
        ps = null;
        try {
            ps=connection.prepareStatement(insert);
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getApellidos());
            if(ps.executeUpdate()==0){
                throw new RuntimeException("No se pudo insertar alumno");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }

    @Override
    public void modificar(Profesor a) {
        String  update = "UPDATE profesores SET nombre =?, apellidos =? WHERE id_profesor =?";
        ps = null;
        try {
            ps=connection.prepareStatement(update);
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getApellidos());
            ps.setLong(3, a.getId());
            if(ps.executeUpdate()==0){
                throw new RuntimeException("No se pudo modificar alumno");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    @Override
    public void eliminar(Long id) {
        String  delete = "DELETE FROM profesores WHERE id_profesor =?";
        ps = null;
        try {
            ps=connection.prepareStatement(delete);
            ps.setLong(1, id);
            if(ps.executeUpdate()==0){
                throw new RuntimeException("No se pudo eliminar el profesor");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }
    private Profesor convertirProfesor(ResultSet resultSet) throws SQLException {
        String nombre=resultSet.getString("nombre");
        String apellidos=resultSet.getString("apellidos");
        Profesor profesor=new Profesor(nombre,apellidos);
        profesor.setId(resultSet.getLong("id_profesor"));
        return profesor;
    }

    @Override
    public List<Profesor> obtenerTodos() {
        List<Profesor> profesores=new ArrayList<>();
        String select = "SELECT * FROM profesores";
        ps = null;
        try {
            ps = connection.prepareStatement(select);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                profesores.add(convertirProfesor(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return profesores;
    }

    @Override
    public Profesor obtener(Long id) {
        String select = "SELECT * FROM profesores WHERE id_profesor =?";
        ps = null;
        Profesor profesor=null;
        try {
            ps = connection.prepareStatement(select);
            ps.setLong(1, id);
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                 profesor=convertirProfesor(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return profesor;
    }
}
