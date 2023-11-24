public class Producto {

    private String tipo;
    private double precio;
    private String id;
    private String modelo;


    public Producto(String tipo, double precio, String id, String modelo) {
        this.tipo = tipo;
        this.precio = precio;
        this.id = id;
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }



    public void menu(){

    }
}
