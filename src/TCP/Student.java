package TCP;

import java.io.Serial;
import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 20151107;
    private int id;
    private String code;
    private float gpa;
    private String gpaLetter;

    public Student(int id, String code, float gpa, String gpaLetter) {
        this.id = id;
        this.code = code;
        this.gpa = gpa;
        this.gpaLetter = gpaLetter;
    }

    public void setGpaLetter() {
        if (this.gpa >= 3.7) {
            gpaLetter = "A";
        } else if (this.gpa >= 3.0) {
            gpaLetter = "B";
        } else if (this.gpa >= 2.0) {
            gpaLetter = "C";
        } else if (this.gpa >= 1.0) {
            gpaLetter = "D";
        } else {
            gpaLetter = "F";
        }
    }
}
