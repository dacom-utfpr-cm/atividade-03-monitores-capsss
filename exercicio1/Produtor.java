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
public class Produtor implements Runnable{
    
    BufferCircular buffer;

    public Produtor(BufferCircular buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        System.out.println("produzindo o valor: " + Thread.currentThread().getId());
        buffer.put("" + Thread.currentThread().getId());
        System.out.println("valor: " + Thread.currentThread().getId() + " produzido");
    }


}
