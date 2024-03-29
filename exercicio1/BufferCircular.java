/*
 * Implemente uma solução com monitor para o problema do Produtor-Consumidor usando um buffer circular.
 */
package exercicio1;

/**
 * Carlos Alexandre Peron dos Santos
 * @author a834173
 */
public class BufferCircular{
    private String message[];
    private boolean empty=true;
    private boolean full=false;
    private int inicio = 0;
    private int fim = 0;
    private int tamanho;
    
    public BufferCircular(int tamanho){
        this.tamanho = tamanho;
        this.message = new String[this.tamanho];
    }
    
    public synchronized String take(){
        while(empty){
            try{
                wait();
            } catch(InterruptedException e){}
        }
        inicio++;
        if(fim-inicio == 0){
            empty=true;
        }
        full=false;
        notifyAll();
        return this.message[(inicio-1) % tamanho];
    }
    
    public synchronized void put(String entrada){
        while(full){
            try{
                wait();
            } catch(InterruptedException e){}
        }
        fim++;
        if(fim-inicio >= tamanho){
            full=true;
        }
        empty = false;
        this.message[(fim -1) % tamanho] = entrada;
        notifyAll();
    }
}