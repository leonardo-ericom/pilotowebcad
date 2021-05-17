/**
 * 
 */

function validar(){
	

	let renavam=frmCadastro.renavam.value
	let marca=frmCadastro.marca.value
	let modelo=frmCadastro.modelo.value
	let cor=frmCadastro.cor.value
	let placa=frmCadastro.placa.value
	let anoFabricacao=frmCadastro.anoFabricacao.value
	let categoria=frmCadastro.categoria.value
	let combustivel=frmCadastro.combustivel.value
	let kilometragem=frmCadastro.kilometragem.value

	
if(renavam=== "" ){
	
	alert('Preencha o campo Renavam!')
	frmCadastro.renavam.focus()
	return  false
	
}	else if (marca === ""){
	
	alert('Preencha o campo Marca!')
	frmCadastro.marca.focus()
	return  false
	
}   else if(modelo ===""){
	alert('Preencha o campo Modelo!')
	frmCadastro.modelo.focus()
	return  false

}	else if (cor === ""){
	alert('Preencha o campo cor!')
	frmCadastro.cor.focus()
	return  false
	
}   else if(placa ===""){

	alert('Preencha o campo Placa!')
	frmCadastro.placa.focus()
	return  false
}	else if (anoFabricacao === ""){
	
	alert('Preencha o campo Ano Fabricação!')
	frmCadastro.anoFabricacao.focus()
	return  false
	
}	else if (categoria === ""){
	
	alert('Preencha o campo Categoria!')
	frmCadastro.categoria.focus()
	return  false
	
}	else if (combustivel === ""){
	
	alert('Preencha o campo Combustivel!')
	frmCadastro.combustivel.focus()
	return  false
	
}	else if (kilometragem === ""){
	
	alert('Preencha o campo Kilometragem!')
	frmCadastro.kilometragem.focus()
	return  false	
	}else{
	
document.forms["frmCadastro"].submit()
}
}
