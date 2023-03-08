package com.hussain.controller;

import com.hussain.responses.UserResponse;
import com.hussain.utils.DataBean;
import com.hussain.utils.DataBeanList;
import com.hussain.utils.ReportUtility;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private ReportUtility reportUtility;

    @GetMapping(value = "/generatePdf")
    public ResponseEntity<Object> generatePdf(HttpServletRequest request,
                                              HttpServletResponse response) throws JRException, IOException {
        List<DataBean> dataList = DataBeanList.getDataBeanList();
        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);
        Map<String, Object> parameters = new HashMap<>();
        String templateName = "jasper_report_template";
        JasperReport jasperReport = reportUtility.getCompiledJasper(templateName);
        parameters.put("name", dataList);
        parameters.put("country", dataList);
        JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
        String path = "D:\\go";
        String dirForPdf = createPath(path);
        File pdfDirFile = new File(dirForPdf);
        if (!pdfDirFile.exists())
            pdfDirFile.mkdirs();
        String pdfFilePath = dirForPdf + System.currentTimeMillis() + ".pdf";
        JasperExportManager.exportReportToPdfFile(print, pdfFilePath);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    private String createPath(String path) {
        return path + "/";
    }

    @GetMapping("/pdf")
    public void hello(HttpServletResponse response) throws Exception {
        JasperReport jasperReport = reportUtility.getCompiledJasper("Blank_A4");

        // Parameters for report
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("clientName", "Shahzad");
        parameters.put("address", "New Delhi India");
        parameters.put("panNumber", "ADLPY6756C");

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

        // Make sure the output directory exists.
        String path = "D:\\go\\";
        File outDir = new File(path);

        if (!outDir.exists()) {
            outDir.mkdirs();
        }

        // Export to PDF.
        JasperExportManager.exportReportToPdfFile(jasperPrint, path + "test.pdf");

        reportUtility.exportToPdfWithoutDataSource(response, jasperReport, parameters, "test1");

    }

    @GetMapping("/jasperReport")
    public void generateJasperReport(HttpServletResponse response) throws JRException, IOException {
        String templateName = "jasper_report_template";
        List<UserResponse> users = List.of(new UserResponse("Shahzad", "India"), new UserResponse("Piter", "US"));
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(users);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("jasperData", dataSource);
        reportUtility.exportToPdf(response, reportUtility.getCompiledJasper(templateName), parameters,
                dataSource, "JasperReport");
    }


}
