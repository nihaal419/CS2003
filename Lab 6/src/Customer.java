/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-b05b57321 modeling language!*/



// line 1 "code.ump"
public class Customer
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Customer Attributes
  private String fname;
  private String lname;
  private int zipCode;
  private int phoneNumber;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Customer(String aFname, String aLname, int aZipCode, int aPhoneNumber)
  {
    fname = aFname;
    lname = aLname;
    zipCode = aZipCode;
    phoneNumber = aPhoneNumber;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setFname(String aFname)
  {
    boolean wasSet = false;
    fname = aFname;
    wasSet = true;
    return wasSet;
  }

  public boolean setLname(String aLname)
  {
    boolean wasSet = false;
    lname = aLname;
    wasSet = true;
    return wasSet;
  }

  public boolean setZipCode(int aZipCode)
  {
    boolean wasSet = false;
    zipCode = aZipCode;
    wasSet = true;
    return wasSet;
  }

  public boolean setPhoneNumber(int aPhoneNumber)
  {
    boolean wasSet = false;
    phoneNumber = aPhoneNumber;
    wasSet = true;
    return wasSet;
  }

  public String getFname()
  {
    return fname;
  }

  public String getLname()
  {
    return lname;
  }

  public int getZipCode()
  {
    return zipCode;
  }

  public int getPhoneNumber()
  {
    return phoneNumber;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "fname" + ":" + getFname()+ "," +
            "lname" + ":" + getLname()+ "," +
            "zipCode" + ":" + getZipCode()+ "," +
            "phoneNumber" + ":" + getPhoneNumber()+ "]";
  }
}