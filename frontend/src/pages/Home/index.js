import React from 'react'

class Home extends React.Component {

    logout = () => {
        this.props.history.push('/')
    }
    render(){
        return (
            <div>
                <h1>Testando</h1>
                <button className="btn btn-primary" onClick={this.logout}>Logout</button>
            </div>
        )
    }
}

export default Home;