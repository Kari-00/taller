import java.util.Objects;

public class Comercial extends Empleado {

    private double comision;

    @Override
    public boolean plus(double sueldoPlus) {
        boolean aumento = false;
        if (comision < 50) {
            salario += sueldoPlus;
            aumento = true;
        }
        return aumento;
    }

    public Comercial() {
        super();
        this.comision = 0;
    }

    public Comercial(String nombre, String apellido, int edad, double salario, double comision) {
        super(nombre, apellido, edad, salario);
        this.setComision(comision);  // Validación de comisión
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        if (comision < 0) {
            throw new IllegalArgumentException("La comisión no puede ser negativa.");
        }
        this.comision = comision;
    }

    @Override
    public double calcularSalarioFinal() {
        return this.salario + this.comision;
    }

    @Override
    public String toString() {
        return "Comercial{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", salario=" + salario +
                ", comision=" + comision +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comercial comercial = (Comercial) o;
        return Double.compare(comercial.comision, comision) == 0 &&
                Double.compare(comercial.salario, salario) == 0 &&
                edad == comercial.edad &&
                Objects.equals(nombre, comercial.nombre) &&
                Objects.equals(apellido, comercial.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido, edad, salario, comision);
    }
}
