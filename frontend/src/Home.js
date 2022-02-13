import React from "react";
import {Button} from "react-bootstrap";
import PatientManager from "./components/PatientManager";
import './css/home.css'

class Home extends React.Component {
    render() {
        return <div>
            <Button className={"button-manager titleHeader patient"} name={"Patient"}>Patient Manager</Button>
            <Button className={"button-manager titleHeader user"} name={"User"}>User Manager </Button>
            <PatientManager active={"on"}>Patient manager</PatientManager>

            {/*<UserForm active={"off"}>User manager</UserForm>*/}
        </div>
    }
}
export default Home