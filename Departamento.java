import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Departamento {
    private String clave;
    private String nombreDepartamento;

    //Constructor
    public Departamento(String nombreDepartamento, String clave) {
        this.nombreDepartamento = nombreDepartamento;
        this.clave = clave;
    }

    //Métodos Get y Set de clave y nombre del departamento
    public String getClave() {

        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }


    @Override
    public String toString() {
        return "Nombre de Departamento: " + this.nombreDepartamento +
                ", Clave de Departamento: " + this.clave;
    }
}
