import java.util.Random;
import java.util.Scanner;

public class Asiento {
    int fila;
    int columna;
    boolean estado; // true = ocupado, false = libre
    double precio;

    public void mostrarInfo() {
        System.out.println("Fila " + fila + ", Columna " + columna +", Precio: $" + precio +", Estado: " + (estado ? "Ocupado" : "Libre"));
    }

    public void ocupar() {
        if (estado) {
            System.out.println("El asiento está ocupado");
        } else {
            System.out.println("El asiento está libre");
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Cuantas filas: ");
        int f = entrada.nextInt();
        System.out.print("Cuantas columnas: ");
        int c = entrada.nextInt();

        // Creamos la matriz de objetos Asiento
        Asiento[][] posicion = new Asiento[f][c];
//pasamelo desde este cacho hasta abajo
        // Inicializamos la matriz con objetos Asiento aleatorios
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                posicion[i][j] = new Asiento();
                posicion[i][j].fila = i;
                posicion[i][j].columna = j;
                posicion[i][j].estado = random.nextBoolean();
                posicion[i][j].precio = 5 + random.nextInt(51);
            }
        }

        // Mostrar el estado general de los asientos (X = ocupado, O = libre)
        System.out.println("\n=== ESTADO DE LOS ASIENTOS ===");
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print((posicion[i][j].estado ? "X" : "O") + "  ");
            }
            System.out.println();
        }

        // Mostrar información detallada de cada asiento
        System.out.println("\n=== INFORMACIÓN DETALLADA ===");
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                posicion[i][j].mostrarInfo();
            }
        }

        entrada.close();
    }
}
