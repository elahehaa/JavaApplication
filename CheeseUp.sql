DROP DATABASE CheeseUp;
CREATE DATABASE CheeseUp;
USE CheeseUp;
CREATE TABLE EMPLOYEE
(
    Fname VARCHAR(10) NOT NULL,
    Minit CHAR,
    Lname VARCHAR(20) NOT NULL,
    Emp_No INT NOT NULL,
    Left_vac int ,
    Street VARCHAR(30),
    State VARCHAR(30),
    Zip VARCHAR(7),
    Working_hour int ,
    Experience VARCHAR(15),
    Phone_Number INT,
    Username VARCHAR (30),
    Passwords VARCHAR (30),
    JobType VARCHAR (30),
    PRIMARY KEY   (Emp_No)
);

CREATE TABLE Timesheet
(
    Emp_No INT NOT NULL,
	Shift_Date Date ,
    Enter_time Time ,
    Exit_time Time,
    Working_hour INT ,
    ESSN CHAR(9) ,
    PRIMARY KEY (Emp_No)
  
);

CREATE TABLE  ORDERS
(
    Quantity INT ,
    Dates Date ,
    Times Time,
    Bill_Number INT NOT NULL,
    Bill_Amount VARCHAR(15) ,
    Food_Name VARCHAR(30) ,
    Food_Modification VARCHAR(30),
    Food_Price VARCHAR(15) ,
    Food_Description VARCHAR(30),
    Drink_Name VARCHAR(15) ,
    Drink_Price VARCHAR(15) ,
    PRIMARY KEY (Bill_Number)
   
);

CREATE TABLE Clients
(
    Client_ID VARCHAR(15) NOT NULL,
    Client_Name VARCHAR(30) ,
    Client_Phone INT,
    PRIMARY KEY (Client_ID)
);

CREATE TABLE Payment_method
(
    Receipt_Number CHAR(15) NOT NULL,
    Client_ID VARCHAR(15) ,
    Bill_Number INT,
    PRIMARY KEY (Receipt_Number)
    /*FOREIGN KEY (Client_ID) REFERENCES Clients(Client_ID),
    FOREIGN KEY (Bill_Number) REFERENCES Orders(Bill_Number)*/
);

/**CREATE TABLE Cash
(
    Receipt_Number VARCHAR(15) NOT NULL,
    Bill_Amount VARCHAR(15) NOT NULL,
    Received_Amount VARCHAR(15) NOT NULL,
    FOREIGN KEY (Receipt_Number) REFERENCES Payment_method(Receipt_Number),
    FOREIGN KEY (Bill_Amount) REFERENCES Orders(Bill_Amount)
);

CREATE TABLE Square_System
(
    Client_Email VARCHAR(30) NOT NULL,
    last_4_digit INT,
    Receipt_Number VARCHAR(15) NOT NULL,
    PRIMARY KEY (Client_Email),
    FOREIGN KEY (Receipt_Number) REFERENCES Payment_method(Receipt_Number)
); **/

CREATE TABLE Supplier
(
    Supplier_Name VARCHAR(15) NOT NULL,
    Street VARCHAR(15) ,
    State VARCHAR(15) ,
    Zip VARCHAR(15) ,
    Phone_Num INT ,
    PRIMARY KEY (Supplier_Name)
    );
    
 /**CREATE TABLE Location
(
    loc_ID VARCHAR(15) NOT NULL,
    Street VARCHAR(15) NOT NULL,
    State VARCHAR(15) NOT NULL,
    Zip VARCHAR(15) NOT NULL,
    ESSN VARCHAR(9) NOT NULL,
    PRIMARY KEY (loc_ID),
    FOREIGN KEY (ESSN) REFERENCES EMPLOYEE(Ssn)
    );**/
    

    
    
    
INSERT INTO EMPLOYEE
VALUES ('John', 'B', 'Smith',  1 , 4 ,  '731 Fondren' , 'TX', '12345', 2, '2 year', 555 , 'John' , 'Smith', 'Manager'),
               ('J', 'B', 'S', 2 , 3 ,  '731 Fondren' , 'TX', '12345', 2, '2 year', 555 , 'J' , 'S', 'Staff');


INSERT INTO Timesheet
VALUES ( 1  , '2020-03-03' , '12:00:00' , '16:00:00' , 4 , '123456789');

INSERT INTO Orders
VALUES ( NULL  , NULL , NULL, 1 , '$15' , 'Vegie Wrap' , NULL , NULL , NULL, 'coke',NULL );

INSERT INTO Clients 
VALUES ( '1', 'Jack Song' , 234  );

INSERT INTO Payment_method
VALUES ( 'A1' , '1', 1 );

INSERT INTO Supplier
VALUES ( 'ABC' , '123 York Rd', NULL , NULL , 123);

-- ALTER TABLE DEPARTMENT
 -- ADD CONSTRAINT Dep_emp FOREIGN KEY (Mgr_ssn) REFERENCES EMPLOYEE(Ssn);

-- ALTER TABLE EMPLOYEE
 -- ADD CONSTRAINT Emp_emp FOREIGN KEY (Super_ssn) REFERENCES EMPLOYEE(Ssn);
-- ALTER TABLE EMPLOYEE
 -- ADD CONSTRAINT Emp_dno FOREIGN KEY  (Dno) REFERENCES DEPARTMENT(Dnumber);
-- ALTER TABLE EMPLOYEE
--  ADD CONSTRAINT Emp_super FOREIGN KEY  (Super_ssn) REFERENCES EMPLOYEE(Ssn);