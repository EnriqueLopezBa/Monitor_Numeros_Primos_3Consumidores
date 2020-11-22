


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Enrique
 */
public class Generador implements Runnable{
    private Contenedor contenedor;
    private vtnPrincipal puntero;
    public boolean ejecucion = true;
    private int pos = 0;
    private List<Integer> lista = new ArrayList<>();
    
    public Generador(Contenedor contenedor, vtnPrincipal puntero){
        this.contenedor = contenedor;
        this.puntero = puntero;
    }

    public void setEjecucion(boolean ejecucion) {
        this.ejecucion = ejecucion;
    }

    

    @Override
    public void run() {
        while(ejecucion){
            
            try {
                if(!vtnPrincipal.consumidoresActivos()){
                    ejecucion = false;
                    return;
                }
                int num =  (int)(Math.random()*(500000-1000)+1000);
                contenedor.insertar(num);
                        lista.add(num);
                        for (int i = pos; i < lista.size(); i++) {
                             puntero.a.addRow(new Object[]{lista.get(i)});
                            pos++;
                }
                     
               
              
                Thread.sleep((int)(Math.random()*(800-200)+200));
            } catch (InterruptedException e) {
                System.err.println("papa    "+e.getMessage());
                
            }
        }
    }
    
    
    
    
}
