package sg.edu.nus.iss.vttp5_day18l.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

// Model class to represent session data
public class SessionData {

    // Name field with validation: cannot be empty and max 20 characters
    @NotEmpty(message = "Name is mandatory")
    @Size(max = 20, message = "Max 20 characters")
    private String name;

    // Date of birth field with validation: must be a past date
    @Past(message = "Date of Birth must be in the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd") // Format for binding date input
    private Date dob;

    // Default constructor
    public SessionData() {
    }

    // Constructor with parameters for easy initialization
    public SessionData(String name, Date dob) {
        this.name = name;
        this.dob = dob;
    }

    // Getters and setters for the name field
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getters and setters for the dob field
    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    // Override toString() for debugging purposes
    @Override
    public String toString() {
        return name + ", " + dob;
    }
}
