package com.christyantofernando.volatilitysample;

public class Main {
    private static boolean ready;
    
    private static class Reader extends Thread {
        
        @Override
        public void run() {
            int a = 0;
            while (!ready) {
                a++;
            }
            
            System.out.println("Operation took: " + a);
        }
    }
    
    public static void main(String[] args) {
        new Reader().start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ready = true;
    }
}
