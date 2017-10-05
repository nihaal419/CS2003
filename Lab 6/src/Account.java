/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-b05b57321 modeling language!*/



// line 10 "code.ump"
public class Account extends Customer
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Account Attributes
  private int custID;
  private String userID;
  private String password;
  private Order lastOrder;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Account(String aFname, String aLname, int aZipCode, int aPhoneNumber, int aCustID, String aUserID, String aPassword, Order aLastOrder)
  {
    super(aFname, aLname, aZipCode, aPhoneNumber);
    custID = aCustID;
    userID = aUserID;
    password = aPassword;
    lastOrder = aLastOrder;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCustID(int aCustID)
  {
    boolean wasSet = false;
    custID = aCustID;
    wasSet = true;
    return wasSet;
  }

  public boolean setUserID(String aUserID)
  {
    boolean wasSet = false;
    userID = aUserID;
    wasSet = true;
    return wasSet;
  }

  public boolean setPassword(String aPassword)
  {
    boolean wasSet = false;
    password = aPassword;
    wasSet = true;
    return wasSet;
  }

  public boolean setLastOrder(Order aLastOrder)
  {
    boolean wasSet = false;
    lastOrder = aLastOrder;
    wasSet = true;
    return wasSet;
  }

  public int getCustID()
  {
    return custID;
  }

  public String getUserID()
  {
    return userID;
  }

  public String getPassword()
  {
    return password;
  }

  public Order getLastOrder()
  {
    return lastOrder;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "custID" + ":" + getCustID()+ "," +
            "userID" + ":" + getUserID()+ "," +
            "password" + ":" + getPassword()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "lastOrder" + "=" + (getLastOrder() != null ? !getLastOrder().equals(this)  ? getLastOrder().toString().replaceAll("  ","    ") : "this" : "null");
  }
}