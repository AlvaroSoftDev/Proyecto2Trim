import java.util.ArrayList;
import java.util.Iterator;

public class Admin {
    protected String contraseña;
    protected static ArrayList departamentos = new ArrayList();
    protected static ArrayList salas = new ArrayList();

    //Accesos a Departamentos y a Salas
    public static Departamento accesoDepartamento(String clave) throws Exception {
        for (Object d: departamentos) {
            if (d.getClave().equals(clave)) {
                return (Departamento) d;
            }
        }
        throw new Exception("No existe ese Departamento.");
    }

    public static Sala accesoSala(String clave) throws Exception {
        for (Object s: salas) {
            if (s.getClaveSala().equals(clave)) {
                return (Sala) s;
            }
        }
        throw new Exception("No existe esa Sala.");
    }

    //Comprobar departamentos
    public static boolean comprobarDepartamento(String nombre, String clave) {
        Iterator iterador = departamentos.iterator();
        while (iterador.hasNext()) {
            Departamento elemento = (Departamento) iterador.next();
            if (elemento.getNombreDepartamento().equals(nombre) || elemento.getClave().equals(clave)) {
                return true;
            }
        }
        return false;
    }

    //Añadir departamentos
    public static void añadirDepartamento(String nombre, String clave) throws Exception {
        if (comprobarDepartamento(nombre, clave)) {
            throw new Exception("Ya hay un departamento con ese nombre o esa clave");
        }
        Departamento d = new Departamento(nombre, clave);
        departamentos.add(d);
    }

    //Eliminar departamentos
    public static void eliminarDepartamento(String clave) throws Exception {
        Departamento d = accesoDepartamento(clave);
        departamentos.remove(d);
        for (Sala s: salas) {
            s.eliminarReservasDepartamento(clave);
        }
    }

    //Listar departamentos
    public static void listarDepartamentos() {
        Iterator iterador = departamentos.iterator();
        while (iterador.hasNext()) {
            Departamento elemento = (Departamento) iterador.next();
            System.out.println(elemento.toString());
        }
    }

    //Comprobar Sala
    public static boolean comprobarSala(String nombre, String clave) {
        Iterator iterador = salas.iterator();
        while (iterador.hasNext()) {
            Sala elemento = (Sala) iterador.next();
            if (elemento.getNomSala().equals(nombre) || elemento.getClaveSala().equals(clave)) {
                return true;
            }
        }
        return false;
    }

    //Añadir Sala
    public static void añadirSala(String nombre, String clave) throws Exception {
        if (comprobarSala(nombre, clave)) {
            throw new Exception("Ya hay una sala con ese nombre o esa clave");
        }
        Sala s = new Sala(nombre, clave);
        salas.add(s);
    }

    //Eliminar Sala
    public static void eliminarSala(String clave) throws Exception {
        Sala s = accesoSala(clave);
        salas.remove(s);
    }

    //Listas las Salas
    public static void listarSalas() {
        Iterator iterador = salas.iterator();
        while (iterador.hasNext()) {
            Sala elemento = (Sala) iterador.next();
            System.out.println(elemento.toString());
        }
    }

    //Listar todas las Reservas realizadas
    public static void listarReservasTodas() {
        Iterator iterador = salas.iterator();
        while (iterador.hasNext()) {
            Sala s1 = (Sala) iterador.next();
            s1.listarReservas();
        }
    }

    // Añadir Reserva de Sala
    public static void añadirReservaSala(Reserva res,String clave) {
        Iterator iterator = salas.iterator();
        while (iterator.hasNext()) {
            Sala s1 = (Sala) iterator.next();
            if (s1.getClaveSala().equals(clave)) {
                s1.añadirReserva(res);
            }
        }
    }

    //Cancelar Reserva de Sala
    public static void cancelarReservaSala(Reserva res, String clave) {
        Iterator iterator = salas.iterator();
        while (iterator.hasNext()) {
            Sala elementosala = (Sala) iterator.next();
            if (elementosala.getClaveSala().equals(clave)) {
                elementosala.cancelarReserva(res);
            }
        }
    }

    //Listar las Reservas
    public static void listarReservasDepartamento(String clave) {
        Iterator iterador = salas.iterator();
        while (iterador.hasNext()) {
            Sala s1 = (Sala) iterador.next();
            s1.listarReservasDepartamento(clave);
        }
    }


}
