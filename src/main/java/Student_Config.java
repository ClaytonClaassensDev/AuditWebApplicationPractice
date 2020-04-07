import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import sun.security.util.Password;

@Configuration
@ComponentScan(basePackageClasses = Student.class)
public class Student_Config {

    private Student_ID student_id;
    private Password password;
    private EmailAddresses email;

    @Bean
    public Student_ID getStudent_id(){
        return student_id;
    }

    @Bean
    public Password getPassword() {
        return password;
    }

    @Bean
    public EmailAddresses getEmail(){
        return email;
    }
}
