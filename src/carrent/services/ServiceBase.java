/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrent.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author hp
 */
public abstract class ServiceBase {
    EntityManagerFactory emf;
    public EntityManager getEntityManager(){
        if(emf == null){
            emf = Persistence.createEntityManagerFactory("CarrentPU");
        }
        return emf.createEntityManager();
    }
}
