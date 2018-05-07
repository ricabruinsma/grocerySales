# Project Plan

### Week 2:
- [X] First Draft of Problem Statement
- [X] Create project repository in GitHub
- [X] Create project structure in intellij and push to GitHub
- [X] Add link to list of indie projects in student repo

### Week 3:
- [X] Complete Problem Statement.
- [X] Design project plan 
- [X] Create initial screen design / wireframes
- [X] First draft of database design
- [X] Journal
- [X] Triple-check for Checkpoint 1: problem statement
- [X] Triple-check for Checkpoint 1: project plan
- [X] Triple-check for Checkpoint 1: Screen Design
- [X] Triple-check for Checkpoint 1: Time log

### Week 4: Hibernate, DAOs
- [X] Hibernate
- [X] DAOs
- [X] Create User entity class and annotate for hibernate
- [X] Create User dao
- [X] Create User dao unit tests (test database?)
- [X] Create User table
- [X] Set up logging with log4j
- [X] Journal
- [X] Review and incorporate feedback from checkpoint 1
- [X] Research APIs and/or screen scrape technology

### Week 5: Hibernate
- [X] Prepare for week 6 Design Review
- [X] Journal

### Week 6: AWS Deployment
- [X] Complete database design
- [X] Create class uml diagram
- [X] Design Review
- [X] Add role table to db
- [X] Add store table to db
- [X] Add item table to db
- [X] Add shoppingList table to db
- [X] Add listLine table to db
- [X] Journal

- [X] Triple check checkpoint 2: database designed and created
- [X] Triple check checkpoint 2: at least one DAO implemented with Hibernate
- [X] Triple check checkpoint 2: DAO is unit tested 
- [X] Triple check checkpoint 2: Log4J is implemented
- [X] Triple check checkpoint 2: Class design and other diagrams created

### Week 7: Security Authentication
- [X] Set up authentication locally
- [X] Add role entity and annotate for hibernate
- [X] Create Generic DAO
- [X] Continue screen scrape research
- [X] Review and Incorporate feedback from checkpoint 2
- [X] Journal

### Week 8: Web Services (SOAP) 
- [X] Deploy to AWS for first time
- [X] Create db on AWS
- [X] Create relationships between tables 
- [X] Set up authentication on AWS

- [X] Sign up for team project
- [X] Journal
- [X] Triple check checkpoint 3: Deployed to AWS
- [X] Triple check checkpoint 3: at least one JSP that displays data from database
- [X] Triple check checkpoint 3: Authentication implemented

### Week 9: REST
- [X] Continue screen scrape research & begin trials
- [X] Team repository created
- [X] Review and incorporate feedback from checkpoint 3
- [X] Journal

### Week 10 - work week
- [X] Team Project work items
- [X] Add role dao unit tests
- [X] Journal


### Week 11: Multithreading
- [X] Finalize Team Project
- [X] Present Team Project
- [X] Journal

### Week 12
- [X] Review rubric
- [X] Journal

### Week 13: Asynchronous Messaging
- [X] Create store entity and annotate for hibernate
- [X] Create item entity and annotate for hibernate
- [X] Create shoppinglist entity and annotate for hibernate

- [X] Create store dao unit tests
- [X] Create item dao unit tests
- [X] Create shoppinglist dao unit tests

- [X] Pick website template

- [X] Journal

### Week 14
- [X] Create listline entity and annotate for hibernate
- [X] Create listline dao unit tests

- [X] Create JSP templates using bootstrap
- [X] specific search form and controllers for admin (items, users, stores)
- [X] <%@include  when including a file within the include  --> OK to use
- [X] Validate User-entered data (not empty)
- [X] Logout function
- [X Validating user-entered data?
- [X] Code Reviews
- [X] Journal


### Week 15
- [X] Error 403/500/etc not getting picked up  --> use correct address in web.xml
- [X] check for new user sign-up --> username not already in use.
- [X] Create Welcome/Landing JSP (includes deal search, login, sign-up a new user)
- [X] Add category table, change to category_id in item table
- [X] CategoryDAO and unit tests +  update Item unit tests (and others...)
- [X] Create Admin JSP to CRUD users (including roles)
- [ ] Stores - add & delete
- [ ] Items - delete
- [ ] Category - add & delete
- [ ] Create Logged-in user JSP to view/edit user info, edit/delete shoppingList info, deal search
- [X] Implement API to populate deal search results
- [ ] Create Deal Search Results JSP, including ability to add to ShoppingList, if logged in.

- [ ] Test relationships
- [ ] Carefully review code for standards and best practices
- [ ] Unit test all relationships
- [ ] Go through all feedback from previous checkpoints & peer reviews
- [ ] Code quality check

- [ ] Ensure full application is functional
- [ ] Final documentation
- [ ] Create final presentation
- [ ] Journal

### Week 16
- [ ] Present to class
- [ ] Create video recording - walking through application
- [ ] Final touches before code complete
- [ ] Journal

- [ ] update AWS DB for items - category
- [ ] update ERD diagram
- [ ] login doesn't route user to their page - only after bounced back from "no admittance"
- [ ] comment back in error pages, create more if time!

- [ ] Update time log/journal

- [ ] When unit testing your entities, test the relationships too.
- [ ] Add custom error pages and a login page that reflects the look and feel of your site. The error page should hide any stack trace information which can reveal information about your site and db that should not be shared.
- [ ] Javadoc - remember there's a plugin for this
- [ ] Be sure to remove any duplicate code - this means using the generic dao, for example.
- [ ] Address and close any open issues
- [ ] Use properties rather than hard-coded values, like web service urls.
- [ ] Update your web.xml with regard to restricted resources. Remember that both jsps and servlets should be restricted (not just the jsps as a savvy user/hacker will try to access the servlets too).
