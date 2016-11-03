package bean;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Persona;
import model.Usuario;
import serv.UsuarioServ;
import util.Paginas;

@ManagedBean
@SessionScoped
public class UsuarioBean {

	public int user_id;
	public String user_user,user_pass,user_emai;
	public Date user_freg,user_facc;
	public Character user_esta,user_rol;
	public Persona oPersona;
	
	Usuario obj= new Usuario();
	public UsuarioServ oUsuarioServ= new UsuarioServ();
	
	private List<Usuario> lista;
	private int lista_size;
	private boolean sw_buscar=false;
	Paginas pag=new Paginas();
	
	
	public String validar()throws Exception{
		String val=pag.pagina_error;
		Usuario u = new Usuario();
		u.setUser_user(getUser_user());
		u.setUser_pass(getUser_pass());
		obj=oUsuarioServ.validar(u);
		Thread.sleep(4500);
		if(obj!=null && obj.getUser_user()!=null){
			val=pag.pagina_principal;
			setUser_user(obj.getUser_user());
			setUser_pass(obj.getUser_pass());
		}
		return val;
	}
	
	public void limpiar() {
		setUser_user(null);
		setUser_pass(null);
	}
	
	
	
	
	
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
	public Persona getoPersona() {
		return oPersona;
	}
	public void setoPersona(Persona oPersona) {
		this.oPersona = oPersona;
	}
	public Usuario getObj() {
		return obj;
	}
	public void setObj(Usuario obj) {
		this.obj = obj;
	}
	public UsuarioServ getoUsuarioServ() {
		return oUsuarioServ;
	}
	public void setoUsuarioServ(UsuarioServ oUsuarioServ) {
		this.oUsuarioServ = oUsuarioServ;
	}
	public List<Usuario> getLista() {
		return lista;
	}
	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}
	public int getLista_size() {
		return lista_size;
	}
	public void setLista_size(int lista_size) {
		this.lista_size = lista_size;
	}
	public boolean isSw_buscar() {
		return sw_buscar;
	}
	public void setSw_buscar(boolean sw_buscar) {
		this.sw_buscar = sw_buscar;
	}
	public Paginas getPag() {
		return pag;
	}
	public void setPag(Paginas pag) {
		this.pag = pag;
	}
	

	@PostConstruct
	public void init() {
		oPersona = new Persona();
	}
}
