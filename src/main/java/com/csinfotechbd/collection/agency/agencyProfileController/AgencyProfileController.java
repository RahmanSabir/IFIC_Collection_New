package com.csinfotechbd.collection.agency.agencyProfileController;

import com.csinfotechbd.collection.distribution.loan.loanAccountBasic.LoanAccountBasicInfo;
import com.csinfotechbd.customerbasicinfo.CustomerBasicInfoEntity;
import com.csinfotechbd.customerbasicinfo.CustomerBasicInfoService;
import com.csinfotechbd.retail.card.dataEntry.distribution.accountBasicInfo.CardAccountBasicInfo;
import com.csinfotechbd.retail.card.dataEntry.distribution.accountBasicInfo.CardAccountBasicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/collection/agency")
public class AgencyProfileController {

    private final CustomerBasicInfoService customerBasicInfoService;

    private final CardAccountBasicService cardAccountBasicService;

    @GetMapping("/search")
    public String searchCardProfile(@RequestParam(value = "account") String account) {
        CustomerBasicInfoEntity customerEntity = customerBasicInfoService.findByAccountNo(account);
        CardAccountBasicInfo cardBasicInfo = cardAccountBasicService.getByContractId(account);

        return "agency/cutomer360Page/pannels/main";
    }
}
