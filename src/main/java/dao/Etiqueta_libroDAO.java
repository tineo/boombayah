package dao;

import entity.Etiqueta_libro;

import java.util.List;

/**
 * Created by Alejandro on 24/11/2016.
 */
public interface Etiqueta_libroDAO {
    int insertarEtiqueta_libro(Etiqueta_libro etiqueta_libro) throws Exception;
    List<Etiqueta_libro> buscarEtiqueta(Etiqueta_libro etiqueta_libro) throws Exception;
    List<Etiqueta_libro> listarEtiquetasLibro() throws Exception;
    int eliminar(Etiqueta_libro etiqueta_libro) throws Exception;
}
