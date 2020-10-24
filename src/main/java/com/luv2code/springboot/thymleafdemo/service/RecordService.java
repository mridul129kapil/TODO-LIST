package com.luv2code.springboot.thymleafdemo.service;

import java.util.List;

import com.luv2code.springboot.thymleafdemo.entity.Record;

public interface RecordService {
public List<Record> findAll();
	
	public Record findById(int theId);
	
	public void save(Record theRecord);
	
	public void deleteById(int theId);

}
