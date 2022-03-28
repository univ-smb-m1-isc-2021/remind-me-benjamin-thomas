import React, {Component} from "react";
import CreateEvent from "./CreateEvent";
import Home from "./Home";

class Route extends Component {

    constructor(props) {
        super(props);
        this.state = {
            result: []
        }
        this.sceneRef = React.createRef();
    }

    componentDidMount() {
        const { location } = this.props;
        this.state.path = new URLSearchParams(location.pathname);
        this.routes = {
            "/react" : <Home/>,
            "/react/createEvent" : <CreateEvent/>,
        };
    }

    render() {
        return (
            <View>
                <p>
                    Bonjour
                </p>
            </View>
        );
    }
}

export default Route;
