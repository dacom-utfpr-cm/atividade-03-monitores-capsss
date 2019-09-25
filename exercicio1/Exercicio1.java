/*
 * Implemente uma solução com monitor para o problema do Produtor-Consumidor usando um buffer circular.
 *
 * Carlos Alexandre Peron dos Santos
*/
package exercicio1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int tamanho = 4;
        
        BufferCircular buffer = new BufferCircular(tamanho); //tamanho da lista = 4
        
        //criando 5 produtores... 1 deles ficara esperando
        for(int i=0; i<tamanho+1; i++){
            Thread t = new Thread(new Produtor(buffer));
            t.start();
        }
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Exercicio1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //criando 1 consumidor... o quinto produtor executara
        for(int i=0; i<1; i++){
            Thread t = new Thread(new Consumidor(buffer));
            t.start();
        }
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Exercicio1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //criando 5 consumidores... 1 deles ficara esperando
        for(int i=0; i<tamanho+1; i++){
            Thread t = new Thread(new Consumidor(buffer));
            t.start();
        }
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Exercicio1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //criando 1 produtor... vai ficar tudo certo
        for(int i=0; i<1; i++){
            Thread t = new Thread(new Produtor(buffer));
            t.start();
        }
       
        
    }
    
}
