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
                Ingreso de libros
            </div>
        </h2>
        <form class="ui large form" action="/form/ingresarlibro" method="POST">
            <div class="ui stacked segment">
                <div class="field">
                    <div class="ui input">
                        <input type="text" name="codigoClasificacion" placeholder="Codigo de clasificacion">
                    </div>
                </div>

                <div class="field">
                    <div class="ui input">
                        <input type="text" name="titulo" placeholder="Titulo">
                    </div>
                </div>

                <div class="field">
                    <div class="ui input">
                        <input type="text" name="formato" placeholder="Formato">
                    </div>
                </div>

                <div class="field">
                    <div class="ui input">
                        <input type="text" name="isbn" placeholder="ISBN">
                    </div>
                </div>

                <div class="field">
                    <div class="ui input">
                        <input type="text" name="autor" placeholder="Autor">
                    </div>
                </div>

                <div class="field">
                    <div class="ui input">
                        <input type="text" name="pieImprenta" placeholder="Pie de imprenta">
                    </div>
                </div>

                <div class="field">
                    <div class="ui input">
                        <input type="text" name="paginas" placeholder="Paginas">
                    </div>
                </div>

                <div class="field">
                    <div class="ui input">
                        <input type="text" name="descripcion" placeholder="Descripcion">
                    </div>
                </div>

                <div class="field">
                    <div class="ui input">
                        <input type="text" name="idioma" placeholder="Idioma">
                    </div>
                </div>

                <div class="field">
                    <div class="ui input">
                        <button class="ui button" type="submit">Registrar</button>
                    </div>
                </div>

                <div class="ui error message"></div>

            </div>
        </form>
    </div>
</div>
<script type="text/javascript">
    $(function() {

        //alert('form');
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
    });

</script>
</#macro>

<@display_page />