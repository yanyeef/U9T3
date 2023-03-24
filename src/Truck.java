public class Truck extends Vehicle
{
  private int axles;
  private boolean hasTrailer;
  
  public Truck(String licensePlate, double tollFee, int passengers, int axles, boolean hasTrailer)
  {
    super(licensePlate, tollFee, passengers);
    this.axles = axles;
    this.hasTrailer = hasTrailer;
  }

  @Override
  public void printInfo()
  {
    // print the truck's license plate, toll fee, number of passengers, axles,
    // and whether it has a trailer
    super.printInfo();
    System.out.println("Number of axles: " + axles);
    System.out.println("Has trailer? " + hasTrailer);
  }

  public boolean validateLicensePlate()
  {
    // check if truck has a trailer
    if (hasTrailer)
    {
      // get license plate
      String licensePlate = getLicensePlate();

      // get last two characters
      String lastTwoChars = licensePlate.substring(licensePlate.length() - 2);

      // confirm MX if axles > 4 or LX if axles <= 4
      boolean isValid = (lastTwoChars.equals("MX") && axles > 4) || (lastTwoChars.equals("LX") && axles <= 4);
      return isValid;
    }
    else  // trucks without trailers automatically return true
    {
      return true;
    }
  }

  @Override
  public double calculateTollPrice(){
    double fee = 0;
    fee = getTollFee()*axles;
    if(hasTrailer){
      fee= fee*2;
    }
    return fee;
  }
}
