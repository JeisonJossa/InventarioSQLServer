
package co.edu.unbosque.controller;

import java.awt.Component;
import javax.swing.JOptionPane;
import co.edu.unbosque.entity.Producto;
import java.awt.event.ActionEvent;
import co.edu.unbosque.view.VistaBodega;
import co.edu.unbosque.entity.Bodega;
import java.awt.event.ActionListener;

public class ControllerProducto implements ActionListener {
	Bodega bodega;
	VistaBodega vistaBodega;

	public ControllerProducto(final Bodega bodega, final VistaBodega vistaBodega) {
		this.bodega = null;
		this.vistaBodega = null;
		this.bodega = bodega;
		this.vistaBodega = vistaBodega;
		this.actionListener(this);
	}

	public void actionListener(final ActionListener escuchador) {
		this.vistaBodega.botonAgregarProducto.addActionListener(escuchador);
		this.vistaBodega.botonModificarProducto.addActionListener(escuchador);
		this.vistaBodega.botonEliminarProducto.addActionListener(escuchador);
		this.vistaBodega.botonMostrarProducto.addActionListener(escuchador);
		this.vistaBodega.botonMostrarUbicacion.addActionListener(escuchador);
		this.vistaBodega.botonMostrarMenorExistencia.addActionListener(escuchador);
		this.vistaBodega.botonImprimirPDF.addActionListener(escuchador);
		this.vistaBodega.botonCalcularValorTotalBodega.addActionListener(escuchador);
	}

	@Override
	public void actionPerformed(final ActionEvent objEvento) {
		if (this.vistaBodega.botonAgregarProducto == objEvento.getSource()) {
			if (!"".equals(this.vistaBodega.campoTextoNombreProducto.getText())
					&& !"".equals(this.vistaBodega.campoTextoDescProductos.getText())
					&& !"".equals(this.vistaBodega.campoTextoCodigoProducto.getText())
					&& !"".equals(this.vistaBodega.campoTextoUbicacionProducto.getText())
					&& !"".equals(this.vistaBodega.campoTextoProveedorProducto.getText())
					&& !"".equals(this.vistaBodega.campoTextoPrecioUnitario.getText())
					&& !"".equals(this.vistaBodega.campoTextoExistencia.getText())) {
				try {
					final String cExis = this.vistaBodega.campoTextoExistencia.getText();
					final String cPrecio = this.vistaBodega.campoTextoPrecioUnitario.getText();
					final int cExistencia = Integer.parseInt(cExis);
					final double cPrecioUnitario = Double.parseDouble(cPrecio);
					if (cExistencia > -1 && cPrecioUnitario > -1.0) {
						String mensaje = "";
						final String cNombreProducto = this.vistaBodega.campoTextoNombreProducto.getText();
						final String cDescProductos = this.vistaBodega.campoTextoDescProductos.getText();
						final String cUbicacionProducto = this.vistaBodega.campoTextoUbicacionProducto.getText();
						final String cProveedorProducto = this.vistaBodega.campoTextoProveedorProducto.getText();
						final String cCodigoProducto = this.vistaBodega.campoTextoCodigoProducto.getText();
						if (!this.bodega.validarCodigoProducto(cCodigoProducto)) {
							final Producto producto = new Producto(cNombreProducto, cDescProductos, cCodigoProducto,
									cUbicacionProducto, cProveedorProducto, cPrecioUnitario, cExistencia);
							mensaje = this.bodega.agregarProducto(producto);
							this.vistaBodega.mostrarMensajes(mensaje);
							this.vistaBodega.botonModificarProducto.setEnabled(true);
							this.vistaBodega.botonEliminarProducto.setEnabled(true);
							this.vistaBodega.botonMostrarProducto.setEnabled(true);
							this.vistaBodega.botonMostrarUbicacion.setEnabled(true);
							this.vistaBodega.botonMostrarMenorExistencia.setEnabled(true);
							this.vistaBodega.botonImprimirPDF.setEnabled(true);
							this.vistaBodega.botonCalcularValorTotalBodega.setEnabled(true);
							this.vistaBodega.campoTextoNombreProducto.setText("");
							this.vistaBodega.campoTextoDescProductos.setText("");
							this.vistaBodega.campoTextoCodigoProducto.setText("");
							this.vistaBodega.campoTextoUbicacionProducto.setText("");
							this.vistaBodega.campoTextoProveedorProducto.setText("");
							this.vistaBodega.campoTextoPrecioUnitario.setText("");
							this.vistaBodega.campoTextoExistencia.setText("");
						} else {
							JOptionPane.showMessageDialog(null, "El codigo del producto ya existe.", "ERROR", 0);
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"Las Cantidad de Existencias y el Precio Unitario no pueden ser un valor negativo.",
								"ERROR", 0);
					}
				} catch (NumberFormatException e) {
					this.vistaBodega.mostrarMensajes("Se ha presentado un error....");
					this.vistaBodega.campoTextoNombreProducto.setText("");
					this.vistaBodega.campoTextoDescProductos.setText("");
					this.vistaBodega.campoTextoCodigoProducto.setText("");
					this.vistaBodega.campoTextoUbicacionProducto.setText("");
					this.vistaBodega.campoTextoProveedorProducto.setText("");
					this.vistaBodega.campoTextoPrecioUnitario.setText("");
					this.vistaBodega.campoTextoExistencia.setText("");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Debe diligenciar todos los campos.", "ERROR", 0);
			}
		} else if (this.vistaBodega.botonEliminarProducto == objEvento.getSource()) {
			if (!"".equals(this.vistaBodega.campoTextoCodigoProducto.getText())) {
				try {
					final String cCodigoProducto2 = this.vistaBodega.campoTextoCodigoProducto.getText();
					final String resultado = this.bodega.eliminarProducto(cCodigoProducto2);
					this.vistaBodega.mostrarMensajes(resultado);
				} catch (NumberFormatException e) {
					this.vistaBodega.mostrarMensajes("Se ha presentado un error....");
					this.vistaBodega.campoTextoNombreProducto.setText("");
					this.vistaBodega.campoTextoDescProductos.setText("");
					this.vistaBodega.campoTextoCodigoProducto.setText("");
					this.vistaBodega.campoTextoUbicacionProducto.setText("");
					this.vistaBodega.campoTextoProveedorProducto.setText("");
					this.vistaBodega.campoTextoPrecioUnitario.setText("");
					this.vistaBodega.campoTextoExistencia.setText("");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Debe digitar el codigo del producto.", "ERROR", 0);
			}
		} else if (this.vistaBodega.botonMostrarProducto == objEvento.getSource()) {
			final String resultado2 = this.bodega.mostrarProductos();
			this.vistaBodega.mostrarMensajes(resultado2);
		} else if (this.vistaBodega.botonMostrarUbicacion == objEvento.getSource()) {
			if (!"".equals(this.vistaBodega.campoTextoCodigoProducto.getText())) {
				final String cCodigoProducto2 = this.vistaBodega.campoTextoCodigoProducto.getText();
				final String resultado = this.bodega.mostrarUbicacion(cCodigoProducto2);
				this.vistaBodega.mostrarMensajes(resultado);
			} else {
				JOptionPane.showMessageDialog(null, "Debe digitar el codigo del producto.", "ERROR", 0);
			}
		} else if (this.vistaBodega.botonCalcularValorTotalBodega == objEvento.getSource()) {
			try {
				final String resultado2 = this.bodega.calcularValorTotalBodega();
				this.vistaBodega.mostrarMensajes(resultado2);
			} catch (NumberFormatException e) {
				this.vistaBodega.mostrarMensajes("Se ha presentado un error....");
				this.vistaBodega.campoTextoNombreProducto.setText("");
				this.vistaBodega.campoTextoDescProductos.setText("");
				this.vistaBodega.campoTextoCodigoProducto.setText("");
				this.vistaBodega.campoTextoUbicacionProducto.setText("");
				this.vistaBodega.campoTextoProveedorProducto.setText("");
				this.vistaBodega.campoTextoPrecioUnitario.setText("");
				this.vistaBodega.campoTextoExistencia.setText("");
			}
		} else if (this.vistaBodega.botonModificarProducto == objEvento.getSource()) {
			if (!"".equals(this.vistaBodega.campoTextoNombreProducto.getText())
					&& !"".equals(this.vistaBodega.campoTextoDescProductos.getText())
					&& !"".equals(this.vistaBodega.campoTextoCodigoProducto.getText())
					&& !"".equals(this.vistaBodega.campoTextoUbicacionProducto.getText())
					&& !"".equals(this.vistaBodega.campoTextoProveedorProducto.getText())
					&& !"".equals(this.vistaBodega.campoTextoPrecioUnitario.getText())
					&& !"".equals(this.vistaBodega.campoTextoExistencia.getText())) {
				try {
					final String cNombreProducto2 = this.vistaBodega.campoTextoNombreProducto.getText();
					final String cDescProductos2 = this.vistaBodega.campoTextoDescProductos.getText();
					final String cCodigoProducto3 = this.vistaBodega.campoTextoCodigoProducto.getText();
					final String cUbicacionProducto2 = this.vistaBodega.campoTextoUbicacionProducto.getText();
					final String cProveedorProducto2 = this.vistaBodega.campoTextoProveedorProducto.getText();
					final double cPrecioUnitario2 = Double
							.parseDouble(this.vistaBodega.campoTextoPrecioUnitario.getText());
					final int cExistencia2 = Integer.parseInt(this.vistaBodega.campoTextoExistencia.getText());
					if (this.bodega.validarCodigoProducto(cCodigoProducto3)) {
						final String resultado3 = this.bodega.modificarProducto(cNombreProducto2, cDescProductos2,
								cCodigoProducto3, cUbicacionProducto2, cProveedorProducto2, cPrecioUnitario2,
								cExistencia2);
						this.vistaBodega.mostrarMensajes(resultado3);
					} else {
						JOptionPane.showMessageDialog(null, "El codigo del producto no existe.", "ERROR", 0);
					}
				} catch (NumberFormatException e) {
					this.vistaBodega.mostrarMensajes("Se ha presentado un error....");
					this.vistaBodega.campoTextoNombreProducto.setText("");
					this.vistaBodega.campoTextoDescProductos.setText("");
					this.vistaBodega.campoTextoCodigoProducto.setText("");
					this.vistaBodega.campoTextoUbicacionProducto.setText("");
					this.vistaBodega.campoTextoProveedorProducto.setText("");
					this.vistaBodega.campoTextoPrecioUnitario.setText("");
					this.vistaBodega.campoTextoExistencia.setText("");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos.", "ERROR", 0);
			}
		} else if (this.vistaBodega.botonMostrarMenorExistencia == objEvento.getSource()) {
			final String resultado2 = this.bodega.mostrarMenorExistencia();
			this.vistaBodega.mostrarMensajes(resultado2);
		} else if (this.vistaBodega.botonImprimirPDF == objEvento.getSource()) {
			this.bodega.imprimirPDF();
		}
	}
}