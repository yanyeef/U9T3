public class Car extends Vehicle
{
  private boolean electric;
  private boolean discountApplied;
  
  public Car(String licensePlate, double tollFee, int passengers, boolean electric)
  {
    super(licensePlate, tollFee, passengers);
    this.electric = electric;
    discountApplied = false; // default value
  }
  public boolean isElectric()
  {
    return electric;
  }

  public boolean isDiscountApplied()
  {
    return discountApplied;
  }

  public void printCar()
  {
    // print the car's license plate, toll fee, number of passengers,
    // whether it is electric, and whether a discount has been applied
    System.out.println("License plate: " + getLicensePlate());
    System.out.println("Toll fee: " + getTollFee());
    System.out.println("Passengers: " + getPassengers());
    System.out.println("Electric? " + electric);
    System.out.println("Discount applied? " + discountApplied);
  }

  public boolean dropOffPassengers(int numOut)
  {
    // get the current number of passengers
    int currentPassengers = getPassengers();

    if (numOut < currentPassengers)
    {
      // update passengers to new value using setter method
      // (which needs to be added to the Vehicle class)
      setPassengers(currentPassengers - numOut);
      return true;  // success!
    }
    else  // do nothing and return false;
    {
      return false;
    }
  }

  public void applyDiscount()
  {
    if (!discountApplied)  // only apply discount if discountApplied is currently false
    {
      if (isElectric())  // discount only granted for electric vehicles
      {
        double discountedFee = getTollFee() * 0.5;  // get current toll fee and cut in half
        setTollFee(discountedFee); // set the fee to the new fee; MUST ADD THIS SETTER METHOD!
        discountApplied = true; // set discountApplied to true
      }
    }
  }
}