import React, {Component} from "react";

class Settings extends Component {

    constructor(props) {
        super(props);
        this.state = {
            result: [],
            notificationChannels: []
        }
    }

    componentDidMount() {
        const { location } = this.props;
        fetch("/api/get_notification_channels")
            .then(response => response.json())
            .then((data) => {
                this.setState({notificationChannels: data})
            });
    }

    deleteNotificationChannel(id){
        fetch("/api/delete_notification_channel?id="+id)
            .then(response => response)
            .then((data) => {
                console.log(data);
            });
        const data = this.state.notificationChannels.filter(i => i.id !== id)
        this.setState({notificationChannels: data})
    }

    addNotificationChannel(){
        var name = document.getElementById("name").value;
        var type = document.getElementById("type").value;
        var destination = document.getElementById("destination").value;

        fetch("/api/create_notification_channel?name=" + name + "&type=" + type + "&destination=" + destination)
            .then(response => response.json())
            .then((data) => {
                const tmp = this.state.notificationChannels;
                tmp.push(data);
                this.setState({notificationChannels: tmp});
            });
    }

    render() {
        return (
            <div>
                {this.state.notificationChannels.map(item => <div className="notification" id={"card_" + item["id"]}><p>Nom : {item["name"]}<br/>Type : {item["type"]}<br/>Destination : {item["destination"]}<br/><button onClick={() => this.deleteNotificationChannel(item["id"])}>Supprimer</button></p></div>)}
                <hr/>
                <div className="notificationAdd">
                    Nom : <input id="name" type="text"/><br/>
                    Type : <input id="type" type="text"/><br/>
                    Destination : <input id="destination" type="text"/><br/>
                    <button onClick={() => this.addNotificationChannel()}>Créer</button>
                </div>
            </div>
        );
    }
}

export default Settings;
