package com.ps;

public class LeaseContract extends Contract
{
    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold)
    {
        super(date, customerName, customerEmail, vehicleSold);
    }

    @Override
    public double getTotalPrice()
    {
        double endingValue = vehicleSold.getPrice() * 0.5;
        double leaseFee = vehicleSold.getPrice() * 0.07;
        return endingValue + leaseFee;
    }

    @Override
    public double getMonthlyPayment()
    {
        double total = getTotalPrice();
        double rate = 0.04 / 12;
        int months = 36;
        return (total * rate) / (1 - Math.pow(1 + rate, -months));
    }
}