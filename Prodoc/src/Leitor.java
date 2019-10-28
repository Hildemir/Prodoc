import java.util.LinkedList;
import java.util.Scanner;

public class Leitor {



    public String lerCpfLoginAdmin(ModuloAdmin moduloAdmin) {
        String valor;
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("Digite o seu cpf: ");
            System.out.println("ou pressione enter para voltar ao Menu Principal.");
            valor = in.nextLine();
            if(valor.isEmpty()){                //se em algum SEGUNDA VEZ DER PROBLEMA EH PQ TEM Q LIMPAR A VARIAVEL VALOR
                return null;
            }
            if (Validacao.cpfValido(valor)) {
                return valor;
            } else{
                System.out.println("Cpf invalido. Digite novamente: ");
            }
        }

    }

    public String lerCpfLoginProf(ModuloAdmin moduloAdmin) {
        String valor;
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("Digite o seu cpf: ");
            System.out.println("ou pressione enter para voltar ao Menu Principal.");
            valor = in.nextLine();
            if(valor.isEmpty()){                //se em algum SEGUNDA VEZ DER PROBLEMA EH PQ TEM Q LIMPAR A VARIAVEL VALOR
                return null;
            }
            if (Validacao.cpfValido(valor)) {
                if(moduloAdmin.getProfessores().get(valor) != null){
                    return valor;
                } else{
                    System.out.println("Há nenhum cadastrado com esse cpf.");
                    return null;
                }
            } else{
                System.out.println("Cpf invalido. Digite novamente: ");
            }
        }

    }


    public String lerCpf() {
        String valor;
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o cpf: ");
        while (true) {
            valor = in.nextLine();
            if (Validacao.cpfValido(valor)) {
                return valor;
            }
            System.out.println("Cpf invalido. Digite novamente: ");
        }
    }



    public String lerSenhaLoginAdmin(ModuloAdmin moduloAdmin , String cpf) {
        String valor;
        Scanner in = new Scanner(System.in);
        System.out.println("Digite a sua senha: ");
        while (true) {
            valor = in.nextLine();
            if (Validacao.senhaValida(valor)) {
                return valor;
//                if(moduloAdmin.getProfessores().get(cpf).getSenha().contentEquals(valor)){
//                    return valor;
//                } else{
//                    System.out.println("Senha incorreta.");
//                    return null;
//                }
            } else {
                System.out.println("Senha invalida. Tente novamente. ");
                return null;
            }
        }
    }

    public String lerSenhaLoginProf(ModuloAdmin moduloAdmin , String cpf) {
        String valor;
        Scanner in = new Scanner(System.in);
        System.out.println("Digite a sua senha: ");
        while (true) {
            valor = in.nextLine();
            if (Validacao.senhaValida(valor)) {
                if(moduloAdmin.getProfessores().get(cpf).getSenha().contentEquals(valor)){
                    return valor;
                } else{
                    System.out.println("Senha incorreta.");
                    return null;
                }
            } else {
                System.out.println("Senha invalida. Tente novamente. ");
                return null;
            }
        }
    }

    public String lerSenhacadastro() {
        String valor;
        Scanner in = new Scanner(System.in);
        System.out.println("Digite a sua senha: ");
        while (true) {
            valor = in.nextLine();
            if (Validacao.senhaValida(valor)) {
                return valor;
            } else {
                System.out.println("Senha invalida. Tente novamente. ");
            }
        }
    }

    public boolean lerLoginAdmin(ModuloAdmin moduloAdmin){
        String cpf = lerCpfLoginAdmin(moduloAdmin);
        if(cpf == null){
            return false;
        } else {String senha = lerSenhaLoginAdmin(moduloAdmin, cpf);
            if(senha != null){
                return true;
            } else {
                return false;
            }

        }

    }

    public boolean lerLoginProf( ModuloAdmin moduloAdmin){
        String cpf = lerCpfLoginProf(moduloAdmin);

        if(cpf == null){
            return false;
        } else {
            String senha = lerSenhaLoginProf(moduloAdmin, cpf);
            if(senha != null) {
                return true;
            } else {
                return false;
            }
        }

    }


    public String lerEmail() {
        String valor;
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o seu email: ");
        while (true) {
            valor = in.nextLine();
            if (Validacao.emailValido(valor)) {
                return valor;
            }
            System.out.println("Email invalido. Digite novamente: ");
        }
    }

    public String lerNome() {
        String valor;
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o seu nome: ");
        while (true) {
            valor = in.nextLine();
            if (Validacao.nomeValido(valor)) {
                return valor.replace("  ", " ").trim();
            }
            System.out.println("Nome invalido. Digite novamente: ");
        }
    }

    public String lerDepartamento(){
        String valor;
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o departamento: ");
        while (true) {
            valor = in.nextLine();
            if (Validacao.departamentoValido(valor)) {
                return valor;
            }
            System.out.println("Departamento invalido. Digite novamente: ");
        }
    }

    public String lerTelefone() {
        String valor;
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o telefone do professor: ");
        while (true) {
            valor = in.nextLine();
            if (Validacao.telefoneValido(valor)) {
                return valor;
            }
            System.out.println("Telefone invalido. Digite novamente: ");
        }
    }

    public LinkedList<String> lerEspecialidades(){
        LinkedList<String> especialidades = new LinkedList<>();
        Scanner in = new Scanner(System.in);
        int valor;

        System.out.println("Escolha a especialidade, caso tenha. ");
        System.out.println("ou pressione 8 para seguir com o cadastro.");
        System.out.println("1-Mestrado                       5-Mestrado e Livre Docente\n2-Doutorado                      6-Doutorado e Livre Docente\n3-Livre Docente                  7-Mestrado, Doutorado e Livre Docente\n4-Mestrado e Doutorado           8-Nenhuma acima");
            valor = in.nextInt();
            switch (valor){
                case 1:
                    especialidades.add(Especialidade.MESTRADO.toString().replace("MESTRADO","Mestrado"));
                    break;
                case 2:
                    especialidades.add(Especialidade.DOUTORADO.toString().replace("DOUTORADO","Doutorado"));
                    break;
                case 3:
                    especialidades.add(Especialidade.LIVRE_DOCENTE.toString().replace("LIVRE_DOCENTE","Livre Docente"));
                    break;
                case 4:
                    especialidades.add(Especialidade.MESTRADO.toString().replace("MESTRADO","Mestrado"));
                    especialidades.add(Especialidade.DOUTORADO.toString().replace("DOUTORADO","Doutorado"));
                    break;
                case 5:
                    especialidades.add(Especialidade.MESTRADO.toString().replace("MESTRADO","Mestrado"));
                    especialidades.add(Especialidade.LIVRE_DOCENTE.toString().replace("LIVRE_DOCENTE","Livre Docente"));
                    break;
                case 6:
                    especialidades.add(Especialidade.DOUTORADO.toString().replace("DOUTORADO","Doutorado"));
                    especialidades.add(Especialidade.LIVRE_DOCENTE.toString().replace("LIVRE_DOCENTE","Livre Docente"));
                    break;
                case 7:
                    especialidades.add(Especialidade.MESTRADO.toString().replace("MESTRADO","Mestrado"));
                    especialidades.add(Especialidade.DOUTORADO.toString().replace("DOUTORADO","Doutorado"));
                    especialidades.add(Especialidade.LIVRE_DOCENTE.toString().replace("LIVRE_DOCENTE","Livre Docente"));
                    break;
                case 8:
                    return especialidades;        //deveria retornar lista vazia ao inves de null
                default:
                    System.out.println("opcao invalida. Digite novamente: ");
            }
            return especialidades;
    }

    public int lerOpcao(){
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public String lerEnter(){
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public String lerLinkDoc() {
        String valor;
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o link dos documentos que comprovam a atividade: ");
        while (true) {
            valor = in.nextLine();
            if (Validacao.linkValido(valor)) {
                return valor;
            }
            System.out.println("Link invalido. Digite novamente: ");
        }
    }
}
