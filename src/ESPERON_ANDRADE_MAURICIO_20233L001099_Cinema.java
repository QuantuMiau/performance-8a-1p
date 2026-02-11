import java.util.Arrays;
import java.util.Scanner;

public class Cinema {
    private char[][] seats = {
            {'O','O','O','O','O'},
            {'O','O','O','O','O'},
            {'O','O','O','O','O'},
            {'O','O','O','O','O'},
            {'O','O','O','O','O'},
    };
    private int[] sales = {};
    private int priceTicket = 35;
    Scanner sc = new Scanner(System.in);

    public Cinema() {
    }

    public Cinema(int[] sales, char[][] seats) {
        this.sales = sales;
        this.seats = seats;
    }

    public int[] getSales() {
        return sales;
    }

    public void setSales(int[] sales) {
        this.sales = sales;
    }

    public char[][] getSeats() {
        return seats;
    }

    public void setSeats(char[][] seats) {
        this.seats = seats;
    }

    // functions

    public void newSale(){
        System.out.println("Asientos disponibles");
        System.out.println("Precio el boleto: $" + priceTicket);
        for (int i = 0; i < 5; i++) {
            System.out.println(" " + seats[i][0] + " | " + seats[i][1] + " | " + seats[i][2] + " | " + seats[i][3] +  " | " + seats[i][4] );
        }

        int tickets;
        System.out.println("Ingrese la cantidad de boletos que desea comprar.");
        tickets = sc.nextInt();

        int totalSale = priceTicket * tickets;

        System.out.println("Precio de " + tickets + " boletos " + totalSale);
        int ticket = 0;


        do {
            System.out.println("Ingresa la columna del boleto: " + (ticket + 1));
            int column = sc.nextInt();

            System.out.println("Ingresa la fila del boleto: " + (ticket + 1));
            int file = sc.nextInt();

            if (seats[file][column] == 'O') {
                seats[file][column] = 'X';
                ticket++;
            }else {
                System.out.println("Este asiento ya esta ocupado.");
            }

        } while (ticket < tickets);
        int[] tempSale = new int[1];

        tempSale[0] = totalSale;

        int[] merged = new int[ this.sales.length + tempSale.length];


        System.arraycopy(this.sales, 0, merged,0, this.sales.length);
        System.arraycopy(tempSale, 0, merged, this.sales.length, tempSale.length);

        this.sales = merged;


        System.out.println("Gracias por su compra.");
        System.out.println("Sus asientos");
        for (int i = 0; i < 5; i++) {
            System.out.println(" " + seats[i][0] + " | " + seats[i][1] + " | " + seats[i][2] + " | " + seats[i][3] +  " | " + seats[i][4] );
        }

    }

    public  void addSales(){
        System.out.println("Ingresa la cantidad de ventas a registrar");
        int salesQty = sc.nextInt();

        int[] tempSales = new int[salesQty];

        for (int e = 0; e < tempSales.length; e++) {
            System.out.println("Ingresa el valor de la venta " + (e + 1));
            int sale = sc.nextInt();
            tempSales[e] = sale;
        }

        int[] merged = new int[ this.sales.length + tempSales.length];


        System.arraycopy(this.sales, 0, merged,0, this.sales.length);
        System.arraycopy(tempSales, 0, merged, this.sales.length, tempSales.length);
        this.sales = merged;

        System.out.println(Arrays.toString(sales));

    }

    public int[] sortSales(int[] merged){
        // ordenaminto por seleccion
        for (int i = 0; i < merged.length - 1; i++) {
            int minimo = i;

            for (int j = i + 1; j < merged.length; j++) {
                if (merged[j] > merged[minimo]) {
                    minimo = j;
                }
            }

            int temp = merged[minimo];
            merged[minimo] = merged[i];
            merged[i] = temp;
        }

        System.out.println(Arrays.toString(sales));
        return merged;
    }
}
//
//  /\_/\
// ( x.o )