import React, {useState} from "react";
import '../css/login.css'
import '../App.css'
import {useHistory} from "react-router-dom";
import UserService from "../services/UserService";

const Login = ({loading, ...props}) => {
    const [error, setError] = useState();
    const [show, setShow] = useState(true);
    const initialState = {
        username: "",
        password: "",
    };
    const [user, setUser] = useState(initialState);
    const credentialChange = (event) => {
        const {name, value} = event.target;
        setUser({...user, [name]: value});
    };

    let history = useHistory();

    const validateUser = () => {
        UserService.doLogin(user)
            .then(response => {
                if (response.data.result  === 1) {
                    console.log(response.data);
                    history.push("/home");
                }
                else {
                    console.log(response.data.message);
                    console.log(response.data.result);
                    setShow(true);
                    setError("Invalid user and password");
                }
            })
            .catch((error) => {
                setShow(true);
                setError(error.message);
            });
    };

    return (
        <div className="App">
            <div>{show && props.message && (
                <p onClose={() => setShow(false)}>
                    {props.message}
                </p>
            )}
                {show && error && (
                    <p onClose={() => setShow(false)}>
                        {error}
                    </p>
                )}</div>
            <header className="App-header">
                <div className={"form"} onChange={credentialChange}>
                    <h3>Login to system</h3>
                    <div className="container">
                        <div className={"label"}>Username:
                            <input type="text" name="username" required/>
                        </div>
                        <div className={"label"}>Password:
                            <input type="password" name="password" required/>
                            <button onClick={validateUser}>Login</button>
                        </div>
                    </div>
                </div>
            </header>
        </div>
    );
}

export default Login;
