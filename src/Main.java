import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Usuario> usuarios = new ArrayList<>();
        int opcao;

        while (true) {
            System.out.println("\n==== SISTEMA LOGIN ====");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Fazer login");
            System.out.println("3 - Listar usuários");
            System.out.println("4 - Sair");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
         case 1:
    System.out.print("Nome: ");
    String nome = scanner.nextLine();

    System.out.print("Email: ");
    String email = scanner.nextLine();

    System.out.print("Senha: ");
    String senha = scanner.nextLine();

    Usuario novoUsuario = new Usuario(nome, email, senha);
    usuarios.add(novoUsuario);

    // salvar no arquivo
    try (FileWriter writer = new FileWriter("dados/usuarios.txt", true)) {
        writer.write(novoUsuario.toFileString() + System.lineSeparator());
        System.out.println("Usuário cadastrado e salvo com sucesso!");
    } catch (IOException e) {
        System.out.println("Erro ao salvar usuário no arquivo.");
    }
    break;

                case 2:
                    System.out.println("Login será implementado");
                    break;

                case 3:
                    if (usuarios.isEmpty()) {
                        System.out.println("Nenhum usuário cadastrado");
                    } else {
                        for (Usuario u : usuarios) {
                            System.out.println(u.getNome() + " | " + u.getEmail());
                        }
                    }
                    break;

                case 4:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}