package com.jbk.practise.ApiWithJunit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.jbk.UIPojo.CountryUI;
import com.jbk.UIPojo.EmployeeUI;

public class TwelveAPITest extends ApiWithJunitApplicationTests
{
	@Autowired
	private MockMvc mvc;
	
	//1.Show Employee Test Test
	@Test
	public void ShowAllEmployeeTest() throws Exception 
	{
		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.get("http://localhost:9091/api/showallemployeehb")
			    .contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		int status = result.getResponse().getStatus();
		assertEquals(200, status);
	}
	
	//2.test to shwoAllEmp by status
	@Test
	public void ShowAllEmployeebyStatusTest() throws Exception 
	{
		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.get("http://localhost:9091/api/statushb/active")
				.contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		int status = result.getResponse().getStatus();
		assertEquals(200, status);
	}
	
	//3.test to showallEmp by ID
	@Test
	public void ShowAllEmployeebyIDTest() throws Exception 
	{
		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.get("http://localhost:9091/api/eidhb/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andReturn();

		int status = result.getResponse().getStatus();
		assertEquals(200, status);
	}
	
	//4.test to show all emp by name
	@Test
	public void ShowAllEmployeebyNameTest() throws Exception 
	{
		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.get("http://localhost:9091/api/enamehb/asmi")
				.contentType(MediaType.APPLICATION_JSON))
				.andReturn();

		int status = result.getResponse().getStatus();
		assertEquals(200, status);
	}
	
	//5.test to show allemp by created date
	@Test
	public void ShowAllEmployeebyCreatdDateTest() throws Exception 
	{
		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.get("http://localhost:9091/api/listofempbeforetodayhb/2020-07-04")
				.contentType(MediaType.APPLICATION_JSON))
				.andReturn();

		int status = result.getResponse().getStatus();
		assertEquals(200, status);
	}
	
	//6.test to add employee
	@Test
	public void AddEmployeeTest() throws Exception 
	{
		EmployeeUI e=new EmployeeUI();
		e.setName("Surabhi Manekar");
		e.setPhoneno("9874563210");
		e.setDepartment("EXTC");
		e.setStatus("Active");
		e.setCreateddtm("2020-06-16");
		e.setCreatedby("ankita");
		e.setUpdateddtm("2020-06-16");
		e.setUpdatedby("onkar");
		e.setCid(1);
		e.setCname("india");
		
		String input=mapToJson(e);
		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.post("http://localhost:9091/api/addemployeehb")
				.content(input)
				.contentType(MediaType.APPLICATION_JSON))
				.andReturn();

		int status = result.getResponse().getStatus();
		assertEquals(200, status);
	}
	
	//7.test to add country
	@Test
	public void AddCountryTest() throws Exception 
	{
		CountryUI con=new CountryUI();
		con.setCid(6);
		con.setCname("korea");
		
		String input=mapToJson(con);
		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.post("http://localhost:9091/api/addcountryhb")
				.content(input)
				.contentType(MediaType.APPLICATION_JSON))
				.andReturn();

		int status = result.getResponse().getStatus();
		assertEquals(200, status);
	}
	
	//8.test to update country
	@Test
	public void updateCountryTest() throws Exception 
	{
		CountryUI con=new CountryUI();
		con.setCid(6);
		con.setCname("New Zeeland");
		
		String input=mapToJson(con);
		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.put("http://localhost:9091/api/updatecountrynamehb")
				.content(input)
				.contentType(MediaType.APPLICATION_JSON))
				.andReturn();

		int status = result.getResponse().getStatus();
		assertEquals(200, status);
	}
	
	//9.test to update employee
	@Test
	public void updateEmployeeTest() throws Exception 
	{
		EmployeeUI e=new EmployeeUI();
		e.setId(15);
		e.setName("Surabhi Manekar");
		e.setPhoneno("9874563210");
		e.setDepartment("EXTC");
		e.setStatus("Active");
		e.setCreateddtm("2020-06-16");
		e.setCreatedby("ankita Wankhade");
		e.setUpdateddtm("2020-06-16");
		e.setUpdatedby("onkar Nimbalkar");
		e.setCid(1);
		e.setCname("india");
		
		String input=mapToJson(e);
		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.put("http://localhost:9091/api/updateEmployeeIdhb")
				.content(input)
				.contentType(MediaType.APPLICATION_JSON))
				.andReturn();

		int status = result.getResponse().getStatus();
		assertEquals(200, status);
	}
	
	//10. test to delete country by name
	@SuppressWarnings("unused")
	@Test
	public void deleteCountryTest() throws Exception 
	{
		
		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.delete("http://localhost:9091/api/deletebycountrynamehb/us")
				.contentType(MediaType.APPLICATION_JSON))
				.andReturn();

		int status = result.getResponse().getStatus();
		String content = result.getResponse().getContentAsString();
		assertEquals(200, status);
	}
	
	//11. test to delete the country by id
	@Test
	public void deleteCountrybyIDTest() throws Exception 
	{

		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.delete("http://localhost:9091/api/deletebycountrybyIdhb/19")
				.contentType(MediaType.APPLICATION_JSON))
				.andReturn();

		int status = result.getResponse().getStatus();
		
		assertEquals(200, status);
	
	}
	
	//12. test to delete the employee by id
	@Test
	public void deleteEmployyebyIdTest() throws Exception 
	{
		
		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.delete("http://localhost:9091/api/deleteemployeebyidhb/26")
				.contentType(MediaType.APPLICATION_JSON))
				.andReturn();

		int status = result.getResponse().getStatus();
		assertEquals(200, status);
	}
}
