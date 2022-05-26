package tdaproject;

public class Eventos {
	String Nombre,fi,ff,desc;
	int cantAsist;
	public Eventos(String n, String fs, String fn, int cA,String ds) {
		Nombre = n;
		fi = fs;
		ff = fn;
		cantAsist = cA;
		desc = ds;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
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
