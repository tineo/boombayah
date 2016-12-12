package dao;

import entity.Etiqueta;

import java.util.List;


public interface EtiquetaDAO {
    int insertarEtiqueta(Etiqueta etiqueta) throws Exception;
    List<Etiqueta> listarEtiquetas() throws Exception;
    int eliminar(int id) throws Exception;
    List<Etiqueta> buscar(Etiqueta etiqueta) throws Exception;
}
