import java.util.Scanner;

public class MenuDepartamento {

    /*public static String clave;
    public static void escribir() {
        Scanner in = new Scanner(System.in);
        String claveDep;
        System.out.println("Introduce la clave del Departamento: ");
        claveDep = in.nextLine();
        if (clave.equals(claveDep)) {
            System.out.println("Elige una opción: \n1. Añadir Reserva \n" +
                    "2. Cancelar Reserva \n3. Listar todas las reservas \n4. Cerrar Sesión");
        }
    }*/

    public static void login(String clave) throws Exception {
        // Comprobamos si el departamento está creado por medio de su código
        Admin.accesoDepartamento(clave);

        Scanner in = new Scanner(System.in);
        int n = -1;
        while (n != 4) {
            System.out.println("Elige una opción: ");
            System.out.println("1. Añadir reserva");
            System.out.println("2. Cancelar reserva");
            System.out.println("3. Listar todas las reservas");
            System.out.println("4. Cerrar sesión (Volver al menú principal)");

            // Menú de opciones desde Departamento controlando las excepciones
            try {
                n = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) {
                n = -1;
            }
            switch (n) {
                case 1: {
                    // Añadir reserva
                    System.out.println("Introduce el año, mes, dia, hora y duración");
                    int year = in.nextInt();
                    int month = in.nextInt();
                    int day = in.nextInt();
                    int hour = in.nextInt();
                    int duracion = in.nextInt();
                    in.nextLine();
                    Reserva res = new Reserva(year, month, day, hour, duracion, clave);
                    System.out.println("Introduce el código de la sala");
                    String codigo = in.nextLine();
                    Admin.añadirReservaSala(res, codigo);
                    break;
                }
                case 2: {
                    // Cancelar reserva
                    System.out.println("Introduce el año, mes, dia, hora y duración");
                    int year = in.nextInt();
                    int month = in.nextInt();
                    int day = in.nextInt();
                    int hour = in.nextInt();
                    int duracion = in.nextInt();
                    Reserva res = new Reserva(year, month, day, hour, duracion, clave);
                    in.nextLine();
                    System.out.println("Introduce el código de la sala");
                    String codigo = in.nextLine();
                    Admin.cancelarReservaSala(res, codigo);
                    break;
                }
                case 3: {
                    // Listar las reservas
                    Admin.listarReservasDepartamento(clave);
                    break;
                }
                case 4: {
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


