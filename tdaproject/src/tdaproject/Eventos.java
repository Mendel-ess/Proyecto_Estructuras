package tdaproject;

public class Eventos {
	//Clase eventos
	public String nombre;
	public String fi;
	public String ff;
	public String desc;
	public int cantAsist,horas;
	Eventos sig=null;
	
	public Eventos(String fn,String ffn,String n,String d,int h, int c) {
		fi = fn;
		ff = ffn;
		nombre = n;
		desc = d;
		horas=h;
		cantAsist = c;
	}
	
	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nom) {
		nombre = nom;
	}
	public String getFi() {
		return fi;
	}
	public void setFi(String fi) {
		this.fi = fi;
	}
	public String getFf() {
		return ff;
	}
	public void setFf(String ff) {
		this.ff = ff;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getCantAsist() {
		return cantAsist;
	}
	public void setCantAsist(int cantAsist) {
		this.cantAsist = cantAsist;
	}
	
}
