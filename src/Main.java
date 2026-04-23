import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.Random;

public class Main {

    void main() {
        JFrame janela = new JFrame();

        janela.setTitle("DVD LOGO");
        janela.setSize(800, 600);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Painel painel = new Painel();

        janela.add(painel);
        janela.setVisible(true);
    }
}

class Painel extends JPanel {
    int x = 100;
    int y = 100;

    int velocidadeX = 2;
    int velocidadeY = 2;

    int altura = 60;
    int largura = 120;

    Color cor = Color.RED;

    public Painel() {
        Timer timer = new Timer(16, event -> atualizar());
        timer.start();
    }

    void atualizar() {

        x += velocidadeX;
        y += velocidadeY;

        repaint();
        validarColisao();
    }

    void validarColisao() {

        if(x + largura >= getWidth() || x <= 0) {
            velocidadeX = -velocidadeX;
            mudarCor();
        }
        if(y + altura >= getHeight() || y <= 0) {
            velocidadeY = -velocidadeY;
            mudarCor();
        }

    }

    void mudarCor() {
        cor = new Color(
                (int)(Math.random()*255),
                (int)(Math.random()*255),
                (int)(Math.random()*255)
        );

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.fillRect(x, y, largura, altura);
        g.setColor(cor);

    }

}
