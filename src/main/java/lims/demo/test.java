package lims.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {

    @Autowired
    private RDStest rdstest;


    @RequestMapping("/show")
    public String RDSTest()
    {
        System.err.println("已执行到此处");
        String rds=rdstest.selectadmin();
        System.out.println("rds"+rds);
        return rds;
    }
}
