package com.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Employee{
	int id;
	String name;
	Employee(int i,String n){
		this.id=i;
		this.name=n;
	}
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + id;
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		return result;
//	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	@Override
	public boolean equals(Object obj) {

		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}
public class TestinghashMap {

	public static void main(String[] args) {
		Map<Employee,String> e=new HashMap<Employee,String>();
		Employee e1=new Employee(1, "Naman");
		Employee e2=new Employee(1, "Naman");
		System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());
		
		e.put(e1, e1.name);
		e.put(e2, e1.name);
		
//		System.out.println(e.get(e2));
		
		System.out.println(e);
//		e1.name="Aman";
		e2.id=1;
//		System.out.println(e);
//		System.out.println(e1.hashCode());
//		System.out.println(e.get(e2));
		
		
	}
}
