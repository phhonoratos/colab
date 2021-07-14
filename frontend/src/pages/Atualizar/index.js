import axios from 'axios';
import Card from 'components/Card';
import React from 'react'

class Atualizar extends React.Component {
    
    state = {
        nome: '',
        email: '',
        pais: '',
        estado: '',
        municipio: '',
        cep: '',
        rua: '',
        numero: '',
        complemento: '',
        cpf: '',
        pis: '',
        senha: '',
        senhaRepeticao: ''
    }

    atualizar = () => {
        alert('Usuario atualizado')
        this.props.history.push('/home')
    }
    
    removerCadastro = () => {
        axios.delete('http://localhost:8080/colaborators/3').then( response => {
            this.props.history.push('/')
            console.log(response)
        })
    }

    render(){
        return (
            <div>
                <Card title="Atualização dos dados cadastrais">
                    <div className="form-group mt-4">
                        <input type="text"
                            value={this.state.nome}
                            onChange={e => this.setState({ nome: e.target.value })}
                            className="form-control"
                            placeholder="Nome completo"
                            name="nome" />
                    </div>
                    <div className="form-group mt-4">
                        <input type="text"
                            value={this.state.email}
                            onChange={e => this.setState({ email: e.target.value })}
                            className="form-control"
                            placeholder="Email"
                            name="email" />
                    </div>
                    <div className="form-group mt-4">
                        <input type="text"
                            value={this.state.cep}
                            onChange={e => this.setState({ cep: e.target.value })}
                            className="form-control"
                            placeholder="CEP"
                            name="cep" />
                    </div>
                    <div className="form-group mt-4">
                        <input type="text"
                            value={this.state.rua}
                            onChange={e => this.setState({ rua: e.target.value })}
                            className="form-control"
                            placeholder="Logradouro / Rua"
                            name="rua" />
                    </div>
                    <div className="form-group mt-4">
                        <input type="text"
                            value={this.state.numero}
                            onChange={e => this.setState({ numero: e.target.value })}
                            className="form-control"
                            placeholder="Número"
                            name="numero" />
                    </div>
                    <div className="form-group mt-4">
                        <input type="text"
                            value={this.state.complemento}
                            onChange={e => this.setState({ complemento: e.target.value })}
                            className="form-control"
                            placeholder="Complemento"
                            name="complemento" />
                    </div>
                    <div className="form-group mt-4">
                        <input type="text"
                            value={this.state.municipio}
                            onChange={e => this.setState({ municipio: e.target.value })}
                            className="form-control"
                            placeholder="Cidade"
                            name="municipio" />
                    </div>
                    <div className="form-group mt-4">
                        <input type="text"
                            value={this.state.estado}
                            onChange={e => this.setState({ estado: e.target.value })}
                            className="form-control"
                            placeholder="UF / Estado"
                            name="estado" />
                    </div>
                    <div className="form-group mt-4">
                        <input type="text"
                            value={this.state.pais}
                            onChange={e => this.setState({ pais: e.target.value })}
                            className="form-control"
                            placeholder="País"
                            name="pais" />
                    </div>
                    <div className="form-group mt-4">
                        <input type="text"
                            value={this.state.cpf}
                            onChange={e => this.setState({ cpf: e.target.value })}
                            className="form-control"
                            placeholder="CPF"
                            name="cpf" />
                    </div>
                    <div className="form-group mt-4">
                        <input type="text"
                            value={this.state.pis}
                            onChange={e => this.setState({ pis: e.target.value })}
                            className="form-control"
                            placeholder="PIS"
                            name="pis" />
                    </div>
                    <div className="form-group mt-4">
                        <input type="text"
                            value={this.state.senha}
                            onChange={e => this.setState({ senha: e.target.value })}
                            className="form-control"
                            placeholder="Senha"
                            name="senha" />
                    </div>
                    <div className="form-group mt-4">
                        <input type="text"
                            value={this.state.senhaRepeticao}
                            onChange={e => this.setState({ senhaRepeticao: e.target.value })}
                            className="form-control"
                            placeholder="Confirme a senha"
                            name="senha" />
                    </div>
                    <button className="btn btn-danger" onClick={this.removerCadastro}>Remover cadastro</button>
                    <button className="btn btn-primary" onClick={this.atualizar}>Atualizar</button>
                </Card>
            </div>
        )
    }    
}

export default Atualizar;