package Dao.MySQL;

import Dao.MatriculaDAO;
import modelo.Matricula;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLMatriculaDAO implements MatriculaDAO {
    private Connection con;
    private PreparedStatement ps;

    public MySQLMatriculaDAO(Connection con) {
        this.con = con;
    }

    @Override
    public void insertar(Matricula a) {
        ps=null;
        try {
            ps=con.prepareStatement("INSERT INTO matricula (alumno,asignatura,fecha,nota) VALUES (?,?,?,?)");
            ps.setLong(1,a.getId().getAlumno());
            ps.setLong(2,a.getId().getAsignatura());
            ps.setInt(3,a.getId().getYear());
            if(a.getNota()==null){
                ps.setInt(4,a.getNota());
            }
            if(ps.executeUpdate()==0){
                throw new RuntimeException("No se pudo insertar");
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
    public void modificar(Matricula a) {
        ps=null;
        try {
            ps=con.prepareStatement("UPDATE matricula SET alumno=?,asignatura=?,fecha=?,nota=? WHERE id=?");
            ps.setLong(1,a.getId().getAlumno());
            ps.setLong(2,a.getId().getAsignatura());
            ps.setInt(3,a.getId().getYear());
            if(a.getNota()==null){
                ps.setInt(4,a.getNota());
            }else {
                ps.setNull(4, Types.INTEGER);
            }
            ps.setObject(5,a.getId());
            if(ps.executeUpdate()==0){
                throw new RuntimeException("No se pudo modificar");
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
    public void eliminar(Matricula.IdMatricula id) {
        ps=null;
        try {
            ps=con.prepareStatement("DELETE FROM matricula WHERE id=?");
            ps.setObject(1,id);
            if(ps.executeUpdate()==0){
                throw new RuntimeException("No se pudo eliminar");
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
    public List<Matricula> obtenerTodos() {
        String sql="SELECT * FROM matricula";
        ps=null;
        List<Matricula> matriculas=new ArrayList<>();
        try {
            ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                matriculas.add(convertirMatricula(rs));
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
        return matriculas;
    }

    private Matricula convertirMatricula(ResultSet rs) throws SQLException {
        long alumno=rs.getLong("alumno");
        long asignatura=rs.getLong("asignatura");
        int year=rs.getInt("year");
        Integer nota=rs.getInt("nota");
        if(rs.wasNull()){
            nota=null;
        }
        Matricula matricula=new Matricula(alumno,asignatura,year);
        matricula.setNota(nota);
        return matricula;
    }

    @Override
    public Matricula obtener(Matricula.IdMatricula id) {
        String sql="SELECT * FROM matricula WHERE alumno=? AND asignatura=? AND year=?";
        ps=null;
        Matricula matricula=null;
        try {
            ps=con.prepareStatement(sql);
            ps.setLong(1,id.getAlumno());
            ps.setLong(2,id.getAsignatura());
            ps.setInt(3,id.getYear());
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                matricula=convertirMatricula(rs);
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

        return null;
    }

    @Override
    public List<Matricula> obtenerPorAlumno(long alumno) {
        ps=null;
        String sql="SELECT * FROM matricula WHERE alumno=?";
        List<Matricula> matriculas=new ArrayList<>();
        try {
            ps=con.prepareStatement(sql);
            ps.setLong(1,alumno);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                matriculas.add(convertirMatricula(rs));
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

        return matriculas;
    }

    @Override
    public List<Matricula> obtenerPorAsignatura(long asignatura) {
        ps=null;
        String sql="SELECT * FROM matricula WHERE asignatura=?";
        List<Matricula> matriculas=new ArrayList<>();
        try {
            ps=con.prepareStatement(sql);
            ps.setLong(1,asignatura);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                matriculas.add(convertirMatricula(rs));
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

        return matriculas;
    }

    @Override
    public List<Matricula> obtenerPorCurso(int curso) {
        ps=null;
        String sql="SELECT * FROM matricula WHERE curso=?";
        List<Matricula> matriculas=new ArrayList<>();
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1,curso);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                matriculas.add(convertirMatricula(rs));
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

        return matriculas;

    }
}
