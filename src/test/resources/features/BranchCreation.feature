Feature: Create Branch

  @createBranch
  Scenario: As an admin i should be able to create branch
    Given the admin navigates to Supply Sync login page
    When the admin enters email, password and clicks login button
    When admin navigates to Branches
    When admin clicks the create branch button
    Then admin enters required information and press create button