/*package com.cybage.controller;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.exceptions.UserDefinedException;
import com.cybage.model.Customer;
import com.cybage.model.Insurance;
import com.cybage.services.CustomerService;
import com.cybage.services.InsuranceService;

@RestController //Default to message conversion
objects returned from those methods will still go through
message conversion to produce a resource representation for the client
public class RestControllerImpl {

private static final Logger logger = Logger.getLogger(MainController.class);

static int update_id;
static int insupdate_id;

@Autowired
CustomerService customerservice;

@Autowired
InsuranceService insuranceservice;

@InitBinder
public void initBinder(WebDataBinder webDataBinder) {
 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
 dateFormat.setLenient(false);
 webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
 }

@RequestMapping(value="/", method=RequestMethod.GET)
public String index(Model model) 
{ 
   model.addAttribute("msg", "This is index page");
   return "index";
}

	@RequestMapping(value="/homepage",method=RequestMethod.GET)
public String list(Model model)
{   
	logger.info("in homepage... maincontroller");
	List<Insurance> allinsurance= insuranceservice.getInsurance();
	model.addAttribute("allinsurance", allinsurance);
	return "homepage";
}

@RequestMapping(value="/allcustomers",method=RequestMethod.GET)
public String showAllCustomers(Model model)
{ 
	logger.info("in showallCustomers...maincontroller");
	List<Customer> allcustomers= customerservice.getCustomer();
	model.addAttribute("allcustomers", allcustomers);
	return "allcustomers";
}

@RequestMapping(value="/add",method=RequestMethod.POST,consumes="application/json")
public String add(@RequestBody Customer customer)//@ModelAttribute("SpringWeb")
{ 
	System.out.println("in add... maincontroller");
	return "addcustomer";
	
}

@RequestMapping(value="/addCustomer",method= RequestMethod.POST ,consumes="application/json")
 public String addCustomer(@RequestBody Customer customer)throws UserDefinedException
{  
    System.out.println("in main controller.. addCustomer");
    if((customer.getName().length()>55)||(customer.getName().isEmpty()))
    {
    throw new UserDefinedException("Name is empty or invalid", "Name should have 55 chars only");
    }
    if(customer.getAddress().length()>255||(customer.getAddress().isEmpty()))
    {throw new UserDefinedException("Address is empty or invalid","Address should have 255 chars only");}
    if((customer.getPhone().toString().length()>11)||(customer.getPhone().toString().isEmpty()))
    {throw new UserDefinedException("not a valid phone no.", "not a valid phone no.");}
    if(customer.getDob().toString().isEmpty())
    {throw new UserDefinedException("Not a Valid Date of Birth", "Enter Correct Dob in 'YYYY-MM-DD' format");}
	customerservice.addCustomer(customer);
	return "redirect:/allcustomers";
	
}

@RequestMapping(value="/edit/{id}",method= RequestMethod.PUT)
public String editCustomer(ModelMap model,@RequestParam(value="id") int id)
{  
	logger.debug("in main controller.. edit"+id);
	System.out.println("in main controller.. edit"+id);
	List customer= customerservice.searchCustomer(id);
	Customer cust= (Customer) customer.get(0);
	System.out.println(cust);
	update_id=id;
	model.addAttribute("customerId",update_id);
	if((cust.getName().length()>55)||(cust.getName().isEmpty()))
    {
    throw new UserDefinedException("Name is empty or invalid", "Name should have 55 chars only");
    }
	model.addAttribute("name",cust.getName());
	
	 if(cust.getAddress().length()>255||(cust.getAddress().isEmpty()))
	    {throw new UserDefinedException("Address is empty or invalid","Address should have 255 chars only");}
	 
	model.addAttribute("address", cust.getAddress());
	
	if((cust.getPhone().toString().length()>11)||(cust.getPhone().toString().isEmpty()))
    {throw new UserDefinedException("not a valid phone no.", "not a valid phone no.");}
   
	model.addAttribute("phone", cust.getPhone());
	
	
	 if(cust.getDob().toString().isEmpty())
	    {throw new UserDefinedException("Not a Valid Date of Birth", "Enter Correct Dob in 'YYYY-MM-DD' format");}
	
	model.addAttribute("dob",cust.getDob());
	return "updatecustomer";
}

@RequestMapping(value="/updateCustomer",method=RequestMethod.POST,consumes="application/json")
public String updateCustomer(@RequestBody Customer customer)
{
	System.out.println("in maincontroller.. update customer");
	customerservice.updateCustomer(customer,update_id);
	return "redirect:/allcustomers";
}

@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
public String deleteCustomer(ModelMap model,@RequestParam(value="id") int id)
{
  logger.info("in main controller...delete"+id);
  System.out.println("in main controller...delete"+id);
  customerservice.removeCustomer(id);
  return "redirect:/allcustomers";}

  
   * ----- Code for adding delete confirmation page---
   * List customer= customerservice.searchCustomer(id);
  Customer cust= (Customer) customer.get(0);
  System.out.println(cust);
  delete_id=id;
  model.addAttribute("customerId",delete_id);
  model.addAttribute("name",cust.getName());
  model.addAttribute("phone",cust.getPhone());		
	return "deletecustomer";
}

@RequestMapping(value="/deleteConfirm/{id}")
public String deleteConfirm(@ModelAttribute("SpringWeb")Customer customer)
{   
	System.out.println("in maincontroller.. deleteConfirm");
	customerservice.removeCustomer(delete_id);
	return "redirect:/allcustomers";
}

@RequestMapping(value="/viewinsurance/{id}",method=RequestMethod.GET)
public String viewInsurance(ModelMap model,@RequestParam(value="id") int id)
{
    System.out.println("in view insurance .. main controller"+" "+id);
	logger.info("in view insurance .. main controller"+" "+id);
	List<Insurance> insurance= customerservice.searchInsurance(id);
	System.out.println("List of insurance to customer"+insurance);
	model.addAttribute("insurance",insurance);
	for (Insurance ins:insurance)
	{
	 model.addAttribute("insuranceid", ins.getInsuranceid());
	 model.addAttribute("insurancecode", ins.getInsurancecode());
	 model.addAttribute("type",ins.getType());
	 model.addAttribute("dateOfIssuance",ins.getDateofIssuance());
	 model.addAttribute("dateOfRenewal",ins.getDateofRenewal());
	 model.addAttribute("dateOfExpiry", ins.getDateofExpiry());
	 model.addAttribute("customer.customerId",ins.getCustomer().getCustomerId());
	}
	
	return "viewCustomerInsurance";
}


@RequestMapping(value="/allinsurance", method=RequestMethod.GET)
public String showAllInsurance(Model model)
{
	logger.info("in showallInsurance...maincontroller");
	List<Insurance> allinsurance= insuranceservice.getInsurance();
	model.addAttribute("allinsurance", allinsurance);
	return "allinsurance";	
}


 * 
 * to view details of customer linked to an insurance.
 * 
 * @RequestMapping("/viewcustomer/{code}")
public String viewCustomer(ModelMap model,@PathVariable String code)
{
	System.out.println("in maincontroller.. View Customer"+code);
	List<Customer> cust=insuranceservice.searchCustomer(code);
	System.out.println("List of customer with insurancecode.."+cust);
    model.addAttribute("cust",cust);
	return "viewcustomerdetails";
}

@RequestMapping(value="/addnew")
public String addNew(@ModelAttribute("SpringWeb")Insurance insurance)
{ 
	System.out.println("in addnew... maincontroller");
	return "addinsurance";
	
}

@RequestMapping(value="/addInsurance",method= RequestMethod.POST,consumes="application/json")
 public String addInsurance(@RequestBody Insurance insurance)
{  
	List<Customer>cust=customerservice.getCustomer();
    System.out.println("in main controller.. addInsurance"+" "+insurance);
    if(insurance.getDateofExpiry().before(insurance.getDateofIssuance()))
    {
    throw new UserDefinedException("Invalid date of expiry", "Date of expiry should be after date of issuance");	
    }  
    if(insurance.getDateofRenewal().before(insurance.getDateofIssuance()))
    {
     throw new UserDefinedException("invalid date of renewal","renewal date should be after date of issuance");	
    }
    for(Customer c:cust)
    {
     if(insurance.getCustomer()!=c)
     {
      throw new UserDefinedException("Not a valid Customer.. Check customer id","Register the Customer First!!");
     }
    }
    
	insuranceservice.addInsurance(insurance);
	return "redirect:/allinsurance";
}

@RequestMapping(value="/editins/{id}",method=RequestMethod.PUT)
public String editInsurance(ModelMap model,@RequestParam(value="id") int id)
{  
	logger.debug("in main controller.. edit"+id);
	System.out.println("in main controller.. editins"+id);
	List insurance= insuranceservice.searchInsurance(id);
	Insurance ins= (Insurance) insurance.get(0);
	System.out.println(ins);
	insupdate_id=id;
	model.addAttribute("insuranceId",insupdate_id);
	model.addAttribute("insurancecode",ins.getInsurancecode());
	model.addAttribute("type", ins.getType());
	model.addAttribute("dateOfIssuance", ins.getDateofIssuance());
	model.addAttribute("dateOfRenewal",ins.getDateofRenewal());
	model.addAttribute("dateOfExpiry",ins.getDateofExpiry());
	model.addAttribute("customer.customerId",ins.getCustomer().getCustomerId());
	return "updateinsurance";
}

@RequestMapping(value="/updateInsurance",method=RequestMethod.POST,consumes="application/json")
public String updateInsurance(@RequestBody Insurance insurance)
{
	System.out.println("in maincontroller.. update customer");
	insuranceservice.updateInsurance(insurance,insupdate_id);
	return "redirect:/allinsurance";
}

@RequestMapping(value="/deleteinsurance/{id}",method=RequestMethod.DELETE)
public String deleteInsurance(ModelMap model,@RequestParam(value="id") int id)
{
  logger.info("in main controller...delete"+id);
  System.out.println("in main controller...delete"+id);
  insuranceservice.removeInsurance(id);;
  return "redirect:/allinsurance";}

@RequestMapping(value="/sortCustomerByName",method=RequestMethod.GET)
public String sortCustomerByName(ModelMap model)
{
  List<Customer> allcustomers= customerservice.getCustomer();
  Collections.sort(allcustomers, new com.cybage.dao.sortCustomerByName() );
  model.addAttribute("allcustomers",allcustomers);
	return "allcustomers";
}

@RequestMapping(value="/sortInsuranceByDateOfIssuance",method=RequestMethod.GET)
public String sortInsuranceByDateOfIssuance(ModelMap model)
{
 List<Insurance> allinsurance=insuranceservice.getInsurance();
 Collections.sort(allinsurance, new com.cybage.dao.sortInsuranceByDateOfIssuance());
 model.addAttribute("allinsurance",allinsurance);
  return "allinsurance";
}
@RequestMapping(value="/sortInsuranceByDateOfExpiry",method=RequestMethod.GET)
public String sortInsuranceByDateOfExpiry(ModelMap model)
{
 List<Insurance> allinsurance=insuranceservice.getInsurance();
 Collections.sort(allinsurance, new com.cybage.dao.sortInsuranceByDateOfExpiry());
 model.addAttribute("allinsurance",allinsurance);
  return "allinsurance";
}

@RequestMapping(value="/sortInsuranceByCustomerId",method=RequestMethod.GET)
public String sortInsuranceByCustomerId(ModelMap model)
{
	System.out.println("in sort by CustomerId .. MainController..");
   List<Insurance> allinsurance=insuranceservice.getInsurance();
   Collections.sort(allinsurance,new com.cybage.dao.sortInsuranceByCustomerId());
	model.addAttribute("allinsurance",allinsurance);
	return "allinsurance";
}



}
*/