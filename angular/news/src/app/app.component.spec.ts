import { TestBed, async } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { SignupComponent } from './signup/signup.component';
import { HomepageComponent } from './homepage/homepage.component';
import { AdminComponent } from './admin/admin.component';
import { ArticleComponent } from './article/article.component';
import { LoginComponent } from './login/login.component';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { APP_BASE_HREF } from '@angular/common';
import { Routes } from '@angular/router';

fdescribe('AppComponent', () => {
  beforeEach(async(() => {
    const routes: Routes = [
      {path:"", component:LoginComponent},
      {path:"login", component:LoginComponent},
      {path:"signup", component:SignupComponent},
      {path:"home", component:HomepageComponent},
      {path:"admin", component:AdminComponent},
      {path:"article", component:ArticleComponent},
      ];
    TestBed.configureTestingModule({
      declarations: [
        AppComponent,
        HeaderComponent,
        SignupComponent,
        LoginComponent,
        HomepageComponent,
        AdminComponent,
        ArticleComponent
      ],
      imports: [
        BrowserModule,
        AppRoutingModule,
      ReactiveFormsModule,
        HttpClientModule,
        FormsModule
      ],
      providers: [
        {provide : APP_BASE_HREF  , useValue:'/'}
      ]
    }).compileComponents();
  }));

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'news'`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.title).toEqual('news');
  });


});
