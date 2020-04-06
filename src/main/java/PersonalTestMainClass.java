public class PersonalTestMainClass {

    public static void main(String[] args) {

        DatabaseCRUD database = new DatabaseCRUD();

        User user = new User(216531479, "abchexcfggv@gmail.com", "129465retezrxdhf6523687");

        database.addUserToStudentRecordsTable(user);

        //database.searchUserInStudentRecordsTable(219299369);

        //database.deleteUserFromStudentRecordsTable(219299369);

        //database.displayAllStudents();

    }
}
