/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-b05b57321 modeling language!*/



// line 19 "code.ump"
public class Order extends Account
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Order Attributes
  private int creationDate;
  private String item;
  private int orderID;
  private double total;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Order(String aFname, String aLname, int aZipCode, int aPhoneNumber, int aCustID, String aUserID, String aPassword, Order aLastOrder, int aCreationDate, String aItem, int aOrderID, double aTotal)
  {
    super(aFname, aLname, aZipCode, aPhoneNumber, aCustID, aUserID, aPassword, aLastOrder);
    creationDate = aCreationDate;
    item = aItem;
    orderID = aOrderID;
    total = aTotal;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCreationDate(int aCreationDate)
  {
    boolean wasSet = false;
    creationDate = aCreationDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setItem(String aItem)
  {
    boolean wasSet = false;
    item = aItem;
    wasSet = true;
    return wasSet;
  }

  public boolean setOrderID(int aOrderID)
  {
    boolean wasSet = false;
    orderID = aOrderID;
    wasSet = true;
    return wasSet;
  }

  public boolean setTotal(double aTotal)
  {
    boolean wasSet = false;
    total = aTotal;
    wasSet = true;
    return wasSet;
  }

  public int getCreationDate()
  {
    return creationDate;
  }

  public String getItem()
  {
    return item;
  }

  public int getOrderID()
  {
    return orderID;
  }

  public double getTotal()
  {
    return total;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "creationDate" + ":" + getCreationDate()+ "," +
            "item" + ":" + getItem()+ "," +
            "orderID" + ":" + getOrderID()+ "," +
            "total" + ":" + getTotal()+ "]";
  }
}