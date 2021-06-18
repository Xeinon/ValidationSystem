package kodlamaio.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.adapters.abstracts.ValidationCodeService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;


public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	
	
	private List<String> emailList = new ArrayList<String>();
	private List<String> webAdressList = new ArrayList<String>();
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, ValidationCodeService validationCodeService) {
		super();
		this.employerDao = employerDao;
		//
	}

	@Override
	public Result add(Employer employer) {
		if (emailList.contains(employer.getEmail())){
            System.out.println("E-posta adresi mevcut, başka bir adres giriniz.");
        }
		if(emailList.contains(employer.getEmail()) == webAdressList.contains(employer.getWebAdress())) {
			System.out.println("E-posta ve Web adresiniz aynı olmak zorunda!");
		}
		return new SuccessResult();
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Data listed");
	}

}
