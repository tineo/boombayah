package util;

import entity.Etiqueta;
import spark.Request;

/**
 * Created by Debra on 06/12/2016.
 */
public class EtiquetasRequestDraw extends Etiqueta{
    private Request request;

    public EtiquetasRequestDraw(Request request) {
        this.request = request;

        if(this.request.queryParams("id_etiqueta")!=null)
            super.setId_etiqueta(Integer.parseInt(this.request.queryParams("id_etiqueta")));



        super.setNombre(this.request.queryParams("nombre"));



    }
}
