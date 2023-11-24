import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Almacen {


    private ArrayList<Producto> almacen;
    private double facturacion;
    private HashMap<String, Double> facturacionPorTipo;
    public Almacen(){
        almacen = new ArrayList<>();
        facturacionPorTipo = new HashMap<>();
    }

    public void insertarProducto(String tipo, String modelo, double precio){
        if(tipo.equals("Tarjeta gráfica") || tipo.equals("Memoria RAM")  || tipo.equals("Placa base")  || tipo.equals("Fuente de alimentacion")  || tipo.equals("Memorias SSD")){
            Producto pro = new Producto(tipo, precio, "" + almacen.size(), modelo);
            almacen.add(pro);
            System.out.println("Producto introducido correctamente.");
        }
        System.out.println("No se pudo introducir producto");
    }


    public void buscarProducto(String id){
        for (Producto producto : almacen) {
            if (producto.getId().equals(id)) {
                System.out.println("**************************************\nProducto encontrado\nTIPO: " + producto.getTipo() + "\nID: " + producto.getId() + "\nMODELO: " + producto.getModelo() + "\nPRECIO: " + producto.getPrecio() + "\n**********************************************");
            }
        }
        System.out.println("Producto no encontrado");
    }

    public void ventaProducto(String tipo) {
        Iterator<Producto> iterator = almacen.iterator();
        boolean productoEncontrado = false;
        while (iterator.hasNext()) {
            Producto producto = iterator.next();
            if (producto.getTipo().equals(tipo)) {
                facturacion += producto.getPrecio();
                actualizarFacturacionPorTipo(producto.getTipo(), producto.getPrecio());
                iterator.remove();
                productoEncontrado = true;
                System.out.println("Producto vendido correctamente");
                break;
            }
        }
        if (!productoEncontrado) {
            System.out.println("Producto no encontrado");
        }
    }

    public void cambiarPrecio(String id, double nuevoPrecio){
        for (Producto producto : almacen) {
            if (producto.getId().equals(id)) {
                producto.setPrecio(nuevoPrecio);
                System.out.println("Precio cambiado correctamente para el producto con ID: " + id);
                return;
            }
        }
        System.out.println("Producto no encontrado");
    }

    public void facturacionGeneral(){
        System.out.println("Se ha generado " + facturacion + "€");
    }

    private void actualizarFacturacionPorTipo(String tipo, double precio) {
        if (facturacionPorTipo.containsKey(tipo)) {
            double facturacionTipoActual = facturacionPorTipo.get(tipo);
            facturacionPorTipo.put(tipo, facturacionTipoActual + precio);
        } else {
            facturacionPorTipo.put(tipo, precio);
        }
    }

    public void facturacionProducto(String tipo) {
        if (facturacionPorTipo.containsKey(tipo)) {
            double facturacionTipo = facturacionPorTipo.get(tipo);
            System.out.println("Facturación total para el tipo de producto '" + tipo + "': " + facturacionTipo + "€");
        } else {
            System.out.println("No hay facturación para el tipo de producto '" + tipo + "'");
        }
    }
}
