import java.util.Scanner;

public class MenuAdmin {

    private static final String psswd = "ADMIN";

    public static void escribir() {
        Scanner in = new Scanner(System.in);
        String contraseña;
        String opcion;
        boolean prueba = true;


        System.out.println("Introduce la contraseña: ");
        contraseña = in.nextLine();
        if (psswd.equals(contraseña)) {

            while (prueba) {
                System.out.println("Elige una opción: \n1. Listar departamentos \n" +
                        "2. Añadir departamento \n3. Eliminar departamento \n4. Listar Sala \n5. Añadir Sala" +
                        "\n6. Eliminar Sala \n7. Listar todas las reservas \n8. Cerrar Sesión");
                opcion = in.nextLine();
                if (opcion.equals("1")) {

                }
                if (opcion.equals("2")) {

                    System.out.println("Escribe el nombre del departamento");
                    String nombreDepartamento = in.nextLine();
                    System.out.println("Escribe el nombre del codigo del departamento");
                    String codDepartamento = in.nextLine();
                    Departamento departamento = new Departamento(nombreDepartamento, codDepartamento);
                    departamento.añadirDepartamento(departamento);


                }
                if (opcion.equals("8")) {
                    MenuPrincipal.escribir();
                }

            }
        } else {
            System.out.println("Contraseña errónea.");
            MenuPrincipal.escribir();


        }
    }
}
