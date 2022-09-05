package com.coforge.AdminService.ServiceImpl;

import com.coforge.AdminService.Entity.BranchDetails;
import com.coforge.AdminService.Repository.BranchDetailsRepository;
import com.coforge.AdminService.Services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranchServiceImpl implements  BranchService{

    @Autowired
    BranchDetailsRepository branchRepository;
    @Override
    public BranchDetails saveBranch(BranchDetails branch) {
        return branchRepository.save(branch);
    }

    @Override
    public BranchDetails updateBranch(BranchDetails branch) {
        return branchRepository.save(branch);
    }

    @Override
    public Boolean deleteBranch(long branchId) {
        branchRepository.deleteById(branchId);
        return true;
    }
}
