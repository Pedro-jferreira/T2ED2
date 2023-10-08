package view.CustomComponents;
import javax.swing.table.AbstractTableModel;
import model.Aluno;
import java.util.List;

/**
 * Classe de customização da tabela existente da tela de "Listar Alunos".
 * 
 */
public class AlunoTableModel extends AbstractTableModel {
    private List<Aluno> alunos;
    private String[] colunas = {"Matrícula", "Nome", "Nota 1", "Nota 2", "Nota 3", "Média", "Faltas"};

    public AlunoTableModel(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public int getRowCount() {
        return alunos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Aluno aluno = alunos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return aluno.getMatricula();
            case 1:
                return aluno.getNome();
            case 2:
                return aluno.getNotas()[0];
            case 3:
                return aluno.getNotas()[1];
            case 4:
                return aluno.getNotas()[2];
            case 5:
                return aluno.getMedia();
            case 6:
                return aluno.getFaltas();
            default:
                return null;
        }
    }
}
