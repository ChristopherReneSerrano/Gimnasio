
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static void imprimirMenu() {
        System.out.println("====== GIMNASIO - MENU ======");
        System.out.println("1) Registrar nuevo miembro");
        System.out.println("2) Registrar nuevo entrenador");
        System.out.println("3) Registrar nueva rutina");
        System.out.println("4) Asignar rutina a miembro");
        System.out.println("5) Ver reportes");
        System.out.println("6) Listar datos");
        System.out.println("7) Salir");
        System.out.print("Elige una opción: ");
    }

    private static void imprimirSubReportes() {
        System.out.println("--- Reportes ---");
        System.out.println("1) Rutina más popular");
        System.out.println("2) Número de rutinas activas");
        System.out.println("3) Entrenador con más alumnos");
        System.out.print("Elige una opción: ");
    }

    private static void imprimirSubListados() {
        System.out.println("--- Listados ---");
        System.out.println("1) Miembros");
        System.out.println("2) Entrenadores");
        System.out.println("3) Rutinas");
        System.out.print("Elige una opción: ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Gimnasio gym = new Gimnasio();
        boolean ejecutando = true;

        gym.registrarEntrenador("E1", "Ana Ruiz", "Fuerza");
        gym.registrarEntrenador("E2", "Luis Pérez", "Cardio");
        gym.registrarRutina("R1", "Full Body", "Rutina general de cuerpo completo", "Intermedio", true);
        gym.registrarRutina("R2", "HIIT 20", "Circuito HIIT de 20 minutos", "Avanzado", true);
        gym.registrarRutina("R3", "Movilidad", "Movilidad y estiramientos", "Básico", false);
        gym.registrarMiembro("M1", "Carla Soto", "Mensual", "E1");
        gym.registrarMiembro("M2", "Diego Muñoz", "Anual", "E2");
        gym.asignarRutinaAMiembro("M1", "R1");
        gym.asignarRutinaAMiembro("M2", "R2");

        while (ejecutando) {
            imprimirMenu();
            String opcion = sc.nextLine().trim();

            switch (opcion) {
                case "1":
                    System.out.print("ID del miembro: ");
                    String mid = sc.nextLine().trim();
                    System.out.print("Nombre: ");
                    String mnom = sc.nextLine().trim();
                    System.out.print("Tipo de membresía: ");
                    String mtipo = sc.nextLine().trim();
                    System.out.print("ID de entrenador existente: ");
                    String eid = sc.nextLine().trim();
                    boolean okM = gym.registrarMiembro(mid, mnom, mtipo, eid);
                    System.out.println(okM ? "Miembro registrado." : "No se pudo registrar (ID duplicado o entrenador inexistente).");
                    break;
                case "2":
                    System.out.print("ID del entrenador: ");
                    String nid = sc.nextLine().trim();
                    System.out.print("Nombre: ");
                    String nnom = sc.nextLine().trim();
                    System.out.print("Especialidad: ");
                    String nes = sc.nextLine().trim();
                    boolean okE = gym.registrarEntrenador(nid, nnom, nes);
                    System.out.println(okE ? "Entrenador registrado." : "No se pudo registrar (ID duplicado).");
                    break;
                case "3":
                    System.out.print("ID de la rutina: ");
                    String rid = sc.nextLine().trim();
                    System.out.print("Nombre: ");
                    String rnom = sc.nextLine().trim();
                    System.out.print("Descripción: ");
                    String rdesc = sc.nextLine().trim();
                    System.out.print("Nivel (Básico/Intermedio/Avanzado): ");
                    String rniv = sc.nextLine().trim();
                    System.out.print("Activa (true/false): ");
                    boolean ract = Boolean.parseBoolean(sc.nextLine().trim());
                    boolean okR = gym.registrarRutina(rid, rnom, rdesc, rniv, ract);
                    System.out.println(okR ? "Rutina registrada." : "No se pudo registrar (ID duplicado).");
                    break;
                case "4":
                    System.out.print("ID del miembro: ");
                    String amid = sc.nextLine().trim();
                    System.out.print("ID de la rutina: ");
                    String arid = sc.nextLine().trim();
                    boolean okA = gym.asignarRutinaAMiembro(amid, arid);
                    System.out.println(okA ? "Rutina asignada." : "No se pudo asignar (IDs inválidos).");
                    break;
                case "5":
                    imprimirSubReportes();
                    String rop = sc.nextLine().trim();
                    if ("1".equals(rop)) {
                        Rutina pop = gym.obtenerRutinaMasPopular();
                        if (pop == null) {
                            System.out.println("No hay datos suficientes."); 
                        }else {
                            System.out.println("Rutina más popular: " + pop.getNombre() + " (ID " + pop.getId() + ")");
                        }
                    } else if ("2".equals(rop)) {
                        System.out.println("Rutinas activas: " + gym.contarRutinasActivas());
                    } else if ("3".equals(rop)) {
                        Entrenador top = gym.obtenerEntrenadorConMasAlumnos();
                        if (top == null) {
                            System.out.println("No hay datos suficientes."); 
                        }else {
                            System.out.println("Entrenador con más alumnos: " + top.getNombre() + " (ID " + top.getId() + ")");
                        }
                    } else {
                        System.out.println("Opción inválida.");
                    }
                    break;
                case "6":
                    imprimirSubListados();
                    String lop = sc.nextLine().trim();
                    if ("1".equals(lop)) {
                        ArrayList<Miembro> ms = gym.listarMiembros();
                        for (Miembro m : ms) {
                            System.out.println(m);
                        }
                    } else if ("2".equals(lop)) {
                        ArrayList<Entrenador> es = gym.listarEntrenadores();
                        for (Entrenador e : es) {
                            System.out.println(e);
                        }
                    } else if ("3".equals(lop)) {
                        ArrayList<Rutina> rs = gym.listarRutinas();
                        for (Rutina r : rs) {
                            System.out.println(r);
                        }
                    } else {
                        System.out.println("Opción inválida.");
                    }
                    break;
                case "7":
                    ejecutando = false;
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
            System.out.println();
        }
        sc.close();
    }
}
