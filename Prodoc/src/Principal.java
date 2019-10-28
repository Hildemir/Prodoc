import java.util.LinkedList;
import java.util.Scanner;

public class Principal {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String [] args){

        Scanner in = new Scanner(System.in);
        ModuloAdmin moduloAdmin = new ModuloAdmin();
        ModuloProfessor moduloProfessor = new ModuloProfessor();
        LinkedList <Atividade> pendencias = new LinkedList<>();
        LinkedList <Atividade> notificacoes = new LinkedList<>();

        int option;
        do{
            System.out.println("================");
            System.out.println("Menu Principal");
            System.out.println("================");
            System.out.println("Escolha uma opcao de usuario que deseja logar:\n1-Admistrador\n2-Professor\n3-Sair");
            option = in.nextInt();
            switch (option){
                case 1:
                    telaLoginAdmin(moduloAdmin, in, pendencias, notificacoes);
                    break;
                case 2:
                    if(moduloAdmin.getProfessores().getHead() == null){
                        System.out.println("Não há professores cadastrados.");
                    } else {
                        telaLoginProf(moduloAdmin, moduloProfessor, in, pendencias, notificacoes);
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opcao invalida. Digite novamente");

            }
        }while(option!= 3);
    }


    //Administrador

    private static void telaLoginAdmin(ModuloAdmin admin, Scanner in, LinkedList pendencias, LinkedList notificacoes) {
        Leitor leitor = new Leitor();

        while(true) {
            System.out.println("================================");
            System.out.println("Tela de Login: Administrador");
            System.out.println("================================");
            if(leitor.lerLoginAdmin(admin)){
                menuAdmin(admin, in, pendencias, notificacoes);
                break;
            } else{
                break;
            }

        }
    }

    private static void menuAdmin(ModuloAdmin moduloAdmin, Scanner in, LinkedList <Atividade>pendencias, LinkedList<Atividade> notificacoes){
        int option;
        do {
            System.out.println("=====================");
            System.out.println("Modulo administrador");
            System.out.println("======================");
            System.out.println("Escolha uma opcao:\n1-Cadastrar professor\n2-Exibir professor\n3-Alterar professor\n4-Remover professor");
            if(pendencias.isEmpty()){
                System.out.println("5-Pendências");
            } else {
                System.out.println(ANSI_RED + "5-Pendências" + ANSI_RESET);
            }

            System.out.println("6-Ranking Geral\n7-Voltar" );
            option = in.nextInt();
            in.nextLine();
            switch (option) {
                case 1:
                    moduloAdmin.cadastrarProf();
                    break;
                case 2:
                    moduloAdmin.exibirProf();
                    break;
                case 3:
                    moduloAdmin.alterarProf();
                    break;
                case 4:
                    moduloAdmin.removerProf();
                    break;
                case 5:
                    moduloAdmin.exibirPendencias(in, pendencias, notificacoes);
                    break;
//                case 6:
//                    moduloAdmin.exibirRankingGeral();                                 //exibe ranking de TODOS os professores da universidades
//                    break;
                case 7:
                    break;
                default:
                    System.out.println("Opcao invalida. Digite novamente.");
            }
        } while(option != 7);

    }


    //Professor

    private static void telaLoginProf(ModuloAdmin moduloAdmin, ModuloProfessor moduloProfessor, Scanner in, LinkedList<Atividade> pendencias, LinkedList<Atividade> notificacoes) {
        Leitor leitor = new Leitor();

        while(true) {
            System.out.println("================================");
            System.out.println("Tela de Login: Professor");
            System.out.println("================================");
            if(leitor.lerLoginProf(moduloAdmin)){
                menuProf(moduloAdmin, moduloProfessor, in, pendencias, notificacoes);
                break;
            } else{
                break;
            }

        }
    }

    public static void menuProf(ModuloAdmin moduloAdmin, ModuloProfessor moduloProfessor, Scanner in, LinkedList<Atividade> pendencias, LinkedList<Atividade> notificacoes){
        int option;
        do {
            boolean destacaNotificacao = false;
            System.out.println("=====================");
            System.out.println("Modulo professor");
            System.out.println("======================");
            System.out.println("Escolha uma opcao:\n1-Exibir dados\n2-Submeter Atividades");
            for (Atividade atividade: notificacoes) {
                if(atividade.getLido() == false){
                    destacaNotificacao = true;
                }
            }
            if(destacaNotificacao == false){
                System.out.println("3-Notificações");
            } else {
                System.out.println(ANSI_RED + "3-Notificações" + ANSI_RESET);
            }
            System.out.println("4-Alterar dados pessoais\n5-Ranking\n6-Voltar");        //ranking de professores de mesmo departamento

            option = in.nextInt();
            in.nextLine();
            switch (option) {
                case 1:
                    moduloProfessor.exibirDados(moduloProfessor, moduloAdmin);
//                    System.out.println(moduloAdmin.getProfessores().getLast().getValue().getCpf());                // imprime ultimo prof cadastrado (Teste)
//                    System.out.println(moduloAdmin.getProfessores().getLast().getValue().getNome());
//                    System.out.println(moduloAdmin.getProfessores().getLast().getValue().getEmail());
//                    System.out.println(moduloAdmin.getProfessores().getLast().getValue().getTelefone());
//                    System.out.println(moduloAdmin.getProfessores().getLast().getValue().getDepartamento());
//                    System.out.println(moduloAdmin.getProfessores().getLast().getValue().getPontuacao());
//                    System.out.println(moduloAdmin.getProfessores().getLast().getValue().getSenha());
                    break;
                case 2:
                    moduloProfessor.submeterAtividades(moduloProfessor, moduloAdmin, pendencias);
                    break;
                case 3:
                    moduloProfessor.exibirNotificacoes(notificacoes);
                    break;
                case 4:
                    moduloProfessor.alterarDados(moduloAdmin);
                    break;
//                case 5:
//                    moduloProfessor.exibirRaking();;
//                    break;
                case 6:
                    break;
                default:
                    System.out.println("Opcao invalida. Digite novamente.");
            }
        } while(option != 6);
    }


}
