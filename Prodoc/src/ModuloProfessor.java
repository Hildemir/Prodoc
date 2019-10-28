import java.util.LinkedList;

public class ModuloProfessor {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";


    private Leitor leitor;

    public ModuloProfessor() {
        this.leitor = new Leitor();
    }

    public void exibirDados(ModuloProfessor moduloProfessor, ModuloAdmin moduloAdmin) {
        if (moduloAdmin.getProfessores().getHead() != null) {
            Professor professor = moduloAdmin.getProfessor();
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

    public void submeterAtividades(ModuloProfessor moduloProfessor, ModuloAdmin moduloAdmin, LinkedList<Atividade> pendencias) {
        int opcao;
        Atividade atividade = null;
        do{
            System.out.println("Escolha a atividade que deseja submeter:");
            exibirAtividades();
            opcao = leitor.lerOpcao();
            switch (opcao){
                case 1:
                    atividade = new Atividade(IndiceAtividades.ATV_ACAD_NA_UNICAP_19_HORAS_SEMANAIS,leitor.lerLinkDoc(),moduloAdmin.getProfessor());
                    break;
                case 2:
                    atividade = new Atividade(IndiceAtividades.ATV_ACAD_NA_UNICAP_20_39_HORAS_SEMANAIS,leitor.lerLinkDoc(),moduloAdmin.getProfessor());
                    break;
                case 3:
                    atividade = new Atividade(IndiceAtividades.ATV_ACAD_NA_UNICAP_40_HORAS_SEMANAIS,leitor.lerLinkDoc(),moduloAdmin.getProfessor());
                    break;
                case 4:
                    atividade = new Atividade(IndiceAtividades.ATV_ACAD_FORA_DA_UNICAP_MAIS_DE_20_HORAS_SEMANAIS,leitor.lerLinkDoc(),moduloAdmin.getProfessor());
                    break;
                case 5:
                    atividade = new Atividade(IndiceAtividades.LIVROS_PUBLICADOS,leitor.lerLinkDoc(),moduloAdmin.getProfessor());
                    break;
                case 6:
                    atividade = new Atividade(IndiceAtividades.CAPITULO_DE_LIVRO,leitor.lerLinkDoc(),moduloAdmin.getProfessor());
                    break;
                case 7:
                    atividade = new Atividade(IndiceAtividades.PUBLICACAO_REVISTA_INTERNACIONAL,leitor.lerLinkDoc(),moduloAdmin.getProfessor());
                    break;
                case 8:
                    atividade = new Atividade(IndiceAtividades.PUBLICACAO_REVISTA_NACIONAL,leitor.lerLinkDoc(),moduloAdmin.getProfessor());
                    break;
                case 9:
                    atividade = new Atividade(IndiceAtividades.TRABALHO_PUBLICADO_EM_ANAIS_NACIONAL_E_INTERNACIONAL,leitor.lerLinkDoc(),moduloAdmin.getProfessor());
                    break;
                case 10:
                    atividade = new Atividade(IndiceAtividades.ORIENTACAO_DOUTORADO,leitor.lerLinkDoc(),moduloAdmin.getProfessor());
                    break;
                case 11:
                    atividade = new Atividade(IndiceAtividades.CO_ORIENTACAO__DOUTORADO,leitor.lerLinkDoc(),moduloAdmin.getProfessor());
                    break;
                case 12:
                    atividade = new Atividade(IndiceAtividades.ORIENTACAO_MESTRADO,leitor.lerLinkDoc(),moduloAdmin.getProfessor());
                    break;
                case 13:
                    atividade = new Atividade(IndiceAtividades.CO_ORIENTACAO__MESTRADO,leitor.lerLinkDoc(),moduloAdmin.getProfessor());
                    break;
                case 14:
                    atividade = new Atividade(IndiceAtividades.LIDERANCA_GRUPO_PESQUISA,leitor.lerLinkDoc(),moduloAdmin.getProfessor());
                    break;
                case 15:
                    atividade = new Atividade(IndiceAtividades.PARTICIPACAO_EVENTO_TECNICO_EXTERIOR,leitor.lerLinkDoc(),moduloAdmin.getProfessor());
                    break;
                case 16:
                    atividade = new Atividade(IndiceAtividades.PARTICIPACAO_EVENTO_TECNICO_NO_PAIS,leitor.lerLinkDoc(),moduloAdmin.getProfessor());
                    break;
                case 17:
                    atividade = new Atividade(IndiceAtividades.TRADUCAO_LIVRO,leitor.lerLinkDoc(),moduloAdmin.getProfessor());
                    break;
                case 18:
                    atividade = new Atividade(IndiceAtividades.TRADUCAO_ARTIGO_CAPITULO_TRABALHO,leitor.lerLinkDoc(),moduloAdmin.getProfessor());
                    break;
                case 19:
                    atividade = new Atividade(IndiceAtividades.PRODUCAO_FILME,leitor.lerLinkDoc(),moduloAdmin.getProfessor());
                    break;
                case 20:
                    atividade = new Atividade(IndiceAtividades.ELABORACAO_SOFTWARE,leitor.lerLinkDoc(),moduloAdmin.getProfessor());
                    break;
                case 21:
                    atividade = new Atividade(IndiceAtividades.ORGANIZACAO_COMPENDIOS,leitor.lerLinkDoc(),moduloAdmin.getProfessor());
                    break;
                case 22:
                    atividade = new Atividade(IndiceAtividades.ORIENTACAO_INICIACAO_CIENTIFICA,leitor.lerLinkDoc(),moduloAdmin.getProfessor());
                    break;
                case 23:
                    atividade = new Atividade(IndiceAtividades.PARTICIPACAO_COLEGIADO_COMISSAO,leitor.lerLinkDoc(),moduloAdmin.getProfessor());
                    break;
                case 24:
                    atividade = new Atividade(IndiceAtividades.BANCA_EXAMINADORA_DOUTORADO,leitor.lerLinkDoc(),moduloAdmin.getProfessor());
                    break;
                case 25:
                    atividade = new Atividade(IndiceAtividades.BANCA_EXAMINADORA_MESTRADO,leitor.lerLinkDoc(),moduloAdmin.getProfessor());
                    break;
                case 26:
                    atividade = new Atividade(IndiceAtividades.BANCA_EXAMINADORA_CONCURSO_PUBLICO,leitor.lerLinkDoc(),moduloAdmin.getProfessor());
                    break;
                case 27:
                    atividade = new Atividade(IndiceAtividades.BANCA_EXAMINADORA_SELECAO,leitor.lerLinkDoc(),moduloAdmin.getProfessor());
                    break;
                case 28:
                    atividade = new Atividade(IndiceAtividades.COORDENACAO_PROJETO,leitor.lerLinkDoc(),moduloAdmin.getProfessor());
                    break;
                case 29:
                    atividade = new Atividade(IndiceAtividades.POS_DOUTORADO,leitor.lerLinkDoc(),moduloAdmin.getProfessor());
                    break;
                case 30:
                    atividade = new Atividade(IndiceAtividades.PREMIOS,leitor.lerLinkDoc(),moduloAdmin.getProfessor());
                    break;
                default:
                    System.out.println("Opcao inválida. Tente novamente.");
                    break;
            }
        } while (atividade == null);
        pendencias.add(atividade);
    }

    public void exibirNotificacoes(LinkedList<Atividade> notificacoes) {
        if(!notificacoes.isEmpty()) {
            int i;
            String opcao;
            System.out.println("================");
            System.out.println("Notificações");
            System.out.println("================");
            System.out.println();
            do {
                i = 0;
                System.out.println("=============================================================================================================================");
                for (Atividade atividade : notificacoes) {
                    System.out.println("Atividade " + (i + 1));
                    System.out.println("    Nome da atividade:" + atividade.getDescricao());
                    System.out.println("    Link com documentos:" + atividade.getLinkDoc());
                    System.out.println("    Pontos da atividade: " + atividade.getPontos());
                    if(atividade.getStatus() == true){
                        System.out.println("    Status: " + ANSI_GREEN + " Aceita" + ANSI_RESET );
                        System.out.println(ANSI_GREEN + "    Nova pontuação atual: " + atividade.getProfessor().getPontuacao() + ANSI_RESET);
                    } else {
                        System.out.println("    Status: " + ANSI_RED + " Recusada" + ANSI_RESET );
                    }
                    System.out.println("=============================================================================================================================");
                    i++;
                    atividade.setLido(true);                //notificacoes lidas  sao marcadas como true para limpar as notificacoes visuzalizadas
                }
                System.out.println("Digite enter para voltar");
                opcao = leitor.lerEnter();
                if (opcao.isEmpty()) {
                    return;
                } else {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            } while (!opcao.isEmpty());
        } else{
            System.out.println("Nenhuma notificação.");
        }
    }

    public void alterarDados(ModuloAdmin moduloAdmin) {
        int opcao;
        if (moduloAdmin.getProfessores().getHead() != null) {
            Professor professor = moduloAdmin.getProfessor();
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

    public static void exibirAtividades(){

        System.out.println(" 1-Atividade Acadêmica em nível superior na UNICAP, com até 19 horas semanais por ano.");
        System.out.println(" 2-Atividade Acadêmica em nível superior na UNICAP, de 20 a 39 horas semanais por ano.");
        System.out.println(" 3-Atividade Acadêmica em nível superior na UNICAP, com 40 horas semanais por ano.");
        System.out.println(" 4-Atividade Acadêmica em nível superior fora da UNICAP, com mais de 20 horas semanais por ano.");
        System.out.println(" 5-Livros publicados.");
        System.out.println(" 6-Capítulo de livro.");
        System.out.println(" 7-Publicação em revistas indexadas de circulação internacional.");
        System.out.println(" 8-Publicação em revistas indexadas de circulação nacional.");
        System.out.println(" 9-Trabalho completo publicado em anais de evenetos nacionais e internacionais.");
        System.out.println("10-Orientação de Doutorado em programa reconhecido pelo MEC.");
        System.out.println("11-Co-orientação de Doutorado em programa reconhecido pelo MEC.");
        System.out.println("12-Orientação de Mestrado em programa reconhecido pelo MEC.");
        System.out.println("13-Co-orientação de Mestrado em programa reconhecido pelo MEC.");
        System.out.println("14-Liderança em grupos de pesquisa credenciados pelo CNPq.");
        System.out.println("15-Participação em eventos técnico-científicos no exterior com apresentação de trabalho.");
        System.out.println("16-Participação em eventos técnico-científicos no país com apresentação de trabalho.");
        System.out.println("17-Tradução de livro.");
        System.out.println("18-Tradução de artigo, capítulo de livro ou de trabalho técnico-científico.");
        System.out.println("19-Produção de filme e vídeo de longa e curta duração.");
        System.out.println("20-Produção de filme e vídeo de longa e curta duração.");
        System.out.println("21-Organização de compêndios.");
        System.out.println("22-Orientação de bolsista de Iniciação Científica.");
        System.out.println("23-Participação em Órgãos colegiados, na condição de titular, ou em condições nomeadas pelo Diretor-Presidente ou Reitor.");
        System.out.println("24-Participação em banca examinadora de doutorado.");
        System.out.println("25-Participação em banca examinadora de mestrado.");
        System.out.println("26-Participação em banca examinadora de concurso públic em IES.");
        System.out.println("27-Participação em banca examinadora de seleção.");
        System.out.println("28-Coordenação de projetos de pesquisa aprovados por órgãos de fomento à pesquisa.");
        System.out.println("29-Pós-doutorado ou equivalente.");
        System.out.println("30-Prêmios conferidos por trabalhos técnicos ou científicos.");
    }

}
