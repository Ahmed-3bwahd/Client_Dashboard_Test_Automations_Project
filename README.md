# Client Dashboard Automation Project



This project contains automated UI tests for the Rahul Shetty Academy Client Dashboard web application. The tests validate core user flows such as login, product selection, cart operations, checkout, and payment.



---



## Tech Stack



- Java 26  

- Selenium WebDriver 4.45.0  

- TestNG 7.12.0  

- WebDriverManager 6.3.4  

- Allure TestNG 2.35.4  

- AspectJ Weaver 1.9.25.1  



---



## Project Structure



src

├── main

│    └── java

└── test

├── java

│    └── com.rahul.academy.client.dashboard

│         ├── base

│         ├── config

│         ├── factory

│         ├── pages

│         ├── testcases

│         └── utils

└── resources





- base → BaseTest, BasePage  

- factory → WebDriver initialization  

- pages → Page Object Model  

- testcases → Test classes (Login, Dashboard, Cart, Payment)  

- utils → Waits, config reader, properties loader  



---



## How to Run Tests



Run the TestNG suite using Maven: mvn clean test


The suite file used: src/test/resources/testng.xml



---


## Browser Selection



Default browser: Chrome



To run with Firefox: mvn clean test -Dbrowser=FIREFOX


---


## Configuration



Test data and environment values are stored in:


src/test/java/com/rahul/academy/client/dashboard/config/production.properties


Loaded through `ConfigUtils`.


---



## Screenshots



After each test, a screenshot is saved to:



target/screenshots/



Screenshots are also attached to Allure reports.

---


## Allure Reporting


Generate and view the report:


allure serve target/allure-results


---


## Application Under Test


URL:  https://rahulshettyacademy.com/client/#/auth/login





















