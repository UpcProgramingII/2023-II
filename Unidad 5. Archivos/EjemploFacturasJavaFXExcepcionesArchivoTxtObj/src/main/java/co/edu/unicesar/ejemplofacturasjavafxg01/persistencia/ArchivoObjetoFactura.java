/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicesar.ejemplofacturasjavafxg01.persistencia;

import co.edu.unicesar.ejemplofacturasjavafxg01.entidades.Factura;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Jairo F
 */
public class ArchivoObjetoFactura implements IFactura {

    private File archivo;
    private FileOutputStream archivoEscritura;
    private FileInputStream archivoLectura;

    public ArchivoObjetoFactura(String filename) {
        this.archivo = new File(filename);
    }

    public ArchivoObjetoFactura() {
        this("Facturas.obj");
    }

    @Override
    public void adicionarFactura(Factura f) {
            ListaFactura lista = this.leer();
            lista.adicionarFactura(f);
            this.guardar(lista);
    }

    @Override
    public ArrayList<Factura> obtenerfacturas() {
        ListaFactura lista = this.leer();
        return lista.obtenerfacturas();
    }

    @Override
    public ArrayList<Factura> obtenerfacturasCredito() {
        ListaFactura lista = this.leer();
        return lista.obtenerfacturasCredito();
    }

    @Override
    public ArrayList<Factura> obtenerfacturasContado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Factura buscarFactura(int noFactura) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void guardar(ListaFactura lista) {
        ObjectOutputStream oos = null;
        try {
            this.archivoEscritura = new FileOutputStream(this.archivo, false);
            oos = new ObjectOutputStream(this.archivoEscritura);
            oos.writeObject(lista);
            oos.close();

        } catch (IOException ioe) {
            throw new IllegalStateException("Error al abrir archivo escritura o el archivo no existe");

        } finally {
            if (this.archivoEscritura != null) {
                try {
                    this.archivoEscritura.close();
                } catch (IOException ioe) {
                    throw new IllegalStateException("Error al cerrar archivo");
                }
            }
        }

    }

    private ListaFactura leer() {
        if (!this.archivo.exists()) {
            return new ListaFactura();
        }

        ObjectInputStream ois = null;
        try {
            this.archivoLectura = new FileInputStream(this.archivo);
            ois = new ObjectInputStream(this.archivoLectura);
            ListaFactura lista = (ListaFactura) ois.readObject();
            return lista;

        } catch (FileNotFoundException fne) {
            throw new IllegalStateException("Error al abrir archivo para elctura");
        } catch (IOException ioe) {
            throw new IllegalStateException("Error al leer archivo");
        } catch (ClassNotFoundException cnf) {
            throw new IllegalStateException("Error al leer la lista de facturas");
        } finally {
            if (this.archivoLectura != null) {
                try {
                    this.archivoLectura.close();
                } catch (IOException ioe) {
                    throw new IllegalStateException("Error al cerrar archivo");
                }
            }
        }

    }

}
