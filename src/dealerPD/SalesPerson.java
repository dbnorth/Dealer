package dealerPD;

import java.util.ArrayList;

public class SalesPerson {


  private String name;
  private String position;
  private ArrayList<Car> cars;
  
  public SalesPerson(){
    cars = new ArrayList<Car>();
  }
  
  public SalesPerson( String name, String position) {
    this();
    this.setName(name);
    this.setPosition(position);
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  
  public String getPosition() {
    return position;
  }
  public void setPosition(String position) {
    this.position = position;
  }
  public ArrayList<Car> getCars() {
    return cars;
  }
  
  public void addCar(Car car) {
    getCars().add(car);
  }
  
  public void removeCar(Car car)
  {
    getCars().remove(car);
  }
  
  public boolean isOkToRemove() {
    if (getCars().size() == 0) return true; else return false;
  }
  
  public String toString() {
    return getName()+ " "+getPosition();
  }
}
