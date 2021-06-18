package kodlamaio.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.adapters.abstracts.PersonCheckService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	private PersonCheckService personCheckService;
	
	private List<String> emailList = new ArrayList<String>();
	
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, PersonCheckService personCheckService) {
		super();
		this.candidateDao = candidateDao;
		this.personCheckService = personCheckService;
	}

	@Override
	public Result add(Candidate candidate) {
		if(emailList.contains(candidate.getEmail())) {
			System.out.println("E-posta adresi mevcut, başka bir adres giriniz.");
		}
		if(personCheckService.checkIfRealPerson(candidate)) {
			this.candidateDao.save(candidate);
		}
		return new SuccessResult("Candidate added.");
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Candidates listed");
	}

}
