import logo from '../../logo.svg';
import './App.css';
import React, {Component} from 'react';
import '../../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import Home from "../Home/Home";
import EShopService from "../../repository/eShopRepository";

class App extends Component {

  constructor(props) {
    super(props);
    this.state = {
      events : null,
      organisers : null
    }
  }
  render()
  {
    return (
        <Home items={this.state.events} />
    );
  }

  componentDidMount() {
    this.loadEvents();
  }

  loadEvents = () => {
    EShopService.fetchUpcomingEvents()
        .then((data) => {
            this.setState({
              events: data.data
            })
        });
  }
}

export default App;
