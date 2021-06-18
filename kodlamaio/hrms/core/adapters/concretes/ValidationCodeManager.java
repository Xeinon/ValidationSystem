package kodlamaio.hrms.core.adapters.concretes;

import org.springframework.beans.factory.annotation.Autowired;

import kodlamaio.hrms.core.adapters.abstracts.ValidationCodeService;

public class ValidationCodeManager implements ValidationCodeService{

	private ValidationCodeManager validationCodeManager;

	@Autowired
	public ValidationCodeManager(ValidationCodeManager validationCodeManager) {
		this.validationCodeManager = validationCodeManager;
	}


	@Override
	public boolean sendValidationCode(String email) {
		return validationCodeManager.sendValidationCode(email);
	}

}
