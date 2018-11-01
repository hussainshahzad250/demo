/*************************************************************************
* 
* SATIN CREDITCARE NETWORK LIMITED CONFIDENTIAL
* __________________
* 
*  [2018] SATIN CREDITCARE NETWORK LIMITED
*  All Rights Reserved.
* 
* NOTICE:  All information contained herein is, and remains the property of SATIN CREDITCARE NETWORK LIMITED, and
* The intellectual and technical concepts contained herein are proprietary to SATIN CREDITCARE NETWORK LIMITED
* and may be covered by India and Foreign Patents, patents in process, and are protected by trade secret or copyright law.
* Dissemination of this information or reproduction of this material is strictly forbidden unless prior written permission
* is obtained from SATIN CREDITCARE NETWORK LIMITED.
*/
package com.example.demo;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

public class Main {

	public static void main(String[] args) throws JRException {
		createPdf();

		creare();

	}

	private static void creare() {
		try {

			// Compile jrxml file.
			JasperReport jasperReport = JasperCompileManager.compileReport(
					"C:\\Users\\Shahzad.Hussain\\Downloads\\demo (1)\\demo\\src\\main\\resources\\reports\\jasper_report_template.jrxml");

			// Parameters for report
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("name", "Shahzad");

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

			// Make sure the output directory exists.
			String path = "D:\\office-work\\perfios\\satinCreditcare";
			File outDir = new File(path);

			if (!outDir.exists()) {
				outDir.mkdirs();
			}

			// Export to PDF.
			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "StyledTextReport.pdf");

			System.out.println("Done!");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static void createPdf() throws JRException {
		String reportSrcFile = "C:\\Users\\Shahzad.Hussain\\Downloads\\demo (1)\\demo\\src\\main\\resources\\reports\\jasper_report_template.jrxml";

		// First, compile jrxml file.
		JasperReport jasperReport = JasperCompileManager.compileReport(reportSrcFile);

		// Parameters for report
		Map<String, Object> parameters = new HashMap<String, Object>();

		// Make sure the output directory exists.
		String destFileName = "D:\\\\office-work\\\\perfios\\\\satinCreditcare";
		File outDir = new File(destFileName);
		outDir.mkdirs();

		JasperFillManager.fillReportToFile(jasperReport, destFileName, parameters);

		// PDF Exportor.
//		JRPdfExporter exporter = new JRPdfExporter();
//
//		ExporterInput exporterInput = new SimpleExporterInput(print);
//		// ExporterInput
//		exporter.setExporterInput(exporterInput);
//
//		// ExporterOutput
//		OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(
//				"D:\\office-work\\perfios\\satinCreditcare" + "FirstJasperReport.pdf");
//		// Output
//		exporter.setExporterOutput(exporterOutput);
//
//		//
//		SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
//		exporter.setConfiguration(configuration);
//		exporter.exportReport();

		System.out.print("Done!");

	}

}
