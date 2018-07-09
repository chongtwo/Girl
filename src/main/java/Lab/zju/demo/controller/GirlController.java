package Lab.zju.demo.controller;

import Lab.zju.demo.DAO.Girl;
import Lab.zju.demo.DAO.GirlRepository;
import Lab.zju.demo.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GirlController {

	@Autowired
	private GirlRepository girlRepository;

	@Autowired
	private GirlService girlService;
	/**
	 * 查询所有女生列表
	 * @return
	 */
	@GetMapping(value = "/girls")
	public List<Girl> girlList(){
		return girlRepository.findAll();
	}

	/**
	 * 添加一个女生
	 * @param name
	 * @param age
	 * @return
	 */
	@PostMapping(value = "/girls")
	public Girl girlAdd(@RequestParam("name") String name,
						   @RequestParam("age") Integer age){
		Girl girl = new Girl();
		girl.setName(name);
		girl.setAge(age);
		return girlRepository.save(girl);
	}

	/**
	 * 查询一个女生
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/girls/{id}")
	public Girl girlFindOne(@PathVariable("id") Integer id){
		return girlRepository.findById(id).get();
	}

	/**
	 * 修改
	 * @param id
	 * @param name
	 * @param age
	 * @return
	 */
	@PutMapping(value = "/girls/{id}")
	public Girl girlUpdate(@PathVariable("id") Integer id,
						     @RequestParam("name") String name,
						     @RequestParam("age") Integer age){
		Girl girl = new Girl();
		girl.setId(id);
		girl.setName(name);
		girl.setAge(age);

		return girlRepository.save(girl);
	}

	/**
	 * 删除一个女生
	 * @param id
	 */
	@DeleteMapping(value = "girls/{id}")
	public void DeleteOne(@PathVariable("id") Integer id){
		girlRepository.deleteById(id);
	}

	/**
	 * 自定义查询字段-age
	 * @param age
	 * @return
	 */
	@GetMapping(value = "girls/age/{age}")
	public List<Girl> girlListByAge(@PathVariable("age") Integer age){
		return girlRepository.findByAge(age);
	}

	@PostMapping(value = "girls/two")
	public void insertTwoGirls(){
		girlService.insertTwo();
	}





}
