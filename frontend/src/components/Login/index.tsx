function Login() {
    return (
        <div className="card">
            <h5 className="card-header">Login</h5>
            <div className="card-body">
                <input className="form-control" type="text" placeholder="CPF ou PIS" />
                <input className="form-control mt-4" type="text" placeholder="senha" />
                <button className="btn btn-primary mt-4">Acessar</button>
                <div>OU</div>
                <h6>Crie uma conta</h6>
                <button className="btn btn-success">Cadastrar-se</button>
            </div>
        </div>
    );
}

export default Login;