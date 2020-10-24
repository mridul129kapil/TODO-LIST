package com.luv2code.springboot.thymleafdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.thymleafdemo.dao.RecordRepository;
import com.luv2code.springboot.thymleafdemo.entity.Record;

@Service
public class RecordServiceImpl implements RecordService {

	private RecordRepository recordRepository;
	
	@Autowired
	public RecordServiceImpl(RecordRepository theRecordRepository) {
		recordRepository=theRecordRepository;
	}
	
	@Override
	public List<Record> findAll() {
		return recordRepository.findAll();
	}

	@Override
	public Record findById(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Record theRecord) {
		recordRepository.save(theRecord);

	}

	@Override
	public void deleteById(int theId) {
		recordRepository.deleteById(theId);

	}

}
