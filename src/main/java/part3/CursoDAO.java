package part3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

    public List<Curso> buscarCurso(){
        List<Curso> cursoRepository = new ArrayList<>();
        System.out.println("Entrei no Buscar curso!");

        try (Connection conn = ConnectionFactory.getConnection()){
            String query = "SELECT * FROM curso";
            System.out.println("Entrei no try!");

            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                System.out.println("Entrei no next!");
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int duracaoHoras = rs.getInt("duracao_horas");
                System.out.println(duracaoHoras);
                System.out.println(id);
                System.out.println(nome);

                cursoRepository.add(new Curso(
                        id,
                        nome,
                        duracaoHoras
                ));
            }
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Deu erro na busca!");
        }

        System.out.println("saí do while!");

        System.out.println(cursoRepository);

        return cursoRepository;
    }

    // 2 - Inserção
    public void criarCurso(Curso curso) {
        try (Connection conn = ConnectionFactory.getConnection()) {

            System.out.println("entrou no try do curso!");

            //Preparar SQL para inserção de dados do aluno.
            String sql = "INSERT INTO curso(nome, duracao_horas) VALUES(?, ?)";

            //Preparar statement com os parâmetros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1 , curso.getNome());
            stmt.setInt(2, curso.getDuracaoHoras());

            System.out.println("entrou no try do curso2!");

            //Executa inserção e armazena o numero de linhas afetadas
//            int rowsAffected = stmt.executeUpdate(); // Retorna o número de linhas (INTEIRO)
//            System.out.println("entrou no try do curso3!");

            System.out.println("Inserção BEM SUCEDIDA!. Foi adicionada " + "x" + " linha");
        } catch (SQLException e) {
            System.out.println("Inserção FALHOU no CURSO!");
            e.printStackTrace();
        }
    }
}
