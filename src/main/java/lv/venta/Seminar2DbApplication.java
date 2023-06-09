package lv.venta;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.models.Course;
import lv.venta.models.Degree;
import lv.venta.models.Grade;
import lv.venta.models.Professor;
import lv.venta.models.Programme;
import lv.venta.models.Student;
import lv.venta.repos.ICourseRepo;
import lv.venta.repos.IGradeRepo;
import lv.venta.repos.IProfessorRepo;
import lv.venta.repos.IStudentRepo;

@SpringBootApplication
public class Seminar2DbApplication {

	public static void main(String[] args) {
		SpringApplication.run(Seminar2DbApplication.class, args);
	}
	
	@Bean  //izsauks funkciju automātiski, kad startēsies sistēma
	public CommandLineRunner testModel(IProfessorRepo profRepo, IStudentRepo stRepo, ICourseRepo courRepo, IGradeRepo grrepo) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				
				ArrayList<Professor> professors = new ArrayList<>();
				
				Professor pr1 = new Professor("Karina", "Skirmante", Degree.mg);
				Professor pr2 = new Professor("Martins", "Saulitis", Degree.mg);
				profRepo.save(pr1);
				profRepo.save(pr2);
				
				professors.add(pr1);
				professors.add(pr2);
				
				
				
				Student st1 = new Student("Janis", "Berzins", Programme.BACHELOR);
				Student st2 = new Student("Baiba", "Kalnina", Programme.BACHELOR);
				stRepo.save(st1);
				stRepo.save(st2);
				
				
				//TODO uztaisīt kursu, kam ir divi profesori piesaistīti
				//TODO Uztaisīt gadījumu, kad viens profesors pasniedz divus kursus.
				Course c1 = new Course("Java", 4, professors);
				Course c2 = new Course("Datubazes", 4, new ArrayList<>(Arrays.asList(pr1, pr2))); //šādi arī var rakstīt, nevis kā c1 gadījumā
				Course c3 = new Course("Datustrukturas", 4, new ArrayList<>(Arrays.asList(pr1)));
				courRepo.save(c1);
				courRepo.save(c2);
				courRepo.save(c3);
				
				c1.addProfessor(pr1);
				c1.addProfessor(pr2);
				
				c2.addProfessor(pr1);
				c2.addProfessor(pr2);
				
				c3.addProfessor(pr1);
				//tik gari jāraksta, lai pārliecinātos, ka many to many strādā
				courRepo.save(c1);
				courRepo.save(c2);
				courRepo.save(c3);
				
				grrepo.save(new Grade(10, st1, c1)); //Jānis nopelnīja 10 JAVA
				grrepo.save(new Grade(6, st1, c2)); //Jānis  nopelnīja 6 Datubāzēs
				
				grrepo.save(new Grade(8, st2, c1)); //Baiba nopelnīja 8 JAVA
				grrepo.save(new Grade(10, st2, c2));
				
				//TODO izveidot jaunu zaru un pāriet uz to (git branch xxxx, git checkout xxx)
				//TODO jaunajā zarā pārveidot saiti starp profesoru un kursu uz ManyToMany
				//TODO pamainīt testModel funkciju, lai notestētu. Ieliekot katram pasniedzējam 2 kursus un
				//katram kursam divus pasniedzējus
				
				
				
			}
		};
	}

}
