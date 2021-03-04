import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Elevador elevador = new Elevador();
        Scanner in = new Scanner(System.in);

        int pessoas;
        String inserir = new String();
        String sim = new String("sim");

        System.out.print("Digite a quantidade maxima de pessoas do elevador: ");
        elevador.setCapElevador(in.nextInt());

        System.out.print("Digite a quantidade de andares do edficio: ");
        elevador.setAndarTotal(in.nextInt());
        elevador.inicia(elevador.getAndarTotal(), elevador.getCapElevador());
        do {
            System.out.print("Quantidade de pessoas para entrar no elevador tem  "
                    + (elevador.getCapElevador() - elevador.getQuantPessoas()) + " espacos vagos: ");
            elevador.entra(in.nextInt());

            System.out.println("Voce esta no andar " + elevador.getAndar() + " \nAndares disponiveis para subir: ");
            for (int i = elevador.getAndarTotal(); i > elevador.getAndar(); i--) {
                System.out.println(i + " ");
            }
            System.out.print("Escolha um andar para subir: ");
            elevador.sobe(in.nextInt());

            if (elevador.getQuantPessoas() < elevador.getCapElevador()) {
                System.out.print("Quantidade de pessoas para entrar no elevador tem  "
                        + (elevador.getCapElevador() - elevador.getQuantPessoas())
                        + " espacos vagos tem mais alguem para entrar \nsim/nao: ");
                inserir = in.next();
                if (inserir.equals(sim)) {
                    System.out.print("Quantidade de pessoas para entrar no elevador tem  "
                            + (elevador.getCapElevador() - elevador.getQuantPessoas()) + " espacos vagos: ");
                    pessoas = in.nextInt();
                    elevador.entra(pessoas);
                }
            }

            System.out.print("Quantidade de pessoas para sair do elevador: ");
            elevador.sair(in.nextInt());

            if (elevador.getQuantPessoas() == 0) {
                break;
            }

            System.out.println("Voce esta no andar " + elevador.getAndar() + "\nAndares disponiveis para descer: ");
            for (int i = elevador.getAndar() - 1; i >= 0; i--) {
                System.out.println(i + " ");
            }
            System.out.print("Escolha um andar para descer: ");
            elevador.desce(in.nextInt());
        } while (elevador.getQuantPessoas() != 0);

        System.out.println("Elevador no andar " + elevador.getAndar());
        in.close();
    }
}
