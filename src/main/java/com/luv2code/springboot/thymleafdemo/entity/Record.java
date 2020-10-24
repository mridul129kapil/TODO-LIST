package com.luv2code.springboot.thymleafdemo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "record")
public class Record {

	public Record() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "info")
	private  String info;
	
	@Column(name = "done")
	private boolean done;
	
	@Column(name = "date")
	private LocalDate date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Record(String info, boolean done, LocalDate date) {
		this.info = info;
		this.done = done;
		this.date = date;
	}

	@Override
	public String toString() {
		return "Record [id=" + id + ", info=" + info + ", done=" + done + ", date=" + date + "]";
	}
	
	
	
	
}
