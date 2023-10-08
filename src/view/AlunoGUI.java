package view;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import view.CustomComponents.FontPaletas;
import view.CustomComponents.Jbutton;
import view.CustomComponents.JtextField;

/**
 * Classe AlunoGui responsável pelos campos que são mutáveis dentro da aplicação e ficam no corpo principal, 
 * abaixo dos labels fixos existentes em todas as telas.
 * 
 * Esta classe é responsável por todos os textfield e botões que não estão na área de navegação.
 */
public class AlunoGUI extends JPanel{

    JtextField matricula_txt, nome_txt, notas1_txt, notas2_txt, notas3_txt, media_txt, faltas_txt;
    Jbutton inserirButton, excluirButton, buscarButton, buscarButton2, salvarNotasButton;
    
    public AlunoGUI(){
        setLayout(new GridBagLayout());
        setBackground(FontPaletas.lightGray());

        int widthNotas = 80;
        int heightNotas = 40;

        this.matricula_txt = new JtextField();
        matricula_txt.setFont(FontPaletas.font2());
        matricula_txt.setPreferredSize(new Dimension(125, heightNotas));
        matricula_txt.setAlignmentX(CENTER_ALIGNMENT);
        this.nome_txt = new JtextField();
        nome_txt.setFont(FontPaletas.font2());
        nome_txt.setPreferredSize(new Dimension(525, heightNotas));
        this.notas1_txt = new JtextField();
        notas1_txt.setFont(FontPaletas.font2());
        notas1_txt.setPreferredSize(new Dimension(widthNotas, heightNotas));
        this.notas2_txt = new JtextField();
        notas2_txt.setFont(FontPaletas.font2());
        notas2_txt.setPreferredSize(new Dimension(widthNotas, heightNotas));
        this.notas3_txt = new JtextField();
        notas3_txt.setFont(FontPaletas.font2());
        notas3_txt.setPreferredSize(new Dimension(widthNotas, heightNotas));
        this.media_txt = new JtextField();
        media_txt.setFont(FontPaletas.font2());
        media_txt.setPreferredSize(new Dimension(widthNotas, heightNotas));
        this.faltas_txt = new JtextField();
        faltas_txt.setFont(FontPaletas.font2());
        faltas_txt.setPreferredSize(new Dimension(widthNotas, heightNotas));


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 0, 0, 5);
        add(matricula_txt, gbc);
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.insets = new Insets(0, 0, 0, 10);
        add(nome_txt, gbc);
        gbc.gridx = 8;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 0, 0, 5);
        add(notas1_txt, gbc);
        gbc.gridx = 9;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 0, 0, 5);
        add(notas2_txt, gbc);
        gbc.gridx = 10;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 0, 0, 5);
        add(notas3_txt, gbc);
        gbc.gridx = 11;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 0, 0, 5);
        add(media_txt, gbc);
        gbc.gridx = 12;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(0, 0, 0, 5);
        add(faltas_txt, gbc);

        this.excluirButton = new Jbutton("Excluir");
        excluirButton.setBackground(FontPaletas.red());
        excluirButton.setForeground(FontPaletas.white());
        excluirButton.setBorder(new EmptyBorder(10, 40, 10, 40));
        GridBagConstraints gbcButtons = new GridBagConstraints();
        gbcButtons.gridx = 10;
        gbcButtons.gridy = 2;
        gbcButtons.gridwidth = 4;
        gbcButtons.insets = new Insets(20, 80, 0, 0);
        excluirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                excluirButtonActionPerformed(evt);
            }
        });
        add(excluirButton, gbcButtons);

        this.inserirButton = new Jbutton("Inserir");
        inserirButton.setBackground(FontPaletas.darkGreen());
        inserirButton.setForeground(FontPaletas.white());
        inserirButton.setBorder(new EmptyBorder(10, 50, 10, 50));
        gbcButtons.gridx = 10;
        gbcButtons.gridy = 3;
        gbcButtons.gridwidth = 4;
        gbcButtons.insets = new Insets(20, 50, 0, 0);
        inserirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                inserirButtonActionPerformed(evt);
            }
        });
        add(inserirButton, gbcButtons);

        this.buscarButton2 = new Jbutton("Pesquisar");
        buscarButton2.setBackground(FontPaletas.color1());
        buscarButton2.setForeground(FontPaletas.white());
        buscarButton2.setBorder(new EmptyBorder(10, 35, 10, 35));
        gbcButtons.gridx = 8;
        gbcButtons.gridy = 2;
        gbcButtons.gridwidth = 4;
        gbcButtons.insets = new Insets(20, 30, 0, 0);
        buscarButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buscarButton2ActionPerformed(evt);
            }
        });
        add(buscarButton2, gbcButtons);

        this.buscarButton = new Jbutton("Pesquisar");
        buscarButton.setBackground(FontPaletas.color1());
        buscarButton.setForeground(FontPaletas.white());
        buscarButton.setBorder(new EmptyBorder(10, 35, 10, 35));
        gbcButtons.gridx = 11;
        gbcButtons.gridy = 2;
        gbcButtons.gridwidth = 4;
        gbcButtons.insets = new Insets(20, 20, 0, 0);
        buscarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buscarButtonActionPerformed(evt);
            }
        });
        add(buscarButton, gbcButtons);

        this.salvarNotasButton = new Jbutton("Gravar Notas");
        salvarNotasButton.setBackground(FontPaletas.color1());
        salvarNotasButton.setForeground(FontPaletas.white());
        salvarNotasButton.setBorder(new EmptyBorder(10, 28, 10, 28));
        gbcButtons.gridx = 11;
        gbcButtons.gridy = 2;
        gbcButtons.gridwidth = 4;
        gbcButtons.insets = new Insets(20, 10, 0, 0);
        salvarNotasButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                salvarNotasButtonActionPerformed(evt);
            }
        });
        add(salvarNotasButton, gbcButtons);

        setVisible(true);
    }
    /**
     * o método abaixo retira a possibilidade de edição dos dados existentes nos campos de notas, média e faltas.
     */
    public void disableNotasFaltasField(){
        notas1_txt.setBackground(FontPaletas.lightGray());
        notas1_txt.setForeground(FontPaletas.black());
        notas1_txt.setEditable(false);
        notas2_txt.setBackground(FontPaletas.lightGray());
        notas2_txt.setForeground(FontPaletas.black());
        notas2_txt.setEditable(false);
        notas3_txt.setBackground(FontPaletas.lightGray());
        notas3_txt.setForeground(FontPaletas.black());
        notas3_txt.setEditable(false);
        media_txt.setBackground(FontPaletas.lightGray());
        media_txt.setForeground(FontPaletas.black());
        media_txt.setEditable(false);
        faltas_txt.setBackground(FontPaletas.lightGray());
        faltas_txt.setForeground(FontPaletas.black());
        faltas_txt.setEditable(false);
    }
    /**
     * o método abaixo retira os botões indesejáveis da tela de "Inserir Alunos" e deixa só o de inserir.
     */
    public void inserirAlunoField(){
        inserirButton.setVisible(true);
        excluirButton.setVisible(false);
        buscarButton2.setVisible(false);
        buscarButton.setVisible(false);
        salvarNotasButton.setVisible(false);
    }
    /**
     * o método abaixo retira os botões indesejáveis da tela de "Excluir Alunos" e deixa só o de pesquisar e o de excluir.
     */
    public void excluirAlunoField(){
        excluirButton.setVisible(true);
        inserirButton.setVisible(false);
        buscarButton2.setVisible(true);
        buscarButton.setVisible(false);
        salvarNotasButton.setVisible(false);
    }
    /**
     * o método abaixo retira os botões indesejáveis da tela de "Pesquisar Alunos" e deixa só o de pesquisar.
     * aqui ele chama o método acima que retira a possibilidade de edição dos campos, deixando só matrícula editável.
     */
    public void pesquisarAlunosField(){
        nome_txt.setBackground(FontPaletas.lightGray());
        nome_txt.setForeground(FontPaletas.black());
        nome_txt.setEditable(false);
        disableNotasFaltasField();
        excluirButton.setVisible(false);
        inserirButton.setVisible(false);
        buscarButton2.setVisible(false);
        buscarButton.setVisible(true);
        salvarNotasButton.setVisible(false);
    }
    /**
     * o método abaixo retira os botões indesejáveis da tela de "Lançar Notas" deixando só o de pesquisar e salvar notas.
     */
    public void lancarNotasField(){
        nome_txt.setBackground(FontPaletas.lightGray());
        nome_txt.setForeground(FontPaletas.black());
        nome_txt.setEditable(false);
        media_txt.setBackground(FontPaletas.lightGray());
        media_txt.setForeground(FontPaletas.black());
        media_txt.setEditable(false);
        buscarButton2.setVisible(true);
        excluirButton.setVisible(false);
        inserirButton.setVisible(false);
        buscarButton.setVisible(false);
        salvarNotasButton.setVisible(true);
    }
    /**
     * métodos de controle dos eventos.
     */
    private void excluirButtonActionPerformed(ActionEvent evt){    }
    private void inserirButtonActionPerformed(ActionEvent evt){    }
    private void buscarButtonActionPerformed(ActionEvent evt){    }
    private void buscarButton2ActionPerformed(ActionEvent evt){    }
    private void salvarNotasButtonActionPerformed(ActionEvent evt){    }

    public JtextField getMatricula_txt() {
        return matricula_txt;
    }
    public void setMatricula_txt(String matricula) {
        matricula_txt.setText(matricula);
    }

    public JtextField getNome_txt() {
        return nome_txt;
    }
    public void setNome_txt(String texto) {
        nome_txt.setText(texto);
    }

    public JtextField getNotas1_txt() {
        return notas1_txt;
    }
    public void setNotas1_txt(String nota1) {
        notas1_txt.setText(nota1);
    }

    public JtextField getNotas2_txt() {
        return notas2_txt;
    }
    public void setNotas2_txt(String nota2) {
        notas2_txt.setText(nota2);
    }

    public JtextField getNotas3_txt() {
        return notas3_txt;
    }
    public void setNotas3_txt(String nota3) {
        notas3_txt.setText(nota3);
    }

    public JtextField getMedia_txt() {
        return media_txt;
    }
    public void setMedia_txt(Double media) {
        media_txt.setText(String.valueOf(media));
    }

    public JtextField getFaltas_txt() {
        return faltas_txt;
    }
    public void setFaltas_txt(String qtddFaltas) {
        faltas_txt.setText(qtddFaltas);
    }

    public Jbutton getInserirButton() {
        return inserirButton;
    }
    public void setInserirButton(Jbutton inserirButton) {
        this.inserirButton = inserirButton;
    }

    public Jbutton getExcluirButton() {
        return excluirButton;
    }
    public void setExcluirButton(Jbutton excluirButton) {
        this.excluirButton = excluirButton;
    }

    public Jbutton getBuscarButton() {
        return buscarButton;
    }
    public void setBuscarButton(Jbutton buscarButton) {
        this.buscarButton = buscarButton;
    }

    public Jbutton getSalvarNotasButton() {
        return salvarNotasButton;
    }
    public void setSalvarNotasButton(Jbutton salvarNotasButton) {
        this.salvarNotasButton = salvarNotasButton;
    }

    public Jbutton getBuscarButton2() {
        return buscarButton2;
    }
    public void setBuscarButton2(Jbutton buscarButton2) {
        this.buscarButton2 = buscarButton2;
    }

    

}
