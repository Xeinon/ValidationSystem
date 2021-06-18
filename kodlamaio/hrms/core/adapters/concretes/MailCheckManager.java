package kodlamaio.hrms.core.adapters.concretes;

import java.util.regex.Pattern;

import kodlamaio.hrms.core.adapters.abstracts.MailCheckService;

public class MailCheckManager implements MailCheckService{

	private static final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
	
	@Override
	public boolean checkEmail(String email) {
		Pattern p = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
		return p.matcher(email).find();
	}

}
