package com.stackroute.springJdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
//import org.springframework.dao;

public class EmployeeDao {
    // Declaration
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

   /* public void createTable()
    {
        String query="create table student(id int,name varchar(20),gender varchar(20),designation String)";
        jdbcTemplate.update(query);
    }*/

    public void insertData()
    {
        String query="insert into employee values(6,'Karthik','male','Data Entry')";
        jdbcTemplate.execute(query);
    }

    // Implementing rowmapper
    public Employee readData()
    {
        String query="select * from employee";
        return jdbcTemplate.queryForObject(query, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
                Employee employee=new Employee();
                employee.setId(resultSet.getInt(1));
                employee.setName(resultSet.getString(2));
                employee.setGender(resultSet.getString(3));
                employee.setDesignation(resultSet.getString(4));
                return employee;
            }
        });
    }

    public void updateDetails()
    {
        String query="update employee set gender='female' where id=1";
        jdbcTemplate.execute(query);
    }

    public void deleteDetails()
    {
        String query="delete from employee";
        jdbcTemplate.update(query);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public DataSource getDataSource() {
        return dataSource;
    }
    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate=new JdbcTemplate(dataSource);
    }
}


