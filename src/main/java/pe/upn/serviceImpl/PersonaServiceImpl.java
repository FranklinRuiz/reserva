package pe.upn.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upn.model.Persona;
import pe.upn.repository.IPersonaRepository;
import pe.upn.service.IPersonaService;

import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService {

    @Autowired
    private IPersonaRepository personaRepository;

    @Override
    public Persona guardar(Persona persona) {
        Persona rpta = personaRepository.save(persona);
        return rpta;
    }

    @Override
    public List<Persona> listaPersona() {
        List<Persona> personas = null;
        try {
            personas = (List<Persona>) personaRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return personas;
    }

    @Override
    public void eliminar(Long idPersona) {
        Persona p = personaRepository.findById(idPersona).orElseThrow();
        p.setEstado(false);
        personaRepository.save(p);
    }
}
