import java.util.Scanner;
public class App {
    public static void main(String[] args) {

        /*Scanner in = new Scanner (System.in);
        String opcion;
        MenuPrincipal.escribir();
        // Mejor para cuando hay operaciones: opcion = Integer.parseInt(in.nextLine());
        opcion = in.nextLine();
        if(opcion.equals("1")){
            MenuAdmin.escribir();
        }
        else if(opcion.equals("2")){
            MenuDepartamento.escribir();
        }
        else{
            System.out.println("Has salido.");
        }*/

        Sala s1 = new Sala("Informática","INF");
        Reserva r1 = new Reserva(2024,5,16,10,2);
        //Reserva r2 = new Reserva(2024,5,16,10,2);
        Reserva r3 = new Reserva(2024,6,16,10,2);
        s1.añadirReserva(r1);
        //s1.añadirReserva(r2);
        s1.añadirReserva(r3);
        s1.listarReservas();
    }
}
