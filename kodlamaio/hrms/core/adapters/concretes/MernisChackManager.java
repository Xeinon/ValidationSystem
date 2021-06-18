package kodlamaio.hrms.core.adapters.concretes;


import kodlamaio.hrms.core.adapters.abstracts.PersonCheckService;
import kodlamaio.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;


public class MernisChackManager implements PersonCheckService{

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		KPSPublicSoapProxy proxy = new KPSPublicSoapProxy();
	
		boolean result = false;
		
		try 
		{
			result = proxy.TCKimlikNoDogrula(Long.parseLong(candidate.getNationalIdentity()), 
											  candidate.getFirstName().toUpperCase(), 
											  candidate.getLastName().toUpperCase(), 
											  candidate.getDateOfBirth().getYear());		
		} 
		catch (Exception e) 
		{
			System.out.println("Not a valid person");
		}
		
		return result;
	}

}
