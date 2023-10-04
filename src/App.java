import configs.CommandLineInterface;
import service.AlunoTreeService;

public class App {
    public static void main(String[] args) {
        AlunoTreeService alunoService = new AlunoTreeService();
        Runtime.getRuntime().addShutdownHook(new Thread(alunoService::finallyApp));
        new CommandLineInterface(alunoService);
    }
}







