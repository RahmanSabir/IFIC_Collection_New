package com.csinfotechbd.collection.samd.setup.approvalLevel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprovalLevelRepository extends JpaRepository<ApprovalLevel, Long> {

}
