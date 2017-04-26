package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.util.List;
import pe.com.home.jdbc.Persona;
import pe.com.home.jdbc.PersonaDAO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:datasource-test.xml", "classpath:applicationContext.xml" })
public class TestPersonasDAOImpl {
	private static Log logger = LogFactory.getLog("TestPersonasDAOImpl");
	
	@Autowired
	private PersonaDAO personaDao;

	@Test
	public void deberiaMostrarPersonas() {
		try {
			System.out.println();
			logger.info("Inicio del test deberiaMostrarPersonas");
			List<Persona> personas = personaDao.findAllPersonas();
			int contadorPersonas = 0;
			for (Persona persona : personas) {
				logger.info("Persona: " + persona);
				contadorPersonas++;
			}
			// Segun el numero de personas recuperadas, deberia ser el mismo de
			// la tabla
			assertEquals(contadorPersonas, personaDao.contadorPersonas());
			logger.info("Fin del test deberiaMostrarPersonas");
		} catch (Exception e) {
			logger.error("Error JBDC", e);
		}
	}

}