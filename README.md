## Running Test Using Maven
This framework was built using Java, Selenium, TestNG and cucumber. 
I also used the page object model. 
I ran these test using chrome locally but it is possible to run these test across multiple browsers and platforms if you have the correct driver. 
I also use my own logger and a config file reader so that these test can be ran in multiple environments, with different parameters. I'm assuming you're going to want to check out my gherkin, the feature file is located in the test resources root directory under features.
Build requires JDK 1.8 or higher but I have version 11 set in the pom file since that is the version i'm using (I also recommend it). If you look at the pom.xml file you can change the Java version under properties.

   #### Step 0 - Installing Maven
The first thing you will need to do is install maven. Check out maven's documentation [here](https://maven.apache.org/install.html).
   #### Step 1 - Clone this Project
Clone this repository to the directory of your choice on your local machine.
   #### Step 2 - Get the appropriate driver executable
Open this project with your favorite IDE. 
In the test resources root directory you will find a package called drivers. 
In order to run these test successfully you will 
need to make sure that you have the right driver for your machine and browser. 
I typically use chrome and I hear this is common practice. Check which version of chrome you have installed on your machine. Download the driver [here](https://chromedriver.chromium.org/home) and add it to the driver.chrome package under resources.
   #### Step 3 - You're ready to run the tests
Open up the command prompt and navigate to the root directory in this project. Try running "mvn clean" then "mvn compile". In order to run the test you will need to run mvn test with two command line arguments.


    -Dselenium.browser=chrome
    -Dwebdriver.chrome.driver ={THE PATH TO THE DRIVER YOU DOWNLOADED}.
Your command should look something like this: 

"mvn test -Dselenium.browser=chrome -Dwebdriver.chrome.driver=$WORKSPACE\src\test\resources\drivers\chrome\chromedriver_Windows.exe". 

If you have a linux or mac you will need to use forward slashes instead of backslashes. 
