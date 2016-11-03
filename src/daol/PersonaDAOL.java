package daol;

import java.util.List;

import model.Persona;
import model.Usuario;

public interface PersonaDAOL {

	public abstract Persona insertar(Persona obj) throws Exception;
	public abstract List<Persona> listar() throws Exception;
	public abstract List<Persona> buscar(Persona obj, Usuario  oUsuario) throws Exception;
	public abstract void eliminar(Persona obj) throws Exception;
	void actualizar(Persona obj) throws Exception;
}
