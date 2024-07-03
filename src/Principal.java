import java.util.Collections;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        System.out.println("Escriba el limite de la tarjeta: ");
        double limite= lectura.nextDouble();
        TarjetaDeCredito tarjeta = new TarjetaDeCredito(limite);

        int salir = 1;
        while (salir != 0){
            System.out.println("Escriba la descripcion de la compra= ");
            String descripcion = lectura.next();

            System.out.println("Escriba el valor de la compra:");
            double valor = Double.valueOf(lectura.next());

            Compra compra = new Compra(valor, descripcion);
            boolean compraRealizada = tarjeta.lanzarCompra(compra);

            if(compraRealizada){
                System.out.println("Compra realizada con exito");
                System.out.println("Escriba 0 para salir o 1 para continuar");
                salir = lectura.nextInt();
            } else {
                System.out.println("Saldo insuficiente");
                salir = 0;
            }

            System.out.println("\n************************");
            System.out.println("COMPRAS REALIZADAS:\n");
            Collections.sort(tarjeta.getListaDeCompra());
            for (Compra compra1 : tarjeta.getListaDeCompra()) {
                System.out.println(compra1.getDescripcion() + " - " +compra1.getValor());
            }
            System.out.println("\n************************");
            System.out.println("\nSaldo de la tarjeta: " + tarjeta.getSaldo());
        }
    }
}
