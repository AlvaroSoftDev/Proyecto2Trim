import java.util.ArrayList;
import java.util.Iterator;

public class Sala {
    protected String nomSala;
    protected String claveSala;
    protected ArrayList reservas;


    //Constructor/es
    public Sala (String nomSala, String claveSala){
        this.nomSala = nomSala;
        this.claveSala = claveSala;
        this.reservas = new ArrayList();
    }

    //OTROS MÉTODOS
    //get codigo
    public String getClaveSala() {
        return claveSala;
    }

    //get nombreSala
    public String getNomSala() {
        return nomSala;
    }

    //compararReservas
    public boolean comprobarReserva (Reserva res){
        Iterator iterador = this.reservas.iterator();
        while (iterador.hasNext()){
            Reserva item = (Reserva) iterador.next();
            if(item.getFecha().equals(res.getFecha()) ||
            res.getFecha().isAfter(item.getFecha()) && res.getFecha().isBefore(item.getFechaFin()) ||
            res.getFechaFin().isAfter(item.getFecha()) && res.getFechaFin().isBefore(item.getFechaFin())){
                return false;  //Esa reserva ya está hecha o no se puede por condiciones establecidas
            }
        }
        return true;
    }

    //añadir reservas
    public void añadirReserva (Reserva res){
        if(comprobarReserva(res)){
            this.reservas.add(res);
        }
        else{
            System.out.println("Esa reserva no se puede hacer.");
        }
    }

    //cancelar reservas
    public void cancelarReserva (Reserva res){
        if(this.reservas.equals(res)){
            this.reservas.remove(res);
        }
        else{
            System.out.println("Esa reserva no se puede eliminar.");
        }
    }

    //toString
    @Override
    public String toString() {
        return "Nombre: " + this.nomSala + ", Clave de la Sala: " + this.claveSala;
    }

    //Listar reservas
    public void listarReservas (){
        toString();
        Iterator iterador = this.reservas.iterator();
        while (iterador.hasNext()){
            Reserva item = (Reserva) iterador.next();
            System.out.println(item.toString());
    }
    }
}
