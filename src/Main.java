import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;


public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Usuario> usuarios = new ArrayList<>();
       
// carregar usuarios do arquivo
try (BufferedReader reader = new BufferedReader(new FileReader("dados/usuarios.txt"))) {
    String linha;

    while ((linha = reader.readLine()) != null) {
        String[] partes = linha.split(";");

        if (partes.length == 3) {
            String nome = partes[0];
            String email = partes[1];
            String senha = partes[2];

            Usuario u = new Usuario(nome, email, senha);
            usuarios.add(u);
        }
    }
} catch (Exception e) {
    System.out.println("Arquivo de usuários ainda não existe ou está vazio.");
}
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
                    System.out.print ("Email:");
                    String emailLogin = scanner.nextLine();

                    System.out.print("Senha:");
                    String senhalogin = scanner.nextLine();

                    boolean encontrado = false;

                    for (Usuario u:  usuarios){
                        if (u.getEmail().equals(emailLogin) &&
                            u.getSenha().equals(senhalogin)){

                                System.out.print("Login finalizado com sucesso,");
                                System.out.print("Bem vindo,"+ u.getNome());
                                encontrado = true;
                                break;
                            }
                    }
                    if (!encontrado){
                        System.out.println("Email ou senha invalidos");
                    }
                

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