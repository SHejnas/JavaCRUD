import React, {Component} from 'react';
import {Checkbox,} from '@material-ui/core';
import logo from './logo.svg';
import axios from 'axios';
import './App.css';





class App extends Component {
  state = {
    isLoading: true,
    toDos: []
  };

  async componentDidMount() {
    let api = 'http://localhost:8080/todo/all';
    let response = await axios.get(api);
    this.setState({ toDos: response.data.toDoList, isLoading: false });
  };
 async updateFunc(id) {
    let toDoState = this.state.toDos;
    let api = `http://localhost:8080/todo/${id}`
    await axios.put(api);
    toDoState.forEach(todo => {
      if(id == todo.id){
        todo.completed = !todo.completed
      }
    });
    
    this.setState({ToDos: toDoState, isLoading: false });
  };

  render() {
    const {toDos, isLoading} = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }

  return (
    <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <div className="App-intro">
           <p>
             Simple ToDo app, created with Spring Boot and React
           </p>
            
          </div>
        </header>
        
        <h1>Active ToDos:</h1>
          <div className ="ToDos">
              {toDos.map(toDo =>
                <div key={toDo.id}>
                  <div className="ToDo">
                  <h2>{toDo.taskTitle}</h2>
                    <h3>Status: <Checkbox
                    checked={toDo.completed}
                    onChange={()=>{this.updateFunc(toDo.id)}}
                      color="default"
                      size="medium"/>
                    </h3>
                  <h5>{toDo.taskDescription}</h5>
                  
                  </div>
                </div>
              )}
          </div>
        
      </div>

  );
}

}

export default App;
