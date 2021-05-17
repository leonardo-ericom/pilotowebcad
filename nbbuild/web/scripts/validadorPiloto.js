/**
 * 
 */

function validar(){
	

	let nome=frmCadastro.nome.value
	let pais=frmCadastro.pais.value
	let idade=frmCadastro.idade.value
	let equipe=frmCadastro.equipe.value
	let fabricante=frmCadastro.fabricante.value
	let pontos=frmCadastro.pontos.value

	
if(nome=== "" ){
	
	alert('Preencha o campo nome!')
	frmCadastro.nome.focus()
	return  false
	
}	else if (pais === ""){
	
	alert('Preencha o campo pais!')
	frmCadastro.pais.focus()
	return  false
	
}   else if(idade ===""){
	alert('Preencha o campo idade!')
	frmCadastro.idade.focus()
	return  false

}	else if (equipe === ""){
	alert('Preencha o campo equipe!')
	frmCadastro.equipe.focus()
	return  false
	
}   else if(fabricante ===""){

	alert('Preencha o campo fabricante!')
	frmCadastro.fabricante.focus()
	return  false
}	else if (pontos === ""){
	
	alert('Preencha o campo pontos!')
	frmCadastro.pontos.focus()
	return  false
	
	
	}else{
	
document.forms["frmCadastro"].submit()
}
}
