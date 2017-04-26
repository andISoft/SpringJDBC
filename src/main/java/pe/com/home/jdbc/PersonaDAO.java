package pe.com.home.jdbc;

import java.util.List;

public interface PersonaDAO {
	void insertPersona(Persona persona);

	void updatePersona(Persona persona);

	void deletePersona(Persona persona);

	Persona findPersonaById(long idPersona);

	List<Persona> findAllPersonas();

	int contadorPersonasPorNombre(Persona persona);

	int contadorPersonas();

	Persona getPersonaByEmail(Persona persona);

}
