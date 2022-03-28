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
        this.path = window.location.pathname;
        this.routes = {
            "/react" : <Home/>,
            "/react/createEvent" : <CreateEvent/>,
        };
    }

    render() {
        return (
            <div>
                {this.routes[this.path]}
            </div>
        );
    }
}

export default Route;