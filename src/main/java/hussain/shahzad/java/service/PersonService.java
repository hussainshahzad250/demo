package hussain.shahzad.java.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import hussain.shahzad.java.requests.dto.PersonRequest;
import hussain.shahzad.java.responses.dto.PersonResponse;

public interface PersonService {
	Long add(PersonRequest request);

	PersonResponse getById(Long id);

	List<PersonResponse> getAll();

	void delete(Long id);

	boolean exist(Long id);

	void uploadExcellFile(MultipartFile mFile)
			throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException;
}