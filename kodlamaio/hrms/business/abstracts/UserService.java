package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.User;

public interface UserService {

	Result addUser(User user);
	User getById(int id);
	DataResult<List<User>> getAll();
	
}
