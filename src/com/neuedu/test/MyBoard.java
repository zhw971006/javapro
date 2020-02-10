package com.neuedu.test;

/**
 * Created by Daniel on 2020/2/6.
 */
public class MyBoard {
   private Cpu cpu;

    public Cpu getCpu() {
        return cpu;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }
    public void method(){
        this.cpu.method();
    }
}
