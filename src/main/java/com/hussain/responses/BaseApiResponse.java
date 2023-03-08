//package hussain.shahzad.java.responses.dto;
//
//import java.util.List;
//
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonInclude.Include;
//
//import hussain.shahzad.java.enums.LoanApplicationResponseCode;
//
///**
// * 
// * @author shahzad
// *
// */
//@JsonInclude(Include.NON_NULL)
//public class BaseApiResponse<T> extends BaseResponseData<T> {
//
//	private List<String> fieldErrors;
//
//	public BaseApiResponse(String status, String msg, BaseResponseData<T> response) {
//		super(status, msg, response);
//	}
//
//	public BaseApiResponse(LoanApplicationResponseCode responseCode, BaseResponseData<T> response) {
//		super(responseCode, response);
//	}
//
//	public BaseApiResponse(LoanApplicationResponseCode invalidArguementsPassed, List<String> fieldErrors) {
//		this(invalidArguementsPassed.getCode(), invalidArguementsPassed.getMessage(), null);
//		this.fieldErrors = fieldErrors;
//	}
//
//}
