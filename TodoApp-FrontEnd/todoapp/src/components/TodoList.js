import React from "react";

import "./css/todolist.css";
export default function TodoList() {
  return (
    <>
      <div className="header text-center">
        <h2>Todo App</h2>
        <button className="">Create Project</button>
      </div>
      <div className="project-container"></div>
    </>
  );
}
