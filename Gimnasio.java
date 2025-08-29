
import java.util.ArrayList;

public class Gimnasio {
    private ArrayList<Miembro> miembros;
    private ArrayList<Entrenador> entrenadores;
    private ArrayList<Rutina> rutinas;

    public Gimnasio() {
        this.miembros = new ArrayList<>();
        this.entrenadores = new ArrayList<>();
        this.rutinas = new ArrayList<>();
    }

    public boolean registrarEntrenador(String id, String nombre, String especialidad) {
        if (buscarEntrenadorPorId(id) != null) return false;
        entrenadores.add(new Entrenador(id, nombre, especialidad));
        return true;
    }

    public boolean registrarRutina(String id, String nombre, String descripcion, String nivel, boolean activa) {
        if (buscarRutinaPorId(id) != null) return false;
        rutinas.add(new Rutina(id, nombre, descripcion, nivel, activa));
        return true;
    }

    public boolean registrarMiembro(String id, String nombre, String tipoMembresia, String entrenadorId) {
        if (buscarMiembroPorId(id) != null) return false;
        Entrenador ent = buscarEntrenadorPorId(entrenadorId);
        if (ent == null) return false;
        miembros.add(new Miembro(id, nombre, tipoMembresia, ent));
        return true;
    }

    public boolean asignarRutinaAMiembro(String miembroId, String rutinaId) {
        Miembro m = buscarMiembroPorId(miembroId);
        Rutina r = buscarRutinaPorId(rutinaId);
        if (m == null || r == null) return false;
        m.setRutina(r);
        return true;
    }

    public ArrayList<Miembro> listarMiembros() {
        return new ArrayList<>(miembros);
    }

    public ArrayList<Entrenador> listarEntrenadores() {
        return new ArrayList<>(entrenadores);
    }

    public ArrayList<Rutina> listarRutinas() {
        return new ArrayList<>(rutinas);
    }

    public Rutina obtenerRutinaMasPopular() {
        Rutina mejor = null;
        int max = -1;
        for (Rutina r : rutinas) {
            int count = 0;
            for (Miembro m : miembros) {
                if (m.getRutina() != null && m.getRutina().getId().equals(r.getId())) {
                    count++;
                }
            }
            if (count > max) {
                max = count;
                mejor = r;
            }
        }
        return mejor;
    }

    public int contarRutinasActivas() {
        int c = 0;
        for (Rutina r : rutinas) if (r.isActiva()) c++;
        return c;
    }

    public Entrenador obtenerEntrenadorConMasAlumnos() {
        Entrenador mejor = null;
        int max = -1;
        for (Entrenador e : entrenadores) {
            int count = 0;
            for (Miembro m : miembros) {
                if (m.getEntrenador() != null && m.getEntrenador().getId().equals(e.getId())) {
                    count++;
                }
            }
            if (count > max) {
                max = count;
                mejor = e;
            }
        }
        return mejor;
    }

    private Miembro buscarMiembroPorId(String id) {
        for (Miembro m : miembros) if (m.getId().equals(id)) return m;
        return null;
    }
    private Entrenador buscarEntrenadorPorId(String id) {
        for (Entrenador e : entrenadores) if (e.getId().equals(id)) return e;
        return null;
    }
    private Rutina buscarRutinaPorId(String id) {
        for (Rutina r : rutinas) if (r.getId().equals(id)) return r;
        return null;
    }
}
