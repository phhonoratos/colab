import Card from 'components/Card'
import React from 'react'

class Home extends React.Component {

    state = {
        email: "",
        senha: ""
    }

    entrar = () => {
        console.log('Email: ', this.state.email)
        console.log('Senha: ', this.state.senha)
    }

    Cadastrar = () => {
        this.props.history.push('/cadastrar')
    }

    render() {
        return (
            <div className="container">
                <div className="home-content">
                    <h1>Olá Visitante!</h1>
                    <Card title="Login">
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
                    <button className="btn btn-success mt-4" onClick={this.entrar}>Entrar</button>
                    <div>OU</div>
                    <button className="btn btn-danger mt-2" onClick={this.Cadastrar}>Cadastre-se</button>
                </Card>
                </div>
            </div>
        );
    }
}

export default Home;