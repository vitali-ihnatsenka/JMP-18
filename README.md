# JMP-18

Please, write Rest web services for User directory that provide CRUD operations on User.


User information should contain at least: first name, last name, login and email.


For creation of the user, please, use XML, for user update JSON format.


Create also Rest service to upload and download user logo as Image.


The application should be implemented and deploy on application server.


You can use any Rest implementation (Jersey, Restlet, etc.).


To test your application, please, use jersey Rest client that will cover all operations.


User data can be saved anywhere, database is not required.


-------------------------------------------------------------------------------------------


Create models: Employee, EmployeeStatus, Address, Personal, Project, Unit

Take into account the following:

EmployeeStatus should be Enum type
Address should be embedded to Employee object
Relationship between Employee and EmployeePersonalInfo should be one-to-one
Relationship between Employee and Project should be many-to-many
Relationship between Unit and Employee should be one-to-many
Implement Service API which provides:

Create Employee / Unit / Project
Find employee / Unit / Project by id
Delete employee / Unit / Project by id
Update Employee / Unit / Project by id
Add Employee to Unit by id’s
Assign Employee for Project by id’s
