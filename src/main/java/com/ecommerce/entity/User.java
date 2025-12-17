package com.ecommerce.entity;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;      
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@entity                       // Entity annotation 
@Table(name = "users")        // Table mapping annotation which means this class is mapped to "users" table in the database
public class User implements UserDetails {  //UserDetails interface implementation
    //Attributes

    @id                       // Primary key annotation
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // Auto-increment strategy
    private Long id;            //First attribute
    
    @NotBlank(message = "Username is mandatory")  //It cannot be blank
    @Size(min = 3, mxa = 50, message = "Username must be between 3 and 50 characters") // Size constraint if failed it will show the message
    @Column( nullable = false, unique = true)     //nullable means this column cannot be null, unique means no two users can have the same username  
    private String username; 
    
    @NotBlank(message = "Email is mandatory") //Validation annotation
    @Email(message = "Email should be valid") // Email format validation which means the email should be in proper format .
    @Column( nullable = false, unique = true) //nullable means this column cannot be null, unique means no two users can have the same email.
    private String email;                     //If we want different column name for database we can use name attribute in @Column annotation.
    
    @NotBlank(message = "Password is mandatory")   //Validation annotation
    @Size(min = 6, message = "Password must be at least 6 characters long") // Size constraint
    @Column( nullable = false)                     //nullable means this column cannot be null
    private String password;
    
    @NotBlank(message = "First name is mandatory") //Validation annotation
    @Column( name="first_name" nullable = false)   //nullable means this column cannot be null
    private String firstName;

    @NotBlank(message = "Last name is mandatory") //Validation annotation
    @Column( name="last_name" nullable = false)   //nullable means this column cannot be null
    private String lastName;

    Column( name="phone_number")  //Since it is in camelcase we are giving different column name in the database because in the 
    private String phoneNumber;   // database we are using snake_case convention
    
    @Column(name = "created_at", nullable = false, updatable = false) // Column to store creation timestamp, not updatable
    private LocalDateTime createdAt;  // Attribute to store the creation timestamp

    @Column(name = "updated_at") // Column to store last update timestamp
    private LocalDateTime updatedAt;  // Attribute to store the last update timestamp
    
    @Enumerated(EnumType.STRING) //indicates that the Role enum should be stored as a string in the database
    @Column( nullable = false)   //nullable means this column cannot be null
    private Role role = Role.USER; //Role is an enum defined below, default role is USER

    //Constructors
    public User() { //Default constructor , if no constructor is defined Java provides a default constructor... 
        this.created_at = LocalDateTime.now();
        this.updated_at = LocalDateTime.now();
    }
    
    //Constrcturs for sign up page...
    public User(String username, String email, String password, String firstName, String lastName) {
        this.(); //calls the above constructor, for createdAt and updatedAt...
        this.username = username;  //this keyword is used to refer to the current object's attribute   
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    }
    
    //Getters and Setters
    
    

    public enum Role {  //enum is a special data type that enables for a variable to be a set of predefined constants.
        USER,
        ADMIN
    }   //Keep the enum bottom of the class

    

}