import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Lecturer.class)
public class Lecturer_Config {

    private Lecturer_ID lecturer_id;
    private Password password;
    private EmailAddresses email;

    @Bean
    public Lecturer_ID getLecturer_id(){
        return lecturer_id;
    }

    @Bean
    public Password getPassword(){
        return password;
    }

    public EmailAddresses getEmail(){
        return email;
    }

}
