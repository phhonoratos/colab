import LocalStorageService from 'app/service/localStorageService';
import axios from 'axios';
import React from 'react'

class Home extends React.Component {

    state = {
        nome: ''
    }

    atualizar = () => {
        this.props.history.push('/atualizar')
    }

    logout = () => {
        this.props.history.push('/')
        localStorage.clear();
    }

    componentDidMount() {
        const usuarioLogado = LocalStorageService.obterItem('_usuario_logado')
        
        axios.get(`http://localhost:8080/colaborators/1`)
            .then(response => {
                this.setState({nome: response.data.nome})
            }).catch(erro => {
                console.log('errooooo', erro.response)
            })
    }

    render(){
        return (
            <div>
                <h1>Olá {this.state.nome}!</h1>
                <button className="btn btn-primary" onClick={this.atualizar}>Atualizar Dados</button>                
                <button className="btn btn-danger" onClick={this.logout}>Logout</button>
            </div>
        )
    }
}

export default Home;