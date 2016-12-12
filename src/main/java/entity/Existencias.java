package entity;

public class Existencias{
	int id_Existencias;
	String codigoLibro;
	String ubicacion;
	String estado;
	String tipoPrestamo;

	public int getId_Existencias() {
		return id_Existencias;
	}

	public void setId_Existencias(int id_Existencias) {
		id_Existencias = id_Existencias;
	}

	public String getCodigoLibro() {
		return codigoLibro;
	}

	public void setCodigoLibro(String codigoLibro) {
		this.codigoLibro = codigoLibro;
	}




	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipoPrestamo() {
		return tipoPrestamo;
	}

	public void setTipoPrestamo(String tipoPrestamo) {
		this.tipoPrestamo = tipoPrestamo;
	}
}