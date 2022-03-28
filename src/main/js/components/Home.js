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
            <View>
                <p>
                    Hello home;
                </p>
            </View>
        );
    }
}

export default Home;
