# Steps to Execute the test
1. Do a git clone on the project
2. Import Project in eclipse (or any IDE), these steps will follow the steps needed for eclipse
3. General -- Projects from Folder or Archive
4. Right Click on Project and click Maven Update (Configure As Maven Project)
5. Right Click on Project - RunAs - Maven Build... - In Goals type - ```clean install -Pintegration-tests```

```** Assumption the chromedriver which is checked in - is MACOS compatible. Please download the windows compatible file from "https://chromedriver.storage.googleapis.com/index.html?path=87.0.4280.88/" and put it under root folder of project. ** ```

6. Please Note - User First Name, Last Name, email and message are randomGenerated number plus a static text. Phone Number is random generated with no restrictions except being 10 digits.

## How can this test be extended? ##
1. This Automation test can have - a separate Element Locator storing like in DB
2. The Wrapper methods around selenium can be published as a library and then consumed by StepDefinition project
3. Selenium methods could have smart waits not hard waits. Can be extended to Alerts, Actions etc.
4. Tests can be parameterized to have the data coming from scenario examples or Json or Excel file
5. Tests can have multiple profiles set up in pom.xml - targeting SMOKE and regression and feature saggregation tests
6. Tests can support multiple browsers - like Firefox, Safari etc.
7. Tests can have better reporting including screenshots at failure 
8. Tests can have better logging 
9. Tests can be integrated with the Test Management Tool to publish automation results


## How else could this feature be tested? ##

1. Test Live Video Tour
2. Test for Mandatory Fields and leave out optional fields to check how UI behaves
3. Check the Max and Minimum character length on UI input boxes
4. Enter a date which isn't available for booking
5. Verify the 'Terms of Use' and 'Privacy' Link content.
6. Verify static texts, usability features, headings if needed. Create negative tests to verify errors like 'Last name is required'
7. What happens when all the appointments are booked.
8. User gets an email with confirmation
9. Button is disabled until all the required fields are set.
10. Checking for cancel button functionality for iframes.
11. ** Verify Remaining navigation buttons - Self-GUided Tour, View Photos, Prices/Availability and functionalities **



## What assumptions did you make when writing this test? ##
1. Tests running on chrome, user is not running it in headless mode. No additional capabilities were defined.
2.
2. User is booking In-person Tour
3. User will always pick 2 days from today as an appointment date
4. User is picking second available time from dropdown
5. The test verification at the end is always the same text ""
6. User will not check email for confirmation
7. Implemented BDD, created Featur File and Step definition. Used Maven as a build/dependency management tool.


## How could this test be integrated into a CI/CD pipeline? ##
1. Create a jenkins downstream job to Build Job deploying UI code (wait for the service to be health and running)
2. Use Git plugin under SCM section to be connected to Git Hub repository
3. Configure jenkins slave to have java 1.8 or higher
4. Add Build Step-- Invoke Top Level Maven Target -- In Goals input box and enter the Goal.
5. Publish Results
6. Send required emails to stakeholders
7. Keep history limited to 10 or 20 
8. Integrate with Test Management Framework to report/update results.
