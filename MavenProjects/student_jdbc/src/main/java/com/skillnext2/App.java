package com.skillnext2;

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {

        StudentDAO dao = new StudentDAO();

        // Insert student
        Student s = new Student();
        s.setName("Anu");
        s.setEmail("anu@gmail.com");
        s.setMarks(85.5);

        dao.addStudent(s);
        System.out.println("Student inserted");

        // Display students
        List<Student> students = dao.getAllStudents();
        for (Student st : students) {
            System.out.println(
                st.getId() + " " +
                st.getName() + " " +
                st.getEmail() + " " +
                st.getMarks()
            );
        }
    }
}
