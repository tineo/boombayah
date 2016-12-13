<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ingresar</title>

    <link rel="stylesheet" type="text/css" href="/semantic/dist/semantic.min.css">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="/semantic/dist/semantic.min.js"></script>

    <style>

        body {
            background-color: #e6e6e6;
        }
        body > .grid {
            height: 100%;
        }
        .image {
            margin-top: -100px;
        }
        .column {
            max-width: 450px;
        }

    </style>
</head>
<body>
<div class="ui middle aligned center aligned grid">
    <div class="column">
        <h2 class="ui teal image header">
            <div class="content">
                Edicion de etiquetas de libro
            </div>
        </h2>
        <form class="ui large form" action="/form/ingresarlibro" method="POST">
            <div class="ui stacked segment">
                <div class="field">
                    <div class="ui input">
                        <input type="text" name="codigo_clasificacion" placeholder="Codigo de clasificacion">
                    </div>
                </div>

                <div class="field">


                    <div class="ui sub header">Etiquetas Disponibles</div>
                    <div class="ui fluid multiple search selection dropdown">
                        <input name="tags" type="hidden">
                        <i class="dropdown icon"></i>
                        <div class="default text">Skills</div>
                        <div class="menu">
                            <div class="item" data-value="angular">Angular</div>
                            <div class="item" data-value="css">CSS</div>
                            <div class="item" data-value="design">Graphic Design</div>
                            <div class="item" data-value="ember">Ember</div>
                            <div class="item" data-value="html">HTML</div>
                            <div class="item" data-value="ia">Information Architecture</div>
                            <div class="item" data-value="javascript">Javascript</div>
                            <div class="item" data-value="mech">Mechanical Engineering</div>
                            <div class="item" data-value="meteor">Meteor</div>
                            <div class="item" data-value="node">NodeJS</div>
                            <div class="item" data-value="plumbing">Plumbing</div>
                            <div class="item" data-value="python">Python</div>
                            <div class="item" data-value="rails">Rails</div>
                            <div class="item" data-value="react">React</div>
                            <div class="item" data-value="repair">Kitchen Repair</div>
                            <div class="item" data-value="ruby">Ruby</div>
                            <div class="item" data-value="ui">UI Design</div>
                            <div class="item" data-value="ux">User Experience</div>
                        </div>
                    </div>


                </div>

                <div class="ui error message"></div>

            </div>
        </form>




        <div class="ui small basic  modal ">
            <div class="ui icon header"><i class="archive icon"></i> Nueva etiqueta </div>
            <div class="content">
                <p>¿Desea agregar esta nueva etiqueta al listado de etiquetas?</p>
            </div>
            <div class="actions">
                <div class="ui red basic cancel inverted button"><i class="remove icon"></i> Nop </div>
                <div class="ui green ok inverted button"><i class="checkmark icon"></i> Yep </div>
            </div>
        </div>

    </div>
</div>
<script type="text/javascript">
    $(function() {

        /*$('select')
                .dropdown({
                    allowAdditions: true
                })
        ;*/

        console.log(1225412);

        function preAdd(arg) {

            /*$('.ui.basic.modal').modal({
                onApprove: function () {
                    //alert("ok");
                    return arg;
                }.bind(arg),
                onDeny: function () {
                    //return;
                }
            }).modal('show');
            */
            var r = confirm("Desea agregar la etiqueta");
            if (r == true) {
                return arg;
            } else {
                return;
            }

        }

        $('.ui.dropdown')
                .dropdown({
                    allowAdditions: true,
                    onAdd: function (addedValue, addedText,addedChoice) {
                        //console.log(addedValue);
                        //console.log(addedText);
                        //console.log(addedChoice);
                    },
                    onLabelCreate: function (value, text){
                        //console.log(value);
                        //console.log(text);
                        //console.log($(this));
                        //console.log(this);
                        return preAdd($(this));
                    },
                    onLabelRemove: function (value){
                        //console.log(value);

                        return $(this);
                    }

                })
        ;
    });

</script>





</body>
</html>