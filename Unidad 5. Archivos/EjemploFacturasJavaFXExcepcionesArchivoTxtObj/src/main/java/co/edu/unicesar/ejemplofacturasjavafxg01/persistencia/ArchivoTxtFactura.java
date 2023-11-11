/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicesar.ejemplofacturasjavafxg01.persistencia;

import co.edu.unicesar.ejemplofacturasjavafxg01.entidades.Factura;
import co.edu.unicesar.ejemplofacturasjavafxg01.entidades.FacturaContado;
import co.edu.unicesar.ejemplofacturasjavafxg01.entidades.FacturaCredito;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Jairo F
 */
public class ArchivoTxtFactura implements IFactura {

    private File archivo;
    private FileWriter archivoEscritura;
    private Scanner archivoLectura;

    public ArchivoTxtFactura() {
        this("Facturas.txt");
    }

    public ArchivoTxtFactura(String fileName) {
        this.archivo = new File(fileName);
    }

    @Override
    public void adicionarFactura(Factura f) {
        PrintWriter pw = null;
        try {
            this.archivoEscritura = new FileWriter(this.archivo, true);
            pw = new PrintWriter(this.archivoEscritura);
            pw.println(f.getDataForFileTxt());

        } catch (IOException ioe) {
            throw new IllegalStateException("Error al abrir archivo, o no existe");
        } finally {
            if (pw != null) {
                pw.close();
            }
        }

    }

    public Factura getDataFromFile(String datos[]) {

        Factura leida;
        int noFactura = Integer.valueOf(datos[1]);
        LocalDate fechaF = LocalDate.parse(datos[2]);
        double valorF = Double.valueOf(datos[3].replace(',', '.'));
        if (datos[0].equals("CO")) {
            char medioP = datos[4].charAt(0);
            LocalDate fechaP = LocalDate.parse(datos[5]);
            leida = new FacturaContado(medioP, fechaP, fechaF, valorF);
        } else {
            int plazo = Integer.valueOf(datos[4]);
            leida = new FacturaCredito(plazo, fechaF, valorF);
        }
        leida.setConsecutivo(noFactura);
        return leida;
    }

    @Override
    public ArrayList<Factura> obtenerfacturas() {
        try {
            this.archivoLectura = new Scanner(this.archivo);
            ArrayList<Factura> listaLeida = new ArrayList();
            while (this.archivoLectura.hasNext()) {
                String datos[] = this.archivoLectura.nextLine().split(";");
                Factura facturaLeida = this.getDataFromFile(datos);
                listaLeida.add(facturaLeida);
            }
            return listaLeida;

        } catch (FileNotFoundException fne) {
            throw new IllegalStateException("El archivo no se puede leer o no existe");
        } finally {
            if (this.archivoLectura != null) {
                this.archivoLectura.close();
            }
        }
    }

    @Override
    public ArrayList<Factura> obtenerfacturasCredito() {

        try {
            this.archivoLectura = new Scanner(this.archivo);
            ArrayList<Factura> listaLeida = new ArrayList();
            while (this.archivoLectura.hasNext()) {
                String datos[] = this.archivoLectura.nextLine().split(";");
                if (datos[0].equals("CR")) {
                    Factura facturaLeida = this.getDataFromFile(datos);
                    listaLeida.add(facturaLeida);
                }
            }
            return listaLeida;

        } catch (FileNotFoundException fne) {
            throw new IllegalStateException("El archivo no se puede leer o no existe");
        } finally {
            if (this.archivoLectura != null) {
                this.archivoLectura.close();
            }
        }

    }

    @Override
    public ArrayList<Factura> obtenerfacturasContado() {
          try {
            this.archivoLectura = new Scanner(this.archivo);
            ArrayList<Factura> listaLeida = new ArrayList();
            while (this.archivoLectura.hasNext()) {
                String datos[] = this.archivoLectura.nextLine().split(";");
                if (datos[0].equals("CO")) {
                    Factura facturaLeida = this.getDataFromFile(datos);
                    listaLeida.add(facturaLeida);
                }
            }
            return listaLeida;

        } catch (FileNotFoundException fne) {
            throw new IllegalStateException("El archivo no se puede leer o no existe");
        } finally {
            if (this.archivoLectura != null) {
                this.archivoLectura.close();
            }
        }
    }

    @Override
    public Factura buscarFactura(int noFactura) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
