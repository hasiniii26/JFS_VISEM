package com.skillnext2;

import java.sql.*;
import java.util.*;

public class StudentDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/skillnext2_db";
    private static final String USER = "root";
    private static final String PASSWORD = "#hasA12J3@Sql"; // your MySQL password

    // Add student
    public void addStudent(Student s) throws Exception {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String sql = "INSERT INTO student (name, email, marks) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, s.getName());
        ps.setString(2, s.getEmail());
        ps.setDouble(3, s.getMarks());
        ps.executeUpdate();
        conn.close();
    }

    // View all students
    public List<Student> getAllStudents() throws Exception {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM student");

        List<Student> list = new ArrayList<>();
        while (rs.next()) {
            Student s = new Student();
            s.setId(rs.getInt("id"));
            s.setName(rs.getString("name"));
            s.setEmail(rs.getString("email"));
            s.setMarks(rs.getDouble("marks"));
            list.add(s);
        }
        conn.close();
        return list;
    }

    // Delete student
    public void deleteStudent(int id) throws Exception {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement ps =
                conn.prepareStatement("DELETE FROM student WHERE id=?");
        ps.setInt(1, id);
        ps.executeUpdate();
        conn.close();
    }
}
