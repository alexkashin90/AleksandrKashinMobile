<b>Steps to run tests</b>

1. Run Native tests via command line: mvn clean test (native tests are set by default)
2. Run Web test via command line: mvn clean test -P web

<b>Native tests: </b>

1. <b>newAccountRegistrationTest</b> - Make sure that after registering a new user and logging in we are on a BudgetActivity page.
2. <b>registrationActivityCheckBoxTest</b> - Make sure that checkbox on Registration page acts properly (test should fail).
Bugs found: checkbox is not clickable and has misspells in its text.

<b>Web test: </b>
1. <b>googleSearchTest</b> - Make sure that we have relevant search result via google search (non-empty list and result contains text "EPAM").
