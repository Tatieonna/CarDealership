package org.example;

public class LeaseContract implements getPrice {
    private double leaseFee;
    private double interestRate;

    public LeaseContract(Vehicle vehicle, double salesTax, double processingFee, double recordingFee, double leaseFee, double interestRate) {
        super();
        this.leaseFee = leaseFee;
        this.interestRate = interestRate;
    }

    @Override
    public double getTotalPrice() {
        double totalPrice = getVehicle().getPrice() + leaseFee;

        // Calculate the total of monthly payments
        double monthlyPayment = getMonthlyPayment();
        totalPrice = monthlyPayment * 36;

        return totalPrice;
    }

    private Vehicle getVehicle() {
        return getVehicle();
    }

    @Override
    public double getMonthlyPayment() {
        // Calculate the monthly payment using the following formula:
        // Monthly Payment = (P - RV) * r / (1 - (1 + r)^-n)
        // Where:
        // P is the cost of the vehicle
        // RV is the residual value (50% of the cost of the vehicle)
        // r is the monthly interest rate (interestRate / 12)
        // n is the number of payments (36)

        double monthlyPayment = (getVehicle().getPrice() - getVehicle().getPrice() * 0.5) * interestRate / 12 / (1 - Math.pow(1 + interestRate / 12, -36));

        return monthlyPayment;
    }
}
