

## Car Dealership Management System
This application is a simple, console-based car dealership management system written in Java. It allows users to manage a dealership’s vehicle inventory, filter and search vehicles, add or remove vehicles, and process sales or lease contracts. All data is stored in CSV files for easy editing and persistence.

## Features:

- Add new vehicles to the dealership inventory
- Remove vehicles by VIN
- all vehicles in the inventory
- Filter vehicles by price range, make/model, year, color, mileage, or type
- Data is stored in a CSV file (Inventory.csv) for easy editing and backup
- Contracts: Supports both sales and lease contracts, with all contract data appended to a contracts CSV file.


## How it works:

On startup, the program loads dealership and vehicle data from Inventory.csv.
The user interacts with a menu to view, filter, add, remove, sell, or lease vehicles.
When a vehicle is sold or leased, the contract is saved to contracts.csv and the vehicle is removed from inventory.
All changes are immediately saved to the CSV files.

## Interesting Code:

One interesting aspect of this project is the robust file parsing logic. The code skips blank or malformed lines in the CSV files, preventing crashes and making the application more user-friendly.

![MainMenu](../../../OneDrive/Pictures/Screenshots/Screenshot%202025-04-20%20195937.png)

![contractProcess](../../../OneDrive/Pictures/Screenshots/Screenshot%202025-04-20%20195849.png)

![InterestingCode](../../../OneDrive/Pictures/Screenshots/Screenshot%202025-04-20%20195749.png)