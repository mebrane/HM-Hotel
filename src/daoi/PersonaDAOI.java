package daoi;

import java.util.List;

import javax.persistence.Query;

import daol.PersonaDAOL;
import model.Persona;
import model.Usuario;
import util.Conexion;

public class PersonaDAOI implements PersonaDAOL {

	Conexion cn = new Conexion();

	@Override
	public void actualizar(Persona obj) throws Exception {
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
	public Persona insertar(Persona obj) throws Exception {
		
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
	public List<Persona> listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Persona> buscar(Persona oPersona, Usuario oUsuario) throws Exception {
		cn.abrir();
		String jpql = "select p from Persona p where " 
					+ "(lower(p.pers_nomb) like :busqueda or lower(p.pers_apel) like :busqueda) "
					+ "and p.pers_id in " 
						+ "(select u.Persona.pers_id from Usuario u " 
							+ "where u.user_rol= :rol "
							+ "and u.user_esta= :esta) "
							+ "order by p.pers_apel, p.pers_nomb";
		
		List<Persona> lista = null;
		try {
			Query q = cn.em.createQuery(jpql);
			q.setParameter("busqueda",'%'+ oPersona.getPers_nomb().toLowerCase()+'%');
			q.setParameter("rol", oUsuario.getUser_rol());
			q.setParameter("esta", oUsuario.getUser_esta());
			lista = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lista;
	}

	@Override
	public void eliminar(Persona obj) throws Exception {
		// TODO Auto-generated method stub

	}

}
