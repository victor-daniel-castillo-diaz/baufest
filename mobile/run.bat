rmdir /s /q allure-results
cmd /c mvn clean test -Dcucumber.filter.tags="@AndroidDemoApp"
allure serve
pause
