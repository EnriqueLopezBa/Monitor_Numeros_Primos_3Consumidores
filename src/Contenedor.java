


public class Contenedor {
    
    private boolean contenedorLleno = false;
    private int[] arreglo = new int[100];
    private int cont = -1;
    
    public synchronized void insertar(int numero){
        while(contenedorLleno){
            try {
//                System.out.println("Contenedor lleno");
                wait();
            } catch (InterruptedException e) {
                System.out.println("Error");
            }
        }
        
        arreglo[++cont] = numero;
        if(cont == 99)
            contenedorLleno = true;
        notify();
    }
    
    public synchronized int sacar(){
        
        while(cont == -1){
            try {
//                System.out.println("Contenedor vacio");
                wait();
            } catch (InterruptedException e) {
                System.out.println("error");
            }
        }
      
        int x = arreglo[cont];
        arreglo[cont] = 0;
        cont--;
          if(cont < 100)
            contenedorLleno = false;
        notify();
        return x;
    }
}
