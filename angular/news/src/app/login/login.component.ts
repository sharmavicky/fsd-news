import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { LoginService } from '../login.service';
import { Observable } from 'rxjs';
import { AuthService } from '../auth.service';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private loginService: LoginService, private service: AuthService, private router: Router) { }

  ngOnInit() {
  }
errorMessage:any;
//message;
  form = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.maxLength(255) ]),
    password: new FormControl('', [Validators.required, Validators.minLength(6)])

  });
  error: any;
  authenticate() {
    this.loginService.authenticate(JSON.stringify(this.form.value)).subscribe(
      data => {
        console.log(JSON.stringify(this.form.value));
        console.log("authenticate")
        if (data.authenticated) {
          this.service.login();
          //this.service.setRole(data.user.role.name);
          //this.service.setLanguage(data.user.language.name);
          console.log(data.user.id);
          this.service.setUserId(data.user.id);
          this.service.setSetStatus(data.user.blacklist);
          this.service.setLanguageCode(data.user.language.code);
          // console.log(data.user.language.name);
          console.log(data.user.language.code);
          this.router.navigate(['/home']);
        }
        if (data.admin) {
          this.service.login();
          this.router.navigate(['/admin']);
        }

        if(!data.authenticated){
         // this.message=true;
          //this.errorMessage=data.message;
          console.log(this.errorMessage)

        }
      },
     
      error => {
        error = true;
        this.error = error;
      });
    this.form.reset();
  }
}
