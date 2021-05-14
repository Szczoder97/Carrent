/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrent;

import carrent.models.Car;
import carrent.models.Client;
import carrent.models.Transactions;
import carrent.services.CarService;
import carrent.services.ClientService;
import carrent.services.TransactionsService;



/**
 *
 * @author hp
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      CarService cs = new CarService();
      ClientService cls = new ClientService();
      TransactionsService ts = new TransactionsService();
      Car car = cs.getCarById("GD 07604");
      Client client  = cls.getClientById(0);
      System.out.println(car);
      System.out.println(client);
      Transactions t = new Transactions(0,2,car,client);
      System.out.println(t);
      ts.addTransaction(t);
    }
    
}
