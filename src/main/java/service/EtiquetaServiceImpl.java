package service;

import dao.EtiquetaDAO;
import dao.FactoryDAO;
import entity.Etiqueta;

import java.util.List;

/**
 * Created by Debra on 06/12/2016.
 */
public class EtiquetaServiceImpl implements EtiquetaService {
    FactoryDAO factory = FactoryDAO.getFactory(FactoryDAO.MYSQL_FACTORY);
    EtiquetaDAO etiquetaDAO = factory.getEtiquetaDao();




    @Override
    public int insertarEtiqueta(Etiqueta etiqueta) throws Exception {
        return etiquetaDAO.insertarEtiqueta(etiqueta);
    }

    @Override
    public List<Etiqueta> listarEtiquetas() throws Exception {
        return ((List<Etiqueta>) etiquetaDAO.listarEtiquetas());
    }
}
