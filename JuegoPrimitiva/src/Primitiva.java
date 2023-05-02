import java.util.Scanner;

public class Primitiva {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	int [] arrayEnteros= new  int[9]; //creo un array estático con 9 números
	
	int min=11; 
				//para determinar el número aleatorio entre un rango 
	int max=99;
	
	int rango=max-min + 1; //rango de los números aleatorios
	
		for(int i=0;i<arrayEnteros.length;i++) {
			
			int numeroAleatorio=(int) ((Math.random()*rango)+min); //agrego numeros aleatorios al array
			
			while(existeNumero(arrayEnteros, numeroAleatorio)) { //utilizo el método que he creado para comprobar si existe el número en el array
				
				numeroAleatorio = (int) ((Math.random()*rango)+min);
				
			}
			
			arrayEnteros[i]=numeroAleatorio;
		}

	
	Scanner teclado = new Scanner(System.in);
	
	int numero=0; //variable para el número que le pido al usuario
	
	int contador=0; //inicializo el contador (con este cuento los intentos)
	
	int intentos=15; //establezco el número de intentos
	
	boolean salir=false; //para establecer como false la variable salir
	
	boolean encontrado = false; //establezco como false el número encontrado
	
	while(contador < 15 && !salir) { //bucle que permite que pida número hasta que se cumpla la condición de 15 intentos o se salga
		
		encontrado = false; //Necesito reiniciar el valor de encontrado, porque si no solo me lo pide dos veces
		
		contador++; // suma intento
		
		System.out.println("Introduzca un número (0 para salir): "); //muestra mensaje para insertar número
		
		numero=teclado.nextInt();
		
		if(numero == 0) { //comprueba que no sea 0
			
			salir = true;

			
		} else {
			
			for(int j=0;j<arrayEnteros.length;j++) { //recorre el array en búsqueda del número
							
				if(numero==arrayEnteros[j]) { //si es correcto nos dice la posición
					
					int posicion=j;
					
					System.out.println("El número existe y está en la posición " + (j+1));
							
					encontrado = true;
		
					arrayEnteros[j] = -1; //marco el número como acierto
				}
			}
			
			if(!encontrado) { //si no es correcto nos dice que no existe
					
				System.out.println("Numero "+numero+" no existe");
				
			}
		}
	if(numero==0) { //texto para salir del sistema
		
		System.out.println("Se ha salido del sistema");
		
	}
		
	else { //si no ha salido del sistema, imprime el array con los datos del boleto y el que hemos acertado lo marca con "XX"
		
	for(int k=0;k<arrayEnteros.length;k++) {
		
		if (arrayEnteros[k] == -1) {
			System.out.print("XX ");
		}else {
		
		System.out.print(arrayEnteros[k]+" "); //imprime el array entero
		

		}
	}
	
	
		System.out.println();//le damos un espacio para que el texto salga en la siguiente línea del array
		
		System.out.println("Faltan "+(intentos-contador)+" intentos");// muestra el número de intentos restante
	}
	
		
		}
	}



	
	//método para recorrer el array en busca del número añadido por el usuario
	private static boolean existeNumero(int[] array, int numero) {
		for(int i=0;i<array.length;i++) {
			if(array[i]==numero) {
				return true;
			}
		}
		return false;
	}
}
	
		
	
