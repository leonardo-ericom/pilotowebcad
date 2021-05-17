/**
 * 
 */

function validar() {

    let nomecorrida = frmCadastro.nomecorrida.value
    let data = frmCadastro.data.value
    let hora = frmCadastro.hora.value
    let circuito = frmCadastro.circuito.value

    if (nomecorrida === "") {
        alert('Preencha o campo Nome Corrida!')
        frmCadastro.nomecorrida.focus()
        return  false
    }
    else if (data === "") {

        alert('Preencha o campo Data!')
        frmCadastro.data.focus()
        return  false

    } else if (hora === "") {

        alert('Preencha o campo hora!')
        frmCadastro.hora.focus()
        return  false



    } else if (circuito === "") {
        alert('Preencha o campo circuito!')
        frmCadastro.circuito.focus()
        return  false


    } else {

        document.forms["frmCadastro"].submit()
    }
}
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


