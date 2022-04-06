import React, {Component} from "react";
import Login from "./Login";
import Home from "./Home";
import Settings from "./Settings";

class Route extends Component {

    constructor(props) {
        super(props);
        this.state = {
            result: []
        }
        this.sceneRef = React.createRef();
        this.path = window.location.pathname;
        this.routes = {
            "/react/home" : <Home/>,
            "/react/login" : <Login/>,
            "/react/settings" : <Settings/>
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