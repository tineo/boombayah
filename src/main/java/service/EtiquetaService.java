package service;

import entity.Etiqueta;


import java.util.List;

/**
 * Created by Debra on 06/12/2016.
 */
public interface EtiquetaService {
    public abstract int insertarEtiqueta(Etiqueta etiqueta) throws Exception;

    public abstract List<Etiqueta> listarEtiquetas() throws Exception;
}

