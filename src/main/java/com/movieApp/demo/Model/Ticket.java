package com.movieApp.demo.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Ticket {
	@Transient
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	   
	   @Id
	   @GeneratedValue
	   private int transactionId;
	   private int movie_id_fk;
	   private int no_of_tickets;
	   private String issueAt=formatter.format(new Date());
	public SimpleDateFormat getFormatter() {
		return formatter;
	}
	public void setFormatter(SimpleDateFormat formatter) {
		this.formatter = formatter;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getMovie_id_fk() {
		return movie_id_fk;
	}
	public void setMovie_id_fk(int movie_id_fk) {
		this.movie_id_fk = movie_id_fk;
	}
	public int getNo_of_tickets() {
		return no_of_tickets;
	}
	public void setNo_of_tickets(int no_of_tickets) {
		this.no_of_tickets = no_of_tickets;
	}
	public String getIssueAt() {
		return issueAt;
	}
	public void setIssueAt(String issueAt) {
		this.issueAt = issueAt;
	}
	   
	   

}
