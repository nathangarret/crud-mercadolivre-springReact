import React from 'react'
import '../App.css';

import Logo from '../assets/logo.png';

export const Formulario = ({ botao, eventoTeclado, cadastrar, obj, cancelar, remover, alterar }) => {
    return (
        <div>
            <form>
                <img src={Logo} className='logo' />
                <label>Nome </label>
                <input type='text' value={obj.nome} onChange={eventoTeclado} name='nome' placeholder='Escreva o nome do produto' className='form-control' />
                <label>Marca </label>
                <input type='text' value={obj.marca} onChange={eventoTeclado} name='marca' placeholder='Escreva a marca do produto' className='form-control' />
                {
                    botao
                        ?
                        <input type='button' value='Cadastrar' onClick={cadastrar} className='btn btn-primary' />
                        :
                        <div>
                            <input type='button' value='Alterar' onClick={alterar} className='btn btn-warning' />
                            <input type='button' value='Remover' onClick={remover} className='btn btn-danger' />
                            <input type='button' value='Cancelar' onClick={cancelar} className='btn btn-secondary' />
                        </div>
                }
            </form>
        </div>
    )
}

export default Formulario;