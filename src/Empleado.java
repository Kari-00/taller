import java.util.Objects;

public abstract class Empleado implements Trabajador {

    protected final static double SALARIO_DEF = 600;
    protected String nombre;
    protected String apellido;
    protected int edad;
    protected double salario;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad < 18) {
            throw new IllegalArgumentException("El empleado debe tener al menos 18 años.");
        }
        this.edad = edad;
    }

    @Override
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario < 0) {
            throw new IllegalArgumentException("El salario no puede ser negativo.");
        }
        this.salario = salario;
    }

    @Override
    public abstract boolean plus(double sueldoPlus);

    public Empleado() {
        this("", "", 0, SALARIO_DEF);
    }

    public Empleado(String nombre, String apellido, int edad, double salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.setEdad(edad);  // Validación de edad
        this.setSalario(salario);  // Validación de salario
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", salario=" + salario +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return edad == empleado.edad &&
                Double.compare(empleado.salario, salario) == 0 &&
                Objects.equals(nombre, empleado.nombre) &&
                Objects.equals(apellido, empleado.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido, edad, salario);
    }
}
