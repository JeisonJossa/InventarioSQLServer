package co.edu.unbosque.view;

import javax.swing.JOptionPane;
import java.awt.Container;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JFrame;

public class VistaBodega extends JFrame
{
    public JLabel etiquetaNombreProducto;
    public JLabel etiquetaDescProducto;
    public JLabel etiquetaCodigoProducto;
    public JLabel etiquetaUbicacionProducto;
    public JLabel etiquetaProveedorProducto;
    public JLabel etiquetaPrecioUnitario;
    public JLabel etiquetaExistencia;
    public JTextField campoTextoNombreProducto;
    public JTextField campoTextoDescProductos;
    public JTextField campoTextoCodigoProducto;
    public JTextField campoTextoUbicacionProducto;
    public JTextField campoTextoProveedorProducto;
    public JTextField campoTextoPrecioUnitario;
    public JTextField campoTextoExistencia;
    public JButton botonAgregarProducto;
    public JButton botonModificarProducto;
    public JButton botonEliminarProducto;
    public JButton botonMostrarProducto;
    public JButton botonMostrarUbicacion;
    public JButton botonMostrarMenorExistencia;
    public JButton botonImprimirPDF;
    public JButton botonCalcularValorTotalBodega;
    
    public VistaBodega() {
        final JFrame ventana = new JFrame("Registro Inventario.");
        final JPanel panel = new JPanel();
        this.etiquetaNombreProducto = new JLabel("Nombre del Producto: ");
        this.etiquetaDescProducto = new JLabel("Descripci\u00f3n del Producto: ");
        this.etiquetaCodigoProducto = new JLabel("C\u00f3digo del Producto: ");
        this.etiquetaUbicacionProducto = new JLabel("Ubicaci\u00f3n del Producto: ");
        this.etiquetaProveedorProducto = new JLabel("Proveedor del Producto: ");
        this.etiquetaPrecioUnitario = new JLabel("Precio Unitario: ");
        this.etiquetaExistencia = new JLabel("Cantidad de Existencia: ");
        this.campoTextoNombreProducto = new JTextField(20);
        this.campoTextoDescProductos = new JTextField(20);
        this.campoTextoCodigoProducto = new JTextField(20);
        this.campoTextoUbicacionProducto = new JTextField(20);
        this.campoTextoProveedorProducto = new JTextField(20);
        this.campoTextoPrecioUnitario = new JTextField(20);
        this.campoTextoExistencia = new JTextField(20);
        (this.botonAgregarProducto = new JButton("Agregar Producto ")).setEnabled(true);
        (this.botonModificarProducto = new JButton("Modificar Producto ")).setEnabled(false);
        (this.botonEliminarProducto = new JButton("Eliminar Producto ")).setEnabled(false);
        (this.botonMostrarProducto = new JButton("Mostrar Productos ")).setEnabled(false);
        (this.botonMostrarUbicacion = new JButton("Mostrar Ubicaci\u00f3n ")).setEnabled(false);
        (this.botonMostrarMenorExistencia = new JButton(" Mostrar Producto con menor existencias ")).setEnabled(false);
        (this.botonImprimirPDF = new JButton(" Imprimir Inventario en PDF ")).setEnabled(false);
        (this.botonCalcularValorTotalBodega = new JButton(" Calcular Valor Total Bodega ")).setEnabled(false);
        panel.add(this.etiquetaCodigoProducto);
        panel.add(this.campoTextoCodigoProducto);
        panel.add(this.etiquetaNombreProducto);
        panel.add(this.campoTextoNombreProducto);
        panel.add(this.etiquetaDescProducto);
        panel.add(this.campoTextoDescProductos);
        panel.add(this.etiquetaUbicacionProducto);
        panel.add(this.campoTextoUbicacionProducto);
        panel.add(this.etiquetaProveedorProducto);
        panel.add(this.campoTextoProveedorProducto);
        panel.add(this.etiquetaPrecioUnitario);
        panel.add(this.campoTextoPrecioUnitario);
        panel.add(this.etiquetaExistencia);
        panel.add(this.campoTextoExistencia);
        panel.add(this.botonAgregarProducto);
        panel.add(this.botonModificarProducto);
        panel.add(this.botonEliminarProducto);
        panel.add(this.botonMostrarProducto);
        panel.add(this.botonMostrarUbicacion);
        panel.add(this.botonMostrarMenorExistencia);
        panel.add(this.botonCalcularValorTotalBodega);
        panel.add(this.botonImprimirPDF);
        ventana.setContentPane(panel);
        ventana.setVisible(true);
        ventana.setSize(400, 400);
        ventana.setDefaultCloseOperation(3);
    }
    
    public void mostrarMensajes(final String men) {
        JOptionPane.showMessageDialog(null, men);
    }
}