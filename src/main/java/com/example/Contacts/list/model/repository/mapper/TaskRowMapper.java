package com.example.Contacts.list.model.repository.mapper;

import com.example.Contacts.list.model.Contact;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskRowMapper implements RowMapper<Contact> {
    @Override
    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
        Contact contact = new Contact();
        contact.setId(rs.getLong(Contact.Fields.id));
        contact.setName(rs.getString(Contact.Fields.name));
        contact.setLastName(rs.getString(Contact.Fields.lastName));
        contact.setPhoneNumber(rs.getString(Contact.Fields.phoneNumber));
        return contact;
    }
}
