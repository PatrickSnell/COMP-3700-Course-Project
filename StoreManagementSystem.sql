# Create tables for Store Management System database
CREATE TABLE Product (
	Barcode_Number int,
    Product_Name varchar(45),
    Quantity_Available int,
    Price_Per_Unit double,
    Provider_Name varchar(45),
    Provider_Contact varchar(45),
    Primary Key (Barcode_Number)
);

CREATE TABLE Orders (
	Order_ID int,
    Num_Products int,
    Payment_Choice varchar(45),
    Subtotal double,
    Tax_Rate double,
    Total_Price double,
    Primary Key (Order_ID)
);

CREATE TABLE OrderLine (
	Order_ID int,
	Barcode_Number int,
    Product_Name varchar(45),
	Quantity int,
	Cost double,
	Primary Key(Barcode_Number, Order_ID)
);

CREATE TABLE Cashier (
	Employee_ID int,
	Employee_Name varchar(45),
	wage double,
    Primary Key(Employee_ID)
);

CREATE TABLE Customer (
	Customer_Name varchar(45),
	Payment_Choice double,
    Primary Key(Customer_Name)
);

CREATE TABLE Product_Inventory (
	Barcode_Number int,
    Admin varchar(45),
	Capacity int,
    Assets double,
    Primary Key(Admin)
);

CREATE TABLE  Order_Inventory (
	Order_ID int,
    Admin varchar(45),
	Capacity int,
    Revenue double,
    Primary Key(Admin)
);

# Insert sample datasets into tables
INSERT INTO Product 
Values (101, 'Apple', 25, 1.00, 'Johnny Appleseed', '2568709132'),
(102, 'Banana', 50, 0.50, 'Banana Man', '2059876543'),
(103, 'Orange', 20, 0.75, 'Orange Man', '9876543210'),
(104, 'Water Bottle', 24, 1.00, 'Aqua Man', '2347639873'),
(105, 'Pear', 15, 1.00, 'Pear Man', '6546547654');

INSERT INTO Orders
Values (1, 2, 'Credit Card', 4.50, 0.05, 4.73),
(2, 2, 'Cash', 30.00, 0.05, 31.50),
(3, 2, 'Check', 4.00, 0.05, 4.20),
(4, 3, 'Credit Card', 12.00, 0.05, 12.60),
(5, 3, 'Cash', 5.25, 0.05, 5.51);

INSERT INTO Orderline
Values (1, 101, 'Apple', 2, 2.00),
(1, 102, 'Banana', 5, 2.50),
(2, 104, 'Water Bottle', 20, 20.00),
(2, 105, 'Pear', 10, 10.00),
(3, 103, 'Orange', 2, 1.50),
(3, 102, 'Banana', 5, 2.50),
(4, 101, 'Apple', 2, 2.00),
(4, 102, 'Banana', 5, 2.50),
(4, 103, 'Orange', 10, 7.50),
(5, 104, 'Water Bottle', 2, 2.00),
(5, 102, 'Banana', 5, 2.50),
(5, 103, 'Orange', 1, 0.75);
