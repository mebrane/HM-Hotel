package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="hm_persona")
public class Persona {

	@Id
	@SequenceGenerator(name="hm_persona_seq", allocationSize=1, initialValue=6)        
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="hm_persona_seq")  
	private int pers_id;
	private String pers_nomb;
	private String pers_apel;
	private String pers_dire;
	private String pers_pobl;
	private String pers_prov;
	private String pers_codp;
	private String pers_telf;
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
	public String getPers_prov() {
		return pers_prov;
	}
	public void setPers_prov(String pers_prov) {
		this.pers_prov = pers_prov;
	}
	
	
	
}
