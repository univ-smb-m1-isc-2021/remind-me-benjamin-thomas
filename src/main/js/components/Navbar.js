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
            <div id="navBar">
                <ul>
                    <li>
                        <a href="/react/home">Home</a>
                    </li>
                    <li>
                        <a href="/react/settings">Manage Channels</a>
                    </li>
                </ul>
            </div>
        );
    }
}

export default Navbar;
