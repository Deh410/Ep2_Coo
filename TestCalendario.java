package gerenciadores;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

public class TestCalendario {

	@Test
	public void test() {
		Calendar c = Calendar.getInstance();
		System.out.println(c.get(Calendar.NOVEMBER));
	}

}
