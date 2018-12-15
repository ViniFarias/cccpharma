package com.cccpharma;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * The main class of application, responsible for starting execution.
 * The {@code EnableScheduling} annotation allows the application to perform scheduled tasks.
 *
 * @author Marcus Vinicius
 */
@SpringBootApplication
@EnableScheduling
public class CccpharmaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CccpharmaApplication.class, args);
    }

    @Bean
    ObjectMapper myObjectMapper() {
        Hibernate5Module m = new Hibernate5Module();
        m.disable(Hibernate5Module.Feature.USE_TRANSIENT_ANNOTATION);
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(m);
        return mapper;
    }
}
