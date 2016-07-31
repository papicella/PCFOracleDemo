package apples.pas.pivotal.pcf.oracle.service;

import apples.pas.pivotal.pcf.oracle.domain.Dept;
import apples.pas.pivotal.pcf.oracle.domain.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OracleService
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Dept> getAllDeps()
    {
        List<Dept> deps = jdbcTemplate.query("select * from dept", new BeanPropertyRowMapper<Dept>(Dept.class));

        return deps;
    }

    public List<Emp> getAllEmps()
    {
        List<Emp> emps = jdbcTemplate.query("select * from emp", new BeanPropertyRowMapper<Emp>(Emp.class));

        return emps;
    }
}
