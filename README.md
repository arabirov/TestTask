#Test task for ZOOM QA Automation
UI tests for Google form. 
URL - https://docs.google.com/forms/d/e/1FAIpQLScNx9xK2LM-G3Z3fJXOQapiSK1IAoNXc_67MyS-soTfhDXotA/viewform. 

##Project description
Tests are separated for different browser.

List of supported browsers and classes for them:
- ChromeNavigationTest for Google Chrome;
- FirefoxNavigationTest for Mozilla Firefox;
- IENavigationTest for Internet Explorer;

Class "Constants" contains all elements that would be used in tests. "GoogleFormNavigation" contains all test logic. 
"AbstractNavigationTest" is abstract class used for starting actions, containing in "GoogleFormNavigation". 

##Built with
Built with Maven. Requires at least Java 1.8.