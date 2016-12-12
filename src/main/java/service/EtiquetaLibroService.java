package service;

import entity.Etiqueta_libro;

import java.util.List;

/**
 * Created by Debra on 06/12/2016.
 */
public interface EtiquetaLibroService  {
    public abstract int insertarEtiqueta_libro(Etiqueta_libro etiqueta) throws Exception;

    public abstract List<Etiqueta_libro> listarEtiquetasLibro() throws Exception;
}
