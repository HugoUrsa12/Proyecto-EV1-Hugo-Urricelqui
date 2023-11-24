import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Almacen almacen = new Almacen();
        int opcion;

        do {
            System.out.println("----------------------------------------------------------");
            System.out.println("|    Elija una de las siguientes opciones con su número: |");
            System.out.println("|    1- Insertar producto en almacén                     |");
            System.out.println("|    2- Buscar producto                                  |");
            System.out.println("|    3- Venta de Producto                                |");
            System.out.println("|    4- Cambiar precio de producto                       |");
            System.out.println("|    5- Mostrar facturación general                      |");
            System.out.println("|    6- Mostrar facturación de producto                  |");
            System.out.println("|    7- Salir                                            |");
            System.out.println("----------------------------------------------------------");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el tipo de producto(Tarjeta gráfica | Memoria RAM | Placa base | Fuente de alimentacion | Memorias SSD):");
                    String tipo = sc.nextLine();
                    System.out.println("Ingrese el modelo del producto:");
                    String modelo = sc.nextLine();
                    System.out.println("Ingrese el precio del producto:");
                    double precio = sc.nextDouble();
                    almacen.insertarProducto(tipo, modelo, precio);
                    break;
                case 2:
                    System.out.println("Ingrese el ID del producto a buscar:");
                    String idBuscar = sc.nextLine();
                    almacen.buscarProducto(idBuscar);
                    break;
                case 3:
                    System.out.println("Ingrese el tipo de producto a vender:");
                    String tipoVenta = sc.nextLine();
                    almacen.ventaProducto(tipoVenta);
                    break;
                case 4:
                    System.out.println("Ingrese el ID del producto cuyo precio quiere cambiar:");
                    String idCambiarPrecio = sc.nextLine();
                    System.out.println("Ingrese el nuevo precio:");
                    double nuevoPrecio = sc.nextDouble();
                    almacen.cambiarPrecio(idCambiarPrecio, nuevoPrecio);
                    break;
                case 5:
                    almacen.facturacionGeneral();
                    break;
                case 6:
                    System.out.println("Ingrese el tipo de producto del cual quiere ver la facturación:");
                    String tipoFacturacion = sc.nextLine().trim(); // Elimina los espacios en blanco alrededor del texto ingresado
                    almacen.facturacionProducto(tipoFacturacion);
                    break;
                case 7:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("El número no es válido, elija uno entre 1-7.");
            }
        } while (opcion != 7);

        sc.close();
    }
}