package com.csinfotechbd.collection.automaticDistribution.postInterim;

import com.csinfotechbd.retail.card.dataEntry.distribution.accountBasicInfo.CardAccountBasicInfo;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/*
Created by Monirul Islam at 9/15/2019
*/
@Data
@Entity
public class PostInterimCardDistributionTemp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private CardAccountBasicInfo cardAccountBasicInfo;

    private String supervisorPin;

    private String supervisorName;

    private String dealerPin;

    private String productGroup;

    private String ageCode;

    private String samAccount;

    private String writeOffAccount;

    private String dealerName;

    private String vvip;

    private String plasticCd;

    private String billingCycle;

    private String customerName;

    private String outstandingAmount;

    private String secureCard;

    @Temporal(TemporalType.DATE)
    private Date statusDate;

    public PostInterimCardDistributionTemp() {
    }

    public PostInterimCardDistributionTemp(String supervisorName, String supervisorPin, String dealerName,
                                           String dealerPin, String samAccount, String writeOffAccount,
                                           Date statusDate, CardAccountBasicInfo cardAccountBasicInfo,
                                           String productGroup, String ageCode, String outstandingAmount,
                                           String vvip, String billingCycle, String plasticCd,
                                           String secureCard, String customerName) {
        this.supervisorName = supervisorName;
        this.supervisorPin = supervisorPin;
        this.dealerName = dealerName;
        this.dealerPin = dealerPin;
        this.samAccount = samAccount;
        this.writeOffAccount = writeOffAccount;
        this.statusDate = statusDate;
        this.cardAccountBasicInfo = cardAccountBasicInfo;
        this.productGroup = productGroup;
        this.ageCode = ageCode;
        this.outstandingAmount = outstandingAmount;
        this.vvip = vvip;
        this.billingCycle = billingCycle;
        this.plasticCd = plasticCd;
        this.secureCard = secureCard;
        this.customerName = customerName;
    }
}
