package Dao;

import modelo.Matricula;

import java.util.List;

public interface MatriculaDAO extends DAO<Matricula,Matricula.IdMatricula> {
    List<Matricula> obtenerPorAlumno(long alumno);
    List<Matricula> obtenerPorAsignatura(long asignatura);
    List<Matricula> obtenerPorCurso(int curso);
}
