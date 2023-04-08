package Dao.MySQL;

import Dao.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDaoManger implements DAOManager {
    private Connection con;
    private AlumnoDAO alumno=null;
    private ProfesorDAO profesor=null;
    private MatriculaDAO matricula=null;
    private AsignaturaDAO asignatura=null;



    public MySQLDaoManger(String host,String database,  String user, String password ) throws SQLException {
        this.con = DriverManager.getConnection("jdbc:mysql://" + host + "/" + database,user,password );
    }

    @Override
    public AlumnoDAO getAlumnoDAO() {
        if(alumno==null){
            alumno=new MySQLAlumnoDAO(con);
        }
        return alumno;
    }

    @Override
    public ProfesorDAO getProfesorDAO() {
        if(profesor==null){
            profesor=new MySQLProfesorDAO(con);
        }
        return profesor;

    }

    @Override
    public MatriculaDAO getMatriculaDAO() {
        if(matricula==null){
            matricula=new MySQLMatriculaDAO(con);
        }
        return matricula;

    }

    @Override
    public AsignaturaDAO getAsignaturaDAO() {
        if(asignatura==null){
            asignatura=new MysqlAsignaturaDAO(con);
        }
        return asignatura;

    }
}
