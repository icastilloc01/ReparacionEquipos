/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reparacionequipos;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import static reparacionequipos.Utilidades.CLIENTES;

/**
 *
 * @author Rxndy
 */
public class Cliente {

    private long id; //valores validos: números positivos mayores que 0 - valor invalido: números menores o iguales que 0
    private String nombre; //valores validos: cadenas de caracterés con mínimo de 3 letras - valor invalido: cadenas con numeros o menor de 3 letras
    private String nif;//valores validos: cadena de caracterés con 8 números y una letra - valor invalido: cadenas con solo numeros o letras
    private String direccion;// valores validos: cadena de caracteres con minimo de 4 letras - valor invalido: longitud de cadena menor de 4 letras
    private String telefono;//valores validos: cadena de caracteres con 9 numeros - valor invalido: cadena menor de 9 numeros o que contenga alguna letra
    private String tarjetaCredito;//valores validos: 9 cifras numéricas - valor invalido: menos de 9 cifras númericas o con letras
    private String cuentaCorriente;//valores validos: 9 cifras numéricas con dos letras iniciales que indican el país - valor invalido: menos de 9 cifras o que no tenga letras
    private ArrayList<Servicio> servicios = new ArrayList<Servicio>();//valores validos: solo onjetos de tipo Servicio

    //constructor por defecto
    public Cliente() {
    }

    //constructor parámetros
    public Cliente(long id, String nombre, String nif, String direccion, String telefono, String tarjetaCredito, String cuentaCorriente, ArrayList<Servicio> servicios){
        this.id = id;
        this.nombre = nombre;
        this.nif = nif;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tarjetaCredito = tarjetaCredito;
        this.cuentaCorriente = cuentaCorriente;
        this.servicios = servicios;
    }
    
    public Cliente(long id, String nombre, String nif, String direccion, String telefono, String tarjetaCredito, String cuentaCorriente){
        this.id = id;
        this.nombre = nombre;
        this.nif = nif;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tarjetaCredito = tarjetaCredito;
        this.cuentaCorriente = cuentaCorriente;
    }

    //constructor copia
    private Cliente(Cliente c) {
        this.id = c.id;
        this.nombre = c.nombre;
        this.nif = c.nif;
        this.direccion = c.direccion;
        this.telefono = c.telefono;
        this.tarjetaCredito = c.tarjetaCredito;
        this.cuentaCorriente = c.cuentaCorriente;
        this.servicios = c.servicios;
    }

    //getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setTarjetaCredito(String tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    public String getCuentaCorriente() {
        return cuentaCorriente;
    }

    public void setCuentaCorriente(String cuentaCorriente) {
        this.cuentaCorriente = cuentaCorriente;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }

    public static long nextIdCliente() {
        long ret = 0;
        for (Cliente c : Utilidades.CLIENTES) {
            if (c.getId() > ret) {
                ret = c.getId();
            }
        }
        return ret + 1;
    }

    public static Cliente nuevoCliente() throws ClienteException {
        Cliente c = new Cliente();
        Scanner sc = new Scanner(System.in);
        boolean salir;
        do {
            c.id = nextIdCliente();
            System.out.println("Introduzca su nombre:");
            String nombre = sc.nextLine();
            c.setNombre(nombre);
            System.out.println("Introduzca su nif:");
            String nif = sc.nextLine();
            c.setNombre(nif);
            System.out.println("Introduzca su dirección:");
            String direccion = sc.nextLine();
            c.setNombre(direccion);
            System.out.println("Introduzca su número de teléfono");
            String tlfn = sc.nextLine();
            c.setTelefono(tlfn);
            System.out.println("Introduzca su tarjeta de credito:");
            String credito = sc.nextLine();
            c.setNombre(credito);
            System.out.println("Introduzca su cuenta corriente:");
            String ccorriente = sc.nextLine();
            c.setNombre(ccorriente);
            ArrayList<Servicio> ls = new ArrayList();
            System.out.println("¿Quiere introducir un servicio? (s/n)");
            boolean p;
            p = Utilidades.leerBoolean();
            while (p) {
                c.servicios.add(Servicio.nuevoServicio());
                System.out.println("¿Quiere introducir otro servicio? (s/n)");
                p = Utilidades.leerBoolean();
            }
            System.out.println("Son correctos los siguiente datos?(s/n)");
            System.out.println("nombre:" + nombre);
            System.out.println("telefono:" + tlfn);
            System.out.println("tarjeta de credito:" + credito);
            System.out.println("cuenta corriente:" + ccorriente);
            System.out.println("nif:" + nif);
            System.out.println("direccion:" + direccion);
            salir = Utilidades.leerBoolean();
        } while (salir);
        if (!ClienteException.comprobarTelefono(c.getTelefono())){
            throw new ClienteException("El telefono no es valido");
        } else if(!ClienteException.comprobarNombre(c.getNombre())){
            throw new ClienteException("El nombre no es valido");
            } else if(!ClienteException.comprobarNif(c.getNif())){
            throw new ClienteException("El nif no es valido");
        } else if(!ClienteException.comprobarDireccion(c.getDireccion())){
            throw new ClienteException("La dirección no es valida");
        } else if(!ClienteException.comprobarTarjetaCredito(c.getTarjetaCredito())){
            throw new ClienteException("La tarjeta de credito no es valida");
        } else if(!ClienteException.comprobarCuentaCorriente(c.getCuentaCorriente())){
            throw new ClienteException("El nombre no es valido");
        }
        
        return c;
    }

    public String servicios() {
        String ret = " servicios:[";
        for (Servicio s : this.servicios) {
            ret += "" + s.getId() + "(" + s.getId() + "), ";
        }
        return ret + "]";
    }

    /*
    public String servicios() {
        String ret = " servicios:[";
        ret = this.servicios.stream().map((s) -> "" + s.getId() + "(" + s.getId() + "), ").reduce(ret, String::concat);
        return ret + "]";
    }
     */
    public static ArrayList<Cliente> listarclientes(ArrayList<Cliente> lista, int[] ids) {
        ArrayList<Cliente> ret = new ArrayList<Cliente>();
        Cliente c1 = new Cliente();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                System.out.println("Este el número de clientes " + ids.length);
                System.out.println("Estos son los nombres" + c1.getNombre());
                //el método getIdentificador() es propio de Almacen
                if (lista.get(j).getId() == ids[i]) {
                    ret.add((Cliente) lista.get(ids[i]));

                    break;
                }
            }
        }
        return ret;
    }

    public static ArrayList<Cliente> arrayde(ArrayList<Cliente> lista, int[] ids) {
        ArrayList<Cliente> ret = new ArrayList<Cliente>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                //el método getIdentificador() es propio de Almacen
                if (lista.get(j).getId() == ids[i]) {
                    ret.add((Cliente) lista.get(ids[i]));
                    break;
                }
            }
        }
        return ret;
    }

    public static ArrayList<Cliente> convertir(Cliente[] array) {
        ArrayList<Cliente> ret = new ArrayList<Cliente>();
        for (Cliente c : array) {
            ret.add((Cliente) c);
        }
        return ret;
    }

    public static void verClientes(ArrayList<Cliente> clientes) {
        System.out.println("En el sistema estan registrados los siguientes clientes:");
        for (Cliente c : clientes) {
            System.out.println(c.getId() + ". " + c.getNombre() + ". " + c.getNif() + ". " + c.getDireccion() + ". " + c.getTelefono() + ". " + c.getTarjetaCredito() + ". " + c.getCuentaCorriente());
        }
    }

    //Método para buscar
    public static Cliente buscarporid(ArrayList<Cliente> lista) throws ClienteException{

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca su id");
        sc.reset();
        int idCliente = sc.nextInt();
        Cliente c = null;
        for (Cliente ret : Utilidades.CLIENTES) {
            if (ret.getId() == idCliente) {
                c = ret;
                break;
            }
        }
         if (!ClienteException.comprobarId(c.getId())) {
             throw new ClienteException("El id tiene que ser mayor que 0");
         }
       
        return c;
    }

    public static ArrayList<Cliente> buscarclientepornombre(String nombrecl, ArrayList<Cliente> clientes) throws ClienteException {
        ArrayList<Cliente> ret = new ArrayList<Cliente>();
        for (Cliente c : clientes) {
            if (Utilidades.removeDiacriticalMarks(c.getNombre().toLowerCase()).contains(Utilidades.removeDiacriticalMarks(nombrecl.toLowerCase()))) {
                ret.add(c);
            }
            if (c.getNombre().toLowerCase().contains(nombrecl.toLowerCase())) {
                if (!ret.contains(c)) {
                    ret.add(c);
                }
            }
            if(!ClienteException.comprobarNombre(c.getNombre())){
            throw new ClienteException("El nombre no es valido");
        }}
        
        
        return ret;
    }
    

    public static ArrayList<Cliente> buscarclientepornif(String nifcl, ArrayList<Cliente> clientes) throws ClienteException {
        ArrayList<Cliente> ret = new ArrayList<Cliente>();
        for (Cliente c : clientes) {
            if (Utilidades.removeDiacriticalMarks(c.getNif().toLowerCase()).contains(Utilidades.removeDiacriticalMarks(nifcl.toLowerCase()))) {
                ret.add(c);
            }
            if (c.getNif().toLowerCase().contains(nifcl.toLowerCase())) {
                if (!ret.contains(c)) {
                    ret.add(c);
                }
            }
            if(!ClienteException.comprobarNif(c.getNif())){
            throw new ClienteException("El nif no es valido");}
        }
        return ret;
    }

    public static ArrayList<Cliente> buscarclientepordireccion(String direccioncl, ArrayList<Cliente> clientes) throws ClienteException {
        ArrayList<Cliente> ret = new ArrayList<Cliente>();
        for (Cliente c : clientes) {
            if (Utilidades.removeDiacriticalMarks(c.getDireccion().toLowerCase()).contains(Utilidades.removeDiacriticalMarks(direccioncl.toLowerCase()))) {
                ret.add(c);
            }
            if (c.getNif().toLowerCase().contains(direccioncl.toLowerCase())) {
                if (!ret.contains(c)) {
                    ret.add(c);
                }
            }
            if(!ClienteException.comprobarDireccion(c.getDireccion())){
            throw new ClienteException("La dirección no es valida");}
        }
        return ret;
    }

    public static ArrayList<Cliente> buscarclienteportelefono(String tlfcl, ArrayList<Cliente> clientes) throws ClienteException {
        ArrayList<Cliente> ret = new ArrayList<Cliente>();
        for (Cliente c : clientes) {
            if (Utilidades.removeDiacriticalMarks(c.getTelefono().toLowerCase()).contains(Utilidades.removeDiacriticalMarks(tlfcl.toLowerCase()))) {
                ret.add(c);
            }
            if (c.getNif().toLowerCase().contains(tlfcl.toLowerCase())) {
                if (!ret.contains(c)) {
                    ret.add(c);
                }
            }
            if (!ClienteException.comprobarTelefono(c.getTelefono())){
            throw new ClienteException("El telefono no es valido");}
        }
        return ret;
    }

    public static ArrayList<Cliente> buscarclienteportarjetadecredito(String tdcrcl, ArrayList<Cliente> clientes) throws ClienteException{
        ArrayList<Cliente> ret = new ArrayList<Cliente>();
        for (Cliente c : clientes) {
            if (Utilidades.removeDiacriticalMarks(c.getTarjetaCredito().toLowerCase()).contains(Utilidades.removeDiacriticalMarks(tdcrcl.toLowerCase()))) {
                ret.add(c);
            }
            if (c.getNif().toLowerCase().contains(tdcrcl.toLowerCase())) {
                if (!ret.contains(c)) {
                    ret.add(c);
                }
            }
            if(!ClienteException.comprobarTarjetaCredito(c.getTarjetaCredito())){
            throw new ClienteException("La tarjeta de credito no es valida");
        }
        }
        return ret;
    }

    public static ArrayList<Cliente> buscarclienteporcuentacorriente(String cccl, ArrayList<Cliente> clientes) throws ClienteException {
        ArrayList<Cliente> ret = new ArrayList<Cliente>();
        for (Cliente c : clientes) {
            if (Utilidades.removeDiacriticalMarks(c.getCuentaCorriente().toLowerCase()).contains(Utilidades.removeDiacriticalMarks(cccl.toLowerCase()))) {
                ret.add(c);
            }
            if (c.getNif().toLowerCase().contains(cccl.toLowerCase())) {
                if (!ret.contains(c)) {
                    ret.add(c);
                }
            }
            if(!ClienteException.comprobarCuentaCorriente(c.getCuentaCorriente())){
            throw new ClienteException("El nombre no es valido");}
            
        }
        return ret;
    }

    public static void buscarClientes(ArrayList<Cliente> clientes) throws ClienteException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        System.out.println("Pulse 1 para buscar un cliente por el id");
        System.out.println("Pulse 2 para buscar un cliente por el nombre");
        System.out.println("Pulse 3 para buscar un cliente por el telefono");
        System.out.println("Pulse 4 para buscar un cliente por el nif");
        System.out.println("Pulse 5 para buscar un cliente por el apellido");
        System.out.println("Pulse 6 para buscar un cliente por la direccion");
        System.out.println("Pulse 0 para volver");
        sc.reset();
        int opcion = sc.nextInt();

     
            do {
                switch (opcion) {
                    case 1:

                        buscarporid(clientes);
                        ReparacionEquipos.mostrarGestionClientes(clientes);
                        break;

                    case 2:
                        System.out.println("Introduzca el nombre del cliente que desea buscar:");
                        String nombrecl = sc.nextLine(); //linea para que no se salte el nextLine()
                        nombrecl = sc.nextLine();
                        lista = buscarclientepornombre(nombrecl, clientes);
                        if (lista.size() > 0) {
                            System.out.println("Se han encontrado datos: ");
                            for (Cliente c : lista) {
                                System.out.println(c.getId() + "." + c.getNombre() + "." + c.getNif() + "." + c.getDireccion() + "." + c.getCuentaCorriente() + "." + c.getTelefono() + "." + c.getTarjetaCredito() + "." + c.getCuentaCorriente() + c.getClass().getSimpleName());
                            }
                        } else {
                            System.out.println("El cliente con nombre " + nombrecl + " no se ha encontrado en el sistema.");
                        }
                        System.out.println("");
                        ReparacionEquipos.mostrarGestionClientes(clientes);
                        break;

                    case 3:
                    case 4:
                        System.out.println("Introduzca el nif del cliente que desea buscar");
                        String nifcl = sc.nextLine(); //linea para que no se salte el nextLine()
                        nifcl = sc.nextLine();
                        lista = buscarclientepornif(nifcl, clientes);
                        if (lista.size() > 0) {
                            System.out.println("Se han encontrado datos: ");
                            for (Cliente c : lista) {
                                System.out.println(c.getId() + "." + c.getNombre() + "." + c.getNif() + "." + c.getDireccion() + "." + c.getCuentaCorriente() + "." + c.getTelefono() + "." + c.getTarjetaCredito() + "." + c.getCuentaCorriente() + c.getClass().getSimpleName());
                            }
                        } else {
                            System.out.println("El cliente con nombre " + nifcl + " no se ha encontrado en el sistema.");
                        }
                        System.out.println("");
                        ReparacionEquipos.mostrarGestionClientes(clientes);
                        break;

                    case 5:
                        System.out.println("Introduzca la direccion del cliente que desea buscar");
                        String direccioncl = sc.nextLine(); //linea para que no se salte el nextLine()
                        direccioncl = sc.nextLine();
                        lista = buscarclientepordireccion(direccioncl, clientes);
                        if (lista.size() > 0) {
                            System.out.println("Se han encontrado datos: ");
                            for (Cliente c : lista) {
                                System.out.println(c.getId() + "." + c.getNombre() + "." + c.getNif() + "." + c.getDireccion() + "." + c.getCuentaCorriente() + "." + c.getTelefono() + "." + c.getTarjetaCredito() + "." + c.getCuentaCorriente() + c.getClass().getSimpleName());
                            }
                        } else {
                            System.out.println("El cliente con nombre " + direccioncl + " no se ha encontrado en el sistema.");
                        }
                        System.out.println("");
                        ReparacionEquipos.mostrarGestionClientes(clientes);
                        break;

                    case 6:
                        System.out.println("Introduzca el telefono del cliente que desea buscar");
                        String tlfcl = sc.nextLine(); //linea para que no se salte el nextLine()
                        tlfcl = sc.nextLine();
                        lista = buscarclienteportelefono(tlfcl, clientes);
                        if (lista.size() > 0) {
                            System.out.println("Se han encontrado datos: ");
                            for (Cliente c : lista) {
                                System.out.println(c.getId() + "." + c.getNombre() + "." + c.getNif() + "." + c.getDireccion() + "." + c.getCuentaCorriente() + "." + c.getTelefono() + "." + c.getTarjetaCredito() + "." + c.getCuentaCorriente() + c.getClass().getSimpleName());
                            }
                        } else {
                            System.out.println("El cliente con nombre " + tlfcl + " no se ha encontrado en el sistema.");
                        }
                        System.out.println("");
                        ReparacionEquipos.mostrarGestionClientes(clientes);
                        break;

                    case 7:
                        System.out.println("Introduzca la cuenta corriente del cliente que desea buscar");
                        String cccl = sc.nextLine(); //linea para que no se salte el nextLine()
                        cccl = sc.nextLine();
                        lista = buscarclienteporcuentacorriente(cccl, clientes);
                        if (lista.size() > 0) {
                            System.out.println("Se han encontrado datos: ");
                            for (Cliente c : lista) {
                                System.out.println(c.getId() + "." + c.getNombre() + "." + c.getNif() + "." + c.getDireccion() + "." + c.getCuentaCorriente() + "." + c.getTelefono() + "." + c.getTarjetaCredito() + "." + c.getCuentaCorriente() + c.getClass().getSimpleName());
                            }
                        } else {
                            System.out.println("El cliente con nombre " + cccl + " no se ha encontrado en el sistema.");
                        }
                        System.out.println("");
                        ReparacionEquipos.mostrarGestionClientes(clientes);
                        break;

                    case 0:
                        ReparacionEquipos.mostrarGestionClientes(clientes);
                    default:
                        System.out.println("El valor que ha introducido no es un número del 0 al 6");
                        System.out.println("");
                }

            } while (opcion > 7 || opcion < 0);
            /*if (!ClienteException.comprobarTelefono(c.getTelefono())){
            throw new ClienteException("El telefono no es valido");
        } else if(!ClienteException.comprobarNombre(c.getNombre())){
            throw new ClienteException("El nombre no es valido");
            } else if(!ClienteException.comprobarNif(c.getNif())){
            throw new ClienteException("El nif no es valido");
        } else if(!ClienteException.comprobarDireccion(c.getDireccion())){
            throw new ClienteException("La dirección no es valida");
        } else if(!ClienteException.comprobarTarjetaCredito(c.getTarjetaCredito())){
            throw new ClienteException("La tarjeta de credito no es valida");
        } else if(!ClienteException.comprobarCuentaCorriente(c.getCuentaCorriente())){
            throw new ClienteException("El nombre no es valido");
        }*/

        }

    

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", nif=" + nif + ", direccion=" + direccion + ", telefono=" + telefono + ", tarjetaCredito=" + tarjetaCredito + ", cuentaCorriente=" + cuentaCorriente + servicios() + '}';
    }
    
    
    
    /**
     * Este metodo exporta una coleccion de objetos de tipo empleado a un
     * fichero binario
     *
     * @param path
     */
    public static void exportarColeccionClientesaArchivoBinario(String path) {
        ArrayList<Cliente> coleccion;
        coleccion = Cliente.convertir(Utilidades.CLIENTES);
        try {
            FileOutputStream fichero = new FileOutputStream(path, true);
            ObjectOutputStream escritor = new ObjectOutputStream(fichero);
            escritor.writeObject(coleccion);
            escritor.flush();
            escritor.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el fichero");
        } catch (IOException e) {
            System.out.println("Se ha producido un error en la inserción de los datos");
        } catch (Exception e) {
            System.out.println("Se ha producido un error inesperado intentelo de nuevo");
        }
    }

    /**
     * Este metodo importa una coleccion de obejtos de tipo empleado desde un
     * fichero de datos binario
     *
     * @param path
     * @return
     */
    public static ArrayList<Cliente> importarClienteDesdeFicheroBytes(String path) {
        ArrayList<Cliente> ret = new ArrayList<Cliente>();
        FileInputStream lector = null;
        ObjectInputStream lectorObjeto = null;
        try {
            try {
                lector = new FileInputStream(path);
                lectorObjeto = new ObjectInputStream(lector);
                Cliente e;
                while ((e = (Cliente) lectorObjeto.readObject()) != null) {
                    ret.add(e);
                }
            } finally {
                if (lectorObjeto != null) {
                    lectorObjeto.close();
                }
                if (lector != null) {
                    lector.close();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el fichero");
        } catch (EOFException e) {
            System.out.println("Final de fichero");
        } catch (IOException e) {
            System.out.println("Se ha producido un error en la inserción de los datos");
        } catch (ClassNotFoundException e) {
            System.out.println("No se ha encontrado la clase a la cual haces referencia");
        } catch (Exception e) {
            System.out.println("Se ha producido un error inesperado intentelo de nuevo");
        }
        return ret;
    }

    /**
     * Este metodo importa una coleccion de objetos de tipo empleado desde un
     * fichero de tecto
     *
     * @param path
     * @return
     */
    public static ArrayList<Cliente> importarClienteDesdeFicheroCaracteres(String path) {
        ArrayList<Cliente> ret = new ArrayList<Cliente>();
        File fichero = new File(path);
        BufferedReader buffer = null;
        FileReader lector = null;
        try {
            try {
                lector = new FileReader(fichero);
                buffer = new BufferedReader(lector);
                String linea;
                while ((linea = buffer.readLine())!= null) {
                    String campos[] = linea.split("\\|");
                    long id = Long.parseLong(campos[0]);
                    String nombre = campos[1];
                    String nif = campos[2];
                    String direccion = campos[3];
                    String telefono = campos[4];
                    String tarjetaCredito = campos[5];
                    String cuentaCorriente = campos[6];
                    Cliente c = new Cliente (id,nombre, nif, direccion,telefono,tarjetaCredito, cuentaCorriente);
                    ret.add(c);
                }
            } finally {
                if (lector != null) {
                    lector.close();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el fichero");
        } catch (EOFException e) {
            System.out.println("Final de fichero");
        } catch (IOException e) {
            System.out.println("Se ha producido un error en la inserción de los datos");
        } catch (Exception e) {
            System.out.println("Se ha producido un error inesperado intentelo de nuevo");
        }
        return ret;
    }

    /**
     * Este metodo busca un objeto de la coleccion de objetos de un fichero de
     * texto mediante el id del objeto
     *
     * @param path
     * @return
     */
 

    public String data() {
        return id + "|" + nombre + '|' + telefono + '|' + nif +  '|' + direccion;
    }

    
    }
    

