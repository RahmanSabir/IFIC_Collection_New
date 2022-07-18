package com.csinfotechbd.collection.emi;

import com.csinfotechbd.user.UserPrincipal;
import com.csinfotechbd.utillity.DateUtils;
import lombok.RequiredArgsConstructor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/collection/emi/excel")
public class EmiController {

    private final EmiRepository emiRepository;
    private final DateUtils dateUtils;

    @GetMapping(value = "/list")
    public String viewAll(Model model) {
        List<EmiEntity> emiEntities = emiRepository.findAll();
            model.addAttribute("emiAll", emiEntities);
        return "collection/emi/list";
    }

    @GetMapping("/upload-excel")
    public String bulkUpload() {
        return "collection/emi/upload";
    }

    @PostMapping("/upload-excel")
    public String mapReapExcelDatatoDB(@RequestParam("file") MultipartFile reapExcelDataFile) throws IOException {
        UserPrincipal user = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        try {
            List<EmiEntity> emiEntities = new ArrayList<EmiEntity>();
            XSSFWorkbook workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
            XSSFSheet worksheet = workbook.getSheetAt(0);

            for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
                EmiEntity emi = new EmiEntity();

                XSSFRow row = worksheet.getRow(i);


                emi.setContractId(row.getCell(0) != null ? row.getCell(0).toString() : null);
                emi.setPaymentDate(row.getCell(1) != null ? row.getCell(1).getDateCellValue() : null);
                emi.setBdtEmi(row.getCell(2) != null ? row.getCell(2).getNumericCellValue() : null);
                emi.setUsdEmi(row.getCell(3) != null ? row.getCell(3).getNumericCellValue() : null);
                emi.setCreatedBy(user.getUsername());
                emi.setCreatedDate(new Date());

                emiEntities.add(emi);
            }

            emiRepository.saveAll(emiEntities);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return "redirect:/collection/emi/excel/list";
    }


//    @GetMapping("/find")
//    public List<EmiEntity> getEmiByCurrentDate(@RequestParam String contractId){
//        return emiRepository.findContractByDateRange(contractId);
//    }
}
