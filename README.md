# Rica Bruinsma's Individual Project

This repository will serve as a portfolio to demonstrate development skills learned through my Madison College Web Software Development degree.

### Problem Statement

Local grocery stores send weekly paper advertisements through the mail, highlighting their weekly sales.  Individual stores have websites that highlight their own sales.  However, there isn't a single web source where this information is aggregated and searchable.

I would like to create a site to demonstrate this for one local grocery store, with the potential to aggregate this data for multiple local grocery stores.  Users would be able to search the site for current sales, as well as login and create their own shopping list of sale items. The site might interface with Google Maps and a local gas price site to help users determine how much they need to save through sales in order to make the trip worthwhile.

### Project Technologies/Techniques 

* Security/Authentication
  * Tomcat's JDBC Realm Authentication
  * Admin role: create/read/update/delete (crud) users and grocery store items
  * User role: create grocery list by store, enter home address to calculate mileage to store, edit data they have entered previously
  * All: anyone can view grocery store sales information (no login)
* Database
  * MySQL
  * Store users and roles
  * Store all data for grocery items and grocery list
  * Store all data for store
* ORM Framework
  * Hibernate 5
* Dependency Management
  * Maven
* Web Services consumed using Java
  * Maybe Google Maps for mileage calculations???
* CSS 
  * Bootstrap
* Data Validation
  * Bootstrap Validator for front end
  * Custom JavaScript code for password verification
  * Servlet function to check database
* Logging
  * Configurable logging using Log4J2. In production, only errors will normally be logged, but logging at a debug level can be turned on to facilitate trouble-shooting. 
* Hosting
  * AWS
* Independent Research Topic/s
  * Google Maps API
  * JSoup - screen scrape
  * Project Lombok to eliminate boilerplate code like getters/setters/equals
* Unit Testing
  * JUnit tests to achieve 80%+ code coverage 
* IDE: IntelliJ IDEA

### Demo Videos of App
[Admin Functions - Search and Delete Items](https://youtu.be/_Ob_h7-vUiM)

[Admin Functions - Search and Delete Stores](https://youtu.be/pt13b98uubI)

[Admin Functions - Search, Edit, and Delete Users](https://youtu.be/OKu3DlIwv9Y)

[Guest Functions - Search Deals and Sign-Up](https://youtu.be/-RGZ2duqkMk)

[Shopper Functions - Search Deals, Shopping List view/edit, password change](https://youtu.be/kWuEFQdcJFU)

[Code Coverage](https://youtu.be/DMHM1LV-3Ug)

[Custom Error Pages](https://youtu.be/poAeakF1m5Q)

[Restricted Access to Shopper and Admin pages](https://youtu.be/N7vx9uZRI9E)

[Validation of Sign-Up form fields](https://youtu.be/NIVTKGRgosA)