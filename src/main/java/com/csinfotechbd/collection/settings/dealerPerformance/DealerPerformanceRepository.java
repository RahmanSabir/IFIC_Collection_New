package com.csinfotechbd.collection.settings.dealerPerformance;

import com.csinfotechbd.collection.settings.employee.EmployeeInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
Created by Monirul Islam at 8/28/2019 
*/
@Repository
public interface DealerPerformanceRepository extends JpaRepository<DealerPerformance, Long> {
    List<DealerPerformance> findAllByEmployeeInfoEntityNotIn(List<EmployeeInfoEntity> dealer);
}
