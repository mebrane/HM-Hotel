package serv;

import java.util.List;

import daoi.PersonaDAOI;
import model.Persona;
import model.Usuario;

public class PersonaServ extends PersonaDAOI {

	@Override
	public Persona insertar(Persona obj) throws Exception {
		return super.insertar(obj);
		
	}

	@Override
	public List<Persona> listar() throws Exception {
		// TODO Auto-generated method stub
		return super.listar();
	}

	@Override
	public List<Persona> buscar(Persona obj,Usuario usu) throws Exception {
		// TODO Auto-generated method stub
		return super.buscar(obj, usu);
	}

	@Override
	public void eliminar(Persona obj) throws Exception {
		super.eliminar(obj);
		// TODO Auto-generated method stub
		
	}

}
