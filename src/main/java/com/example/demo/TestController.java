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
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@RestController
@RequestMapping
public class TestController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> hello(HttpServletRequest request) {

		return new ResponseEntity<Object>("Hi Your Public IP is : " + request.getRemoteAddr(), HttpStatus.OK);
	}

	@RequestMapping(value = "/world", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> world(HttpServletRequest request) {
		
		return new ResponseEntity<Object>(new Person("Shahzad","Hussain",26), HttpStatus.OK);
	}
	@RequestMapping(value = "/getAddress", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> getRemoteAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		System.out.println(ip);
		String remoteAddr = "";
		if (request != null) {
			remoteAddr = request.getHeader("X-FORWARDED-FOR");
			if (remoteAddr == null || "".equals(remoteAddr)) {
				remoteAddr = request.getRemoteAddr();
			}
		}
		System.out.println("Success : \t " + remoteAddr);
		return new ResponseEntity<Object>("Hi Your Public IP is : \t " + remoteAddr + "", HttpStatus.OK);
	}

	@RequestMapping(value = "/generatePdf", method = RequestMethod.GET)
	public ResponseEntity<Object> generateCibilInformationReport(HttpServletRequest request,
			HttpServletResponse response) throws JRException, FileNotFoundException {
		DataBeanList DataBeanList = new DataBeanList();
		List<DataBean> dataList = DataBeanList.getDataBeanList();
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);
		Map<String, Object> parameters = new HashMap<String, Object>();
		String sourceFileName = "C:\\Users\\Shahzad.Hussain\\Downloads\\demo (1)\\demo\\src\\main\\resources\\reports\\jasper_report_template.jasper";
		parameters.put("name", dataList);
		parameters.put("country", dataList);
		JasperPrint print = JasperFillManager.fillReport(sourceFileName, parameters, beanColDataSource);
		String path = "D:\\office-work\\perfios\\satinCreditcare";
		String dirForPdf = createPath(path);
		File pdfDirFile = new File(dirForPdf);
		if (!pdfDirFile.exists())
			pdfDirFile.mkdirs();
		String pdfFilePath = dirForPdf + System.currentTimeMillis() + "_" + ".pdf";
		// generating loan agreement
		JasperExportManager.exportReportToPdfFile(print, pdfFilePath);
		return new ResponseEntity<Object>("Success", HttpStatus.OK);
	}

	private String createPath(String path) {
		path = path + "/";
		return path;
	}
}
