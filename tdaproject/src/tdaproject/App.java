package tdaproject;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.io.*;
import java.time.YearMonth;

// txt = C:/Users/GINNA1/Downloads/archivoPrueba.txt
public class App {
	Espacios cab=null,x,y,z;
	Eventos cab1=null,a,b,c;
	Scanner ent = new Scanner(System.in);
	public App() {
		menu();
	}
	
	public void menu(){
		System.out.println("-------------------------- Centro de Convenciones --------------------------");
		System.out.println("1. Agregar un Espacio\n2. Agregar Eventos a un Espacio\n3. Eliminar un espacio del centro\n4. Eliminar el evento de un espacio");
		System.out.println("5. Valor recaudado por los eventos\n6. Buscar un espacio\n7. Generar reporte de eventos\n8. Importar txt\n9. Exportar txt");
		System.out.println("10. salir");
		int opc = ent.nextInt();
		
		switch (opc) {
		case 1:
			agregarEspacio();
			menu();
			break;
		case 2:
			agregarEvento();
			menu();
			break;
		case 3:
			eliminarEspacio();
			menu();
			break;
		case 4:
			eliminarEvento();
			menu();
			break;
		case 5:
			recaudacion();
			menu();
			break;
		case 6:
			buscar();
			menu();
			break;
		case 7:
			generarReporte();
			menu();
			break;
		case 8:
			importarTxt();
			menu();
			break;
		case 9:
			exportarTxt();
			menu();
			break;
		case 10:
			break;
		default:
			System.out.println("Digite un valor del 1 al 7");
			menu();
			break;
		}
	}

	private void importarTxt() {
		System.out.println("Digite la ruta donde se encuentra el archivo: ");
		String ruta = ent.next();
		File f = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			f = new File(ruta);
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String line = "";
			int cantEsp = Integer.parseInt((line=br.readLine()));
			int i=0;
			while (i < cantEsp) {
				if(cab == null) {
					line = br.readLine();
					String n = line;
					line = br.readLine();
					String t = line;
					line = br.readLine();
					String pa = line;
					line = br.readLine();
					String net = line; 
					line = br.readLine();
					int cap = Integer.parseInt(line);
					line = br.readLine();
					int tam = Integer.parseInt(line);
					line = br.readLine();
					int cos = Integer.parseInt(line);
					y = new Espacios(n,t,pa,net,cap,tam,cos);
					cab = y;
					line = br.readLine();
					int cantEv = Integer.parseInt(line);
					int j =0;
					while(j<cantEv) {
						if(y.ev == null) {
							line = br.readLine();
							String fi = line;
							line = br.readLine();
							String ff = line;
							line = br.readLine();
							String nom = line;
							line = br.readLine();
							String d = line;
							line = br.readLine();
							int h = Integer.parseInt(line);
							line = br.readLine();
							int c = Integer.parseInt(line);
							b = new Eventos(fi,ff,nom,d,h,c);
							y.ev = b;
						}else {
							a = y.ev; 
							while (a.sig != null) {a=a.sig;}
							line = br.readLine();
							String fi = line;
							line = br.readLine();
							String ff = line;
							line = br.readLine();
							String nom = line;
							line = br.readLine();
							String d = line;
							line = br.readLine();
							int h = Integer.parseInt(line);
							line = br.readLine();
							int c = Integer.parseInt(line);
							b = new Eventos(fi,ff,nom,d,h,c);
							a.sig = b;	
						}
						j++;		
					}

				}else {
					x = cab;
					while(x.sig != null) {x=x.sig;}
					line = br.readLine();
					String n = line;
					line = br.readLine();
					String t = line;
					line = br.readLine();
					String pa = line;
					line = br.readLine();
					String net = line; 
					line = br.readLine();
					int cap = Integer.parseInt(line);
					line = br.readLine();
					int tam = Integer.parseInt(line);
					line = br.readLine();
					int cos = Integer.parseInt(line);
					y = new Espacios(n,t,pa,net,cap,tam,cos);
					x.sig = y;
					y.ant = x;
					line = br.readLine();
					int cantEv = Integer.parseInt(line);
					int j =0;
					while(j<cantEv) {
						if(y.ev == null) {
							line = br.readLine();
							String fi = line;
							line = br.readLine();
							String ff = line;
							line = br.readLine();
							String nom = line;
							line = br.readLine();
							String d = line;
							line = br.readLine();
							int h = Integer.parseInt(line);
							line = br.readLine();
							int c = Integer.parseInt(line);
							b = new Eventos(fi,ff,nom,d,h,c);
							y.ev = b;
						}else {
							a = y.ev; 
							while (a.sig != null) {a=a.sig;}
							line = br.readLine();
							String fi = line;
							line = br.readLine();
							String ff = line;
							line = br.readLine();
							String nom = line;
							line = br.readLine();
							String d = line;
							line = br.readLine();
							int h = Integer.parseInt(line);
							line = br.readLine();
							int c = Integer.parseInt(line);
							b = new Eventos(fi,ff,nom,d,h,c);
							a.sig = b;	
						}
						j++;		
					}
				}
				i++;
			}
			br.close();
			fr.close();
		}catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	private void exportarTxt() {
		String rdefault = "C:/Users/GINNA1/Downloads/";
		System.out.println("Digite el nombre del nuevo archivo (sin espacios): ");
		String file = ent.next();
		String ruta = rdefault+file+".txt";
		
		try {
			PrintWriter pw = new PrintWriter(ruta,"UTF-8");
			x = cab;
			y=cab;
			int i=0;
			int cantEsp =0;		
			while (x != null) {cantEsp++;x=x.sig;}
			pw.println(cantEsp);
			while(i<cantEsp) {
				int cantEv=0;
				int j=0;
				pw.println(y.getNombre());
				pw.println(y.getTipo());
				pw.println(y.getPacargo());
				pw.println(y.getInternet());
				pw.println(y.getCapacidad());
				pw.println(y.getTamaño());
				pw.println(y.getCost());
				a=y.ev;
				while(a!=null) {cantEv++;a=a.sig;}
				//cantEv=temp;
				pw.println(cantEv);
				b=y.ev;
				while(j<cantEv) { 
					pw.println(b.getFi());
					pw.println(b.getFf());
					pw.println(b.getNombre());
					pw.println(b.getDesc());
					pw.println(b.getHoras());
					pw.println(b.getCantAsist());
					b=b.sig;
					j++;
				}
				y = y.sig;
				i++;
			}
			pw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private int recaudacion() {
		System.out.println("Digite el nombre del espacio que desea saber la recaudacion");
		String n = ent.next();
		x = cab;
		int recaudacion =0 ;
		if(cab.nombre.compareToIgnoreCase(n)==0) {
			int cantEv=0;
			int h = 0;
			b = x.ev;
			while(b != null) {cantEv++;b = b.sig;}
			for(int i=0;i<cantEv;i++) {h+=x.ev.getHoras();x.ev=x.ev.sig;}
			int costo = x.getCost();
			recaudacion = costo*h;
			
		}else {
			while(x.nombre.compareToIgnoreCase(n)!=0 && x != null) {x = x.sig;}
			int cantEv=0;
			int h = 0;
			b = x.ev;
			while(b != null) {cantEv++;b = b.sig;}
			for(int i=0;i<cantEv;i++) {h+=x.ev.getHoras();x.ev=x.ev.sig;}
			int costo = x.getCost();
			recaudacion = costo*h;	
		}
		return recaudacion;
		
	}

	private void eliminarEvento() {
		System.out.println("Digite el nombre del espacio al que desea eliminar los eventos");
		String n = ent.next();
		x = cab;
		while(x.nombre.compareToIgnoreCase(n) != 0  && x != null) {
			x = x.sig;
		}
		if(x.nombre.compareToIgnoreCase(n)==0) {
			a=x.ev;
			b=x.ev;
			System.out.println("Digite el nombre del evento que desea elminar");
			String nom = ent.nextLine();
			if(a.nombre.compareToIgnoreCase(nom)==0) {a = a.sig;}
			else {
				while(a.nombre.compareToIgnoreCase(nom)!= 0 && a != null) {b=a;a=a.sig;}
				b.sig = a.sig;
				
			}
			
		}
		
	}

	private void eliminarEspacio() {
		System.out.println("Digite el nombre del espacio que desea eliminar");
		String n = ent.next();
		x = cab;
		y = cab;
		if(cab.nombre.compareToIgnoreCase(n)==0) {
			cab = cab.sig;
		}
		else {
			while(x.nombre.compareToIgnoreCase(n)!=0 && x != null) {
				y=x;
				x = x.sig;
			}
			x.sig.ant = y;
			y.sig = x.sig;
			
			
		}
	}

	private void agregarEvento() {
		System.out.println("Digite el nombre del espacio al cual le desea agregar el evento: ");
		String n = ent.next();
		x = cab;
		while(x.nombre.compareToIgnoreCase(n)!= 0 && x != null) {
			x = x.sig;
		}
		
		if(x.nombre.compareToIgnoreCase(n)==0) {
			if(x.ev == null) {
				System.out.println("Fecha de inicio del evento (DD/MM/AAAA): ");
				String fi = ent.next();
				System.out.println("Fecha final del evento (DD/MM/AAAA): ");
				String ff = ent.next();
				System.out.println("Nombre del evento: ");
				String nom = ent.next();
				System.out.println("Descripcion del evento:");
				ent.nextLine();
				String des = ent.nextLine();
				System.out.println("Duracion del evento: ");
				int h = ent.nextInt();
				System.out.println("Cantidad de asistentes: ");
				int cass = ent.nextInt();
				b= new Eventos(fi,ff,nom,des,h,cass);
				x.ev = b;
			}else {
				a=x.ev;
				while(a.sig != null) {
					a = a.sig;
				}
				System.out.println("Fecha de inicio del evento (DD/MM/AAAA): ");
				String fi = ent.next();
				System.out.println("Fecha final del evento (DD/MM/AAAA): ");
				String ff = ent.next();
				System.out.println("Nombre del evento: ");
				String nom = ent.next();
				System.out.println("Descripcion del evento:");
				ent.nextLine();
				String des = ent.nextLine();
				System.out.println("Duracion del evento: ");
				int h = ent.nextInt();
				System.out.println("Cantidad de asistentes: ");
				int cass = ent.nextInt();
				b= new Eventos(fi,ff,nom,des,h,cass);
				a.sig = b;
				
		
			}
		}	
		
	}

	private void agregarEspacio() {
		String op;
		do {
			if(cab==null) {
				System.out.println("Nombre del espacio: ");
				String n = ent.next();
				System.out.println("Tipo de espacio: ");
				ent.nextLine();
				String t = ent.nextLine();
				System.out.println("Persona a cargo: ");
				String pa = ent.nextLine();
				System.out.println("¿el espacio cuenta con internet?: ");
				String net = ent.next();
				System.out.println("Capacidad del espacio");
				int cap = ent.nextInt();
				System.out.println("tamaño del espacio (en metros cuadrados): ");
				int tam = ent.nextInt();
				System.out.println("Digite el costo de la hora");
				int cos = ent.nextInt();
				y = new Espacios(n,t,pa,net,cap,tam,cos);
				cab = y;
				
			}else {
				x=cab;
				while(x.sig != null) {
					x = x.sig;
				}
				System.out.println("Nombre del espacio: ");
				String n = ent.next();
				System.out.println("Tipo de espacio: ");
				ent.nextLine();
				String t = ent.nextLine();
				System.out.println("Persona a cargo: ");
				String pa = ent.nextLine();
				System.out.println("¿el espacio cuenta con internet?: ");
				String net = ent.next();
				System.out.println("Capacidad del espacio");
				int cap = ent.nextInt();
				System.out.println("tamaño del espacio (en metros cuadrados): ");
				int tam = ent.nextInt();
				System.out.println("Digite el costo de la hora");
				int cos = ent.nextInt();
				y = new Espacios(n,t,pa,net,cap,tam,cos);
				y.ant = x;
				x.sig = y;
			}
			System.out.println("Desea ingresar otro nodo (S/N)");
			op = ent.next();
		}
		while(op.charAt(0) == 's' || op.charAt(0) == 'S');
		
	}
	
	private void generarReporte() {
			x = cab;
			c = x.ev;
			a = x.ev;
			while (x.sig != null) {
				int cantEv = 0;
				while(c != null) {cantEv++;c=c.sig;}
				int j=1;
				System.out.println("=======================================================================================");
				while(a != null) {
					System.out.println("Evento N°"+(j)+":");
					System.out.println("Fecha inicial del evento: "+a.getFi());
					System.out.println("Fecha final del evento: "+a.getFf());
					System.out.println("Nombre del evento: "+a.getNombre());
					System.out.println("Descripcion del evento: "+a.getDesc());
					System.out.println("Duracion del evento (en horas): "+a.getHoras());
					System.out.println("Cantidad de asistentes: "+a.getCantAsist());
					System.out.println("");
					a=a.sig;
					j++;
				}
				System.out.println("Nombre de espacio: "+x.getNombre());
				System.out.println("Tipo: "+x.getTipo());
				System.out.println("Capacidad: "+x.getCapacidad());
				System.out.println("Tamaño: "+x.getTamaño());
				System.out.println("Costo por hora: "+x.getCost());
				System.out.println("Cantidad de eventos: "+cantEv);
				System.out.println("Persona a Cargo: "+x.getPacargo());
				System.out.println("=======================================================================================");
				//System.out.println("Internet: "+x.getInternet());
				//System.out.println("Sig: "+x.getSig());
				System.out.println("");
				x = x.sig;
				a = x.ev;
				c=x.ev;
			}
			int cantEv = 0;
			c = x.ev;
			a = x.ev;
			while(c != null) {cantEv++;c=c.sig;}
			int j=1;
			System.out.println("=======================================================================================");
			while(a != null) {
				System.out.println("Evento N°"+(j)+":");
				System.out.println("Fecha inicial del evento: "+a.getFi());
				System.out.println("Fecha final del evento: "+a.getFf());
				System.out.println("Nombre del evento: "+a.getNombre());
				System.out.println("Descripcion del evento: "+a.getDesc());
				System.out.println("Duracion del evento(en horas): "+a.getHoras());
				System.out.println("Cantidad de asistentes: "+a.getCantAsist());
				System.out.println("");
				a=a.sig;
				j++;
			}
			System.out.println("Nombre de espacio: "+x.getNombre());
			System.out.println("Tipo: "+x.getTipo());
			System.out.println("Capacidad: "+x.getCapacidad());
			System.out.println("Tamaño: "+x.getTamaño());
			System.out.println("Costo por hora: "+x.getCost());
			System.out.println("Cantidad de eventos: "+cantEv);
			System.out.println("Persona a Cargo: "+x.getPacargo());
			System.out.println("=======================================================================================");
			//System.out.println("Internet: "+x.getInternet());
			//System.out.println("Sig: "+x.getSig());
			System.out.println("");
			x = x.sig;
	}


	private void buscar() {
		System.out.println("---------------------------------------- BUSCAR ----------------------------------------");
		System.out.println("1. Buscar espacio por nombre\n2. Buscar espacio mas usado\n3. Buscar espacio menos usado ");
		int opt = ent.nextInt();
		switch(opt) {
		case 1:
			System.out.println("Digite el nombre del espacio a buscar");
			String n = ent.next();
			x = cab;
			while(x.nombre.compareToIgnoreCase(n) != 0 && x != null) {x =x.sig;}
			if(x.nombre.compareToIgnoreCase(n)==0) {
				System.out.println("Nombre del espacio: "+x.getNombre());
				System.out.println("Tipo:"+x.getTipo());
				System.out.println("Persona a cargo"+x.getPacargo());
				System.out.println("Internet: "+x.getInternet());
				c = x.ev;
				int cantEv=0;
				while(c != null) {cantEv++;c=c.sig;}
				System.out.println("Cantidad de eventos:"+cantEv);
			}else {System.out.println("el espacio no se encuentra en el centro");}
			
			break;
		case 2:
			x=cab;
			y=x.sig;
			while(x != null && y !=null) {
				a = x.ev;
				b = y.ev;
				int cantEvA=0;
				int cantEvB=0;
				while(a!=null) {cantEvA++;a=a.sig;}
				while(b != null) {cantEvB++;b=b.sig;}
				if(cantEvA > cantEvB) {
					z=x;
				}else if(cantEvB > cantEvA) {
					z=y;
				}
				x=x.sig;
				y=x.sig;
			}
			System.out.println("El espacio mas usado es el "+z.getNombre());
			break;
		case 3:
			x=cab;
			y=x.sig;
			while(x != null && y !=null) {
				a = x.ev;
				b = y.ev;
				int cantEvA=0;
				int cantEvB=0;
				while(a!=null) {cantEvA++;a=a.sig;}
				while(b != null) {cantEvB++;b=b.sig;}
				if(cantEvA < cantEvB) {
					z=x;
				}else if(cantEvB < cantEvA) {
					z=y;
				}
				x=x.sig;
				y=x.sig;
			}
			System.out.println("El espacio mas usado es el "+z.getNombre());
			break;
		}
	}
}
