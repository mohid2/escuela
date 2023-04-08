package Dao;

import modelo.Alumno;

import java.util.List;

public interface DAO <T,K>{

    void insertar(T a);
    void modificar(T a);
    void eliminar(K id);
    List<T> obtenerTodos();
    T obtener(K id);
}
