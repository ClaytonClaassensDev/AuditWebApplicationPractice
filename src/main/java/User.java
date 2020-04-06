public class User {

    private int studentNumber;
    private String email, password;

    public User(){


    }

    public User(int studentNumber, String password, String email){

        this.studentNumber = studentNumber;
        this.password = password;
        this.email = email;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "studentNumber=" + studentNumber +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
