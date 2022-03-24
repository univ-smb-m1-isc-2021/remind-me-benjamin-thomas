import React, {Component} from "react";
import Panel from "./components/Panel";
import BoardWrapper from "./components/BoardWrapper";

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

    onClickFloppa(event){
        console.log("floppa");
    }

    onClickSogga(event){
        console.log("sogga");
    }

    render() {
        return (
            <div>
                <div><div onClick={(event) => this.onClickFloppa(event)}>Hello Floppa</div><div onClick={(event) => this.onClickSogga(event)}>Hello Sogga</div></div>
                <div ref={this.sceneRef}>
                    ...
                </div>
            </div>
        );
    }
}

export default App;
