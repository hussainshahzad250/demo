package hussain.shahzad.java.exception;

import org.springframework.http.HttpStatus;

import hussain.shahzad.java.enums.ResponseCode;

/**
 * 
 * @author shahzad.hussain
 *
 */
public class MyAppException extends RuntimeException {

	private static final long serialVersionUID = -2109770668634776728L;

	public int code;
	public String message;
	public HttpStatus httpStatus;

	public MyAppException(String msg) {
		super(msg);
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public MyAppException(String message, HttpStatus httpStatus) {
		this.message = message;
		this.code = httpStatus.value();
		this.httpStatus = httpStatus;
	}

	public MyAppException(ResponseCode personNotFound, HttpStatus httpStatus) {
		this.code = httpStatus.value();
		this.httpStatus = httpStatus;
		this.message = personNotFound.getMessage();

	}

	public int getCode() {
		return code;
	}

}
