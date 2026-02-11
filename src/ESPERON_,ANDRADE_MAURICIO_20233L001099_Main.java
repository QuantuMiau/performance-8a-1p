import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner sc = new Scanner(System.in);
        int seleccion = 0;

        Cinema cinema = new Cinema();

        do {
            System.out.println("""
                Seleciona unas de las siguientes opciones
              1. Comprar boletos para la pelicula X.
              2. Mostrar las ventas.
              3. Agregar ventas antiguas.
              4. Salir""");
            seleccion = sc.nextInt();

            switch (seleccion) {
                case 1:
                    cinema.newSale();
                    break;
                case 2:
                    cinema.sortSales(cinema.getSales());
                    break;
                case 3:
                    cinema.addSales();
                    break;
                case 4:
                        System.out.println("Adioooos!!!");

                        break;
                default:
                    System.out.println("Opcion invalida...");
                    break;
            }

        } while ( seleccion != 4);

    }
}