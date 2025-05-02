package com.project.hamroschool.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.apache.logging.log4j.message.Message;

@Entity
@Table(name="holidays")
public class Holiday {
    @Id
    @Column(name="Day") // Hibernate
    @NotBlank(message = "Enter the day")
    private String  day;

    @Column(name="Reason")
    @NotBlank(message = "Enter the Reason")
    private String reason;

    @Column(name="Type")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Enter the Type")
    private Type type;

    public enum Type {
        federal, festival, other
    }

    public Holiday(String day, String reason, Type type) {
        this.day = day;
        this.reason = reason;
        this.type = type;
    }

    // Default constructor for Hibernate (needed for object instantiation)
    public Holiday() {
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Holiday{" +
                "day='" + day + '\'' +
                ", reason='" + reason + '\'' +
                ", type=" + type +
                '}';
    }
}
