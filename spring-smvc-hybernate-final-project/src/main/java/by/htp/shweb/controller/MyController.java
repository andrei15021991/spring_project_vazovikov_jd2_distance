package by.htp.shweb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import by.htp.shweb.entity.User;
import by.htp.shweb.service.UserService;

@Controller
@RequestMapping("/user")
public class MyController {

	@Autowired
	private UserService userService;

	@RequestMapping("/loginForm")
	public String loginForm(Model theModel) {

		User user = new User();

		theModel.addAttribute("user", user);

		return "loginForm";

	}

	@RequestMapping("/mainPage")
	public String mainPage(@ModelAttribute("user") User user, Model theModel, HttpSession session) {

		String login = user.getLogin();
		String password = user.getPassword();

		String errorMessage = null;

		user = userService.logination(login, password);

		if (user == null) {
			errorMessage = "wrong login or password";

			session.setAttribute("errorMessage", errorMessage);

			return "redirect:/user/loginForm";

		} else if (user.getUserDetail().getRole().equals("admin")) {
			session.setAttribute("user1", user);

			List<User> users = userService.getUsers();

			session.setAttribute("users", users);

			return "mainPage";

		} else {
			session.setAttribute("user1", user);

			return "userPage";
		}

	}

	@RequestMapping("/goToMainPage")
	public String goToMainPage(@ModelAttribute("user") User user, HttpSession session) {
		List<User> users = userService.getUsers();

		// session.setAttribute("user", user);
		session.setAttribute("users", users);

		return "mainPage";
	}

	@RequestMapping("/goToReg")
	public String goToRegForm(Model theModel) {

		User user = new User();

		theModel.addAttribute("user", user);

		return "regForm";
	}

	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {

		if (result.hasErrors()) {
			return "regForm";

		} else {
			userService.registration(user);

			session.setAttribute("user1", user);

			return "userPage";
		}
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("userId") int id) {

		userService.deleteUser(id);

		return "redirect:/user/goToMainPage";
	}

	@RequestMapping("/updateUser")
	public String updateUser(@RequestParam("userId") int id, Model model) {
		User user = userService.getUser(id);

		model.addAttribute("user", user);
		return "passwordPage";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("user") User user) {
		userService.registration(user);

		return "userPage";
	}

	@GetMapping("logoff")
	public String logOff(HttpSession session) {
		session.removeAttribute("errorMessage");

		return "redirect:/user/loginForm";
	}

}
