package daol;



import java.util.List;

import model.Usuario;

public interface UsuarioDAOL {
	public abstract Usuario validar(Usuario obj) throws Exception;
	public abstract Usuario insertar(Usuario obj) throws Exception;
	public abstract List<Usuario> listar() throws Exception;
	public abstract List<Usuario> buscar(Usuario obj) throws Exception;
	public abstract void eliminar(Usuario obj) throws Exception;
	public abstract Usuario obtener(Usuario u) throws Exception;
	public abstract void actualizar(Usuario obj) throws Exception;
	
}
