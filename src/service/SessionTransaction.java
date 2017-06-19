/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Klasa zawierająca metody odpowiedzialne za otwarcie i zamknięcie sesji oraz
 * transakcji z bazą danych.
 *
 * @author Łukasz Wojtas
 */
public class SessionTransaction {

    /**
     * Utworzenie obiektu klasy SessionFactory - potrzebnej do otwarcia sesji.
     *
     * @return Obiekt klasy SessionFactory.
     */
    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }

    /**
     * Otwarcie sesji.
     *
     * @return Obiekt klasy Session.
     */
    public static Session openSession() {
        return SessionTransaction.getSessionFactory().openSession();
    }

    /**
     * Zamknięcie sesji.
     *
     * @param session Obiekt klasy Session.
     */
    public static void closeSession(Session session) {
        session.close();
    }

    /**
     * Otwarcie transakcji dla podanej sesji.
     *
     * @param session Obiekt klasy Session dla którego chcemy otworzyć sesję.
     * @return Obiekt klasy Transaction.
     */
    public static Transaction openTransaction(Session session) {
        return session.beginTransaction();
    }

    /**
     * Zamknięcie (commit) tansakcji wraz z automatycznym zamknięciem
     * odpowiadającej jej sesji.
     *
     * @param transaction Obiekt klasy Transaction.
     */
    public static void closeTransaction(Transaction transaction) {
        transaction.commit();
    }

}
