package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="hm_usuario")
public class Usuario {
	@Id
	@SequenceGenerator(name="hm_usuario_seq", allocationSize=1, initialValue=5)        
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="hm_usuario_seq")  
	private int user_id;
	private String user_user;
	private String user_pass;
	private String user_emai;
	@Temporal(TemporalType.DATE)
	private Date user_freg;
	@Temporal(TemporalType.DATE)
	private Date user_facc;
	private Character user_esta;
	private Character user_rol;
	
	@ManyToOne
	@JoinColumn(name="pers_id")
	private Persona Persona;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_user() {
		return user_user;
	}

	public void setUser_user(String user_user) {
		this.user_user = user_user;
	}

	public String getUser_pass() {
		return user_pass;
	}

	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}

	public String getUser_emai() {
		return user_emai;
	}

	public void setUser_emai(String user_emai) {
		this.user_emai = user_emai;
	}

	public Date getUser_freg() {
		return user_freg;
	}

	public void setUser_freg(Date user_freg) {
		this.user_freg = user_freg;
	}

	public Date getUser_facc() {
		return user_facc;
	}

	public void setUser_facc(Date user_facc) {
		this.user_facc = user_facc;
	}

	public Character getUser_esta() {
		return user_esta;
	}

	public void setUser_esta(Character user_esta) {
		this.user_esta = user_esta;
	}

	public Character getUser_rol() {
		return user_rol;
	}

	public void setUser_rol(Character user_rol) {
		this.user_rol = user_rol;
	}

	public Persona getPersona() {
		return Persona;
	}

	public void setPersona(Persona persona) {
		Persona = persona;
	}
	
	
}	
