import java.util.Scanner;
public class MenuAdmin {

    public static final String psswd = "ADMIN";
    public static void escribir(){
        Scanner in = new Scanner (System.in);
        String contraseña;
        System.out.println("Introduce la contraseña: ");
        contraseña = in.nextLine();
        if(psswd.equals(contraseña)){
            System.out.println("Elige una opción: \n1. Listar departamentos \n" +
                    "2. Añadir departamento \n3. Eliminar departamento \n4. Listar Sala \n5. Añadir Sala" +
                    "\n6. Eliminar Sala \n7. Listar todas las reservas \n8. Cerrar Sesión");
        }
        else{
            System.out.println("Contraseña errónea.");
            MenuPrincipal.escribir();
        }


    }
}
