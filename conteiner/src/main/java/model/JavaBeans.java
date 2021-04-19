package model;

public class JavaBeans {
	private String idcon;
	private String cliente;
	private String numcont;
	private String tipo;
	private String statu;
	private String categoria;

	public JavaBeans() {
		super();
	}

	public JavaBeans(String idcon, String cliente, String numcont, String tipo, String statu, String categoria) {
		super();
		this.idcon = idcon;
		this.cliente = cliente;
		this.numcont = numcont;
		this.tipo = tipo;
		this.statu = statu;
		this.categoria = categoria;
	}

	public String getIdcon() {
		return idcon;
	}

	public void setIdcon(String idcon) {
		this.idcon = idcon;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getNumcont() {
		return numcont;
	}

	public void setNumcont(String numcont) {
		this.numcont = numcont;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getStatu() {
		return statu;
	}

	public void setStatu(String statu) {
		this.statu = statu;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
