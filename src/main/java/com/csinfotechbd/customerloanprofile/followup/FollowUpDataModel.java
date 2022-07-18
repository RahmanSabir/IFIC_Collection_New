package com.csinfotechbd.customerloanprofile.followup;

import lombok.Data;

/**
 * Created by Yasir Araphat on 05 April, 2021
 */

@Data
public class FollowUpDataModel {

    private String accountNo;
    private String accountName;
    private String followupDate ;
    private String followupTime;
    private String reason;
    private String remarks;
    private String dealerName;

}
