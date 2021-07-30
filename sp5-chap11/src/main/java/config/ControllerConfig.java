package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.LoginController;
import spring.AuthService;
import controller.RegisterController;
import spring.MemberRegisterService;
import survey.SurveyController;
import controller.ChangePwdController;
import spring.ChangePasswordService;

@Configuration
public class ControllerConfig {
	
	@Autowired
	private ChangePasswordService changePasswordService;
	
	@Autowired
	private MemberRegisterService memberRegSvc;
	@Autowired
	private AuthService authService;

	@Bean
	public ChangePwdController changePwdController() {
		ChangePwdController controller = new ChangePwdController();
		controller.setChangePasswordService(changePasswordService);
		return controller;
	}
	@Bean
	public RegisterController registerController() {
		RegisterController controller = new RegisterController();
		controller.setMemberRegisterService(memberRegSvc);
		return controller;
	}
	@Bean
	public LoginController loginController() {
		LoginController controller = new LoginController();
		controller.setAuthService(authService);
		return controller;
	}
	
	@Bean
	public SurveyController surveyController() {
		return new SurveyController();
	}
}
