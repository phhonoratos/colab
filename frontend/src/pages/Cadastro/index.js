import React from 'react';
import Card from 'components/Card';
import { withRouter} from 'react-router-dom';
import axios from 'axios';

class Cadastro extends React.Component {

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
        senhaRepeticao: '',
        msgErro: null
    }

    validar(){
        const msgs = [];

        if(!this.state.nome){
            msgs.push('O campo NOME é obrigatório.')
        }

        if(!this.state.email) {
            msgs.push('O campo EMAIL é obrigatório.')
        } else if(!this.state.email.match(/^[a-z0-9.]+@[a-z0-9]+\.[a-z]/)) {
            msgs.push('Informe um EMAIL válido.')
        }

        if(!this.state.cep) {
            msgs.push('O campo CEP é obrigatório.')
        }

        if(!this.state.numero) {
            msgs.push('O campo NÚMERO é obrigatório.')
        }

        if(!this.state.cpf) {
            msgs.push('O campo CPF é obrigatório.')
        }

        if(!this.state.pis) {
            msgs.push('O campo PIS é obrigatório.')
        }

        if(!this.state.senha || !this.state.senhaRepeticao) {
            msgs.push('Informe a SENHA 2x.')
        } else if(this.state.senha !== this.state.senhaRepeticao) {
            msgs.push('As SENHAS não conferem. Por favor digite novamente e confirme.')
        }

        return msgs;
    }

    cadastrar = () => {
        const msgs = this.validar();

        if(msgs && msgs.length > 0) {
            msgs.forEach((msg, index) => {
                alert(msg)
            });
            return false;
        }

        axios.post('http://localhost:8080/colaborators', {
            nome: this.state.nome,
            email: this.state.email,
            pais: this.state.pais,
            estado: this.state.estado,
            municipio: this.state.municipio,
            cep: this.state.cep,
            rua: this.state.rua,
            numero: this.state.numero,
            complemento: this.state.complemento,
            cpf: this.state.cpf,
            pis: this.state.pis,
            senha: this.state.senha,
            senhaRepeticao: this.state.senhaRepeticao
        }).then(response => {
            alert('Cadastro realizado com sucesso!')
            this.props.history.push('/')
        }).catch( erro => {
            this.setState({msgErro: erro.response})
        })
    }

    cancelar = () => {
        this.props.history.push('/')
    }

    render() {
        return (
            <div className="container">
                <Card title="Cadastro de colaborador">
                    <div className="form-group mt-4">
                        <input type="text"
                            value={this.state.nome}
                            onChange={e => this.setState({ nome: e.target.value })}
                            className="form-control"
                            placeholder="Nome completo" />
                    </div>
                    <div className="form-group mt-4">
                        <input type="email"
                            value={this.state.email}
                            onChange={e => this.setState({ email: e.target.value })}
                            className="form-control"
                            placeholder="Email" />
                    </div>
                    <div className="form-group mt-4">
                        <input type="number"
                            value={this.state.cep}
                            onChange={e => this.setState({ cep: e.target.value })}
                            className="form-control"
                            placeholder="CEP (somente números)" />
                    </div>
                    <div className="form-group mt-4">
                        <input type="text"
                            value={this.state.rua}
                            onChange={e => this.setState({ rua: e.target.value })}
                            className="form-control"
                            placeholder="Logradouro / Rua" />
                    </div>
                    <div className="form-group mt-4">
                        <input type="number"
                            value={this.state.numero}
                            onChange={e => this.setState({ numero: e.target.value })}
                            className="form-control"
                            placeholder="Número" />
                    </div>
                    <div className="form-group mt-4">
                        <input type="text"
                            value={this.state.complemento}
                            onChange={e => this.setState({ complemento: e.target.value })}
                            className="form-control"
                            placeholder="Complemento" />
                    </div>
                    <div className="form-group mt-4">
                        <input type="text"
                            value={this.state.municipio}
                            onChange={e => this.setState({ municipio: e.target.value })}
                            className="form-control"
                            placeholder="Cidade" />
                    </div>
                    <div className="form-group mt-4">
                        <input type="text"
                            value={this.state.estado}
                            onChange={e => this.setState({ estado: e.target.value })}
                            className="form-control"
                            placeholder="UF / Estado" />
                    </div>
                    <div className="form-group mt-4">
                        <input type="text"
                            value={this.state.pais}
                            onChange={e => this.setState({ pais: e.target.value })}
                            className="form-control"
                            placeholder="País" />
                    </div>
                    <div className="form-group mt-4">
                        <input type="number"
                            value={this.state.cpf}
                            onChange={e => this.setState({ cpf: e.target.value })}
                            className="form-control"
                            placeholder="CPF (somente números)" />
                    </div>
                    <div className="form-group mt-4">
                        <input type="number"
                            value={this.state.pis}
                            onChange={e => this.setState({ pis: e.target.value })}
                            className="form-control"
                            placeholder="PIS (somente números)" />
                    </div>
                    <div className="form-group mt-4">
                        <input type="password"
                            value={this.state.senha}
                            onChange={e => this.setState({ senha: e.target.value })}
                            className="form-control"
                            placeholder="Senha" />
                    </div>
                    <div className="form-group mt-4">
                        <input type="password"
                            value={this.state.senhaRepeticao}
                            onChange={e => this.setState({ senhaRepeticao: e.target.value })}
                            className="form-control"
                            placeholder="Confirme a senha" />
                    </div>
                    <button className="btn btn-danger mt-4" onClick={this.cancelar}>Cancelar</button>
                    <button className="btn btn-success mt-4" onClick={this.cadastrar}>Cadastrar</button>
                </Card>
            </div>
        )
    }
}

export default withRouter(Cadastro);