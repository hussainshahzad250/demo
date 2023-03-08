package com.hussain.utils;

import com.lowagie.text.pdf.PdfWriter;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.*;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Component
public class ReportUtility {


    public void exportToExcel(HttpServletResponse httpServletResponse, JasperReport jasperReport, Map<String, Object> parameters, JRBeanCollectionDataSource dataSource,
                              String fileName) throws JRException, IOException {
        ByteArrayOutputStream byteArrayOutputStream = null;
        ServletOutputStream outputStream = null;
        try {
            parameters.put("autoSizeExcelColumns", "false");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
            JRXlsxExporter xlsExporter = new JRXlsxExporter();
            xlsExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            byteArrayOutputStream = new ByteArrayOutputStream();
            xlsExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(byteArrayOutputStream));
            //xlsExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(fileName + ".xlsx"));
            SimpleXlsxReportConfiguration xlsReportConfiguration = new SimpleXlsxReportConfiguration();
            SimpleXlsxExporterConfiguration xlsExporterConfiguration = new SimpleXlsxExporterConfiguration();
            xlsExporterConfiguration.setCreateCustomPalette(true);
            xlsReportConfiguration.setOnePagePerSheet(false);
            xlsReportConfiguration.setRemoveEmptySpaceBetweenRows(false);
            xlsReportConfiguration.setDetectCellType(true);
            xlsReportConfiguration.setWhitePageBackground(true);
            xlsReportConfiguration.setShowGridLines(true);
            xlsExporter.setConfiguration(xlsReportConfiguration);
            xlsExporter.setConfiguration(xlsExporterConfiguration);
            xlsExporter.exportReport();
            httpServletResponse.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".xlsx");
            httpServletResponse.setContentType("application/xlsx");
            outputStream = httpServletResponse.getOutputStream();
            outputStream.write(byteArrayOutputStream.toByteArray());
        } finally {
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    public JasperReport getCompiledJasper(String jasperName) throws JRException, IOException {
        try (InputStream stream = getClass().getResourceAsStream("/reports/" + jasperName + ".jrxml")) {
            return JasperCompileManager.compileReport(stream);
        }
    }

    public void exportToPdf(HttpServletResponse httpServletResponse, JasperReport jasperReport,
                            Map<String, Object> parameters, JRBeanCollectionDataSource dataSource,
                            String fileName) throws JRException, IOException {
        ByteArrayOutputStream byteArrayOutputStream = null;
        ServletOutputStream outputStream = null;
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
//        JasperExportManager.exportReportToPdfFile(jasperPrint, fileName + ".pdf");

//        byte[] fileData = JasperExportManager.exportReportToPdf(jasperPrint);
//        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".pdf");
//        httpServletResponse.setContentType("application/pdf");
//        httpServletResponse.getOutputStream().write(fileData);

            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            byteArrayOutputStream = new ByteArrayOutputStream();
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(byteArrayOutputStream));
            SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
            configuration.setMetadataAuthor("finncub");
            configuration.setPermissions(PdfWriter.ALLOW_COPY | PdfWriter.ALLOW_PRINTING);
            exporter.setConfiguration(configuration);
            exporter.exportReport();
            httpServletResponse.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".pdf");
            httpServletResponse.setContentType("application/pdf");
            outputStream = httpServletResponse.getOutputStream();
            outputStream.write(byteArrayOutputStream.toByteArray());
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
        }
    }

    public void exportToPdfWithoutDataSource(HttpServletResponse httpServletResponse, JasperReport jasperReport,
                                             Map<String, Object> parameters, String fileName) throws Exception {
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

//        byte[] fileData = JasperExportManager.exportReportToPdf(jasperPrint);
//        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".pdf");
//        httpServletResponse.setContentType("application/pdf");
//        httpServletResponse.getOutputStream().write(fileData);
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(byteArrayOutputStream));
            SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
            configuration.setCompressed(true);
            configuration.setOwnerPassword("password");
            configuration.setMetadataAuthor("Shahzad Hussain");
            configuration.setPermissions(PdfWriter.ALLOW_COPY | PdfWriter.ALLOW_PRINTING);
            exporter.setConfiguration(configuration);
            exporter.exportReport();
            httpServletResponse.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".pdf");
            httpServletResponse.setContentType("application/pdf");
            httpServletResponse.getOutputStream().write(byteArrayOutputStream.toByteArray());
        }
    }

    public BufferedImage getBufferedImage(String path) throws IOException {
        try (InputStream stream = getClass().getResourceAsStream(path)) {
            if (stream != null) {
                byte[] bytes = stream.readAllBytes();
                try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes)) {
                    return ImageIO.read(bis);
                }
            }
        }
        return null;
    }

}


