package bean;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import model.Persona;
import model.Usuario;
import serv.PersonaServ;
import serv.UsuarioServ;
import util.Paginas;

@ManagedBean
@SessionScoped
public class ClienteBean {
	public int pers_id;
	public String pers_nomb, pers_apel, pers_dire, pers_pobl, pers_prov, pers_codp, pers_telf;
	public String pers_user,pers_pass,pers_emai;
//	public Date pers_freg,pers_facc;
	public Character pers_esta;
	
	public int user_id;
	public String user_user,user_pass,user_emai;
	public Date user_freg,user_facc;
	public Character user_esta,user_rol;
	public Persona oPersona;
	
	Persona persona= new Persona();
	public PersonaServ oPersonaServ=new PersonaServ();
	
	Usuario usuario= new Usuario();
	public UsuarioServ oUsuarioServ=new UsuarioServ();
	
	private List<Persona> listaclientes;
	private int listaclientes_l;
	private boolean sw_edit;
	private int fila_seleccionada;
	
	Paginas pages= new Paginas();
	
	public void seleccionar(ActionEvent e) throws Exception
	{
		String fila=e.getComponent().getAttributes().get("atributo_id").toString();
		System.out.println(fila);
		fila_seleccionada=Integer.parseInt(fila);
	}
	
	public void accion_insertar(){
		sw_edit=false;
	}
	
	public void accion_editar(){
		sw_edit=true;
	}
	
	public void eliminar(ActionEvent e) throws Exception{
		//String id=e.getComponent().getAttributes().get("atributo_id").toString();
		System.out.println("TEST DELETE (i)");
		Persona p1= new Persona();
		Usuario u1= new Usuario();
		p1.setPers_id(fila_seleccionada);
		u1.setPersona(p1);
		u1.setUser_rol('C');
		oUsuarioServ.eliminar(u1);
		listar();
		System.out.println("ID: "+fila_seleccionada);
		System.out.println("TEST DELETE (f)");
		limpiar();
	}
	
	public void modo_editar(ActionEvent e) throws Exception{
		seleccionar(e);
		//String id=e.getComponent().getAttributes().get("atributo_id").toString();
		System.out.println("TEST EDIT (i)");
		accion_editar();
		Persona p1= new Persona();
		Usuario u1= new Usuario();
		p1.setPers_id(fila_seleccionada);
		u1.setPersona(p1);
		u1.setUser_rol('C');
		Usuario u2=oUsuarioServ.obtener(u1);
		Persona p2=u2.getPersona();
		setPers_id(p2.getPers_id());
		setPers_nomb(p2.getPers_nomb());
		setPers_apel(p2.getPers_apel());
		setPers_dire(p2.getPers_dire());
		setPers_pobl(p2.getPers_pobl());
		setPers_prov(p2.getPers_prov());
		setPers_codp(p2.getPers_codp());
		setPers_telf(p2.getPers_telf());
		setUser_id(u2.getUser_id());
		setUser_user(u2.getUser_user());
		setUser_pass(u2.getUser_pass());
		setUser_emai(u2.getUser_emai());
		setUser_freg(u2.getUser_freg());
		//listar();
		System.out.println("ID: "+fila_seleccionada);
		System.out.println("TEST EDIT (f)");
	}
	
	public void actualizar() throws Exception{
		Persona p1 = new Persona();
		p1.setPers_id(pers_id);
		p1.setPers_nomb(pers_nomb);
		p1.setPers_apel(pers_apel);
		p1.setPers_dire(pers_dire);
		p1.setPers_pobl(pers_pobl);
		p1.setPers_prov(pers_prov);
		p1.setPers_codp(pers_codp);
		p1.setPers_telf(pers_telf);
		
		Usuario u1= new Usuario();
		u1.setUser_id(user_id);
		u1.setUser_user(user_user);
		u1.setUser_pass(user_pass);
		u1.setUser_emai(user_emai);
		u1.setUser_freg(user_freg);
		//u1.setUser_facc(user_facc);
		u1.setUser_esta('A');
		u1.setUser_rol('C');
		u1.setPersona(p1);
		
		Thread.sleep(4500);
		oUsuarioServ.actualizar(u1);
		oPersonaServ.actualizar(p1);
		
		
	}
	
	
	public void listar() throws Exception{
		Persona p = new Persona();
		p.setPers_nomb(getPers_nomb());
		
		Usuario u = new Usuario();
		u.setUser_rol('C');
		u.setUser_esta('A');
		listaclientes=oPersonaServ.buscar(p,u);
		listaclientes_l=listaclientes.size();
	}
	
	public String registrar() throws Exception{
	//	limpiar();
		//Thread.sleep(500);
		String res=pages.pagina_error;
		Persona p = new Persona();
//		p.setPers_id(pers_id);
		p.setPers_nomb(pers_nomb);
		p.setPers_apel(pers_apel);
		p.setPers_dire(pers_dire);
		p.setPers_pobl(pers_pobl);
		p.setPers_prov(pers_prov);
		p.setPers_codp(pers_codp);
		p.setPers_telf(pers_telf);
		
		Persona p2=new Persona();
		p2=oPersonaServ.insertar(p);
		System.out.println("ID de Persona: "+p2.getPers_id());
		
		Usuario u1= new Usuario();
		u1.setPersona(p);
		u1.setUser_user(user_user);
		
		u1.setUser_pass(user_pass);
		u1.setUser_emai(user_emai);
		u1.setUser_freg(new Date());
		u1.setUser_esta('A');
		u1.setUser_rol('C');
//		System.out.println("User_user: "+user_user);
//		System.out.println("User_user: "+u1.getUser_user());
		Usuario u2=new Usuario();
		u2=oUsuarioServ.insertar(u1);
//		Thread.sleep(4500);
		if(u2.getUser_user()!=null){
			res=pages.pagina_principal;
			System.out.println("Se agregó cliente.");
		}
//		System.out.println("ID de Usuario: "+u2.getUser_id());
//		System.out.println("RES: "+res);
		
		Persona p3= new Persona();
		setPers_id(p3.getPers_id());
		limpiar();
		if(res==pages.pagina_error){
			System.out.println("Ocurrió un error.");
		}
		Thread.sleep(4500);
		return res;
	}

	public void limpiar(){
		setPers_id(0);
		setPers_nomb(null);
		setPers_apel(null);
		setUser_id(0);
		setUser_user(null);
		setUser_emai(null);
		setUser_pass(null);
		setPers_dire(null);
		setPers_pobl(null);
		setPers_prov(null);
		setPers_codp(null);
		setPers_telf(null);
	}
	
	public int getPers_id() {
		return pers_id;
	}


	public void setPers_id(int pers_id) {
		this.pers_id = pers_id;
	}


	public String getPers_nomb() {
		return pers_nomb;
	}


	public void setPers_nomb(String pers_nomb) {
		this.pers_nomb = pers_nomb;
	}


	public String getPers_apel() {
		return pers_apel;
	}


	public void setPers_apel(String pers_apel) {
		this.pers_apel = pers_apel;
	}


	public String getPers_dire() {
		return pers_dire;
	}


	public void setPers_dire(String pers_dire) {
		this.pers_dire = pers_dire;
	}


	public String getPers_pobl() {
		return pers_pobl;
	}


	public void setPers_pobl(String pers_pobl) {
		this.pers_pobl = pers_pobl;
	}

	

	public String getPers_prov() {
		return pers_prov;
	}


	public void setPers_prov(String pers_prov) {
		this.pers_prov = pers_prov;
	}


	public String getPers_codp() {
		return pers_codp;
	}


	public void setPers_codp(String pers_codp) {
		this.pers_codp = pers_codp;
	}


	public String getPers_telf() {
		return pers_telf;
	}


	public void setPers_telf(String pers_telf) {
		this.pers_telf = pers_telf;
	}


	public String getPers_user() {
		return pers_user;
	}


	public void setPers_user(String pers_user) {
		this.pers_user = pers_user;
	}


	public String getPers_pass() {
		return pers_pass;
	}


	public void setPers_pass(String pers_pass) {
		this.pers_pass = pers_pass;
	}


	public String getPers_emai() {
		return pers_emai;
	}


	public void setPers_emai(String pers_emai) {
		this.pers_emai = pers_emai;
	}


//	public Date getPers_freg() {
//		return pers_freg;
//	}
//
//
//	public void setPers_freg(Date pers_freg) {
//		this.pers_freg = pers_freg;
//	}
//
//
//	public Date getPers_facc() {
//		return pers_facc;
//	}
//
//
//	public void setPers_facc(Date pers_facc) {
//		this.pers_facc = pers_facc;
//	}


	public Character getPers_esta() {
		return pers_esta;
	}


	public void setPers_esta(Character pers_esta) {
		this.pers_esta = pers_esta;
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


	public Persona getPersona() {
		return persona;
	}


	public void setPersona(Persona persona) {
		this.persona = persona;
	}


	public PersonaServ getoPersonaServ() {
		return oPersonaServ;
	}


	public void setoPersonaServ(PersonaServ oPersonaServ) {
		this.oPersonaServ = oPersonaServ;
	}


	public List<Persona> getListaclientes() {
		return listaclientes;
	}


	public void setListaclientes(List<Persona> listaclientes) {
		this.listaclientes = listaclientes;
	}


	public int getListaclientes_l() {
		return listaclientes_l;
	}


	public void setListaclientes_l(int listaclientes_l) {
		this.listaclientes_l = listaclientes_l;
	}


	public boolean isSw_edit() {
		return sw_edit;
	}


	public void setSw_edit(boolean sw_edit) {
		this.sw_edit = sw_edit;
	}
	
	
	
	

}
