import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
       
        Questao01();
        Questao02();

    }

    private static String[] numeros = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
    private static String[] caracteresEspeciais = { "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "-", "+" };

    /**
     * Questão 01:
     * Escreva um algoritmo que mostre na tela uma escada de tamanho n utilizando o caractere * e espaços. 
     * A base e altura da escada devem ser iguais ao valor de n. A última linha não deve conter nenhum espaço.
     */    
        public static void Questao01() {
        System.out.println("####### App para construção de uma escada #######");
        //Solicitando dados de entrada do usuário.
        System.out.println("Favor informar o número de degraus da escada: ");

        //Declaração de propriedades do método
        Scanner quantidadeDegraus = new Scanner(System.in);
        String degraus = "";
        //Recebendo os dados digitado pelo usuário do tipo inteiro.
        int n = quantidadeDegraus.nextInt();
        String recuo = "";

        //Laço de repetição para criação dos degraus colocando espaço onde não há degraus.
        for (int i = 0; i < n; i++) {
            recuo = "";
            for (int z = i; z < n - 1; z++) {
                recuo += " ";
            }
            degraus += "*";
            //imprimindo a escada gerada.
            System.out.println(recuo + degraus); 

        }
    }

    /**
    * Questão 02: 
    * Débora se inscreveu em uma rede social para se manter em contato com seus amigos. 
    * A página de cadastro exigia o preenchimento dos campos de nome e senha, porém a senha precisa ser forte.
    * O site considera uma senha forte quando ela satisfaz os seguintes critérios:
    * •	Possui no mínimo 6 caracteres.
    * •	Contém no mínimo 1 digito.
    * •	Contém no mínimo 1 letra em minúsculo.
    * •	Contém no mínimo 1 letra em maiúsculo.
    * •	Contém no mínimo 1 caractere especial. Os caracteres especiais são: !@#$%^&*()-+
    * Débora digitou uma string aleatória no campo de senha, porém ela não tem certeza se é uma senha forte. 
    * Para ajudar Débora, construa um algoritmo que informe qual é o número mínimo de caracteres que devem ser 
    * adicionados para uma string qualquer ser considerada segura.
    */
    public static void Questao02() {
        //Declaração de propriedades do método
        String nome = "";
        String senha = "";
        boolean controle = false;
        //Solicitando dados de entrada do usuário.
        System.out.println("Por favor digite o seu nome: ");
        Scanner scanner = new Scanner(System.in);

        nome = scanner.nextLine();
        
        //Validação do tamanho do nome de usuário.
        while (nome.isEmpty() || nome.length() < 3) {
            System.out.println("O seu nome precisa ter mais de 2 caracteres: ");
            //Recebendo os dados digitado pelo usuário do tipo String.
            nome = scanner.nextLine();
        }
            
        //Solicitando dados de entrada do usuário.
        System.out.println("Por favor digite sua senha: ");
        
        //Laço de repetição solicitando a senha do usuário até que ela seja válida.
        do {
            //Recebendo os dados digitado pelo usuário do tipo String.
            senha = scanner.nextLine();
            controle = ValidarSenha(senha);
        } while (!controle);

        System.out.println("O seu nome é: " + nome);
        System.out.println("Sua senha é: " + senha);

    }
    
    //Método de validação da senha de usuário.
    public static boolean ValidarSenha(String senha) {

        //Declaração de propriedades do método 
        boolean resultado = true;
        boolean erroMaiuscula = true;
        boolean erroMinuscula = true;
        boolean erroTamanhoInvalido = true;
        boolean semNumero = false;
        boolean erroCaracterEspecial = false;

        //Verificando se a senha possui no mínimo 6 caracteres.
        if (senha.length() > 5) {
            erroTamanhoInvalido = false;
        }

        //Verificando se a senha contém no mínimo 1 digito.
        if (!semNumero) {

            semNumero = isNumero(senha);
        }
        
        //Verificando se a senha contém no mínimo 1 caractere especial (Os caracteres especiais são: !@#$%^&*()-+)
        if (!erroCaracterEspecial) {

            erroCaracterEspecial = isCaracterEspecial(senha);
        }
        
        //Laço de verificação de caracter maiúscula e minúscula.
        for (int i = 0; i < senha.length(); i++) {

            if (!isNumero(String.valueOf(senha.charAt(i))) && !isCaracterEspecial(String.valueOf(senha.charAt(i)))) {

                ////Verificando se a senha contém no mínimo 1 letra em maiúsculo.
                if (erroMaiuscula) {
                    if (String.valueOf(senha.charAt(i)).equals(String.valueOf(senha.charAt(i)).toUpperCase())) {
                        erroMaiuscula = false;
                    }
                }
                
                //Verificando se a senha contém no mínimo 1 letra em minúsculo.
                if (erroMinuscula) {
                    if (String.valueOf(senha.charAt(i)).equals(String.valueOf(senha.charAt(i)).toLowerCase())) {
                        erroMinuscula = false;
                    }
                }

            }

        }

        //Bloco de mensagens das verificações das condições solicitadas.
        if (erroTamanhoInvalido) {

            System.out.println("Senha inválida, sua senha precisa ter mais de 5 caracteres.");
        }

        if (erroMaiuscula) {
            System.out.println("Senha inválida. Sua senha precisa ter ao menos uma letra maiúscula.");
        }

        if (erroMinuscula) {
            System.out.println("Senha inválida. Sua senha precisa ter ao menos uma letra minúscula.");
        }

        if (!semNumero) {
            System.out.println("Senha inválida. Sua senha precisa ter ao menos um número.");
        }

        if (!erroCaracterEspecial) {
            System.out.println("Senha inválida. Sua senha precisa ter ao menos um caracter especial: !@#$%^&*()-+.");
        }

        if (erroTamanhoInvalido || erroMaiuscula || erroMinuscula || !semNumero || !erroCaracterEspecial) {
            resultado = false;
            System.out.println("Por favor digite uma senha válida: ");
        }

        return resultado;
    }
    
    //Verifica se o caracter informado é um número.
    public static boolean isNumero(String caracter) {
        boolean resultado = false;
        for (String numero : numeros) {
            if (caracter.indexOf(numero) > -1) {
                resultado = true;
                break;
            }
        }
        return resultado;
    }

    ////Verifica se o caracter informado é um caracter especial.
    public static boolean isCaracterEspecial(String caracter) {
        boolean resultado = false;
        for (String caractereEspecial : caracteresEspeciais) {
            if (caracter.indexOf(caractereEspecial) > -1) {
                resultado = true;
                break;
            }
        }

        return resultado;
    }

}
