package kodlamaio.hrms.api.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import kodlamaio.hrms.business.abstracts.SystemStaffService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemStaff;

@RestController
@RequestMapping("/api/systemstaffs")
public class SystemStaffsController {
	
	private SystemStaffService systemStaffService;
	
	@Autowired 
	public SystemStaffsController(SystemStaffService systemStaffService) {
		super();
		this.systemStaffService = systemStaffService;
	} 
	
	@GetMapping("/getall")
	public DataResult<List<SystemStaff>> getAll(){
		return this.systemStaffService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody SystemStaff systemStaff) {
		return this.systemStaffService.add(systemStaff);
	}
	
	
	
}
