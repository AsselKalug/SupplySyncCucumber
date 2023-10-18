Feature: LogOut

  @logOut
  Scenario: As an admin i should be able to log out
    Given the admin navigates to Supply Sync login page
    When the admin enters email, password and clicks login button
    When the admin clicks on Administrator
    Then admin able to log out