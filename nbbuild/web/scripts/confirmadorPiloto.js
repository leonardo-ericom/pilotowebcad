
function confirmar(matricula){
	
	let resposta = confirm ("Confirma a exclusão deste contato?")
	if (resposta === true){
		
		//alert (matricula)
		window.location.href="deletePiloto?matricula=" + matricula
		
	}
	
}