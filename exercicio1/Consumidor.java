/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio1;

/**
 *
 * @author a834173
 */
public class Consumidor implements Runnable{
    
    BufferCircular buffer;
    
    public Consumidor(BufferCircular buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        System.out.println("valor consumido: " + buffer.take() + " pela thread: " + Thread.currentThread().getId());
    }
    
}
