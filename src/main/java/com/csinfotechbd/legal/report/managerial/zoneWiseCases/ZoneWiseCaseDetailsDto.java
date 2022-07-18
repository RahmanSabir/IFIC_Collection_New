package com.csinfotechbd.legal.report.managerial.zoneWiseCases;

import lombok.Data;

import javax.persistence.Tuple;
import java.util.Objects;
import java.util.Optional;

@Data
public class ZoneWiseCaseDetailsDto {

    private String branchName;
    private String accountNumber;
    private String caseType;
    private String caseNumber;
    private String courtName;
    private double suitValue;

    public ZoneWiseCaseDetailsDto(){
    
    }
    
    public ZoneWiseCaseDetailsDto(Tuple data){
        branchName = Objects.toString(data.get("BRANCH_NAME"), "-");
        accountNumber = Objects.toString(data.get("ACCOUNT_NUMBER"), "-");
        caseType = Objects.toString(data.get("CASE_TYPE"), "-");
        caseNumber = Objects.toString(data.get("CASE_NUMBER"), "-");
        courtName = Objects.toString(data.get("COURT_NAME"), "-");
        suitValue = ((Number) Optional.ofNullable(data.get("SUIT_VALUE")).orElse(0)).doubleValue();
    }
}
