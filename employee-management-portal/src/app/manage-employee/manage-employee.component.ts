import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { RestService } from '../rest.service';

@Component({
  selector: 'app-manage-employee',
  templateUrl: './manage-employee.component.html',
  styleUrls: ['./manage-employee.component.css']
})
export class ManageEmployeeComponent implements OnInit {

  employee=new Employee(0,'','','','','','','','','','','M',{id:0},{id:0},{id:0});
  employees:any;
  departments:any;
  designations:any;
  update=false;
 
  constructor(private restService:RestService) { }

  ngOnInit(): void {
    this.reloadEmployees();
  }

  onSubmit(employeeId:number){
    console.log(JSON.stringify(this.employee));
    if(this.employee.manager.id === 0){
      delete this.employee.manager;
    }
    if(this.update){
      this.restService.updateEmployee(employeeId,JSON.stringify(this.employee)).subscribe(data => {
        console.log(data);
        this.reloadEmployees();
      });
    }else{
      this.restService.addEmployee(JSON.stringify(this.employee)).subscribe(data => {
        console.log(data);
        this.reloadEmployees();
      });
    }
  }

  onSelect(employeeId:number){
    console.log("On select");
    this.reloadDynamicData();
    this.update=true;
    this.restService.getEmployee(employeeId).subscribe(employee => {
      if(employee.manager == null)
      {
        employee.manager={
          id:0
        }
      }
      this.employee=employee;
    });
  }

  onReset(){
    this.employee=new Employee(0,'','','','','','','','','','','M',{id:0},{id:0},{id:0});
    this.update=false;
    this.reloadDynamicData();
  }

  reloadEmployees(){
    this.restService.getAllEmployees().subscribe(employees => this.employees=employees);
  }

  reloadDynamicData(){
    this.restService.getAllDepartments().subscribe(departments => this.departments=departments);
    this.restService.getAllDesignations().subscribe(designations => this.designations=designations);
  }
}
