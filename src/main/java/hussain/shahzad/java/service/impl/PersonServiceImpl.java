package hussain.shahzad.java.service.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import hussain.shahzad.java.entity.Person;
import hussain.shahzad.java.repository.PersonRepository;
import hussain.shahzad.java.requests.dto.PersonRequest;
import hussain.shahzad.java.requests.dto.RetailerRequest;
import hussain.shahzad.java.responses.dto.ExcellResponse;
import hussain.shahzad.java.responses.dto.PersonResponse;
import hussain.shahzad.java.service.PersonService;
import hussain.shahzad.java.utils.ExcelUtils;
import hussain.shahzad.java.utils.PersonConverter;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	public static final String CSV_LOCATION = "persons.csv";

	@Override
	public Long add(PersonRequest request) {
		Person entity = PersonConverter.getEntityFromRequest(request);
		if (entity != null) {
			personRepository.save(entity);
			return entity.getId();
		}
		return 0l;
	}

	@Override
	public PersonResponse getById(Long id) {
		Optional<Person> optionalPerson = personRepository.findById(id);
		if (optionalPerson.isPresent()) {
			return PersonConverter.getResponseFromEntity(optionalPerson.get());
		}
		return null;
	}

	@Override
	public List<PersonResponse> getAll() {
		return PersonConverter.getResponseListFromEntityList(personRepository.findAll());
	}

	@Override
	public void delete(Long id) {
		personRepository.deleteById(id);
	}

	@Override
	public boolean exist(Long id) {
		PersonResponse byId = getById(id);
		if (byId == null) {
			return false;
		}
		return true;
	}

	@Override
	public void uploadExcellFile(MultipartFile mFile)
			throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {

		List<RetailerRequest> retailers = ExcelUtils.toList(mFile, RetailerRequest.class);
		if (CollectionUtils.isEmpty(retailers)) {
			System.out.println("No retailers extracted from excel file.");
			return;
		}
		List<ExcellResponse> chnageResponse = PersonConverter.chnageResponse(retailers);

		Comparator<ExcellResponse> comparator = Comparator.comparing(ExcellResponse::getBalance)
				.thenComparing(Comparator.comparing(ExcellResponse::getCity));

		FileWriter writer = new FileWriter(CSV_LOCATION);
		List<ExcellResponse> collect2 = chnageResponse.stream().sorted(comparator).collect(Collectors.toList());

		ColumnPositionMappingStrategy<ExcellResponse> mappingStrategy = new ColumnPositionMappingStrategy<>();
		mappingStrategy.setType(ExcellResponse.class);

		// Arrange column name as provided in below array.
		String[] columns = new String[] { "City", "Country", "Gender", "Currency", "Balance", "Mobile" };
		mappingStrategy.setColumnMapping(columns);

		// Createing StatefulBeanToCsv object
		StatefulBeanToCsvBuilder<ExcellResponse> builder = new StatefulBeanToCsvBuilder<>(writer);
		StatefulBeanToCsv<ExcellResponse> beanWriter = builder.withMappingStrategy(mappingStrategy).build();

		// Write list to StatefulBeanToCsv object
		beanWriter.write(collect2);

		// closing the writer object
		writer.close();

		Map<String, List<ExcellResponse>> collect = chnageResponse.stream()
//				.sorted(comparator)
				.collect(Collectors.groupingBy(ExcellResponse::getGender));

		Set<Entry<String, List<ExcellResponse>>> entrySet2 = collect.entrySet();
		for (Entry<String, List<ExcellResponse>> entry : entrySet2) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
//		Map<String, Map<String, List<ExcellResponse>>> collect = chnageResponse.stream().sorted(comparator).collect(
//				Collectors.groupingBy(ExcellResponse::getGender, Collectors.groupingBy(ExcellResponse::getCity)));
//		Set<Entry<String, Map<String, List<ExcellResponse>>>> entrySet2 = collect.entrySet();
//		for (Entry<String, Map<String, List<ExcellResponse>>> entry : entrySet2) {
//			System.out.println(entry.getKey() + " " + entry.getValue());
//		}
	}
}