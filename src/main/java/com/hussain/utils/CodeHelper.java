package com.hussain.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CodeHelper {
	public static String MAIN_PACKAGE = "hussain.shahzad.java";
	public static String MAIN_PACKAGE_PATH = "src/main/java/hussain/shahzad/java/";
	public static String author = "/**\r\n" + " * @author shahzad.hussain\r\n" + " */\n\n";

	public static void main(String[] args) throws IOException {
		List<TableData> tableList = new ArrayList<>();
		tableList.add(new TableData("name", "String", "", true, true));
		tableList.add(new TableData("population", "int", "", true, true));
		createCollection("Employee", tableList);
	}

	private static void createCollection(String entityName, List<TableData> fieldsMap) throws IOException {
		createEntity(MAIN_PACKAGE_PATH + "entity/", entityName, fieldsMap);
		createPojo(MAIN_PACKAGE_PATH + "pojos/", entityName, fieldsMap);
		createRequest(MAIN_PACKAGE_PATH + "requests/dto/", entityName);
		createResponse(MAIN_PACKAGE_PATH + "responses/dto/", entityName);
		createConverter(MAIN_PACKAGE_PATH + "utils/", entityName, fieldsMap);
		createRepository(MAIN_PACKAGE_PATH + "repository/", entityName);
		createService(MAIN_PACKAGE_PATH + "service/", entityName);
		createServiceImpl(MAIN_PACKAGE_PATH + "service/impl/", entityName);
		createController(MAIN_PACKAGE_PATH + "controller/", entityName);
//		addRestMapping(MAIN_PACKAGE_PATH + "constants/", entityName);
//		addErrorConstants(MAIN_PACKAGE_PATH + "enums/", entityName, fieldsMap);
//		addValidations(MAIN_PACKAGE_PATH + "utils/", entityName, fieldsMap);

//		createUrlFile(entityName, fieldsMap);
	}

	private static void createUrlFile(String entityName, List<TableData> fieldsMap) throws IOException {
		FileWriter filewriter = null;
		String rootUrl = "http://localhost:8080/api/";
		getUrls(rootUrl);
		StringBuilder filecontent = new StringBuilder("URL, BODY, RESPONSE\n");
		filecontent.append(rootUrl).append(entityName).append("").append("\n");
		filecontent.append(rootUrl).append(entityName + "{id}").append("\n");
		filecontent.append(rootUrl).append(entityName + "{id}").append("\n");
		filecontent.append(rootUrl).append(entityName + "{id}").append("\n");
		filecontent.append(rootUrl).append(entityName).append("GET").append("\n");
//		for (Url csv : urlList) {
//			
//		}
		String filename = "C:\\Users\\Shahzad.Hussain\\Documents\\code\\Java-Rest\\filedownload\\filedownload\\csvdata.csv";
		filewriter = new FileWriter(filename);
		filewriter.write(filecontent.toString());
		filewriter.flush();
		filewriter.close();
		System.out.println("Url File Created Successfully");
	}

	private static void getUrls(String rootUrl) {
		Url url = new Url();
		url.setUrl(rootUrl);
	}

	private static void createEntity(String folder, String fileName, List<TableData> fieldsMap) {
		try {
			FileWriter fileWriter = new FileWriter(folder + fileName + ".java");
			fileWriter.write("package " + MAIN_PACKAGE + ".entity;\n\n");
			fileWriter.write("import javax.persistence.Column;\n");
			fileWriter.write("import javax.persistence.Entity;\n");
			fileWriter.write("import javax.persistence.Table;\n");
			fileWriter.write(author + "\n");

			fileWriter.write("@Entity\n");
			fileWriter.write("@Table(name=" + fileName + ".Columns.TABLE)\n");
			fileWriter.write("public class " + fileName);
			fileWriter.write(" extends BaseEntity{\n");
			fileWriter.write("\tpublic interface Columns{\n");
			fileWriter.write("\t\tString TABLE=\"" + fileName.toLowerCase().charAt(0)
					+ fileName.substring(1, fileName.length()) + "s\";\n");
			fileWriter.write("\t\tString QUERY=\"CREATE TABLE " + fileName.toLowerCase().charAt(0)
					+ fileName.substring(1, fileName.length()) + "s (id INT AUTO_INCREMENT,");
			for (TableData data : fieldsMap) {
				fileWriter.write(data.getName() + " " + data.getDataType());
				if (data.isNotNull()) {
					fileWriter.write(" NOT NULL");
				}
				if (data.isUnique()) {
					fileWriter.write(" UNIQUE");
				}
				fileWriter.write(",");
			}
			fileWriter
					.write("created DATETIME,updated DATETIME,creator INTEGER,updator INTEGER,PRIMARY KEY (id));\";\n");
			for (TableData data : fieldsMap) {
				fileWriter.write("\t\tString " + data.getName().toUpperCase() + " =\"" + data.getName() + "\";\n");
			}
			fileWriter.write("\t}\n\n");
			for (TableData data : fieldsMap) {
				fileWriter.write("\t@Column(name = Columns." + data.getName().toUpperCase() + ", ");
				fileWriter.write("columnDefinition=\"" + data.getDataType());
				if (data.isNotNull()) {
					fileWriter.write(" NOT NULL");
				}
				if (data.isUnique()) {
					fileWriter.write(" UNIQUE");
				}
				fileWriter.write("\")\n");
				fileWriter.write("\tprivate " + data.getType() + " " + data.getName() + ";\n");
			}
			fileWriter.write("\n");
			for (TableData data : fieldsMap) {
				fileWriter.write("\tpublic " + data.getType() + " " + "get" + data.getName().toUpperCase().charAt(0)
						+ data.getName().substring(1, data.getName().length()) + "(){\n");
				fileWriter.write("\t\treturn " + data.getName() + ";\n\t}\n");
				fileWriter.write("\tpublic void " + "set" + data.getName().toUpperCase().charAt(0)
						+ data.getName().substring(1, data.getName().length()) + "(" + data.getType() + " "
						+ data.getName() + "){\n");
				fileWriter.write("\t\t this." + data.getName() + "= " + data.getName() + ";\n\t}\n");
			}
			fileWriter.write("}");
			fileWriter.flush();
			fileWriter.close();
			System.out.println(fileName + "Entity Created!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void createRepository(String folder, String fileName) {

		try {
			FileWriter fileWriter = new FileWriter(folder + fileName + "Repository.java");
			fileWriter.write("package " + MAIN_PACKAGE + ".repository;\n\n");
			fileWriter.write("import org.springframework.data.jpa.repository.JpaRepository;\n");
			fileWriter.write("import org.springframework.stereotype.Repository;\n\n");
			fileWriter.write("import " + MAIN_PACKAGE + ".entity." + fileName + ";\n");
			fileWriter.write(author + "\n");
			fileWriter.write("@Repository\n");
			fileWriter.write("public interface " + fileName);
			fileWriter.write("Repository extends JpaRepository<" + fileName + ", Long> {\n");
			fileWriter.write("\n");
			fileWriter.write("}");
			fileWriter.write("\n");
			fileWriter.flush();
			fileWriter.close();
			System.out.println(fileName + "Repositoty Created!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void addValidations(String filePath, String fileName, List<TableData> fieldsMap) {
		try {
			FileReader fileReader = new FileReader(filePath + "ValidationUtils.java");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuilder builder = new StringBuilder();
			String linePre = null;
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				if (line.trim().endsWith("{") && !builder.toString().contains(fileName)) {
					builder.append("import " + MAIN_PACKAGE + ".requests.dto." + fileName + "Request;\n");
					builder.append("import " + MAIN_PACKAGE + ".responses.dto." + fileName + "Response;\n");
				}
				if (line.trim().endsWith("}/* finish */")) {
					if (linePre.trim().endsWith("}")) {
						if (!builder.toString().contains(fileName + "s Validations")) {
							builder.append("\n").append("\t/* " + fileName + "s Validations */\n");
							builder.append("\tpublic static void validate" + fileName + "Request(" + fileName
									+ "Request request) throws MyAppException {\n");
							for (TableData entry : fieldsMap) {
								if (entry.isNotNull()) {
									if (entry.getType().equals("String")) {
										builder.append("\tif(StringUtils.isEmpty(request.get"
												+ entry.getName().toUpperCase().charAt(0)
												+ entry.getName().substring(1, entry.getName().length()) + "())){\n");
									} else if (entry.getType().contains("List") || entry.getType().contains("Set")) {
										builder.append("\tif(CollectionUtils.isEmpty(request.get"
												+ entry.getName().toUpperCase().charAt(0)
												+ entry.getName().substring(1, entry.getName().length()) + "())){\n");
									} else {
										builder.append("\tif(request.get" + entry.getName().toUpperCase().charAt(0)
												+ entry.getName().substring(1, entry.getName().length())
												+ "()==null){\n");
									}
									builder.append("\t\tthrow new MyAppException(LoanApplicationResponseCode.EMPTY_"
											+ entry.getName().toUpperCase() + ");\n");
									builder.append("\t}\n");
								}
							}
							builder.append("\t}\n\n");
							builder.append("\tpublic static void validate" + fileName + "Response(" + fileName
									+ "Response request) throws MyAppException {\n");
							builder.append("\tif(StringUtils.isEmpty(request.get" + fileName + "Id())){\n");
							builder.append("\t\tthrow new MyAppException(LoanApplicationResponseCode.EMPTY_"
									+ fileName.toUpperCase() + "_ID);\n");
							builder.append("\t}\n");
							for (TableData entry : fieldsMap) {
								if (entry.isNotNull()) {
									builder.append("\tif(StringUtils.isEmpty(request.get"
											+ entry.getName().toUpperCase().charAt(0)
											+ entry.getName().substring(1, entry.getName().length()) + "())){\n");
									builder.append("\t\tthrow new MyAppException(LoanApplicationResponseCode.EMPTY_"
											+ entry.getName().toUpperCase() + ");\n");
									builder.append("\t}\n");
								}
							}
							builder.append("\t}\n");
						}
					}
				}
				builder.append(line).append("\n");
				linePre = line;
			}
			bufferedReader.close();
			FileOutputStream out = new FileOutputStream(filePath + "ValidationUtils.java");
			out.write(builder.toString().getBytes());
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Validations Created!");
	}

	private static void addErrorConstants(String filePath, String fileName, List<TableData> fieldsMap) {
		try {
			FileReader fileReader = new FileReader(filePath + "LoanApplicationResponseCode.java");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuilder builder = new StringBuilder();
			String linePre = "";
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				if (line.trim().endsWith(";")) {
					if (linePre.trim().endsWith(",")) {
						if (!builder.toString().contains(fileName + "s")) {
							builder.append("\n").append("\t/* " + fileName + "s*/\n");
							builder.append("\tEMPTY_" + (fileName + "_ID").toUpperCase() + "(\""
									+ fileName.toLowerCase().charAt(0) + fileName.substring(1, fileName.length())
									+ "Id cannot be empty!\",\"EMP_" + (fileName + "_ID").toUpperCase() + "\"),\n");
							for (TableData entry : fieldsMap) {
								if (entry.isNotNull()) {
									builder.append("\tEMPTY_" + entry.getName().toUpperCase() + "(\"" + entry.getName()
											+ " cannot be empty!\",\"EMP_" + entry.getName().toUpperCase() + "\"),\n");
								}
								if (entry.isUnique()) {
									builder.append("\tEXIST_" + entry.getName().toUpperCase() + "(\"" + entry.getName()
											+ " already exist!\",\"EXS_" + entry.getName().toUpperCase() + "\"),\n");
								}
							}
							builder.append("\t" + fileName.toUpperCase() + "_NOT_FOUND(\"" + fileName
									+ " not found!\",\"NF_" + fileName.toUpperCase() + "\"),\n");
							builder.append("\tNO_" + fileName.toUpperCase() + "S_FOUND(\"No " + fileName
									+ "s added yet!\",\"NO_" + fileName.toUpperCase() + "_ADDED\"),\n");
						}
					}
				}
				builder.append(line).append("\n");
				linePre = line;
			}
			bufferedReader.close();
			FileOutputStream out = new FileOutputStream(filePath + "LoanApplicationResponseCode.java");
			out.write(builder.toString().getBytes());
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Exeptions Created");
	}

	private static void addRestMapping(String filePath, String fileName) {
		try {
			FileReader fileReader = new FileReader(filePath + "RestMappingConstants.java");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuilder builder = new StringBuilder();
			String linePre = null;
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				if (line.trim().endsWith("}")) {
					if (linePre.trim().endsWith("}")) {
						if (!builder.toString().contains(fileName + "Constants")) {
							builder.append("\tinterface " + fileName + "Constants{\n");
							builder.append("\t\tString BASE = APP_BASE + \"/" + fileName.toLowerCase().charAt(0)
									+ fileName.substring(1, fileName.length()) + "s\";\n");
							builder.append("\t}\n");
						}
					}
				}
				builder.append(line).append("\n");
				linePre = line;
			}
			bufferedReader.close();
			FileOutputStream out = new FileOutputStream(filePath + "RestMappingConstants.java");
			out.write(builder.toString().getBytes());
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Constants Created");
	}

	private static void createController(String folder, String fileName) {
		try {
			FileWriter fileWriter = new FileWriter(folder + fileName + "Controller.java");
			fileWriter.write("package " + MAIN_PACKAGE + ".controller;\n\n");
			fileWriter.write("import org.springframework.beans.factory.annotation.Autowired;\n");
			fileWriter.write("import org.springframework.http.HttpStatus;\n");
			fileWriter.write("import org.springframework.http.MediaType;\n");
			fileWriter.write("import org.springframework.web.bind.annotation.RestController;\n");
			fileWriter.write("import org.springframework.web.bind.annotation.RequestBody;\n");
			fileWriter.write("import org.springframework.web.bind.annotation.DeleteMapping;\n");
			fileWriter.write("import org.springframework.web.bind.annotation.GetMapping;\n");
			fileWriter.write("import org.springframework.web.bind.annotation.PostMapping;\n");
			fileWriter.write("import org.springframework.web.bind.annotation.PathVariable;\n");
			fileWriter.write("import org.springframework.web.bind.annotation.RequestMapping;\n");

			fileWriter.write("import " + MAIN_PACKAGE + ".constants.RestMappingConstants;\n");
			fileWriter.write("import " + MAIN_PACKAGE + ".enums.LoanApplicationResponseCode;\n");
			fileWriter.write("import " + MAIN_PACKAGE + ".exception.MyAppException;\n");
			fileWriter.write("import " + MAIN_PACKAGE + ".responses.dto.Response;\n");
			fileWriter.write("import org.springframework.util.CollectionUtils;\n");

			fileWriter.write("import " + MAIN_PACKAGE + ".requests.dto." + fileName + "Request;\n");
			fileWriter.write("import " + MAIN_PACKAGE + ".responses.dto." + fileName + "Response;\n");
			fileWriter.write("import java.util.List;\n");
			fileWriter.write("import " + MAIN_PACKAGE + ".service." + fileName + "Service;\n");
			fileWriter.write("import " + MAIN_PACKAGE + ".utils." + fileName + "Converter;\n\n");

			fileWriter.write(author + "\n");

			fileWriter.write("@RestController\n");
			fileWriter.write("@RequestMapping(value = \"/api/" + fileName + "\")\n");
			fileWriter.write("public class " + fileName + "Controller{\n\n");

			fileWriter.write("\t@Autowired\n");
			String serviceName = fileName.toLowerCase().charAt(0) + fileName.substring(1, fileName.length())
					+ "Service";

			fileWriter.write("\tprivate " + fileName + "Service " + serviceName + ";\n");
			fileWriter.write("\n");

			fileWriter.write(
					"\t@GetMapping(value = RestMappingConstants.REQUEST, produces = MediaType.APPLICATION_JSON_VALUE)\n");
			fileWriter
					.write("\tpublic Response<" + fileName + "Request> generateRequestJson() throws MyAppException{\n");
			fileWriter.write(
					"\t\treturn new Response<" + fileName + "Request>(LoanApplicationResponseCode.SUCCESS.getMessage(),"
							+ fileName + "Converter.getSample(),HttpStatus.OK);\n");
			fileWriter.write("\t}\n\n");

			fileWriter.write("\t@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)\n");
			fileWriter.write("\tpublic Response<Long> add(");
			fileWriter.write("@RequestBody(required = true) " + fileName + "Request request");
			fileWriter.write(")throws MyAppException{\n");
			fileWriter.write("\t\tLong response = " + serviceName + ".add(request);\n");
			fileWriter.write(
					"\t\treturn new Response<Long>(LoanApplicationResponseCode.SUCCESS.getMessage(),response,HttpStatus.OK);\n");
			fileWriter.write("\t}\n\n");

			fileWriter.write(
					"\t@GetMapping(path = RestMappingConstants.ID_PARAM, produces = MediaType.APPLICATION_JSON_VALUE)\n");
			fileWriter.write("\tpublic Response<" + fileName + "Response> getById(");
			fileWriter.write("@PathVariable(RestMappingConstants.ID) Long id)throws MyAppException{\n");
			fileWriter.write("\t" + fileName + "Response response = " + serviceName + ".getById(id);\n");
			fileWriter.write("\tif(response==null){\n");

			fileWriter.write("\t\tthrow new MyAppException(\"" + fileName + " Not Found\",HttpStatus.NOT_FOUND);\n");
			fileWriter.write("\t}\n");
			fileWriter.write("\treturn new Response<" + fileName
					+ "Response>(LoanApplicationResponseCode.SUCCESS.getMessage(),response,HttpStatus.OK);\n");
			fileWriter.write("\t}\n\n");

			fileWriter.write("\t@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)\n");
			fileWriter.write("\tpublic Response<List<" + fileName + "Response>> getAll()throws MyAppException{\n");
			fileWriter.write("\tList<" + fileName + "Response> response = " + serviceName + ".getAll();\n");
			fileWriter.write("\tif(CollectionUtils.isEmpty(response)){\n");
			fileWriter.write("\t\tthrow new MyAppException(\"No " + fileName + " Found\",HttpStatus.NOT_FOUND);\n");
			fileWriter.write("\t}\n");
			fileWriter.write("\treturn new Response<List<" + fileName
					+ "Response>>(LoanApplicationResponseCode.SUCCESS.getCode(), response, HttpStatus.OK);\n");
			fileWriter.write("\t}\n\n");

			fileWriter.write(
					"\t@DeleteMapping(path = RestMappingConstants.ID_PARAM, produces = MediaType.APPLICATION_JSON_VALUE)\n");
			fileWriter.write("\tpublic Response<Boolean> delete(");
			fileWriter.write("@PathVariable(RestMappingConstants.ID) Long id)throws MyAppException{\n");
			fileWriter.write("\tif(!" + serviceName + ".exist(id)){\n");
			fileWriter.write("\t\tthrow new MyAppException(\"" + fileName + " Not Found\",HttpStatus.NOT_FOUND);\n");
			fileWriter.write("\t}\n");
			fileWriter.write("\t" + serviceName + ".delete(id);\n");
			fileWriter.write(
					"\treturn new Response<Boolean>(LoanApplicationResponseCode.SUCCESS.getMessage(),HttpStatus.OK);\n");
			fileWriter.write("\t}\n\n");

//			fileWriter.write(
//					"\t@RequestMapping(method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)\n");
//			fileWriter.write("\t@ResponseBody\n");
//			fileWriter.write("\tpublic Response<Boolean> update(");
//			fileWriter.write("@RequestBody(required = true) " + fileName + "Response request)throws MyAppException{\n");
//			fileWriter.write("\tif(!" + serviceName + ".exist(request.get" + fileName + "Id())){\n");
//			fileWriter.write("\t\tthrow new MyAppException(LoanApplicationResponseCode." + fileName.toUpperCase()
//					+ "_NOT_FOUND,HttpStatus.NOT_FOUND);\n");
//			fileWriter.write("\t}\n");
//			fileWriter.write("\tBoolean response = " + serviceName + ".update(request);\n");
//			fileWriter.write(
//					"\treturn new Response<Boolean>(LoanApplicationResponseCode.SUCCESS.getMessage(),HttpStatus.OK);\n");
//			fileWriter.write("\t}\n\n");

			fileWriter.write("}");
			fileWriter.flush();
			fileWriter.close();
			System.out.println("Controller Created!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void createService(String folder, String fileName) {
		try {
			FileWriter fileWriter = new FileWriter(folder + fileName + "Service.java");
			fileWriter.write("package " + MAIN_PACKAGE + ".service;\n");
			fileWriter.write("import " + MAIN_PACKAGE + ".requests.dto." + fileName + "Request;\n");
			fileWriter.write("import " + MAIN_PACKAGE + ".responses.dto." + fileName + "Response;\n");
			fileWriter.write("import java.util.List;\n");
			fileWriter.write(author + "\n");
			fileWriter.write("public interface " + fileName);
			fileWriter.write("Service{\n");
			fileWriter.write("\tLong add(" + fileName + "Request request);\n");
			fileWriter.write("\t" + fileName + "Response getById(Long id);\n");
			fileWriter.write("\tList<" + fileName + "Response> getAll();\n");
			fileWriter.write("\tvoid delete(Long id);\n");
			fileWriter.write("\tboolean exist(Long id);\n");

			/**
			 * Declare Method to Update Record
			 */
//			fileWriter.write("\tboolean update(" + fileName + "Response request);\n");
			fileWriter.write("}");
			fileWriter.flush();
			fileWriter.close();
			System.out.println(fileName + "Service Created!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void createServiceImpl(String folder, String fileName) {
		try {
			FileWriter fileWriter = new FileWriter(folder + fileName + "ServiceImpl.java");
			fileWriter.write("package " + MAIN_PACKAGE + ".service.impl;\n\n");
			fileWriter.write("import org.springframework.beans.factory.annotation.Autowired;\n");
			fileWriter.write("import org.springframework.stereotype.Service;\n\n");
			fileWriter.write("import " + MAIN_PACKAGE + ".entity." + fileName + ";\n");
			fileWriter.write("import " + MAIN_PACKAGE + ".requests.dto." + fileName + "Request;\n");
			fileWriter.write("import " + MAIN_PACKAGE + ".responses.dto." + fileName + "Response;\n");
			fileWriter.write("import java.util.List;\n");
			fileWriter.write("import java.util.Optional;\n");
			fileWriter.write("import " + MAIN_PACKAGE + ".service." + fileName + "Service;\n");
			fileWriter.write("import " + MAIN_PACKAGE + ".repository." + fileName + "Repository;\n");

			fileWriter.write("import " + MAIN_PACKAGE + ".utils." + fileName + "Converter;\n\n");
			fileWriter.write(author + "\n");
			fileWriter.write("@Service\n");
			fileWriter.write("public class " + fileName);
			fileWriter.write("ServiceImpl implements " + fileName + "Service{\n\n");
			fileWriter.write("\t@Autowired\n");
			String daoName = fileName.toLowerCase().charAt(0) + fileName.substring(1, fileName.length()) + "Repository";
			fileWriter.write("\tprivate " + fileName + "Repository " + daoName + ";\n\n");

			fileWriter.write("\t@Override\n");
			fileWriter.write("\tpublic Long add(" + fileName + "Request request){\n");
			fileWriter.write("\t" + fileName + " entity=" + fileName + "Converter.getEntityFromRequest(request);\n");
			fileWriter.write("\tif(entity!=null){\n");
			fileWriter.write("\t\t" + daoName + ".save(entity);\n");
			fileWriter.write("\t\treturn entity.getId();\n");
			fileWriter.write("\t}\n");
			fileWriter.write("\treturn 0l;\n");
			fileWriter.write("\t}\n\n");

			fileWriter.write("\t@Override\n");
			fileWriter.write("\tpublic " + fileName + "Response getById(Long id){\n");

			fileWriter.write("\t\tOptional<" + fileName + "> optional" + fileName + "=" + daoName + ".findById(id);\n");

			fileWriter.write("\t\tif(optional" + fileName + ".isPresent()) {\n");

			fileWriter.write(
					"\t\t\treturn " + fileName + "Converter.getResponseFromEntity(optional" + fileName + ".get());\n");

			fileWriter.write("\t\t}\n");
			fileWriter.write("\t\treturn null;\n");

			fileWriter.write("\t}\n\n");

			fileWriter.write("\t@Override\n");
			fileWriter.write("\tpublic List<" + fileName + "Response> getAll(){\n");
			fileWriter.write(
					"\treturn " + fileName + "Converter.getResponseListFromEntityList(" + daoName + ".findAll());\n");
			fileWriter.write("\t}\n\n");

			fileWriter.write("\t@Override\n");
			fileWriter.write("\tpublic void delete(Long id){\n");
			fileWriter.write("\t" + daoName + ".deleteById(id);\n");
			fileWriter.write("\t}\n\n");

			fileWriter.write("\t@Override\n");
			fileWriter.write("\tpublic boolean exist(Long id){\n");
			fileWriter.write("\tif(getById(id)!=null){\n");
			fileWriter.write("\t\treturn true;\n");
			fileWriter.write("\t}\n");
			fileWriter.write("\treturn false;\n");
			fileWriter.write("\t}\n\n");

			/**
			 * Method To Update
			 */

//			fileWriter.write("\t@Override\n");
//			fileWriter.write("\tpublic boolean update(" + fileName + "Response request){\n");
//			fileWriter.write("\t" + fileName + " entity=" + daoName + ".getTById(request.get" + fileName + "Id());\n");
//			fileWriter.write("\t" + fileName + "Converter.getEntityFromResponse(request,entity);\n");
//			fileWriter.write("\tif(entity!=null){\n");
//			fileWriter.write("\t\t" + daoName + ".updateT(entity);\n");
//			fileWriter.write("\t\treturn true;\n");
//			fileWriter.write("\t}\n");
//			fileWriter.write("\treturn false;\n");
//			fileWriter.write("\t}\n\n");

			fileWriter.write("}");
			fileWriter.flush();
			fileWriter.close();
			System.out.println(fileName + "ServiceImpl Created!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void createConverter(String folder, String fileName, List<TableData> fieldsMap) {
		try {
			FileWriter fileWriter = new FileWriter(folder + fileName + "Converter.java");
			fileWriter.write("package " + MAIN_PACKAGE + ".utils;\n\n");

			fileWriter.write("import " + MAIN_PACKAGE + ".entity." + fileName + ";\n");
			fileWriter.write("import java.util.ArrayList;\n");
			fileWriter.write("import org.springframework.util.CollectionUtils;\n");
			fileWriter.write("import java.util.List;\n");
			fileWriter.write("import " + MAIN_PACKAGE + ".requests.dto." + fileName + "Request;\n");
			fileWriter.write("import " + MAIN_PACKAGE + ".responses.dto." + fileName + "Response;\n\n");
			fileWriter.write(author + "\n");
			fileWriter.write("public class " + fileName);
			fileWriter.write("Converter {\n");

			fileWriter.write("\n\tpublic static " + fileName + "Request getSample() {\n");
			fileWriter.write("\t\t" + fileName + "Request response = new " + fileName + "Request();\n");
			for (TableData entry : fieldsMap) {
				System.out.println("name:" + entry.getName());
				fileWriter.write("\t\tresponse.set" + entry.getName().toUpperCase().charAt(0)
						+ entry.getName().substring(1, entry.getName().length()) + "("
						+ getSample(entry.getType(), entry.getName()) + ");\n");
			}
			fileWriter.write("\t\treturn response;\n");
			fileWriter.write("\t}\n");

			fileWriter.write(
					"\n\tpublic static " + fileName + " getEntityFromRequest(" + fileName + "Request request) {\n");
			fileWriter.write("\t\tif(request!=null){\n");
			fileWriter.write("\t\t\t" + fileName + " response = new " + fileName + "();\n");
			for (TableData entry : fieldsMap) {
				fileWriter.write("\t\t\tresponse.set" + entry.getName().toUpperCase().charAt(0)
						+ entry.getName().substring(1, entry.getName().length()) + "(request.get"
						+ entry.getName().toUpperCase().charAt(0)
						+ entry.getName().substring(1, entry.getName().length()) + "());\n");
			}
			fileWriter.write("\t\t\treturn response;\n");
			fileWriter.write("\t\t}\n");
			fileWriter.write("\t\treturn null;\n");
			fileWriter.write("\t}\n");

			fileWriter.write(
					"\n\tpublic static " + fileName + "Response getResponseFromEntity(" + fileName + " request) {\n");
			fileWriter.write("\t\tif(request!=null){\n");
			fileWriter.write("\t\t\t" + fileName + "Response response = new " + fileName + "Response();\n");
			fileWriter.write("\t\t\tresponse.set" + fileName + "Id(request.getId());\n");
			for (TableData entry : fieldsMap) {
				fileWriter.write("\t\t\tresponse.set" + entry.getName().toUpperCase().charAt(0)
						+ entry.getName().substring(1, entry.getName().length()) + "(request.get"
						+ entry.getName().toUpperCase().charAt(0)
						+ entry.getName().substring(1, entry.getName().length()) + "());\n");
			}
			fileWriter.write("\t\t\treturn response;\n");
			fileWriter.write("\t\t}\n");
			fileWriter.write("\t\treturn null;\n");
			fileWriter.write("\t}\n");

			fileWriter.write("\n\tpublic static " + fileName + " getEntityFromResponse(" + fileName
					+ "Response request," + fileName + " response) {\n");
			fileWriter.write("\t\tif(request!=null){\n");
			for (TableData entry : fieldsMap) {
				fileWriter.write("\t\t\tresponse.set" + entry.getName().toUpperCase().charAt(0)
						+ entry.getName().substring(1, entry.getName().length()) + "(request.get"
						+ entry.getName().toUpperCase().charAt(0)
						+ entry.getName().substring(1, entry.getName().length()) + "());\n");
			}
			fileWriter.write("\t\t\treturn response;\n");
			fileWriter.write("\t\t}\n");
			fileWriter.write("\t\treturn null;\n");
			fileWriter.write("\t}\n");

			fileWriter.write("\n\tpublic static List<" + fileName + "Response> getResponseListFromEntityList(List<"
					+ fileName + "> requestList) {\n");
			fileWriter.write("\t\tif(CollectionUtils.isEmpty(requestList))\n");
			fileWriter.write("\t\t\treturn null;\n");

			fileWriter.write("\t\tList<" + fileName + "Response> responseList = new ArrayList<>();\n");
			fileWriter.write("\t\tfor(" + fileName + " request:requestList){\n");
			fileWriter.write("\t\t\tresponseList.add(getResponseFromEntity(request));\n");
			fileWriter.write("\t\t}\n");
			fileWriter.write("\t\treturn responseList;\n");

			fileWriter.write("\t}\n");
			fileWriter.write("}");
			fileWriter.flush();
			fileWriter.close();
			System.out.println(fileName + "Converter Created!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String getSample(String value, String name) {
		switch (value) {
		case "String":
			return "\"" + name + "\"";
		case "Double":
			return 123 + "D";
		case "Float":
		case "Integer":
			return "123";
		case "Long":
			return "123l";
		case "Boolean":
			return "true";
		case "List<String>":
			return "new ArrayList<>()";
		default:
			return "new " + value + "()";
		}
	}

	private static void createResponse(String folder, String fileName) {
		try {
			FileWriter fileWriter = new FileWriter(folder + fileName + "Response.java");
			fileWriter.write("package " + MAIN_PACKAGE + ".responses.dto;\n\n");
			fileWriter.write("import " + MAIN_PACKAGE + ".pojos." + fileName + "Pojo;\n");
			fileWriter.write(author + "\n");
			fileWriter.write("public class " + fileName);
			fileWriter.write("Response extends " + fileName + "Pojo {\n");

			String atr = fileName.toLowerCase().charAt(0) + fileName.substring(1, fileName.length()) + "Id";
			fileWriter.write("\tprivate Long " + atr + ";\n");

			fileWriter.write("\n");

			/**
			 * 
			 */

			fileWriter.write("\tpublic Long " + " " + "get" + fileName.toUpperCase().charAt(0)
					+ fileName.substring(1, fileName.length()) + "Id(){\n");
			fileWriter.write("\t\treturn " + atr + ";\n\t}\n");
			fileWriter.write("\tpublic void " + "set" + fileName.toUpperCase().charAt(0)
					+ fileName.substring(1, fileName.length()) + "Id( Long " + " " + atr + "){\n");
			fileWriter.write("\t\t this." + atr + "= " + atr + ";\n\t}\n");

			/**
			 * 
			 */

			fileWriter.write("}");
			fileWriter.flush();
			fileWriter.close();
			System.out.println(fileName + "Response Created!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void createRequest(String folder, String fileName) {
		try {
			FileWriter fileWriter = new FileWriter(folder + fileName + "Request.java");
			fileWriter.write("package " + MAIN_PACKAGE + ".requests.dto;\n\n");
			fileWriter.write("import " + MAIN_PACKAGE + ".pojos." + fileName + "Pojo;\n");
			fileWriter.write(author + "\n");
			fileWriter.write("public class " + fileName);
			fileWriter.write("Request extends " + fileName + "Pojo {\n");
			fileWriter.write("}");
			fileWriter.flush();
			fileWriter.close();
			System.out.println(fileName + "Request Created!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void createPojo(String folder, String fileName, List<TableData> fieldsMap) {
		try {
			FileWriter fileWriter = new FileWriter(folder + fileName + "Pojo.java");
			fileWriter.write("package " + MAIN_PACKAGE + ".pojos;\n\n");
			fileWriter.write(author + "\n");
			fileWriter.write("public class " + fileName);
			fileWriter.write("Pojo {\n");
			for (TableData data : fieldsMap) {
				fileWriter.write("\tprivate " + data.getType() + " " + data.getName() + ";\n");
			}
			fileWriter.write("\n");
			for (TableData data : fieldsMap) {
				fileWriter.write("\tpublic " + data.getType() + " " + "get" + data.getName().toUpperCase().charAt(0)
						+ data.getName().substring(1, data.getName().length()) + "(){\n");
				fileWriter.write("\t\treturn " + data.getName() + ";\n\t}\n");
				fileWriter.write("\tpublic void " + "set" + data.getName().toUpperCase().charAt(0)
						+ data.getName().substring(1, data.getName().length()) + "(" + data.getType() + " "
						+ data.getName() + "){\n");
				fileWriter.write("\t\t this." + data.getName() + "= " + data.getName() + ";\n\t}\n");
			}
			fileWriter.write("}");
			fileWriter.flush();
			fileWriter.close();
			System.out.println(fileName + "Pojo Created!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class Url {
	private Long id;
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
