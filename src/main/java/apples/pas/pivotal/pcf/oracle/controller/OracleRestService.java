package apples.pas.pivotal.pcf.oracle.controller;

import apples.pas.pivotal.pcf.oracle.domain.Dept;
import apples.pas.pivotal.pcf.oracle.domain.Emp;
import apples.pas.pivotal.pcf.oracle.service.OracleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OracleRestService
{
    @Autowired
    OracleService oracleService;

    @RequestMapping(value = "/alldeps", method = RequestMethod.GET)
    public List<Dept> allDeps()
    {
        return oracleService.getAllDeps();
    }

    @RequestMapping(value = "/allemps", method = RequestMethod.GET)
    public List<Emp> allEmps()
    {
        return oracleService.getAllEmps();
    }
}
