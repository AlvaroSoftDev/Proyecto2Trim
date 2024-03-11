import java.util.ArrayList;
import java.util.Iterator;


public class Sala {
    protected String nomSala;
    protected String claveSala;
    protected ArrayList reservas;

    //Constructor
    public Sala(String nomSala, String claveSala) {
        this.nomSala = nomSala;
        this.claveSala = claveSala;
        this.reservas = new ArrayList();
    }

    //OTROS MÉTODOS
    //get código
    public String getClaveSala() {
        return claveSala;
    }

    //get nombreSala
    public String getNomSala() {
        return nomSala;
    }

    //Comprobar las Reservas
    public boolean comprobarReserva(Reserva res) {
        Iterator iterador = this.reservas.iterator();
        while (iterador.hasNext()) {
            Reserva item = (Reserva) iterador.next(); //tengo que hacer casting porque si no me salta error
            if (item.getFecha().equals(res.getFecha()) ||
                    res.getFecha().isAfter(item.getFecha()) && res.getFecha().isBefore(item.getFechaFin()) ||
                    res.getFechaFin().isAfter(item.getFecha()) && res.getFechaFin().isBefore(item.getFechaFin())) {
                return false;  //Esa reserva ya está hecha o no se puede por condiciones establecidas
            }
        }
        return true;
    }

    //añadir reservas
    public void añadirReserva(Reserva res) {
        if (comprobarReserva(res)) {
            this.reservas.add(res);
        } else {
            System.out.println("Esa reserva no se puede hacer.");
        }
    }

    //cancelar reservas
    public void cancelarReserva(Reserva res) {
        if (this.reservas.equals(res)) {
            this.reservas.remove(res);
        } else {
            System.out.println("Esa reserva no se puede eliminar.");
        }
    }

    //toString
    @Override
    public String toString() {
        return "Nombre: " + this.nomSala + ", Clave de la Sala: " + this.claveSala;
    }

    //Listar reservas
    public void listarReservas() {
        toString();
        Iterator iterador = this.reservas.iterator();
        while (iterador.hasNext()) {
            Reserva item = (Reserva) iterador.next();
            System.out.println(item.toString());
        }
    }

    //Listar Reservas del Departamento
    public void listarReservasDepartamento(String clave){
        Iterator iterador = this.reservas.iterator();
        while(iterador.hasNext()){
            Reserva r1= (Reserva) iterador.next();
            if (r1.getClaveDepartamento().equals(clave)) {
                System.out.println(this.toString() + " - " + r1.toString());
            }
        }
    }

    //Eliminar Reservas del Departamento
    public void eliminarReservasDepartamento(String clave) {
        ArrayList eliminar = new ArrayList();
        for (Object r: reservas) {
            if (((Reserva)r).getClaveDepartamento().equals(clave)) {
                eliminar.add(r);
            }
        }
        for (Object r: eliminar) {
            reservas.remove(r);
        }
    }
}
