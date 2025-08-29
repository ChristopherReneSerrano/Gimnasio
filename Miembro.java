
public class Miembro {
    private String id;
    private String nombre;
    private String tipoMembresia;
    private Entrenador entrenador;
    private Rutina rutina; 

    public Miembro(String id, String nombre, String tipoMembresia, Entrenador entrenador) {
        this.id = id;
        this.nombre = nombre;
        this.tipoMembresia = tipoMembresia;
        this.entrenador = entrenador;
        this.rutina = null;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTipoMembresia() { return tipoMembresia; }

    public Entrenador getEntrenador() { return entrenador; }
    public void setEntrenador(Entrenador entrenador) { this.entrenador = entrenador; }

    public Rutina getRutina() { return rutina; }
    public void setRutina(Rutina rutina) { this.rutina = rutina; }

    @Override
    public String toString() {
        String ent = (entrenador != null) ? entrenador.getNombre() : "N/A";
        String rut = (rutina != null) ? rutina.getNombre() : "N/A";
        return "Miembro{id='" + id + "', nombre='" + nombre + "', tipo='" + tipoMembresia +
                "', entrenador='" + ent + "', rutina='" + rut + "'}";
    }
}
