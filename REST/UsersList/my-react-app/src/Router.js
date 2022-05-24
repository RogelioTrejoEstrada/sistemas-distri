import React, { Component } from 'react';
import { BrowserRouter, Route, Switch, Redirect } from 'react-router-dom';

// Importar componentes
import Error from './components/Error';
import Home from './components/Home';
import Create from './components/Create';
import Edit from './components/Edit';



class Router extends Component {

    render() {
        return (
            <BrowserRouter>

                {/* <Header /> */}

                {/* CONFIGURAR RUTAS Y PÁGINAS */}
                <Switch>
                    <Route exact path="/" component={Home} />
                    <Route exact path="/create" component={Create} />
                    <Route exact path="/edit/:id" component={Edit} />
                    <Route component={Error} />
                </Switch>

                <div className="clearfix"></div>
                {/* <Footer /> */}
            </BrowserRouter>
        );
    }
}

export default Router;