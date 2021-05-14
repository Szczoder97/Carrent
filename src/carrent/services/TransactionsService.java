/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrent.services;


import carrent.models.Transactions;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author hp
 */
public class TransactionsService extends ServiceBase {
    public void addTransaction(Transactions t){
        EntityManager em  = this.getEntityManager();
        em.getTransaction().begin();
        try{
            em.persist(t);
            em.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
        }
        finally{
            em.close();
        }
    }
    public List<Transactions> getAllTransactions(){
        EntityManager em  = this.getEntityManager();
        TypedQuery<Transactions> q = em.createNamedQuery("Car.findAll", Transactions.class);
        return q.getResultList();
    }
    public Transactions getTransactionById(int id){
        EntityManager em  = this.getEntityManager();
        return em.find(Transactions.class, id);
    }
    public void updateTransaction(Transactions t, int days){
        EntityManager em  = this.getEntityManager();
        em.getTransaction().begin();
        int newTotalPrice = t.getCarId().getPricePerDay() * days;
        try{
            t.setDays(days);
            t.setTotalPrice(newTotalPrice);
            t = em.merge(t);
            em.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
        }
        finally{
            em.close();
        }
    }
    public void removeTransaction(Transactions t){
        EntityManager em  = this.getEntityManager();
        em.getTransaction().begin();
        try{
            t = em.merge(t);
            em.remove(t);
            em.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
        }
        finally{
            em.close();
        }
    }
}
