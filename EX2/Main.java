import java.util.Scanner;

public class Main {
    
    public static void main (String[] args) {

        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite o limite do intervalo: [1, ...v]");
        int v = entrada.nextInt();

        System.out.println(Ex2.countSeq(v) + " sequencias de valores somam exatamente " + v);
    }
}
