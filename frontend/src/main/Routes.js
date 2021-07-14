import Login from 'components/Login';
import Cadastro from 'pages/Cadastro';
import React from 'react';

import { Route, Switch, HashRouter } from 'react-router-dom';

function Routes() {
    return (
        <HashRouter>
            <Switch>
                <Route path="/login" component={Login} />
                <Route path="/cadastrar" component={Cadastro} />
            </Switch>
        </HashRouter>

    );
}

export default Routes;