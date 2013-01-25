/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.osbosoftware.pruebas;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.osbosoftware.facturas.CodigoControl7;
import org.osbosoftware.facturas.core.AllegedRC4;
import org.osbosoftware.facturas.core.Base64;
import org.osbosoftware.facturas.core.Verhoeff;

/**
 *
 * @author joaquin
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            long nuevo = 204986118;
            Base64 b = new Base64(nuevo);
            System.out.println(nuevo + " en 64 " + b.getResultado());
            AllegedRC4 o = new AllegedRC4();
            System.out.println(o.encripta("18isw", "9rCB7Sv4X29d)5k7N%3ab89p-3(5[A71621"));
            Verhoeff v = new Verhoeff();
            System.out.println(v.obtener("1503"));
            // ejemplo de codigo de generacion
            CodigoControl7 cc7 = new CodigoControl7();
            cc7.setNumeroAutorizacion("29040011007");
            cc7.setNumeroFactura(1503);
            cc7.setNitci("4189179011");
            Date fecha = new Date();
            String formato = "yyyyMMdd";
            SimpleDateFormat sdf = new SimpleDateFormat(formato);
            fecha = sdf.parse("20070702");
            cc7.setFechaTransaccion(fecha);
            cc7.setMonto(2500);
            cc7.setLlaveDosificacion("9rCB7Sv4X29d)5k7N%3ab89p-3(5[A");
            System.out.println("resultado:"+cc7.obtener());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
