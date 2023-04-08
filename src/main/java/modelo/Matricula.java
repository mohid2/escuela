package modelo;
public class Matricula {
    public class IdMatricula {
        private long alumno;
        private long asignatura;
        private int year;

        public IdMatricula(long alumno, long asignatura, int year) {
            this.alumno = alumno;
            this.asignatura = asignatura;
            this.year = year;
        }

        public long getAlumno() {
            return alumno;
        }

        public void setAlumno(long alumno) {
            this.alumno = alumno;
        }

        public long getAsignatura() {
            return asignatura;
        }

        public void setAsignatura(long asignatura) {
            this.asignatura = asignatura;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        @Override
        public String toString() {
            return "IdMatricula{" +
                    "alumno=" + alumno +
                    ", asignatura=" + asignatura +
                    ", year=" + year +
                    '}';
        }
    }
    private IdMatricula id;

    private Integer nota=null;

    public Matricula(IdMatricula id, Integer nota) {
        this.id = id;
        this.nota = nota;
    }

    public Matricula(Long alumno, Long asignatura, int year) {
        this.id = new IdMatricula(alumno, asignatura, year);
    }

    public IdMatricula getId() {
        return id;
    }

    public void setId(IdMatricula id) {
        this.id = id;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Matricula{" +
                "id=" + id +
                ", nota=" + nota +
                '}';
    }
}
