import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuardService } from './auth.guard.service';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';
import { ManageDepartmentComponent } from './manage-department/manage-department.component';
import { ManageEmployeeComponent } from './manage-employee/manage-employee.component';
import { ManageLeaveComponent } from './manage-leave/manage-leave.component';

const routes: Routes=[
  {path:'login',component:LoginComponent},
  {path:'dashboard',component:DashboardComponent, canActivate: [AuthGuardService],children:[
    {path:'manageEmployee',component:ManageEmployeeComponent, canActivate: [AuthGuardService],outlet:'actionModule'},
    {path:'manageDepartment',component:ManageDepartmentComponent, canActivate: [AuthGuardService],outlet:'actionModule'},
    {path:'manageLeave',component:ManageLeaveComponent, canActivate: [AuthGuardService],outlet:'actionModule'}
  ]},
  {path:'',redirectTo:'/login',pathMatch:'full'}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports:[RouterModule]
})
export class AppRoutingModule { }
