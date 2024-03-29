import java.util.InputMismatchException;
import java.util.regex.Pattern;

public class Validacao {

    public static boolean nomeValido(String nome) {
        return Pattern.matches("\\s*([a-zA-Z]+\\s*)+", nome);
    }

    public static boolean emailValido(String email) {
        return Pattern.matches("[^@]*@[^@]*", email);
    }

    public static boolean senhaValida(String senha) {
        return Pattern.matches("\\d{6}\\d*", senha);
    }

    public static boolean departamentoValido(String departamento){
        if(departamento.equalsIgnoreCase(Departamentos.A.toString())  || departamento.equalsIgnoreCase(Departamentos.B.toString()) || departamento.equalsIgnoreCase(Departamentos.C.toString())){
            return true;
        }
        return false;
    }

    public static boolean telefoneValido(String telefone) {
        return Pattern.matches("\\d{10}\\d*", telefone);
    }

    public static boolean cpfValido(String cpf) {
        if (cpf.equals("00000000000") ||
                cpf.equals("11111111111") ||
                cpf.equals("22222222222") || cpf.equals("33333333333") ||
                cpf.equals("44444444444") || cpf.equals("55555555555") ||
                cpf.equals("66666666666") || cpf.equals("77777777777") ||
                cpf.equals("88888888888") || cpf.equals("99999999999") ||
                (cpf.length() != 11))
            return false;

        char dig10, dig11;
        int sm, i, r, num, weight;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            weight = 10;
            for (i = 0; i < 9; i++) {
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posicao de '0' na tabela ASCII)
                num = cpf.charAt(i) - 48;
                sm = sm + (num * weight);
                weight = weight - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char) (r + 48); // converte no respectivo caractere numerico

            // Calculo do 2o. Digito Verificador
            sm = 0;
            weight = 11;
            for (i = 0; i < 10; i++) {
                num = cpf.charAt(i) - 48;
                sm = sm + (num * weight);
                weight = weight - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else dig11 = (char) (r + 48);

            // Verifica se os digitos calculados conferem com os digitos informados.
            return (dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10));
        } catch (InputMismatchException erro) {
            return false;
        }
    }

    public static boolean linkValido(String link) {
        return Pattern.matches("^(http:\\/\\/www\\.|https:\\/\\/www\\.|http:\\/\\/|https:\\/\\/)?[a-z0-9]+([\\-\\.]{1}[a-z0-9]+)*\\.[a-z]{2,5}(:[0-9]{1,5})?(\\/.*)?$", link);
    }
}
