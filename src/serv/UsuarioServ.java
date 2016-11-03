package serv;

import java.util.List;

import daoi.UsuarioDAOI;
import model.Usuario;

public class UsuarioServ extends UsuarioDAOI {

	@Override
	public Usuario validar(Usuario obj) throws Exception {
		return super.validar(obj);
	}

	@Override
	public Usuario insertar(Usuario obj) throws Exception {
		return super.insertar(obj);
		
	}

	@Override
	public List<Usuario> listar() throws Exception {
		return super.listar();
	}

	@Override
	public List<Usuario> buscar(Usuario obj) throws Exception {
		// TODO Auto-generated method stub
		return super.buscar(obj);
	}

	@Override
	public void eliminar(Usuario obj) throws Exception {
		// TODO Auto-generated method stub
		super.eliminar(obj);
		
	}
	
	@Override
	public Usuario obtener(Usuario obj) throws Exception {
		// TODO Auto-generated method stub
		return super.obtener(obj);
		
	}
	
	@Override
	public void actualizar(Usuario obj) throws Exception {
		// TODO Auto-generated method stub
		super.actualizar(obj);
		
	}

}
