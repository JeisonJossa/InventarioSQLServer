
package co.edu.unbosque.controller;

import co.edu.unbosque.view.VistaBodega;
import co.edu.unbosque.entity.Bodega;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager;

public class AplBodegaProducto
{
    public static void main(final String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (UnsupportedLookAndFeelException ex) {}
        catch (ClassNotFoundException ex2) {}
        catch (InstantiationException ex3) {}
        catch (IllegalAccessException ex4) {}
        final Bodega bodega = new Bodega();
        final VistaBodega vistaBodega = new VistaBodega();
        final ControllerProducto controlador = new ControllerProducto(bodega, vistaBodega);
    }
}