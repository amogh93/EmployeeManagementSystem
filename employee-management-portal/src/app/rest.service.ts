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
}