package es.lsi.practica02.AcmeBay;

import java.util.Random;

public class Producto implements Comparable<Producto>, Cloneable {

	private Float precio;
	private Integer referencia;

	public Producto(Integer referencia, Float precio) {
		super();
		this.precio = precio;
		this.referencia = referencia;
	}

	public Producto(Producto original) {
		super();
		this.precio = original.precio;
		this.referencia = original.referencia;
	}

	public Float getPrecio() {
		return precio;
	}

	public Integer getReferencia() {
		return referencia;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto [precio=" + precio + ", referencia=" + referencia
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((referencia == null) ? 0 : referencia.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (referencia == null) {
			if (other.referencia != null)
				return false;
		} else if (!referencia.equals(other.referencia))
			return false;
		return true;
	}

	public static Integer getReferenciaAleatoria() {
		Random r = new Random();
		return Math.abs(r.nextInt());
	}

	@Override
	public int compareTo(Producto producto) {
		return this.getPrecio().compareTo(producto.getPrecio());
	}

}
