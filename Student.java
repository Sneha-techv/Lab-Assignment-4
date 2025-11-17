package model;

public class Student {
    private int rollNo;
    private String name;
    private String email;
    private String course;
    private double marks;

    public Student() {}

    public Student(int rollNo, String name, String email, String course, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.email = email;
        this.course = course;
        this.marks = marks;
    }

    public int getRollNo() { return rollNo; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getCourse() { return course; }
    public double getMarks() { return marks; }

    public void setRollNo(int rollNo) { this.rollNo = rollNo; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setCourse(String course) { this.course = course; }
    public void setMarks(double marks) { this.marks = marks; }

    @Override
    public String toString() {
        return "Roll No: " + rollNo + "\n" +
               "Name: " + name + "\n" +
               "Email: " + email + "\n" +
               "Course: " + course + "\n" +
               "Marks: " + marks;
    }

    // CSV representation: roll,name,email,course,marks
    public String toCSV() {
        return rollNo + "," + escape(name) + "," + escape(email) + "," + escape(course) + "," + marks;
    }

    private String escape(String s) {
        if (s == null) return "";
        return s.replace(",", ";");
    }

    public static Student fromCSV(String line) {
        if (line == null || line.trim().isEmpty()) return null;
        String[] parts = line.split(",", -1);
        if (parts.length < 5) return null;
        try {
            int roll = Integer.parseInt(parts[0].trim());
            String name = parts[1].trim().replace(";", ",");
            String email = parts[2].trim().replace(";", ",");
            String course = parts[3].trim().replace(";", ",");
            double marks = Double.parseDouble(parts[4].trim());
            return new Student(roll, name, email, course, marks);
        } catch (Exception e) {
            return null;
        }
    }
}
