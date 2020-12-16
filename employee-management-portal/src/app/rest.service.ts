import { Injectable } from "@angular/core";
import { HttpClient,HttpHeaders } from '@angular/common/http'
import { Observable } from "rxjs";

@Injectable({
    providedIn:'root'
})
export class RestService{

    constructor(private http: HttpClient){}

    public login(userName: String,password: String): Observable<String>{
        const headers=new HttpHeaders({Authorization: 'Basic '+btoa(userName+":"+password)});
        return this.http.get<String>("http://localhost:8080",{headers,responseType:'text' as 'json'});
    }

    public addEmployee(data:String): Observable<String>{
        const headers = { 'content-type': 'application/json'};
        return this.http.post<String>("http://localhost:8080/api/v1/employee",data,{headers,responseType:'text' as 'json'});
    }

    public updateEmployee(employeeId:number,data:String): Observable<String>{
        const headers = { 'content-type': 'application/json'};
        return this.http.put<String>("http://localhost:8080/api/v1/employee/"+employeeId,data,{headers,responseType:'text' as 'json'});
    }

    public getAllEmployees(): Observable<any>{
        return this.http.get<any>("http://localhost:8080/api/v1/employee");
    }

    public getEmployee(employeeId:number): Observable<any>{
        return this.http.get<any>("http://localhost:8080/api/v1/employee/"+employeeId);
    }

    public addDepartment(data:String): Observable<String>{
        const headers = { 'content-type': 'application/json'};
        return this.http.post<String>("http://localhost:8080/api/v1/department",data,{headers,responseType:'text' as 'json'});
    }

    public getAllDepartments(): Observable<any>{
        return this.http.get<any>("http://localhost:8080/api/v1/department");
    }

    public getDepartment(departmentId:number): Observable<any>{
        return this.http.get<any>("http://localhost:8080/api/v1/department/"+departmentId);
    }

    public updateDepartment(departmentId:number,data:String): Observable<String>{
        const headers = { 'content-type': 'application/json'};
        return this.http.put<String>("http://localhost:8080/api/v1/department/"+departmentId,data,{headers,responseType:'text' as 'json'});
    }

    public getAllDesignations(): Observable<any>{
        return this.http.get<any>("http://localhost:8080/api/v1/designation");
    }
}