
import controller.TelaPrincipalController;
import service.AlunoTreeService;
import view.TelaPrincipalGUI;

public class App {
    public static void main(String[] args) {

        /**
         * A árvore é atualizada assim que roda a aplicação.
         * Para rodar é só dar play e colocar pra rodar.
         */

        AlunoTreeService alunoService = new AlunoTreeService();
        alunoService.refreshTree();
        TelaPrincipalController telaPrincipalController = new TelaPrincipalController(new TelaPrincipalGUI(), alunoService);
        telaPrincipalController.initController();
        Runtime.getRuntime().addShutdownHook(new Thread(alunoService::finallyApp));

    }
}







