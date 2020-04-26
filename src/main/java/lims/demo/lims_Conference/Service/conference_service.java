package lims.demo.lims_Conference.Service;


import lims.demo.lims_Conference.Mapper.conference_mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class conference_service {

    @Autowired
    private conference_mapper conference_mapper;

}
