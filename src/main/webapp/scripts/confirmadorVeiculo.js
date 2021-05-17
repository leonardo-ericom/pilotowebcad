function confirmar(renavam){
	
	let resposta = confirm ("Confirma a exclusão deste contato?")
	if (resposta === true){
		
		//alert (renavam)
		window.location.href="deleteVeiculo?renavam=" + renavam
		
	}
	
}