package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDemo 
{
    public static void main(String[] args) 
    {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        // INSERT OPERATION
        Library lib = new Library("Central Library",
                                  "Books and Journals",
                                  "2026-03-13",
                                  "Available");

        session.save(lib);

        tx.commit();
        System.out.println("Record Inserted");

        // DELETE OPERATION
        Transaction tx2 = session.beginTransaction();

        Library l = session.get(Library.class, 1);

        if(l != null)
        {
            session.delete(l);
            System.out.println("Record Deleted");
        }

        tx2.commit();

        session.close();
        sf.close();
    }
}