
public class Rutina {

    private String id;
    private String nombre;
    private String descripcion;
    private String nivel;
    private boolean activa;

    public Rutina(String id, String nombre, String descripcion, String nivel, boolean activa) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.nivel = nivel;
        this.activa = activa;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNivel() {
        return nivel;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    @Override
    public String toString() {
        return "Rutina{id='" + id + "', nombre='" + nombre + "', nivel='" + nivel + "', activa=" + activa + "}";
    }
}
