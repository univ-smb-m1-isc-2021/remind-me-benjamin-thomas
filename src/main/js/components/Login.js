import React, {Component} from "react";

class Login extends Component {

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
                Hello Login
            </div>
        );
    }
}

export default Login;
