import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RestService } from '../rest.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userName: String;
  password: String;

  constructor(private restService:RestService,private router:Router) { }

  ngOnInit(): void {
  }

  doLogin(): void {
    let resp=this.restService.login(this.userName,this.password);
    resp.subscribe(data => {
      console.log(data);
      if(data === 'authenticated'){
        localStorage.setItem('authorization',btoa(this.userName+":"+this.password));
        this.router.navigate(["/dashboard"]);
      }
    });
  }

}
