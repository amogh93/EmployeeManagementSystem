import { HttpErrorResponse } from '@angular/common/http';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { RestService } from '../rest.service';

@Component({
  selector: 'app-manage-leave',
  templateUrl: './manage-leave.component.html',
  styleUrls: ['./manage-leave.component.css']
})
export class ManageLeaveComponent implements OnInit {

  @ViewChild('closeBtn') closeBtn: ElementRef;
  leaveTypes=[{id:1,type:'CL'},{id:2,type:'SL'}];
  leaveRequests:any;
  leaveRequest={
    id:0,
    fromDate:'',
    toDate:'',
    reason:'',
    leaveType:1
  }
  error:String;

  constructor(private restService:RestService) { }

  ngOnInit(): void {
    this.reloadLeaveRequests();
  }

  onSubmit(){
    console.log(this.leaveRequest);
    this.restService.addLeaveRequest(JSON.stringify(this.leaveRequest)).subscribe(data => {
      console.log(data);
      if(data === 'success'){
        this.closeBtn.nativeElement.click();
        this.reloadLeaveRequests();
      }
    },(error: HttpErrorResponse) => {
      console.log(error);
      this.error=error.message;
  });
  }

  onReset(){
    this.error=null;
    this.leaveRequest={
      id:0,
      fromDate:'',
      toDate:'',
      reason:'',
      leaveType:1
    }
  }

  reloadLeaveRequests(){
    this.restService.getAllLeaveRequests().subscribe(leaveRequests => this.leaveRequests=leaveRequests);
  }

}
