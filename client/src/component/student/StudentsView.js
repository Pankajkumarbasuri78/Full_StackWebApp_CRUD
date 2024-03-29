import React, { useEffect, useState } from "react";
import axios from "axios";
import { MdDelete } from "react-icons/md";
import { FaEdit } from "react-icons/fa";
import { FaEye } from "react-icons/fa";
import { Link } from "react-router-dom";

const StudentsView = () => {
  const [students, setStudents] = useState([]);

  useEffect(() => {
    loadStudents();
    console.log("1st call");
  }, []);

  const loadStudents = async () => {
    const result = await axios.get(
      "http://localhost:8080/students/getStudents"
    );

    //console.log(result.data);
    setStudents(result.data);
  };

  /**Fetch api call */
  // const loadStudents = async() => {
  //     try {
  //         const res = await fetch("http://localhost:8080/students/getStudents");

  //         const result =await res.json();
  //         console.log(result);
  //         setStudents(result);
  //     } catch (error) {
  //         console.error('Error fetching data:', error);
  //     }
  // }

  const handleDelete = async (id) => {
		await axios.delete(
			`http://localhost:8080/students/deleteStudent/${id}`
		);
		loadStudents();
	};

  return (
    <section>
      <table className="table table-bordered table-hover shadow">
        <thead>
          <tr className="text-center">
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Department</th>
            <th colSpan="3">Actions</th>
          </tr>
        </thead>
        <tbody className="text-center">
          {students.map((student, index) => (
            <tr key={student.id}>
              <th scope="row" key={index}>
                {index + 1}
              </th>

              <td>{student.firstName}</td>
              <td>{student.lastName}</td>
              <td>{student.email}</td>
              <td>{student.department}</td>
              <td className="mx-2">
                <Link
                  to={`/student-profile/${student.id}`}
                  className="btn btn-info"
                >
                  <FaEye />
                </Link>
              </td>
              <td className="mx-2">
                <Link
                  to={`/edit-student/${student.id}`}
                  className="btn btn-warning"
                >
                  <FaEdit />
                </Link>
              </td>
              <td className="mx-2">
                <button 
                  className="btn btn-danger"
                  onClick={()=>handleDelete(student.id)}
                  >
                  <MdDelete />
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </section>
  );
};

export default StudentsView;
