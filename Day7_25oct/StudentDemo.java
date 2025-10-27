import java.io.*;
import java.util.*;

// Custom checked exception for low attendance
class LowAttendanceException extends Exception {
    public LowAttendanceException(String message) {
        super(message);
    }
}

class Student implements Serializable {
    int rollno;
    String sname;
    String course;
    double attendance_percentage;
    int score;

    // Default constructor
    public Student() {}

    // Parameterized constructor
    public Student(int rollno, String sname, String course, double attendance_percentage, int score) {
        this.rollno = rollno;
        this.sname = sname;
        this.course = course;
        this.attendance_percentage = attendance_percentage;
        this.score = score;
    }

    // Method to calculate grade
    public String calculateGrade() throws LowAttendanceException {
        if (attendance_percentage < 60) {
            throw new LowAttendanceException(sname + " has attendance below 60%!");
        }
        if (score >= 90) return "A";
        if (score >= 75) return "B";
        if (score >= 60) return "C";
        return "D";
    }

    @Override
    public String toString() {
        return "[" + rollno + ", " + sname + ", " + course + ", " + attendance_percentage + "%, " + score + "]";
    }
}

// Comparator for decreasing order of attendance
class AttendanceComparator implements Comparator<Student> {
    public int compare(Student a, Student b) {
        return Double.compare(b.attendance_percentage, a.attendance_percentage);
    }
}

public class StudentDemo {
    public static void main(String[] args) throws Exception {
        List<Student> students = new ArrayList<>();
        // Create 10 students
        for (int i = 1; i <= 10; i++) {
            students.add(
                new Student(i, "Student" + i, "Course" + (i%3+1), 50 + i*5, 55 + i*4)
            );
        }

        // Serialize students to file
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("students.dat"));
        for (Student s : students) out.writeObject(s);
        out.close();

        // Deserialize students from file and store in PriorityQueue
        PriorityQueue<Student> pq = new PriorityQueue<>(new AttendanceComparator());
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("students.dat"));
        try {
            while (true) {
                Student s = (Student) in.readObject();
                pq.add(s);
            }
        } catch (EOFException e) { /* Finished reading */ }
        in.close();

        // Print students in decreasing order of attendance
        System.out.println("Students in decreasing order of attendance:");
        while (!pq.isEmpty()) {
            Student s = pq.poll();
            try {
                System.out.println(s + " Grade: " + s.calculateGrade());
            } catch (LowAttendanceException ex) {
                System.out.println(s + " " + ex.getMessage());
            }
        }
    }
}
