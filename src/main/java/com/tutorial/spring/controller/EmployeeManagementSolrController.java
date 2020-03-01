package com.tutorial.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tutorial.spring.dao.SolrEmployeeRepository;
import com.tutorial.spring.model.EmployeeDocument;

@RestController
public class EmployeeManagementSolrController {

	@Autowired
	SolrEmployeeRepository solrEmployeeRepository;

	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public String createEmployee(@RequestBody EmployeeDocument employeeDocument) {
		String description = "Employee Created";
		solrEmployeeRepository.save(employeeDocument);
		return description;
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	public ModelAndView readEmployee(ModelAndView model, HttpServletRequest request,
			@PathVariable String id) {
		Long _id = StringUtils.isNotBlank(id) && StringUtils.isNumeric(id) ? Long.parseLong(id) : 0l;
		EmployeeDocument employeeDocument = new EmployeeDocument();
		if(_id > 0l) {
			employeeDocument = solrEmployeeRepository.findById(_id);
		}
		model.addObject("employee", employeeDocument);
		model.setViewName("employee-form");
		return model;
	}
	
	@RequestMapping(value = "/employee/delete/{id}", method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable String id) {
		String description = "Employee Deleted";
		Long _id = StringUtils.isNotBlank(id) && StringUtils.isNumeric(id) ? Long.parseLong(id) : 0l;
		solrEmployeeRepository.delete(solrEmployeeRepository.findById(_id));
		return description;
	}

	@RequestMapping(value = "/employee/by-name/{name}", method = RequestMethod.GET)
	public ModelAndView findEmployee(HttpServletRequest request, ModelAndView model,
			@PathVariable String name) throws IOException{
		List<EmployeeDocument> list = solrEmployeeRepository.findByName(name);
		model.addObject("keyword", name);
		model.addObject("employeeList", list);
		model.setViewName("list-employee");
		return model;
	}

	@RequestMapping(value = "/employee/search/{keyword}", method = RequestMethod.GET)
	public ModelAndView findEmployeeBySearchTerm(HttpServletRequest request, ModelAndView model,
			@PathVariable String keyword) {
		List<EmployeeDocument> list = solrEmployeeRepository.findByEmployeeQuery(keyword);
		model.addObject("keyword", keyword);
		model.addObject("employeeList", list);
		model.setViewName("list-employee");
		return model;
	}
}
