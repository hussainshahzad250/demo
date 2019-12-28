package hussain.shahzad.java.responses.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import hussain.shahzad.java.enums.ResponseCode;

/**
 * 
 * @author shahzad
 *
 */
@JsonInclude(Include.NON_NULL)
public class BaseResponsePojo {

	private String status;
	private String msg;

	public BaseResponsePojo(ResponseCode roEmiResponseCode) {
		this(roEmiResponseCode.getMessage());
	}

	public BaseResponsePojo(String msg) {
		this.msg = msg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
