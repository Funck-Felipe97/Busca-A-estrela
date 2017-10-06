package Busca;

import Model.Node;
import Model.NodeParede;
import Model.Objetivo;
import java.awt.Button;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Mapa extends JPanel{
    
    private List<List<Node>> nodes;
    private Button botao;
    private TextField tfX;
    private TextField tfY;
    private List<Node> caminho;

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
                eventoBotao(e);
            }
        });
    }
    
    // Evento Botao
    private void eventoBotao(ActionEvent e) {
        int x = Integer.valueOf(tfX.getText());
        int y = Integer.valueOf(tfY.getText());
        
        if(!(nodes.get(x).get(x) instanceof NodeParede)){
            try{
                Objetivo.x = x;
                Objetivo.y = y;
                caminho = new BuscaHeuristica().aStar(nodes.get(0).get(0) , nodes.get(x).get(y));
                JOptionPane.showMessageDialog(this , "De certo porr \nTamanho do caminho : "  + caminho.size());
            }catch(Exception erro){
                JOptionPane.showMessageDialog(this , "Erro :(((");
            }    
        }else{
            JOptionPane.showMessageDialog(this , "Ponto inacessivel,\n é uma parede");
        }
    }
    
    public void paintComponent( Graphics grafico ){
        super.paintComponent( grafico );
        Graphics2D g = (Graphics2D) grafico;
        int contColuna = 0;
        int contLinha = 0;
        
        for(int i = 0 ; i < nodes.size() ; ++i){
            for(int j = 0 ; j < nodes.size() ; ++j){
                nodes.get(i).get(j).renderizar(g , contColuna, contLinha);
                contColuna += 40;
            }
            contLinha += 40;
            contColuna = 0;
        }
    }
}
