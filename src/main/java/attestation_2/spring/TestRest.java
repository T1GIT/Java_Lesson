package attestation_2.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TestRest {

    public static void main(String[] args) {
        SpringApplication.run(TestRest.class, args);
    }

}
