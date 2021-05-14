/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrent.services;

import carrent.models.Car;
import carrent.models.Client;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author hp
 */
public class ClientService extends ServiceBase {
    public void addClient(Client c){
        EntityManager em  = this.getEntityManager();
        em.getTransaction().begin();
        try{
            em.persist(c);
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
    public List<Client> getAllClients(){
        EntityManager em  = this.getEntityManager();
        TypedQuery<Client> q = em.createNamedQuery("Car.findAll", Client.class);
        return q.getResultList();
    }
    public Client getClientById(int id){
        EntityManager em  = this.getEntityManager();
        return em.find(Client.class, id);
    }
    public void updateClient(Client c, String address){
        EntityManager em  = this.getEntityManager();
        em.getTransaction().begin();
        try{
            c.setAdres(address);
            c = em.merge(c);
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
    public void removeClient(Client c){
        EntityManager em  = this.getEntityManager();
        em.getTransaction().begin();
        try{
            c = em.merge(c);
            em.remove(c);
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
