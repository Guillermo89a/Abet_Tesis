package co.edu.usbcali.abet;
// Generated 30/08/2015 10:05:04 PM by Zathura powered by Hibernate Tools 3.2.4.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Docente generated by Zathura powered by Hibernate-tools(hbm2java)
 */
public class Docente  implements java.io.Serializable {


     private Long idCodigoDocente;
     private String nombreDocente;
     private Set<Curso> cursos = new HashSet<Curso>(0);

    public Docente() {
    }

	
    public Docente(Long idCodigoDocente) {
        this.idCodigoDocente = idCodigoDocente;
    }
    public Docente(Long idCodigoDocente, String nombreDocente, Set<Curso> cursos) {
       this.idCodigoDocente = idCodigoDocente;
       this.nombreDocente = nombreDocente;
       this.cursos = cursos;
    }
   
    public Long getIdCodigoDocente() {
        return this.idCodigoDocente;
    }
    
    public void setIdCodigoDocente(Long idCodigoDocente) {
        this.idCodigoDocente = idCodigoDocente;
    }
    public String getNombreDocente() {
        return this.nombreDocente;
    }
    
    public void setNombreDocente(String nombreDocente) {
        this.nombreDocente = nombreDocente;
    }
    public Set<Curso> getCursos() {
        return this.cursos;
    }
    
    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }




}


