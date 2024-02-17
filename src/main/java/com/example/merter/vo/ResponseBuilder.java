package com.example.merter.vo;

/**
 * 
 * @author Lenovo
 *
 */
public class ResponseBuilder {

	Object data;
	boolean isError;
	String message;

	public Object getData() {
		return data;
	}

	public ResponseBuilder setData(Object data) {
		this.data = data;
		return this;
	}

	public boolean isError() {
		return isError;
	}

	public ResponseBuilder setError(boolean isError) {
		this.isError = isError;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public ResponseBuilder setMessage(String message) {
		this.message = message;
		return this;
	}

	public Response build() {
		Response res = new Response(this);
		return res;
	}
}
