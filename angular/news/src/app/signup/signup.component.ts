import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { SignupService } from '../signup.service';
import { LanguageService } from '../language.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private signupService: SignupService, private languageService: LanguageService) { }
  message: boolean;
  message1: boolean;
  successMessage: any;
  errorMessage: any;
  form = new FormGroup({
    name: new FormControl('', [Validators.required, Validators.minLength(2)]),
    email: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
    //confirmpassword: new FormControl('', Validators.required),
    language: new FormGroup({
      id: new FormControl('')
    })

    //confirmPassword: new FormControl,
  });

  languageList: any;
  ngOnInit() {
    this.languageService.getLanguage().subscribe(
      data => {
        this.languageList = data;
      })
  }


  status: any
  signupStatus: boolean;
  error;
  signup() {
    console.log(this.form.value);

    // console.log(this.form.value.email)
    this.signupService.signup(JSON.stringify(this.form.value)).subscribe(
      data => {
        this.status = data;
        //this.message=true;
        console.log(data);
        if (this.status.signupStatus == true) {
          this.message = true;
          this.message1 = this.status.signupStatus = false
          this.successMessage = this.status.message;
          console.log(this.successMessage)

        }
        else {
          this.message1 = this.status.signupStatus = true;
          this.message = false;
          this.errorMessage = this.status.message;
        }

      },
      error => {
        this.successMessage = "";
        this.errorMessage = "";
        this.error = true;
        this.error = error;


      })
    this.form.reset();

  }
}
