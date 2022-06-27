rmdir /s /q allure-results
cmd /c mvn clean test -Dcucumber.filter.tags="@BFST-01"
allure serve
pause
