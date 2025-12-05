package JogoDaVelha;

import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

        // declaraçao tabuleiro e inicia a matrix 3x3
        String [][] tabuleiro = new String[3][3];
        char jogadaAtual = 'X';
        boolean game = false;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j]="-";
            }
        }

        desenharJogo(tabuleiro);

        while (game == false){
            int[] coordenadas = iniciarJogada(scanner, jogadaAtual);

            int linha = coordenadas[0]-1;
            int coluna = coordenadas[1]-1;

            tabuleiro[linha][coluna]= String.valueOf(jogadaAtual);
            desenharJogo(tabuleiro);

            if(verificarVitoria(tabuleiro,jogadaAtual)){
                game = true;
                System.out.println("O jogador " + jogadaAtual + " venceu!");
                break;
            }

            if(verificarEmpate(tabuleiro)){
                game = true;
                System.out.println("O jogo terminou em empate! ");
                break;
            }

            if(jogadaAtual == 'X'){
                jogadaAtual = 'O';
            } else {
                jogadaAtual = 'X';
            }

        }
    }

    public static boolean verificarVitoria(String[][] tabuleiro,char jogador) {
        String jogada = String.valueOf(jogador);

        for (int i = 0; i < 3; i++) {
            if(tabuleiro[i][0].equals(jogada) && tabuleiro[i][1].equals(jogada) && tabuleiro[i][2].equals(jogada)) {
                return true;
            }
        }
        for (int j = 0; j < 3; j++) {
            if(tabuleiro[0][j].equals(jogada) && tabuleiro[1][j].equals(jogada) && tabuleiro[2][j].equals(jogada))
                return true;
        }
        if(tabuleiro[0][0].equals(jogada) && tabuleiro[1][1].equals(jogada) && tabuleiro[2][2].equals(jogada)){
            return true;
        }
        if(tabuleiro[0][2].equals(jogada) && tabuleiro[1][1].equals(jogada) && tabuleiro[2][0].equals(jogada)){
            return true;
        }
        return false;
    }

    public static boolean verificarEmpate(String[][] tabuleiro){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <3; j++) {
                if(tabuleiro[i][j].equals("-")){
                    return false;
                }
            }
        }
        return true;
    }

    public static void desenharJogo(String[][] tabuleiro){
        System.out.printf("\n| %s | %s | %s | \n", tabuleiro[0][0],tabuleiro[0][1],tabuleiro[0][2]);
        System.out.println("--------------");
        System.out.printf("| %s | %s | %s |\n",tabuleiro[1][0], tabuleiro[1][1],tabuleiro[1][2]);
        System.out.println("--------------");
        System.out.printf("| %s | %s | %s |\n\n",tabuleiro[2][0],tabuleiro[2][1], tabuleiro[2][2]);
    }

    public static int[] iniciarJogada (Scanner scanner, char jogada){
        int matriz[] = new int[2];
        System.out.print("Digite a linha que você quer jogar: ");
        matriz[0] = scanner.nextInt();
        System.out.print("Digite a coluna que você quer jogar: ");
        matriz[1] = scanner.nextInt();
        return matriz;
    }

}
