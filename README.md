# 🧪 Automation Exercise Test Cases

An automated UI testing project developed as **Asynchronous Laboratory Activity #2** for **IT Elective 3**. This project uses **Selenium WebDriver** with **TestNG** to automate selected test cases from the Automation Exercise website.

---

## 📌 Project Information

**Project Title:** Automation Exercise Test Cases

**Course:** IT Elective 3 – Asynchronous Laboratory Activity #2

**Target Website:**
https://automationexercise.com/

**Official Test Cases:**
https://automationexercise.com/test_cases

---

## 👥 Members

* Rianne Magtuba
* Rhaniel Dimaguila
* Riyle Lhane Mapanoo

---

## 📖 Project Description

This project demonstrates automated testing of the **Automation Exercise** web application using Selenium WebDriver.

The automation suite executes multiple functional test cases provided by the Automation Exercise website, validating user interactions, page navigation, form submissions, authentication workflows, and other core website functionalities.

The project follows a structured Selenium TestNG framework and generates detailed HTML execution reports after every test run using Extent Reports. The generated report includes execution status, timestamps, screenshots, and step-by-step logs for each executed test case.

---

## 🚀 Technologies Used

* Java
* Maven
* Selenium WebDriver
* TestNG
* Extent Reports
* WebDriverManager
* Visual Studio Code / Visual Studio
* Google Chrome
* uBlock Origin (recommended to minimize advertisements during test execution)

---

## ▶️ Running the Test Project

### Method 1 — Using Maven (Recommended)

Run the entire TestNG suite:

```bash
mvn test -DsuiteFile=testng.xml
```

---

### Method 2 — Using Visual Studio Code

1. Open the project.
2. Navigate to:

```text
src
└── test
    └── java
        └── regression
            └── DemoGuruTestCases.java
```

3. Right-click **DemoGuruTestCases.java**.
4. Select **Run Tests**.
5. Wait for all test cases to finish executing.

---

## 📊 Test Reports

After the test execution is complete, an Extent Report will be automatically generated in the `Reports` folder.

Locate the report file named:

```text
REGRESSION_(browser name).html
```

For example:

```text
REGRESSION_CHROME.html
```

Right-click the report file and select **Open with** → **Google Chrome** (recommended) or any modern web browser.

The report contains:

- ✅ Overall test execution summary
- ✅ Pass/Fail status of each test case
- 🕒 Execution timestamps and duration
- 📝 Detailed step-by-step execution logs
- 📷 Screenshots captured during test execution
- 📊 Interactive Extent Report dashboard

---

##

This repository was created solely for academic purposes as part of the requirements for **IT Elective 3**.
