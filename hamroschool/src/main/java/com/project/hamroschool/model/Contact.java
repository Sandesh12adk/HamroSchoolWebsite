package com.project.hamroschool.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class Contact extends BaseEntity{
    private int contactId;
    private String name;
    @Size(min= 10, max =10, message = "contact must be 10 digits")
    @NotEmpty(message = "Contact is missing")
    private String mobileno;
    @NotEmpty(message = "Message is missing")
    @Size(min=15, message="Message must be atleast 15 characters")
    private  String message;
    @NotEmpty(message = "Subject is missing")
    private String subject;
    @NotEmpty(message = "Email is missing")
    @Email(message = "Please provide the valid email address")
    private String email;
    // Above all the fields are coming from the ui now other columens
    // in the mysql table are managed through the code
   // private int contactid;
    private String status;
/*
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", mobileno='" + mobileno + '\'' +
                ", message='" + message + '\'' +
                ", subject='" + subject + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

 */
}
