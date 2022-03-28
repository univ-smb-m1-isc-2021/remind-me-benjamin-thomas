import React, {Component} from "react";

class CreateEvent extends Component {

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
                Hello event
            </div>
        );
    }
}

export default CreateEvent;
