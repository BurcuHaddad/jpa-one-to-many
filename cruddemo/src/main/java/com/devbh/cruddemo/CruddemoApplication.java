package com.devbh.cruddemo;

import com.devbh.cruddemo.dao.AppDao;
import com.devbh.cruddemo.entity.Instructor;
import com.devbh.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao) {
		return runner -> {
			createInstructor(appDao);
		};
	}

	private void createInstructor(AppDao appDao) {
		/*// create the instructor
		Instructor tempInstructor =
				new Instructor("Burcu", "Haddad", "burcu@bhdev.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("http://www.burcudev.com/youtube", "Coding");*/

		Instructor tempInstructor =
				new Instructor("Madhu", "Patel", "madhu@bhdev.com");
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("http://www.burcudev.com/youtube", "Guitar");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//save the instructor
		// NOTE: this will also save the details object
		// because of CascadeType.ALL

		System.out.println("Saving instructor: " + tempInstructor);
		appDao.save(tempInstructor);

		System.out.println("Done !");
	}

}
