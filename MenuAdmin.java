import java.util.Scanner;

public class MenuAdmin {

    private static final String psswd = "ADMIN";

    public static void login(String pass) throws Exception {
        // Si la contraseña no coincide con la propuesta, sacamos excepción que lo avise:
        if (!psswd.equals(pass)) {
            throw new Exception("Contraseña inválida.");
        }

        Scanner in=new Scanner(System.in);
        int opcion = -1;
        while (opcion != 8) {
            System.out.println("Elige una opción: ");
            System.out.println("1. Listar departamentos");
            System.out.println("2. Añadir departamento");
            System.out.println("3. Eliminar departamento");
            System.out.println("4. Listar salas");
            System.out.println("5. Añadir sala");
            System.out.println("6. Eliminar sala");
            System.out.println("7. Listar todas las reservas");
            System.out.println("8. Cerrar sesión");

            // Seleccion de opcion con control de errores
            try {
                opcion = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1;
            }
            switch (opcion) {
                case 1: {
                    // Listar departamentos
                    Admin.listarDepartamentos();
                    break;
                }
                case 2: {
                    // Añadir departamento
                    System.out.println("Introduce un nombre de departamento: ");
                    String nombre=in.nextLine();
                    System.out.println("Introduce un código de departamento: ");
                    String clave = in.nextLine();
                    try {
                        Admin.añadirDepartamento(nombre, clave);
                    } catch(Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 3: {
                    // Eliminar departamento
                    System.out.println("Introduce un código de departamento: ");
                    String clave = in.nextLine();
                    try {
                        Admin.eliminarDepartamento(clave);
                        System.out.println("Departamento eliminado.");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 4: {
                    // Listar Salas
                    Admin.listarSalas();
                    break;
                }
                case 5: {
                    // Añadir sala
                    System.out.println("Introduce el nombre de la sala: ");
                    String nombre=in.nextLine();
                    System.out.println("Introduce la clave de la sala: ");
                    String clave = in.nextLine();
                    try {
                        Admin.añadirSala(nombre,clave);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 6: {
                    // Eliminar sala
                    System.out.println("Introduce la clave de la sala: ");
                    String clave = in.nextLine();
                    try {
                        Admin.eliminarSala(clave);
                        System.out.println("Sala eliminada");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 7: {
                    // Listar reservas
                    Admin.listarReservasTodas();
                    break;
                }
                case 8: {
                    // Cerrar sesión
                    System.out.println("Cierre de sesión.");
                    MenuPrincipal.escribir();
                    break;
                }
                default: {
                    // Opción no válida
                    System.out.println("Opción introducida no válida.");
                    break;
                }
            }
        }
    }
}
