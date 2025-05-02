package com.project.hamroschool.repository;

import com.project.hamroschool.model.Constants;
import com.project.hamroschool.model.Contact;
import com.project.hamroschool.model.ContactRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@Repository
public class ContactRepository {
    private final JdbcTemplate jdbctemplate;
    @Autowired
    public ContactRepository(JdbcTemplate jdbcTemplate){
        this.jdbctemplate= jdbcTemplate;
    }

    //To sotre the Data into the database
    public int StoretoDataBase(Contact contact) {

        String sql = "INSERT INTO contact_msg (name, mobile_no, email, subject, message, status, creater_at, createdd_by) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        return jdbctemplate.update(sql,
                contact.getName(),
                contact.getMobileno(),
                contact.getEmail(),
                contact.getSubject(),
                contact.getMessage(),
                contact.getStatus(),
                contact.getCreatedat(),
                contact.getCreatedby()
        );
    }
    // To extract the data from the database
    public List<Contact> findMessagesWithOpenStatus(String status){
        String sql= "SELECT * FROM contact_msg WHERE status= ?";
        return jdbctemplate.query(sql, (PreparedStatement ps) -> {
            ps.setString(1, status);
        }, new ContactRowMapper());
    }
    // To updata the Database
    public int closeMsgInDataBase(int contactId){
        String sql="UPDATE contact_msg SET status=? where contact_id= ?";
       return jdbctemplate.update(sql, Constants.CLOSE,contactId);
    }
    }