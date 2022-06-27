# Baufest automation
Web testing framework

## Prerequisites

+ Java Development Kit 17.0.2
+ Maven 3.8.5

## Dependencies

+ JUnit 4.13.1
+ Cucumber 6.0.0
+ Selenium 3.141.59 
+ Allure 2.13.8

## Features

✅ Page Object design pattern for enhancing test maintenance and reducing code duplication
✅ Behavior-driven development with Gherkin
✅ Allure Test report integrated with Cucumber


## Allure install

Open a PowerShell terminal version 5.1 or later and run to install Scoop

`Set-ExecutionPolicy RemoteSigned -Scope CurrentUser`

`iwr -useb get.scoop.sh | iex` 

For install Allure run

`scoop install allure`


## Chrome Driver install

Find the Chrome version in ⋮ > Help > About Google Chrome and download the right version of  ChromeDriver for your platform from https://chromedriver.chromium.org/downloads 

Extract the chromedriver executable and copy it to the /resources folder of the project


## Usage

The scrip `run.bat` is provided to run on Windows systems.



