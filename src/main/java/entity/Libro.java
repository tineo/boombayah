package entity;

public class Libro {

	int id_libro;
	String codigoClasificacion;
	String Titulo;
	String formato;
	String isbn;
	String autor;
	String pieImprenta;
	int paginas;
	String descripcion;
	String idioma;
	int vistas;
	
	public int getCodigo_libro() {
		return id_libro;
	}
	public void setCodigo_libro(int codigo_libro) {
		id_libro = codigo_libro;
	}
	public String getCodigoClasificacion() {
		return codigoClasificacion;
	}
	public void setCodigoClasificacion(String codigoClasificacion) {
		this.codigoClasificacion = codigoClasificacion;
	}
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public String getFormato() {
		return formato;
	}
	public void setFormato(String formato) {
		this.formato = formato;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String iSBN) {
		isbn = iSBN;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getPieImprenta() {
		return pieImprenta;
	}
	public void setPieImprenta(String pieImprenta) {
		this.pieImprenta = pieImprenta;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public int getVistas() {
		return vistas;
	}
	public void setVistas(int vistas) {
		this.vistas = vistas;
	}
}
