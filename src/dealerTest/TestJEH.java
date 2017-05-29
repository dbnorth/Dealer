package dealerTest;

import dealerPD.Car;
import dealerPD.Dealer;
import dealerPD.SalesPerson;

public class TestDBN extends Test {
  
  public void printTest(Dealer dealer) {
     
    
    Car car1 = new Car("JX123456708","Chevrolet","Malibu","1976","Maroon", "09/01/1977","5400");
    Car car2 = new Car("LG12312489","Triump","TR6","1973","Green","08/01/1984","8000");
    Car car3 = new Car("TY12348908","Alpha","Spyder","1985","Red","06/01/1995","12000");
    Car car4 = new Car("QU12463484","Porche","911-Cabriolet","1984","Red","10/01/2000","24000");
    
    dealer.addCar(car1);
    dealer.addCar(car2);
    dealer.addCar(car3);
    dealer.addCar(car4);
    
    SalesPerson salesPerson1 = new SalesPerson("Daivd","Owner");
    dealer.addSalesPerson(salesPerson1);
    

    System.out.println(dealer+ " cars for Sale:"+dealer.getCarForSaleCount());
    System.out.println("===================");
    System.out.println("Sales People");
    System.out.println("===================");
    for (SalesPerson salesPerson : dealer.getSalesPersons()) {
      System.out.println(salesPerson);
    }
    System.out.println("");
    System.out.println("===================");
    System.out.println("Cars");
    System.out.println("===================");
    for (Car car: dealer.getCars())
    { 
      
      System.out.println(car);
    }
    
  }

}
