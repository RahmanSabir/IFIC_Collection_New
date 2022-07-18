package com.csinfotechbd.collection.samd.dataEntry.reasonForClassification;

import com.csinfotechbd.base.BaseInfo;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ReasonForClassification extends BaseInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    private String borrowerPointOfView;
    @Lob
    private String bankPointOfView;
    private String accountNumber;
    private String dealerId;
}
