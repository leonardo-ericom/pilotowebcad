function confirmar(id){
	
	let resposta = confirm ("Confirma a exclusão deste contato?")
	if (resposta === true){
		
		//alert (matricula)
		window.location.href="deleteCorrida?id=" + id
		
	}
	
}