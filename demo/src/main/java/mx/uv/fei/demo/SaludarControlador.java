package mx.uv.fei.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class SaludarControlador {

    String nombre;
    private Saludador saludador;

    @GetMapping("/saludar")
    public String saludo() {
        return "Hola Mundo " + nombre;
    }

    @GetMapping("/despedidas")
    public String adios() {
        return "Adios mundo!";
    }

    @PostMapping("/nombramientos")
    public void nombre() {
        nombre = "Rafael";
    }

    @PutMapping("/nombramientos")
    public void met1() {
        nombre = "otro nombre";
    }

    @DeleteMapping("/deleteNombre")
    public void borrarNombre() {
        nombre = null;
    }

    @GetMapping("/saludar/{nombre}")
    public Saludador met3(@PathVariable String nombre){
        System.out.println(nombre);
        return new Saludador(nombre);
    }

    @GetMapping("/saludar2/{nombreX}")
    public Saludador met4(@PathVariable("nombreX") String nombre){
        System.out.println(nombre);
        return new Saludador(nombre);
    }

    @PostMapping ("/crearSaludador")
    public String crearSaludador (@RequestBody Saludador nuevoSaludador){
        saludador = nuevoSaludador;
        return "Saludador creado: " + saludador.getNombre();
    }

    @GetMapping("/obtenerSaludador")
    public Saludador obtenerSaludador(){
        return saludador;
    }

    @GetMapping("/query1")
    public String query1(@RequestParam(defaultValue = "default") String nombre) {
        return "default";
    }

    @RequestMapping("/")
    public String raiz(){
        String contenido = null;
        contenido = """
                
                <h1> Menu de Opciones </h1>
                <ul>
                    <li> <a href='/saludar'>/saludar</a></li>
                    <li> <a href='/despedidas'>/despedidas</a></li>
                    <li> /nombramientos (P|P|D) </li>
                    <li> <a href='/saludar'>/despedidas></a></li>
                    <li> <a href='/query1'>/query1</a></li>

                </ul>
                    """;
        return contenido;
    }
}