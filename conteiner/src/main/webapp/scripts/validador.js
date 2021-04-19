/**
 * Validação de formulário
 * @author Fabrício E. Costa
 */

function validar() {
	let cliente = frmConteiner.cliente.value
	let numero = frmConteiner.numero.value
	let tipo = frmConteiner.tipo.value
	let status = frmConteiner.status.value
	let categoria = frmConteiner.categoria.value
	if (cliente === "") {
		alert('Preencha o campo Cliente')
		frmConteiner.cliente.focus()
		return false
	}
	else if (numero === "") {
		alert('Preencha o campo Número')
		frmConteiner.numero.focus()
		return false
	}
	else if (tipo === "") {
		alert('Preencha o campo Tipo')
		frmConteiner.tipo.focus()
		return false
	}
	else if (status === "") {
		alert('Preencha o campo Status')
		frmConteiner.status.focus()
		return false
	}
	else if (categoria === "") {
		alert('Preencha o campo Categoria')
		frmConteiner.categoria.focus()
		return false
	}
	else {
		document.forms["frmConteiner"].submit()
	}

}