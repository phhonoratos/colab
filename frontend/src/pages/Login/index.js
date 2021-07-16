import React from 'react'
import Card from 'components/Card'
import axios from 'axios'
import LocalStorageService from 'app/service/localStorageService'
import './styles.css'

class Login extends React.Component {

    state = {
        email: "",
        senha: "",
        msgErro: null
    }

    entrar = () => {
        axios.post('http://localhost:8080/login', {
            email: this.state.email,
            senha: this.state.senha
        }).then( response => {
            // LocalStorageService.addItem('_usuario_logado', response.data)
            console.log("aaaaaaaaaaaa", response.data)
            this.props.history.push('/home')
        }).catch( erro => {
            // this.setState({msgErro: erro.response.data})
            console.log(erro.response)
        })
    }

    Cadastrar = () => {
        this.props.history.push('/cadastrar')
    }

    render() {
        return (
            <div className="container">
                <div className="home-content">
                    <h3 className="mt-3">Olá Visitante!</h3>
                    <Card title="Login" className="card">
                        <div>
                            <span>{this.state.msgErro}</span>
                        </div>
                    <fieldset>
                        <div className="form-group mt-4">
                            <input type="text" 
                                value={this.state.email}
                                onChange={e => this.setState({email: e.target.value})}
                                className="form-control" 
                                placeholder="Digite o CPF ou o PIS" />
                        </div>
                        <div className="form-group mt-4">
                            <input type="password" 
                                value={this.state.senha}
                                onChange={e => this.setState({senha: e.target.value})}
                                className="form-control" 
                                placeholder="Password" />
                        </div>
                    </fieldset>
                    <div className="botoes">
                        <button className="btn btn-success" onClick={this.entrar}>Entrar</button>
                        <h5 className="mt-4">OU</h5>
                        <button className="btn btn-danger" onClick={this.Cadastrar}>Cadastre-se</button>
                    </div>
                </Card>
                </div>
            </div>
        );
    }
}

export default Login;