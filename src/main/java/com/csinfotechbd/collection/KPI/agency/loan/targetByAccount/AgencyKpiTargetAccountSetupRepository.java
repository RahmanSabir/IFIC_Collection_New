package com.csinfotechbd.collection.KPI.agency.loan.targetByAccount;
/*
Created by Monirul Islam at 9/19/2019 
*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyKpiTargetAccountSetupRepository extends JpaRepository<AgencyKpiTargetAccountSetup, Long> {
}
