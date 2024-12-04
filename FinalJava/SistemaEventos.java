import java.sql.*;
import java.util.Scanner;

public class SistemaEventos {

    private static final String URL = "jdbc:mysql://localhost:3306/sistema_eventos";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("1. Criar Evento");
        System.out.println("2. Alterar Evento");
        System.out.println("3. Excluir Evento");
        System.out.println("4. Criar Organizador");
        System.out.println("5. Excluir Organizador");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                criarEvento(scanner);
                break;
            case 2:
                alterarEvento(scanner);
                break;
            case 3:
                excluirEvento(scanner);
                break;
            case 4:
                criarOrganizador(scanner);
                break;
            case 5:
                excluirOrganizador(scanner);
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
        
        scanner.close();
    }

    public static void criarEvento(Scanner scanner) {
        System.out.println("Digite o nome do evento:");
        String nomeEvento = scanner.nextLine();

        System.out.println("Digite a data do evento (YYYY-MM-DD):");
        String dataEvento = scanner.nextLine();

        System.out.println("Digite a descrição do evento:");
        String descricaoEvento = scanner.nextLine();

        System.out.println("Digite o ID do organizador (selecione um organizador existente):");
        int idOrganizador = scanner.nextInt();

        String sql = "INSERT INTO eventos (nome, data, descricao, idOrganizador) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nomeEvento);
            stmt.setString(2, dataEvento);
            stmt.setString(3, descricaoEvento);
            stmt.setInt(4, idOrganizador);

            stmt.executeUpdate();
            System.out.println("Evento criado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void alterarEvento(Scanner scanner) {
        System.out.println("Digite o ID do evento que deseja alterar:");
        int idEvento = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o novo nome do evento:");
        String nomeEvento = scanner.nextLine();

        System.out.println("Digite a nova data do evento (YYYY-MM-DD):");
        String dataEvento = scanner.nextLine();

        System.out.println("Digite a nova descrição do evento:");
        String descricaoEvento = scanner.nextLine();

        String sql = "UPDATE eventos SET nome = ?, data = ?, descricao = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nomeEvento);
            stmt.setString(2, dataEvento);
            stmt.setString(3, descricaoEvento);
            stmt.setInt(4, idEvento);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Evento alterado com sucesso!");
            } else {
                System.out.println("Evento não encontrado.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void excluirEvento(Scanner scanner) {
        System.out.println("Digite o ID do evento que deseja excluir:");
        int idEvento = scanner.nextInt();

        String sql = "DELETE FROM eventos WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idEvento);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Evento excluído com sucesso!");
            } else {
                System.out.println("Evento não encontrado.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void criarOrganizador(Scanner scanner) {
        System.out.println("Digite o nome do organizador:");
        String nome = scanner.nextLine();

        System.out.println("Digite o email do organizador:");
        String email = scanner.nextLine();

        String sql = "INSERT INTO organizadores (nome, email) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, email);

            stmt.executeUpdate();
            System.out.println("Organizador criado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void excluirOrganizador(Scanner scanner) {
        System.out.println("Digite o ID do organizador que deseja excluir:");
        int idOrganizador = scanner.nextInt();

        String sql = "DELETE FROM organizadores WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idOrganizador);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Organizador excluído com sucesso!");
            } else {
                System.out.println("Organizador não encontrado.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
