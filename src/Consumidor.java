


import java.util.List;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;


public class Consumidor implements Runnable{
    
    private Contenedor contenedor;
    private vtnPrincipal puntero;
    private DefaultTableModel tabla;
    private boolean desactivar = false;
    private int contador = 0, pos = 0;
    private List<Integer> listaNumeros;
    private List<Integer> listaPrimos;
    private JLabel label;
    
    public Consumidor(Contenedor contenedor, vtnPrincipal puntero, DefaultTableModel tabla,JLabel label){
        this.contenedor = contenedor;
        this.puntero = puntero;
        this.tabla = tabla;
         listaNumeros = new ArrayList<>();
         listaPrimos = new ArrayList<>();
         this.label = label;
    }

    
    @Override
    public void run() {
        while(!desactivar){
            try {
//                 tabla.setRowCount(0);
                 Thread.sleep((int)(Math.random()*(1000-300)+300));
                 if(listaPrimos.size() == 5){
                     desactivar = true;
                     puntero.ejec = false;
                     return;
                 }
                 
                 int numero = contenedor.sacar();
                listaNumeros.add(numero);
                tabla.addRow(new Object[]{listaNumeros.get(pos),""});
                for (int i = pos; i < listaNumeros.size(); i++) {
                    if(esPrimo(listaNumeros.get(i)) && !listaPrimos.contains(listaNumeros.get(i))){
                        listaPrimos.add(listaNumeros.get(i));
                        tabla.setValueAt("SI", i, 1);
                    }
                    pos++;
                }

                for (int i = 0; i < puntero.a.getRowCount(); i++) {
                    if(puntero.a.getValueAt(i, 0).equals(numero))
                        puntero.a.removeRow(i);
                }
                label.setText("<html>Numeros Primos: <font color= 'red'>"+listaPrimos.size()+" </font> <br>Total numeros: <font color = 'red'>"+tabla.getRowCount()+"</br></font> </html>");
//                puntero.jLabel2.setForeground(Color.red);
//                puntero.jLabel2.setText("Buscando...");

            } catch (InterruptedException e) {
                System.err.println("asdasdas");
            }
        }
    }
    
     boolean esPrimo(int n) {
        if (n%2==0) return false;
            for(int i = 3; i * i <= n; i += 2) {
                if(n % i == 0)
                    return false;  
            }
    return true;
    }
     
    
}
