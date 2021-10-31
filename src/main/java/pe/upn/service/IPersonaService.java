package pe.upn.service;

import pe.upn.model.Persona;

import java.util.List;

public interface IPersonaService {
    Persona guardar(Persona persona);

    List<Persona> listaPersona();

    void eliminar(Long idPersona);
}
