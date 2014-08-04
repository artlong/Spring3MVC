package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.ItemService;
import service.UserService;
import vo.Item;

/**
 * @author X201
 *
 */
@Controller
public class HelloController {
	private static final Logger logger = Logger.getLogger(HelloController.class);

	@Autowired
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Autowired
	private ItemService itemService;

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

//	@RequestMapping(value = "welcome")
//	 public String welcome() {
//		return "login";
//	 }

	@RequestMapping(value = "login")
	public ModelAndView login(@RequestParam String name, @RequestParam Integer age, HttpServletRequest request) {
		logger.info("name [" + name + "] age [" + age + "]");
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", name);
		user.put("age", age);
		request.getSession().setAttribute("user", user);
		testItemService(name, age);
		return new ModelAndView("hello", "user", user);
	}
	
	private void testUserService(String name, int age) {
		logger.info("-------------" + userService + "--------------");
		logger.info("-------------" + userService.getUser() + "--------------");
		
	}
	
	private void testItemService(String name, int age) {
		Item iVo = new Item();
		iVo.setItemId("Test" + name);
		iVo.setProductId("FI-SW-01");
		iVo.setSupplier("1");
		iVo.setAttr1(name);
		iVo.setAttr2("" + age);

//		logger.info("------------- itemService.getItem --" + itemService.getItem() + "--------------");
//		logger.info("-------------####" + itemService.getAdultFemaleItem() + "####--------------");
//		logger.info("-------------itemService.updateItem " + itemService.updateItem(name) + "--------------");
//		logger.info("-------------====" + itemService.getAdultFemaleItem() + "====--------------");
		logger.info("-------------itemService.selectAllItem " + itemService.selectAllItem() + "####--------------");
		logger.info("-------------itemService.deleteItem " + itemService.deleteItem(iVo.getItemId()) + "####--------------");
		logger.info("-------------itemService.insertItem " + itemService.insertItem(iVo) + "####--------------");
		logger.info("-------------itemService.selectAllItem " + itemService.selectAllItem() + "####--------------");
	}


	@RequestMapping(value = "rest/{dep}/{emp}")
	public ModelAndView rest(@PathVariable String dep, @PathVariable String emp) throws Exception {
		logger.info("dep [" + dep + "] emp [" + emp + "]");
		Map<String, String> user = new HashMap<String, String>();
		user.put("dep", dep);
		user.put("emp", emp);
		if("aaa".equals(dep)) {
			throw new Exception("aaa");
		}
		return new ModelAndView("depEmp", "user", user);
	}
}
