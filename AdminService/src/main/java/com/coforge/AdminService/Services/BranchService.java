package com.coforge.AdminService.Services;

import com.coforge.AdminService.Entity.BranchDetails;

public interface BranchService {

    BranchDetails saveBranch(BranchDetails branch);

    BranchDetails updateBranch(BranchDetails branch);

    Boolean deleteBranch(long branchId);


}
