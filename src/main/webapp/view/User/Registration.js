import React, {Component} from 'react';


export default class Registration extends Component {
    render() {
        return (
            <div>
                <h2>Registration</h2>
                <br/>
                <form action="api/registration" method="GET">
                    <label htmlFor="name">
                        First name*: <input type="text" id="name" required name="firstName"/>
                    </label>
                    <br/><br/>
                    <label htmlFor="surname">
                        Last name: <input type="text" id="surname" name="lastName"/>
                    </label>
                    <br/><br/>
                    <label htmlFor="email">
                        Email: <input type="text" id="email" name="email"/>
                    </label>
                    <br/><br/>
                    <label htmlFor="password">
                        Password*: <input type="password" required id="password" name="password"/>
                    </label>
                    <br/><br/>
                    <input type="submit" value="Submit"/>
                </form>
            </div>
        );
    }
}