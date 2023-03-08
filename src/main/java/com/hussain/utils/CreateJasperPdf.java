package com.hussain.utils;

import net.sf.jasperreports.engine.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class CreateJasperPdf {

	public static void main(String[] args) {
		creare();
	}

	private static void creare() {
		try {
			// Compile jrxml file.
			JasperReport jasperReport = JasperCompileManager.compileReport(
					"D:\\go\\demo\\src\\main\\resources\\reports\\jasper_report_template.jrxml");

			// Parameters for report
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("name", "Shahzad");

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

			// Make sure the output directory exists.
			String path = "D:\\go\\";
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

}
