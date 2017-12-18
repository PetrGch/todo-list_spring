import React, {Component} from 'react';
import {Link} from 'react-router';

export default class UserPage extends Component {
    render() {
        return (
            <div>
                <div>
                    <Link to="/firstPage/registration">Registration</Link>
                </div>
                <div>
                    <Link to="/firstPage/authorization">Authorization</Link>
                </div>
            </div>
        );
    }
}