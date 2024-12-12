import java.time.LocalDate;
import java.util.Scanner;

public class ClinicaVeterinaria{
    public static void main(String[] args) {
        Clinica clinica = new Clinica();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n------------- MENU -------------");
            System.out.println("1 - Cadastrar uma vacina");
            System.out.println("2 - Cadastrar um cachorro");
            System.out.println("3 - Aplicar uma vacina em um cachorro");
            System.out.println("4 - Listar vacinas disponíveis");
            System.out.println("5 - Listar cachorros cadastrados");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    
                    System.out.print("Digite o nome da vacina: ");
                    String nomeVacina = scanner.nextLine();
                    System.out.print("Digite o lote da vacina: ");
                    String loteVacina = scanner.nextLine();
                    System.out.print("Digite a data de vencimento (AAAA-MM-DD): ");
                    LocalDate dtVencimento = LocalDate.parse(scanner.nextLine());

                    Vacina vacina = new Vacina(nomeVacina, loteVacina, dtVencimento);
                    if (clinica.cadastrarVacina(vacina)) {
                        System.out.println("Vacina cadastrada com sucesso!");
                    } else {
                        System.out.println("Erro: Limite de vacinas alcançado!");
                    }
                    break;

                case 2:
                    
                    System.out.print("Digite o nome do cachorro: ");
                    String nomeCachorro = scanner.nextLine();
                    System.out.print("Digite a raça do cachorro: ");
                    String racaCachorro = scanner.nextLine();
                    System.out.print("Digite a cor do cachorro: ");
                    String corCachorro = scanner.nextLine();
                    System.out.print("Digite o sexo do cachorro (M/F): ");
                    char sexoCachorro = scanner.nextLine().toUpperCase().charAt(0);
                    System.out.print("Digite a data de nascimento (AAAA-MM-DD): ");
                    LocalDate dtNascimentoCachorro = LocalDate.parse(scanner.nextLine());
                    System.out.print("Digite o peso do cachorro (kg): ");
                    double pesoCachorro = scanner.nextDouble();
                    scanner.nextLine();
                    
                    System.out.print("Digite o nome do tutor: ");
                    String nomeTutor = scanner.nextLine();
                    System.out.print("Digite o CPF do tutor: ");
                    String cpfTutor = scanner.nextLine();
                    System.out.print("Digite o telefone do tutor: ");
                    String telefoneTutor = scanner.nextLine();

                    Pessoa tutor = new Pessoa(nomeTutor, cpfTutor, telefoneTutor);
                    Cachorro cachorro = new Cachorro(nomeCachorro, racaCachorro, corCachorro, sexoCachorro, dtNascimentoCachorro, pesoCachorro, tutor);

                    if (clinica.cadastrarCachorro(cachorro)) {
                        System.out.println("Cachorro cadastrado com sucesso!");
                    } else {
                        System.out.println("Erro: Limite de cachorros alcançado!");
                    }
                    break;

                case 3:
                    
                    System.out.print("Digite o nome do cachorro: ");
                    String nomeCachorroAplicacao = scanner.nextLine();
                    System.out.print("Digite o nome do tutor do cachorro: ");
                    String nomeTutorAplicacao = scanner.nextLine();

                    Cachorro cachorroAplicacao = clinica.pesquisarCachorro(nomeCachorroAplicacao, nomeTutorAplicacao);
                    if (cachorroAplicacao == null) {
                        System.out.println("Erro: Cachorro não encontrado!");
                        break;
                    }

                    System.out.print("Digite o nome da vacina a ser aplicada: ");
                    String nomeVacinaAplicacao = scanner.nextLine();
                    Vacina vacinaAplicacao = clinica.pesquisarVacina(nomeVacinaAplicacao);

                    if (vacinaAplicacao == null) {
                        System.out.println("Erro: Vacina não encontrada ou já aplicada!");
                    }else if (vacinaAplicacao.isVencida()) {
                            System.out.println("Erro: A vacina está vencida e não pode ser aplicada.");
                    } else if (cachorroAplicacao.cadastrarVacina(vacinaAplicacao)) {
                        System.out.println("Vacina aplicada com sucesso!");
                    }else {
                        System.out.println("Erro: Limite de vacinas no cachorro alcançado!");
                    }                  
                    
                    break;

                case 4:
                    
                    System.out.println("\nVacinas disponíveis:");
                    clinica.getVacinasDisponiveis().forEach(v -> System.out.println(v));
                    break;

                case 5:
                
                    System.out.println("\nCachorros cadastrados:");
                    clinica.getCachorrosCadastrados().forEach(c -> System.out.println(c));
                    break;

                case 6:
                
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 6);

        scanner.close();
    }
}



