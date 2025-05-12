package com.ps;

import java.util.ArrayList;

public class Dealership
{
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> vehicles;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        vehicles = new ArrayList<>();
    }

    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }


    public void addVehicle(Vehicle v)
    {
        vehicles.add(v);
    }


    public boolean removeVehicle(String vin)
    {
        for (int i = 0; i < vehicles.size(); i++)
        {
            if (vehicles.get(i).getVin().equalsIgnoreCase(vin))
            {
                vehicles.remove(i);
                return true;
            }
        }
        return false;
    }


    public ArrayList<Vehicle> getAllVehicles()
    {
        return vehicles;
    }
}
