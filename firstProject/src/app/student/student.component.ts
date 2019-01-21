import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.scss']
})
export class StudentComponent implements OnInit {
  public students:String[]=['diya','shikha','shree'];
  newStudentName:String;
  constructor() { }
 
  ngOnInit() {
  }
  addStudent():void{
    this.students.push( this.newStudentName);
    this.newStudentName='';
  }
  removeStudent():void{
    let index = this.students.indexOf(this.newStudentName);
    this.newStudentName='';
        this.students.splice(index,1);
    
    
    
  }
}
