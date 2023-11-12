package org.example;

public class Contract {
    private Vehicle vehicle;
    private double salesTax;
    private double processingFee;
    private double recordingFee;
    private boolean isFinanced;

    public Contract(Vehicle vehicle, double salesTax, double processingFee, double recordingFee, boolean isFinanced) {
        this.vehicle = vehicle;
        this.salesTax = salesTax;
        this.processingFee = processingFee;
        this.recordingFee = recordingFee;
        this.isFinanced = isFinanced;
    }

    public double getTotalPrice() {
        return 0;
    }

    public double getMonthlyPayment() {
        return 0;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public double getSalesTax() {
        return salesTax;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public boolean isFinanced() {
        return isFinanced;
    }
}
