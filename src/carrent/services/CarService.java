/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrent.services;

import carrent.models.Car;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author hp
 */
public class CarService extends ServiceBase {
    public void addCar(Car c){
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
    public List<Car> getAllCars(){
        EntityManager em  = this.getEntityManager();
        TypedQuery<Car> q = em.createNamedQuery("Car.findAll", Car.class);
        return q.getResultList();
    }
    public Car getCarById(String id){
        EntityManager em  = this.getEntityManager();
        return em.find(Car.class, id);
    }
    public void updateCar(Car c, int price){
        EntityManager em  = this.getEntityManager();
        em.getTransaction().begin();
        try{
            c.setPricePerDay(price);
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
    public void removeCar(Car c){
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
