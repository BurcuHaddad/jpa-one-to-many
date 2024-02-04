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
			//createInstructor(appDao);

			//findInstructor(appDao);

			//deleteInstructor(appDao);
			
			//findInstructorDetail(appDao);

			deleteInstructorDetail(appDao);
		};
	}

	private void deleteInstructorDetail(AppDao appDao) {
		int theId = 3;
		System.out.println("Deleting instructor detail id: " + theId);
		appDao.deleteInstructorDetailById(theId);
		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDao appDao) {

		// get the instructor detail object
		int theId = 2;
		InstructorDetail tempInstructorDetail = appDao.findInstructorDetailById(theId);
		// print the instructor detail
		System.out.println("tempInstructorDetail: " + tempInstructorDetail);
		// print the associated instructor
		System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());
		System.out.println("Done!");
	}

	private void deleteInstructor(AppDao appDao) {
		int theId = 1;
		System.out.println("Deleting instructor id: " + theId);
		appDao.deleteInstructorById(theId);
		System.out.println("Done!");

	}

	private void findInstructor(AppDao appDao) {
		int theId = 2;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDao.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated instructorDetail only: " + tempInstructor.getInstructorDetail());
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
