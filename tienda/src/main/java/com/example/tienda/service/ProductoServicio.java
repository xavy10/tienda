package com.example.tienda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tienda.dao.IProductoDAO;
import com.example.tienda.entity.Producto;

@Service
public class ProductoServicio implements IProductoService {
	
	@Autowired
	private IProductoDAO productoDAO;

	@Override
	public List<Producto> ObtenerProductos() {
		return productoDAO.ObtenerProductos();
	}

	@Override
	public Producto obtenerProductoPorClave(int clave) {
		return productoDAO.obtenerProductoPorClave(clave);
	}

	@Override
	public synchronized void añadirProducto(Producto producto) {
		productoDAO.añadirProducto(producto);
	}

	@Override
	public void actualizarProducto(Producto producto) {
		productoDAO.actualizarProducto(producto);
	}

	@Override
	public void borrarProducto(int clave) {
		productoDAO.borrarProducto(clave);
	}

	@Override
	public boolean existeProducto(String codigo, String nombre) {
		return productoDAO.existeProducto(codigo, nombre);
	}

}
