<!DOCTYPE html>
<html>
<head>
    <title class="titulo">Biblioteca FISI</title>

    <link rel="shortcut icon" type="image/x-icon" href="logo.png" class="imagenLogo" >
    <link rel="stylesheet" href="css/style3.css">
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
            <input type="text" placeholder="  Ingrese el nombre del libro a buscar..." id="buscador" name="termino"  size="100" />
            <input type="submit"  id="Search" name=botonBuscar VALUE="Buscar" /><br><br>
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
    <tr>
        <th>#</th>
        <th>Codigo</th>
        <th>Autor</th>
        <th>Titulo</th>
        <th>A&ntildeo</th>
        <th>Formato</th>
    </tr>
    <tr>
        <td>1</td>
        <td>001</td>
        <td>Berg, Alan Mark,</td>
        <td>Jenkins continuous integration cookbook : over 90 recipes to produce great results from Jenkins using pro-level practices, techniques, and solutions</td>
        <td>2015</td>
        <td>PDF</td>
    </tr>
    <tr>
        <td>2</td>
        <td>002</td>
        <td>Schildt, Herbert</td>
        <td>Java 8</td>
        <td>2016</td>
        <td>Libro</td>
    </tr>
</table>
<div id="botones">
    <button id="prev" name="btn_prev">Anterior</button>
    <button id="next" name="btn_next">Siguiente</button>
</div>

</div>
<hr>
<script type="text/javascript">

    </script>
</body>
</html>