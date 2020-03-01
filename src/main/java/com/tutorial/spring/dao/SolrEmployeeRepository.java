package com.tutorial.spring.dao;

import java.util.List;

import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import com.tutorial.spring.model.EmployeeDocument;

public interface SolrEmployeeRepository extends SolrCrudRepository<EmployeeDocument, String> {
	
	EmployeeDocument findById(Long id);

	@Query("name:*?0*")
	List<EmployeeDocument> findByName(String searchTerm);

	@Query("name:*?0* OR id:*?0* OR email:*?0* OR address:*?0* OR telephone:*?0*")
	List<EmployeeDocument> findByEmployeeQuery(String searchTerm);
}