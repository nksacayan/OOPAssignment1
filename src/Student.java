import java.util.HashSet;

public class Student {
    private static HashSet<String> studentIDSet;

    static {
        studentIDSet = new HashSet<String>();
    }

    private String studentID;

    public Student(String studentID) {
        if(studentIDSet.contains(studentID)) {
            System.out.println("Tried to make student " + studentID + " but that id is taken.");
            return;
        }
        this.studentID = studentID;
        studentIDSet.add(studentID);
        System.out.println("Welcome " + studentID);
    }

    public String getStudentID() {
        return studentID;
    }
}
