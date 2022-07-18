package com.csinfotechbd.retail.card.customerProfile;
/*
  Created by MR on 9/28/2021
*/

import com.csinfotechbd.base.BaseInfo;
import com.csinfotechbd.customerbasicinfo.CustomerBasicInfoEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class SmsPushPull extends BaseInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String mobileNumber;

    private String contractNo;

    private String messageDetails;

    private String sendOn;

    private String deliveryStatus;

    private String alertType;

    private String messageType;

    private Date fromDate;

    private Date toDate;

    private String emiDate;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "CUSTOMER_ID")
    private CustomerBasicInfoEntity customerBasicInfoEntity;
}
