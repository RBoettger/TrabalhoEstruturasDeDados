package program;
import java.util.Scanner;
import estrutura.PilhaEstatica;
import model.Aluno;

public class AplicacaoControleAlunos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PilhaEstatica pilhaFeminina = new PilhaEstatica(20);
        PilhaEstatica pilhaMasculina = new PilhaEstatica(20);

        boolean continuar = true;

        while (continuar) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Inicializar pilhas");
            System.out.println("2. Destruir pilhas");
            System.out.println("3. Adicionar aluno");
            System.out.println("4. Remover aluno");
            System.out.println("5. Exibir topo das pilhas");
            System.out.println("6. Verificar se as pilhas estão vazias");
            System.out.println("7. Verificar se as pilhas estão cheias");
            System.out.println("8. Exibir alunos");
            System.out.println("9. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    pilhaFeminina.init();
                    pilhaMasculina.init();
                    System.out.println("Pilhas inicializadas.");
                    break;
                case 2:
                    pilhaFeminina.destroy();
                    pilhaMasculina.destroy();
                    System.out.println("Pilhas destruídas.");
                    break;
                case 3:
                    System.out.println("Digite o nome do aluno:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite a matrícula do aluno:");
                    int matricula = scanner.nextInt();
                    System.out.println("Digite o sexo do aluno (F/M):");
                    char sexo = scanner.next().charAt(0);
                    Aluno aluno = new Aluno(nome, matricula, sexo);
                    if (aluno.getSexo() == 'F') {
                        pilhaFeminina.push(aluno);
                    } else {
                        pilhaMasculina.push(aluno);
                    }
                    System.out.println("Aluno adicionado com sucesso.");
                    break;
                case 4:
                    if (!pilhaFeminina.isEmpty()) {
                        System.out.println("Removendo aluno do sexo feminino: " + pilhaFeminina.pop().getNome());
                    } else if (!pilhaMasculina.isEmpty()) {
                        System.out.println("Removendo aluno do sexo masculino: " + pilhaMasculina.pop().getNome());
                    } else {
                        System.out.println("Não há alunos para remover.");
                    }
                    break;
                case 5:
                    System.out.println("Topo da pilha feminina: " + (pilhaFeminina.isEmpty() ? "Pilha vazia" : pilhaFeminina.topo().getNome()));
                    System.out.println("Topo da pilha masculina: " + (pilhaMasculina.isEmpty() ? "Pilha vazia" : pilhaMasculina.topo().getNome()));
                    break;
                case 6:
                    System.out.println("Pilha feminina vazia? " + pilhaFeminina.isEmpty());
                    System.out.println("Pilha masculina vazia? " + pilhaMasculina.isEmpty());
                    break;
                case 7:
                    System.out.println("Pilha feminina cheia? " + pilhaFeminina.isFull());
                    System.out.println("Pilha masculina cheia? " + pilhaMasculina.isFull());
                    break;
                case 8:
                    mostrarAlunos(pilhaFeminina, pilhaMasculina);
                    break;
                case 9:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
        
        scanner.close();
    }

    private static void mostrarAlunos(PilhaEstatica pilhaFeminina, PilhaEstatica pilhaMasculina) {
        System.out.println("\nAlunos do sexo feminino:");
        mostrarPilha(pilhaFeminina);

        System.out.println("\nAlunos do sexo masculino:");
        mostrarPilha(pilhaMasculina);
    }

    private static void mostrarPilha(PilhaEstatica pilha) {
        PilhaEstatica temp = new PilhaEstatica(20);
        while (!pilha.isEmpty()) {
            Aluno aluno = pilha.pop();
            System.out.println("Nome: " + aluno.getNome() + ", Matrícula: " + aluno.getMatricula() + ", Sexo: " + aluno.getSexo());
            temp.push(aluno);
        }
        while (!temp.isEmpty()) {
            pilha.push(temp.pop());
        }
    }
}