<b>Steps to run tests on EPAM Mobile Cloud</br>
<b>1.</b> Paste your EPAM Mobile Cloud API Key into "src/test/resources/cloudTest.properties" file. <br>
<b>2.</b> Manually install android (src/main/resources/EPAMTestApp.apk) or iOS (src/main/resources/EPAMTestApp1.ipa) app onto the targeted devices. <br> 
devices specified in xml files: <br>
android device's udid: "0A211JEC222740"  <br>
iOS device's udid: "3e50758dd2e1179a014ee7b51dc4285d73118107"<br>
<b>3. </b>Run tests:

1. Run Cloud Native Android test via command line: mvn clean test -P cloudNativeAndroid
2. Run Cloud Web Android test via command line: mvn clean test -P cloudWebAndroid
3. Run Cloud Native iOS test via command line: mvn clean test -P cloudNativeiOS
4. Run Cloud Web iOS test via command line: mvn clean test -P cloudWebiOS

<b>Native test: </b>

1. <b>newAccountRegistrationTest</b> - Make sure that after registering a new user and logging in we are on a BudgetActivity page.

<b>Web test: </b>
1. <b>googleSearchTest</b> - Make sure that we have relevant search result via Google search (non-empty list and result contains text "EPAM").
