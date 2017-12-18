import React, {Component} from 'react';

import UserPage from '../User/UserPage';

export default class App extends Component {
    render() {
        return (
            <div>
                <header>
                    <h1>Authorization</h1>
                    <a href="#">Go to beginning</a>
                </header>
                <section>
                    {this.props.children}
                </section>
                <footer><h2>Footer</h2></footer>
            </div>
        );
    }
}