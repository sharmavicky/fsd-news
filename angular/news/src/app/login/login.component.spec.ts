import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginComponent } from './login.component';
import { BrowserModule, By } from '@angular/platform-browser';
import { AppRoutingModule } from '../app-routing.module';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { APP_BASE_HREF } from '@angular/common';
import { LoginService } from '../login.service';
import { SignupComponent } from '../signup/signup.component';
import { Routes } from '@angular/router';
import { DebugElement } from '@angular/core';
import { HomepageComponent } from '../homepage/homepage.component';
import { AdminComponent } from '../admin/admin.component';
import { ArticleComponent } from '../article/article.component';
import { of } from 'rxjs';
import { AuthService } from '../auth.service';
import { CommandExecutor } from 'selenium-webdriver/safari';

fdescribe('LoginComponent', () => {
  
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  let de : DebugElement;
  let el : HTMLElement;
  let service : LoginService;
  let authService : AuthService;

  beforeEach(async(() => {
    const routes: Routes = [
      {path:"", component:LoginComponent},
      {path:"login", component:LoginComponent},
      {path:"signup", component:SignupComponent},
      {path:"home", component:HomepageComponent},
      {path:"admin", component:AdminComponent},
      {path:"article", component:ArticleComponent}

    ];
    TestBed.configureTestingModule({
      declarations: [LoginComponent, SignupComponent, HomepageComponent,AdminComponent,ArticleComponent],
      imports: [
        BrowserModule,
        AppRoutingModule,
        ReactiveFormsModule,
        HttpClientModule,
        FormsModule],
      providers: [{provide : APP_BASE_HREF  , useValue:'/'},
                    LoginService]
       
      
    }).compileComponents().then(() =>{
      fixture = TestBed.createComponent(LoginComponent);
      component = fixture.componentInstance;
       de = fixture.debugElement.query(By.css('form'));
      el = de.nativeElement;

    });
  }));


  it('should create', () => {
    expect(component).toBeTruthy();
  });

  

  it('form should invalid when empty',async(()=> {
    //accessing controls
    component.form.controls['email'].setValue('');
    component.form.controls['password'].setValue('');
    expect(component.form.valid).toBeFalsy();
  }));

  it('form should valid when filled',async(()=> {
    //accessing controls
    component.form.controls['email'].setValue('Vishal@gmail.com');
    component.form.controls['password'].setValue('123456789');
    expect(component.form.valid).toBeTruthy();
  }));

  it('form should invalid when Password length less than 6',async(()=> {
    //accessing controls
    //component.form.controls['email'].setValue('Vishal@gmail.com');
    component.form.controls['password'].setValue('1234');
    expect(component.form.valid).toBeFalsy();
  }));

  /*  it('authenticate funcation is called when login clicking on login button' ,async(()=> {
      fixture.detectChanges();
      spyOn(component, 'authenticate');
      el =fixture.debugElement.query(By.css('button')).nativeElement;
      el.click();
      expect(component.authenticate).toHaveBeenCalledTimes(1);
    }));   */
  
  it('should set user id for successfull login', async(()=>{
   authService=fixture.debugElement.injector.get(AuthService)
    service=fixture.debugElement.injector.get(LoginService);
    let data: any=JSON.parse(JSON.stringify({
      authenticated:true,
      user: {
        id:1,
        blacklist:false,
        language:{
          code:"en"} 
          
        }
    }))
    spyOn(service, 'authenticate').and.returnValue(of(data));
    //spyOn(authService, 'getUserId').and.returnValue(of(this.user.id));
    let id= authService.getUserId();
   // let code= authService.getLanguageCode();
    component.authenticate();
    expect(authService.languageCode).toBe("en");
    expect(authService.getLanguageCode()).toBe("en");
    expect(authService.id).toBe(1);
    expect(authService.blacklist).toBe(false)
  }));
});
