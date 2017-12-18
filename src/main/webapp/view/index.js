import ReactDOM from 'react-dom';
import { Router, Route, hashHistory, IndexRoute } from 'react-router'

import App from "./App/App";
import UserPage from "./User/UserPage";
import Welcome from "./User/Welcome";
import Registration from "./User/Registration";
import Authorization from "./User/Authorization";

ReactDOM.render(
    <Router history={hashHistory}>
        <Route path="/" component={Welcome}/>
        <Route path="/firstPage" component={App}>
            <IndexRoute component={UserPage}/>
            <Route path="/firstPage/registration" component={Registration}/>
            <Route path="/firstPage/authorization" component={Authorization}/>
        </Route>
    </Router>,
    document.getElementById('root')
);