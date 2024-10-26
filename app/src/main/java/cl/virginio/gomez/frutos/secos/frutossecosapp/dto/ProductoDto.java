package cl.virginio.gomez.frutos.secos.frutossecosapp.dto;

public class ProductoDto {

    private String nombre;
    private String precio;
    private String codigo;
    private String descripcion;

    public ProductoDto() {
    }

    public ProductoDto(String nombre, String precio, String codigo, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
