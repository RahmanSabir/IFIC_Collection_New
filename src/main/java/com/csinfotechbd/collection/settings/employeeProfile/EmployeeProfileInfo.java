package com.csinfotechbd.collection.settings.employeeProfile;
/*
Created by Monirul Islam at 7/23/2019 
*/


import com.csinfotechbd.base.BaseInfo;
import com.csinfotechbd.collection.settings.jobRole.JobRoleEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
public class EmployeeProfileInfo extends BaseInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long employeePin;
    private String employeeName;
    private String userId;
    private String password;
    private String ipAddress;
    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private List<JobRoleEntity> jobRoleEntity = new ArrayList<>();

    @Transient
    private List<Long> selectedRole = new ArrayList<>();

    public void setSelectedRoleFromJobRoleEntities(){
        jobRoleEntity.forEach(role -> selectedRole.add(role.getId()));
    }

    public void setJobRoleEntitiesFromSelectedIds(){
        jobRoleEntity = selectedRole.stream()
                .map(JobRoleEntity::new).collect(Collectors.toList());
    }
}
