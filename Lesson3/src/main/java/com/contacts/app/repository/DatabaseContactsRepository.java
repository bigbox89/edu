package com.contacts.app.repository;

import com.contacts.app.entity.Contact;
import com.contacts.app.exception.ContactNotFounExeception;
import com.contacts.app.repository.mapper.ContactRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.ArgumentPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
@RequiredArgsConstructor
@Slf4j
public class DatabaseContactsRepository implements ContactRepository{

    private final JdbcTemplate jdbcTemplate;
    @Override
    public Contact save(Contact contact) {
        log.debug("Calling DatabaseContactsRepository.save()");
        contact.setId(System.currentTimeMillis());
        String sql = "INSERT into contacts (id, \"firstName\", \"lastName\", email, phone) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, contact.getId(), contact.getFirstName(), contact.getLastName(), contact.getEmail(), contact.getPhone() );
        return  contact;
    }

    @Override
    public Contact update(Contact contact) {
        log.debug("Calling DatabaseContactsRepository.update()");
        Contact existtedContatct = findById(contact.getId()).orElse(null);
        if(existtedContatct != null){
            String sql = "UPDATE contacts SET \"firstName\" = ?, \"lastName\" = ?, email = ?, phone = ? WHERE id = ?";
            jdbcTemplate.update(sql, contact.getFirstName(), contact.getLastName(), contact.getEmail(), contact.getPhone(), contact.getId());

            return  contact;
        }
        log.warn("Contact with id not found ID = " + contact.getId());
        throw  new ContactNotFounExeception("Contact with id not found ID =" + contact.getId());
    }

    @Override
    public Optional<Contact> findById(Long id) {
        log.debug("Calling DatabaseContactsRepository.findById()");
        String sql = "SELECT * FROM contacts where id = ?";
        Contact contact = DataAccessUtils.singleResult(
                jdbcTemplate.query(
                        sql,
                        new ArgumentPreparedStatementSetter(new Object[] {id}),
                        new RowMapperResultSetExtractor<>(new ContactRowMapper(), 1)
                )
        );
        return Optional.ofNullable(contact);
    }


    @Override
    public List<Contact> findAll() {
        log.debug("Calling DatabaseContactsRepository.findAll()");
        String sql = "SELECT * FROM contacts";
        return jdbcTemplate.query(sql, new ContactRowMapper());
    }

    @Override
    public void deleteById(Long id) {
        log.debug("Calling DatabaseContactsRepository.deleteById()");

        String sql = "DELETE FROM contacts WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

}
