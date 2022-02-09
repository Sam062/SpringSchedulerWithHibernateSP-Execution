package base.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import base.service.EmployeeService;

@Configuration
@EnableScheduling
public class AppSchedulerConfig {
	@Autowired
	private EmployeeService serv;

	@Scheduled(fixedRate = 600000l)
	public void generateReport() {
		System.out.println("\n************** INSIDE GENERATE REPORT ************** ");
		serv.getAllEmpBySp();
	}

}
