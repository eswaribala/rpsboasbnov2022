package com.boa.bank.models;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

	private long amount;
	private String sender;
	private String receiver;
	private LocalDateTime dot;
}
