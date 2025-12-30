package com.skillnext2;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class StudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            StudentDAO dao = new StudentDAO();
            List<Student> students = dao.getAllStudents();
            req.setAttribute("students", students);

            RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
            rd.forward(req, res);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            String action = req.getParameter("action");
            StudentDAO dao = new StudentDAO();

            if ("add".equals(action)) {
                Student s = new Student(
                        req.getParameter("name"),
                        req.getParameter("email"),
                        Double.parseDouble(req.getParameter("marks"))
                );
                dao.addStudent(s);
            }

            // IMPORTANT: redirect back to servlet (GET)
            res.sendRedirect("student");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
