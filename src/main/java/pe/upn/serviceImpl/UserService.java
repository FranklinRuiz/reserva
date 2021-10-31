package pe.upn.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.upn.model.Authority;
import pe.upn.model.Usuario;
import pe.upn.dto.UserDto;
import pe.upn.exception.DuplicateMemberException;
import pe.upn.repository.IUsuarioRepository;
import pe.upn.utils.SecurityUtil;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private IUsuarioRepository userRepository;

    private PasswordEncoder passwordEncoder;

    @Transactional
    public Usuario signup(UserDto userDto) {
        if (userRepository.findOneWithAuthoritiesByUsuario(userDto.getUsuario()).orElse(null) != null) {
            throw new DuplicateMemberException("Ya eres un usuario registrado.");
        }

        //Ventajas del patrón constructor
        Authority authority = Authority.builder()
                .nombreRol("ROLE_USER")
                .build();

        Usuario user = Usuario.builder()
                .usuario(userDto.getUsuario())
                .password(passwordEncoder.encode(userDto.getPassword()))
                //.nickname(userDto.getNickname())
                .authorities(Collections.singleton(authority))
                .estado(true)
                .build();

        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public Optional<Usuario> getUserWithAuthorities(String username) {
        return userRepository.findOneWithAuthoritiesByUsuario(username);
    }

    @Transactional(readOnly = true)
    public Optional<Usuario> getMyUserWithAuthorities() {
        return SecurityUtil.getCurrentUsername().flatMap(userRepository::findOneWithAuthoritiesByUsuario);
    }
}
