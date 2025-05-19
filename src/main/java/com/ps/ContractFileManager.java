package com.ps;

import java.io.*;

public class ContractFileManager
{
    public static void saveContract(Contract contract)
    {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Contracts.csv", true))) {

            if (contract instanceof SalesContract)
            {
                bw.write("SALE|" + contract.date + "|" + contract.customerName + "|" + contract.customerEmail + "|" +
                        contract.vehicleSold.toCSV() + "|" + contract.getTotalPrice() + "|" + contract.getMonthlyPayment());
            } else if (contract instanceof LeaseContract)
            {
                bw.write("LEASE|" + contract.date + "|" + contract.customerName + "|" + contract.customerEmail + "|" +
                        contract.vehicleSold.toCSV() + "|" + contract.getTotalPrice() + "|" + contract.getMonthlyPayment());
            }
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error saving contract: " + e.getMessage());
        }
    }
}