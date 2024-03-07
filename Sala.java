import java.util.ArrayList;
import java.util.Iterator;

public class Sala {
    protected String nomSala;
    protected String claveSala;
    protected ArrayList reservas;


    //Constructor
    public Sala (String nomSala, String claveSala){
        this.nomSala = nomSala;
        this.claveSala = claveSala;
    }

    //Otros métodos
    /*public void añadirReserva (Reserva res){
        if(comprobar(res)){
            reservas.add(res);
        }
        else{
            System.out.println("No se puede añadir.");
        }
    }*/

    /*public boolean comprobar (Reserva res){
        Iterator iterador = reservas.iterator();
        while (iterador.hasNext()){
            if(res==iterador){
                System.out.println("Esa reserva ya está hecha.");
            }
            return false;
        }
        return true;
    }*/


}
