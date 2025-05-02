package com.project.hamroschool.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ContactRowMapper implements RowMapper<Contact> {

    @Override
    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
        Contact contact = new Contact();

        // Mapping the columns to the Contact object
        contact.setContactId(rs.getInt("contact_id"));
        contact.setName(rs.getString("name"));
        contact.setMobileno(rs.getString("mobile_no"));
        contact.setEmail(rs.getString("email"));
        contact.setSubject(rs.getString("subject"));
        contact.setMessage(rs.getString("message"));
        contact.setStatus(rs.getString("status"));
        contact.setCreatedby(rs.getString("createdd_by"));

        // Handling the nullable fields for timestamps
        contact.setCreatedat(rs.getTimestamp("creater_at") != null ? rs.getTimestamp("creater_at").toLocalDateTime() : null);
        contact.setUpdatedby(rs.getString("updated_by"));

        // Handling nullable updated_at
        contact.setUpdatedat(rs.getTimestamp("updated_at") != null ? rs.getTimestamp("updated_at").toLocalDateTime() : null);

        return contact;
    }
}
