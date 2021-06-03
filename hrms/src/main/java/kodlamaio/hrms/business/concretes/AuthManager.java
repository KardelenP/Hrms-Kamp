package kodlamaio.hrms.business.concretes;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;


public class AuthManager implements AuthService{

	private EmployerService employerService;
	private CandidateService candidateService;
	
	@Autowired
	public AuthManager(EmployerService employerService, CandidateService candidateService) {
		super();
		this.employerService = employerService;
		this.candidateService = candidateService;
	}
	
	public static boolean isEmailValidation(String email) {
	    final Pattern EMAIL_REGEX = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
	    return EMAIL_REGEX.matcher(email).matches();
	}
	
	@Override
	public Result registerEmployer(Employer employer, String confirmPassword) {
		if(!isEmailValidation(employer.getEmail()))
		{
			return new ErrorResult("Invalid email address. Please enter your email address correctly.");
		}
		
		if(!employer.getPassword().equals( confirmPassword)) {
			return new ErrorResult("Password does not match. Please re-enter your password.");
		}
		
		return new ErrorResult();
	}

	@Override
	public Result registerCandidate(Candidate candidate, String confirmPassword) {
		if(!isEmailValidation(candidate.getEmail()))
		{
			return new ErrorResult("Invalid email address. Please enter your email address correctly.");
		}
		if(candidate.getPassword().equals( confirmPassword)) {
			return new ErrorResult("Password does not match. Please re-enter your password.");
		}

		return new ErrorResult();
	}


}
