import React, { Component } from 'react'
import ProjectItem from './Project/ProjectItem'

export default class Dashboard extends Component {
  render() {
    return (
        <>
      <div className="alert alert-success">Welcome to Dashboard</div>
        <ProjectItem></ProjectItem>
      </>
    )
  }
}
