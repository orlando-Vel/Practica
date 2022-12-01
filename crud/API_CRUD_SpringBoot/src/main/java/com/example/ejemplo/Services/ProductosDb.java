package com.example.ejemplo.Services;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.ejemplo.Models.Productos;

public class ProductosDb {
    Connection _cn;

    public ProductosDb(){
        _cn = new Conexion().openDb();
    }

    public List<Productos> ObtenerProductos(){
        try {
            Statement stmt = _cn.createStatement();
            String query = "SELECT * FROM productos";

            List<Productos> productos = new ArrayList<>();
            ResultSet result = stmt.executeQuery(query);
            while(result.next()){
                Productos producto = new Productos(
                    result.getString("nombre"),
                    result.getFloat("precio"),
                    result.getString("foto"),
                    result.getInt("id"),
                    result.getInt("cantidad")
                );

                productos.add(producto);
            }

            result.close();
            stmt.close();
            return productos;

        } catch (Exception e) {
            int x=1;
            System.out.println("Error:"+e);
        }

        return null;
    }

    public int GuardarProductos(Productos producto){
        int resultado = 0;
        try {
            Statement stm = _cn.createStatement();
            String query = "Call InsertarProd('"
            +producto.getNombre()+"',"
            +producto.getPrecio()+
            ",'"+producto.getFoto()+"',"
            +producto.getId()+","
            +producto.getCantidad()+")";

            resultado = stm.executeUpdate(query);

            return resultado;
        } catch (Exception e) {
            System.out.println("Hola soy un error "+e);
            int x=1;
        }
        return resultado;
    }

    public int EliminarProducto(int pid){
        int resultado = 0;
        try {
            Statement stmt = _cn.createStatement();
            String query = "Call EliminarProd("+ pid +")";

            resultado = stmt.executeUpdate(query);
            return resultado;
        } catch (Exception e) {
            int x=1;
        }
        return resultado;
    }

    public int ActualizarProductos(Productos producto){
        int resultado = 0;
        try {
            Statement stm = _cn.createStatement();
            String query = "Call ActualizarProd('"
            +producto.getNombre()+"',"
            +producto.getPrecio()+",'"
            +producto.getFoto()+"',"
            +producto.getId()+","
            +producto.getCantidad()+")";

            resultado = stm.executeUpdate(query);

            return resultado;
        } catch (Exception e) {
            System.out.println("Hola soy un error "+e);
            int x=1;
        }
        return resultado;
    }
}
