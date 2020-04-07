import org.springframework.stereotype.Component;

@Component
public class Lecturer {

    public Lecturer(){


    }

    private Lecturer_ID lecturer_id;
    private Password password;
    private EmailAddresses email;

    public Lecturer(Lecturer_ID lecturer_id, Password password, EmailAddresses email){

        this.lecturer_id = lecturer_id;
        this.password = password;
        this.email = email;
    }

    public Lecturer_ID getLecturer_id() {
        return lecturer_id;
    }

    public void setLecturer_id(Lecturer_ID lecturer_id) {
        this.lecturer_id = lecturer_id;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public EmailAddresses getEmail() {
        return email;
    }

    public void setEmail(EmailAddresses email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "lecturer_id=" + lecturer_id +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
