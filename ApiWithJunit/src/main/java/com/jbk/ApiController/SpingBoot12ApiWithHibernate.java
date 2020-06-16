package com.jbk.ApiController;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.HibernatePOJO.CountryHibernate;
import com.jbk.HibernatePOJO.EmployeeHibernate;
import com.jbk.UIPojo.CountryUI;
import com.jbk.UIPojo.EmployeeUI;

@RestController
@CrossOrigin
@RequestMapping("api")
@ComponentScan("com.jbk")
public class SpingBoot12ApiWithHibernate {

	@Autowired
	SessionFactory sf;

	
	@SuppressWarnings("unchecked")
	@GetMapping("/showallemployeehb")
	public ResponseEntity<List<EmployeeHibernate>> getShowallEmployee() {
		System.out.println("show All Employee api is getting hit");
		Session session = sf.openSession();
		Criteria criteria=session.createCriteria(EmployeeHibernate.class);
		List<EmployeeHibernate> list = criteria.list();
		System.out.println(list);
		return new ResponseEntity<List<EmployeeHibernate>>(list, HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/statushb/{status}")
	public ResponseEntity<List<EmployeeHibernate>> getStatusActive(@PathVariable("status") String status){
		System.out.println("show All Employee by status api is getting hit");
		Session session = sf.openSession();
		Criteria criteria=session.createCriteria(EmployeeHibernate.class);
		criteria.add(Restrictions.eq("status", status));
		List<EmployeeHibernate> list = criteria.list();
		System.out.println(list);
		return new ResponseEntity<List<EmployeeHibernate>>(list, HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/eidhb/{id}")
	public ResponseEntity<List<EmployeeHibernate>> getEmployeebyId(@PathVariable("id") int id) {
		System.out.println("show All Employee by id api is getting hit");
		Session session = sf.openSession();
		Criteria criteria=session.createCriteria(EmployeeHibernate.class);
		criteria.add(Restrictions.eq("id", id));
		List<EmployeeHibernate> list = criteria.list();
		System.out.println("list >>"+list);
		return new ResponseEntity<List<EmployeeHibernate>>(list, HttpStatus.OK);
		
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/enamehb/{name}")
	public ResponseEntity<List<EmployeeHibernate>> getEmployeebyName(@PathVariable("name") String name){
		System.out.println("show All Employee by name api is getting hit");
		Session session = sf.openSession();
		Criteria criteria=session.createCriteria(EmployeeHibernate.class);
		criteria.add(Restrictions.eq("name", name));
		List<EmployeeHibernate> list = criteria.list();
		System.out.println("list >>"+list);
		return new ResponseEntity<List<EmployeeHibernate>>(list, HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/listofempbeforetodayhb/{createddtm}")
	public ResponseEntity<List<EmployeeHibernate>> getEmployeesOfToday(@PathVariable("createddtm") String ddtm){
		System.out.println("show All Employee for Today api is getting hit");
		Session session = sf.openSession();
		Criteria criteria=session.createCriteria(EmployeeHibernate.class);
		criteria.add(Restrictions.eq("createddtm", ddtm));
		List<EmployeeHibernate> list = criteria.list();
		System.out.println("list >>"+list);
		return new ResponseEntity<List<EmployeeHibernate>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/addemployeehb")
	public ResponseEntity<String> addEmployee(@RequestBody EmployeeUI emp) {
		
		System.out.println("Add Employee api is getting hit");
		
		EmployeeHibernate hb=new EmployeeHibernate();
		hb.setName(emp.getName());
		hb.setPhoneno(emp.getPhoneno());
		hb.setDepartment(emp.getDepartment());
		hb.setStatus(emp.getStatus());
		hb.setCreateddtm(emp.getCreateddtm());
		hb.setCreatedby(emp.getCreatedby());
		hb.setUpdateddtm(emp.getUpdateddtm());
		hb.setUpdatedby(emp.getUpdatedby());
		CountryHibernate con=new CountryHibernate();
		con.setCid(emp.getCid());
		con.setCname(emp.getCname());
		hb.setCountry(con);
		
		
		Session session = sf.openSession();
		Transaction tx=session.beginTransaction();
		session.save(hb);
		tx.commit();
		System.out.println("emp");
		return new ResponseEntity<>("employee added Successfully", HttpStatus.OK);
		
	}
	
	@PostMapping("/addcountryhb")
	public ResponseEntity<String> addCountry(@RequestBody CountryUI country) {
		System.out.println("Add Country api is getting hit");
		CountryHibernate con=new CountryHibernate();
		con.setCid(country.getCid());
		con.setCname(country.getCname());
		Session session = sf.openSession();
		Transaction tx=session.beginTransaction();
		session.save(con);
		tx.commit();
		return new ResponseEntity<>("country added Successfully", HttpStatus.OK);
		
	}
	
	
	@PutMapping("/updatecountrynamehb")
		public  ResponseEntity<String> updateCountryName(@RequestBody CountryUI country) {
	        System.out.println("Update Country by name api is getting hit");
	        Session session = sf.openSession();
			Transaction tx=session.beginTransaction();
			CountryHibernate con =session.load(CountryHibernate.class, country.getCid());
			con.setCname(country.getCname());
			session.saveOrUpdate(con);
			tx.commit();
			return new ResponseEntity<>("country updatd successfully", HttpStatus.OK);
		 }
	
	@PutMapping("/updateEmployeeIdhb")
	public  ResponseEntity<String> updateEmployeeID(@RequestBody EmployeeUI employee) {
		System.out.println("update employee by id api is gettingg hit");
		Session session = sf.openSession();
		Transaction tx=session.beginTransaction();
		
		EmployeeHibernate emp =session.load(EmployeeHibernate.class, employee.getId());
		emp.setName(employee.getName());
		emp.setPhoneno(employee.getPhoneno());
		emp.setDepartment(employee.getDepartment());
		emp.setStatus(employee.getStatus());
		emp.setCreateddtm(employee.getCreateddtm());
		emp.setCreatedby(employee.getCreatedby());
		emp.setUpdateddtm(employee.getUpdateddtm());
		emp.setUpdatedby(employee.getUpdatedby());
		CountryHibernate con=new CountryHibernate();
		con.setCid(employee.getCid());
		con.setCname(employee.getCname());
		emp.setCountry(con);
		
		session.saveOrUpdate(emp);
		tx.commit();
		return new ResponseEntity<>("employee updatd by id successfully", HttpStatus.OK);
	}
	
	 @SuppressWarnings("unchecked")
	@DeleteMapping("/deletebycountrynamehb/{cname}")
		public ResponseEntity<String> deletebyCountryName(@PathVariable("cname") String cname) {
		 System.out.println("delete country by name api is getting hit");
		    Session session = sf.openSession();
		    Criteria criteria=session.createCriteria(CountryHibernate.class);
			criteria.add(Restrictions.eq("cname", cname));
			List<CountryHibernate> list=criteria.list();
		     for(CountryHibernate ctr:list)
		     {
					Transaction tx=session.beginTransaction();
					session.delete(ctr);
					tx.commit();
					System.out.println("Country Deleted....");
		     }
           
		    return new ResponseEntity<>("country deleted by name successfully", HttpStatus.OK);
		 
	 }
	 
	 @SuppressWarnings("unchecked")
	@DeleteMapping("/deletebycountrybyIdhb/{cid}")
		public ResponseEntity<String> deletebyCountryId(@PathVariable("cid") int cid) {
		 System.out.println("delete country by cid api is getting hit");
		    Session session = sf.openSession();
		    Criteria criteria=session.createCriteria(CountryHibernate.class);
			criteria.add(Restrictions.eq("cid", cid));
			List<CountryHibernate> list=criteria.list();
		     for(CountryHibernate ctr:list)
		     {
					Transaction tx=session.beginTransaction();
					session.delete(ctr);
					tx.commit();
					System.out.println("Country Deleted....");
		     }
		    return new ResponseEntity<>("country deleted by id successfully", HttpStatus.OK);
		 
	 }
	 @SuppressWarnings("unchecked")
	@DeleteMapping("/deleteemployeebyidhb/{id}")
		public ResponseEntity<String> deletebyEmployeeId(@PathVariable("id") int id){
		    Session session = sf.openSession();
		    Criteria criteria=session.createCriteria(EmployeeHibernate.class);
			criteria.add(Restrictions.eq("id", id));
			List<EmployeeHibernate> list=criteria.list();

			for(EmployeeHibernate ctr:list)
		     {
					Transaction tx=session.beginTransaction();
					session.delete(ctr);
					tx.commit();
					System.out.println("employee Deleted....");
		     }
			return new ResponseEntity<>("employee deleted by id successfully", HttpStatus.OK);
	 }

}
