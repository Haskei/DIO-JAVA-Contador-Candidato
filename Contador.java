package candidatura;
import java.util.Scanner;
public class Contador extends Exception {
    public static void main(String[] args) {
    Scanner terminal= new Scanner(System.in);
    System.out.println("Digite o primeiro parametro: ");
    int parametroUm = terminal.nextInt();
    System.out.println("Digite o segundo parametro: ");
    int parametroDois = terminal.nextInt();
    try{
        contar(parametroUm,parametroDois);
    }catch(ParametrosInvalidosException erro){
        System.out.println("ERRO!"+ erro);
    }    
    }
    static void contar(int parametroUm,int parametroDois)throws ParametrosInvalidosException{
        if(parametroUm>parametroDois){
            throw new ParametrosInvalidosException("Parametro 1 é maior que o 2");
        }
        else{
            int contagem = parametroDois-parametroUm;
            for(int indice=1; indice<=contagem;indice++){
                System.out.println("Imprimindo o numero "+ indice);
            }
        }
    }
    
    
}
class ParametrosInvalidosException extends Exception{
    public ParametrosInvalidosException(String str){
        super(str);
    }
}
