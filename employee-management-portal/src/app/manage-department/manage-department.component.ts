import { HttpErrorResponse } from '@angular/common/http';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { RestService } from '../rest.service';

@Component({
  selector: 'app-manage-department',
  templateUrl: './manage-department.component.html',
  styleUrls: ['./manage-department.component.css']
})
export class ManageDepartmentComponent implements OnInit {

  @ViewChild('closeBtn') closeBtn: ElementRef;

  department={
    id:0,
    name:''
  }
  departments:any;
  update=false;
  error:String;
  processing=false;

  constructor(private restService:RestService) { }

  ngOnInit(): void {
    this.reloadDepartments();
  }

  onSubmit(departmentId:number){
    console.log(JSON.stringify(this.department));
    this.processing=true;
    if(this.update){
      this.restService.updateDepartment(departmentId,JSON.stringify(this.department)).subscribe(data => {
        console.log(data);
        if(data === 'success'){
          this.processing=false;
          this.closeBtn.nativeElement.click();
          this.reloadDepartments(); 
        }
      },(error: HttpErrorResponse) => {
        console.log(error);
        this.error=error.message;
        this.processing=false;
    });
    }else{
      this.restService.addDepartment(JSON.stringify(this.department)).subscribe(data => {
        console.log(data);
        if(data === 'success'){
          this.processing=false;
          this.closeBtn.nativeElement.click();
          this.reloadDepartments();
        }
      },(error: HttpErrorResponse) => {
        console.log(error);
        this.error=error.message;
        this.processing=false;
    });
    }
  }

  onSelect(departmentId:number){
    console.log("On select");
    this.processing=false;
    this.update=true;
    this.restService.getDepartment(departmentId).subscribe(department => {
      this.department=department;
    });
  }

  onReset(){
    this.processing=false;
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
