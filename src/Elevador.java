import java.util.Scanner;

public class Elevador {
    private int capElevador;
    private int andarTotal;
    private int andar;
    private int quantPessoas;

    Scanner in = new Scanner(System.in);

    public int getCapElevador() {
        return this.capElevador;
    }

    public void setCapElevador(int capElevador) {
        this.capElevador = capElevador;
    }

    public int getAndarTotal() {
        return this.andarTotal;
    }

    public void setAndarTotal(int andarTotal) {
        this.andarTotal = andarTotal;
    }

    public int getAndar() {
        return this.andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public int getQuantPessoas() {
        return this.quantPessoas;
    }

    public void setQuantPessoas(int quantPessoas) {
        this.quantPessoas = quantPessoas;
    }

    public void inicia(int andarTotal, int capElevador) {
        setAndar(0);
        setQuantPessoas(0);
    }

    public void entra(int pessoas) {
        if (this.getQuantPessoas() + pessoas <= this.getCapElevador()) {
            setQuantPessoas(this.getQuantPessoas() + pessoas);
            System.out.println("Quantidade de pessoas no elevador: " + this.getQuantPessoas());
        } else {
            System.out.println("Entraram " + (this.getCapElevador() - this.getQuantPessoas())
                    + " elevador esta cheio pegue o proximo por favor.");
        }

    }

    public void sair(int pessoas) {
        if (this.getQuantPessoas() >= 1) {
            this.setQuantPessoas(this.getQuantPessoas() - pessoas);
            if (this.getQuantPessoas() >= 1) {
                System.out.println("Quantidade de pessoas no elevadore: " + this.getQuantPessoas());

            } else {
                this.setQuantPessoas(0);
                System.out.println("Elevador esta vazio.");
                System.out.print("Quantidade de pessoas para entrar no elevador: ");
                entra(in.nextInt());
            }
        } else {
            System.out.println("Elevador esta vazio.");
            System.out.print("Quantidade de pessoas para entrar no elevador: ");
            entra(in.nextInt());
        }

    }

    public void sobe(int proxAndar) {
        if (this.getAndar() < this.andarTotal) {
            this.setAndar(this.getAndar() + proxAndar);
            System.out.println("Andar atual: " + this.getAndar());
        } else {
            System.out.println("O elevador se encontra na cobertura.");
        }
    }

    public void desce(int proxAndar) {
        if (this.getAndar() >= 1) {
            for (int i = this.getAndar(); i > proxAndar; i--) {
                this.setAndar(this.getAndar() - 1);
            }
            if (this.getAndar() != 0) {
                System.out.println("Andar atual: " + this.getAndar());

            } else {
                System.out.println("O elevador se encontra no terreo");
            }
        }

    }
}
