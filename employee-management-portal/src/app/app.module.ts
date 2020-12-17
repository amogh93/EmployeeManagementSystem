import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ManageEmployeeComponent } from './manage-employee/manage-employee.component';
import { ManageDepartmentComponent } from './manage-department/manage-department.component';
import { ManageLeaveComponent } from './manage-leave/manage-leave.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginComponent,
    DashboardComponent,
    ManageEmployeeComponent,
    ManageDepartmentComponent,
    ManageLeaveComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
