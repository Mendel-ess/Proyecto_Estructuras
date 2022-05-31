package tdaproject;
 //Clase para los espacios
public class Espacios {
	Espacios ant;
	String nombre,tipo,pacargo,internet;
	int capacidad,tamaño,cost;
	Eventos ev;
	Espacios sig;
	
	public Espacios getAnt() {
		return ant;
	}


	public void setAnt(Espacios ant) {
		this.ant = ant;
	}


	public Espacios getSig() {
		return sig;
	}


	public void setSig(Espacios sig) {
		this.sig = sig;
	}


	public Espacios(String n, String t, String pa,String i, int cap,int tam, int cos) {
		nombre = n;
		tipo = t;
		pacargo = pa;
		capacidad = cap;
		tamaño = tam;
		cost = cos;
		internet = i;
	}
	

	public int getCost() {
		return cost;
	}


	public void setCost(int cost) {
		this.cost = cost;
	}


	public Eventos getEv() {
		return ev;
	}


	public void setEv(Eventos ev) {
		this.ev = ev;
	}


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getPacargo() {
		return pacargo;
	}
	public void setPacargo(String pacargo) {
		this.pacargo = pacargo;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public int getTamaño() {
		return tamaño;
	}
	public void setTamaño(int tamaño) {
		this.tamaño = tamaño;
	}

	public String getInternet() {
		return internet;
	}

	public void setInternet(String internet) {
		this.internet = internet;
	}

}
