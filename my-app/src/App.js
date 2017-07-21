import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Label from './components/label/Label'
import Button from './components/button/Button'
import LinkButton from './components/linkButton/LinkButton'
import TexBox from './components/textBox/TextBox'
import Form from './components/form/Form'
import List from './components/lista/List'

class App extends Component {
 
  constructor(){
    super();
    this.state = {
      message: "ainda não fui clicado",
      texto: "t"
    }
    this.saveOnClick = this.saveOnClick.bind(this);
    this.cancelOnClick = this.cancelOnClick.bind(this);
    this.editOnClick = this.editOnClick.bind(this);
    this.onEditorChange = this.onEditorChange.bind(this);
  }
  onEditorChange(value){
    console.log(value)
          this.setState({
          texto :value
      })
  }
  editOnClick(){
  this.setState({
        message : "Editar clicado"
      })
  }
  saveOnClick(){
    this.setState({
      message : "Salvar clicado"
    })
  }
  cancelOnClick(){
    this.setState({
      message : "Cancelar clicado"
    })
  }

  render() {
    return (
      <div className="App">
        <div className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          
          <p>
            <Label types="title">
              Bem Vindo 
            </Label>
            <Label types="regular">
              Esta é minha primeira aplicação 
            </Label>
          </p>
          <div>{this.state.texto} {this.state.message}</div>
          <Button caption="Salvar" types="info" onClick={this.saveOnClick}></Button>          
          <Button.cancel caption="Cancelar" types="danger" onClick={this.cancelOnClick}></Button.cancel>
          <LinkButton  caption="Editar" onClick={this.editOnClick} ></LinkButton>
          
          <TexBox name={this.state.texto} onChange={this.onEditorChange}></TexBox>
          
          
          
        </div>
        
      </div>
    );
  }
}

export default App;
