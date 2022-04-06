import React, {Component} from "react";

class Settings extends Component {

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
                Hello Settings
            </div>
        );
    }
}

export default Settings;
