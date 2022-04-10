import React, {Component} from "react";

class Home extends Component {

    constructor(props) {
        super(props);
        this.state = {
            notifications: [],
            notificationChannels: []
        }
    }

    componentDidMount() {
        const { location } = this.props;
        fetch("/api/get_notification")
            .then(response => response.json())
            .then((data) => {
                this.setState({notifications: data})
            });
        fetch("/api/get_notification_channels")
            .then(response => response.json())
            .then((data) => {
                this.setState({notificationChannels: data})
            });
    }

    reformatDate(dateStr)
    {
        const dArr = dateStr.split("-");  // ex input "2010-01-18"
        return dArr[2]+ "/" +dArr[1]+ "/" +dArr[0]; //ex out: "18/01/10"
    }

    deleteNotification(id){
        fetch("/api/delete_notification?id="+id)
            .then(response => response)
            .then((data) => {
                console.log(data);
            });
        const data = this.state.notifications.filter(i => i.id !== id)
        this.setState({notifications: data})
    }

    addNotification(){
        var name = document.getElementById("name").value;
        var description = document.getElementById("description").value;
        var date = this.reformatDate(document.getElementById("date").value);
        var repeat = document.getElementById("repeat").value;
        var frequence = document.getElementById("frequence").value;

        fetch("/api/create_notification?name=" + name + "&description=" + description + "&date=" + date + "&repeat=" + repeat + "&frequence=" + frequence + "")
            .then(response => response.json())
            .then((data) => {
                const tmp = this.state.notifications;
                tmp.push(data);
                this.setState({notifications: tmp});
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
                {this.state.notifications.map(item => <div id={"card_" + item["id"]}><p>Nom : {item["name"]}<br/>Description : {item["description"]}<br/>Date : {item["date"]}<br/>Repetition : {item["repeat"]}<br/>Fréquence de repetition : {item["frequence"]}<br/><button onClick={() => this.deleteNotification(item["id"])}>Supprimer</button></p></div>)}
                <hr/>
                <div>
                    Nom : <input id="name" type="text"/><br/>
                    Description : <input id="description" type="text"/><br/>
                    Date : <input id="date" type="date"/><br/>
                    Repetition : <input id="repeat" type="text"/><br/>
                    Frequence (jour) : <input id="frequence" type="number"/><br/>
                    <button onClick={() => this.addNotification()}>Créer</button>
                </div>
                <hr/>
                {this.state.notificationChannels.map(item => <div id={"card_" + item["id"]}><p>Nom : {item["name"]}<br/>Type : {item["type"]}<br/>Destination : {item["destination"]}<br/><button onClick={() => this.deleteNotificationChannel(item["id"])}>Supprimer</button></p></div>)}
                <hr/>
                <div>
                    Nom : <input id="name" type="text"/><br/>
                    Type : <input id="type" type="text"/><br/>
                    Destination : <input id="destination" type="text"/><br/>
                    <button onClick={() => this.addNotificationChannel()}>Créer</button>
                </div>
            </div>
        );
    }
}

export default Home;
