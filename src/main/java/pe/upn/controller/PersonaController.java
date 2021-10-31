package pe.upn.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upn.model.Persona;
import pe.upn.service.IPersonaService;

import java.util.List;

@RestController
@RequestMapping("/api/persona")
public class PersonaController {

    @Autowired
    private IPersonaService personaService;

    @PostMapping("/guardar")
    @ApiOperation("Post guardar - guardar una persona nueva")
    public Persona guardar(@RequestBody Persona persona) {
        return personaService.guardar(persona);
    }

    @GetMapping("/lista")
    @ApiOperation("Get lista - lista de todas las personas")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Persona>> listar() {
        List<Persona> lista = null;
        try {
            lista = personaService.listaPersona();
        } catch (Exception e) {
            return new ResponseEntity<List<Persona>>(lista, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<Persona>>(lista, HttpStatus.OK);
    }

    @PostMapping("/eliminar")
    @ApiOperation("Post eliminar - eliminar persona por id")
    public void eliminar(@RequestParam Long idPersona) {
        personaService.eliminar(idPersona);
    }

}
