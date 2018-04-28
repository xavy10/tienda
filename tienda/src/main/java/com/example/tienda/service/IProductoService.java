package com.example.tienda.service;

import java.util.List;

import com.example.tienda.entity.Producto;

public interface IProductoService {
	
	List<Producto> ObtenerProductos();
	Producto obtenerProductoPorClave(int clave);
	void añadirProducto(Producto producto);
	void actualizarProducto(Producto producto);
	void borrarProducto(int clave);
	boolean existeProducto(String codigo,String nombre);

}
