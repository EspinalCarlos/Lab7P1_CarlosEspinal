
package lab7p1_carlosespinal;
import java.util.Scanner;
import java.util.Random;


public class Lab7P1_CarlosEspinal {
static Scanner read = new Scanner(System.in);
static Random rand = new Random();

    public static int menu() {
        int opcion = 0;
        
        System.out.println("  Menu  ");
        System.out.println();
        System.out.println();
        System.out.println("Opcion 1: Portrait");
        System.out.println("Opcion 2: Numero Magico");
        System.out.println("Opcion 3: Subsequencia");
        System.out.println("Opcion 4: Salida");
        System.out.println();
        System.out.println("Ingrese la opcion que desea usar: ");
        opcion = read.nextInt();
        
        return opcion;
    }
    
    public static int[][]lectura(int fila, int columna) {
        int temporal [][] = new int[fila][columna];
        
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                temporal[i][j] = rand.nextInt(10);
            }
        }
        return temporal;
    } 
    
    public static String imprimir(int[][] numeros) {
        String cadena = "";
        
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                cadena += "["+numeros[i][j]+"]";
            }
            cadena += "\n";
        }
        return cadena;
    }    
    
    public static int magico() {
        int filas = 0;
        int columnas = 0;
        int afuera = 0;
        int adentro = 1;
        int respuesta = 0;
        do {
            System.out.println("Ingrese el valor de M: ");
            filas = read.nextInt();
            System.out.println("Ingrese el valor de N: ");
            columnas = read.nextInt();
        }while(filas == columnas);
        int[][] matriz = lectura(filas,columnas);
        System.out.println(imprimir(matriz));
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j<matriz[0].length;j++) {
                if (j == 0|| i == 0 || i== matriz.length-1|| j == matriz[0].length-1) {
                    afuera += matriz[i][j];   
                }
                else {
                    adentro *= matriz[i][j];
                }
            }
        }
        respuesta = afuera + adentro;
        System.out.println("El resultado es de: "+respuesta);
        
        return respuesta;
    }
    
    public static int[][] portrait(int[][] matrizz) {
        int[][] matrizzz = new int [matrizz[0].length][matrizz.length];
        
        
        System.out.println(imprimir(matrizz));
        for (int i = 0; i < matrizz.length; i++) {
            for (int j = 0; j < matrizz[0].length; j++) {
                matrizzz[j][i] = matrizz[matrizz.length-1-i][j];
            }
        }
       
       return matrizzz; 
    }
    
    public static int subsecu(String cad1, String cad2) {
        String cade1 = '-'+(cad1).toUpperCase();
        String cade2= '-'+(cad2).toUpperCase();
        int fila = cade1.length();
        int columna = cade2.length();
        
        int[][] matriz = new int [fila][columna];
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                char cha1 = cade1.charAt(i);
                char cha2 = cade2.charAt(j);
                
                if (cha1 == '-'|| cha2 == '-') {
                    matriz[i][j] = 0;
                }
                else if (cha1 != cha2) {
                    matriz[i][j] = Math.max(matriz[i][j-1], matriz[i-1][j]);
                }
                else if (cha1 == cha2) {
                    matriz[i][j] = 1 + matriz[i-1][j-1];
                }
            }
        }
        System.out.println(imprimir(matriz));
        int matrizfin = matriz[matriz.length - 1][matriz[0].length-1];
        return matrizfin;
    }
    
    public static void main(String[] args) {
        int opcion = menu();
        do{
            switch(opcion) {
                case 1:
                    int filass;
                    int columnass;
                    do {
                        System.out.println("Ingrese un valor de filas: ");
                        filass = read.nextInt();
                        System.out.println("Ingrese un valor de columnas: ");
                        columnass = read.nextInt();
                    } while(filass == columnass);
                    int[][] matriz = lectura(filass,columnass);
                    
                    System.out.println(imprimir(portrait(matriz)));
                    
                    break;
                case 2:
                    magico();
                    break;
                case 3:
                    System.out.println("Ingrese la primera cadena: ");
                    String cadena1 = read.next();
                    System.out.println("Ingrese la segunda cadena: ");
                    String cadena2 = read.next();
                    
                    subsecu(cadena1,cadena2);
                    break;
            }
            
            
            opcion = menu();
        }while(opcion != 4);
        
        
        
    }
    
}
