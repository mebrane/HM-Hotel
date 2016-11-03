package daoi;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import daol.UsuarioDAOL;
import model.Usuario;
import util.Conexion;

public class UsuarioDAOI implements UsuarioDAOL {

	Conexion cn = new Conexion();

	@Override
	public Usuario validar(Usuario obj) throws Exception {
		cn.abrir();
		Usuario u = new Usuario();
		u = null;
		try {
			Query q = cn.em.createQuery("select u from Usuario u where u.user_user= :user and u.user_pass= :pass");
			q.setParameter("user", obj.getUser_user());
			q.setParameter("pass", obj.getUser_pass());
			List<Usuario> lista = q.getResultList();
			for (Usuario o : lista) {
				u = lista.get(0);
			}
			if(u.getUser_user()!=null){
				u.setUser_facc(new Date());
				cn.em.getTransaction().begin();
				cn.em.merge(u);
				cn.em.getTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.cerrar();
		}
		return u;
	}

	@Override
	public Usuario insertar(Usuario obj) throws Exception {
		cn.abrir();
		try {
			cn.em.getTransaction().begin();
			cn.em.persist(obj);
			cn.em.flush();
			cn.em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			cn.em.getTransaction().rollback();
			// TODO: handle exception
		}
		return obj;

	}
	
	@Override
	public void actualizar(Usuario obj) throws Exception {
		cn.abrir();
		try {
			cn.em.getTransaction().begin();
			cn.em.merge(obj);
			cn.em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			cn.em.getTransaction().rollback();
			// TODO: handle exception
		}
	}

	@Override
	public List<Usuario> listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> buscar(Usuario obj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Usuario u) throws Exception {
		cn.abrir();
		try {
			cn.em.getTransaction().begin();
			Query q = cn.em
					.createQuery("select u from Usuario u where u.Persona.pers_id= :pers_id and u.user_rol= :user_rol");
			q.setParameter("pers_id", u.getPersona().getPers_id());
			q.setParameter("user_rol", u.getUser_rol());
			List<Usuario> lista = q.getResultList();
			Usuario u2= new Usuario();
			u2=null;
			for (Usuario o : lista) {
				u2 = lista.get(0);
			}
			if(u2!=null){
				u2.setUser_esta('D');
				cn.em.merge(u2);
				cn.em.getTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			cn.em.getTransaction().rollback();
			// TODO: handle exception
		}

	}
	
	@Override
	public Usuario obtener(Usuario u) throws Exception {
		cn.abrir();
		Usuario usu=new Usuario();
		try {
			cn.em.getTransaction().begin();
			Query q = cn.em
					.createQuery("select u from Usuario u where u.Persona.pers_id= :pers_id and u.user_rol= :user_rol");
			q.setParameter("pers_id", u.getPersona().getPers_id());
			q.setParameter("user_rol", u.getUser_rol());
			List<Usuario> lista = q.getResultList();
			Usuario u2= new Usuario();
			u2=null;
			for (Usuario o : lista) {
				u2 = lista.get(0);
			}
			usu= u2;
//			if(u2!=null){
//				u2.setUser_esta('D');
//				cn.em.merge(u2);
//				cn.em.getTransaction().commit();
//			}
		} catch (Exception e) {
			e.printStackTrace();
			cn.em.getTransaction().rollback();
			// TODO: handle exception
		}
		
		return usu;

	}

}
