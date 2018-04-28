package com.example.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.tienda.entity.Producto;
import com.example.tienda.service.IProductoService;


@Controller
@RequestMapping(path="/tienda")
public class ProductoController {
	
	@Autowired
	private IProductoService productoService;

	@GetMapping(path="/agregar")
	public @ResponseBody String addNewProduct(@RequestParam String codigo,@RequestParam String nombre, @RequestParam float precio) {
		if(!productoService.existeProducto(codigo, nombre)) {
			Producto producto = new Producto();
			producto.setCodigo(codigo);
			producto.setNombre(nombre);
			producto.setPrecio(precio);
			productoService.añadirProducto(producto);
			return "El producto se agrego con exito";
		}else {
			return "Ya existe el producto";
		}
		
		
	}
	
	@GetMapping(path="/listar")
	public @ResponseBody Iterable<Producto> getAllProducts(){
		return productoService.ObtenerProductos();
	}
	
	@GetMapping(path="/eliminar")
	public @ResponseBody String deleteProduct(@RequestParam int clave){
		productoService.borrarProducto(clave);
		return "Se elimino con exito";
	}
	
	@GetMapping(path="/consultar")
	public @ResponseBody String getProduct(@RequestParam int clave) {
		Producto producto = productoService.obtenerProductoPorClave(clave);
		return producto.toString();
	}
	
	@GetMapping(path="/modificar")
	public @ResponseBody String modifyProduct(@RequestParam int clave,@RequestParam String codigo,@RequestParam String nombre,@RequestParam float precio) {
		Producto producto = productoService.obtenerProductoPorClave(clave);
		producto.setCodigo(codigo);
		producto.setNombre(nombre);
		producto.setPrecio(precio);
		productoService.actualizarProducto(producto);
		return "Se actualizo el producto";
	}
	
}
