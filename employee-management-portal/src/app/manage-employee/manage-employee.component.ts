import { HttpErrorResponse } from '@angular/common/http';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Employee } from '../employee';
import { RestService } from '../rest.service';

@Component({
  selector: 'app-manage-employee',
  templateUrl: './manage-employee.component.html',
  styleUrls: ['./manage-employee.component.css']
})
export class ManageEmployeeComponent implements OnInit {

  @ViewChild('closeBtn') closeBtn: ElementRef;
  employee=new Employee(0,'','','','','','','','','','','M',{id:0},{id:0},{id:0});
  employees:any;
  resignedEmployees:any;
  filteredReportingManager:any;
  departments:any;
  designations:any;
  update=false;
  error:String;
  processing=false;
 
  constructor(private restService:RestService) { }

  ngOnInit(): void {
    this.reloadEmployees();
  }

  onSubmit(employeeId:number){
    console.log(JSON.stringify(this.employee));
    this.processing=true;
    if(this.employee.manager.id === 0){
      delete this.employee.manager;
    }
    if(this.update){
      this.restService.updateEmployee(employeeId,JSON.stringify(this.employee)).subscribe(data => {
        console.log(data);
        if(data === 'success'){
          this.closeBtn.nativeElement.click();
          this.reloadEmployees();
        }
      },(error: HttpErrorResponse) => {
          console.log(error);
          this.error=error.message;
          this.processing=false;
      });
    }else{
      this.restService.addEmployee(JSON.stringify(this.employee)).subscribe(data => {
        console.log(data);
        if(data === 'success'){
          this.closeBtn.nativeElement.click();
          this.reloadEmployees();
        }
      },(error: HttpErrorResponse) => {
        console.log(error);
        this.error=error.message;
        this.processing=false;
    });
    }
  }

  onSelect(employeeId:number){
    console.log("On select");
    this.processing=false;
    this.error=null;
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
      this.filteredReportingManager=this.employees.filter(e => e.id != employee.id);
    });
  }

  onReset(){
    this.processing=false;
    this.error=null;
    this.employee=new Employee(0,'','','','','','','','','','','M',{id:0},{id:0},{id:0});
    this.update=false;
    this.filteredReportingManager=this.employees;
    this.reloadDynamicData();
  }

  reloadEmployees(){
    this.restService.getAllEmployees().subscribe(employees => {
      employees.filter(e => {
        if(e.manager == null){
          e.manager={
            id:0,
            firstName:'',
            lastName:''
          }
        }
      });
      this.employees=employees.filter(e => e.releivingDate == null);
      this.resignedEmployees=employees.filter(e => e.releivingDate != null);
      console.log("Res emp: "+this.resignedEmployees)
    });
  }

  reloadDynamicData(){
    this.restService.getAllDepartments().subscribe(departments => this.departments=departments);
    this.restService.getAllDesignations().subscribe(designations => this.designations=designations);
  }
}
