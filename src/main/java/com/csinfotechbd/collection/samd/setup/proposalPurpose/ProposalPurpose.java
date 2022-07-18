package com.csinfotechbd.collection.samd.setup.proposalPurpose;

import com.csinfotechbd.common.CommonEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter @Setter
@Table(name = "lms_collection_sam_proposal_purpose")
public class ProposalPurpose extends CommonEntity {

    private String name;

}
