import React, {Component} from "react";

class Navbar extends Component {

    constructor(props) {
        super(props);
        this.state = {
            result: []
        }
    }

    componentDidMount() {
        const { location } = this.props;
    }

    render() {
        return (
            <div>
                <ul>
                    <li>
                        <a href="/react/home">Home</a>
                    </li>
                    <li>
                        <a href="/react/createEvent">Create Event</a>
                    </li>
                    <li>
                        <a href="/react/reminders">My Reminders</a>
                    </li>
                    <li>
                        <a href="/react/parameters">Parameters</a>
                    </li>
                    <li>
                        <a href="/react/profile">Profile</a>
                    </li>
                </ul>
            </div>
        );
    }
}

export default Navbar;
