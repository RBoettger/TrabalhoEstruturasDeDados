package estrutura;

import model.Aluno;

public class PilhaEstatica {
    private Aluno[] elementos;
    private int topo;
    private int tamanhoMaximo;

    // Construtor
    public PilhaEstatica(int tamanhoMaximo) {
        this.tamanhoMaximo = tamanhoMaximo;
        this.elementos = new Aluno[tamanhoMaximo];
        this.topo = -1;
    }

   
    public void init() {
        this.topo = -1;
    }

    public boolean isEmpty() {
        return (topo == -1);
    }

    public boolean isFull() {
        return (topo == tamanhoMaximo - 1);
    }

    public void push(Aluno aluno) {
        if (isFull()) {
            System.out.println("A pilha está cheia!");
            return;
        }
        topo++;
        elementos[topo] = aluno;
    }
    
    public Aluno pop() {
        if (isEmpty()) {
            System.out.println("A pilha está vazia!");
            return null;
        }
        Aluno aluno = elementos[topo];
        topo--;
        return aluno;
    }

    public Aluno topo() {
        if (isEmpty()) {
            System.out.println("A pilha está vazia!");
            return null;
        }
        return elementos[topo];
    }

    public void destroy() {
        init();
        elementos = null;
        tamanhoMaximo = 0;
    }
}
