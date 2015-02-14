package com.tripoin.rest.DTO;

import org.codehaus.jackson.annotate.JsonProperty;

public abstract class ABaseRESTDTO {
	
	@JsonProperty("result")
	private int result;
	
	@JsonProperty("err_code")
	private int err_code;
	
	@JsonProperty("err_msg")
	private String err_msg;

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public int getErr_code() {
		return err_code;
	}

	public void setErr_code(int err_code) {
		this.err_code = err_code;
	}

	public String getErr_msg() {
		return err_msg;
	}

	public void setErr_msg(String err_msg) {
		this.err_msg = err_msg;
	}

	@Override
	public String toString() {
		return "ABaseRESTDTO [result=" + result + ", err_code=" + err_code
				+ ", err_msg=" + err_msg + "]";
	}
		

}
