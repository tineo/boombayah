/**
 * Created by Alejandro on 24/11/2016.
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import service.ExistenciasServiceImpl;
import service.LibroServiceImpl;
import service.UsuarioServiceImpl;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;
import util.ExistenciasRequestDraw;
import util.LibroRequestDraw;
import util.UsuarioRequestDraw;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

//import entity.*;
//import service.*;
//import util.PacienteRequestDraw;
//import util.PsicologoRequestDraw;
//import util.SesionRequestDraw;


public class Main {

    public static void main(String[] args) throws Exception{

        port((System.getenv("PORT") != null)?Integer.valueOf(System.getenv("PORT")):8008);
        staticFileLocation("/public");


        get("/ingresar/libro", (req, res) -> {
            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes, "ingresarlibro.ftl");
        }, new FreeMarkerEngine());

        post("/form/ingresarlibro", (req, res) -> {
            //Libro libro =  new LibroRequestDraw(req);

            LibroServiceImpl service = new LibroServiceImpl();
            service.insertarLibro(new LibroRequestDraw(req));

            res.redirect("/ingresar/libro?msg=ok");
            return "OK";
        });

        get("/ingresar/etiqueta", (req, res) -> {
            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes, "ingresaretiquetas.ftl");
        }, new FreeMarkerEngine());

        /*Existencias*/
        get("/ingresar/existencias", (req, res) -> {
            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes, "ingresarexistencias.ftl");
        }, new FreeMarkerEngine());

        get("/bus", (req, res) -> {
            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes, "buscando.ftl");
        }, new FreeMarkerEngine());

        post("/form/ingresarexistencias", (req, res) -> {
            //Libro libro =  new LibroRequestDraw(req);

            ExistenciasServiceImpl service = new ExistenciasServiceImpl();
            service.insertarExistencias(new ExistenciasRequestDraw(req));

            res.redirect("/ingresar/existencias?msg=ok");
            return "OK";
        });
        /*Usuario*/
        get("/ingresar/usuario", (req, res) -> {
            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes, "ingresarusuario.ftl");
        }, new FreeMarkerEngine());

        post("/form/ingresarusuario", (req, res) -> {
            //Libro libro =  new LibroRequestDraw(req);

            UsuarioServiceImpl service = new UsuarioServiceImpl();
            service.insertarUsuario(new UsuarioRequestDraw(req));

            res.redirect("/ingresar/usuario?msg=ok");
            return "OK";
        });

        before("/", (request, response) -> {
            if (request.session().attribute("user") == null) {
                response.redirect("/login");
            }
        });

        before("/registrar/*", (request, response) -> {
            if (request.session().attribute("user") == null) {
                response.redirect("/login");
            }
        });

        /*before("/", (request, response) -> {
            if (request.session().attribute("user") == null) {
                response.redirect("/login");
            }
        });

        before("/ingresar/*", (request, response) -> {
            if (request.session().attribute("user") == null) {
                response.redirect("/login");
            }
        });

        before("/registrar/*", (request, response) -> {
            if (request.session().attribute("user") == null) {
                response.redirect("/login");
            }
        });*/

        get("/hello", (req, res) -> {
            String world = "world";
            if(req.session().attribute("user") != null){
                world = req.session().attribute("user");
            }
            return "Hello " + world +"!";
        });

        get("/logout", (req, res) -> {
            req.session().removeAttribute("user");
            res.redirect("/login");
            return "Goodbye!";
        });

        get("/", (req, res) -> {
            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());

        get("/login", (req, res) -> {
            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes, "login.ftl");
        }, new FreeMarkerEngine());

        get("/master", (req, res) -> {
            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes, "master.ftl");
        }, new FreeMarkerEngine());

         /*Validar*/
        post("/validar",(req, res) -> {

            Map<String, Object> attributes = new HashMap<>();

            String username = req.queryParams("username");
            String password = req.queryParams("password");

            UsuarioServiceImpl service = new UsuarioServiceImpl();
            try {
                if(service.validarUsuario(username, password)){
                    //Creacion de la sesion
                    req.session().attribute("user", username);

                    res.redirect("/");
                }else{
                    res.redirect("/login");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            //return new ModelAndView(attributes, "login.ftl");
            return "OK";
        });




        //PRUEBADAO

        /*
        Etiqueta_libroMySQLFactoryDAO el =new Etiqueta_libroMySQLFactoryDAO();
        Etiqueta_libro e = new Etiqueta_libro();
        e.setId_etiqueta("125877");
        e.setCodigoLibro("122345");
        List<Etiqueta_libro> al = new ArrayList<Etiqueta_libro>();
        al = el.buscar(e);
        */


        //System.out.println(al.get(0).getId_etiqueta_libro());
/*
        post("/form/ingresar_paciente", (req, res) -> {

            String nombres = req.queryParams("nombres");
            String apellido_paterno = req.queryParams("apellido_paterno");
            String apellido_materno = req.queryParams("apellido_materno");
            String fecha_nacimiento = req.queryParams("fecha_nacimiento");
            String direccion = req.queryParams("direccion");
            String email = req.queryParams("email");

            String tipo = req.queryParams("tipo");

            DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
            java.util.Date date = formatter.parse(fecha_nacimiento);


            Usuario usuario = new Usuario();

            usuario.setNombres(nombres);
            usuario.setApellido_paterno(apellido_paterno);
            usuario.setApellido_materno(apellido_materno);
            usuario.setFecha_nacimiento(date);
            usuario.setDireccion(direccion);
            usuario.setEmail(email);

            usuario.setUsername(null);
            usuario.setPassword(null);

            UsuarioServiceImpl service = new UsuarioServiceImpl();
            int codigo_usuario = service.insertarUsuario(usuario);

            Paciente paciente = new Paciente();
            paciente.setTipo(tipo);
            paciente.setCodigo_usuario(codigo_usuario);

            PacienteServiceImpl servicePaciente = new PacienteServiceImpl();
            servicePaciente.insertarPaciente(paciente);

            res.redirect("/ingresar/paciente?msg=ok");
            return "OK";
        });

        post("/form/ingresar_psicologo", (req, res) -> {

            String nombres = req.queryParams("nombres");
            String apellido_paterno = req.queryParams("apellido_paterno");
            String apellido_materno = req.queryParams("apellido_materno");
            String fecha_nacimiento = req.queryParams("fecha_nacimiento");
            String direccion = req.queryParams("direccion");
            String email = req.queryParams("email");

            String username = req.queryParams("username");
            String password = req.queryParams("password");

            String especialidad = req.queryParams("especialidad");

            DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
            java.util.Date date = formatter.parse(fecha_nacimiento);

            Usuario usuario = new Usuario();

            usuario.setNombres(nombres);
            usuario.setApellido_paterno(apellido_paterno);
            usuario.setApellido_materno(apellido_materno);
            usuario.setFecha_nacimiento(date);
            usuario.setDireccion(direccion);
            usuario.setEmail(email);

            usuario.setUsername(username);
            usuario.setPassword(password);

            UsuarioServiceImpl service = new UsuarioServiceImpl();
            int codigo_usuario = service.insertarUsuario(usuario);

            Psicologo psicologo = new Psicologo();
            psicologo.setEspecialidad(especialidad);
            psicologo.setCodigo_usuario(codigo_usuario);

            PsicologoServiceImpl psicologoService = new PsicologoServiceImpl();
            int psi = psicologoService.insertarPsicologo(psicologo);
            System.out.println(psi);

            res.redirect("/ingresar/psicologo?msg=ok");
            return "OK";
        });

        post("/form/registrar_sesion", (req, res) -> {

            Sesion sesion = new Sesion();
            sesion.setCodigo_psicologo(Integer.parseInt(req.queryParams("codigo_psicologo")));
            sesion.setCodigo_paciente(Integer.parseInt(req.queryParams("codigo_paciente")));
            sesion.setLugar(req.queryParams("lugar"));
            DateFormat formatter = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
            System.out.println(req.queryParams("fecha_reunion")+" "+req.queryParams("hora")+":00:00");
            sesion.setFecha_reunion(formatter.parse(req.queryParams("fecha_reunion")+" "+req.queryParams("hora")+":00:00"));
            System.out.println(sesion.getFecha_reunion());
            sesion.setEstado("1");
            sesion.setDuracion(Integer.parseInt(req.queryParams("duracion")));
            sesion.setFecha_creacion(new Date());

            SesionServiceImpl service = new SesionServiceImpl();

            service.insertar(sesion);

            res.redirect("/registrar/sesion?msg=ok");
            return "OK";
        });

        post("/validar",(req, res) -> {

            Map<String, Object> attributes = new HashMap<>();

            String username = req.queryParams("username");
            String password = req.queryParams("password");

            UsuarioServiceImpl service = new UsuarioServiceImpl();
            try {
                if(service.validarUsuario(username, password)){
                    //Creacion de la sesion
                    req.session().attribute("user", username);

                    //res.redirect("/");
                }else{
                    //res.redirect("/login");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            //return new ModelAndView(attributes, "login.ftl");
            return "OK";
        });

        get("/test", (req, res) -> {

            Map<String, Object> attributes = new HashMap<>();

            attributes.put("dateutil", new DateUtil());

            return new ModelAndView(attributes, "listado_sesion.ftl");
        }, new FreeMarkerEngine());

        get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello Tineo!");

            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());
*/
        Gson gson = new GsonBuilder()
                .setDateFormat("MM/dd/yyyy HH:mm:ss").create();
        //.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").create();
        //new Gson ();
        get("/json/:key","application/json",(request,response)->{
            String key = request.params(":key");
            LibroServiceImpl service = new LibroServiceImpl();

            return service.buscarLibro(key);

            //PacienteServiceImpl pa= new PacienteServiceImpl();
            //return pa.listarPaciente();

        },gson::toJson);
/*
        get("/json/psicologo/:accion","application/json",(request,response)->{

            String accion = request.params(":accion");

                Psicologo psicologo =  new PsicologoRequestDraw(request);
            int codigo = psicologo.getCodigo_psicologo();

            PsicologoServiceImpl pa= new PsicologoServiceImpl();

            Object respuesta;

            switch (accion){
                case "agregar": respuesta = pa.insertarPsicologo(psicologo); break;
                case "buscar": respuesta = pa.buscarPsicologos(psicologo); break;
                case "listar": respuesta = pa.listarPsicologos(); break;
                case "eliminar": respuesta = pa.eliminarPsicologo(codigo);break;
                default:  respuesta =  "Ninguna coincidencia"; break;
            }

            return respuesta;

        },gson::toJson);

        get("/json/paciente/:accion","application/json",(request,response)->{

            String accion = request.params(":accion");

            Paciente paciente=  new PacienteRequestDraw(request);
            int codigo = paciente.getCodigo_paciente();

            PacienteServiceImpl pa= new PacienteServiceImpl();

            Object respuesta;

            switch (accion){
                case "agregar": respuesta = pa.insertarPaciente(paciente); break;
                case "buscar": respuesta = pa.buscarPacientes(paciente); break;
                case "listar": respuesta = pa.listarPaciente(); break;
                case "eliminar": respuesta = pa.eliminarPaciente(codigo);break;
                default:  respuesta =  "Ninguna coincidencia"; break;
            }

            return respuesta;

        },gson::toJson);


        get("/json/sesion/:accion","application/json",(request,response)->{

            String accion = request.params(":accion");

            Sesion sesion =  new SesionRequestDraw(request);
            int codigo = sesion.getCodigo_sesion();


            SesionServiceImpl service = new SesionServiceImpl();

            Object respuesta = "";

            switch (accion){
                case "agregar": respuesta = service.insertar(sesion); break;
                case "buscar": respuesta = service.buscar(sesion); break;
                case "listar": respuesta = service.listar(); break;
                case "eliminar": respuesta = service.eliminar(codigo);break;
                default:  respuesta =  "Ninguna coincidencia"; break;
            }

            return respuesta;

        },gson::toJson);


        get("/json/observacion/:accion","application/json",(request,response)->{

            String accion = request.params(":accion");

            Observacion observacion =  new Observacion();
            // Observacion observacion =  new ObservacionRequestDraw(request);
            int codigo = observacion.getCodigo_observacion();


            ObservacionServiceImpl service = new ObservacionServiceImpl();

            Object respuesta = "";

            switch (accion){
                case "agregar": respuesta = service.insertar(observacion); break;
                case "buscar": respuesta = service.buscar(observacion); break;
                case "listar": respuesta = service.listar(); break;
                case "eliminar": respuesta = service.eliminar(codigo);break;
                default:  respuesta =  "Ninguna coincidencia"; break;
            }

            return respuesta;

        },gson::toJson);

*/


    }


}
