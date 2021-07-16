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
        const emailAutenticado = LocalStorageService.obterItem('email')
        axios.post('http://localhost:8080/colaborators/acessar', {
            email: emailAutenticado
        }).then( response => {
            LocalStorageService.addItem('_usuario_logado', response.data)
            axios.get(`http://localhost:8080/colaborators/${response.data.id}`)
            .then(response => {
                this.setState({nome: response.data.nome})
            }).catch(erro => {
                console.log('errooooo', erro.response)
            })
        }).catch( erro => {
            // this.setState({msgErro: erro.response.data})
            console.log(erro.response)
        })
    }

    render(){
        return (
            <div>
                <h1>Olá {this.state.nome}!</h1>
                <div className="d-flex flex-column">
                    <button className="btn btn-primary" onClick={this.atualizar}>Atualizar Dados</button>                
                    <button className="btn btn-danger" onClick={this.logout}>Logout</button>
                </div>
            </div>
        )
    }
}

export default Home;