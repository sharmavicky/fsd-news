import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SignupComponent } from './signup.component';
import { SignupService } from '../signup.service';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from '../app-routing.module';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { APP_BASE_HREF } from '@angular/common';
import { LoginComponent } from '../login/login.component';
import { HomepageComponent } from '../homepage/homepage.component';
import { AdminComponent } from '../admin/admin.component';
import { ArticleComponent } from '../article/article.component';
import { of } from 'rxjs';
import { LanguageService } from '../language.service';

fdescribe('SignupComponent', () => {
  let component: SignupComponent;
  let fixture: ComponentFixture<SignupComponent>;

  let service : SignupService;
  let language: LanguageService;
  

  beforeEach(async(() => {
    TestBed.configureTestingModule({

    
      declarations: [ SignupComponent, LoginComponent , HomepageComponent, AdminComponent, ArticleComponent],
      imports: [
        BrowserModule,
        AppRoutingModule,
        ReactiveFormsModule,
        HttpClientModule,
        FormsModule],
      providers: [{provide : APP_BASE_HREF  , useValue:'/'},
                    SignupService]
       
    })
    .compileComponents().then(()=>{
      fixture = TestBed.createComponent(SignupComponent);
       component = fixture.componentInstance;
    });
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SignupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  /* it('should create', () => {
    expect(component).toBeTruthy();
  }); */

  it('should call signup method', async()=>{
    service= fixture.debugElement.injector.get(SignupService)
     let data : any = JSON.parse(JSON.stringify({
      signupStatus:true
    })) 
    
    spyOn(service, 'signup').and.returnValue(of(data));
    component.signup();
  //(data.signupStatus).toBe(true)
  expect(component.message).toBe(true);

  })


  it('should get language when getLanguage method', async()=>{
  language  = fixture.debugElement.injector.get(LanguageService);
  let data:any 
  })
});
