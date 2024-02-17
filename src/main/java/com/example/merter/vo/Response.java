package com.example.merter.vo;

/**
 * 
 * @author Lenovo
 *
 */
public class Response {
	Object data;
	boolean isError;
	String message;

	public Response(ResponseBuilder rb) {
		this.data=rb.getData();
		this.isError=rb.isError();
		this.message=rb.getMessage();

	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public boolean isError() {
		return isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
