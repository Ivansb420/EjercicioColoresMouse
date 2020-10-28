
package ejerciciocoloresmouse;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

public class Controlador implements MouseListener{
    private final Vista vista;
    private Color color;
    
    public Controlador(){
        this.vista=new Vista(this);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        Object titulo=me.getSource();
        if (titulo instanceof JPanel) {
            String nombre=((JPanel)titulo).getName();
            switch (nombre) {
                case Vista.P_COLOR_1:
                    vista.cambiarColorTitulo(Color.GREEN);
                    break;
                case Vista.P_COLOR_2:
                    vista.cambiarColorTitulo(Color.YELLOW);
                    break;
                case Vista.P_COLOR_3:
                    vista.cambiarColorTitulo(Color.RED);
                    break;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        Object entrada=me.getSource();
        if (entrada instanceof JPanel) {
            String nombre=((JPanel)entrada).getName();
            switch (nombre) {
                case Vista.P_COLOR_1:
                    color=Color.GREEN;                   
                    break;
                case Vista.P_COLOR_2:
                    color=Color.YELLOW;                    
                    break;
                case Vista.P_COLOR_3:
                    color=Color.red;                    
                    break;
                case Vista.PANEL_MEDIO:
                    vista.cambiarColorPanel(color);
                    break;
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (me.getSource() instanceof JPanel) {
            vista.panelOriginal();
        }
    }
}
