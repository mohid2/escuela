package Dao.MySQL;

import Dao.AsignaturaDAO;
import modelo.Asignatura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MysqlAsignaturaDAO implements AsignaturaDAO {
    private Connection con;
    private PreparedStatement ps;

    public MysqlAsignaturaDAO(Connection con) {
        this.con = con;
    }

    @Override
    public void insertar(Asignatura a) {
        ps = null;
        try {
            ps = con.prepareStatement("INSERT INTO asignaturas (nombre, profesor) VALUES (?,?)");
            ps.setString(1, a.getNombre());
            ps.setLong(2, a.getIdProfesor());
            if(ps.executeUpdate()==0){
                System.out.println("No se pudo insertar");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public void modificar(Asignatura a) {

    }

    @Override
    public void eliminar(Long id) {
        ps = null;
        try {
            ps = con.prepareStatement("DELETE FROM asignaturas WHERE id_asignatura =?");
            ps.setLong(1, id);
            if(ps.executeUpdate()==0){
                System.out.println("No se pudo eliminar");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    private Asignatura obtenerAsignatura(ResultSet rs){
        Asignatura a = null;
        try {
            String nombre = rs.getString("nombre");
            Long profesor = rs.getLong("profesor");
            a = new Asignatura(nombre, profesor);
            a.setId(rs.getLong("id_asignatura"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return a;
    }

    @Override
    public List<Asignatura> obtenerTodos() {
        ps = null;
        List<Asignatura> asignaturas = new ArrayList<>();
        try {
            ps =con.prepareStatement("SELECT * FROM asignaturas");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               asignaturas.add(obtenerAsignatura(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return asignaturas;
    }

    @Override
    public Asignatura obtener(Long id) {
        ps = null;
        try {
            ps = con.prepareStatement("SELECT * FROM asignaturas WHERE id_asignatura =?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return obtenerAsignatura(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}

