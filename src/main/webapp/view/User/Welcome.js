import React, {Component} from 'react';
import {Link} from 'react-router'

export default class Welcome extends Component {
    render() {
        return (
            <section>
                <h1>Hi there man</h1>
                <br/><br/>
                <span>If you want to start then click <Link to={"/firstPage"}>here</Link></span>
            </section>
        );
    }
}