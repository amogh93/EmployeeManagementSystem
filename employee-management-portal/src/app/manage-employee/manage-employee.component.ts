import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { RestService } from '../rest.service';

@Component({
  selector: 'app-manage-employee',
  templateUrl: './manage-employee.component.html',
  styleUrls: ['./manage-employee.component.css']
})
export class ManageEmployeeComponent implements OnInit {

  employee=new Employee('','','','','','','','','','M');

  constructor(private restService:RestService) { }

  ngOnInit(): void {
  }

  onSubmit(){
    console.log(JSON.stringify(this.employee));
    this.restService.addEmployee(JSON.stringify(this.employee)).subscribe(data => console.log(data));
  }
}
