import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Reserva {
    private LocalDateTime fecha;
    private Duration duracion;
    private LocalDateTime fechaFinal;
    private String claveDepartamento;


    public Reserva(int año,int mes,int dia,int horas,int duracionHoras,String claveDepartamento){

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
            this.fechaFinal = this.fecha.plusHours(duracionHoras);
        }
        else{
            System.out.println("El intervalo no es correcto.");
        }
        this.claveDepartamento = claveDepartamento;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public LocalDateTime getFechaFin() {
        return fechaFinal;
    }

    public Duration getDuracion() {
        return duracion;
    }

    public String getClaveDepartamento() {
        return claveDepartamento;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Reserva r) {
            return this.fecha.isEqual(r.fecha) && this.fechaFinal.isEqual(r.fechaFinal)
                    && this.claveDepartamento.equals(r.claveDepartamento);
        }
        else{
            return false;
        }
    }

    @Override
    public String toString() {
        DateTimeFormatter d1 = DateTimeFormatter.ofPattern("dd/MM/yyyy-hh:mm:ss a");
        return "Reserva: " + this.fecha.format(d1) + " - " + this.fechaFinal.format(d1) +
                " - Departamento: " + this.claveDepartamento;
    }

    public void mostrar(){
        System.out.println("Fecha: "+this.fecha+". Duracion: "+this.duracion);
    }
}


