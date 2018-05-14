package Busca;

import Model.Node;
import Model.NodeParede;
import java.awt.Button;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Mapa extends JPanel{
    
    private Node[][] nodes;
    private Button botao;
    private TextField tfX;
    private TextField tfY;
    private Graphics2D g;
    private JLabel agente;
    private Button novaBusca;
   
    public Mapa(){
        iniciarComponentes();
    }
    
    public void iniciarComponentes(){
        setLayout(null);
        nodes = new CriaMapa().terrenos;
        
        // Criando Botoes
        botao = new Button("Iniciar");
        botao.setBounds(520 , 300 , 100 , 40);
        add(botao);
        
        // Criando TextField para a cordenada Y
        tfY = new TextField();
        tfY.setBounds(520 , 250 , 100 , 30);
        add(tfY);
        
        // Criando TextField para a cordenada X
        tfX = new TextField();
        tfX.setBounds(520 , 200 , 100 , 30);
        add(tfX);
        
        // Adicionado eventos
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    eventoBotao(e);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Mapa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        novaBusca = new Button("Nova Busca");
        novaBusca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 novaBusca(e);
            }
        });
        
        novaBusca.setBounds(520 , 350 , 100 , 40);
        
        add(novaBusca);
        
        agente = new JLabel(new ImageIcon(getClass().getResource("/imagem/agente.png")));
        agente.setBounds(10, 30 , 40 , 40);
        add(agente);
     
    }
    
    // Evento Botao
    private void eventoBotao(ActionEvent e) throws InterruptedException {
        int x = Integer.valueOf(tfX.getText());
        int y = Integer.valueOf(tfY.getText());
        
        if(!(nodes[x][y] instanceof NodeParede)){
            try{
                List<Node> caminho = new BuscaHeuristica().aEstrela(nodes[0][0] , nodes[x][y]); 
                movimentarAgente(caminho);   
            }catch(Exception erro){
                JOptionPane.showMessageDialog(this , "é impossivel alcançar este ponto");
            }
        }else{
            JOptionPane.showMessageDialog(this , "Ponto inacessivel,\n é uma parede");
        }
    }
    
    private void movimentarAgente(List<Node> caminho) throws InterruptedException{
        
        Collections.reverse(caminho);
        
        new Thread(()->{
            for(Node n : caminho){
                agente.setBounds(50 + n.posMapaX , 30 + n.posMapaY , 40 , 40);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Mapa.class.getName()).log(Level.SEVERE, null, ex);
                }
                paintComponent(g);
            }
        }).start();
        
    }
    
    public void paintComponent( Graphics grafico ){
        super.paintComponent( grafico );
        g = (Graphics2D) grafico;
    
        int contColuna = 0;
        int contLinha = 0;

        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10; ++j) {
                nodes[i][j].renderizar(g, contColuna, contLinha);
                contColuna += 40;
            }
            contLinha += 40;
            contColuna = 0;
        }
    }
    
    private void novaBusca(ActionEvent e){
        nodes = new CriaMapa().terrenos;
        agente.setBounds(10, 30 , 40 , 40);
        paintComponent(getGraphics());
    }
    
}
