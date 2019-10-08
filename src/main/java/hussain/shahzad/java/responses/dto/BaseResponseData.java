package hussain.shahzad.java.responses.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 
 * @author shahzad
 *
 */
@JsonInclude(Include.NON_NULL)
public class BaseResponseData<T> {

	@SuppressWarnings("unused")
	private List<T> data;

}
