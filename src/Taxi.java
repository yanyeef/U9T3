public class Taxi extends Car {
  private double fareCollected;

  public Taxi(String licensePlate, double tollFee, int passengers, boolean isElectric, double fareCollected) {
    super(licensePlate, tollFee, passengers, isElectric); // super refers to the Car constructor
    this.fareCollected = fareCollected;
  }

  public boolean chargeAndDropOffRiders(double farePerRider){
    int people = getPassengers()-1;
    fareCollected += (people *farePerRider);
    return super.dropOffPassengers(people);
  }

  public double getFareCollected(){
    return fareCollected;
  }

  @Override
  public void printInfo() {
    super.printInfo();
    System.out.println("Total fare collected: " + fareCollected);
  }

  @Override
  public void gas(int gas1){
    if(gas1 <10){
      System.out.println("You need at least 10 gallons to keep driving passengers");
    } else {
      System.out.println("You have enough gas ");
    }
  }
}