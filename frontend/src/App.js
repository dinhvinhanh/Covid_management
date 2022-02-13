import './App.css';
import {BrowserRouter as Router, Route} from 'react-router-dom'
import Home from "./Home";
import Login from "./components/Login";

function App() {
    return (
        <div>
            <Router>
                <Route exact path={"/"} component={Login}></Route>
                <Route exact path={"/home"} component={Home}></Route>
            </Router>
        </div>
    );
}

export default App;
