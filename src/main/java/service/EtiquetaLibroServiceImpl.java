package service;

import dao.Etiqueta_libroDAO;
import dao.FactoryDAO;
import entity.Etiqueta_libro;

import java.util.List;

/**
 * Created by Debra on 06/12/2016.
 */
public class EtiquetaLibroServiceImpl implements EtiquetaLibroService {
    FactoryDAO factory = FactoryDAO.getFactory(FactoryDAO.MYSQL_FACTORY);
    Etiqueta_libroDAO etiqueta_libroDAO = factory.getEtiquetaLibroDAO();
    @Override
    public int insertarEtiqueta_libro(Etiqueta_libro etiqueta) throws Exception {
        return  etiqueta_libroDAO.insertarEtiqueta_libro(etiqueta);
    }

    @Override
    public List<Etiqueta_libro> listarEtiquetasLibro() throws Exception {
        return ((List<Etiqueta_libro>) etiqueta_libroDAO.listarEtiquetasLibro());
    }
}
