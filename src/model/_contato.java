package model;

public class _contato {
	public _contato() {}
	private int _id;
	
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String get_nome() {
		return _nome;
	}
	public void set_nome(String _nome) {
		this._nome = _nome;
	}
	public String get_telefone() {
		return _telefone;
	}
	public void set_telefone(String _telefone) {
		this._telefone = _telefone;
	}
	public String get_endereco() {
		return _endereco;
	}
	public void set_endereco(String _endereco) {
		this._endereco = _endereco;
	}
	public String get_complemento() {
		return _complemento;
	}
	public void set_complemento(String _complemento) {
		this._complemento = _complemento;
	}
	public String get_cidade() {
		return _cidade;
	}
	public void set_cidade(String _cidade) {
		this._cidade = _cidade;
	}
	public String get_estado() {
		return _estado;
	}
	public void set_estado(String _estado) {
		this._estado = _estado;
	}
	private String _nome, _telefone, _endereco, _complemento, _cidade, _estado;
	
}
