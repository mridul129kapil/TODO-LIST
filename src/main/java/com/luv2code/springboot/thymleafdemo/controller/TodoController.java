package com.luv2code.springboot.thymleafdemo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.luv2code.springboot.thymleafdemo.entity.Record;
import com.luv2code.springboot.thymleafdemo.service.RecordService;


@Controller
@RequestMapping("/todos")
public class TodoController {

	private RecordService recordService;
	
	@Autowired
	public TodoController(RecordService theRecordService) {
		recordService=theRecordService;
	}
	
	@GetMapping("/list")
	public String listRecords(Model theModel)
	{
		//get from db
		List<Record> theRecords=recordService.findAll();
		
		//add to spring model
		theModel.addAttribute("records",theRecords);
		
		formSet(theModel);
		
		return "todo/home.html";
	}
	public void formSet(Model theModel)
	{
		Record record=new Record();
		theModel.addAttribute("record",record);
	}
	
	@GetMapping("/showForm")
	public String showAddForm(Model theModel)
	{
		//create model attribute to bind form data
		Record theRecord=new Record();
		
		//add attribute
		theModel.addAttribute("record", theRecord);
		
		return "redirect:/todos/list";
		
	}
//	
	@PostMapping("/save")
	public String saveRecord(@ModelAttribute("record") Record theRecord)
	{
		//System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>"+theRecord.isDone()+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		theRecord.setDate(LocalDate.now());
		recordService.save(theRecord);
		
		return "redirect:/todos/list";
		
	}
//	
//	@GetMapping("/updateForm")
//	public String showFormUpdate(@RequestParam("employeeId") int id,Model theModel)
//	{
//		Employee theEmp=employeeService.findById(id);
//		
//		theModel.addAttribute("employee",theEmp);
//		
//		return "employee/employeeForm";
//	}
//	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("recordId") int id)
	{
		recordService.deleteById(id);
		return "redirect:/todos/list";
	}
//	
//	
//	
	
	
	
	
	
	
}
