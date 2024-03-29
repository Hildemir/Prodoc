public enum IndiceAtividades {
    ATV_ACAD_NA_UNICAP_19_HORAS_SEMANAIS(1),
    ATV_ACAD_NA_UNICAP_20_39_HORAS_SEMANAIS(2),
    ATV_ACAD_NA_UNICAP_40_HORAS_SEMANAIS(3),
    ATV_ACAD_FORA_DA_UNICAP_MAIS_DE_20_HORAS_SEMANAIS(1),
    LIVROS_PUBLICADOS(16),
    CAPITULO_DE_LIVRO(4),
    PUBLICACAO_REVISTA_INTERNACIONAL(3),
    PUBLICACAO_REVISTA_NACIONAL(2),
    TRABALHO_PUBLICADO_EM_ANAIS_NACIONAL_E_INTERNACIONAL(1),
    ORIENTACAO_DOUTORADO(10),
    CO_ORIENTACAO__DOUTORADO(5),
    ORIENTACAO_MESTRADO(6),
    CO_ORIENTACAO__MESTRADO(3),
    LIDERANCA_GRUPO_PESQUISA(2),
    PARTICIPACAO_EVENTO_TECNICO_EXTERIOR(3),
    PARTICIPACAO_EVENTO_TECNICO_NO_PAIS(2),
    TRADUCAO_LIVRO(3),
    TRADUCAO_ARTIGO_CAPITULO_TRABALHO(1),
    PRODUCAO_FILME(5),
    ELABORACAO_SOFTWARE(5),
    ORGANIZACAO_COMPENDIOS(3),
    ORIENTACAO_INICIACAO_CIENTIFICA(1),
    PARTICIPACAO_COLEGIADO_COMISSAO(1),
    BANCA_EXAMINADORA_DOUTORADO(3),
    BANCA_EXAMINADORA_MESTRADO(2),
    BANCA_EXAMINADORA_CONCURSO_PUBLICO(2),
    BANCA_EXAMINADORA_SELECAO(1),
    COORDENACAO_PROJETO(1),
    POS_DOUTORADO(10),
    PREMIOS(5),
    ERRO(0),
    ;
    private  final int valor;

    IndiceAtividades(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
