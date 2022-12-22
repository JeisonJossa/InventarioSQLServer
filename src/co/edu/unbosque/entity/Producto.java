package co.edu.unbosque.entity;

public class Producto
{
    private String nombreProducto;
    private String descProductos;
    private String codigoProducto;
    private String ubicacionProducto;
    private String proveedorProducto;
    private double precioUnitario;
    private int existencia;
    
    public Producto(final String nombreProducto, final String descProductos, final String codigoProducto, final String ubicacionProducto, final String proveedorProducto, final double precioUnitario, final int existencia) {
        this.nombreProducto = nombreProducto;
        this.descProductos = descProductos;
        this.codigoProducto = codigoProducto;
        this.ubicacionProducto = ubicacionProducto;
        this.proveedorProducto = proveedorProducto;
        this.precioUnitario = precioUnitario;
        this.existencia = existencia;
    }
    
    public String getNombreProducto() {
        return this.nombreProducto;
    }
    
    public void setNombreProducto(final String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    
    public String getDescProductos() {
        return this.descProductos;
    }
    
    public void setDescProductos(final String descProductos) {
        this.descProductos = descProductos;
    }
    
    public String getCodigoProducto() {
        return this.codigoProducto;
    }
    
    public void setCodigoProducto(final String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }
    
    public String getUbicacionProducto() {
        return this.ubicacionProducto;
    }
    
    public void setUbicacionProducto(final String ubicacionProducto) {
        this.ubicacionProducto = ubicacionProducto;
    }
    
    public String getProveedorProducto() {
        return this.proveedorProducto;
    }
    
    public void setProveedorProducto(final String proveedorProducto) {
        this.proveedorProducto = proveedorProducto;
    }
    
    public double getPrecioUnitario() {
        return this.precioUnitario;
    }
    
    public void setPrecioUnitario(final double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    
    public int getExistencia() {
        return this.existencia;
    }
    
    public void setExistencia(final int existencia) {
        this.existencia = existencia;
    }
    
    public double calcularValorTotal() {
        final double valortotal = this.existencia * this.precioUnitario;
        return valortotal;
    }
}