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
            <View>
                <p>
                    Hello event;
                </p>
            </View>
        );
    }
}

export default CreateEvent;
