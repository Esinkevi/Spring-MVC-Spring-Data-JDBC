package com.example.Contacts.list.model.repository;

import com.example.Contacts.list.model.Contact;
import com.example.Contacts.list.model.repository.mapper.TaskRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.ArgumentPreparedStatementSetter;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
@Primary
@RequiredArgsConstructor
@Slf4j
public class DataBaseContactRepository implements ContactRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Contact> findAll() {
        log.info("DataBaseContactRepository call findAll");

        String sql = "SELECT * FROM contacts_schema.contact";

        return jdbcTemplate.query(sql, new TaskRowMapper());
    }

    @Override
    public void saveOrUpdateContact(Contact contact) {
        log.info("DataBaseContactRepository call saveOrUpdateContact");
        Contact existedContact = findById(contact.getId()).orElse(null);
        if (existedContact == null) {
            contact.setId(System.currentTimeMillis());
            String sql = "INSERT INTO CONTACT(name, lastName, phoneNumber, id) VALUES(?, ?, ?, ?)";
            jdbcTemplate.update(sql, contact.getName(), contact.getLastName(),
                    contact.getPhoneNumber(), contact.getId());
        } else {
            String sql = "UPDATE contact SET name = ?, lastName = ?, phoneNumber = ? WHERE id = ?";
            jdbcTemplate.update(sql, contact.getName(), contact.getLastName(),
                    contact.getPhoneNumber(), existedContact.getId());
        }

    }

    @Override
    public void deleteContactById(Long id) {
        log.info("DataBaseContactRepository call deleteContactById" + id);
        String sql = "DELETE FROM contact WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Optional<Contact> findById(Long id) {
        log.info("DataBaseContactRepository call findById {}", id);
        String sql = "SELECT * FROM contact WHERE id = ?";
        Contact contact = DataAccessUtils.singleResult(
                jdbcTemplate.query(
                        sql,
                        new ArgumentPreparedStatementSetter(new Object[]{id}),
                        new RowMapperResultSetExtractor<>(new TaskRowMapper(), 1)
                )
        );
        return Optional.ofNullable(contact);
    }

    @Override
    public void bachInsert(List<Contact> contacts) {
        log.info("DataBaseContactRepository call bachInsert");

        String sql = "INSERT INTO contacts_schema.contact(name, lastName, phoneNumber, id) VALUES(?, ?, ?, ?)";

        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Contact contact = contacts.get(i);
                ps.setString(1, contact.getName());
                ps.setString(2, contact.getLastName());
                ps.setString(3, contact.getPhoneNumber());
                ps.setLong(4, contact.getId());
            }

            @Override
            public int getBatchSize() {
                return contacts.size();
            }
        });
    }
}
