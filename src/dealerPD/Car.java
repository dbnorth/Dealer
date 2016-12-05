package dealerPD;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Car {
  private String make;
  private String model;
  private String year;
  private String color;
  private BigDecimal price;
  private LocalDate datePurchased;
  private LocalDate dateSold;
  private SalesPerson salesPerson;
  private String serialNumber;
  
  public Car() {
    
  };
  
  public Car (String serialNumber,String make, String model, String year, String color, String date, String price)
  {
    this();
    this.serialNumber = serialNumber;
    this.make = make;
    this.model = model;
    this.year = year;
    this.setColor(color);
    this.setDatePurchased(LocalDate.parse(date, DateTimeFormatter.ofPattern("M/d/yyyy")));
    this.price = new BigDecimal(price);
  }
  
  
  public String getMake() {
    return make;
  }
  public void setMake(String make) {
    this.make = make;
  }
  public String getModel() {
    return model;
  }
  public void setModel(String model) {
    this.model = model;
  }
  public String getYear() {
    return year;
  }
  public void setYear(String year) {
    this.year = year;
  }
  public BigDecimal getPrice() {
    return price;
  }
  public void setPrice(BigDecimal price) {
    this.price = price;
  }
  public LocalDate getDatePurchased() {
    return datePurchased;
  }
  public void setDatePurchased(LocalDate datePurchased) {
    this.datePurchased = datePurchased;
  }


  public String getSerialNumber() {
    return serialNumber;
  }


  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }


  public SalesPerson getSalesPerson() {
    return salesPerson;
  }


  public void setSalesPerson(SalesPerson salesPerson) {
    this.salesPerson = salesPerson;
  }


  public LocalDate getDateSold() {
    return dateSold;
  }


  public void setDateSold(LocalDate dateSold) {
    this.dateSold = dateSold;
  }
  
  public boolean isOkToRemove() {
    if (getSalesPerson() == null) return true; else return false;
  }
  
  public String toString() {
    return getMake()+" "+getModel()+" "+getYear()+" "+getSerialNumber();
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }
  
}
