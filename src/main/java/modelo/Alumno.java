package modelo;


import java.util.Date;
import java.util.Objects;
    public class Alumno  {
        private Long id=null;
        private String nombre;
        private String apellidos;
        private Date fechNaimiento;

        public Alumno(String nombre, String apellidos, Date fechNaimiento) {
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.fechNaimiento = fechNaimiento;
        }

        public Alumno() {
            this.nombre = "";
            this.apellidos = "";
            this.fechNaimiento = new Date();
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellidos() {
            return apellidos;
        }

        public void setApellidos(String apellidos) {
            this.apellidos = apellidos;
        }

        public Date getFechNaimiento() {
            return fechNaimiento;
        }

        public void setFechNaimiento(Date fechNaimiento) {
            this.fechNaimiento = fechNaimiento;
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 11 * hash + Objects.hashCode(this.id);
            hash = 11 * hash + Objects.hashCode(this.nombre);
            hash = 11 * hash + Objects.hashCode(this.apellidos);
            hash = 11 * hash + Objects.hashCode(this.fechNaimiento);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Alumno other = (Alumno) obj;
            if (!Objects.equals(this.nombre, other.nombre)) {
                return false;
            }
            if (!Objects.equals(this.apellidos, other.apellidos)) {
                return false;
            }
            if (!Objects.equals(this.id, other.id)) {
                return false;
            }
            return Objects.equals(this.fechNaimiento, other.fechNaimiento);
        }


        @Override
        public String toString() {
            return "alumno{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos +", fecha naciemiento= "+fechNaimiento +'}';
        }
}



