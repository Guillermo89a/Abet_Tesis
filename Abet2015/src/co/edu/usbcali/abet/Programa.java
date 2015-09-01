package co.edu.usbcali.abet;
// Generated 30/08/2015 10:05:04 PM by Zathura powered by Hibernate Tools 3.2.4.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Programa generated by Zathura powered by Hibernate-tools(hbm2java)
 */
public class Programa  implements java.io.Serializable {


     private Long idPrograma;
     private String descripcion;
     private Set<OutcomePorPrograma> outcomePorProgramas = new HashSet<OutcomePorPrograma>(0);
     private Set<Pensum> pensums = new HashSet<Pensum>(0);

    public Programa() {
    }

	
    public Programa(Long idPrograma) {
        this.idPrograma = idPrograma;
    }
    public Programa(Long idPrograma, String descripcion, Set<OutcomePorPrograma> outcomePorProgramas, Set<Pensum> pensums) {
       this.idPrograma = idPrograma;
       this.descripcion = descripcion;
       this.outcomePorProgramas = outcomePorProgramas;
       this.pensums = pensums;
    }
   
    public Long getIdPrograma() {
        return this.idPrograma;
    }
    
    public void setIdPrograma(Long idPrograma) {
        this.idPrograma = idPrograma;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Set<OutcomePorPrograma> getOutcomePorProgramas() {
        return this.outcomePorProgramas;
    }
    
    public void setOutcomePorProgramas(Set<OutcomePorPrograma> outcomePorProgramas) {
        this.outcomePorProgramas = outcomePorProgramas;
    }
    public Set<Pensum> getPensums() {
        return this.pensums;
    }
    
    public void setPensums(Set<Pensum> pensums) {
        this.pensums = pensums;
    }




}


