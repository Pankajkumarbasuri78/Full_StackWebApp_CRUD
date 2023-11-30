import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "/node_modules/bootstrap/dist/js/bootstrap.min.js";
import Home from "./Home";
import StudentsView from "./component/student/StudentsView";
import NavBar from "./component/common/NavBar";
import { Routes, Route } from "react-router-dom";
import AddStudent from "./component/student/AddStudent";
import EditStudent from "./component/student/EditStudent";
import StudentProfile from "./component/student/StudentProfile";

function App() {
  return (
    <>
      <NavBar />

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/view-students" element={<StudentsView />} />
        <Route path="/add-students"element={<AddStudent/>}/>
        <Route path="/edit-student/:id" element={<EditStudent/>}/>
        <Route path="/student-profile/:id" element={<StudentProfile/>}/>
      </Routes>
    </>
  );
}

export default App;
