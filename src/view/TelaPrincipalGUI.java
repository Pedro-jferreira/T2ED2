package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import view.CustomComponents.FontPaletas;
import view.CustomComponents.Jbutton;
import view.images.Images;

/**
 * Classe responsável pela criação do JFrame e Panels da tela da aplicação, incluindo os cards de botões à esquerda.
 * 
 * A tela foi organizada em: Conteúdo Superior (superiorContent) onde está o nome e imagem da aplicação;
 * Barra de Navegação (navigationBar) onde estão os cards de botões de navegação dentro da aplicação;
 * Conteúdo Principal (mainContent) que se subdividiu em outros dois painéis: Área de Texto (areaText) onde estão os
 * labels ou nomes fixos que aparecem em todas as telas, os campos das colunas dos dados; e Área de Texto 2 (areaText2)
 * onde estão os textfields, os campos de texto e botões da classe AlunoGUI.
 * 
 */
public class TelaPrincipalGUI extends JFrame{

    JLabel matricula, nome, notas, notas1, notas2, notas3, media, faltas, label1, label2;;
    Jbutton button1, button2, button3, button4, button5, button6;
    JPanel mainContent, areaText, areaText2, superiorContent, navigationBar;
    AlunoGUI aluno;

    public TelaPrincipalGUI() {

        setTitle("Estrutura de Dados 2 - Árvore AVL");
        setSize(1370, 725);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**
         * Aqui inicia a estilização do Conteúdo Superior onde está a imagem e nome da aplicação.
         * 
         */
        this.superiorContent = new JPanel();
        superiorContent.setBackground(FontPaletas.lightGray());
        superiorContent.setPreferredSize(new Dimension(1000, 100));
        
        this.label1 = new JLabel("Diário de Aulas - Professores");
        label1.setFont(FontPaletas.font1());
        label1.setForeground(FontPaletas.darkGreen());
        label1.setBorder(new EmptyBorder(10, 200, 0, 50));
        
        this.label2 = new JLabel();
        label2.setIcon(Images.IFGoiano());
        superiorContent.add(label2);
        superiorContent.add(label1);

        /**
         * Aqui começa a estilização e inclusão da tela de Conteúdo Principal que se subdivide em Área de Texto
         * e Área de Texto 2.
         */
        this.mainContent = new JPanel();
        mainContent.setBackground(FontPaletas.color1());

        this.areaText = new JPanel();
        areaText.setBackground(FontPaletas.lightGray());
        areaText.setPreferredSize(new Dimension(1125, 50));
        mainContent.add(areaText);

        this.areaText2 = new JPanel();
        areaText2.setBackground(FontPaletas.lightGray());
        areaText2.setPreferredSize(new Dimension(1125, 525));
        mainContent.add(areaText2);

        this.aluno = new AlunoGUI();
        areaText2.add(aluno);
        aluno.setVisible(false);


        /**
         * Abaixo inicia a criação e estilização da barra de navegação.
         */
        this.navigationBar = new JPanel(new GridBagLayout());
        navigationBar.setBackground(FontPaletas.darkGray());
        navigationBar.setPreferredSize(new Dimension(200,550));


        this.button1 = new Jbutton("Inserir Aluno");
        button1.setBorder(new EmptyBorder(35, 30, 35, 30));
        button1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        this.button2 = new Jbutton("Excluir Aluno");
        button2.setBorder(new EmptyBorder(35, 30, 35, 30));
        button2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        this.button3 = new Jbutton("Listar Alunos");
        button3.setBorder(new EmptyBorder(35, 30, 35, 30));
        button3.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });
        this.button4 = new Jbutton("Buscar Alunos");
        button4.setBorder(new EmptyBorder(35, 30, 35, 30));
        button4.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });
        this.button5 = new Jbutton("Lançar notas");
        button5.setBorder(new EmptyBorder(35, 30, 35, 30));
        button5.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });
        this.button6 = new Jbutton("Sair");
        button6.setBorder(new EmptyBorder(35, 30, 35, 30));
        button6.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
                button6ActionPerformed(evt);
            }
        });
        button6.setBackground(FontPaletas.red());
        button6.setForeground(FontPaletas.white());

        /**
         * Este GridBag organiza os botões da barra de navegação.
         */
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        navigationBar.add(button1, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        navigationBar.add(button2, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        navigationBar.add(button3, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        navigationBar.add(button4, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        navigationBar.add(button5, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        navigationBar.add(button6, gbc);

        /**
         * Aqui começa a organização da primeira área de texto, onde ficam os labels ou nomes de coluna que são 
         * fixos.
         */
        int widthNotas = 80;
        int heightNotas = 40;

        this.matricula = new JLabel("Matrícula");
        matricula.setFont(FontPaletas.font2());
        matricula.setPreferredSize(new Dimension(widthNotas, heightNotas));
        matricula.setHorizontalAlignment(SwingConstants.LEFT);
        this.nome = new JLabel("Nome");
        nome.setFont(FontPaletas.font2());
        nome.setPreferredSize(new Dimension(550, heightNotas));
        nome.setHorizontalAlignment(SwingConstants.CENTER);
        this.notas = new JLabel("Notas ");
        notas.setFont(FontPaletas.font2());
        notas.setPreferredSize(new Dimension(widthNotas, heightNotas));
        notas.setHorizontalAlignment(SwingConstants.CENTER);
        this.notas1 = new JLabel("Nota 1");
        notas1.setFont(FontPaletas.font2());
        notas1.setPreferredSize(new Dimension(70, heightNotas));
        notas1.setHorizontalAlignment(SwingConstants.CENTER);
        this.notas2 = new JLabel("Nota 2");
        notas2.setFont(FontPaletas.font2());
        notas2.setPreferredSize(new Dimension(70, heightNotas));
        notas2.setHorizontalAlignment(SwingConstants.CENTER);
        this.notas3 = new JLabel("Nota 3");
        notas3.setFont(FontPaletas.font2());
        notas3.setPreferredSize(new Dimension(70, heightNotas));
        notas3.setHorizontalAlignment(SwingConstants.CENTER);
        this.media = new JLabel("Média Final");
        media.setFont(FontPaletas.font2());
        media.setPreferredSize(new Dimension(100, heightNotas));
        media.setHorizontalAlignment(SwingConstants.CENTER);
        this.faltas = new JLabel("Faltas");
        faltas.setFont(FontPaletas.font2());
        faltas.setPreferredSize(new Dimension(55, heightNotas));
        faltas.setHorizontalAlignment(SwingConstants.CENTER);

        /**
         * Este gridbag organiza na tela os labels ou nomes de colunas acima.
         */
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.fill = GridBagConstraints.BOTH;
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        gbc2.gridwidth = 2;
        gbc2.insets = new Insets(0, 0, 0, 10);
        areaText.add(matricula, gbc2);
        gbc2.gridx = 3;
        gbc2.gridy = 1;
        gbc2.gridwidth = 4;
        gbc2.insets = new Insets(0, 0, 0, 10);
        areaText.add(nome, gbc2);
        gbc2.gridx = 5;
        gbc2.gridy = 1;
        gbc2.gridwidth = 1;
        gbc2.insets = new Insets(0, 10, 0, 2);
        areaText.add(notas1, gbc2);
        gbc2.gridx = 8;
        gbc2.gridy = 1;
        gbc2.gridwidth = 1;
        gbc2.insets = new Insets(0, 0, 0, 2);
        areaText.add(notas2, gbc2);
        gbc2.gridx = 9;
        gbc2.gridy = 1;
        gbc2.gridwidth = 1;
        gbc2.insets = new Insets(0, 0, 0, 2);
        areaText.add(notas3, gbc2);
        gbc2.gridx = 10;
        gbc2.gridy = 1;
        gbc2.gridwidth = 1;
        gbc2.insets = new Insets(0, 0, 0, 2);
        areaText.add(media, gbc2);
        gbc2.gridx = 11;
        gbc2.gridy = 1;
        gbc2.gridwidth = 1;
        gbc2.gridheight = 1;
        gbc2.insets = new Insets(0, 0, 0, 2);
        areaText.add(faltas, gbc2);

        setLayout(new BorderLayout());
        add(mainContent, BorderLayout.CENTER);
        add(navigationBar, BorderLayout.WEST);
        add(superiorContent, BorderLayout.NORTH);

        setVisible(true);

    }

    private void button1ActionPerformed(ActionEvent evt){

    }
    private void button2ActionPerformed(ActionEvent evt){

    }
    private void button3ActionPerformed(ActionEvent evt){

    }
    private void button4ActionPerformed(ActionEvent evt){

    }
    private void button5ActionPerformed(ActionEvent evt){

    }
    private void button6ActionPerformed(ActionEvent evt){

    }

    public Jbutton getButton1() {
        return button1;
    }
    public void setButton1(Jbutton button1) {
        this.button1 = button1;
    }

    public Jbutton getButton2() {
        return button2;
    }
    public void setButton2(Jbutton button2) {
        this.button2 = button2;
    }

    public Jbutton getButton3() {
        return button3;
    }
    public void setButton3(Jbutton button3) {
        this.button3 = button3;
    }

    public Jbutton getButton4() {
        return button4;
    }
    public void setButton4(Jbutton button4) {
        this.button4 = button4;
    }

    public Jbutton getButton5() {
        return button5;
    }
    public void setButton5(Jbutton button5) {
        this.button5 = button5;
    }

    public Jbutton getButton6() {
        return button6;
    }
    public void setButton6(Jbutton button6) {
        this.button6 = button6;
    }

    public JPanel getMainContent() {
        return mainContent;
    }
    public void setMainContent(JPanel mainContent) {
        this.mainContent = mainContent;
    }

    public JPanel getAreaText() {
        return areaText;
    }
    public void setAreaText(Component component) {
        areaText.add(component);
        revalidate();
        repaint();
    }

    public JPanel getSuperiorContent() {
        return superiorContent;
    }
    public void setSuperiorContent(JPanel superiorContent) {
        this.superiorContent = superiorContent;
    }

    public JPanel getNavigationBar() {
        return navigationBar;
    }
    public void setNavigationBar(JPanel navigationBar) {
        this.navigationBar = navigationBar;
    }

    public JLabel getLabel1() {
        return label1;
    }
    public void setLabel1(JLabel label1) {
        this.label1 = label1;
    }

    public JLabel getLabel2() {
        return label2;
    }
    public void setLabel2(JLabel label2) {
        this.label2 = label2;
    }

    public AlunoGUI getAluno() {
        return aluno;
    }
    public void setAluno(AlunoGUI aluno) {
        this.aluno = aluno;
    }
    
    public JLabel getMatricula() {
        return matricula;
    }
    public void setMatricula(JLabel matricula) {
        this.matricula = matricula;
    }

    public JLabel getNome() {
        return nome;
    }
    public void setNome(JLabel nome) {
        this.nome = nome;
    }

    public JLabel getNotas() {
        return notas;
    }
    public void setNotas(JLabel notas) {
        this.notas = notas;
    }

    public JLabel getNotas1() {
        return notas1;
    }
    public void setNotas1(JLabel notas1) {
        this.notas1 = notas1;
    }

    public JLabel getNotas2() {
        return notas2;
    }
    public void setNotas2(JLabel notas2) {
        this.notas2 = notas2;
    }

    public JLabel getNotas3() {
        return notas3;
    }
    public void setNotas3(JLabel notas3) {
        this.notas3 = notas3;
    }

    public JLabel getMedia() {
        return media;
    }
    public void setMedia(JLabel media) {
        this.media = media;
    }

    public JLabel getFaltas() {
        return faltas;
    }
    public void setFaltas(JLabel faltas){
        this.faltas = faltas;
    }

    public JPanel getAreaText2() {
        return areaText2;
    }
    public void setAreaText2(Component component) {
        areaText2.removeAll();
        areaText2.add(component);
        revalidate();
        repaint();
    }
    
    
}
