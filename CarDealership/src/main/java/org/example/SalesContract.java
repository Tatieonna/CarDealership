package org.example;

public class SalesContract implements GetTotalPrice {
    private double interestRate;
    private int loanLength;

    public SalesContract(Vehicle vehicle, double salesTax, double processingFee, double recordingFee, boolean isFinanced, double interestRate, int loanLength) {
        super();
        this.interestRate = interestRate;
        this.loanLength = loanLength;
    }

    @Override
    public double getTotalPrice() {
        double totalPrice = getVehicle().getPrice() + getSalesTax() + getProcessingFee() + getRecordingFee();

        if (isFinanced()) {
            // Calculate the interest paid over the life of the loan
            double interest = getVehicle().getPrice() * interestRate * loanLength / 12;
            totalPrice += interest;
        }

        return totalPrice;
    }

    private boolean isFinanced() {
        return isFinanced();
    }

    private double getRecordingFee() {
        return getRecordingFee();
    }

    private double getProcessingFee() {
        return getProcessingFee();
    }

    private double getSalesTax() {
        return getSalesTax();
    }

    private Vehicle getVehicle() {
        return getVehicle();
    }

    @Override
    public double getMonthlyPayment() {
        double monthlyPayment = getTotalPrice() / loanLength;
        return monthlyPayment;
    }
}
