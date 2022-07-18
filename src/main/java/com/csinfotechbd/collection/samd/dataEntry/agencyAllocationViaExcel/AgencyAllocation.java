package com.csinfotechbd.collection.samd.dataEntry.agencyAllocationViaExcel;


import com.csinfotechbd.collection.distribution.loan.loanAccountBasic.LoanAccountBasicInfo;
import com.csinfotechbd.collection.samd.setup.agencySamd.AgencySamdEntity;
import com.csinfotechbd.common.CommonEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "SAM_AGENCY_ALLOCATION")
@Data
public class AgencyAllocation extends CommonEntity {

    private String accountNo;
    private String accountName;
    private String cif;
    private String lln;
    private String dealerId;
    private String agencyName;
    private boolean Latest;

    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private LoanAccountBasicInfo loanAccountBasicInfo;


    @JsonIgnore
    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private AgencySamdEntity agencySamdEntity;
}
