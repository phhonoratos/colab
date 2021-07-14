import Login from "components/Login";

function Home(){
    return (
        <div className="container">
            <div className="home-content">
                <h1>Olá Visitante!</h1>
                <Login />
            </div>
        </div>
    );
}

export default Home;