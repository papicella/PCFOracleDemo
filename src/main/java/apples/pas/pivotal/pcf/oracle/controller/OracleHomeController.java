package apples.pas.pivotal.pcf.oracle.controller;

import apples.pas.pivotal.pcf.oracle.service.OracleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OracleHomeController
{
    @Autowired
    OracleService oracleService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) throws Exception
    {
        model.addAttribute("employees", oracleService.getAllEmps());

        return "employees";
    }
}
