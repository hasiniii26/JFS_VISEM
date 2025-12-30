<%@ page import="java.util.*,com.skillnext2.Student" %>
<html>
<body>

<h2>Add Student</h2>

<form action="student" method="post">
    <input type="hidden" name="action" value="add">

    Name: <input type="text" name="name"><br>
    Email: <input type="email" name="email"><br>
    Marks: <input type="text" name="marks"><br>
    <input type="submit" value="Add Student">
</form>

<hr>

<h2>Student List</h2>

<table border="1">
<tr>
    <th>ID</th><th>Name</th><th>Email</th><th>Marks</th>
</tr>

<%
    List<Student> students = (List<Student>) request.getAttribute("students");
    if (students != null) {
        for (Student s : students) {
%>
<tr>
    <td><%= s.getId() %></td>
    <td><%= s.getName() %></td>
    <td><%= s.getEmail() %></td>
    <td><%= s.getMarks() %></td>
</tr>
<%
        }
    }
%>

</table>

</body>
</html>
