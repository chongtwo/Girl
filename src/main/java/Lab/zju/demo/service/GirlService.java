package Lab.zju.demo.service;

import Lab.zju.demo.DAO.Girl;
import Lab.zju.demo.DAO.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GirlService {

	@Autowired
	private GirlRepository girlRepository;

	public void insertTwo(){
		Girl girlA = new Girl();
		girlA.setAge(25);
		girlA.setName("Lily");
		girlRepository.save(girlA);

		Girl girlB = new Girl();
		girlB.setAge(24);
		girlB.setName("Lucy");
		girlRepository.save(girlB);
	}
}
