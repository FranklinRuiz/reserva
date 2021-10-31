package pe.upn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import pe.upn.config.SpringSecurityAuditorAware;

@SpringBootApplication
public class ReservaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservaApplication.class, args);
    }

}
