package controller;

import java.awt.Dimension;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.Aluno;
import service.AlunoTreeService;
import view.AlunoGUI;
import view.TelaPrincipalGUI;
import view.CustomComponents.AlunoTableModel;
import view.CustomComponents.FontPaletas;

/**
 * Controller da Aplicação onde conectamos as classes GUI da pasta view com a pasta service.
 * Aqui então fazemos a conexão do que é front com o que é back-end da aplicação.
 * 
 * Estamos utilizando então a classe de Tela Principal, AlunoGUI, Aluno (model), AlunoTreeService (service da aplicação)
 * e alunoTableModel que é onde cria a tabela que lista todos os alunos da aplicação.
 */
public class TelaPrincipalController {

    private TelaPrincipalGUI telaPrincipalGUI;
    private AlunoGUI alunoGUI;
    private Aluno aluno;
    private AlunoTreeService service;
    private AlunoTableModel alunoTableModel;

    public TelaPrincipalController(TelaPrincipalGUI tela, AlunoTreeService service){
        this.telaPrincipalGUI = tela;
        this.service = service;
        initView();
    }

    private void initView(){
        telaPrincipalGUI.setVisible(true);
    }

    /**
     * controle dos botões da Área de Navegação e os métodos que eles chamam.
     */
    public void initController(){
        telaPrincipalGUI.getButton1().addActionListener(e-> telaInserir());
        telaPrincipalGUI.getButton2().addActionListener(e-> telaExcluir());
        telaPrincipalGUI.getButton3().addActionListener(e-> telaListarAlunos());
        telaPrincipalGUI.getButton4().addActionListener(e-> telaPesquisar());
        telaPrincipalGUI.getButton5().addActionListener(e-> telaLancarNotas());
        telaPrincipalGUI.getButton6().addActionListener(e-> sairApp());
    }
    /**
     * tela da área de texto 2 que aparece quando o botão de "Inserir Aluno" é ativado.
     */
    private void telaInserir(){
        alunoGUI = new AlunoGUI();
        telaPrincipalGUI.setAreaText2(alunoGUI);
        alunoGUI.disableNotasFaltasField();
        alunoGUI.inserirAlunoField();
        // a linha abaixo chama o método de inserir aluno quando ativado.
        alunoGUI.getInserirButton().addActionListener(e-> inserirAluno());
        alunoGUI.setVisible(true);
    }
    /**
     * tela da área de texto 2 que aparece quando o botão de "Excluir Aluno" é ativado.
     */
    private void telaExcluir(){
        alunoGUI = new AlunoGUI();
        telaPrincipalGUI.setAreaText2(alunoGUI);
        alunoGUI.disableNotasFaltasField();
        alunoGUI.excluirAlunoField();
        // a linha abaixo chama o método de buscar aluno quando o botão "Pesquisar" é ativado
        alunoGUI.getBuscarButton2().addActionListener(e-> buscarAluno());
        // a linha abaixo chama o método de excluir aluno quando o botão "Excluir" é ativado
        alunoGUI.getExcluirButton().addActionListener(e-> excluirAluno());
        alunoGUI.setVisible(true);
    }
    /**
     * tela da área de texto 2 que aparece quando o botão de "Listar Alunos" é ativado.
     */
    private void telaListarAlunos(){
        // Na linha abaixo o service chama o método da árvore balanceada e retorna os dados da árvore em ordem 
        // crescente de acordo com o número da matrícula.
        List<Aluno> alunos = service.inOrderList();
        // A linha abaixo chama o método listar alunos que colocar os dados da List acima em formato de tabela
        // de acordo com a classe AlunoTableModel. A tabela é estilizada nas linhas abaixo.
        JTable tabela = new JTable(listarAlunos(alunos));
        tabela.setBackground(FontPaletas.white());
        tabela.setFont(FontPaletas.font2());
        tabela.setGridColor(FontPaletas.darkGreen());
        tabela.setPreferredSize(new Dimension(1050, alunos.size()*20));
        tabela.getColumnModel().getColumn(0).setPreferredWidth(80);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(550);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(70);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(70);
        tabela.getColumnModel().getColumn(4).setPreferredWidth(70);
        tabela.getColumnModel().getColumn(5).setPreferredWidth(70);
        tabela.getColumnModel().getColumn(6).setPreferredWidth(70);
        telaPrincipalGUI.setAreaText2(tabela);
        telaPrincipalGUI.repaint();
    }
    /**
     * tela da área de texto 2 que aparece quando o botão de "Buscar Alunos" é ativado.
     */
    private void telaPesquisar(){
        alunoGUI = new AlunoGUI();
        telaPrincipalGUI.setAreaText2(alunoGUI);
        alunoGUI.pesquisarAlunosField();
        alunoGUI.getBuscarButton().addActionListener(e-> buscarAluno());
        alunoGUI.setVisible(true);
    }
    /**
     * tela da área de texto 2 que aparece quando o botão de "Lançar Notas" é ativado.
     */
    private void telaLancarNotas(){
        alunoGUI = new AlunoGUI();
        telaPrincipalGUI.setAreaText2(alunoGUI);
        alunoGUI.lancarNotasField();
        alunoGUI.getBuscarButton2().addActionListener(e-> buscarAluno());
        alunoGUI.getSalvarNotasButton().addActionListener(e-> salvarNotas());
        alunoGUI.setVisible(true);
    }
    /**
     * método chamado quando o botão de inserir é ativado.
     * O método confere se a matrícula inserida já está cadastrada antes de cadastrar o novo Aluno.
     * O método service.insertAluno insere o nó do objeto Aluno na árvore balanceada.
     */
    private void inserirAluno(){
        aluno = new Aluno();
        int matricula = Integer.parseInt(alunoGUI.getMatricula_txt().getText());
        if (confereMatricula(matricula)){
            JOptionPane.showMessageDialog(null, "Matrícula já utilizada, tente outra!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        aluno.setMatricula(matricula); 
        aluno.setNome(alunoGUI.getNome_txt().getText());
        aluno.setFaltas(0);
        Double[] notas = {0.0,0.0,0.0};
        aluno.setNotas(notas);
        service.insertAluno(aluno);
        JOptionPane.showMessageDialog(null, "Aluno inserido com sucesso!", "Inserir Aluno", JOptionPane.INFORMATION_MESSAGE); 
        limparCampos();
    }
    /**
     * Método para conferir a matrícula no banco de dados existente.
     */
    private boolean confereMatricula(int matricula){
        List<Aluno> alunos = service.inOrderList();
        aluno = new Aluno();
        for (Aluno aluno2 : alunos) {
            if (matricula == aluno2.getMatricula()){
                return true;
            }
        }
        return false;
    }
    /**
     * método chamado quando o botão de buscar aluno ou pesquisar é ativado.
     * O método service.searchByMatricula retorna o objeto Aluno existente na árvore balanceada.
     */
    private void buscarAluno(){
        int matricula = Integer.parseInt(alunoGUI.getMatricula_txt().getText());
        if (!confereMatricula(matricula)){
            JOptionPane.showMessageDialog(null, "Esta matrícula não existe na base!", "Erro", JOptionPane.ERROR_MESSAGE);
            limparCampos();
            return;
        }
        aluno = service.searchByMatricula(matricula).getAluno();
        alunoGUI.setNome_txt(aluno.getNome());
        alunoGUI.setFaltas_txt(String.valueOf(aluno.getFaltas()));
        Double[] notas = aluno.getNotas();
        alunoGUI.setNotas1_txt(String.valueOf(notas[0]));
        alunoGUI.setNotas2_txt(String.valueOf(notas[1]));
        alunoGUI.setNotas3_txt(String.valueOf(notas[2]));
        alunoGUI.setMedia_txt(aluno.getMedia());
        alunoGUI.repaint();
    }
    /**
     * método chamado quando o botão de listar alunos é ativado.
     * aqui organizamos a lista de alunos que o método da tela busca no service que busca na árvore balanceada e retorna
     * os dados em ordem, aqui organizamos a lista em modelo de tabela de acordo com a classe AlunoTableModel.
     */
    private AlunoTableModel listarAlunos(List<Aluno> alunos){     
        alunoTableModel = new AlunoTableModel(alunos);
        return alunoTableModel;
    }
    /**
     * método chamado quando o botão de salvar notas é ativado.
     * O método service.updateAlunoByMatricula substitui as modificações do objeto Aluno existente na árvore balanceada.
     */
    private void salvarNotas(){
        Double[] notas = new Double[3];
        String notas1 = alunoGUI.getNotas1_txt().getText();
        notas1 = notas1.replace(',','.');
        notas[0] = Double.parseDouble(notas1);
        String notas2 = alunoGUI.getNotas2_txt().getText();
        notas2 = notas2.replace(',','.');
        notas[1] = Double.parseDouble(notas2);
        String notas3 = alunoGUI.getNotas3_txt().getText();
        notas3 = notas3.replace(',','.');
        notas[2] = Double.parseDouble(notas3);
        int matricula = Integer.parseInt(alunoGUI.getMatricula_txt().getText());
        aluno.setMatricula(matricula);
        aluno.setNome(alunoGUI.getNome_txt().getText());
        aluno.setFaltas(Integer.parseInt(alunoGUI.getFaltas_txt().getText()));
        aluno.setNotas(notas);
        JOptionPane.showMessageDialog(null, "Notas atualizadas com sucesso!", "Salvar Notas", JOptionPane.INFORMATION_MESSAGE); 
        service.updateAlunoByMatricula(matricula, aluno);
        limparCampos();
    }
    /**
     * método chamado quando o botão de excluir aluno é ativado.
     * O método service.deleteAlunoByMatricula exclui o objeto Aluno existente na árvore balanceada.
     */
    private void excluirAluno(){
        buscarAluno();
        int matricula = Integer.parseInt(alunoGUI.getMatricula_txt().getText());
        if (!confereMatricula(matricula)){
            JOptionPane.showMessageDialog(null, "Esta matrícula não existe na base!", "Erro", JOptionPane.ERROR_MESSAGE);
            limparCampos();
            return;
        }
        service.deleteAlunoByMatricula(matricula);
        limparCampos();
        JOptionPane.showMessageDialog(null, "Aluno excluído com sucesso!", "Excluir Aluno", JOptionPane.INFORMATION_MESSAGE); 
        alunoGUI.repaint();
    }
    /**
     * método chamado quando o botão de sair da aplicação existente na barra de navegação é ativado.
     */
    private void sairApp(){
        System.exit(0);
    }
    /**
     * método que limpa os campos após a inserção, atualização ou exclusão ocorrem.
     */
    private void limparCampos(){
        alunoGUI.setMatricula_txt(null);
        alunoGUI.setNome_txt(null);
        alunoGUI.setNotas1_txt(null);
        alunoGUI.setNotas2_txt(null);
        alunoGUI.setNotas3_txt(null);
        alunoGUI.setMedia_txt(null);
        alunoGUI.setFaltas_txt(null);
    }

    public TelaPrincipalGUI getTelaPrincipalGUI() {
        return telaPrincipalGUI;
    }
    public void setTelaPrincipalGUI(TelaPrincipalGUI telaPrincipalGUI) {
        this.telaPrincipalGUI = telaPrincipalGUI;
    }

    public AlunoGUI getAlunoGUI() {
        return alunoGUI;
    }
    public void setAlunoGUI(AlunoGUI alunoGUI) {
        this.alunoGUI = alunoGUI;
    }

    public Aluno getAluno() {
        return aluno;
    }
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public AlunoTreeService getService() {
        return service;
    }
    public void setService(AlunoTreeService service) {
        this.service = service;
    }

    public AlunoTableModel getAlunoTableModel() {
        return alunoTableModel;
    }
    public void setAlunoTableModel(AlunoTableModel alunoTableModel) {
        this.alunoTableModel = alunoTableModel;
    }
    
    
}
