import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class Student {

    private Student_ID studentNumber;
    private EmailAddresses email;
    private Password password;

    public Student(){


    }


    public Student(Student_ID studentNumber, Password password, EmailAddresses email){

        this.studentNumber = studentNumber;
        this.password = password;
        this.email = email;

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

    public Student_ID getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Student_ID studentNumber) {
        this.studentNumber = studentNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentNumber=" + studentNumber +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}
