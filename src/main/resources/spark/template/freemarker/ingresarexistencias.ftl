<#include "master.ftl">

<#macro head>
<link rel="stylesheet" type="text/css" href="/semantic/dist/semantic.min.css">

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="/semantic/dist/semantic.min.js"></script>



</#macro>
<#macro content>
<div class="ui middle aligned center aligned grid">
    <div class="column">
        <h2 class="ui teal image header">
            <div class="content">
                Ingreso de existencias
            </div>
        </h2>
        <form class="ui large form" action="/form/ingresarexistencias" method="POST">
            <div class="ui stacked segment">



                <div class="field">
                    <div class="ui input">
                        <input type="text" name="id_libro" placeholder="Codigo de libro">
                    </div>
                </div>

                <div class="field">
                    <div class="ui input">
                        <input type="text" name="ubicacion" placeholder="Ubicacion">
                    </div>
                </div>

                <div class="field">
                    <div class="ui input">
                        <input type="text" name="estado" placeholder="Estado">
                    </div>
                </div>


                <div class="field">
                    <div class="ui input">
                        <input type="text" name="tipo_prestamo" placeholder="Tipo de Prestamo">
                    </div>
                </div>



                <div class="field">
                    <div class="ui input">
                        <button class="ui button" type="submit">Aceptar</button>
                    </div>
                </div>

                <div class="ui error message"></div>

            </div>
        </form>
    </div>
</div>

<script type="text/javascript">
   /* $(function() {

        alert('form');
        $('form')
                .form({
                    fields: {
                        codigoClasificacion: {
                            identifier: 'codigoClasificacion',
                            rules: [
                                {
                                    type: 'empty',
                                    prompt: 'Igresa un Cod. Bibliografico'
                                }
                            ]
                        },
                        titulo: {
                            identifier: 'titulo',
                            rules: [
                                {
                                    type: 'empty',
                                    prompt: 'Ingresa un titulo'
                                }
                            ]
                        }
                    }
                })
        ;
    });*/

</script>
</#macro>

<@display_page />