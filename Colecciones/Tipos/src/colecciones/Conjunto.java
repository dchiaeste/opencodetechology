package colecciones;

import java.util.HashSet;
import java.util.Set;

public class Conjunto {

	public static void main(String[] args) {
		
		Set<String> equipos = new HashSet<String>();
		
		equipos.add("Barcelona");
		equipos.add("Bayer");
		equipos.add("Chelsea");
		equipos.add("inter");
		
		equipos.remove("Barcelona");
		
		equipos.contains("Bayer");
		
		for(String equipo : equipos){
			System.out.println("Equipos "+equipo);
		}

	}

}
