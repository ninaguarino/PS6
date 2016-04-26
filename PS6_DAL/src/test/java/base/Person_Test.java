package base;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;


public class Person_Test {

	private static final LocalDate LocalDate = null;
	private static PersonDomainModel per1;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		Date dDate = null;
		try {
			dDate = new SimpleDateFormat("yyyy-MM-dd").parse("1997-06-01");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		per1 = new PersonDomainModel();
		per1.setFirstName("Nina");
		per1.setFirstName("Guarino");
		per1.setBirthday(LocalDate);
		per1.setCity("Newark");
		per1.setPostalCode(19717);
		per1.setStreet("400 Academy Street");
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		PersonDomainModel per;
		PersonDAL.deletePerson(per1.getPersonID());
		per = PersonDAL.getPerson(per1.getPersonID());
		assertNull("This person will be removed from the database",per);
	}

	@Test
	public void AddPersonTest() {
		
		PersonDomainModel per;
		per = PersonDAL.getPerson(per1.getPersonID());
		assertNull("This person cannot be added to the database",per);
		PersonDAL.addPerson(per1);
		
		per = PersonDAL.getPerson(per1.getPersonID());
		System.out.println(per1.getPersonID() + " found");
		assertNotNull("This person can be added to the database",per);
	}
	
	@Test
	public void updatePersonTest() {
		
		PersonDomainModel per;
		final String C_LASTNAME = "Fusco";
		
		per = PersonDAL.getPerson(per1.getPersonID());
		assertNull("This person cannot be added to the database",per);
		PersonDAL.addPerson(per1);
		
		per1.setLastName(C_LASTNAME);
		PersonDAL.updatePerson(per1);
		
		per = PersonDAL.getPerson(per1.getPersonID());
		
		assertTrue("This name didn't change",per1.getLastName() == C_LASTNAME);
	}
	
	@Test
	public void deletePersonTest() {
		
		PersonDomainModel per;
		per = PersonDAL.getPerson(per1.getPersonID());
		assertNull("This person cannot be added to the database",per);
		
		PersonDAL.addPerson(per1);
		per = PersonDAL.getPerson(per1.getPersonID());
		System.out.println(per1.getPersonID() + " found");
		assertNotNull("This person cannot be added to the database",per);
		
		PersonDAL.deletePerson(per1.getPersonID());
		per = PersonDAL.getPerson(per1.getPersonID());
		assertNull("This person cannot be added to the database",per);
	}

}