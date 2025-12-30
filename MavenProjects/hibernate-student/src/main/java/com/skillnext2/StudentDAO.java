package com.skillnext2;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDAO {

    public void insertStudent(String name, int sem, String department) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Student student = new Student(name, sem, department);
        session.save(student);

        tx.commit();
        session.close();

        System.out.println("Inserted Student ID: " + student.getId());
    }

    public void updateStudent(int id, int newSem) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Student student = session.get(Student.class, id);

        if (student != null) {
            student.setSem(newSem);
            tx.commit();
            System.out.println("Updated Student ID: " + id);
        } else {
            tx.rollback();
            System.out.println("Student not found");
        }

        session.close();
    }

    public void deleteStudent(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Student student = session.get(Student.class, id);

        if (student != null) {
            session.delete(student);
            tx.commit();
            System.out.println("Deleted Student ID: " + id);
        } else {
            tx.rollback();
            System.out.println("Student not found");
        }

        session.close();
    }
}
