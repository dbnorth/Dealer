package dealerPD;

import java.time.LocalDate;
import java.util.ArrayList;

public class Dealer {
  private String name;
  private String address;
  private String city;
  private String state;
  private String zip;
  private ArrayList<Car> cars;
  private ArrayList<SalesPerson> salesPersons;
  
  public Dealer() {
    cars = new ArrayList<Car>();
    salesPersons = new ArrayList<SalesPerson>();
  }
  
  public Dealer(String name, String address, String city, String state, String zip)
  {
    this();
    this.setName(name);
    this.setAddress(address);
    this.setCity(city);
    this.setState(state);
    this.setZip(zip);
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
  public String getCity() {
    return city;
  }
  public void setCity(String city) {
    this.city = city;
  }
  public String getState() {
    return state;
  }
  public void setState(String state) {
    this.state = state;
  }
  public String getZip() {
    return zip;
  }
  public void setZip(String zip) {
    this.zip = zip;
  }
  public ArrayList<Car> getCars() {
    return cars;
  }
  
  public ArrayList<SalesPerson> getSalesPersons() {
    return salesPersons;
  }
  
  public void addCar(Car car) {
    getCars().add(car);
  }
  
  public void removeCar(Car car)
  {
    getCars().remove(car);
  }
  
  public void addSalesPerson(SalesPerson salesPerson)
  
  {
    getSalesPersons().add(salesPerson);
  }
  public void removeSalesPerson(SalesPerson salesPerson)
  
  {
    getSalesPersons().remove(salesPerson);
  }
  
  public int getCarForSaleCount() {
    int count = 0;
    for (Car car : getCars()) {
      if (car.getDateSold() == null) count =count+1;
    }
    return count;
     
  }
  
  public int getCarsSoldThisMonth() {
    int count = 0;
    for (Car car : getCars()) {
      if ((car.getDateSold().getMonth()== LocalDate.now().getMonth()) &&
              (car.getDateSold().getYear() == LocalDate.now().getYear())) count =count+1;
    }
    return count;
     
  }
  
  public String toString() {
    return getName();
  }
}
