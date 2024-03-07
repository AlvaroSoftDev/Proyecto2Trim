import java.time.Duration;
import java.time.LocalDateTime;

public class Reserva {
    protected LocalDateTime fecha;
    protected Duration duracion;

    public Reserva(int año,int mes,int dia,int horas,int duracionHoras){

        LocalDateTime fecha1=LocalDateTime.of(año,mes,dia,horas,0,0);
        Duration d1 = Duration.ofHours(duracionHoras);

        if(fecha1.getHour()<9||fecha1.getHour()>14){
            System.out.println("La fecha no es correcta.");
        }
        else{
            this.fecha = fecha1;
        }

        if(this.fecha.plusHours(duracionHoras).getHour()<=14){
            this.duracion = d1;
        }
        else{
            System.out.println("El intervalo no es correcto.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Reserva r) {
            return this.fecha ==  r.fecha && this.duracion==r.duracion;
        }
        else{
            return false;
        }
    }

    public void mostrar(){
        System.out.println("Fecha: "+this.fecha+". Duracion: "+this.duracion);
    }
}


