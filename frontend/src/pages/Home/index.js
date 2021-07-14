import axios from 'axios'
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
        const usuarioLogadoString = localStorage.getItem('_usuario_logado')
        const usuarioLogado = JSON.parse(usuarioLogadoString)
        
        axios.get(`http://localhost:8080/colaborators/${usuarioLogado.id}`)
            .then(response => {
                this.setState({nome: usuarioLogado.nome})
            }).catch(erro => {
                console.erro(erro.response)
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