
package ejerciciocoloresmouse;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Vista extends JFrame{
    private final Controlador controlador;
    private final ImageIcon RASTA=new ImageIcon(getClass().getResource("../assets/rasta.png"));
    private JLabel titulo, imagen;
    private JPanel pTitulo, pMedio, pColores, pSuplente, pColor1, pColor2, pColor3;
    private final int ANCHO=400;
    private final int ALTO=500;
    static final String TITULO="TITULO";
    static final String PANEL_MEDIO="PANEL_MEDIO";
    static final String P_COLOR_1="P_COLOR_1";
    static final String P_COLOR_2="P_COLOR_2";
    static final String P_COLOR_3="P_COLOR_3";
    
    public Vista(Controlador controlador){
        super();
        this.controlador=controlador;
        setSize(ANCHO, ALTO);
        configurarVentana();
        crearPaneles();
        anadirEscuchadores();
        setVisible(true);
    }

    private void configurarVentana() {
        setLayout(new GridLayout(4, 0));
    }
    
    private void crearPaneles(){
        pTitulo=new JPanel(new BorderLayout());
        add(pTitulo);
        
        titulo=new JLabel("TRINITARIAS", SwingConstants.CENTER);
        titulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
        titulo.setName(TITULO);
        pTitulo.add(titulo);
        
        pMedio=new JPanel();
        pMedio.setName(PANEL_MEDIO);
        pMedio.setBackground(Color.WHITE);
        add(pMedio);
        
        pSuplente=new JPanel();
        add(pSuplente);
        
        imagen=new JLabel(RASTA);
        pSuplente.add(imagen);
        
        pColores=new JPanel(new GridLayout(0, 3, 15, 0));
        add(pColores);
        
        pColor1=new JPanel();
        pColor1.setName(P_COLOR_1);
        pColor1.setBackground(Color.GREEN);
        pColores.add(pColor1);
        
        pColor2=new JPanel();
        pColor2.setName(P_COLOR_2);
        pColor2.setBackground(Color.YELLOW);
        pColores.add(pColor2);
        
        pColor3=new JPanel();
        pColor3.setName(P_COLOR_3);
        pColor3.setBackground(Color.RED);
        pColores.add(pColor3);
    }

    private void anadirEscuchadores() {
        titulo.addMouseListener(controlador);        
        pMedio.addMouseListener(controlador);
        pColor1.addMouseListener(controlador);
        pColor2.addMouseListener(controlador);
        pColor3.addMouseListener(controlador);
    }
    
    public void cambiarColorTitulo(Color color){
        titulo.setForeground(color);
    }
    
    public void cambiarColorPanel(Color color){
        pMedio.setBackground(color);
    }

    public void panelOriginal() {
        pMedio.setBackground(Color.WHITE);
    }

}
