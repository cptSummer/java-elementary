import java.text.DecimalFormat;

public class Car {
    private double volOfTheTank; // полный бак
    private double tankResidue; // остаток в баке
    private double fuelConsPerKm; // расход нас 100 км

    public Car(double volOfTheTank, double tankResidue) {
        this.volOfTheTank = volOfTheTank;
        this.tankResidue = tankResidue;
    }

    public double getVolOfTheTank() {
        return volOfTheTank;
    }

    public void setVolOfTheTank(double volOfTheTank) {
        this.volOfTheTank = volOfTheTank;
    }

    public double getTankResidue() {
        return tankResidue;
    }

    public void setTankResidue(double tankResidue) {
        this.tankResidue = tankResidue;
    }

    public double getFuelConsPerKm() {
        return fuelConsPerKm;
    }

    public void setFuelConsPerKm(double fuelConsPerKm) {
        this.fuelConsPerKm = fuelConsPerKm;
    }

    public void fillTheTank() { // полный бак
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String resultC = decimalFormat.format(this.tankResidue);
        System.out.println("Fill the full tank");
        System.out.println("Left in the tank " + resultC + " fuel");

        double volOfTank = this.volOfTheTank;
        double tankResidue = this.tankResidue;
        double inequality = volOfTank - tankResidue;
        resultC = decimalFormat.format(inequality);

        System.out.println("Need to refuel " + resultC + " fuel");
        this.tankResidue = inequality + tankResidue;
        System.out.println("The tank is completely full");

    }

    //    public void fuelRemaining(int km) { //остаток топлива по преодолении N км
//        DecimalFormat decimalFormat = new DecimalFormat("#.##");
//        double tankResidue = getTankResidue();
//        double result = (tankResidue / km) * 100;
//        this.fuelConsPerKm = result;
//        result = tankResidue - result;
//        String resultC = decimalFormat.format(result);
//        System.out.println("Fuel remaining " + resultC + " after overcoming " + km + " km");
//    }
    public String fuelRemaining(int km) { //остаток топлива по преодолении N км
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        double tankResidue = this.tankResidue;
        double result = km/tankResidue;
        this.fuelConsPerKm = result;
        result = tankResidue - result;
        this.tankResidue = result;
        String resultC = decimalFormat.format(result);
        return resultC;
    }

    //    public void needToRefuel(int km) { // сколько надо до заправить топлива при преодолении N км
//        DecimalFormat decimalFormat = new DecimalFormat("#.##");
//        double volOfTank = this.volOfTheTank;
//        double tankResidue = this.tankResidue;
//        double result = (tankResidue / km) * 100;
//        tankResidue = tankResidue - result;
//        double inequality = volOfTank - tankResidue;
//        String resultC = decimalFormat.format(inequality);
//        System.out.println("Need to refuel " + resultC + " fuel, when overcoming " + km + " km");
//
//    }
    public String needToRefuel(int km) { // сколько надо до заправить топлива при преодолении N км
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        double volOfTank = this.volOfTheTank;
        double tankResidue = this.tankResidue;
        double inequality = volOfTank - tankResidue;
        String resultC = decimalFormat.format(inequality);
        return resultC;
    }
}
