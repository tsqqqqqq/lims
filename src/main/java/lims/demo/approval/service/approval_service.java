package lims.demo.approval.service;

import lims.demo.approval.lims_approval;
import lims.demo.approval.mapper.approval_mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class approval_service {

        @Autowired
        private approval_mapper approval_mapper;

        public List<lims_approval> list(int pageSize,int pageNow)
        {
            pageNow = (pageNow-1) *pageSize;
            List<lims_approval> lims_approvals = new ArrayList<lims_approval>();
            lims_approvals =approval_mapper.list(pageSize,pageNow);
            return lims_approvals;
        }


        public boolean  updateApproval(lims_approval limsApproval)
        {
            return approval_mapper.updateApproval(limsApproval);
        }

        public lims_approval queryApproval(int approvalId){
            return approval_mapper.queryApproval(approvalId);
        }
}
