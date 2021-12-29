import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double money = Double.parseDouble(args[0]);
        double fullMoney;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter volume of the tank car");
        double volTank = sc.nextDouble();
        System.out.println("Enter tank residue");
        double residue = sc.nextDouble();
        Car car = new Car(volTank, residue);

        System.out.println("Route calculation from Odessa to Kiev");
        System.out.println("The first destination of Krivoye Ozero");
        System.out.println("Fuel remaining " + car.fuelRemaining(179) + " after overcoming 179 km");
        System.out.println(car.getFuelConsPerKm());
        car.fillTheTank();
        System.out.println("Refueling cost is " + getMoney(money, car.getFuelConsPerKm()));
        fullMoney = getMoney(money, car.getFuelConsPerKm());
        System.out.println();

        System.out.println("The second destination of Zhashkov");
        System.out.println("Fuel remaining " + car.fuelRemaining(153) + " after overcoming 153 km");
        System.out.println(car.getFuelConsPerKm());
        System.out.println("Refueling cost is " + getMoney(money, car.getFuelConsPerKm()));
        fullMoney += getMoney(money, car.getFuelConsPerKm());
        car.fillTheTank();
        System.out.println();

        System.out.println("The final destination of Kiev");
        System.out.println("Fuel remaining " + car.fuelRemaining(149) + " after overcoming 149 km");
        System.out.println("Need to refuel " + car.needToRefuel(149) + " fuel");
        System.out.println("Refueling cost is " + getMoney(money, car.getFuelConsPerKm()));
        fullMoney += getMoney(money, car.getFuelConsPerKm());
        System.out.println(car.getFuelConsPerKm());
        System.out.println("The cost of a full trip from Odessa to Kiev is " + fullMoney);
    }

    static double getMoney(double money, double fuel) {
        money = fuel * money;
        return money;
    }
}
