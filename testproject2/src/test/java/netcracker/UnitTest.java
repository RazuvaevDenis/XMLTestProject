package netcracker;
import static org.junit.Assert.*;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Test;

public class UnitTest {

	@Test
	public void test() {
		DOMConfigurator.configure("src/main/resources/log4j.xml");
		Logger log=Logger.getLogger(UnitTest.class);
		Student csfs = new CSFStudent("Ivan","Ivanov",20);
		String expected="My name is Ivan";
		assertEquals(expected,csfs.getName());
		log.log(Level.INFO, "Unit-test run");
		expected="My surname is Ivanov";
		assertEquals(expected,csfs.getSurname());
		log.log(Level.INFO, "Unit-test run");
		expected="My age is 20";
		assertEquals(expected,csfs.getAge());
		log.log(Level.INFO, "Unit-test run");
		expected="I am a student";
		assertEquals(expected,csfs.getPosition());
		log.log(Level.INFO, "Unit-test run");
		expected="My faculty is CSF";
		assertEquals(expected,csfs.faculty());
		log.log(Level.INFO, "Unit-test run");
	}
}
