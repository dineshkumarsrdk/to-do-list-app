package com.dine.todolistapp.todo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

//import jakarta.validation.constraints.Size;

@Entity
public class Todo {
	@Id
	@GeneratedValue
	private int ID;
	private String userID;
	//@Size(min=20, message="Maximum character limit is 20")
	private String description;
	private LocalDate targetDate;
	private String status;
	
	public Todo(){
		
	}
	
	public Todo(int ID, String userID, String description, LocalDate targetDate, String status) {
		super();
		this.ID = ID;
		this.userID = userID;
		this.description = description;
		this.targetDate = targetDate;
		this.status = status;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public String getUserID() {
		return userID;
	}
	public String getDescription() {
		return description;
	}
	public LocalDate getTargetDate() {
		return targetDate;
	}
	public String getStatus() {
		return status;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	@Override
	public String toString() {
		return "Todo [ID=" + ID + ", userID=" + userID + ", description=" + description + ", targetDate=" + targetDate
				+ ", status=" + status + "]";
	}
	
	
}
