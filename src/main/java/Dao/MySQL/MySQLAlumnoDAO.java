package Dao.MySQL;

import Dao.AlumnoDAO;
import modelo.Alumno;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAlumnoDAO implements AlumnoDAO {
    private Connection connection;
    private ResultSet resultSet;

    public MySQLAlumnoDAO(Connection connection) {
            this.connection = connection;
    }


    @Override
    public void insertar(Alumno a) {
        String INSERT="INSERT INTO alumnos(nombre,apellidos,fecha_nac)VALUES(?,?,?)";
        PreparedStatement   ps =null;
        try {
            ps=connection.prepareStatement(INSERT);
            ps.setString(1,a.getNombre());
            ps.setString(2,a.getApellidos());
            ps.setDate(3,new Date(a.getFechNaimiento().getTime()));
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
    public void modificar(Alumno a) {
        String UPDATE="UPDATE alumnos SET nombre=?,apellidos=?,fecha_nac=? WHERE id_alumno=?";
        PreparedStatement   ps =null;
        Alumno alumnoEx=obtener(a.getId());
        resultSet = null;
        try {
            ps=connection.prepareStatement(UPDATE);
            ps.setString(1,a.getNombre());
            ps.setString(2,a.getApellidos());
            ps.setDate(3,new Date(a.getFechNaimiento().getTime()));
            ps.setLong(4,a.getId());
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
        String DELETE="DELETE FROM alumnos WHERE id_alumno=?";
        PreparedStatement  ps =null;
        try {
            ps=connection.prepareStatement(DELETE);
            ps.setLong(1,id);
            if(ps.executeUpdate()==0){
                System.out.println(("No se pudo eliminar alumno"));
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
    private Alumno convertirAlumno(ResultSet resultSet)  {
        String nombre= null;
        try {
            nombre = resultSet.getString("nombre");
            String apellidos=resultSet.getString("apellidos");
            Date fechNaimiento=resultSet.getDate("fecha_nac");
            Alumno alumno=new Alumno(nombre,apellidos,fechNaimiento);
            alumno.setId(resultSet.getLong("id_alumno"));
            return alumno;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Alumno> obtenerTodos() {
        String SELECT="SELECT * FROM alumnos";
        List<Alumno> alumnos = new ArrayList<>();
        PreparedStatement ps = null;
        try {
            ps=connection.prepareStatement(SELECT);
            resultSet=ps.executeQuery();
            while(resultSet.next()) {
                alumnos.add(convertirAlumno(resultSet));
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
                if (resultSet!=null) {
                    try {
                        resultSet.close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        return alumnos;
    }

    @Override
    public Alumno obtener(Long id) {
        String SELECT="SELECT * FROM alumnos WHERE id_alumno=?";
        PreparedStatement ps=null;
        Alumno a=null;
        try {
            ps=connection.prepareStatement(SELECT);
            ps.setLong(1,id);
            resultSet=ps.executeQuery();
            if(resultSet.next()) {
                a=convertirAlumno(resultSet);
            }
            else{
                throw new RuntimeException("No se encontro alumno con id "+id);
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
        return a;
    }
}
