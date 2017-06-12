/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Zawiera chronione (protected) pola klas Session i Transaction. Jest
 * dziedziczona przez każdą klasę ...DAO.
 *
 * @author Łukasz Wojtas
 */
public class DAO {

    /**
     * Chronione (protected) pole klasy Session.
     */
    protected Session session;

    /**
     * Chronione (protected) pole klasy Transaction.
     */
    protected Transaction transaction;

    /**
     * Getter pola session.
     *
     * @return Wartość pola session.
     */
    public Session getSession() {
        return session;
    }

    /**
     * Setter pola session.
     *
     * @param session Wartość do zapisania do pola session.
     */
    public void setSession(Session session) {
        this.session = session;
    }

    /**
     * Getter pola transaction.
     *
     * @return Wartość pola transaction.
     */
    public Transaction getTransaction() {
        return transaction;
    }

    /**
     * Setter pola transaction.
     *
     * @param transaction Wartość do zapisania do pola transaction.
     */
    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

}
