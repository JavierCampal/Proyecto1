package models;


public class Alumno {
    private String nombre;
    private String apellidos;
    private Double ad;
    private Double sge;
    private Double di;
    private Double pmdm;
    private Double psp;
    private Double eie;
    private Double hlc;

    public Alumno(String nombre, String apellidos, Double ad, Double sge, Double di, Double pmdm, Double psp, Double eie, Double hlc) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.ad = ad;
        this.sge = sge;
        this.di = di;
        this.pmdm = pmdm;
        this.psp = psp;
        this.eie = eie;
        this.hlc = hlc;
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

    public Double getAd() {
        return ad;
    }

    public void setAd(Double ad) {
        this.ad = ad;
    }

    public Double getSge() {
        return sge;
    }

    public void setSge(Double sge) {
        this.sge = sge;
    }

    public Double getDi() {
        return di;
    }

    public void setDi(Double di) {
        this.di = di;
    }

    public Double getPmdm() {
        return pmdm;
    }

    public void setPmdm(Double pmdm) {
        this.pmdm = pmdm;
    }

    public Double getPsp() {
        return psp;
    }

    public void setPsp(Double psp) {
        this.psp = psp;
    }

    public Double getEie() {
        return eie;
    }

    public void setEie(Double eie) {
        this.eie = eie;
    }

    public Double getHlc() {
        return hlc;
    }

    public void setHlc(Double hlc) {
        this.hlc = hlc;
    }
    
    
    
    
}
