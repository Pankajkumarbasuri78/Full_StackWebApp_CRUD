import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "/node_modules/bootstrap/dist/js/bootstrap.min.js";
import Home from "./Home";
import StudentsView from "./component/student/StudentsView";

function App() {
  return (
    <div>
     <h1>hello</h1>
     <Home />
     <StudentsView/>
    </div>
  );
}

export default App;
