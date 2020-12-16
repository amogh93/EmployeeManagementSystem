import { Component, OnInit } from '@angular/core';
import { RestService } from '../rest.service';

@Component({
  selector: 'app-manage-department',
  templateUrl: './manage-department.component.html',
  styleUrls: ['./manage-department.component.css']
})
export class ManageDepartmentComponent implements OnInit {

  department={
    id:0,
    name:''
  }
  departments:any;
  update=false;

  constructor(private restService:RestService) { }

  ngOnInit(): void {
    this.reloadDepartments();
  }

  onSubmit(departmentId:number){
    console.log(JSON.stringify(this.department));
    if(this.update){
      this.restService.updateDepartment(departmentId,JSON.stringify(this.department)).subscribe(data => {
        console.log(data);
        this.reloadDepartments();
      });
    }else{
      this.restService.addDepartment(JSON.stringify(this.department)).subscribe(data => {
        console.log(data);
        this.reloadDepartments();
      });
    }
  }

  onSelect(departmentId:number){
    console.log("On select");
    this.update=true;
    this.restService.getDepartment(departmentId).subscribe(department => {
      this.department=department;
    });
  }

  onReset(){
    this.department={
      id:0,
      name:''
    }
    this.update=false;
  }

  reloadDepartments(){
    this.restService.getAllDepartments().subscribe(departments => this.departments=departments);
  }
}
