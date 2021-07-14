import React from 'react';
import Cadastro from 'pages/Cadastro';
import Home from 'pages/Home';

import { Route, Switch, BrowserRouter } from 'react-router-dom';

function Routes() {
    return (
        <BrowserRouter>
            <Switch>
                <Route path="/" component={Home} exact />
                <Route path="/cadastrar" component={Cadastro} />
            </Switch>
        </BrowserRouter>

    );
}

export default Routes;