package com.example.ProyectoMovilesVir04.modelo;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
	// metadata
	private LocalDateTime timeStamp;
	private int statusCode;
	private HttpStatus status;
	private String reason;
	private String message;
	private String developerMessage;
	
	
	// data
	private Map<?, ?> data;

	private Response() {
	}

	Response(Builder builder) {
		timeStamp = builder.timeStamp;
		statusCode = builder.statusCode;
		status = builder.status;
		reason = builder.reason;
		message = builder.message;
		developerMessage = builder.developerMessage;
		data = builder.data;

	}

	public static Builder builder() {
		return new Builder();
	}

	public Map<?, ?> getData() {
		return data;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public String getReason() {
		return reason;
	}

	public String getMessage() {
		return message;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}






	public static class Builder {
		protected int statusCode;
		protected HttpStatus status;
		protected String reason;
		protected String message;
		protected String developerMessage;
		// data
		protected Map<?, ?> data;
		protected LocalDateTime timeStamp;

		public Builder TimeStamp(LocalDateTime timeStamp) {
			this.timeStamp = timeStamp;
			return this;
		}

		public Builder StatusCode(int statusCode) {
			this.statusCode = statusCode;
			return this;
		}

		public Builder Status(HttpStatus status) {
			this.status = status;
			return this;
		}

		public Builder Reason(String reason) {
			this.reason = reason;
			return this;
		}

		public Builder Message(String message) {
			this.message = message;
			return this;
		}

		public Builder DeveloperMessage(String developerMessage) {
			this.developerMessage = developerMessage;
			return this;
		}

		public Builder Data(Map<?, ?> data) {
			this.data = data;
			return this;
		}

		public Response build() {
			return new Response(this);
		}
	}
	
}
