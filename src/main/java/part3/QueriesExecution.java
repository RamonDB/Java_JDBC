package part3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QueriesExecution {

    public static void main(String[] args) {

        AlunoDAO alunoDAO = new AlunoDAO(); // Criou uma instância da classe Aluno Data Access Object

        CursoDAO cursoDAO = new CursoDAO();

        // =========================== 1 - Consulta =================================================
        List<Aluno> alunos = alunoDAO.list(); // Executed list() method in AlunoDAO in a local variable alunos
        List<Curso> cursos = cursoDAO.buscarCurso();

        //alunos.stream().forEach(System.out::println);



        // ======================= 1.1 - Consulta com filtro ========================================
        //Aluno alunoParaConsulta = alunoDAO.getById(1);
        Aluno alunoParaConsulta = alunoDAO.getByName("ramon");

        //System.out.println(alunoParaConsulta);


        // =========================== 2 - Inserção =================================================
        Curso inserirCurso = new Curso("Curso 1",2);
        Curso inserirCurso2 = new Curso("Curso 2",3);

        cursoDAO.criarCurso(inserirCurso);
//        cursoDAO.criarCurso(inserirCurso2);
        cursos.stream().forEach(System.out::println);


        // =========================== 3 - Delete ===================================================
        //alunoDAO.delete(1);


        // =========================== 4 - Atualizar ================================================
        Aluno alunoParaAtualizar = alunoDAO.getById(3);
        alunoParaAtualizar.setNome("Joaquim");
        alunoParaAtualizar.setIdade(18);
        alunoParaAtualizar.setEstado("RS");

        //alunoDAO.update(alunoParaAtualizar);
    }

}


