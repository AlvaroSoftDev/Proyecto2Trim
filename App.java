import java.util.Scanner;
public class App {
    public static void main(String[] args) {

        Scanner in = new Scanner (System.in);
        int opcion = -1;

        // Sacar el MenuPrincipal y en base a ese, los demás:
        while(opcion != 3) {
            MenuPrincipal.escribir();
            // Menú de opciones controlando las excepciones
            try {
                opcion = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1;
            }
            switch(opcion) {
                case 1: {
                    // Login de Administrador
                    System.out.println("Introduce la contraseña de Administrador: ");
                    String pass = in.nextLine();
                    try {
                        MenuAdmin.login(pass);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 2: {
                    // Login de Departamento
                    System.out.println("Introduce la clave del Departamento: ");
                    String clave = in.nextLine();
                    try {
                        MenuDepartamento.login(clave);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 3: {
                    // Salir sistema
                    System.out.println("Has salido correctamente.");
                    break;
                }
                default: {
                    // Opción no válida
                    System.out.println("Opción no válida.");
                    break;
                }
            }
        }
    }
}
