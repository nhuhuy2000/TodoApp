import "./App.css";

import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import TodoList from "./components/TodoList";
import Navbar from "./components/Navbar";
function App() {
  return (
    <div className="App">
      <Navbar></Navbar>
      <TodoList></TodoList>
    </div>
  );
}

export default App;
