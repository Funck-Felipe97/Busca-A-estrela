package Busca;

import java.awt.Button;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author funck
 */

public class Tela extends JFrame{

    private Mapa mapa;
    private Button botao;
    
    public Tela(){
        iniciar();
    }
    
    public void iniciar(){
         
        // Configurando a tela 
        mapa = new Mapa();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700 , 500);
        setLocationRelativeTo(null);
        setVisible(true);
        mapa.setBackground(Color.WHITE);
        add(mapa);
        
    }
    
}
