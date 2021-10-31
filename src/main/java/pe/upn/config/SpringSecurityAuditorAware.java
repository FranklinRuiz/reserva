package pe.upn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import pe.upn.utils.SecurityUtil;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class SpringSecurityAuditorAware {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return ()->Optional.ofNullable(SecurityUtil.getCurrentUsername().get()).filter(s -> !s.isEmpty());
    }


}
