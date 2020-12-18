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
        const auth=localStorage.getItem('authorization');
        const headers = { 'content-type': 'application/json','Authorization':'Basic '+auth};
        return this.http.post<String>("http://localhost:8080/api/v1/employee",data,{headers,responseType:'text' as 'json'});
    }

    public updateEmployee(employeeId:number,data:String): Observable<String>{
        const auth=localStorage.getItem('authorization');
        const headers = { 'content-type': 'application/json','Authorization':'Basic '+auth};
        return this.http.put<String>("http://localhost:8080/api/v1/employee/"+employeeId,data,{headers,responseType:'text' as 'json'});
    }

    public getAllEmployees(): Observable<any>{
        const auth=localStorage.getItem('authorization');
        const headers=new HttpHeaders({Authorization: 'Basic '+auth});
        return this.http.get<any>("http://localhost:8080/api/v1/employee",{headers});
    }

    public getEmployee(employeeId:number): Observable<any>{
        const auth=localStorage.getItem('authorization');
        const headers=new HttpHeaders({Authorization: 'Basic '+auth});
        return this.http.get<any>("http://localhost:8080/api/v1/employee/"+employeeId,{headers});
    }

    public addDepartment(data:String): Observable<String>{
        const auth=localStorage.getItem('authorization');
        const headers = { 'content-type': 'application/json','Authorization':'Basic '+auth};
        return this.http.post<String>("http://localhost:8080/api/v1/department",data,{headers,responseType:'text' as 'json'});
    }

    public getAllDepartments(): Observable<any>{
        const auth=localStorage.getItem('authorization');
        const headers=new HttpHeaders({Authorization: 'Basic '+auth});
        return this.http.get<any>("http://localhost:8080/api/v1/department",{headers});
    }

    public getDepartment(departmentId:number): Observable<any>{
        const auth=localStorage.getItem('authorization');
        const headers=new HttpHeaders({Authorization: 'Basic '+auth});
        return this.http.get<any>("http://localhost:8080/api/v1/department/"+departmentId,{headers});
    }

    public updateDepartment(departmentId:number,data:String): Observable<String>{
        const auth=localStorage.getItem('authorization');
        const headers = { 'content-type': 'application/json','Authorization':'Basic '+auth};
        return this.http.put<String>("http://localhost:8080/api/v1/department/"+departmentId,data,{headers,responseType:'text' as 'json'});
    }

    public getAllDesignations(): Observable<any>{
        const auth=localStorage.getItem('authorization');
        const headers=new HttpHeaders({Authorization: 'Basic '+auth});
        return this.http.get<any>("http://localhost:8080/api/v1/designation",{headers});
    }

    public addLeaveRequest(data:String): Observable<String>{
        const auth=localStorage.getItem('authorization');
        const headers = { 'content-type': 'application/json','Authorization':'Basic '+auth};
        return this.http.post<String>("http://localhost:8080/api/v1/leave",data,{headers,responseType:'text' as 'json'});
    }

    public getAllLeaveRequests(): Observable<any>{
        const auth=localStorage.getItem('authorization');
        const headers=new HttpHeaders({Authorization: 'Basic '+auth});
        return this.http.get<any>("http://localhost:8080/api/v1/leave",{headers});
    }
}