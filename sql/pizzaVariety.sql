---For Micorsoft Sql server
IF OBJECT_ID('dbo.PizzaVariety', 'U') IS NOT NULL 
   DROP TABLE dbo.PizzaVariety;


CREATE TABLE PizzaVariety (
    id int IDENTITY(1,1) PRIMARY KEY,
    pizzaName varchar(80) Unique,
    smallPizzaPrice int NULL,
    mediumPizzaPrice int NULL,
	largePizzaPrice int NULL
);

Select * from employee