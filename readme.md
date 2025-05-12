

## Car Dealership Management System
This application is a simple console-based car dealership management system that allows users to add vehicles, remove vehicles, and view or filter the dealership’s inventory. The main menu offers options to filter vehicles by price, make/model, year, color, mileage, or type, as well as view all vehicles, add a new vehicle, or remove an existing one. All dealership and vehicle data is saved to a CSV file, so your inventory persists between sessions.

Features:

- Add new vehicles to the dealership inventory
- Remove vehicles by VIN
-  all vehicles in the inventory
- Filter vehicles by price range, make/model, year, color, mileage, or type
- Data is stored in a CSV file (Inventory.csv) for easy editing and backup


How it works:

When the application starts, it loads the dealership and all vehicles from the CSV file. Users interact with a simple text-based menu to perform actions. Any changes (adding or removing vehicles) are immediately saved to the file, ensuring your inventory is always up to date.

Interesting Code:

One of the most interesting parts of this project is the flexible filtering system. Each filter option  prompts the user for input and only applies the filter if the user provides a value. This makes it easy to search for exactly the vehicles you want, and required careful handling of user input and list filtering. Getting all the filters to work together smoothly was a great learning experience and really improved the usability of the application.


![Screenshot 2025-04-20 195837.png](../../../OneDrive/Pictures/Screenshots/Screenshot%202025-04-20%20195937.png)

![Screenshot 2025-04-20 195449.png](../../../OneDrive/Pictures/Screenshots/Screenshot%202025-04-20%20195849.png)

![Screenshot 2025-04-20 195949.png](../../../OneDrive/Pictures/Screenshots/Screenshot%202025-04-20%20195749.png)