
package co.edu.unbosque.entity;

import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import java.io.OutputStream;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import java.util.ArrayList;

public class Bodega {
	private String nombreBodega;
	private String direccionBodega;
	private String telefonoBodega;
	private ArrayList<Producto> arrayproductos;

	public Bodega() {
		this.nombreBodega = "Don Dimadon";
		this.direccionBodega = "Avenida Siempreviva 742";
		this.telefonoBodega = "555 5555";
		this.arrayproductos = new ArrayList<Producto>();
	}

	public Bodega(final String nombreBodega, final String direccionBodega, final String telefonoBodega,
			final ArrayList<Producto> arrayproductos) {
		this.nombreBodega = "Don Dimadon";
		this.direccionBodega = "Avenida Siempreviva 742";
		this.telefonoBodega = "555 5555";
		this.arrayproductos = new ArrayList<Producto>();
		this.nombreBodega = nombreBodega;
		this.direccionBodega = direccionBodega;
		this.telefonoBodega = telefonoBodega;
		this.arrayproductos = arrayproductos;
	}

	public String getNombreBodega() {
		return this.nombreBodega;
	}

	public void setNombreBodega(final String nombreBodega) {
		this.nombreBodega = nombreBodega;
	}

	public String getDireccionBodega() {
		return this.direccionBodega;
	}

	public void setDireccionBodega(final String direccionBodega) {
		this.direccionBodega = direccionBodega;
	}

	public String getTelefonoBodega() {
		return this.telefonoBodega;
	}

	public void setTelefonoBodega(final String telefonoBodega) {
		this.telefonoBodega = telefonoBodega;
	}

	public ArrayList<Producto> getArrayproductos() {
		return this.arrayproductos;
	}

	public void setArrayproductos(final ArrayList<Producto> arrayproductos) {
		this.arrayproductos = arrayproductos;
	}

	public String agregarProducto(final Producto mProducto) {
		String resultado = "";
		this.arrayproductos.add(mProducto);
		resultado = "Se ha registrado un nuevo producto.";
		return resultado;
	}

	public String eliminarProducto(final String idProducto) {
		String resultado = "El Codigo del producto no existe.";
		for (int i = 0; i < this.arrayproductos.size(); ++i) {
			if (idProducto.equals(this.arrayproductos.get(i).getCodigoProducto())) {
				this.arrayproductos.remove(i);
				resultado = "El producto se ha eliminado correctamente.";
			}
		}
		return resultado;
	}

	public String mostrarProductos() {
		String listadoProductos = "*** LISTA DE PRODUCTOS ***\n\n a.Codigo ---- b.Nombre ---- c.Cantidad ---- d.Precio ---- e.Ubicacion ---- f.Proveedor ---- g.Descripcion ";
		listadoProductos = String.valueOf(listadoProductos)
				+ "\n------------------------------------------------------------------------------------------------------------\n";
		for (int i = 0; i < this.arrayproductos.size(); ++i) {
			listadoProductos = String.valueOf(listadoProductos) + "a: " + this.arrayproductos.get(i).getCodigoProducto()
					+ " ---- b: " + this.arrayproductos.get(i).getNombreProducto() + " ---- c: "
					+ this.arrayproductos.get(i).getExistencia() + " ---- d: $"
					+ this.arrayproductos.get(i).getPrecioUnitario() + " ---- e: "
					+ this.arrayproductos.get(i).getUbicacionProducto() + " ---- f: "
					+ this.arrayproductos.get(i).getProveedorProducto() + " ---- g: "
					+ this.arrayproductos.get(i).getDescProductos() + "\n";
		}
		return listadoProductos;
	}

	public String modificarProducto(final String nombreProducto, final String descProductos,
			final String codigoProducto, final String ubicacionProducto, final String proveedorProducto,
			final double precioUnitario, final int existencia) {
		String resultado = "";
		for (int i = 0; i < this.arrayproductos.size(); ++i) {
			if (codigoProducto.equals(this.arrayproductos.get(i).getCodigoProducto())) {
				this.arrayproductos.get(i).setNombreProducto(nombreProducto);
				this.arrayproductos.get(i).setDescProductos(descProductos);
				this.arrayproductos.get(i).setUbicacionProducto(ubicacionProducto);
				this.arrayproductos.get(i).setProveedorProducto(proveedorProducto);
				this.arrayproductos.get(i).setPrecioUnitario(precioUnitario);
				this.arrayproductos.get(i).setExistencia(existencia);
				this.arrayproductos.get(i).setCodigoProducto(codigoProducto);
			}
		}
		resultado = "Se ha modificado el producto exitosamente.";
		return resultado;
	}

	public String mostrarUbicacion(final String codigo) {
		String ubicacion = "";
		String resultado = "";
		for (int i = 0; i < this.arrayproductos.size(); ++i) {
			if (codigo.equals(this.arrayproductos.get(i).getCodigoProducto())) {
				ubicacion = this.arrayproductos.get(i).getUbicacionProducto();
				resultado = "El producto esta ubicado en: " + ubicacion;
			} else {
				resultado = "El Codigo del producto no existe.";
			}
		}
		return resultado;
	}

	public String calcularValorTotalBodega() {
		double suma = 0.0;
		String resultado = "";
		for (int i = 0; i < this.arrayproductos.size(); ++i) {
			suma += this.arrayproductos.get(i).calcularValorTotal();
		}
		resultado = "El valor total de los productos de la bodega es: $" + suma;
		return resultado;
	}

	public String mostrarMenorExistencia() {
		String resultado = "";
		Producto menor = new Producto("", "", "", "", "", 0.0, 0);
		for (int i = 0; i < this.arrayproductos.size(); ++i) {
			if (i == 0) {
				menor = this.arrayproductos.get(i);
			} else if (this.arrayproductos.get(i).getExistencia() < menor.getExistencia()) {
				menor = this.arrayproductos.get(i);
			}
		}
		resultado = "El producto con menor existencias es : \nCodigo: " + menor.getCodigoProducto() + "\nNombre : "
				+ menor.getNombreProducto() + "\nCantidad Existencias : " + menor.getExistencia();
		return resultado;
	}

	public boolean validarCodigoProducto(final String cCodigoProducto) {
		boolean resultado = false;
		for (int i = 0; i < this.arrayproductos.size(); ++i) {
			if (cCodigoProducto.equals(this.arrayproductos.get(i).getCodigoProducto())) {
				resultado = true;
			}
		}
		return resultado;
	}

	public void imprimirPDF() {
		try {
			final Document documento = new Document();
			final FileOutputStream ficheroPdf = new FileOutputStream("c:\\Users\\Public\\Inventario.pdf");
			PdfWriter.getInstance(documento, (OutputStream) ficheroPdf).setInitialLeading(20.0f);
			documento.open();
			String listadoProductos = "*** LISTA DE PRODUCTOS ***\n\n Codigo --- Nombre --- Cantidad --- Precio --- Ubicacion --- Proveedor --- Descripcion ";
			listadoProductos = String.valueOf(listadoProductos)
					+ "\n---------------------------------------------------------------------------------------------------------------------------------------\n";
			for (int i = 0; i < this.arrayproductos.size(); ++i) {
				listadoProductos = String.valueOf(listadoProductos) + this.arrayproductos.get(i).getCodigoProducto()
						+ " ----  " + this.arrayproductos.get(i).getNombreProducto() + " ---- "
						+ this.arrayproductos.get(i).getExistencia() + " ---- $"
						+ this.arrayproductos.get(i).getPrecioUnitario() + " ---- "
						+ this.arrayproductos.get(i).getUbicacionProducto() + " ---- "
						+ this.arrayproductos.get(i).getProveedorProducto() + " ---- "
						+ this.arrayproductos.get(i).getDescProductos() + "\n";
			}
			documento.add((Element) new Paragraph(listadoProductos));
			documento.close();
		} catch (Exception ex) {
		}
	}
}