package com.boa.customerapi.exceptions;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
	  private LocalDateTime timestamp;
	  private String message;
	  private List<String> details;

	 
}