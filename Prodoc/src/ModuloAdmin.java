import java.util.LinkedList;
import java.util.Scanner;

public class ModuloAdmin {
    private Leitor leitor;
    private LinkedListEspecial<String, Professor> professores;

    public ModuloAdmin() {
        this.leitor = new Leitor();
        this.professores = new LinkedListEspecial();
    }

    public void cadastrarProf(){
        String cpf = leitor.lerCpf();
        while(professores.containsKey(cpf)) {
            System.out.print("Cpf ja existente, tente de novo.");
            cpf = leitor.lerCpf();
        }
        Professor professor = new Professor(cpf, leitor.lerSenhacadastro(), leitor.lerNome(), leitor.lerEmail(), leitor.lerTelefone(), leitor.lerDepartamento(), leitor.lerEspecialidades());
        professores.put(cpf, professor);
    }

    public void exibirProf() {
        if (professores.getHead() != null) {
            Professor professor = getProfessor();
            System.out.println("Cpf: " + professor.getCpf());
            System.out.println("Nome: " + professor.getNome());
            System.out.println("Email: " + professor.getEmail());
            System.out.println("Telefone: " + professor.getTelefone());
            System.out.println("Departamento: " + professor.getDepartamento());
            System.out.println("Pontuação: " + professor.getPontuacao());
            if(!professor.getEspecialidade().isEmpty()){
                System.out.println("Especialidades: ");
                for (String e: professor.getEspecialidade()) {
                    System.out.print("\t*");
                    System.out.println(e);
                }
            } else {
                System.out.println("Especialidades: nenhuma.");
            }
        } else {
            System.out.println("Nenhum professor cadastrado");
        }
    }


    public void alterarProf() {
        int opcao;
        if (professores.getHead() != null) {
            Professor professor = getProfessor();
            do{
                System.out.println("Digite  a opcao que deseja alterar: ");
                System.out.println("1 - Telefone");
                System.out.println("2 - Email;");
                System.out.println("3 - Telefone e Email");
                System.out.println("4 - Voltar");
                opcao = leitor.lerOpcao();

                switch (opcao) {
                    case 1:
                        professor.setTelefone(leitor.lerTelefone());
                        return;
                    case 2:
                        professor.setEmail(leitor.lerEmail());
                        return;
                    case 3:
                        professor.setTelefone(leitor.lerTelefone());
                        professor.setEmail(leitor.lerEmail());
                        return;
                    case 4:
                        break;
                    default:
                        System.out.println("Opcao invalida. Tente novamente.");

                }
            }while(opcao != 4);
        } else {
            System.out.println("Nenhum professor cadastrado");
        }
    }

    public void removerProf() {
        if (professores.getHead() != null) {
            Professor professor = getProfessor();
            professores.remove(professor.getCpf());
        } else {
            System.out.println("Nenhum professor cadastrado");
        }
    }

    public Professor getProfessor() {
        if(professores.getHead() != null) {
            String cpf = leitor.lerCpf();
            while (!professores.containsKey(cpf)) {
                System.out.print("Cpf nao encontrado, tente de novo.");
                cpf = leitor.lerCpf();
            }
            return professores.get(cpf);
        } else {
            System.out.println("Nao ha professores cadastrados.");
            return null;
        }
    }

    public LinkedListEspecial<String, Professor> getProfessores() {
        return professores;
    }

    public void exibirPendencias(Scanner in, LinkedList<Atividade> pendencias, LinkedList<Atividade> notificacoes) {
        if(!pendencias.isEmpty()) {
            int i, opcaoAtividade, opcaoAcao;
            System.out.println("================");
            System.out.println("Pendências");
            System.out.println("================");
            System.out.println();
            do {
                i = 0;
                System.out.println("Escolha da pendência que deseja quitar:");
                System.out.println("=============================================================================================================================");
                for (Atividade atividade : pendencias) {
                    System.out.println("Atividade " + (i + 1));
                    System.out.println("    Nome da atividade:" + atividade.getDescricao());
                    System.out.println("    Professor: " + atividade.getProfessor().getNome());
                    System.out.println("    Link com documentos:" + atividade.getLinkDoc());
                    System.out.println("    Pontos da atividade: " + atividade.getPontos());
                    System.out.println("=============================================================================================================================");
                    i++;
                }
                opcaoAtividade = leitor.lerOpcao();
                if ((opcaoAtividade - 1)< 0 || (opcaoAtividade - 1) > pendencias.size()) {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            } while ((opcaoAtividade - 1)< 0 || (opcaoAtividade - 1) > pendencias.size());

            do {
                System.out.println("A atividade escolha foi a de numero " + (opcaoAtividade) + ":");
                System.out.println("    Nome da atividade: " + pendencias.get(opcaoAtividade - 1).getDescricao());
                System.out.println("    Professor: " + pendencias.get(opcaoAtividade - 1).getProfessor());
                System.out.println("    Link com documento: " + pendencias.get(opcaoAtividade - 1).getLinkDoc());
                System.out.println("    Pontos da atividade: " + pendencias.get(opcaoAtividade - 1).getPontos());
                System.out.println("Escolha a ação que deseja tomar:");
                System.out.println("1-Aceitar\n2-Recusar\n3-Voltar");
                opcaoAcao = leitor.lerOpcao();
                switch (opcaoAcao) {
                    case 1:
                        pendencias.get(opcaoAtividade - 1).getProfessor().incrementarPontuacao(pendencias.get(opcaoAtividade - 1).getPontos());
                        pendencias.get(opcaoAtividade - 1).setStatus(true);
                        notificacoes.add(pendencias.remove(opcaoAtividade - 1));

                        return;
                    case 2:
                        pendencias.get(opcaoAtividade - 1).setStatus(false);
                        notificacoes.add(pendencias.remove(opcaoAtividade - 1));
                        return;
                    case 3:
                        return;
                    default:
                        System.out.println("Opcao invalida. Tente novamente.");

                }
            } while (opcaoAtividade != 3);
        } else{
            System.out.println("Não há nada pendente.");
        }
    }

//    public void exibirRankingGeral() {
//        if(professores.getHead() != null){
//        ListaRankeada rankedList;
//        rankedList = ordenarPorPontos();
//            Professor professor = rankedList.getFirst();
//
//            for (int i = 0; i < (rankedList.getQtd() - 1); i++) {
//                System.out.println("=============================================================================================================================");
//                System.out.print((i + 1) + "º Lugar: " + professor.getValue().getNome());
//                System.out.println("\t\t\tPontuação: " + professor.getValue().getPontuacao());
//                System.out.println("Departamento: " + professor.getValue().getDepartamento());
//                System.out.println("=============================================================================================================================");
//                professor = professor.getNext();
//            }
//        } else {
//            System.out.println("Nenhum professor cadastrado.");
//        }
//    }
////
////    public ListaRankeada ordenarPorPontos(){
////        ListaRankeada <Professor> rankedList = new ListaRankeada();
////        Node <String, Professor> aux = this.professores.getHead();
////
////        while(aux != null){
////            Professor copia = new Professor(aux.getValue().getCpf(), aux.getValue().getSenha(), aux.getValue().getNome(), aux.getValue().getEmail(),
////                    aux.getValue().getTelefone(), aux.getValue().getDepartamento(), aux.getValue().getEspecialidade());
////            rankedList.put(copia);
////            aux = aux.getNext();
////        }
////        return rankedList;
//    }
}
