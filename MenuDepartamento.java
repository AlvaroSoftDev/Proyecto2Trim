import java.util.Scanner;

public class MenuDepartamento {

    public static String clave;
    public static void escribir() {
        Scanner in = new Scanner(System.in);
        String claveDep;
        System.out.println("Introduce la clave del Departamento: ");
        claveDep = in.nextLine();
        if (clave.equals(claveDep)) {
            System.out.println("Elige una opción: \n1. Añadir Reserva \n" +
                    "2. Cancelar Reserva \n3. Listar todas las reservas \n4. Cerrar Sesión");
        }
    }
}
