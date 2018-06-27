package com.jcg.examples.repo;

import java.util.Map;

import com.jcg.examples.bean.Person;

public interface PersonRepo 
{
		public void save(Person person);
		
		public Person find(String id);
		
		public Map<Object, Object> findAll();
		
		public void	delete(String id);
}
