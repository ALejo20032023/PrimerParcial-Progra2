import java.util.ArrayList;
import java.util.List;

class Catedratico {
    private static int numCatedratico = 0;
    private String nombre;
    private String direccion;
    private String telefono;
    private String profesion;
    private int numero;

    public Catedratico(String nombre, String direccion, String telefono, String profesion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.profesion = profesion;
        this.numero = ++numCatedratico;
    }

    public void imprimirDatos() {
        System.out.println("Catedrático Número: " + numero + ", Nombre: " + nombre + ", Dirección: " + direccion + ", Teléfono: " + telefono + ", Profesión: " + profesion);
    }
}

class Alumno {
    private static int numAlumno = 0;
    private String nombre;
    private String direccion;
    private String telefono;
    private int edad;
    private int carnet;

    public Alumno(String nombre, String direccion, String telefono, int edad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.edad = edad;
        this.carnet = ++numAlumno;
    }

    public int getCarnet() {
        return carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void imprimirDatos() {
        System.out.println("Alumno Carnet: " + carnet + ", Nombre: " + nombre + ", Dirección: " + direccion + ", Teléfono: " + telefono + ", Edad: " + edad);
    }
}

class Curso {
    private static int idCounter = 0;
    private int id;
    private String titulo;
    private int numMaxAlumno;
    private int creditos;
    private List<Alumno> alumnosAsignados = new ArrayList<>();
    private List<Catedratico> catedraticos = new ArrayList<>();

    public Curso(String titulo, int numMaxAlumno, int creditos) {
        this.id = ++idCounter;
        this.titulo = titulo;
        this.numMaxAlumno = numMaxAlumno;
        this.creditos = creditos;
    }

    public boolean agregaAlumno(Alumno alumno) {
        if (alumnosAsignados.size() < numMaxAlumno) {
            alumnosAsignados.add(alumno);
            return true;
        } else {
            System.out.println("No hay espacio en el curso " + titulo + ".");
            return false;
        }
    }

    public void agregarCatedratico(Catedratico catedratico) {
        catedraticos.add(catedratico);
    }

    public void imprimirDatos() {
        System.out.println("Curso ID: " + id + ", Título: " + titulo + ", Créditos: " + creditos + ", Alumnos inscritos: " + alumnosAsignados.size());
        for (Catedratico catedratico : catedraticos) {
            catedratico.imprimirDatos();
        }
    }
    public String getTitulo() {
        return titulo;
    }
}

class Asignacion {
    private Alumno alumno;
    private Curso curso;

    public Asignacion(Alumno alumno, Curso curso) {
        this.alumno = alumno;
        this.curso = curso;
    }

    public void ejecutarAsignacion() {
        if (curso.agregaAlumno(alumno)) {
            System.out.println("Alumno " + alumno.getCarnet() + " asignado al curso " + curso.getTitulo());
        }
    }
}

public class Test {
    public static void main(String[] args) {
        Catedratico c1 = new Catedratico("Devin Solorzano", "Calle 123", "555-1234", "Matemáticas");
        Catedratico c2 = new Catedratico("Lucas Perez", "Avenida 456", "555-5678", "Informática");
        Catedratico c3 = new Catedratico("Anibal Cordova", "Boulevard 789", "555-9101", "Redes");

        Curso curso1 = new Curso("Sistemas Operativos", 2, 4);
        Curso curso2 = new Curso("Programación II", 5, 5);
        Curso curso3 = new Curso("Bases de Datos", 5, 4);

        Alumno a1 = new Alumno("Alejandro Morales", "Calle A", "555-1111", 20);
        Alumno a2 = new Alumno("Yuridia Cruz", "Calle B", "555-2222", 22);
        Alumno a3 = new Alumno("Kevin Urrutia", "Calle C", "555-3333", 21);

        curso1.agregarCatedratico(c1);
        curso2.agregarCatedratico(c2);
        curso3.agregarCatedratico(c3);

        Asignacion asignacion1 = new Asignacion(a1, curso1);
        Asignacion asignacion2 = new Asignacion(a2, curso1);
        Asignacion asignacion3 = new Asignacion(a3, curso2);

        asignacion1.ejecutarAsignacion();
        asignacion2.ejecutarAsignacion();
        asignacion3.ejecutarAsignacion();

        curso1.imprimirDatos();
        curso2.imprimirDatos();
        curso3.imprimirDatos();

        a1.imprimirDatos();
        a2.imprimirDatos();
        a3.imprimirDatos();
    }
}
