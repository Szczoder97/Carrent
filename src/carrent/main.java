/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrent;

import carrent.models.Car;
import carrent.services.CarService;
import java.util.List;

/**
 *
 * @author hp
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Car c1 = new Car("GD 07704", "Opel", "Astra", 2004, 1583, 90, 150);
        //Car c2 = new Car("GD 07504", "Opel", "Corsa", 2008, 998, 58, 80);
        //Car c3 = new Car("GD 07604", "Volkswagen", "Passat", 2004, 1782, 160, 220);
        CarService cs = new CarService();
        //cs.addCar(c1);
        //cs.addCar(c2);
        //cs.addCar(c3);
        Car car = cs.getCarById("GD 07504");
        System.out.println(car+ " "+ car.getPricePerDay());
        cs.updateCar(car, 100);
        Car car2 = cs.getCarById("GD 07504");
        System.out.println(car2+" "+ car2.getPricePerDay());
        cs.removeCar(car2);
    }
    
}
