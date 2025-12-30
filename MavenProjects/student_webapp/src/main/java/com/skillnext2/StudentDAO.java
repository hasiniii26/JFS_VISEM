package com.skillnext2;

import java.sql.*;
import java.util.*;

public class StudentDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/skillnext2_db";
    private static final String USER = "root";
    private static final String PASSWORD = "#hasA12J3@Sql";

    // Insert student
    public void addStudent(Student s) throws Exception {
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

        String sql = "INSERT INTO student(name, email, marks) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, s.getName());
        ps.setString(2, s.getEmail());
        ps.setDouble(3, s.getMarks());

        ps.executeUpdate();
        con.close();
    }

    // Get all students
    public List<Student> getAllStudents() throws Exception {
        List<Student> list = new ArrayList<>();
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM student");

        while (rs.next()) {
            Student s = new Student();
            s.setId(rs.getInt("id"));
            s.setName(rs.getString("name"));
            s.setEmail(rs.getString("email"));
            s.setMarks(rs.getDouble("marks"));
            list.add(s);
        }

        con.close();
        return list;
    }

    // Update marks
    public void updateMarks(int id, double marks) throws Exception {
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement ps =
                con.prepareStatement("UPDATE student SET marks=? WHERE id=?");

        ps.setDouble(1, marks);
        ps.setInt(2, id);
        ps.executeUpdate();
        con.close();
    }

    // Delete student
    public void deleteStudent(int id) throws Exception {
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement ps =
                con.prepareStatement("DELETE FROM student WHERE id=?");

        ps.setInt(1, id);
        ps.executeUpdate();
        con.close();
    }
}
