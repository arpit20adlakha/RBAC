**Usage**
 1. Run `mvn clean compile exec:java` in the application directory
 1. The following commands are available
    * `add user_id [role_name ....]` 
        eg. `add sankar engineer`
    * `checkrole user_id resource action`
        eg `checkrole sankar github write`
    * `remove user_id [role_name ...]` 
        eg `remove sankar engineer`
        
 1. To run tests `mvn clean test`
 
**Files**
1. resources/role_mappings.json
    * Contains the mapping to role to <resource and action> pair
    * Available roles
        * engineer
        * manager
        * hr
        * marketing
    * Available resources
        * github
        * aws
        * payroll
        * analytics
    * Available actions
        * READ
        * WRITE
        * UPDATE
        * DELETE
    

1. CLI
    * Class responsible for reading the input and parsing it

1.  app/RBAC
    * The bussiness logic 
 
1. RolesDAO, UserDAO
    * Interface for accessing the persistence layer

 
 
**Libraries used**
 1. [Immutables](https://immutables.github.io/)
    * A annotation processor used for creating immutable data objects. It creates builder class as
    well. 
    
**Maven plugins**
 1. maven-jar-plugin
    * To create jar and to start the main class 
 1. exec-maven-plugin
    * For executing the application