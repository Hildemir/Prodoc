public class Atividade {
    private IndiceAtividades atividade;
    private String linkDoc;
    private int pontos;
    private boolean status;
    private String descricao;
    private Professor professor;
    private boolean lido;

    public Atividade(IndiceAtividades atividade, String linkDoc, Professor professor) {
        this.atividade = atividade;
        this.linkDoc = linkDoc;
        this.pontos = atividade.getValor();
        this.descricao = buscarDescricao(atividade);
        this. professor = professor;
        this.lido = false;
    }

    public  String buscarDescricao(IndiceAtividades atividade){
        String descricao = "";
        if(atividade.name().contentEquals("ATV_ACAD_NA_UNICAP_19_HORAS_SEMANAIS")){
            descricao = "Atividade Acadêmica em nível superior na UNICAP, com até 19 horas semanais por ano.";
        } else if(atividade.name().contentEquals("ATV_ACAD_NA_UNICAP_20_39_HORAS_SEMANAIS")){
            descricao = "Atividade Acadêmica em nível superior na UNICAP, de 20 a 39 horas semanais por ano.";
        } else if(atividade.name().contentEquals("ATV_ACAD_NA_UNICAP_40_HORAS_SEMANAIS")){
            descricao = "Atividade Acadêmica em nível superior na UNICAP, com 40 horas semanais por ano.";
        } else if(atividade.name().contentEquals("ATV_ACAD_FORA_DA_UNICAP_MAIS_DE_20_HORAS_SEMANAIS")){
            descricao = "Atividade Acadêmica em nível superior fora da UNICAP, com mais de 20 horas semanais por ano.";
        } else if(atividade.name().contentEquals("LIVROS_PUBLICADOS")){
            descricao = "Livros publicados.";
        } else if(atividade.name().contentEquals("CAPITULO_DE_LIVRO")){
            descricao = "Capítulo de livro.";
        } else if(atividade.name().contentEquals("PUBLICACAO_REVISTA_INTERNACIONAL")){
            descricao = "Publicação em revistas indexadas de circulação internacional.";
        } else if(atividade.name().contentEquals("PUBLICACAO_REVISTA_NACIONAL")){
            descricao = "Publicação em revistas indexadas de circulação nacional.";
        } else if(atividade.name().contentEquals("TRABALHO_PUBLICADO_EM_ANAIS_NACIONAL_E_INTERNACIONAL")){
            descricao = "Trabalho completo publicado em anais de evenetos nacionais e internacionais.";
        } else if(atividade.name().contentEquals("ORIENTACAO_DOUTORADO")){
            descricao = "Orientação de Doutorado em programa reconhecido pelo MEC.";
        } else if(atividade.name().contentEquals("CO_ORIENTACAO__DOUTORADO")){
            descricao = "Co-orientação de Doutorado em programa reconhecido pelo MEC.";
        } else if(atividade.name().contentEquals("ORIENTACAO_MESTRADO")){
            descricao = "Orientação de Mestrado em programa reconhecido pelo MEC.";
        } else if(atividade.name().contentEquals("CO_ORIENTACAO__MESTRADO")){
            descricao = "Co-orientação de Mestrado em programa reconhecido pelo MEC.";
        } else if(atividade.name().contentEquals("LIDERANCA_GRUPO_PESQUISA")){
            descricao = "Liderança em grupos de pesquisa credenciados pelo CNPq.";
        } else if(atividade.name().contentEquals("PARTICIPACAO_EVENTO_TECNICO_EXTERIOR")){
            descricao = "Participação em eventos técnico-científicos no exterior com apresentação de trabalho.";
        } else if(atividade.name().contentEquals("PARTICIPACAO_EVENTO_TECNICO_NO_PAIS")){
            descricao = "Participação em eventos técnico-científicos no país com apresentação de trabalho.";
        } else if(atividade.name().contentEquals("TRADUCAO_LIVRO")){
            descricao = "Tradução de livro.";
        } else if(atividade.name().contentEquals("TRADUCAO_ARTIGO_CAPITULO_TRABALHO")){
            descricao = "Tradução de artigo, capítulo de livro ou de trabalho técnico-científico.";
        } else if(atividade.name().contentEquals("PRODUCAO_FILME")){
            descricao = "Produção de filme e vídeo de longa e curta duração.";
        } else if(atividade.name().contentEquals("ELABORACAO_SOFTWARE")){
            descricao = "Produção de filme e vídeo de longa e curta duração.";
        } else if(atividade.name().contentEquals("ORGANIZACAO_COMPENDIOS")){
            descricao = "Organização de compêndios.";
        } else if(atividade.name().contentEquals("ORIENTACAO_INICIACAO_CIENTIFICA")){
            descricao = "Orientação de bolsista de Iniciação Científica.";
        } else if(atividade.name().contentEquals("PARTICIPACAO_COLEGIADO_COMISSAO")){
            descricao = "Participação em Órgãos colegiados, na condição de titular, ou em condições nomeadas pelo Diretor-Presidente ou Reitor.";
        } else if(atividade.name().contentEquals("BANCA_EXAMINADORA_DOUTORADO")){
            descricao = "Participação em banca examinadora de doutorado.";
        } else if(atividade.name().contentEquals("BANCA_EXAMINADORA_MESTRADO")){
            descricao = "Participação em banca examinadora de mestrado.";
        } else if(atividade.name().contentEquals("BANCA_EXAMINADORA_CONCURSO_PUBLICO")){
            descricao = "Participação em banca examinadora de concurso públic em IES.";
        } else if(atividade.name().contentEquals("BANCA_EXAMINADORA_SELECAO")){
            descricao = "Participação em banca examinadora de seleção.";
        } else if(atividade.name().contentEquals("COORDENACAO_PROJETO")){
            descricao = "Coordenação de projetos de pesquisa aprovados por órgãos de fomento à pesquisa.";
        } else if(atividade.name().contentEquals("POS_DOUTORADO")){
            descricao = "Pós-doutorado ou equivalente.";
        } else if(atividade.name().contentEquals("PREMIOS")){
            descricao = "Prêmios conferidos por trabalhos técnicos ou científicos.";
        }
        return descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public IndiceAtividades getAtividade() {
        return atividade;
    }

    public void setAtividade(IndiceAtividades atividade) {
        this.atividade = atividade;
    }

    public String getLinkDoc() {
        return linkDoc;
    }

    public void setLinkDoc(String linkDoc) {
        this.linkDoc = linkDoc;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public boolean getLido() {
        return lido;
    }

    public void setLido(boolean lido) {
        this.lido = lido;
    }
}
