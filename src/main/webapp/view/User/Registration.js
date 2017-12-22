import React, {Component} from 'react';

export default class Registration extends Component {
    constructor(props) {
        super(props);

        this.submitForm = this.submitForm.bind(this);
    }

    submitForm(e) {
        e.preventDefault();
        const { name, surname, email, password } = e.target;

        const formData = new FormData(e.target)

        fetch("./api/users", {
            method: "POST",
            body: formData,
        })
            .then((res) => location.replace('./#/firstPage/authorization'))
            .catch((ex) => console.error(ex.message));
    }

    render() {
        return (
            <div>
                <h2>Registration</h2>
                <br/>
                <form onSubmit={this.submitForm}>
                    <label htmlFor="name">
                        First name*: <input type="text" id="name" required name="firstName"/>
                    </label>
                    <br/><br/>
                    <label htmlFor="surname">
                        Last name: <input type="text" id="surname" name="lastName"/>
                    </label>
                    <br/><br/>
                    <label htmlFor="email">
                        Email: <input type="text" id="email" required name="email"/>
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