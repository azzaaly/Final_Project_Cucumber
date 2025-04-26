Cucumber Automation Framework
This project contains automated test scripts for an e-commerce web application using the Cucumber framework. It covers key flows such as signup, login, product addition and cart management.
🧰 Tools and Technologies Used
- Java – Programming language
- Selenium WebDriver – Browser automation
- Cucumber – BDD framework for writing test scenarios
- Maven – Build and dependency management
- Page Object Model (POM) – For clean separation of test logic and UI elements
- WebDriverManager – Automatic management of browser drivers
- Allure / Extent Reports – For test result reporting (optional)
📂 Project Structure
- `features/` – Contains feature files written in Gherkin syntax
- `stepdefinitions/` – Glue code for feature files and Hooks
- `pages/` – Page Object Model classes like Signup Page, Login Page, Product Page, Cart Page, etc.
- `runners/` – Test runner files 
src
├── main
│   └── java
│       └── pages              # Page Object classes (LoginPage, HomePage, ProductPage, CartPage, etc.)
│
├── test
│   ├── java
│   │   ├── stepDefinitions    # Step definitions linked to feature files, Hooks
│   │   └── runners            # Test runner classes
│   └── resources
│       └── features           # Feature files written in Gherkin
📂 Feature Files

Feature files include test scenarios written in Gherkin syntax. Examples:

Signup. Feature – Validates login with correct and incorrect credentials

EndToEnd.feature – Covers the complete flow: login → add product → checkout



✅ End-to-End Test Coverage
-Sign-up to website
- Login to website
- Add products to cart
- Verify cart contents and total
- Checkout and validate success message
▶️ How to Run the Tests
### Prerequisites:
- Java 8+ installed
- Maven installed
- IDE like IntelliJ or Eclipse
- Chrome browser installed
### Setup Instructions:
1. Clone the repository:
   git clone https://github.com/azzaaly/Final_Project_Cucumber/
   cd your-repo-name
2. Run the tests using Maven:
   mvn test

