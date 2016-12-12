<!DOCTYPE html>
<html>
<head>
    <title class="titulo">Biblioteca FISI</title>
    <link rel="stylesheet" type="text/css" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script type="text/javascript" src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link rel="shortcut icon" type="image/x-icon" href="/logo.png" class="imagenLogo" >
    <link rel="stylesheet" href="/css/style3.css">
</head>
<body>
<div class="topbar">
    <div>
        <img id="logo" src="logo.png" alt="logoBibliotecaFisi" height="90" width="90" >
    </div>
    <div>
        <h1 class="titulo"  > FISI - Biblioteca  </h1>
    </div>

</div>
<div id="cajaBusq">
    <FORM id="searchbox" >
        <div><strong>Busquedad Basica</strong></div>
        <div id="buscador">
            <input type="text" placeholder="  Ingrese el nombre del libro a buscar..." id="keyword" name="termino"  size="100" />
            <button type="button"  id="Search" name=botonBuscar VALUE="Buscar">
                buscar
            </button>
            <br><br>
            <span> Campo de busquedad:</span>
            <select id="select" name="campo">
                <option value="todos">Todos los campos</option>
                <option value="titulo">Titulo</option>
                <option value="autor">Autor</option>
                <option value="tema">Tema</option>
                <option value="pais">Pais</option>
                <option value="editorial">Editorial</option>
            </select>
            <hr>
            <hr>
            <span>Limitar Busquedad:</span><br><br>
            <span>Tipo de documento:</span>
            <select name="tipo_documento">
                <option value="todos">Todos los tipos</option>
                <option value="libro">Libro</option>
                <option value="revista">Revista</option>
                <option value="tesis">Tesis</option>
            </select>
            <span>Idioma:</span>
            <select name="idioma">
                <option value="todos">Todos los idiomas</option>
                <option value="ingles">Ingles</option>
                <option value="español">Espa&ntildeol</option>
                <option value="frances">Frances</option>
                <option value="aleman">Aleman</option>
            </select>
            <br><br><hr>

        </div>
</div>
</FORM>
<br>
<div id="botones">
    <button id="prev" name="btn_prev">Anterior</button>
    <button id="next" name="btn_next">Siguiente</button>
</div>
<table id="tabla">
    <thead>
        <tr>
            <th>#</th>
            <th>Codigo</th>
            <th>Autor</th>
            <th>Titulo</th>
            <th>ISBN</th>
            <th>Formato</th>
        </tr>
    </thead>
    <tbody>

    </tbody>
</table>
<div id="botones">
    <button id="prev" name="btn_prev">Anterior</button>
    <button id="next" name="btn_next">Siguiente</button>
</div>

</div>
<hr>
<script type="text/javascript">
    $(function() {
        $( "#Search").click(function(){
            var bus = $("#keyword").val();
            $.getJSON( "/json/"+bus ,function( data ) {
                $("#tabla tbody > tr").remove();
                $.each(data, function(i, item) {
                    var $tr = $('<tr>').append(
                            $('<td>').text(i),
                            $('<td>').text(item.codigoClasificacion),
                            $('<td>').text(item.autor),
                            $('<td>').text(item.Titulo),
                            $('<td>').text(item.isbn),
                            $('<td>').text(item.formato)
                    ).appendTo('#tabla');
                });

            });
        });
    });
    </script>
</body>
</html>