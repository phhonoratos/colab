import LocalStorageService from 'app/service/localStorageService';
import axios from 'axios';
import Card from 'components/Card';
import React from 'react'

class Atualizar extends React.Component {
    
    state = {
        id: '',
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

    cancelar = () => {
        this.props.history.push('/home')
    }

    componentDidMount() {
        const usuarioLogado = LocalStorageService.obterItem(`_usuario_logado`)
        
        axios.get(`http://localhost:8080/colaborators/${usuarioLogado.id}`)
            .then(response => {
                this.setState({id: usuarioLogado.id})
                this.setState({nome: usuarioLogado.nome})
                this.setState({email: usuarioLogado.email})
                this.setState({pais: usuarioLogado.pais})
                this.setState({estado: usuarioLogado.estado})
                this.setState({municipio: usuarioLogado.municipio})
                this.setState({cep: usuarioLogado.cep})
                this.setState({rua: usuarioLogado.rua})
                this.setState({numero: usuarioLogado.numero})
                this.setState({complemento: usuarioLogado.complemento})
                this.setState({cpf: usuarioLogado.cpf})
                this.setState({pis: usuarioLogado.pis})
                this.setState({senha: usuarioLogado.senha})
                this.setState({senhaRepeticao: usuarioLogado.senhaRepeticao})
            }).catch(erro => {
                console.erro(erro.response)
            })
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
                msgs.push('Informe ou confirme a SENHA.')
            } else if(this.state.senha !== this.state.senhaRepeticao) {
                msgs.push('As SENHAS não conferem. Por favor digite novamente e confirme.')
            }
    
            return msgs;
        }
        
        atualizar = () => {
            const msgs = this.validar();

            if(msgs && msgs.length > 0) {
                msgs.forEach((msg, index) => {
                    alert(msg)
                });
                return false;
            }

            axios.put(`http://localhost:8080/colaborators/${this.state.id}`, {
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
            }).then( response => {
                LocalStorageService.addItem('_usuario_logado', response.data)
                alert('Usuário atualizado com sucesso')
                this.props.history.push('/home')
            }).catch( erro => {
                this.setState({msgErro: erro.response.data})
            })
    }
    
    removerCadastro = () => {
        axios.delete(`http://localhost:8080/colaborators/${this.state.id}`).then( response => {
            LocalStorageService.limparStorage();
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
                    <button className="btn btn-danger" onClick={this.removerCadastro}>Remover cadastro</button>
                    <button className="btn btn-primary" onClick={this.cancelar}>Cancelar</button>
                    <button className="btn btn-success" onClick={this.atualizar}>Atualizar</button>
                </Card>
            </div>
        )
    }    
}

export default Atualizar;