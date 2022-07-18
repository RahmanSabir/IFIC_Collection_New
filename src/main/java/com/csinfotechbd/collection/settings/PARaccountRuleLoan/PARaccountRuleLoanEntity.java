package com.csinfotechbd.collection.settings.PARaccountRuleLoan;
/*
Created by Monirul Islam on 7/10/2019 
*/

import com.csinfotechbd.base.BaseInfo;
import com.csinfotechbd.collection.settings.dpdBucket.DPDBucketEntity;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@Table(name = "PAR_ACC_RULE_LOAN")
public class PARaccountRuleLoanEntity extends BaseInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double minDpd;
    private double maxDpd;
//    private double minATE;
//    private double maxATE;

    @NotEmpty(message = "Dpd Bucket can not be empty", groups = PARaccountRuleLoanEntity.class)
    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    List<DPDBucketEntity> dpdBucketEntityList;

    @Transient
    List<String> dpdBucketIds;

    public void setDpdBucketIds(List<String> dpdBucketIds) {
        this.dpdBucketEntityList = dpdBucketIds == null ? null : dpdBucketIds.stream().map(DPDBucketEntity::new).collect(Collectors.toList());
    }
}
