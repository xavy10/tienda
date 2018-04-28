package com.example.tienda.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.tienda.entity.Producto;

@Transactional
@Repository
public class ProductoDAO implements IProductoDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Producto> ObtenerProductos() {
		String setencia = "from Producto as prod order by prod.nombre";
		return (List<Producto>) entityManager.createQuery(setencia).getResultList();
	}

	@Override
	public Producto obtenerProductoPorClave(int clave) {
		return entityManager.find(Producto.class, clave);
	}

	@Override
	public void añadirProducto(Producto producto) {
		entityManager.persist(producto);
	}

	@Override
	public void actualizarProducto(Producto producto) {
		Producto prod = obtenerProductoPorClave(producto.getProductoId());
		prod.setCodigo(producto.getCodigo());
		prod.setNombre(producto.getNombre());
		prod.setPrecio(producto.getPrecio());
		entityManager.flush();
	}

	@Override
	public void borrarProducto(int clave) {
		entityManager.remove(obtenerProductoPorClave(clave));
	}

	@Override
	public boolean existeProducto(String codigo, String nombre) {
		String sentencia = "FROM Producto as prod WHERE prod.codigo = ? and prod.nombre = ?";
		int contador = entityManager.createQuery(sentencia).setParameter(0, codigo).setParameter(1, nombre).getResultList().size();
		return contador > 0 ? true : false;
	}

}
