import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuardService } from './auth.guard.service';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';
import { ManageEmployeeComponent } from './manage-employee/manage-employee.component';

const routes: Routes=[
  {path:'login',component:LoginComponent},
  {path:'dashboard',component:DashboardComponent, canActivate: [AuthGuardService]},
  {path:'onboarding',component:ManageEmployeeComponent, canActivate: [AuthGuardService]},
  {path:'',redirectTo:'/login',pathMatch:'full'}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports:[RouterModule]
})
export class AppRoutingModule { }
