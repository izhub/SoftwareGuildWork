/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbook.dao;

import com.swcguild.addressbook.dto.Address;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class AddressBookDaoDbImpl implements AddressBookDaoInterface {

    private static final String SQL_INSERT_ADDRESS
            = "insert into addresses (first_name, last_name, street, city, state, zip)"
            + "values(?,?,?,?,?,?)";

    private static final String SQL_DELETE_ADDRESS
            = "delete from addresses where address_id = ?";

    private static final String SQL_SELECT_ADDRESS
            = "SELECT * FROM addresses where address_id = ?";

    private static final String SQL_SELECT_ALL_ADDRESSES
            = "SELECT * FROM addresses";

    private static final String SQL_UPDATE_ADDRESS
            = "UPDATE addresses SET first_name = ?, last_name=?, street=?, city=?, "
            + "state=?, zip=? where address_id=? ";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Address addAddress(Address address) {
        jdbcTemplate.update(SQL_INSERT_ADDRESS,
                address.getFirstName(),
                address.getLastName(),
                address.getStreet(),
                address.getCity(),
                address.getState(),
                address.getZip());

        address.setId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        return address;
    }

    @Override
    public void removeAddress(int addressId) {
        jdbcTemplate.update(SQL_DELETE_ADDRESS, addressId);
    }

    @Override
    public void updateAddress(Address address) {
        jdbcTemplate.update(SQL_UPDATE_ADDRESS,
                address.getFirstName(),
                address.getLastName(),
                address.getStreet(),
                address.getCity(),
                address.getState(),
                address.getZip(),
                address.getId());
    }

    @Override
    public List<Address> getAllAddress() {
        return jdbcTemplate.query(SQL_SELECT_ALL_ADDRESSES, new AddressMapper());
    }

    public Address getAddressById(int addressId) {

        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_ADDRESS, new AddressMapper(), addressId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Address> searchAddress(Map<SearchTerm, String> criteria) {
        if (criteria.size() == 0) {
            return getAllAddress();
        } else {
            StringBuilder sQuery = new StringBuilder("select * from address where ");

            //built where clause
            int numParams = criteria.size();
            int paramPosition = 0;
            String[] paramVals = new String[numParams];

            //get paramsa nd start building // this way avoids hacking
            Set<SearchTerm> keySet = criteria.keySet();
            Iterator<SearchTerm> iter = keySet.iterator();
            while (iter.hasNext()) {
                SearchTerm currentKey = iter.next();
                if (paramPosition > 0) {
                    sQuery.append(" and");
                }

                sQuery.append(currentKey);
                sQuery.append(" = ? ");

                paramVals[paramPosition] = criteria.get(currentKey);
                paramPosition++;

            }
            return jdbcTemplate.query(sQuery.toString(), new AddressMapper(), paramVals);
        }
    }

    private static final class AddressMapper implements ParameterizedRowMapper<Address> {

        @Override
        public Address mapRow(ResultSet rs, int i) throws SQLException {
            Address address = new Address();
            address.setId(rs.getInt("address_id"));
            address.setFirstName(rs.getString("first_name"));
            address.setLastName(rs.getString("last_name"));
            address.setStreet(rs.getString("street"));
            address.setCity(rs.getString("city"));
            address.setState(rs.getString("state"));
            address.setZip(rs.getString("zip"));
            return address;

        }

    }

}
