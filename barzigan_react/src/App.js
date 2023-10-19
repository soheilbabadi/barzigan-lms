import logo from './logo.svg';
import './App.css';
import Button from './component/Button';
import Footer from './component/Footer';
import Navbar from './component/Navbar';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <Navbar/>
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          <Button onClick={() => console.log('clicked')}/>

        </a>
      </header>
<Footer/>
    </div>
  );
}

export default App;
