package util;

import entity.Etiqueta_libro;
import spark.Request;

/**
 * Created by Debra on 06/12/2016.
 */
public class EtiquetaLibroRequestDraw  extends Etiqueta_libro{
    private Request request;

    public EtiquetaLibroRequestDraw(Request request) {
        this.request = request;

        if(this.request.queryParams("id_etiqueta")!=null)
            super.setId_etiqueta_libro(Integer.parseInt(this.request.queryParams("id_etiqueta_libro")));

        super.setId_etiqueta(this.request.queryParams("codigo_etiqueta"));





    }
}
