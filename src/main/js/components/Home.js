import React, {Component} from "react";

class Home extends Component {

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
                Hello home
            </div>
        );
    }
}

export default Home;
