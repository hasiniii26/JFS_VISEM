package com.skillnext2;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1.Insert 2.Update 3.Delete 4.Exit");
            choice = sc.nextInt();

            if (choice == 1) {
                insert(sc);
            } else if (choice == 2) {
                update(sc);
            } else if (choice == 3) {
                delete(sc);
            }

        } while (choice != 4);

        HibernateUtil.getSessionFactory().close();
        sc.close();
    }

    static void insert(Scanner sc) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();


        System.out.print("Sem: ");
        int sem = sc.nextInt();

	System.out.print("Name: ");
        String name = sc.next();

        System.out.print("Department: ");
        String dept = sc.next();

        Student st = new Student(name, sem, dept);
        s.save(st);

        tx.commit();
        s.close();

        System.out.println("Inserted ID: " + st.getId());
    }

    static void update(Scanner sc) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();

        System.out.print("Student ID: ");
        int id = sc.nextInt();

        Student st = s.get(Student.class, id);

        if (st != null) {
            System.out.print("New Sem: ");
            st.setSem(sc.nextInt());
            tx.commit();
            System.out.println("Updated");
        } else {
            tx.rollback();
            System.out.println("Not Found");
        }

        s.close();
    }

    static void delete(Scanner sc) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();

        System.out.print("Student ID: ");
        int id = sc.nextInt();

        Student st = s.get(Student.class, id);

        if (st != null) {
            s.delete(st);
            tx.commit();
            System.out.println("Deleted");
        } else {
            tx.rollback();
            System.out.println("Not Found");
        }

        s.close();
    }
}
