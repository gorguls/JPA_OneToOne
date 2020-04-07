package by.bw.jpa.OneToMany;

import by.bw.jpa.OneToMany.entity.Passport;
import by.bw.jpa.OneToMany.entity.Person;
import by.bw.jpa.OneToMany.repository.PassportRepository;
import by.bw.jpa.OneToMany.repository.PersomRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class OneToManyApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OneToManyApplication.class, args);
	}

	@Autowired
	PersomRepositiry personRepositiry;

	@Autowired
	PassportRepository passportRepository;

	@Override
	public void run(String... args) throws Exception {
		Passport passport1 = new Passport("A111");
		Person person1 = new Person("Иванов", passport1);

		Passport passport2 = new Passport("B222");
		Person person2 = new Person("Петров", passport2);

		Passport passport3 = new Passport("С222");
		Person person3 = new Person("Сидоров", passport3);

		List<Person> personList = Arrays.asList(person1, person2, person3);

		personRepositiry.saveAll(personList);

		Passport passportForDel = passportRepository.findByNumber("B222");
		passportRepository.deleteById(passportForDel.getId());
	}
}
