import React, {Component} from "react";
import Panel from "./components/Panel";
import BoardWrapper from "./components/BoardWrapper";
import Navbar from "./components/Navbar";
import Route from "./components/Route";

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
            </div>
        );
    }
}

export default App;
