import java.util.Scanner;
public class App {
    public static void main(String[] args) {

        Scanner in = new Scanner (System.in);
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
        }
    }
}
