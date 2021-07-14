import Login from "components/Login";
import Cadastro from "pages/Cadastro";

function Home(){
    return (
        <div className="container">
            <div className="home-content">
                <h1>Olá Visitante!</h1>
                <Login />
                <Cadastro />
            </div>
        </div>
    );
}

export default Home;