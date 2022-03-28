import React, {Component} from "react";
import Navbar from "./components/Navbar";
import Route from "./components/Route";
import Home from "./components/Home";

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            result: []
        }
        this.sceneRef = React.createRef();
    }

    componentWillMount() {
        fetch("/react/data")
            .then(response => response.json())
            .then((data) => {
                this.setState({result: data})
            });
    }

    render() {
        return (
            <div>
                <Navbar/>
                <Route/>
            </div>
        );
    }
}

export default App;
