import React from 'react'

class Home extends React.Component {

    atualizar = () => {
        this.props.history.push('/atualizar')
    }

    logout = () => {
        this.props.history.push('/')
    }

    render(){
        return (
            <div>
                <h1>Olá Visitante!</h1>
                <button className="btn btn-primary" onClick={this.atualizar}>Atualizar Dados</button>                
                <button className="btn btn-danger" onClick={this.logout}>Logout</button>
            </div>
        )
    }
}

export default Home;