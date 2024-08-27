package candidatura;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Pedro Henrique Novicov de Andrade
 */
public class ControleCandidatos {

    public static void main(String[] args) {
        System.out.println("Processo Seletivo");
        String[] candidatos= selecaoCandidatos();
        imprimirSelecionados(candidatos);
        for(String candidato: candidatos){
            entrandoEmContato(candidato);
        }
    }
    static boolean atender(){
        return new Random().nextInt(3)==1;
    }
    static void entrandoEmContato(String candidato){
        int tentativasRealizadas=1;
        boolean continuarTentando=true;
        boolean atendeu=false;
        do{
            atendeu=atender();
            if (atendeu==true){
                continuarTentando=false;
                System.out.println("Contato realizado com sucesso");
            }
            else{
                tentativasRealizadas++;
            }
        }while(continuarTentando && tentativasRealizadas<3);
        if(atendeu){
            System.out.println("Conseguimos contato com "+ candidato+ " em "+ tentativasRealizadas+ "tentativas");
                
        }
        else{
            System.out.println("Não conseguimos contatar "+ candidato + ", numero maximo de tentativas "+ tentativasRealizadas);
        }
    }
    static void imprimirSelecionados(String[] candidatos){
        System.out.println("Imprimindo a lista de candidatos com o indice:");
        for(int indice=0;indice<candidatos.length;indice++){
            System.out.println("O candidato nº"+(indice+1)+" é o(a) " + candidatos[indice]);
        }
        System.out.println("Forma abreviada da iteração");
        for(String candidato:candidatos){
            System.out.println("O(A) candidato(a) selecionado(a) foi:" +candidato);
        }
    }
    static String[] selecaoCandidatos(){
        String[] candidatos={"Pedro","Luiz","Laila","Paula","Mario","Julio","Junia","Maria","Zato","Dizzy"};
        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.00;
        String[] candidatosSelecionadosList= new String[5];
        while(candidatosSelecionados<5 && candidatosAtual<candidatos.length){
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();
            System.out.println("O Candidato: "+ candidato + "solicitou o valor de salário " + salarioPretendido);
            if(salarioBase>salarioPretendido){
                System.out.println("O candidato: "+ candidato +"foi selecionado");
                candidatosSelecionadosList[candidatosAtual]=candidato;
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }
        return candidatosSelecionadosList;
    };
    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    };
    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.00;
        if (salarioBase>salarioPretendido){
            System.out.println("Ligar Para Candidato");
        }
        else if (salarioBase==salarioPretendido){
            System.out.println("Ligar para o candidato para um contra proposta");
        }
        else{
            System.out.println("Aguardando resultado do demais candidatos");
        }
    };
}
