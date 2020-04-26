package lims.demo.lims_Conference.Controller;


import lims.demo.Base.SysJson;
import lims.demo.lims_Conference.Service.conference_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class conference_controller {

    @Autowired
    private conference_service conference_service;

    private SysJson sysJson = new SysJson();
}
