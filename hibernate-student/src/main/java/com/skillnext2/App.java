package com.skillnext2;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.skillnext2.Student;
import com.skillnext2.HibernateUtil;

public class App {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Student stu = new Student(
                "Hasini",
                "hasini@gmail.com",
                95
        );

        session.persist(stu);

        tx.commit();
        session.close();

        System.out.println("Student inserted successfully!");
    }
}

