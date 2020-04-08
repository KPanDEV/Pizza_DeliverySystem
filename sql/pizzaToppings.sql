---For Micorsoft Sql server
CREATE TABLE PizzaToppings (
    id int IDENTITY(1,1) PRIMARY KEY,
    toppingName varchar(100) Unique,
    toppingPrice int NOT NULL,
);

