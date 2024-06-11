import java.util.ArrayList;
import java.util.Scanner;

// Classe Contato
class Contato {
    private String nome;
    private String telefone;
    private String email;

    public Contato(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "\nNome: " + nome + ", Telefone: " + telefone + ", Email: " + email;
    }
}

// Classe Agenda
class Agenda {
    private ArrayList<Contato> contatos;

    public Agenda() {
        this.contatos = new ArrayList<>();
    }

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
        System.out.println("\nContato adicionado com sucesso!");
    }

    public void removerContato(String nome) {
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                contatos.remove(contato);
                System.out.println("\nContato removido com sucesso!");
                return;
            }
        }
        System.out.println("Contato não encontrado!");
    }

    public void listarContatos() {
        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato na agenda.");
        } else {
            for (Contato contato : contatos) {
                System.out.println(contato);
            }
        }
    }

    public Contato buscarContato(String nome) {
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                return contato;
            }
        }
        System.out.println("Contato não encontrado!");
        return null;
    }
}

// Classe Principal
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();
        int opcao;

        do {
            System.out.println("\nAgenda de Contatos");
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Remover Contato");
            System.out.println("3. Listar Contatos");
            System.out.println("4. Buscar Contato");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("\nNome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    Contato contato = new Contato(nome, telefone, email);
                    agenda.adicionarContato(contato);
                    break;
                case 2:
                    System.out.print("Nome do contato a remover: ");
                    nome = scanner.nextLine();
                    agenda.removerContato(nome);
                    break;
                case 3:
                    agenda.listarContatos();
                    break;
                case 4:
                    System.out.print("Nome do contato a buscar: ");
                    nome = scanner.nextLine();
                    Contato buscado = agenda.buscarContato(nome);
                    if (buscado != null) {
                        System.out.println(buscado);
                    }
                    break;
                case 5:
                    System.out.println("\nSaindo...");
                    break;
                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }
}