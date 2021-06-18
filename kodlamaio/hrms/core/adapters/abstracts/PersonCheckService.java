package kodlamaio.hrms.core.adapters.abstracts;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface PersonCheckService {
	
	public boolean checkIfRealPerson(Candidate candidate);
}
